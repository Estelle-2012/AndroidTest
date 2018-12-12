package com.example.estelle.activitydemo.rxjavatest;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.estelle.activitydemo.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class RxjavaTestActivity extends AppCompatActivity {
    Context mContext;

    static final String TAG = "RxjavaTestActivity";

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_rxjavatest);
        ButterKnife.bind(this);


    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    //Tip：当涉及绑定多个id事件时，我们可以使用Android studio的Butterknife
    //插件zelezny快速自动生成的，之后在下面会有介绍安装插件与使用
    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                rxjava2test();
                break;
            case R.id.button2:
                rxjavaflowabletest();
                break;
        }
//        rxjava1test();
    }

//    void rxjava1test() {
//        //初始化一个Observable
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                if (!subscriber.isUnsubscribed()) {
//                    subscriber.onNext("\ttest");
//                    subscriber.onCompleted();
//
//                }
//
//            }
//        });
//
//        Subscription subscription = observable.subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                Log.e(TAG, "onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.e(TAG, "onNext" + s);
//            }
//        });
//
//    }

    //不处理背压问题
    void rxjava2test() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext("\ttest");
                    emitter.onComplete();
                }

            }
        });

        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext" + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        });
    }

    //处理背压问题
    void rxjavaflowabletest() {
        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                if (!emitter.isCancelled()) {
                    emitter.onNext("\t flowabletest");
                    emitter.onComplete();
                }
            }
        }, BackpressureStrategy.DROP);

        flowable.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);//响应式拉取
                Log.e(TAG, "onSubscribe");

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext" + s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        });
    }
}
