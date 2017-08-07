package com.mredrock.freshmanspecial.Beans.MienBeans;

import android.graphics.drawable.Drawable;

import com.mredrock.freshmanspecial.Beans.RecyclerBean;

/**
 * Created by zxzhu on 2017/8/7.
 */

public class ExcellentBean extends RecyclerBean {
    private Drawable img;
    private String name, content;

    public void setImg(Drawable img){
        this.img = img;
    }

    public Drawable getImg(){
        return img;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
