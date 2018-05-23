package com.xg.widgetdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by xg on 2018/5/21.
 */

public class DrawTextView extends View {
    Paint paint;
    public DrawTextView(Context context) {
        super(context);
        paint =new Paint();
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        paint.setColor(Color.RED);
//        paint.setTextAlign(Paint.Align.CENTER);//设置文字对齐方式，取值：align.CENTER、align.LEFT或align.RIGHT

//
//        //样式设置
//        paint.setFakeBoldText(true);//设置是否为粗体文字
//        paint.setUnderlineText(true);//设置下划线
//        paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25
//        paint.setStrikeThruText(true);//设置带有删除线效果

        //其它设置
//        paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1 绘制文字
        canvas.drawText("当幸福来敲门",10,100,paint);
        //2 截取绘制文字
        canvas.drawText("当幸福来敲门",2,4,10,300,paint);
        //3 指定个个文字位置
        /**
         * void drawPosText (char[] text, int index, int count, float[] pos, Paint paint)
         void drawPosText (String text, float[] pos, Paint paint)

         char[] text：要绘制的文字数组
         int index:：第一个要绘制的文字的索引
         int count：要绘制的文字的个数，用来算最后一个文字的位置，从第一个绘制的文字开始算起
         float[] pos：每个字体的位置，同样两两一组，如｛x1,y1,x2,y2,x3,y3……｝
         *
         */
        float []pos=new float[]{80,300,
                80,400,
                80,500,
                80,600};
        canvas.drawPosText("画图示例", pos, paint);//两个构造函数

        //4 沿路径绘制
        /**
         * void drawTextOnPath (String text, Path path, float hOffset, float vOffset, Paint paint)
         void drawTextOnPath (char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint)
         */

        String string="风萧萧兮易水寒，壮士一去兮不复返";

        //先创建两个相同的圆形路径，并先画出两个路径原图
        Path circlePath=new Path();
        circlePath.addCircle(220,200, 180, Path.Direction.CCW);//逆向绘制,还记得吗,上篇讲过的
        canvas.drawPath(circlePath, paint);//绘制出路径原形

        Path circlePath2=new Path();
        circlePath2.addCircle(750,200, 180, Path.Direction.CCW);
        canvas.drawPath(circlePath2, paint);//绘制出路径原形

        paint.setColor(Color.GREEN);
         //hoffset、voffset参数值全部设为0，看原始状态是怎样的
        canvas.drawTextOnPath(string, circlePath, 0, 0, paint);
        //第二个路径，改变hoffset、voffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80, 30, paint);

    }
}
