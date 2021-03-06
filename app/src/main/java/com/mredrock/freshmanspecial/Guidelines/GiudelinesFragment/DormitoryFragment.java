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
import android.widget.Toast;

import com.google.gson.Gson;
import com.mredrock.freshmanspecial.Beans.CampusBean;
import com.mredrock.freshmanspecial.Beans.DormitoryBean;
import com.mredrock.freshmanspecial.Beans.GuidelinesVerticalBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.DormitoryRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.model.HttpModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

import static android.content.ContentValues.TAG;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-学生寝室
 */

public class DormitoryFragment extends Fragment {
    private List<GuidelinesVerticalBean> admissionBeanList;
    private RecyclerView recyclerView;
    private DormitoryRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_dormitory, container, false);
        initData(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.dormitory_recycler);
        return view;
    }

    public void initData(final View v) {
        HttpModel.bulid().getDormitory(new Subscriber<DormitoryBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getActivity(),"请求数据失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(DormitoryBean dormitoryBean) {
                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
                adapter = new DormitoryRecyclerAdapter(dormitoryBean.getData(), v.getContext());
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
