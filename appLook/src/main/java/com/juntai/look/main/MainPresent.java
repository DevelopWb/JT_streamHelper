package com.juntai.look.main;

import com.juntai.look.AppNetModule;
import com.juntai.look.base.update.UpdatePresent;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.mvp.IModel;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/30 11:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/30 11:03
 */
public class MainPresent extends UpdatePresent implements MainContract.IMainPresent {
    @Override
    protected IModel createModel() {
        return null;
    }


    public void getWeatherRealTime(String tag, String lng, String lat) {
        AppNetModule.createrRetrofit()
                .getWeatherRealtime(lng, lat)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<ResponseRealTimeWeather>(getView()) {
                    @Override
                    public void onSuccess(ResponseRealTimeWeather o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag, msg);
                        }
                    }
                });
    }

    public void getVideoGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getCameraGroup(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraGroupBean>(null) {
                    @Override
                    public void onSuccess(CameraGroupBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag, msg);
                        }
                    }
                });
    }

}
