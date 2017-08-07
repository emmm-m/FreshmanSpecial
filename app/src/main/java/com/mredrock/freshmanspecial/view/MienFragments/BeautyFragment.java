package com.mredrock.freshmanspecial.view.MienFragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.freshmanspecial.Beans.MienBeans.BeautyBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyRecyclerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxzhu on 2017/8/4.
 */

public class BeautyFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private BeautyBean bean = new BeautyBean();
    private List<BeautyBean> list;
    @Override
    protected void initData() {
        recyclerView = $(R.id.list_beauty);
        manager = new GridLayoutManager(getActivity(), 1);
        list = new ArrayList<>();
        setData();
    }

    private void setData(){
        bean.setImg(getResources().getDrawable(R.mipmap.ic_launcher));
        bean.setTitle("中心食堂");
        bean.setContent("菜品多，好吃，便宜，环境一流，服务好,菜品多，好吃，便宜，环境一流，服务好，卫生菜品多，好吃，便宜，环境一流，服务好，卫生菜品多，好吃，便宜，环境一流，服务好，卫生," +
                "菜品多，好吃，便宜，环境一流，服务好，卫生菜品多，好吃，便宜，环境一流，服务好，卫生,卫生,菜品多，好吃，便宜，环境一流，服务好，卫生");
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(),list,MyRecyclerAdapter.BEAUTY));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_beauty;
    }
}
