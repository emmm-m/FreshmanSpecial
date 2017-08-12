package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.Beans.GuidelinesHorizontalBean;
import com.mredrock.freshmanspecial.Beans.SurroundingBeautyBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyImageView;

import java.util.List;

/**
 * Created by glossimar on 2017/8/4.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-recyclerview 横向排版，周边美景、美食
 */

public class BeautyRecyclerAdapter extends RecyclerView.Adapter<BeautyRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<SurroundingBeautyBean.SurroundingBeautyDataBean> list;  // 卡片里的内容单独组成一个类

    public BeautyRecyclerAdapter(List<SurroundingBeautyBean.SurroundingBeautyDataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopName; //  名称
        TextView commit;  //  具体描述
        TextView address;   //  所在地点
        MyImageView mainImage;    //  图片

        public ViewHolder(View itemView) {
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.picword_horizontal_item_title);
            commit = (TextView) itemView.findViewById(R.id.picword_horizontal_item_text);
            address = (TextView) itemView.findViewById(R.id.picword_horizontal_item_address);
            mainImage = (MyImageView) itemView.findViewById(R.id.picword_horizontal_item_image);

        }
    }

    @Override
    public BeautyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.special_2017_picword_horizontal_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SurroundingBeautyBean.SurroundingBeautyDataBean shopBean = list.get(position);
        holder.address.setText(shopBean.getLocation());
        holder.shopName.setText(shopBean.getName());
        holder.commit.setText(shopBean.getResume());
        Glide.with(context).load(shopBean.getUrl().get(0)).into(holder.mainImage);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}