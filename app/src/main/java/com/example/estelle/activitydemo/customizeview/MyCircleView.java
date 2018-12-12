package com.example.estelle.activitydemo.customizeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Description: 我要画一个⚪
 * @Author: wb.huhuimin
 * @Time: 2018/12/12 16:55
 * @update: wb.huhuimin 2018/12/12 16:55
 */
public class MyCircleView extends View {
    Paint paint;

    public MyCircleView(Context context) {
        this(context, null);

    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);//设置绘制模式
        paint.setColor(Color.YELLOW);// 设置颜色
        paint.setStrokeWidth(1);// 设置线条宽度
        paint.setTextSize(12);// 设置文字大小
        paint.setAntiAlias(true);//设置抗锯齿开关

        //这里是有先后顺序
        canvas.drawColor(Color.BLUE);//绘制背景色
        /**
         * centerX centerY 是圆心的坐标
         *  radius 是圆的半径
         *drawCircle(float centerX, float centerY, float radius, Paint paint)
         */
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, getMeasuredWidth() / 2, paint);
    }
}
