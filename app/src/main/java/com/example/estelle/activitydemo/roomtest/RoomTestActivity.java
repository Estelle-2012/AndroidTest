package com.example.estelle.activitydemo.roomtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.estelle.activitydemo.AppExecutors;
import com.example.estelle.activitydemo.MyApplication;
import com.example.estelle.activitydemo.R;
import com.example.estelle.activitydemo.databinding.ActivityRoomtestBinding;
import com.example.estelle.activitydemo.roomtest.db.AppDatabase;
import com.example.estelle.activitydemo.roomtest.ui.RoomTestCallback;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * @Description: 数据库更新
 * @Author: wb.huhuimin
 * @Time: 2018/10/22 16:32
 * @update: wb.huhuimin 2018/10/22 16:32
 */
public class RoomTestActivity extends AppCompatActivity implements RoomTestCallback {

    private ActivityRoomtestBinding bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_roomtest);
        bind.setCallback(this);
    }

    @Override
    public void add() {

    }

    @Override
    public void delect() {

    }

    @Override
    public void update() {

    }

    @Override
    public void select() {

    }

    @Override
    public void itemClick() {

    }
}
