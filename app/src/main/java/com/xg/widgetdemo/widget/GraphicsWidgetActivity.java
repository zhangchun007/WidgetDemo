package com.xg.widgetdemo.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.xg.widgetdemo.R;

/**
 * Created by xg on 2018/5/21.
 */

public class GraphicsWidgetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        FrameLayout root=(FrameLayout)findViewById(R.id.root);
//        root.addView(new MyView(GraphicsWidgetActivity.this));
//        root.addView(new PathView(GraphicsWidgetActivity.this));
        root.addView(new DrawTextView(GraphicsWidgetActivity.this));
    }
}
