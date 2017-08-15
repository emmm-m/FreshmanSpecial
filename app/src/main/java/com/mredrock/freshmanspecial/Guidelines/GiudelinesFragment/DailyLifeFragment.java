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
import com.mredrock.freshmanspecial.Beans.DailyLifeBean;
import com.mredrock.freshmanspecial.Beans.GuidelinesHorizontalBean;
import com.mredrock.freshmanspecial.Beans.SurroundingBeautyBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.BeautyRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.DailyLifeRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.DormitoryRecyclerAdapter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.model.HttpModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

import static android.content.ContentValues.TAG;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-日常生活
 */

public class DailyLifeFragment extends Fragment {
    private List<GuidelinesHorizontalBean> shopBeanList;
    private RecyclerView recyclerView;
    private DailyLifeRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_daliy_life, container, false);
        initData(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.dailylife_recycler);

        return view;
    }

    public void initData(final View view) {
        HttpModel.bulid().getDailyLife(new Subscriber<DailyLifeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getActivity(),"请求数据失败",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNext(DailyLifeBean dailyLifeBean) {
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                adapter = new DailyLifeRecyclerAdapter(dailyLifeBean.getData(), view.getContext());
                recyclerView.setAdapter(adapter);
            }
        });
    }

}
