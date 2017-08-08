package com.mredrock.freshmanspecial.model;

import android.graphics.Color;
import android.util.Log;

import com.mredrock.freshmanspecial.Beans.FailBean;
import com.mredrock.freshmanspecial.Beans.SexBean;
import com.mredrock.freshmanspecial.Beans.WorkBean;
import com.mredrock.freshmanspecial.Units.ChartData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import rx.internal.util.ActionSubscriber;
import rx.observers.SafeSubscriber;

/**
 * Created by zia on 17-8-5.
 */

public class DataModel {
    public DataModel(){

    }



    /**
     * 组装男女比例信息
     * @return 集合
     */
    public List<ChartData> getSexRateDataList(SexBean.DataBean bean){
        if(bean == null) return null;
        final int girlCircleColor = Color.parseColor("#FFD2E3");
        final int girlCircleStrokeColor = Color.parseColor("#FFAACA");
        final int girlBackColor = Color.parseColor("#FFFDFF");
        final int girlBackStrokeColor = Color.parseColor("#FFFDFF");
        final int girlTextColor = Color.parseColor("#FFABC6");
        final int boyCircleColor = Color.parseColor("#B9E5FE");
        final int boyCircleStrokeColor = Color.parseColor("#7AC8EF");
        final int boyBackColor = Color.parseColor("#F8FCFF");
        final int boyBackStrokeColor = Color.parseColor("#E1F8FF");
        final int boyTextColor = Color.parseColor("#B0E1FB");
        ChartData girl = new ChartData();
        ChartData boy = new ChartData();
        girl.setTextColor(girlTextColor);
        girl.setBackgroundColor(girlBackColor);
        girl.setBackgroundStrokeColor(girlBackStrokeColor);
        girl.setColor(girlCircleColor);
        girl.setStrokeColor(girlCircleStrokeColor);
        boy.setTextColor(boyTextColor);
        boy.setBackgroundColor(boyBackColor);
        boy.setBackgroundStrokeColor(boyBackStrokeColor);
        boy.setColor(boyCircleColor);
        boy.setStrokeColor(boyCircleStrokeColor);
        //-----------------------------------------------//
        List<ChartData> list = new ArrayList<>();
        float girlRate = Float.valueOf(bean.getWomenRatio());
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        girl.setText(decimalFormat.format(girlRate*100.00f)+"%");
        girl.setPercentage((int)(girlRate*100.00f));
        boy.setText(decimalFormat.format(100-girlRate*100.00f)+"%");
        boy.setPercentage(100-(int)(girlRate*100.00f));
        Log.d("girl",girlRate*100.00f+"");
        Log.d("girl",(int)(girlRate*100.00f)+"");
        Log.d("boy",100-girlRate*100.00f+"");
        Log.d("boy",100-(int)(girlRate*100.00f)+"");
        list.add(boy);
        list.add(girl);
        return list;
    }

    /**
     * 组装就业率信息
     * @return 集合
     */
    public List<ChartData> getJobRateDataList(WorkBean.DataBean bean){
        if(bean == null) return null;
        final int girlCircleColor = Color.parseColor("#9EFCEE");
        final int girlCircleStrokeColor = Color.parseColor("#6CEAD5");
        final int girlBackColor = Color.parseColor("#F8FFFE");
        final int girlBackStrokeColor = Color.parseColor("#D7FFF9");
        final int girlTextColor = Color.parseColor("#77EFDB");
        final int boyCircleColor = Color.parseColor("#B9E5FE");
        final int boyCircleStrokeColor = Color.parseColor("#7AC8EF");
        final int boyBackColor = Color.parseColor("#F8FCFF");
        final int boyBackStrokeColor = Color.parseColor("#D0F4FF");
        final int boyTextColor = Color.parseColor("#B0E1FB");
        ChartData girl = new ChartData();
        ChartData boy = new ChartData();
        girl.setTextColor(girlTextColor);
        girl.setBackgroundColor(girlBackColor);
        girl.setBackgroundStrokeColor(girlBackStrokeColor);
        girl.setColor(girlCircleColor);
        girl.setStrokeColor(girlCircleStrokeColor);
        boy.setTextColor(boyTextColor);
        boy.setBackgroundColor(boyBackColor);
        boy.setBackgroundStrokeColor(boyBackStrokeColor);
        boy.setColor(boyCircleColor);
        boy.setStrokeColor(boyCircleStrokeColor);
        //-----------------------------------------------//
        List<ChartData> list = new ArrayList<>();
        float girlRate = Float.valueOf(bean.getRatio());
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        girl.setText(decimalFormat.format(girlRate*100.00f)+"%");
        girl.setPercentage((int)(girlRate*100.00f));
        boy.setText(decimalFormat.format(100-girlRate*100.00f)+"%");
        boy.setPercentage(100-(int)(girlRate*100.00f));
        Log.d("girl",girlRate*100.00f+"");
        Log.d("girl",(int)(girlRate*100.00f)+"");
        Log.d("boy",100-girlRate*100.00f+"");
        Log.d("boy",100-(int)(girlRate*100.00f)+"");
        list.add(boy);
        list.add(girl);
        return list;
    }

