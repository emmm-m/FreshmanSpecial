package com.mredrock.freshmanspecial.Beans.MienBeans;

import com.mredrock.freshmanspecial.Beans.RecyclerBean;
import com.mredrock.freshmanspecial.R;

/**
 * Created by zxzhu on 2017/8/10.
 */

public class GroupBean extends RecyclerBean {

    private String title,content;

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
