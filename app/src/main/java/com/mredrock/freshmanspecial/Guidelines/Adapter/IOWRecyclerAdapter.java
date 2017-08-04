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
 * 界面 ： 邮子攻略-recyclerview 多布局（只有图片或文字的时候）
 */

public class IOWRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> list;  // 卡片里的内容单独组成一个类

    private static final int ONLY_PIC = 1;
    private static final int ONLY_WORDS = 2;

    public IOWRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    static class WordsViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;  // 卡片式布局
        TextView textView; // 卡片里的文字

        public WordsViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            textView = (TextView) itemView.findViewById(R.id.pic_and_word_item_text);
        }
    }

    static class PicViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public PicViewHolder(View itemView) {
            super(itemView);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.pic_and_word_item, parent, false);
        final RecyclerView.ViewHolder holder = null;
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
