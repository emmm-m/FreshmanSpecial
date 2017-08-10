package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.Beans.AdmissionBean;
import com.mredrock.freshmanspecial.Beans.ShopBean;
import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by glossimar on 2017/8/4.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-recyclerview 横向排版，周边美景、美食
 */

public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<HorizontalRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<ShopBean> list;  // 卡片里的内容单独组成一个类

    public HorizontalRecyclerAdapter(List<ShopBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopName; //  名称
        TextView commit;  //  具体描述
        TextView address;   //  所在地点
        ImageView mainImage;    //  图片

        public ViewHolder(View itemView) {
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.picword_horizontal_item_title);
            commit = (TextView) itemView.findViewById(R.id.picword_horizontal_item_text);
            address = (TextView) itemView.findViewById(R.id.picword_horizontal_item_address);
            mainImage = (ImageView) itemView.findViewById(R.id.picword_horizontal_item_image);

        }
    }

    @Override
    public HorizontalRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.special_2017_picword_horizontal_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShopBean shopBean = list.get(position);
        holder.address.setText(shopBean.address);
        holder.shopName.setText(shopBean.shopName);
        holder.commit.setText(shopBean.commit);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
