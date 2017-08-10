package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.Beans.AdmissionBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-校园环境
 */

public class CampusEnvironmentFragment extends Fragment{
    private List<AdmissionBean> admissionBeanList;
    private RecyclerView recyclerView;
    private VerticalRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_environment, container, false);
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.environment_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new VerticalRecyclerAdapter(admissionBeanList, view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void initData() {
        admissionBeanList = new ArrayList<>();
        addCompusEnvironment("鸟瞰重邮", "站在腾飞广场，做着属于我们的腾飞梦，从这一刻便开启了你的大学新篇章。" +
                "秉持“修德、博学、求实、创新”校训，书写你的重邮梦。很高兴能与你在重邮相遇。");

        addCompusEnvironment("科创信科楼", "挑战杯、创青春、互联网+、数模……在各类创新创业竞赛中，" +
                "都可以看到重邮人的身影，他们不断地充实着大学生活，和重邮人在一起，自己在会变得更好。");

        addCompusEnvironment("数字图书馆", "在这里，时间变慢，重邮人的脚步变快。从图书馆开门到熄灯，" +
                "总会看到埋头学习的重邮人，一整天都可以在窗户透过的光芒里，全神贯注。没错，爱学习的重邮人最好看啦！");

        addCompusEnvironment("二教夕阳", "伴着余晖，二教像披着一层朦胧的纱幔，" +
                "金黄的银杏叶妆点着她的美。漫步在春华秋实广场，邂逅一场邮苑专属浪漫。");

        addCompusEnvironment("高山流水", "在重邮信科楼旁的高山流水只是简单一个缩影，却包含了重邮学子的内心广阔。" +
                "流水溅射过青松，把一切都转换为学子的高山俯仰之情");

        addCompusEnvironment("雨红莲", "红砖绿荫的映衬下的雨红莲，是重邮人的活动聚集地。" +
                "丰富的校园活动常常在这里开展，洋着重邮人的活力，展示重邮浓厚的校园文化。");

        addCompusEnvironment("仰望八教", "八教是传媒艺术学院的学子艺术灵感的发源地，创意在这里闪亮聚集，" +
                "也是重邮人乘风破浪，扬帆起航的象征。勇敢追梦吧，重邮学子们。");
    }

    public void addCompusEnvironment(String title, String text) {
        AdmissionBean admissionBean = new AdmissionBean();
        admissionBean.title = title;
        admissionBean.text = text;
        admissionBeanList.add(admissionBean);
    }
}
