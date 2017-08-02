package com.mredrock.freshmanspecial.Units;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

import java.util.List;

public class CircleChart extends android.support.v7.widget.AppCompatTextView {

    private boolean isLog = false;
    private Paint paint;//画笔
    private int paintWidth = 70;//线宽
    private int textSize = 40;//字体大小
    private int speed = 1;//移动速度
    private int rotate = 0;//转动角度
    private boolean isRun = false;
    private List<ChartData> list;//数据
    private int space = paintWidth+20;//设置为自动计算间距，此项废弃
    private float centerX = 0,centerY = 0;
    static int defaultColor = Color.RED , defaultStrokeColor = Color.BLACK , defaultTextColor = Color.BLACK,
            defultBackgroundColor = Color.LTGRAY , defultBackgroundStrokeColor = Color.DKGRAY;


    public CircleChart(Context context) {
        super(context);
    }

    public CircleChart(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CircleChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();

    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if(centerX == 0 || centerY == 0){
            centerX = getWidth()/2;
            centerY = getHeight()/2;
        }
        if(list.size() == 0) return;
        if(isRun) {
            int count = 0;
//            int space = (getWidth()/2-10)/list.size();
            for(ChartData data : list){
                if(data.getRadius() == 0){
                    data.setRadius(getWidth()/2-space*count);
                    count++;
                }
                if(data.getPercentage() == 0) return;//防bug
                //drawArc(canvas, data.getPercentage(), data.getColor()+200, data.getRadius()+3,data.getSpeed());
                drawBackground(canvas,data.getBackgroundColor(),data.getBackgroundStrokeColor(),data.getRadius());
                drawArc(canvas, data.getPercentage(), data.getColor(),data.getStrokeColor(), data.getRadius(),data.getSpeed());
                drawText(canvas,data.getText(),paint.measureText(data.getText()),textSize,data.getTextColor(),data.getRadius());
            }
        }else{
            invalidate();
        }
    }

    /**
     * 背景圆画法封装
     * @param canvas 画布
     * @param backgroundColor 背景颜色
     * @param backgroundStrokeColor 背景描边颜色
     * @param radius 半径
     */
    private void drawBackground(Canvas canvas, int backgroundColor, int backgroundStrokeColor,float radius){
        RectF oval = new RectF( centerX-radius+paintWidth+10, centerY-radius+paintWidth+10,
                centerX+radius-paintWidth-10, centerY+radius-paintWidth-10);//用一个正方形包裹圆形

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(paintWidth+10);//描边宽度
        paint.setAntiAlias(true);//抗锯齿
        paint.setDither(true);//防抖动
        paint.setColor(backgroundStrokeColor);
        canvas.drawArc(oval,-90,360,false,paint);
        paint.setStrokeWidth(paintWidth);//描边宽度
        paint.setColor(backgroundColor);
        canvas.drawArc(oval,-90,360,false,paint);
    }

    /**
     * 画圆方法封装
     * @param canvas 画布
     * @param percentage 百分比
     * @param color 圆圈颜色
     * @param strokeColor 圆圈描边颜色
     * @param radius 半径
     * @param s 速度
     */
    private void drawArc(Canvas canvas, float percentage, int color,int strokeColor, float radius, int s){
        RectF oval = new RectF( centerX-radius+paintWidth+10, centerY-radius+paintWidth+10,
                centerX+radius-paintWidth-10, centerY+radius-paintWidth-10);//用一个正方形包裹圆形

        //黑色底层 用于描边
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(paintWidth+10);//描边宽度
        paint.setAntiAlias(true);//抗锯齿
        paint.setDither(true);//防抖动
        paint.setColor(strokeColor);
        if((float)rotate/360*100 < percentage){//还没到达终点
            rotate = rotate + s;
            canvas.drawArc(oval,-90,rotate,false,paint);
            log(rotate+"");
            invalidate();
        }else{//到达终点,停止绘制
            canvas.drawArc(oval,-90,percentage/100*360,false,paint);
        }
        //绘制
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(paintWidth);
        paint.setAntiAlias(true);//抗锯齿
        paint.setDither(true);//防抖动
        paint.setColor(color);
        if((float)rotate/360*100 < percentage){//还没到达终点
            rotate = rotate + s;
            canvas.drawArc(oval,-90,rotate,false,paint);
            log(rotate+"");
            invalidate();
        }else{//到达终点,停止绘制
            canvas.drawArc(oval,-90,percentage/100*360,false,paint);
        }

    }

    private void drawText(Canvas canvas,String text,float textWidth, int textSize,int color,float radius){
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        canvas.drawText(text,centerX-textWidth-50,centerY-radius+paintWidth+20,paint);
    }

    public void setData(List<ChartData> list){
        this.list = list;
    }

    public void setDefaultColor(int color){
        defaultColor = color;
    }

    public void setDefaultTextColor(int color){
        defaultTextColor = color;
    }

    /**
     * 设置速度，默认为1，每秒走1/6圆
     * 若设置为2，每秒走1/3圈
     * 公式 6/速度
     * @param speed 速度
     */
    public void setSpeed(int speed){
        if(speed <= 0) return;
        this.speed = speed;
    }

    /**
     * 设置圆圈半径粗细
     * @param width 宽度
     */
    public void setPaintWidth(int width){
        if(width <= 0) return;
        paintWidth = width;
    }

    /**
     * 开始动画
     */
    public void run(){
        isRun = true;
    }

    public void openLog(){
        isLog = true;
    }

    private void log(String msg){
        if(isLog) Log.d("CircleChartTest",msg);
    }
}

class ChartData{
    private int percentage = 0;
    private int color = CircleChart.defaultColor;
    private int textColor = CircleChart.defaultTextColor;
    private int backgroundColor = CircleChart.defultBackgroundColor;
    private int strokeColor = CircleChart.defaultStrokeColor;
    private int backgroundStrokeColor = CircleChart.defultBackgroundStrokeColor;
    private int speed = 2;
    private String text = "data";
    private float radius = 0;


    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int stockColor) {
        this.strokeColor = stockColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundStrokeColor() {
        return backgroundStrokeColor;
    }

    public void setBackgroundStrokeColor(int backgroundStrokeColor) {
        this.backgroundStrokeColor = backgroundStrokeColor;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
