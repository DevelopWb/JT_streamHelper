package com.juntai.look.homePage.camera.ijkplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.MainThread;
import android.util.Log;
import android.util.TimeUtils;

import com.juntai.look.AppNetModule;
import com.juntai.look.base.OnBaseCallBack;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.bean.OpenLiveBean;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @aouther tobato
 * @description 描述  保活的服务
 * @date 2020/10/30 16:22
 */
public class KeepAliveService extends Service {

    private String sessionId;
    private BinderHolder binderHolder = new BinderHolder();
    private OnBaseCallBack onBaseCallBack;
    private Disposable disposable;

    @Override
    public IBinder onBind(Intent intent) {
        return binderHolder;
    }

    public void setOnBaseCallBack(OnBaseCallBack onBaseCallBack) {
        this.onBaseCallBack = onBaseCallBack;
    }

    public class BinderHolder extends Binder {
        public KeepAliveService getService() {
            return KeepAliveService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sessionId = intent.getStringExtra("sessionId");
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        disposable = Observable.interval(50, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        AppNetModule.createrRetrofit()
                                .keepAlive(sessionId)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new BaseObserver<OpenLiveBean>(null) {
                                    @Override
                                    public void onSuccess(OpenLiveBean openLiveBean) {
                                        Log.d("KeepAliveService", Thread.currentThread().getName());
                                        if (openLiveBean.getErrcode() < 0) {
                                            if (onBaseCallBack != null) {
                                                onBaseCallBack.callBack(null);
                                                if (disposable != null) {
                                                    disposable.dispose();
                                                }
                                            }
                                        }
                                    }

                                    @Override
                                    public void onError(String msg) {

                                    }
                                });
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("KeepAliveService", Thread.currentThread().getName());
                    }
                });


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("444444", "服务杀死");
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
