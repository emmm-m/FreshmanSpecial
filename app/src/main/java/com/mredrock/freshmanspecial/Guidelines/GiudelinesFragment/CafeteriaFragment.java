package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.Beans.AdmissionBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-学生食堂
 */

public class CafeteriaFragment extends Fragment {
    private List<AdmissionBean> admissionBeanList;
    private RecyclerView recyclerView;
    private VerticalRecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_cafeteria, container, false);
        iniData();
        recyclerView = (RecyclerView) view.findViewById(R.id.cafeteria_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new VerticalRecyclerAdapter(admissionBeanList, view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void iniData() {
        admissionBeanList = new ArrayList<>();
        addCafetira("中心食堂", "地理位置的优越不仅来源于它历史的悠久，" +
                "更是因为中心特色小面的支持，这里一砖一瓦都沉淀着岁月的气息。" +
                "又大又好吃又便宜的素菜包子和肉花卷、馒头加豆浆，是早餐的不二选择。");

        addCafetira("红高粱", "由于地处长长的阶梯之上，它有“重邮最高食堂”之称。" +
                "重邮流传着这样一句话：敢于从老校门到红高粱吃饭的人都是勇士。");

        addCafetira("兴业苑", "位处红高粱之下，“快递一条街”之上，毗邻兴业苑宿舍，" +
                "是兴业苑众多的男神女神便捷的就餐地点。这可是让明理苑、知行苑等的同学嫉妒兴业苑的地理位置得不行呢！");

        addCafetira("千喜鹤", "千喜鹤——上过微博热搜的网红食堂，" +
                "华丽的八角灯和亮丽的小彩灯在五颜六色的高脚凳的映衬下特别有小酒吧的文艺清新范" +
                "，传说中的“别人家的食堂”现在就是你家的食堂啦！");

        addCafetira("大西北", "如果有宗教信仰的小伙伴或者想尝尝大西北特色的同学一定不要错过这里，" +
                "西北的美食——兰州拉面量多价廉。去大西北，一定要点上一碗牛肉拉面尝尝这里的特色。");

        addCafetira("延生", "美食窗口众多，各有特色，每年都会不断推陈出新，更重要的是性价比非常高" +
                "，因此吸引了莘莘学子，客流量很大。酷暑天气，喝上一杯延生西瓜汁，真是降火消暑又愉悦人心。");
    }

    public void addCafetira(String title, String text) {
        AdmissionBean admissionBean = new AdmissionBean();
        admissionBean.title = title;
        admissionBean.text = text;
        admissionBeanList.add(admissionBean);
    }
}
