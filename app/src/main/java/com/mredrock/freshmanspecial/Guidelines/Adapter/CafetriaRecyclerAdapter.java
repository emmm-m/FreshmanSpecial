package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.android.imageloadingwan.HttpMethod;
import com.bignerdranch.android.imageloadingwan.ImageLoad;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mredrock.freshmanspecial.Beans.CafeteriaBean;
import com.mredrock.freshmanspecial.Beans.CampusBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyImageView;
import com.mredrock.freshmanspecial.Units.ScreenUnit;

import java.util.List;

/**
 * Created by glossimar on 2017/8/11.
 */

public class CafetriaRecyclerAdapter extends RecyclerView.Adapter<CafetriaRecyclerAdapter.ViewHolder>{
    private Context context;
    private Activity activity;
    private List<CafeteriaBean.CafeteriaDataBean> list;  // 卡片里的内容单独组成一个类

    public CafetriaRecyclerAdapter(List<CafeteriaBean.CafeteriaDataBean> list, Context context
    , Activity activity
    ) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        MyImageView mainImage; // 主图
        TextView title; // 建筑名称
        TextView text;  // 建筑介绍
        TextView pictureNumber;
        TextView dormitoryNumber;   //Only for Dormitory List
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            mainImage = (MyImageView) itemView.findViewById(R.id.picword_vertical_item_image);
            title = (TextView) itemView.findViewById(R.id.picword_vertical_item_title);
            text = (TextView) itemView.findViewById(R.id.picword_vertical_item_text);
            dormitoryNumber = (TextView) itemView.findViewById(R.id.picwod_vertical_dormitory_number);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.picwod_vertical_picture_linear);
            pictureNumber = (TextView) itemView.findViewById(R.id.picwod_vertical_picture_number);
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
        CafeteriaBean.CafeteriaDataBean cafeteria = list.get(position);
        holder.title.setText(cafeteria.getName());
        holder.text.setText(cafeteria.getResume());
        holder.dormitoryNumber.setText(cafeteria.getDormitoryNumber());
        holder.pictureNumber.setText(cafeteria.getUrl().size() + "");
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .override(ScreenUnit.bulid(context).getPxWide(),ScreenUnit.bulid(context).getPxWide()/16*9);
        Log.d("123","height:  "+ScreenUnit.bulid(context).getPxWide()/16*9);
        Glide.with(context).load(cafeteria.getUrl().get(0)).apply(options).into(holder.mainImage);
        holder.linearLayout.getBackground().setAlpha(170);
//        ImageLoad.getImage(activity, admissionBean.getUrl().get(0), holder.mainImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}