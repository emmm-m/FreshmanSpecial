package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;

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
 * 界面 ： 邮子攻略-recyclerView的Adapter(图片和文字在一个卡片里)
 */

public class IAWRecyclerAdapter extends RecyclerView.Adapter<IAWRecyclerAdapter.ViewHolder>{
    private Context context;
    private List<String> list;  // 卡片里的内容单独组成一个类

    public IAWRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;  // 卡片式布局
        ImageView imageView; // 卡片里的图像
        TextView textView; // 卡片里的文字
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = (ImageView) itemView.findViewById(R.id.pic_and_word_item_image);
            textView = (TextView) itemView.findViewById(R.id.pic_and_word_item_text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.pic_and_word_item, parent, false);

        return new ViewHolder(view);
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
