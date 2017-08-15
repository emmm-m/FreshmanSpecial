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

import com.google.gson.Gson;
import com.mredrock.freshmanspecial.Beans.CampusBean;
import com.mredrock.freshmanspecial.Beans.GuidelinesVerticalBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.CafetriaRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.CampusRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-校园环境
 */

public class CampusEnvironmentFragment extends Fragment{
    private List<GuidelinesVerticalBean> admissionBeanList;
    private RecyclerView recyclerView;
    private CampusRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_environment, container, false);
//        initData(view);

        recyclerView = (RecyclerView) view.findViewById(R.id.environment_recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        adapter = new VerticalRecyclerAdapter(admissionBeanList, view.getContext());
//        recyclerView.setAdapter(adapter);
        return view;
    }

    public void addCompusEnvironment(String title, String text) {
        GuidelinesVerticalBean admissionBean = new GuidelinesVerticalBean();
        admissionBean.title = title;
        admissionBean.text = text;
        admissionBeanList.add(admissionBean);
    }
}
