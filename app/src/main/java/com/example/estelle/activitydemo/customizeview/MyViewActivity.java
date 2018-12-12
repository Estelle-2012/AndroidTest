package com.example.estelle.activitydemo.customizeview;

import android.os.Bundle;

import com.example.estelle.activitydemo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Description: 我的自定义View
 * @Author: wb.huhuimin
 * @Time: 2018/12/12 17:02
 */
public class MyViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);
    }
}
