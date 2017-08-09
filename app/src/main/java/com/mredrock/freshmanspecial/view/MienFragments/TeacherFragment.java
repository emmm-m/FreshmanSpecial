package com.mredrock.freshmanspecial.view.MienFragments;

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
 * Created by zxzhu on 2017/8/8.
 */

public class TeacherFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private List<ExcellentBean> list;

    @Override
    protected void initData() {
        recyclerView = $(R.id.list_teacher);
        manager = new GridLayoutManager(getActivity(), 1);
        list = new ArrayList<>();
        setData();

    }

    private void setData() {
        ExcellentBean bean1 = new ExcellentBean();
        bean1.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean1.setName("陈痒痒");
        list.add(bean1);
        ExcellentBean bean2 = new ExcellentBean();
        bean2.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean2.setName("付蔚");
        list.add(bean2);
        ExcellentBean bean3 = new ExcellentBean();
        bean3.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean3.setName("高冬");
        list.add(bean3);
        ExcellentBean bean4 = new ExcellentBean();
        bean4.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean4.setName("高非");
        list.add(bean4);
        ExcellentBean bean5 = new ExcellentBean();
        bean5.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean5.setName("胡庆");
        list.add(bean5);
        ExcellentBean bean6 = new ExcellentBean();
        bean6.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean6.setName("蒋青");
        list.add(bean6);
        ExcellentBean bean7 = new ExcellentBean();
        bean7.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean7.setName("罗元");
        list.add(bean7);
        ExcellentBean bean8 = new ExcellentBean();
        bean8.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean8.setName("闵绪国");
        list.add(bean8);
        ExcellentBean bean9 = new ExcellentBean();
        bean9.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean9.setName("彭语良");
        list.add(bean9);
        ExcellentBean bean10 = new ExcellentBean();
        bean10.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean10.setName("漆晶");
        list.add(bean10);
        ExcellentBean bean11 = new ExcellentBean();
        bean11.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean11.setName("王睿");
        list.add(bean11);
        ExcellentBean bean12 = new ExcellentBean();
        bean12.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean12.setName("王樱桃");
        list.add(bean12);
        ExcellentBean bean13 = new ExcellentBean();
        bean13.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean13.setName("熊安萍");
        list.add(bean13);
        ExcellentBean bean14 = new ExcellentBean();
        bean14.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean14.setName("袁帅");
        list.add(bean14);
        ExcellentBean bean15 = new ExcellentBean();
        bean15.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean15.setName("张清华");
        list.add(bean15);
        ExcellentBean bean16 = new ExcellentBean();
        bean16.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean16.setName("张琬悦");
        list.add(bean16);
        ExcellentBean bean17 = new ExcellentBean();
        bean17.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean17.setName("郑继明");
        list.add(bean17);
        ExcellentBean bean18 = new ExcellentBean();
        bean18.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean18.setName("周兴茂");
        list.add(bean18);
        ExcellentBean bean19 = new ExcellentBean();
        bean19.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean19.setName("朱伟");
        list.add(bean19);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(), list, MyRecyclerAdapter.TEACHER));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_teacher;
    }
}
