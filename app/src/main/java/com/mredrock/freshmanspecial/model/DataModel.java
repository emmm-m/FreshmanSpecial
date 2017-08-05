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
     * 组装就业率信息
     * @param name 学院名
     * @return 集合
     */
    public List<ChartData> getJobRateDataList(String name){
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
     * 组装最难科目信息
     * @param majorName 专业名
     * @return 集合
     */
    public List<ChartData> getMostDifficultDataList(String majorName){
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
        if(majorName == null) return null;
        switch (majorName) {
            case "计算机科学与技术":
                girl.setText("60%");girl.setPercentage(60);
                boy.setText("40%");boy.setPercentage(40);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "信息安全":
                girl.setText("20%");girl.setPercentage(20);
                boy.setText("80%");boy.setPercentage(80);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "网络工程":
                girl.setText("10%");girl.setPercentage(10);
                boy.setText("90%");boy.setPercentage(90);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "地理信息":
                girl.setText("80%");girl.setPercentage(80);
                boy.setText("20%");boy.setPercentage(20);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "人工智能":
                girl.setText("50%");girl.setPercentage(50);
                boy.setText("50%");boy.setPercentage(50);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "空间信息":
                girl.setText("85%");girl.setPercentage(85);
                boy.setText("15%");boy.setPercentage(15);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "自动化科学与技术":
                girl.setText("85%");girl.setPercentage(85);
                boy.setText("15%");boy.setPercentage(15);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "自动化生产技术":
                girl.setText("65%");girl.setPercentage(65);
                boy.setText("35%");boy.setPercentage(35);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "自动编程技术":
                girl.setText("55%");girl.setPercentage(55);
                boy.setText("45%");boy.setPercentage(45);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            case "自动找女朋友技术":
                girl.setText("25%");girl.setPercentage(25);
                boy.setText("75%");boy.setPercentage(75);
                renyao.setText("30%");renyao.setPercentage(30);
                break;
            default:
                return null;
        }
        list.add(girl);
        list.add(boy);
        list.add(renyao);
        return list;
    }

    /**
     * 获取学院名字集合
     * @return list
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

    /**
     * 获取专业名字集合
     * @return list
     */
    public List<String> getMajorList(String collegeName){
        if(collegeName == null) return null;
        List<String> list = new ArrayList<>();
        switch (collegeName){
            case "计算机科学与技术学院":
                list.add("计算机科学与技术");
                list.add("信息安全");
                list.add("网络工程");
                list.add("地理信息");
                list.add("人工智能");
                list.add("空间信息");
                return list;
            case "自动化学院":
                list.add("自动化科学与技术");
                list.add("自动化生产技术");
                list.add("自动编程技术");
                list.add("自动找女朋友技术");
                return list;
            default:return null;
        }
    }
}
