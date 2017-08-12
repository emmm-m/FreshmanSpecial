package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.Beans.CampusBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyImageView;

import java.util.List;

/**
 * Created by glossimar on 2017/8/11.
 */

public class CampusRecyclerAdapter extends RecyclerView.Adapter<CampusRecyclerAdapter.ViewHolder>{
    private Context context;
    private List<CampusBean.CampusDataBean> list;  // 卡片里的内容单独组成一个类

    public CampusRecyclerAdapter(List<CampusBean.CampusDataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        MyImageView mainImage; // 主图
        TextView title; // 建筑名称
        TextView text;  // 建筑介绍
        TextView dormitoryNumber;   //Only for Dormitory List
        public ViewHolder(View itemView) {
            super(itemView);
            mainImage = (MyImageView) itemView.findViewById(R.id.picword_vertical_item_image);
            title = (TextView) itemView.findViewById(R.id.picword_vertical_item_title);
            text = (TextView) itemView.findViewById(R.id.picword_vertical_item_text);
            dormitoryNumber = (TextView) itemView.findViewById(R.id.picwod_vertical_dormitory_number);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.special_2017_picword_vertical_item, parent, false);
        ViewHolder holer = new ViewHolder(view);
        return holer;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CampusBean.CampusDataBean campus = list.get(position);
        holder.title.setText(campus.getTitle());
        holder.text.setText(campus.getContent());
        holder.dormitoryNumber.setText(campus.getDormitoryNumber());
        Glide.with(context).load(campus.getUrl().get(0)).into(holder.mainImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
