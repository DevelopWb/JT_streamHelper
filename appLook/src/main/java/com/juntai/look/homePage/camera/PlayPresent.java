package com.juntai.look.homePage.camera;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import com.juntai.look.AppNetModule;
import com.juntai.look.bean.stream.CameraOnlineBean;
import com.juntai.look.bean.stream.PreSetBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;
import com.juntai.wisdom.basecomponent.bean.CaptureBean;
import com.juntai.wisdom.basecomponent.bean.OpenLiveBean;
import com.juntai.wisdom.basecomponent.bean.PlayUrlBean;
import com.juntai.wisdom.basecomponent.bean.RecordInfoBean;
import com.juntai.wisdom.basecomponent.bean.VideoInfoBean;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.mvp.IModel;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import java.text.SimpleDateFormat;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/5/30 9:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/5/30 9:49
 */
public class PlayPresent extends BasePresenter<IModel, PlayContract.IPlayView> implements PlayContract.IPlayPresent {
    @Override
    protected IModel createModel() {
        return null;
    }


    @Override
    public void openStream(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .openStream(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<PlayUrlBean>(null) {
                    @Override
                    public void onSuccess(PlayUrlBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o.getData());
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

    /**
     * 获取builder
     *
     * @return
     */
    public MultipartBody.Builder getPublishMultipartBody() {
        return new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("account", UserInfoManager.getUserAccount())
                .addFormDataPart("token", UserInfoManager.getUserToken())
                .addFormDataPart("uid", String.valueOf(UserInfoManager.getUserId()));
    }

    @Override
    public void capturePic(String channelid, String type, String tag) {
        AppNetModule.createrRetrofit()
                .capturePic(channelid, type)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CaptureBean>(getView()) {
                    @Override
                    public void onSuccess(CaptureBean o) {
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

    @Override
    public void getStreamCameraDetail(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getStreamCameraDetail(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<StreamCameraDetailBean>(null) {
                    @Override
                    public void onSuccess(StreamCameraDetailBean o) {
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


    @Override
    public void uploadStreamCameraThumbPic(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .uploadStreamCameraThumbPic(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(null) {
                    @Override
                    public void onSuccess(BaseResult o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o.message);
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

    @Override
    public void searchVideos(String begintime, String endtime, String channelid, String tag) {
        AppNetModule.createrRetrofit()
                .searchVideos(begintime, endtime, channelid)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<VideoInfoBean>(getView()) {
                    @Override
                    public void onSuccess(VideoInfoBean o) {
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

    @Override
    public void operateYunTai(String ptztype, int ptzparam, String channelid, String tag) {
        AppNetModule.createrRetrofit()
                .operateYunTai(ptztype, ptzparam, channelid)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseStreamBean>(getView()) {
                    @Override
                    public void onSuccess(BaseStreamBean o) {
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

    @Override
    public void playHisVideo(Map<String, String> queryMap, String tag) {
        AppNetModule.createrRetrofit()
                .getVideosUrl(queryMap)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<RecordInfoBean>(getView()) {
                    @Override
                    public void onSuccess(RecordInfoBean o) {
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

    @Override
    public void operateRecordVideo(String sessionid, String vodctrltype, String vodctrlparam, String tag) {
        AppNetModule.createrRetrofit()
                .operateRecordVideo(sessionid, vodctrltype, vodctrlparam)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseStreamBean>(getView()) {
                    @Override
                    public void onSuccess(BaseStreamBean o) {
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

    @Override
    public void addPrePosition(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .addPrePosition(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
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
    @Override
    public void delPrePosition(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .delPrePosition(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
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

    @Override
    public void getPrePositions(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getPrePositions(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<PreSetBean>(getView()) {
                    @Override
                    public void onSuccess(PreSetBean o) {
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

    @Override
    public void getOnlineAmount(String parameter, String tag) {
        AppNetModule.createrRetrofit()
                .getOnlineAmount(parameter)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraOnlineBean>(getView()) {
                    @Override
                    public void onSuccess(CameraOnlineBean o) {
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
    @Override
    public void stopStream(String sessionid, String tag) {
        AppNetModule.createrRetrofit()
                .stopStream(sessionid)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseStreamBean>(getView()) {
                    @Override
                    public void onSuccess(BaseStreamBean o) {
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



    /**
     * @param oldTime
     * @return
     */
    public String formatTimeToYun(long oldTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(oldTime);
        return time.replace(" ", "T");
    }

    /**
     * 配置view的margin属性
     */
    public void setMarginOfConstraintLayout(View view, Context context, int left, int top, int right, int bottom) {
        left = DisplayUtil.dp2px(context, left);
        top = DisplayUtil.dp2px(context, top);
        right = DisplayUtil.dp2px(context, right);
        bottom = DisplayUtil.dp2px(context, bottom);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.setMargins(left, top, right, bottom);
        view.setLayoutParams(layoutParams);
    }
}
