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

public class StudentFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private List<ExcellentBean> list;

    @Override
    protected void initData() {
        recyclerView = $(R.id.list_student);
        manager = new GridLayoutManager(getActivity(), 1);
        list = new ArrayList<>();
        setData();

    }

    private void setData() {
        ExcellentBean student1 = new ExcellentBean();
        student1.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student1.setName("丛广林");
        student1.setContent("颁奖词：重邮小帮手背后的技术好能手，用创意传递团思党意；红岩网校里辛勤的代码探索者，用产品激活青春正能量。用原创游戏贴近同学，建专题网站打造主流，带技能培训熔炼团队，抓宣传跟帖清朗网络。他就是将实践服务融入网络的社会主义核心价值观传播者。\n" +
                "\n" +
                "——e路有你，书写无悔青春");
        list.add(student1);
        ExcellentBean student2 = new ExcellentBean();
        student2.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student2.setName("郭鑫");
        student2.setContent("颁奖词：他是创趣异站创始人，重庆森蓝戈科技有限公司总经理，VIPC创业团队组建者。创业路上他一度艰难前行，蹲马路，参路演，拉投资，无所畏惧。创业艰辛也不忘反哺母校，带领百余学弟学妹踏上“双创”征程。他的先进事迹荣登《光明日报》，他就是以创新创造价值的重邮创客。\n" +
                "\n" +
                "——创新是为了产生实际价值");
        list.add(student2);
        ExcellentBean student3 = new ExcellentBean();
        student3.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student3.setName("匡俊嘉");
        student3.setContent("颁奖词：两次国家奖学金、学业绩点3.8、必修课平均分91.1分是她三年学业的骄人成绩；美国数模竞赛特等奖（最高奖）、全国英语竞赛特等奖等6项省部级以上奖项，是她课外竞赛的累累硕果；50余小时的“云互助”朋辈辅导授课，共同进步的寝室氛围营造，是她乐于奉献的真实写照。她是一个求真知、重实践、讲奉献，努力筑梦青春的全能学子。\n" +
                "\n" +
                "——全面发展行路远，心底无私天地宽");
        list.add(student3);
        ExcellentBean student4 = new ExcellentBean();
        student4.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student4.setName("丛广林");
        student4.setContent("颁奖词：重邮小帮手背后的技术好能手，用创意传递团思党意；红岩网校里辛勤的代码探索者，用产品激活青春正能量。用原创游戏贴近同学，建专题网站打造主流，带技能培训熔炼团队，抓宣传跟帖清朗网络。他就是将实践服务融入网络的社会主义核心价值观传播者。\n" +
                "\n" +
                "——e路有你，书写无悔青春");
        list.add(student4);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(), list, MyRecyclerAdapter.STUDENT));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_student;
    }
}
