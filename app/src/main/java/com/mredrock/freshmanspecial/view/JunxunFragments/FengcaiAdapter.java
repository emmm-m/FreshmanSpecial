package com.mredrock.freshmanspecial.view.JunxunFragments;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zia on 17-8-8.
 */

public class FengcaiAdapter extends RecyclerView.Adapter<FengcaiAdapter.MyViewHolder> {

    private static final int JUNXUN_TUPIAN = 0;
    private static final int JUNXUN_SHIPING = 1;
    private static final int JUNXUN_TUIJIAN = 2;

    private Context context = null;
    private JunxunRecyclerAdapter adapter = null;


    public FengcaiAdapter (Context context){
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == JUNXUN_TUPIAN){
            View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxunpic,parent,false);
            return new MyViewHolder(view,JUNXUN_TUPIAN);
        }
        else if(viewType == JUNXUN_SHIPING){
            View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxinvideo,parent,false);
            return new MyViewHolder(view,JUNXUN_SHIPING);
        }
        else if(viewType == JUNXUN_TUIJIAN){
            View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxunrecommend,parent,false);
            return new MyViewHolder(view,JUNXUN_TUIJIAN);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (position){
            case 0://图片
                adapter = new JunxunRecyclerAdapter(context,JunxunRecyclerAdapter.TUPIAN);
                holder.junxunpicRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                holder.junxunpicRecycler.setAdapter(adapter);
                break;
            case 1://视频
                adapter = new JunxunRecyclerAdapter(context,JunxunRecyclerAdapter.SHIPING);
                holder.junxunvideoRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                holder.junxunvideoRecycler.setAdapter(adapter);
                break;
            case 2://推荐
                adapter = new JunxunRecyclerAdapter(context,JunxunRecyclerAdapter.TUIJIAN);
                holder.junxunrecommendRecycler.setLayoutManager(new GridLayoutManager(context,2));
                holder.junxunrecommendRecycler.setAdapter(adapter);
                break;
        }
        Log.d("123",position+"");
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:return JUNXUN_TUPIAN;
            case 1:return JUNXUN_SHIPING;
            case 2:return JUNXUN_TUIJIAN;
            default:return super.getItemViewType(position);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView junxunvideoRecycler,junxunpicRecycler,junxunrecommendRecycler;

        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType){
                case JUNXUN_TUPIAN:
                    junxunpicRecycler = itemView.findViewById(R.id.junxunpic_recycler);
                    break;
                case JUNXUN_SHIPING:
                    junxunvideoRecycler = itemView.findViewById(R.id.junxunvideo_recycler);
                    break;
                case JUNXUN_TUIJIAN:
                    junxunrecommendRecycler = itemView.findViewById(R.id.junxunrecommend_recycler);
                    break;
            }
        }
    }
}
