package com.xg.widgetdemo.value.animator;

import android.animation.TypeEvaluator;

/**
 * Created by xg on 2018/5/4.
 */
public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end  = endValue.getRadius();
        int curValue = (int)(start + fraction * (end - start));
        return new Point(curValue);
    }
}