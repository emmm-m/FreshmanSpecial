package com.mredrock.freshmanspecial.view.MienFragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.Beans.MienBeans.BeautyBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.ExcellentBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.TeacherBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyRecyclerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;
import com.mredrock.freshmanspecial.model.HttpModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by zxzhu on 2017/8/8.
 */

public class TeacherFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private List<TeacherBean.DataBean> list;

    @Override
    protected void initData() {
        recyclerView = $(R.id.list_teacher);
        list = new ArrayList<>();
        setData();

    }

    private void setData() {
        LinearLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(manager);
        HttpModel.bulid().getTeachers(new Subscriber<TeacherBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getActivity(),"获取数据失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(TeacherBean teacherBean) {
                list = teacherBean.getData();
                recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(), list, MyRecyclerAdapter.TEACHER));
            }
        });
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_teacher;
    }
}
