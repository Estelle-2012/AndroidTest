package com.example.estelle.activitydemo.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * @author Estelle
 * @Description: 创建、更新表
 * @Time:
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    Context mContext;

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name,
                              @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建
        String creatsql = "create datebase reactcontaete";
        Toast.makeText(mContext, "数据库创建", Toast.LENGTH_SHORT).show();
        //如果数据库不存在，则会调用onCreate方法，那么我们可以将表的创建工作放在这里面完成

        String sql = "create table info_tb (_id integer primary key autoincrement," +
                "name varhcar(20)," +
                "age integer, " +
                "gender varhcar(4) )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //升级
        Toast.makeText(mContext, "数据库升级", Toast.LENGTH_SHORT).show();
    }
}
