package com.example.estelle.activitydemo.roomtest.db;

import com.example.estelle.activitydemo.roomtest.db.entity.MyRecentContactEntity;
import com.example.estelle.activitydemo.roomtest.db.model.MyRecentContact;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

/**
 * Repository handling the work with products and comments.
 */
public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<MyRecentContactEntity>> mObservableProducts;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableProducts = new MediatorLiveData<>();

    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }


    public LiveData<MyRecentContactEntity> loadRecentContact(final int productId) {
        return mDatabase.myRecentContactDao().loadProduct(productId);
    }

    public MyRecentContactEntity loadRecentContactSync(final int productId) {
        return mDatabase.myRecentContactDao().loadProductSync(productId);
    }
    public void delectRecentContactSync(MyRecentContactEntity myRecentContactEntity) {
         mDatabase.myRecentContactDao().delete(myRecentContactEntity);
    }
}
