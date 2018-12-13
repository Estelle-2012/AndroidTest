package com.example.estelle.activitydemo.customizeview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Description: 练习一下画图
 * @Author: wb.huhuimin
 * @Time: 2018/12/12 16:55
 * @update: wb.huhuimin 2018/12/12 16:55
 */
public class MyCircleView extends View {
    Paint paint;
    Path path;

    public MyCircleView(Context context) {
        this(context, null);

    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        paint = new Paint();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//开启抗锯齿（使边缘更加平滑）
//        paint.setAntiAlias(true);//开启和关闭抗锯齿


        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);//绘制背景色
        drawCircle(canvas);
        drawHeart(canvas);
        drawPoint(canvas);
        drawOval(canvas);
        paint.setColor(Color.BLACK);
        canvas.drawLine(0, getMeasuredHeight() - 100, getMeasuredWidth(), getMeasuredHeight() - 100, paint);//画线
        drawRect(canvas);
        drawArc(canvas);


        //
    }

    //画个圆
    private void drawCircle(Canvas canvas) {
        /**
         * Style
         * 1：FILL 是填充模式
         * 2：STROKE 是画线模式（即勾边模式）
         * 3：FILL_AND_STROKE 是两种模式一并使用：既画线又填充
         */
        paint.setStyle(Paint.Style.FILL);//设置绘制模式
        paint.setColor(Color.YELLOW);// 设置颜色
        paint.setStrokeWidth(1);// 设置线条宽度
        paint.setTextSize(12);// 设置文字大小
        paint.setAntiAlias(true);//设置抗锯齿开关


        /**
         * centerX centerY 是圆心的坐标
         *  radius 是圆的半径
         *drawCircle(float centerX, float centerY, float radius, Paint paint)
         */
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, getMeasuredWidth() / 2, paint);
    }

    //画个爱心drawpath
    @TargetApi(21)
    private void drawHeart(Canvas canvas) {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        paint.setColor(Color.RED);
        path.moveTo(getMeasuredWidth() / 2, getMeasuredHeight() / 2);//起始位置
//        path.rMoveTo(getMeasuredWidth(), getMeasuredHeight());//下一笔起始位置

        //绘制圆弧
        {
            path.addArc(200, 200, 400, 400, -225, 225);
            path.arcTo(400, 200, 600, 400, -180, 225, false);
        }
        path.lineTo(400, 542);////添加当前点到目标点（x，y）构成的直线到path
        canvas.drawPath(path, paint);
    }

    //画点
    private void drawPoint(Canvas canvas) {
        paint.setColor(Color.BLACK);
        //圆点
        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(getMeasuredWidth() / 2 + 30, getMeasuredHeight() / 2, paint);
        //方点
        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(getMeasuredWidth() / 2 - 30/*我第一次知道可以这么注释*/, getMeasuredHeight() / 2, paint);

        //批量画点：(50, 50) (50, 100) (100, 50) (100, 100)
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                8 /* 一共绘制 8 个数（4 个点）*/, paint);
    }

    //画椭圆
    @TargetApi(21)
    private void drawOval(Canvas canvas) {
        paint.setColor(Color.GREEN);
        canvas.drawOval(50, 50, 350, 200, paint);
    }

    //画矩形
    @TargetApi(21)
    private void drawRect(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawRect(700, 100, 1100, 500, paint);//left, top, right, bottom四条边坐标
        canvas.drawRoundRect(100, 100, 500, 300, 50, 50, paint);//left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径。
    }

    //画弧线
    @TargetApi(21)
    private void drawArc(Canvas canvas) {
        paint.setColor(Color.BLUE); // 填充模式
        /**
         * left, top, right, bottom 描述的是这个弧形所在的椭圆；
         * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
         * sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形
         */
        canvas.drawArc(getMeasuredWidth() / 2 - 200, getMeasuredHeight() / 2 - 250, getMeasuredWidth() / 2 + 200, getMeasuredHeight() / 2 + 250, -110, 100, true, paint); // 绘制扇形
        canvas.drawArc(getMeasuredWidth() / 2 - 200, getMeasuredHeight() / 2 - 250, getMeasuredWidth() / 2 + 200, getMeasuredHeight() / 2 + 250, 20, 140, false, paint); // 绘制弧形
        paint.setStyle(Paint.Style.STROKE); // 画线模式
        canvas.drawArc(getMeasuredWidth() / 2 - 200, getMeasuredHeight() / 2 - 250, getMeasuredWidth() / 2 + 200, getMeasuredHeight() / 2 + 250, 180, 60, false, paint); // 绘制不封口的弧形
    }
}
