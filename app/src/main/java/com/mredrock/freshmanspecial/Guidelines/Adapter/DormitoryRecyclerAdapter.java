package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.mredrock.freshmanspecial.Beans.CampusBean;
import com.mredrock.freshmanspecial.Beans.DormitoryBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyImageView;
import com.mredrock.freshmanspecial.view.SlideActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glossimar on 2017/8/11.
 */

public class DormitoryRecyclerAdapter extends RecyclerView.Adapter<DormitoryRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<DormitoryBean.DormitoryDataBean> list;  // 卡片里的内容单独组成一个类

    public DormitoryRecyclerAdapter(List<DormitoryBean.DormitoryDataBean> list, Context context) {
        this.list = list;
        this.context = context;
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
            pictureNumber = (TextView) itemView.findViewById(R.id.picwod_vertical_picture_number);
            dormitoryNumber = (TextView) itemView.findViewById(R.id.picwod_vertical_dormitory_number);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.picwod_vertical_picture_linear);
            linearLayout.setVisibility(View.VISIBLE);
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DormitoryBean.DormitoryDataBean dormitoy = list.get(position);
        holder.title.setText(dormitoy.getName());
        holder.text.setText(dormitoy.getResume());
        holder.dormitoryNumber.setText(dormitoy.getDormitoryNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> picTitleList = new ArrayList<String>();
                for (int i = 0; i < dormitoy.getUrl().size(); i++) {
                    picTitleList.add(dormitoy.getResume());
                }
                Intent intent = new Intent(context, SlideActivity.class);
                intent.putStringArrayListExtra("imageUrlList", (ArrayList) dormitoy.getUrl());
                intent.putStringArrayListExtra("titleList", (ArrayList) picTitleList);
                intent.putExtra("position", 0);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.mainImage, "share").toBundle());
                }else {
                    context.startActivity(intent);
                }
            }
        });
        holder.dormitoryNumber.setText(getDormitoryNumber(dormitoy.getName()));
        holder.pictureNumber.setText(dormitoy.getUrl().size() + "");
        Glide.with(context).load(dormitoy.getUrl().get(0))
                .transition(new DrawableTransitionOptions().crossFade(200))
                .into(holder.mainImage);
        holder.linearLayout.getBackground().setAlpha(170);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private String getDormitoryNumber(String dormitory) {
        String dormitoryNumber = dormitory.substring(3);
        Log.d("Adapter", "getDormitoryNumber:......................................................... " + dormitoryNumber);
        return dormitoryNumber;
    }

    private String getDormitoryName(String dormitory) {
        String dormitoryName = dormitory.substring(0, 3);
        return dormitoryName;
    }

}
