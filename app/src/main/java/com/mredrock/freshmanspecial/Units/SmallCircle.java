package com.mredrock.freshmanspecial.Units;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zia on 17-8-8.
 */

public class SmallCircle extends android.support.v7.widget.AppCompatTextView {

    private Paint circlePaint;
    private Paint textPaint;
    private List<String> texts = new ArrayList<>();
    private List<Integer> colors = new ArrayList<>();
    private List<Integer> shadows = new ArrayList<>();
    private int strokeWidth = ScreenUnit.dip2px(getContext(),12);

    public SmallCircle(Context context) {
        super(context);
    }

    public SmallCircle(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SmallCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);//抗锯齿
        circlePaint.setDither(true);//防抖动
        circlePaint.setStrokeCap(Paint.Cap.ROUND);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setStrokeWidth(strokeWidth);
        textPaint = new Paint();
        textPaint.setAntiAlias(true);//抗锯齿
        textPaint.setDither(true);//防抖动
        textPaint.setColor(Color.parseColor("#343434"));
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextSize(ScreenUnit.dip2px(getContext(),16));
        textPaint.setColor(Color.parseColor("#737373"));
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(texts==null || colors==null || texts.size()==0) return;
        float width = getWidth();
        final float space = strokeWidth * 3f;
        for(int i = 0;i<texts.size();i++){

            circlePaint.setStrokeWidth(strokeWidth-3);
            circlePaint.setShadowLayer(30,-2,1, Color.WHITE);

            //画阴影
            circlePaint.setColor(shadows.get(i));
            canvas.drawCircle(width/3f,strokeWidth+space*i,strokeWidth,circlePaint);
            //画圆
            circlePaint.setColor(colors.get(i));
            canvas.drawCircle(width/3f,strokeWidth+space*i,strokeWidth-6,circlePaint);
            //画字
            canvas.drawText(texts.get(i),width/3f+strokeWidth*2f,strokeWidth+space*i+strokeWidth/3,textPaint);
        }
    }

    public void draw(){
        postInvalidate();
    }

    public void setTexts(List<String> texts){
        this.texts = texts;
    }

    public void setColors(List<Integer> colors){
        this.colors = colors;
    }

    public void setShadows(List<Integer> shadows){
        this.shadows = shadows;
    }
}
