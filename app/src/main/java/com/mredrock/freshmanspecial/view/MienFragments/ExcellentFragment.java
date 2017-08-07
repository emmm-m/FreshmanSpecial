package com.mredrock.freshmanspecial.view.MienFragments;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.freshmanspecial.Beans.MienBeans.ExcellentBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyRecyclerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxzhu on 2017/8/4.
 */

public class ExcellentFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private ExcellentBean bean = new ExcellentBean();
    private List<ExcellentBean> list;
    @Override
    protected void initData() {
        recyclerView = $(R.id.list_excellent);
        manager = new GridLayoutManager(getActivity(), 1);
        list = new ArrayList<>();
        setData();

    }

    private void setData(){
        bean.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean.setName("朱展萱");
        bean.setContent("就是他就是他就是他就是他就是他就是他就是他就是他就是他就是他就是他就是他就是他就是他" +
                "就是他就是他就是他就是他就就是他就是他就是他就是他就是他就是他就是他就是他就是他就是他是他就是他");
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(),list,MyRecyclerAdapter.EXCELLENT));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_excellent;
    }
}
