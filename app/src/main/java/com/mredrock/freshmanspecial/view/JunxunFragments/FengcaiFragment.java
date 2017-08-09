package com.mredrock.freshmanspecial.view.JunxunFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FengcaiFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private FengcaiAdapter adapter;

    @Override
    protected void initData() {
        recyclerView = $(R.id.fengcai_recycler);
        adapter = new FengcaiAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_fengcai;
    }

}
