package com.mredrock.freshmanspecial.view.JunxunFragments;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zia on 17-8-8.
 */

public class FengcaiAdapter extends RecyclerView.Adapter<FengcaiAdapter.MyViewHolder> {

    private static final int JUNXUN_TUPIAN = 1;
    private static final int JUNXUN_SHIPING = 3;
    private static final int JUNXUN_TUIJIAN = 5;

    private Context context = null;
    private JunxunRecyclerAdapter adapter = null;


    public FengcaiAdapter (Context context){
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == JUNXUN_TUPIAN){
            View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxunpic,parent,false);
            return new MyViewHolder(view,JUNXUN_TUPIAN);
        }
        else if(viewType == JUNXUN_SHIPING){
            View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxinvideo,parent,false);
            return new MyViewHolder(view,JUNXUN_SHIPING);
        }
        else if(viewType == JUNXUN_TUIJIAN){
            View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_junxunrecommend,parent,false);
            return new MyViewHolder(view,JUNXUN_TUIJIAN);
        }
        else{
            View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_fengcaidecorte,parent,false);
            return new MyViewHolder(view,viewType);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.textView.setText("军训图片");
                break;
            case 1://图片
                adapter = new JunxunRecyclerAdapter(context,JunxunRecyclerAdapter.TUPIAN);
                holder.junxunpicRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                holder.junxunpicRecycler.setAdapter(adapter);
                List<String> list = new ArrayList<>();
                list.add("123");list.add("1234");list.add("12123");list.add("12123");list.add("12143");list.add("153123");
                adapter.setStringList(list);
                break;
            case 2:
                holder.textView.setText("军训视频");
                break;
            case 3://视频
                adapter = new JunxunRecyclerAdapter(context,JunxunRecyclerAdapter.SHIPING);
                holder.junxunvideoRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                holder.junxunvideoRecycler.setAdapter(adapter);
                List<String> list1 = new ArrayList<>();
                list1.add("123");list1.add("1234");list1.add("12123");list1.add("12123");list1.add("12143");list1.add("153123");
                adapter.setStringList(list1);
                break;
            case 4:
                holder.textView.setText("军歌推荐");
                break;
            case 5://推荐
                adapter = new JunxunRecyclerAdapter(context,JunxunRecyclerAdapter.TUIJIAN);
                holder.junxunrecommendRecycler.setLayoutManager(new GridLayoutManager(context,2));
                holder.junxunrecommendRecycler.setAdapter(adapter);
                List<String> musicList = new ArrayList<>();
                List<String> authorList = new ArrayList<>();
                musicList.add("强军战歌");authorList.add("阎维文");
                musicList.add("咱当兵的人");authorList.add("刘斌");
                musicList.add("团结就是力量");authorList.add("霍勇");
                musicList.add("军中绿花");authorList.add("小曾");
                musicList.add("战友还记得吗");authorList.add("小曾");
                musicList.add("一二三四歌");authorList.add("阎维文");
                musicList.add("75厘米");authorList.add("小曾");
                musicList.add("打靶归来");authorList.add("阎维文");
                musicList.add("精忠报国");authorList.add("屠洪刚");
                musicList.add("我的老班长");authorList.add("小曾");
                musicList.add("保卫黄河");authorList.add("瞿弦和");
                musicList.add("国际歌");authorList.add("张穆庭");
                adapter.setMusicList(musicList,authorList);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:return 0;
            case 1:return JUNXUN_TUPIAN;
            case 2:return 2;
            case 3:return JUNXUN_SHIPING;
            case 4:return 4;
            case 5:return JUNXUN_TUIJIAN;
            default:return position;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView junxunvideoRecycler,junxunpicRecycler,junxunrecommendRecycler;
        TextView textView;

        public MyViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType){
                case JUNXUN_TUPIAN:
                    junxunpicRecycler = itemView.findViewById(R.id.junxunpic_recycler);
                    break;
                case JUNXUN_SHIPING:
                    junxunvideoRecycler = itemView.findViewById(R.id.junxunvideo_recycler);
                    break;
                case JUNXUN_TUIJIAN:
                    junxunrecommendRecycler = itemView.findViewById(R.id.junxunrecommend_recycler);
                    break;
                default:
                    textView = itemView.findViewById(R.id.fengcai_text);
            }
        }
    }
}
