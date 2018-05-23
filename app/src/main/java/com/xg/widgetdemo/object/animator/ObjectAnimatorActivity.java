package com.xg.widgetdemo.object.animator;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.xg.widgetdemo.R;

/**
 * ValueAnimator有个缺点，就是只能对数值对动画计算
 * 为了能让动画直接与对应控件相关联，以使我们从监听动画过程中解放出来，
 * 谷歌的开发人员在ValueAnimator的基础上，又派生了一个类ObjectAnimator;
 * 由于ObjectAnimator是派生自ValueAnimator的，
 * 所以ValueAnimator中所能使用的方法，在ObjectAnimator中都可以正常使用。
 * <p>
 * Created by xg on 2018/5/4.
 */

public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    //    其实，ObjectAnimator做动画，并不是根据控件xml中的属性来改变的，而是通过指定属性所对应的set方法来改变的。
//    比如，我们上面指定的改变rotation的属性值，ObjectAnimator在做动画时就会到指定控件（TextView）中去找对应的setRotation()方法来改变控件中对应的值
//1、要使用ObjectAnimator来构造对画，要操作的控件中，必须存在对应的属性的set方法
//2、setter 方法的命名必须以骆驼拼写法命名，即set后每个单词首字母大写，其余字母小写，即类似于setPropertyName所对应的属性为propertyName
    private Button mButton,btn_self,btn_PropertyValuesHolder;
    private TextView tv;
    private MyRoundView my_round;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        tv = (TextView) findViewById(R.id.tv);
        my_round = (MyRoundView) findViewById(R.id.my_round);
        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(this);
        btn_self = (Button) findViewById(R.id.btn_self);
        btn_self.setOnClickListener(this);
        btn_PropertyValuesHolder = (Button) findViewById(R.id.btn_PropertyValuesHolder);
        btn_PropertyValuesHolder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                //透明度
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "alpha", 1, 0, 1);
                objectAnimator.setDuration(200);
                objectAnimator.start();

                //绕x轴旋转
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(tv, "rotationX", 0, 270, 0);
                animatorX.setDuration(2000);
                animatorX.start();

                //绕Y轴旋转
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(tv, "rotationY", 0, 180, 0);
                animatorY.setDuration(2000);
                animatorY.start();

                //绕Z轴旋转
                ObjectAnimator animatorZ = ObjectAnimator.ofFloat(tv, "rotation", 0, 270, 0);
                animatorZ.setDuration(2000);
                animatorZ.start();

                //setTranslationX与setTranslationY  每次移动距离的计算都是以原点为中心的
                //1 setTranslationX(float translationX) :表示在X轴上的平移距离,以当前控件为原点，向右为正方向，参数translationX表示移动的距离
                //2 setTranslationY(float translationY) :表示在Y轴上的平移距离，以当前控件为原点，向下为正方向，参数translationY表示移动的距离

                //translationX  每次移动距离的计算都是以原点为中心的
                ObjectAnimator translationX = ObjectAnimator.ofFloat(tv, "translationX", 0,  200, -200, 0);
                translationX.setDuration(2000);
                translationX.start();

                //translationY  每次移动距离的计算都是以原点为中心的
                ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationY", 0, 200, -100, 0);
                animator.setDuration(2000);
                animator.start();

                //setScaleX与setScaleY
                //setScaleX(float scaleX):在X轴上缩放，scaleX表示缩放倍数
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(tv, "scaleX", 0, 3, 1);
                scaleX.setDuration(2000);
                scaleX.start();

                //setScaleY(float scaleY):在Y轴上缩放，scaleY表示缩放倍数
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(tv, "scaleY", 0, 3, 1);
                scaleY.setDuration(2000);
                scaleY.start();

                break;
            case R.id.btn_self:
                //由于ObjectAnimator是通过指定属性所对应的set方法来改变的。因此在自定义过程中我们需要定义一个set函数，
                // 如果我们的函数名命名为setScalePointX(float ),那我们在写属性时可以写成”scalePointX”或者写成“ScalePointX”都是可以的，即第一个字母大小写可以随意，
                // 但后面的部分必须与set方法后的大小写保持一致。
                //通过构造设置相应的值，然后调用set函数，实现动画的原理
                ObjectAnimator animators = ObjectAnimator.ofInt(my_round, "pointRadius", 0, 300, 100);
                animators.setDuration(2000);
                animators.start();
                break;
            case R.id.btn_PropertyValuesHolder:
                //PropertyValuesHolder这个类的意义就是，它其中保存了动画过程中所需要操作的属性和对应的值。
                PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
                PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
                ObjectAnimator animator_value_holder = ObjectAnimator.ofPropertyValuesHolder(tv, rotationHolder, colorHolder);
                animator_value_holder.setDuration(3000);
                animator_value_holder.setInterpolator(new AccelerateInterpolator());
                animator_value_holder.start();
                break;

        }

    }


}
