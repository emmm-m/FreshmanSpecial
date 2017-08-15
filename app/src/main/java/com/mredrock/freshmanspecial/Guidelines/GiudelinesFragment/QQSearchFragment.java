package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.content.Context;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.Beans.QQGroupsBean;
import com.mredrock.freshmanspecial.Beans.QQResultBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyRecyclerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;
import com.mredrock.freshmanspecial.model.HttpModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import rx.Subscriber;

public class QQSearchFragment extends BaseFragment {
    private EditText editText;
    private ImageView clear;
    private QQGroupsBean bean;
    private QQGroupsBean.DataBean data;
    private List<QQResultBean.DataBean> result;
    private RecyclerView resultList;
    private TextView back;

    @Override
    protected void initData() {
        editText = $(R.id.edit_search_qq);
        clear = $(R.id.edit_clear_qq);
        resultList = $(R.id.list_qq_result);
        back = $(R.id.cancel_search);
        data = new QQGroupsBean.DataBean();
        result = new ArrayList<>();
        bean = new QQGroupsBean();
        setFocus();
        getData();
        setSearch();
        setClear();
        setCancel();
    }

    private void setFocus() {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() //保证界面的数据加载完成再跳出键盘
                       {
                           public void run() {
                               InputMethodManager inputManager =
                                       (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                               inputManager.showSoftInput(editText, 0);
                           }
                       },
                200);
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_qqsearch;
    }

    private void getData() {
        HttpModel.bulid().getQQGroups(new Subscriber<QQGroupsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("ppp", "onError: "+e.toString());
                Toast.makeText(getActivity(), "获取数据失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(QQGroupsBean qqGroupsBean) {
                bean = qqGroupsBean;
            }
        });
    }

    private void setList() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        resultList.setLayoutManager(manager);
        resultList.setAdapter(new MyRecyclerAdapter(getActivity(), result, MyRecyclerAdapter.QQGROUP));
    }

    private void setCancel() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.qq_layout, new QQgroupFragment());
                transaction.commit();
            }
        });
    }

    private void setClear() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
    }

    private void setSearch() {
        editText.setOnKeyListener(new View.OnKeyListener() {//输入完后按键盘上的搜索键【回车键改为了搜索键】

            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER) {//修改回车键功能
                    ((InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(getActivity().getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;
                }
                return false;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data = bean.getData();
                List<QQGroupsBean.DataBean.CollegeBean> colleges = data.getCollege();
                List<QQGroupsBean.DataBean.HomelandBean> homelands = data.getHomeland();
                String obj = editText.getText().toString();
                result.clear();
                for (QQGroupsBean.DataBean.CollegeBean b : colleges) {
                    if (b.getGroupName().contains(obj) || b.getNumber().contains(obj)) {
                        QQResultBean.DataBean data = new QQResultBean.DataBean();
                        data.setGroupName(b.getGroupName());
                        data.setNumber(b.getNumber());
                        result.add(data);
                    }
                }
                for (QQGroupsBean.DataBean.HomelandBean b : homelands) {
                    if (b.getGroupName().contains(obj) || b.getNumber().contains(obj)) {
                        QQResultBean.DataBean data = new QQResultBean.DataBean();
                        data.setGroupName(b.getGroupName());
                        data.setNumber(b.getNumber());
                        result.add(data);
                    }
                }
                setList();

            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    InputMethodManager imm = (InputMethodManager) view.getContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }
}