    /**
     * 组装最难科目信息
     * @return 集合
     */
    public List<ChartData> getMostDifficultDataList(List<FailBean.DataBean> beans){
        final int girlCircleColor = Color.parseColor("#FBFEB9");
        final int girlCircleStrokeColor = Color.parseColor("#EEDC79");
        final int girlBackColor = Color.parseColor("#FFFFFB");
        final int girlBackStrokeColor = Color.parseColor("#FDF9E7");
        final int girlTextColor = Color.parseColor("#FBF3CA");
        final int boyCircleColor = Color.parseColor("#9DFCEE");
        final int boyCircleStrokeColor = Color.parseColor("#6CEAD5");
        final int boyBackColor = Color.parseColor("#F8FFFE");
        final int boyBackStrokeColor = Color.parseColor("#D9FFF9");
        final int boyTextColor = Color.parseColor("#77EFDB");
        final int renyaoCircleColor = Color.parseColor("#B8E5FE");
        final int renyaoCircleStrokeColor = Color.parseColor("#7AC8EF");
        final int renyaoBackColor = Color.parseColor("#F8FCFF");
        final int renyaoBackStrokeColor = Color.parseColor("#E1F8FF");
        final int renyaoTextColor = Color.parseColor("#8AD4FA");
        ChartData girl = new ChartData();//最外层
        ChartData boy = new ChartData();//中间层
        ChartData renyao = new ChartData();//内层
        girl.setTextColor(girlTextColor);
        girl.setBackgroundColor(girlBackColor);
        girl.setBackgroundStrokeColor(girlBackStrokeColor);
        girl.setColor(girlCircleColor);
        girl.setStrokeColor(girlCircleStrokeColor);
        boy.setTextColor(boyTextColor);
        boy.setBackgroundColor(boyBackColor);
        boy.setBackgroundStrokeColor(boyBackStrokeColor);
        boy.setColor(boyCircleColor);
        boy.setStrokeColor(boyCircleStrokeColor);
        renyao.setTextColor(renyaoTextColor);
        renyao.setBackgroundColor(renyaoBackColor);
        renyao.setBackgroundStrokeColor(renyaoBackStrokeColor);
        renyao.setColor(renyaoCircleColor);
        renyao.setStrokeColor(renyaoCircleStrokeColor);
        //-----------------------------------------------//
        List<ChartData> list = new ArrayList<>();
        if(beans == null || beans.isEmpty()) return null;
        //排序
        Collections.sort(beans, new Comparator<FailBean.DataBean>() {
            @Override
            public int compare(FailBean.DataBean dataBean, FailBean.DataBean t1) {
                return dataBean.getRatio().compareTo(t1.getRatio());
            }
        });
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        if(beans.get(0) != null){
            girl.setText(decimalFormat.format(Float.valueOf(beans.get(0).getRatio())*100)+"%");
            girl.setPercentage((int)(Float.valueOf(beans.get(0).getRatio())*100));
        }else{Log.d("DataModel","beans.get(0) == null");}
        if(beans.get(1) != null){
            boy.setText(decimalFormat.format(Float.valueOf(beans.get(1).getRatio())*100)+"%");
            boy.setPercentage((int)(Float.valueOf(beans.get(1).getRatio())*100));
        }
        if(beans.get(2) != null){
            renyao.setText(decimalFormat.format(Float.valueOf(beans.get(2).getRatio())*100)+"%");
            renyao.setPercentage((int)(Float.valueOf(beans.get(2).getRatio())*100));
        }
        Log.d("12333",girl.getPercentage()+"");
        Log.d("12333",boy.getPercentage()+"");
        Log.d("12333",renyao.getPercentage()+"");
        list.add(girl);
        list.add(boy);
        list.add(renyao);
        return list;
    }


    public List<String> getMostDifficultCollege(){
        List<String> list = new ArrayList<>();
        list.add("经济管理学院");
        list.add("通信与信息工程学院");
        list.add("传媒艺术学院");
        list.add("先进制造工程学院");
        list.add("体育学院");
        list.add("生物信息学院");
        list.add("光电工程学院");
        list.add("国际学院");
        list.add("计算机科学与技术学院");
        list.add("软件工程学院");
        list.add("自动化学院");
        list.add("外国语学院");
        list.add("国际半导体学院");
        list.add("网络空间安全与信息法学院");
        list.add("理学院");
        return list;
    }

    /**
     * 获取学院名字集合
     * @return list
     */
    public List<String> getSexCollegeList(){
        List<String> list = new ArrayList<>();
        list.add("通信与信息工程学院");
        list.add("光电工程学院");
        list.add("经济管理学院");
        list.add("计算机科学与技术学院");
        list.add("外国语学院");
        list.add("生物信息学院");
        list.add("网络空间安全与信息法学院");
        list.add("自动化学院");
        list.add("先进制造工程学院");
        list.add("体育学院");
        list.add("理学院");
        list.add("传媒艺术学院");
        list.add("软件工程学院");
        list.add("国际半导体学院");
        list.add("国际学院");
        list.add("全校");
        return list;
    }

    public List<String> getWorkRateCollegeList(){
        List<String> list = new ArrayList<>();
        list.add("生物信息学院");
        list.add("传媒艺术学院");
        list.add("先进制造工程学院");
        list.add("计算机科学与技术学院");
        list.add("理学院");
        list.add("体育学院");
        list.add("光电工程学院\\/重庆国际半导体学院");
        list.add("软件工程学院");
        list.add("经济管理学院");
        list.add("通信与信息工程学院");
        list.add("自动化学院");
        list.add("外国语学院");
        list.add("法学院");
        return list;
    }

}
