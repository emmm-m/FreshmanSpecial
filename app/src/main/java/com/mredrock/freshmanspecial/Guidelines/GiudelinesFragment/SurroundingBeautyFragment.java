package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.Beans.GuidelinesHorizontalBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.HorizontalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-周边美景
 */

public class SurroundingBeautyFragment extends Fragment {
    private List<GuidelinesHorizontalBean> shopBeanList;
    private RecyclerView recyclerView;
    private HorizontalRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_surrounding, container, false);
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.surrounding_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new HorizontalRecyclerAdapter(shopBeanList, view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void initData() {
        shopBeanList = new ArrayList<>();
        addSurroudingBeauty("大金鹰", "重庆市南岸区南山路25路大金鹰园内", "数十里景物尽收眼底");
        addSurroudingBeauty("黄葛古道", "G65包茂高速附近","重庆的“丝绸之道”");
        addSurroudingBeauty("重庆抗战遗址博物馆", "重庆市南岸区南山植物园路1号", "历史、自然气息浓厚");
        addSurroudingBeauty("老君洞", "重庆市南岸区龙黄公路", "重庆主城区最大最主要的宫观");
        addSurroudingBeauty("南滨公园", "重庆市南岸区南滨路80号", "开放带状公园");
        addSurroudingBeauty("南之山书店", "南山公园北路128号", "一间看得见风景的书店");
        addSurroudingBeauty("涂山湖", "重庆市南岸区崇文路16号", "四季景色尽揽眼底");
        addSurroudingBeauty("一棵树观景台", "重庆市南岸区风景区南山一棵树内", "感受山水之城的起伏面貌");
    }

    public void addSurroudingBeauty(String shopName, String address, String commit) {
        GuidelinesHorizontalBean shopBean = new GuidelinesHorizontalBean();
        shopBean.shopName = shopName;
        shopBean.address = address;
        shopBean.commit = commit;
        shopBeanList.add(shopBean);
    }
}
