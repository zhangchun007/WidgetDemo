package com.xg.widgetdemo.object.animator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xg.widgetdemo.value.animator.Point;

/**
 * Created by xg on 2018/5/8.
 */

public class MyRoundView extends View{

    private Point mPoint = new Point(100);

    public MyRoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mPoint != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mPoint.getRadius(),paint);
        }
        super.onDraw(canvas);
    }

    void setPointRadius(int radius){
        mPoint.setRadius(radius);
        invalidate();
    }
}
