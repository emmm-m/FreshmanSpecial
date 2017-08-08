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
        ExcellentBean bean = new ExcellentBean();
        bean.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean.setName("丛广林");
        bean.setContent("颁奖词：重邮小帮手背后的技术好能手，用创意传递团思党意；红岩网校里辛勤的代码探索者，用产品激活青春正能量。用原创游戏贴近同学，建专题网站打造主流，带技能培训熔炼团队，抓宣传跟帖清朗网络。他就是将实践服务融入网络的社会主义核心价值观传播者。\n" +
                "\n" +
                "——e路有你，书写无悔青春");
        list.add(bean);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(), list, MyRecyclerAdapter.TEACHER));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_teacher;
    }
}
