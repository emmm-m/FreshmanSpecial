package com.mredrock.freshmanspecial.view.JunxunFragments;

import android.content.Context;
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

    public static final int JUNXUN_TUPIAN = 0;
    public static final int JUNXUN_SHIPING = 1;
    public static final int JUNXUN_TUIJIAN = 2;

    private Context context;
    private List<String> list = new ArrayList<>();


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
        if(position == 0){

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
        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType){
                case JUNXUN_TUPIAN:

                    break;
                case JUNXUN_SHIPING:

                    break;
                case JUNXUN_TUIJIAN:

                    break;
            }
        }
    }
}
