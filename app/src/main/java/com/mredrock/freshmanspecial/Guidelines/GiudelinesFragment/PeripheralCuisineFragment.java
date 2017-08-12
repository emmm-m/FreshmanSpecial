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

import com.bignerdranch.android.imageloadingwan.CallBackListener;
import com.bignerdranch.android.imageloadingwan.HttpMethod;
import com.google.gson.Gson;
import com.mredrock.freshmanspecial.Beans.CampusBean;
import com.mredrock.freshmanspecial.Beans.CuisineBean;
import com.mredrock.freshmanspecial.Beans.GuidelinesHorizontalBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.BeautyRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.CuisineRecyclerAdapter;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;

import java.util.List;

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
        HttpMethod httpMethod = new HttpMethod();
        httpMethod.httpRequest("http://www.yangruixin.com/test/apiForGuide.php?RequestType=Cate",
                new CallBackListener() {
                    @Override
                    public void onFinish(String response) {
                        Gson gson = new Gson();
                        final CuisineBean bean = gson.fromJson(response, CuisineBean.class);
                        Log.d(TAG, "onFinish: " +response);
                        Log.d(TAG, "onFinish: " + bean.getData().get(0).getName());

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                                adapter = new CuisineRecyclerAdapter(bean.getData(), view.getContext());
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

    public void addCuisine(String shopName, String address, String commit) {
        GuidelinesHorizontalBean shopBean = new GuidelinesHorizontalBean();
        shopBean.shopName = shopName;
        shopBean.address = address;
        shopBean.commit = commit;
        shopBeanList.add(shopBean);
    }
}
