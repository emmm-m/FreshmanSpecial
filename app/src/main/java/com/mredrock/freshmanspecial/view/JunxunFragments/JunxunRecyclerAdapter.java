package com.mredrock.freshmanspecial.view.JunxunFragments;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

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
    List<String> stringList = null;
    List<String> authorList = null;

    public JunxunRecyclerAdapter(Context context,int type) {
        this.context = context;
        this.type = type;
    }

    public void setStringList(List<String> data){
        this.stringList = data;
        notifyDataSetChanged();
    }

    public void setMusicList(List<String> strings,List<String> authorList){
        this.authorList = authorList;
        this.stringList = strings;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (type){
            case 0://图片
                View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxuntupian,parent,false);
                return new MyViewHolder(view);
            case 1://视频
                View view1 = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxunshiping,parent,false);
                return new MyViewHolder(view1);
            case 2://军歌推荐
                View view2 = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxuntuijian,parent,false);
                return new MyViewHolder(view2);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (type){
            case 0:
                holder.junxuntupian_text.setText((String) stringList.get(position));
                break;
            case 1:
                holder.junxunshiping_text.setText((String) stringList.get(position));
                break;
            case 2:
                if(position<9){
                    holder.junxuntuijian_number.setText("0"+(position+1));
                }
                else{
                    holder.junxuntuijian_number.setText(position+1+"");
                }
                holder.junxuntuijian_music.setText(stringList.get(position));
                holder.junxuntuijian_author.setText(authorList.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        if(stringList != null){
            return stringList.size();
        }
        else return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CardView junxuntupian_image,junxunshiping_image;
        TextView junxuntupian_text,junxunshiping_text,junxuntuijian_number,junxuntuijian_music,junxuntuijian_author;

        public MyViewHolder(View itemView) {
            super(itemView);
            switch (type){
                case 0:
                    junxuntupian_image = itemView.findViewById(R.id.junxuntupian_image);
                    junxuntupian_text = itemView.findViewById(R.id.junxuntupian_text);
                    break;
                case 1:
                    junxunshiping_image = itemView.findViewById(R.id.junxunshiping_image);
                    junxunshiping_text = itemView.findViewById(R.id.junxunshiping_text);
                    break;
                case 2:
                    junxuntuijian_author = itemView.findViewById(R.id.junxuntuijian_author);
                    junxuntuijian_number = itemView.findViewById(R.id.junxuntuijian_number);
                    junxuntuijian_music = itemView.findViewById(R.id.junxuntuijian_music);
                    break;
            }
        }
    }
}
