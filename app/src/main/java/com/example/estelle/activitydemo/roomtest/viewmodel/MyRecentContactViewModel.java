package com.example.estelle.activitydemo.roomtest.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;

import com.example.estelle.activitydemo.MyApplication;
import com.example.estelle.activitydemo.roomtest.db.DataRepository;
import com.example.estelle.activitydemo.roomtest.db.entity.MyRecentContactEntity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @Description: 
 * @Author: wb.huhuimin
 * @Time: 2018/10/23 18:36
 * @update: wb.huhuimin 2018/10/23 18:36
 */
public class MyRecentContactViewModel extends AndroidViewModel {
    final int cantactId;
    private final LiveData<MyRecentContactEntity> mObservableMyRecentContact;
    public ObservableField<MyRecentContactEntity> myRecentContact = new ObservableField<>();

    public MyRecentContactViewModel(@NonNull Application application
            , int cantactId, DataRepository repository) {
        super(application);
        this.cantactId = cantactId;
        mObservableMyRecentContact = repository.loadRecentContact(cantactId);
    }


    public LiveData<MyRecentContactEntity> getmObservableMyRecentContact() {
        return mObservableMyRecentContact;
    }

    public void setMyRecentContact(ObservableField<MyRecentContactEntity> myRecentContact) {
        this.myRecentContact = myRecentContact;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final int mProductId;

        private final DataRepository mRepository;

        public Factory(@NonNull Application application, int productId) {
            mApplication = application;
            mProductId = productId;
            mRepository = ((MyApplication) application).getRepository();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new MyRecentContactViewModel(mApplication, mProductId, mRepository);
        }
    }

}
