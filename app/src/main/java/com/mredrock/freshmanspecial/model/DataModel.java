package com.mredrock.freshmanspecial.model;

import android.graphics.Color;

import com.mredrock.freshmanspecial.Units.ChartData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zia on 17-8-5.
 */

public class DataModel {
    public DataModel(){

    }



    /**
     * 组装男女比例信息
     * @param name 学院名
     * @return 集合
     */
    public List<ChartData> getSexRateDataList(String name){
        final int girlCircleColor = Color.parseColor("#FFD2E3");
        final int girlCircleStrokeColor = Color.parseColor("#FFAACA");
        final int girlBackColor = Color.parseColor("#FFFDFF");
        final int girlBackStrokeColor = Color.parseColor("#FFFDFF");
        final int girlTextColor = Color.parseColor("#FFABC6");
        final int boyCircleColor = Color.parseColor("#B9E5FE");
        final int boyCircleStrokeColor = Color.parseColor("#7AC8EF");
        final int boyBackColor = Color.parseColor("#F8FCFF");
        final int boyBackStrokeColor = Color.parseColor("#E1F8FF");
        final int boyTextColor = Color.parseColor("#FFABC6");
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
        if(name == null) return null;
        switch (name) {
            case "计算机科学与技术学院":
                girl.setText("60%");girl.setPercentage(60);
                boy.setText("40%");boy.setPercentage(40);
                break;
            case "自动化学院":
                girl.setText("20%");girl.setPercentage(20);
                boy.setText("80");boy.setPercentage(80);
                break;
            case "通信学院":
                girl.setText("10%");girl.setPercentage(10);
                boy.setText("90%");boy.setPercentage(90);
                break;
            case "传媒学院":
                girl.setText("80%");girl.setPercentage(80);
                boy.setText("20%");boy.setPercentage(20);
                break;
            case "经管学院":
                girl.setText("50%");girl.setPercentage(50);
                boy.setText("50%");boy.setPercentage(50);
                break;
            case "软件工程学院":
                girl.setText("85%");girl.setPercentage(85);
                boy.setText("15");boy.setPercentage(15);
                break;
            default:
                return null;
        }
        list.add(girl);
        list.add(boy);
        return list;
    }

    /**
     * 获取学院名字集合
     * @return
     */
    public List<String> getCollegeList(){
        List<String> list = new ArrayList<>();
        list.add("计算机科学与技术学院");
        list.add("自动化学院");
        list.add("通信学院");
        list.add("传媒学院");
        list.add("经管学院");
        list.add("数理学院");
        list.add("光电学院");
        list.add("软件工程学院");
        list.add("国际学院");
        return list;
    }
}
