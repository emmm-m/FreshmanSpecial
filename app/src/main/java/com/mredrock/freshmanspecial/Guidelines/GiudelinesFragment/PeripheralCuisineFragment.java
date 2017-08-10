package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.Beans.ShopBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.HorizontalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-周边美食
 */

public class PeripheralCuisineFragment extends Fragment {
    private List<ShopBean> shopBeanList;
    private RecyclerView recyclerView;
    private HorizontalRecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_cuisine, container, false);
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.cuisine_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new HorizontalRecyclerAdapter(shopBeanList, view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void initData() {
       shopBeanList = new ArrayList<>();
        addCuisine("重庆鸡公煲", "老校门对面堕落街", "好吃不辣，量足管饱");
        addCuisine("新疆沙湾大盘鸡", "老校门对面堕落街", "独具疆域特色");
        addCuisine("福宇记黄焖鸡", "老校门对面堕落街", "香味浓郁");
        addCuisine("撒拉尔牛肉面", "老校门对面堕落街", "独具清真特色");
        addCuisine("渝香铁板烧", "老校门对面堕落街", "味道纯正，香气十足");
        addCuisine("刘氏鸡公煲", "老校门对面堕落街", "浓香滑嫩，入味彻底");
        addCuisine("阿里郎", "老校门对面堕落街", "独具台式风味");
        addCuisine("陈记干锅", "老校门对面堕落街", "量大分足，赏心悦目");
        addCuisine("李海粥王", "老校门对面堕落街", "营养美味");
        addCuisine("旮旯酸辣粉、羊肉粉", "老校门对面堕落街", "回味悠长，麻辣鲜香");
        addCuisine("三番料理", "老校门对面堕落街", "唇齿留香，色味俱佳");
        addCuisine("好又来", "老校门对面堕落街", "好吃不贵");
        addCuisine("咖喱至尊", "老校门对面堕落街", "色香味美，物美价廉");
        addCuisine("边林社", "老校门对面堕落街", "美味佳肴");
        addCuisine("小酒馆", "老校门对面堕落街", "文青聚集地");
        addCuisine("嬢嬢汤圆", "老校门对面堕落街", "嬢嬢好，汤圆妈妈味");
        addCuisine("李记串串", "永辉超市旁边", "口味独特，麻辣鲜香");
        addCuisine("纸包鱼", "新校门对面罐罐米线旁边", "味美可口");
        addCuisine("豆花鱼", "新校门对面堕落街2街第一家", "豆浆涮鱼好滋味");
        addCuisine("万州巴斗香烤鱼", "新校门出门右转，农业银行旁买水果的巷子里面", "口味奇绝、营养丰富");
        addCuisine("蜜雪冰城", "老校门对面", "这家的冰激凌很好吃哦，有抹茶，原味和混合三种口味哦~而且不贵，只要两块，物美价廉！");
        addCuisine("果然", "老校门对面", "甜品美食在这里");
        addCuisine("城门老火锅", "新校门出门，过马路右转下山的路边", "辣而不燥，回味悠长");
        addCuisine("Daydream", "老校门出门过马路左转直走看见采蝶轩汤锅，就在它旁边（在角落，不是很好找）", "文青们聚集地");
        addCuisine("华莱士", "老校门对面", "物美价廉，种类繁多，美味可口");
    }

    public void addCuisine(String shopName, String address, String commit) {
        ShopBean shopBean = new ShopBean();
        shopBean.shopName = shopName;
        shopBean.address = address;
        shopBean.commit = commit;
        shopBeanList.add(shopBean);
    }
}
