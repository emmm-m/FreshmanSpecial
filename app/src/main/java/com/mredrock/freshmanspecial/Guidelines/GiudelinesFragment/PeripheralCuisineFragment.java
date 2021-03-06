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
import com.mredrock.freshmanspecial.Beans.CuisineBean;
import com.mredrock.freshmanspecial.Beans.GuidelinesHorizontalBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.BeautyRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.CuisineRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.model.HttpModel;

import java.util.List;

import rx.Subscriber;

import static android.content.ContentValues.TAG;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-周边美食
 */

public class PeripheralCuisineFragment extends Fragment {
    private List<GuidelinesHorizontalBean> shopBeanList;
    private RecyclerView recyclerView;
    private CuisineRecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_cuisine, container, false);
        initData(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.cuisine_recycler);

        return view;
    }

    public void initData(final View view) {
        HttpModel.bulid().getCuisine(new Subscriber<CuisineBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {


            }

            @Override
            public void onNext(CuisineBean cuisineBean) {
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                adapter = new CuisineRecyclerAdapter(cuisineBean.getData(), view.getContext());
                recyclerView.setAdapter(adapter);
            }
        });
    }

    public void addCuisine(String shopName, String address, String commit) {
        GuidelinesHorizontalBean shopBean = new GuidelinesHorizontalBean();
        shopBean.shopName = shopName;
        shopBean.address = address;
        shopBean.commit = commit;
        shopBeanList.add(shopBean);
    }
}
