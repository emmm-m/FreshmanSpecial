package com.mredrock.freshmanspecial.Beans.MienBeans;

import android.graphics.drawable.Drawable;

import com.mredrock.freshmanspecial.Beans.RecyclerBean;
import com.mredrock.freshmanspecial.R;

/**
 * Created by zxzhu on 2017/8/7.
 */

public class BeautyBean extends RecyclerBean{
    private Drawable img;
    private String title, content;

    public void setImg(Drawable img){
        this.img = img;
    }

    public Drawable getImg(){
        return img;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
