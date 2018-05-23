package com.xg.widgetdemo.view.animator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.xg.widgetdemo.R;

/**
 * 属性动画通用属性
 * <p>
 * android:duration        动画持续时间，以毫秒为单位
 * android:fillAfter          如果设置为true，控件动画结束时，将保持动画最后时的状态
 * android:fillBefore       如果设置为true,控件动画结束时，还原到开始动画前的状态
 * android:fillEnabled    与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态
 * android:repeatCount 重复次数
 * android:repeatMode	重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。
 * 因为这里的意义是重复的类型，即回放时的动作。
 * android:interpolator  设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。
 * Created by xg on 2018/5/2.
 */

public class ViewAinmationActivity extends AppCompatActivity implements View.OnClickListener {
    //插值器

    //    用法     android:interpolator="@android:anim/accelerate_decelerate_interpolator"  （静态）
//    用法     interpolateScaleAnim.setInterpolator(new BounceInterpolator());    （动态）
/*
*
AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
AccelerateInterpolator                     在动画开始的地方速率改变比较慢，然后开始加速
AnticipateInterpolator                      开始的时候向后然后向前甩
AnticipateOvershootInterpolator     开始的时候向后然后向前甩一定值后返回最后的值
BounceInterpolator                          动画结束的时候弹起
CycleInterpolator                             动画循环播放特定的次数，速率改变沿着正弦曲线
DecelerateInterpolator                    在动画开始的地方快然后慢
LinearInterpolator                            以常量速率改变
OvershootInterpolator                      向前甩一定值后再回到原来位置
*
* */
    private Button btn_scale, btn_alpha, btn_rotate, btn_translate, btn_set;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        btn_scale = (Button) findViewById(R.id.btn_scale);
        btn_scale.setOnClickListener(this);
        btn_alpha = (Button) findViewById(R.id.btn_alpha);
        btn_alpha.setOnClickListener(this);
        btn_rotate = (Button) findViewById(R.id.btn_rotate);
        btn_rotate.setOnClickListener(this);
        btn_translate = (Button) findViewById(R.id.btn_translate);
        btn_translate.setOnClickListener(this);
        btn_set = (Button) findViewById(R.id.btn_set);
        btn_set.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_scale://伸缩动


                //静态代码
                Animation scale_animation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
                tv.startAnimation(scale_animation);

                //动态代码
                ScaleAnimation scaleAnim = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnim.setDuration(700);
                tv.startAnimation(scaleAnim);

                break;
            case R.id.btn_alpha://透明度
                //静态代码
                Animation alpha_animation = AnimationUtils.loadAnimation(this, R.anim.alphaanim);
                tv.startAnimation(alpha_animation);

                //d动态代码

                AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.1f);
                alphaAnim.setDuration(2000);
                tv.startAnimation(alphaAnim);
                break;
            case R.id.btn_rotate://旋转
                //静态代码
                Animation rotate_animation = AnimationUtils.loadAnimation(this, R.anim.rotateanim);
                tv.startAnimation(rotate_animation);

                //d动态代码
                RotateAnimation rotateAnim = new RotateAnimation(0, -650, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnim.setDuration(2000);
                rotateAnim.setFillAfter(true);
                tv.startAnimation(rotateAnim);
                break;
            case R.id.btn_translate://位移
                //静态代码
                Animation translate_animation = AnimationUtils.loadAnimation(this, R.anim.translateanim);
                tv.startAnimation(translate_animation);

                //d动态代码
                TranslateAnimation translateAnim = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 80,
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 80);
                translateAnim.setDuration(2000);
                translateAnim.setFillBefore(true);


                break;
            case R.id.btn_set:
                //静态代码
                Animation animations2 = AnimationUtils.loadAnimation(this, R.anim.setanim);
                animations2.setFillAfter(true);
                tv.startAnimation(animations2);


                //d动态代码
//                AlphaAnimation alphaAnim1 = new AlphaAnimation(0.0f,1.0f);
//                alphaAnim1.setStartOffset(1000);
//                ScaleAnimation scaleAnim1 = new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                RotateAnimation rotateAnim4 = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//
//                AnimationSet setAnim=new AnimationSet(true);
//                setAnim.addAnimation(alphaAnim1);
//                setAnim.addAnimation(scaleAnim1);
//                setAnim.addAnimation(rotateAnim4);
//
//                setAnim.setDuration(2000);
//                setAnim.setFillAfter(true);
//                tv.startAnimation(setAnim);;

                break;
        }
    }
}
