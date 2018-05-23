package com.xg.widgetdemo.value.animator;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xg.widgetdemo.R;

/**
 * 属性动画
 * 为什么引入Property Animator?
 * 1:Property Animator能实现补间动画无法实现的功能
 * 2:View Animation仅能对指定的控件做动画，而Property Animator是通过改变控件某一属性值来做动画的。
 *
 * 其实ValueAnimator动画的根本是对控件的某一属性值做的动画，通过设置监听AnimatorUpdateListener，根据其返回的值，再设置控件的属性动画
 *
 * Created by xg on 2018/5/2.
 */

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener{

    public Button btn,btn_cancle,btn_object;
    private TextView tv;
    private MyPointView mPointView;



    /*ValueAnimator从名字可以看出，这个Animation是针对值的！*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);
        tv= (TextView) findViewById(R.id.tv);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btn_cancle= (Button) findViewById(R.id.btn_cancle);
        btn_cancle.setOnClickListener(this);
        btn_object= (Button) findViewById(R.id.btn_object);
        btn_object.setOnClickListener(this);
        mPointView = (MyPointView)findViewById(R.id.pointview);


        //初步使用ValueAnimator
        //第一步：创建ValueAnimator实例
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
        valueAnimator.setDuration(1000);
        //第二步：添加监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //int)(startInt + fraction * (endValue - startInt));
                //当前的值 = 100 + （400 - 100）* 显示进度
                //Evaluator的作用是根据当前动画的显示进度，计算出当前进度下把对应的值
                int value = (int) animation.getAnimatedValue();
                Log.i("jimmy","value=="+value);
            }
        });
        valueAnimator.start();

    }

    ValueAnimator animator;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                //我们是通过layout函数来改变位置的，我们知道layout函数在改变控件位置时是永久性的，即通过更改控件left,top,right,bottom这四个点的坐标来改更改坐标位置的，
                // 而不仅仅是从视觉上画在哪个位置，所以通过layout函数更改位置后，控件在新位置是可以响应点击事件的。
               // 大家可能注意到了,layout（）函数中上下左右点的坐标是以屏幕坐标来标准的。所以在效果图中可以看到，textview的运动轨迹是从屏幕的左上角(0,0)点运行到（400，400）点。
                animator= ValueAnimator.ofInt(0,400);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {  //是监听动画的实时变化状态
                        int curValue = (int)animation.getAnimatedValue();
                        tv.layout(tv.getLeft(),curValue,curValue+tv.getWidth(),curValue+tv.getHeight());
                    }
                });
                animator.setDuration(1000);
                animator.start();
                break;
            case R.id.btn_cancle:
                animator.cancel();
                break;
            case R.id.btn_object:
//                ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
//                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        char text = (char)animation.getAnimatedValue();
//                        tv.setText(String.valueOf(text));
//                    }
//                });
//                animator.setDuration(10000);
//                animator.setInterpolator(new AccelerateInterpolator());
//                animator.start();



                mPointView.doPointAnim();
                break;
        }
    }
}
