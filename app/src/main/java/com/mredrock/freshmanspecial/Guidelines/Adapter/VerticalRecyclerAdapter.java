package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.Beans.AdmissionBean;
import com.mredrock.freshmanspecial.R;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by glossimar on 2017/8/4.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-recyclerView item 纵向排版，学校食堂、寝室、环境
 */

public class VerticalRecyclerAdapter extends RecyclerView.Adapter<VerticalRecyclerAdapter.ViewHolder>{
    private Context context;
    private List<AdmissionBean> list;  // 卡片里的内容单独组成一个类

    public VerticalRecyclerAdapter(List<AdmissionBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage; // 主图
        TextView title; // 建筑名称
        TextView text;  // 建筑介绍
        TextView dormitoryNumber;   //Only for Dormitory List
        public ViewHolder(View itemView) {
            super(itemView);
            mainImage = (ImageView) itemView.findViewById(R.id.picword_vertical_item_image);
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
        AdmissionBean admissionBean = list.get(position);
        holder.title.setText(admissionBean.title);
        holder.text.setText(admissionBean.text);
        holder.dormitoryNumber.setText(admissionBean.dormitoryNumber);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
