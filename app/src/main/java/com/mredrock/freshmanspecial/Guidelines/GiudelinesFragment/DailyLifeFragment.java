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
 * 界面 ： 邮子攻略-日常生活
 */

public class DailyLifeFragment extends Fragment {
    private List<GuidelinesHorizontalBean> shopBeanList;
    private RecyclerView recyclerView;
    private HorizontalRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_daliy_life, container, false);
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.dailylife_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new HorizontalRecyclerAdapter(shopBeanList, view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void initData() {
        shopBeanList = new ArrayList<>();
        addShop("重庆农村商业银行", "重庆邮电大学旁，老校门出门，过马路，右转。", "方便取存款，办理业务。");
        addShop("多乐迪KTV", "重庆邮电大学旁，新校门出门右转，中国农业银行楼", "环境较好，是个唱歌的好地方");
        addShop("联佰大药房", "重庆邮电大学旁，新校门出门，过马路，右转直走。", "药品相对齐全");
        addShop("新世纪超市", "重庆邮电大学旁，新校门出门右转，过一条马路直走", "各类物品较为齐全");
        addShop("永辉超市", "重庆邮电大学旁，新校门出门过马路，右转直走", "物品齐全，价钱相对便宜");
        addShop("渝芳百货商场", "重庆邮电大学旁，新校门出门，左转直走。老校门出门，右转直走", "物品较为丰富");
        addShop("中国工商银行自助服务点", "重庆邮电大学旁，新校门出门，左转直走，老校门出门，右转直走", "距离学校较近，比较方便");
        addShop("中国邮政", "重庆邮电大学旁，老校门出门，右转。新校门出们，左转", "以办理相关业务，取存款等");
        addShop("ZAKKA生活小铺", "重庆邮电大学旁，新校门出门，左转直走，老校门出门，右转直走", "文具等用品齐全");
    }

    public void addShop(String shopName, String address, String commit) {
        GuidelinesHorizontalBean shopBean = new GuidelinesHorizontalBean();
        shopBean.shopName = shopName;
        shopBean.address = address;
        shopBean.commit = commit;
        shopBeanList.add(shopBean);
    }
}
