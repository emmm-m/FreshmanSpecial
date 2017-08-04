package com.mredrock.freshmanspecial.Units;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by zxzhu on 2017/8/4.
 */

public class ScreenUnit {
    private Context context;
    private int dpWide,dpHeight,pxWide,pxHiget,dpi;

    private  ScreenUnit(Context context){
        this.context = context;
        getScreen();
    }

    public static ScreenUnit bulid(Context context){
        return new ScreenUnit(context);
    }

    private void getScreen(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        pxWide = dm.widthPixels;         // 屏幕宽度（像素）
        pxHiget = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        dpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        dpWide = (int) (pxWide / density);  // 屏幕宽度(dp)
        dpHeight = (int) (pxHiget / density);// 屏幕高度(dp)

    }
    public int getDpWide(){
        return dpWide;
    }
    public int getDpHeight(){
        return dpHeight;
    }
    public int getPxWide(){
        return pxWide;
    }
    public int getPxHiget(){
        return pxHiget;
    }
    private int getDpi(){
        return dpi;
    }
}
