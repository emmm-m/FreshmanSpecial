package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.imageloadingwan.CallBackListener;
import com.bignerdranch.android.imageloadingwan.HttpMethod;
import com.google.gson.Gson;
import com.mredrock.freshmanspecial.Beans.CafeteriaBean;
import com.mredrock.freshmanspecial.Beans.DormitoryBean;
import com.mredrock.freshmanspecial.Beans.GuidelinesVerticalBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.CafetriaRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.DormitoryRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Guidelines;
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
    private List<GuidelinesVerticalBean> admissionBeanList;
    private RecyclerView recyclerView;
    private CafetriaRecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_cafeteria, container, false);
        iniData(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.cafeteria_recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        adapter = new VerticalRecyclerAdapter(admissionBeanList, view.getContext());
//        recyclerView.setAdapter(adapter);
        return view;
    }

    public void iniData(final View v) {

        HttpMethod httpMethod = new HttpMethod();
        httpMethod.httpRequest("http://www.yangruixin.com/test/apiForGuide.php?RequestType=Canteen",
                new CallBackListener() {
                    @Override
                    public void onFinish(String response) {
                        Gson gson = new Gson();
                        final CafeteriaBean bean = gson.fromJson(response, CafeteriaBean.class);
                        Log.d(TAG, "onFinish: " +response);
                        Log.d(TAG, "onFinish: " + bean.getData().get(2).getUrl().get(0));

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
                                adapter = new CafetriaRecyclerAdapter(bean.getData(), v.getContext(), (Activity)v.getContext());
                                recyclerView.setAdapter(adapter);
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
