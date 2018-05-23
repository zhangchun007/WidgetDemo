package com.xg.widgetdemo.value.animator;

import android.animation.TypeEvaluator;

/**
 * Created by xg on 2018/5/4.
 */

class CharEvaluator implements TypeEvaluator<Character>{
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt  = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int)(startInt + fraction *(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
