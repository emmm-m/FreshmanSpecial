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
    private int strokeWidth = ScreenUnit.dip2px(getContext(),18);

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
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextSize(ScreenUnit.dip2px(getContext(),18));
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(texts==null || colors==null || texts.size()==0) return;
        float width = getWidth();
        float height = getHeight();
        final float space = width/texts.size();
        for(int i = 0;i<texts.size();i++){
            circlePaint.setColor(colors.get(i));
            textPaint.setColor(colors.get(i));

            circlePaint.setStrokeWidth(strokeWidth-3);
            circlePaint.setShadowLayer(30,-2,1, Color.WHITE);
            canvas.drawCircle(space/3+space*i,strokeWidth,height/6,circlePaint);

            canvas.drawText(texts.get(i),space/3+space*i + height/3,strokeWidth+height/12,textPaint);
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
}
