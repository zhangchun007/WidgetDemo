package com.xg.widgetdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xg.widgetdemo.object.animator.ObjectAnimatorActivity;
import com.xg.widgetdemo.value.animator.ValueAnimatorActivity;
import com.xg.widgetdemo.view.animator.ViewAinmationActivity;
import com.xg.widgetdemo.widget.GraphicsWidgetActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_view, btn_value_anim,btn_object_anim,btn_widget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        btn_view = (Button) findViewById(R.id.btn_view);
        btn_view.setOnClickListener(this);
        btn_value_anim = (Button) findViewById(R.id.btn_value_anim);
        btn_value_anim.setOnClickListener(this);
        btn_object_anim = (Button) findViewById(R.id.btn_object_anim);
        btn_object_anim.setOnClickListener(this);
        btn_widget = (Button) findViewById(R.id.btn_widget);
        btn_widget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view:
                startActivity(new Intent(this, ViewAinmationActivity.class));
                break;
            case R.id.btn_value_anim:
                startActivity(new Intent(this, ValueAnimatorActivity.class));
                break;
            case R.id.btn_object_anim:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));
                break;
            case R.id.btn_widget:
                startActivity(new Intent(this, GraphicsWidgetActivity.class));
                break;
        }

    }
}
