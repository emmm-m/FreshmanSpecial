package com.mredrock.freshmanspecial.view.JunxunFragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zia on 17-8-10.
 */

public class JunxunRecyclerAdapter extends RecyclerView.Adapter<JunxunRecyclerAdapter.MyViewHolder> {

    public static int TUPIAN = 0;
    public static int SHIPING = 1;
    public static int TUIJIAN = 2;
    private int type = 0;
    private Context context;
    List data = null;

    public JunxunRecyclerAdapter(Context context,int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(List data){
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (type){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        }
        else return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
