package com.example.designpattern.startegypattern;

import android.widget.Toast;

import com.example.designpattern.MyApplication;

/**
 * @author wb.huhuimin
 * @Description: [功能描述]
 * @Time: [序号]${date} ${time}
 */
public class Stattegy3 implements I_Startegy {
    @Override
    public void startegy() {
        Toast.makeText(MyApplication.mContext, "Stattegy33333", Toast.LENGTH_SHORT).show();
    }
}
