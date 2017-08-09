package com.mredrock.freshmanspecial.Beans.MienBeans;

import android.graphics.drawable.Drawable;

import com.mredrock.freshmanspecial.Beans.RecyclerBean;

/**
 * Created by zxzhu on 2017/8/9.
 */

public class OriginalBean extends RecyclerBean {
    private String title,time,url,img_url;
    private Drawable img;

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setImg_url(String img_url){
        this.img_url = img_url;
    }

    public String getImg_url(){
        return img_url;
    }

    public void setImg(Drawable img){
        this.img = img;
    }

    public Drawable getImg(){
        return img;
    }

}
