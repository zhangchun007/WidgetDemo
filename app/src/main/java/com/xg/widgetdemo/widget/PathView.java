package com.xg.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by xg on 2018/5/21.
 */

public class PathView extends View {
    public PathView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);//描边

        //1 直线路径
        /**canvas.drawPath(path, paint);
         *void moveTo (float x1, float y1):直线的开始点；即将直线路径的绘制点定在（x1,y1）的位置；
         void lineTo (float x2, float y2)：直线的结束点，又是下一次绘制直线路径的开始点；lineTo（）可以一直用；
         void close ():如果连续画了几条直线，但没有形成闭环，调用Close()会将路径首尾点连接起来环；
         */

        Path path = new Path();
        path.moveTo(10, 10); //设定起始点
        path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
        path.lineTo(300, 100);//画第二条直线
        path.lineTo(500, 100);//第三条直线
        path.close();//闭环

        canvas.drawPath(path, paint);

        //2 矩形路径
        /**
         * void addRect (float left, float top, float right, float bottom, Path.Direction dir)
         void addRect (RectF rect, Path.Direction dir)

         Path.Direction有两个值：
         Path.Direction.CCW：是counter-clockwise缩写，指创建逆时针方向的矩形路径；
         Path.Direction.CW：是clockwise的缩写，指创建顺时针方向的矩形路径；
         */

        //逆向生成
        Path CCWRectpath = new Path();
        RectF rect = new RectF(50, 150, 240, 300);
        CCWRectpath.addRect(rect, Path.Direction.CCW);


        //第二个顺向生成
        Path CWRectpath = new Path();
        RectF rect2 =  new RectF(290, 150, 480, 300);
        CWRectpath.addRect(rect2, Path.Direction.CW);
        //先画出这两个路径
        canvas.drawPath(CCWRectpath, paint);
        canvas.drawPath(CWRectpath, paint);

        //依据路径写出文字
        String text="风萧萧兮易水寒，壮士一去兮不复返";
        paint.setColor(Color.GRAY);
        paint.setTextSize(35);

        canvas.drawTextOnPath(text, CCWRectpath, 0, 18, paint);//逆时针生成
        canvas.drawTextOnPath(text, CWRectpath, 0, 18, paint);//顺时针生成


        //3:圆角矩形路径
        /**
         * void addRoundRect (RectF rect, float[] radii, Path.Direction dir)
         void addRoundRect (RectF rect, float rx, float ry, Path.Direction dir)
         这里有两个构造函数，部分参数说明如下：
         第一个构造函数：可以定制每个角的圆角大小：
         float[] radii：必须传入8个数值，分四组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径，如｛x1,y1,x2,y2,x3,y3,x4,y4｝，
         其中，x1,y1对应第一个角的（左上角）用来产生圆角的椭圆的横轴半径和纵轴半径，其它类推……
         第二个构造函数：只能构建统一圆角大小
         float rx：所产生圆角的椭圆的横轴半径；
         float ry：所产生圆角的椭圆的纵轴半径；
         */

        Path pathround=new Path();
        RectF rectF=new RectF(50,400,240,600);
        pathround.addRoundRect(rectF,10,15, Path.Direction.CCW);

//        RectF rect5 =  new RectF(290, 50, 480, 200);
//        float radii[] ={10,15,20,25,30,35,40,45};
//        path.addRoundRect(rect5, radii, Path.Direction.CCW);
        canvas.drawPath(pathround,paint);


        //4:、圆形路径
        /**
         * void addCircle (float x, float y, float radius, Path.Direction dir)
         */
        Path path3 = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CCW);
        canvas.drawPath(path, paint);

        //5、椭圆路径
        /**void addOval (RectF oval, Path.Direction dir)
         *参数说明：
         RectF oval：生成椭圆所对应的矩形
         Path.Direction :生成方式，与矩形一样，分为顺时针与逆时针，意义完全相同，不再重复
         */
        Path path4 = new Path();
        RectF rect4 =  new RectF(50, 50, 240, 200);
        path.addOval(rect4, Path.Direction.CCW);
        canvas.drawPath(path4, paint);

        //*6、弧形路径
        /**RectF oval：弧是椭圆的一部分，这个参数就是生成椭圆所对应的矩形；
         float startAngle：开始的角度，X轴正方向为0度
         float sweepAngel：持续的度数；
         *
         */
        Path path5 = new Path();
        RectF rect5 =  new RectF(50, 50, 240, 200);
        path.addArc(rect5, 0, 100);
        canvas.drawPath(path5, paint);//画出路径






    }
}
