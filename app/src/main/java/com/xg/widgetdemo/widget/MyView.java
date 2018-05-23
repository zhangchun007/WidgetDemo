package com.xg.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by xg on 2018/5/21.
 */

public class MyView extends View {
    Context m_context;

    public MyView(Context context) {
        super(context);
        m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //设置画笔基本属性
        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿功能
        paint.setColor(Color.RED); //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
        paint.setStrokeWidth(5);//设置画笔宽度
//        paint.setShadowLayer(10,15,15,Color.GREEN);//设置阴影

        //设置画布背景颜色
        canvas.drawRGB(255, 255, 255);//设置阴影
        //1：画圆
        /**
         * :drawCircle(float cx, float cy, float radius, @NonNull Paint paint)
         * cx:x轴的位置
         * cy:y轴的位置
         * radius：半径
         */
        canvas.drawCircle(190, 200, 150, paint);
        //2：画直线
        /**、
         * 画直线:void drawLine (float startX, float startY, float stopX, float stopY, Paint paint)
         *startX:开始点X坐标
         startY:开始点Y坐标
         stopX:结束点X坐标
         stopY:结束点Y坐标
         */
        canvas.drawLine(100, 100, 200, 200, paint);

        //3:画多条直线
        /**
         * void drawLines (float[] pts, Paint paint)
         void drawLines (float[] pts, int offset, int count, Paint paint)
         *pts:是点的集合pts的组织方式为｛x1,y1,x2,y2,x3,y3,……｝
         * （上面有四个点：（10，10）、（100，100），（200，200），（400，400）），两两连成一条直线；
         */
        float[] pts = {10, 10, 100, 100, 200, 200, 400, 400};
        canvas.drawLines(pts, paint);

        //4：画点
        /**
         * void drawPoint (float x, float y, Paint paint)
         * 参数：
         float X：点的X坐标
         float Y：点的Y坐标
         */
        canvas.drawPoint(100, 100, paint);

        //5:多个点
        /**
         * void drawPoints (float[] pts, Paint paint)
         void drawPoints (float[] pts, int offset, int count, Paint paint)
         int offset:集合中跳过的数值个数，注意不是点的个数！一个点是两个数值；
         count:参与绘制的数值的个数，指pts[]里人数值个数，而不是点的个数，因为一个点是两个数值


         同样是上面的四个点：（10，10）、（100，100），（200，200），（400，400），drawPoints里路过前两个数值，
         即第一个点横纵坐标，画出后面四个数值代表的点，即第二，第三个点，第四个点没画；效果图如下）
         */
        float[] ptss = {10, 10, 100, 100, 200, 200, 400, 400};
        canvas.drawPoints(pts, 2, 4, paint);


        //矩形工具类RectF与Rect
        //RectF：
        /**
         * RectF()
         RectF(float left, float top, float right, float bottom)
         RectF(RectF r)
         RectF(Rect r)
         */


        //Rect
        /*构造函数如下，最常用的也是根据四个点来构造矩形

        Rect()
        Rect(int left, int top, int right, int bottom)
        Rect(Rect r)*/


        //6:绘制矩形
        /**
         * 6、矩形

         void drawRect (float left, float top, float right, float bottom, Paint paint)
         void drawRect (RectF rect, Paint paint)
         void drawRect (Rect r, Paint paint)
         */
        canvas.drawRect(10,10,100,100,paint);

        RectF rectF=new RectF(120,10,210,100);
        canvas.drawRect(rectF,paint);

        Rect rect=new Rect(230,10,320,100);
        canvas.drawRect(rect,paint);


        //7:圆角矩形
        /**
         * void drawRoundRect (RectF rect, float rx, float ry, Paint paint)
         * RectF rect:要画的矩形
         float rx:生成圆角的椭圆的X轴半径
         float ry:生成圆角的椭圆的Y轴半径
         */

        RectF rectF1=new RectF(100,10,300,100);
        canvas.drawRoundRect(rectF1,20,10,paint);

        //8:椭圆
        /**void drawOval (RectF oval, Paint paint)
         *参数：
         RectF oval：用来生成椭圆的矩形
         */
        RectF oval=new RectF(100,10,300,100);
        canvas.drawOval(oval,paint);

        //9:弧
        /**弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；
         * void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
         *参数：
         RectF oval:生成椭圆的矩形
         float startAngle：弧开始的角度，以X轴正方向为0度
         float sweepAngle：弧持续的角度
         boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧
         */


        RectF rect1 = new RectF(100, 10, 300, 100);
        canvas.drawArc(rect1, 0, 90, true, paint);

        RectF rect2 = new RectF(400, 10, 600, 100);
        canvas.drawArc(rect2, 0, 90, false, paint);

    }
}
