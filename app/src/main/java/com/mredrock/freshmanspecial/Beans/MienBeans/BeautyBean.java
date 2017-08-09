package com.mredrock.freshmanspecial.Beans.MienBeans;

import android.graphics.drawable.Drawable;

import com.mredrock.freshmanspecial.Beans.RecyclerBean;
import com.mredrock.freshmanspecial.R;

/**
 * Created by zxzhu on 2017/8/7.
 */

public class BeautyBean extends RecyclerBean{
    private Drawable img;
    private String title, content, url_img;

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

    public void setUrl_img(String url_img){
        this.url_img = url_img;
    }

    public String getUrl_img(){
        return url_img;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
