package com.example.estelle.activitydemo.roomtest.db.dao;


import com.example.estelle.activitydemo.roomtest.db.entity.MyRecentContactEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * @author wb.huhuimin
 * @Description: [功能描述]
 * @Time: [序号]${date} ${time}
 */
@Dao
public interface MyRecentContactDao {
    @Query("SELECT * FROM MyRecentContactEntity")
    LiveData<List<MyRecentContactEntity>> loadAllMyRecentContactList();

    @Query("select * from MyRecentContactEntity where contactId = :productId")
    LiveData<MyRecentContactEntity> loadProduct(int productId);

    @Query("select * from MyRecentContactEntity where contactId = :productId")
    MyRecentContactEntity loadProductSync(int productId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MyRecentContactEntity> myRecentContactEntity);

    @Delete
    void delete(MyRecentContactEntity myRecentContactEntity);

}
