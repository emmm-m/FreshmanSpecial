package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by glossimar on 2017/8/4.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-recyclerView item 纵向排版，学校食堂、寝室、环境
 */

public class VerticalRecyclerAdapter extends RecyclerView.Adapter<VerticalRecyclerAdapter.ViewHolder>{
    private Context context;
    private List<String> list;  // 卡片里的内容单独组成一个类

    public VerticalRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage; // 主图
        TextView title; // 建筑名称
        TextView text;  // 建筑介绍
        public ViewHolder(View itemView) {
            super(itemView);
            mainImage = (ImageView) itemView.findViewById(R.id.picword_vertical_item_image);
            title = (TextView) itemView.findViewById(R.id.picword_vertical_item_title);
            text = (TextView) itemView.findViewById(R.id.picword_vertical_item_text);
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
//        这里加上类的实例
//        holder.textView .setText(list.get(position));   // 这里后来要改上文字
//        Glide.with(context).load()。into(holder.imageView);  // 加上Glide的引用, 用来加载接口里的图片（如果给接口的情况）
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
