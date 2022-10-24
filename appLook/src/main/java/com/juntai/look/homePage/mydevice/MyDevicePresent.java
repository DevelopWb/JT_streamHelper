package com.juntai.look.homePage.mydevice;

import com.juntai.look.AppNetModule;
import com.juntai.look.base.update.UpdatePresent;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.CameraTypeBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.bean.stream.GroupInfoBean;
import com.juntai.look.bean.stream.PermissionListBean;
import com.juntai.look.bean.stream.SharedLiveTypeBean;
import com.juntai.look.bean.stream.SharedUserBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.main.MainContract;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;
import com.juntai.wisdom.basecomponent.bean.RecordInfoBean;
import com.juntai.wisdom.basecomponent.bean.VideoInfoBean;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.mvp.IModel;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/30 11:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/30 11:03
 */
public class MyDevicePresent extends BasePresenter<IModel, MyDeviceContract.IMyDeviceView> implements MyDeviceContract.IMyDevicePresent {
    @Override
    protected IModel createModel() {
        return null;
    }

    @Override
    public void getVideoGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getCameraGroup(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraGroupBean>(getView()) {
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

    public void restartDev(String devctrltype, String channelid, String param, String tag) {
        AppNetModule.createrRetrofit()
                .restartDev(devctrltype, channelid, param)
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
    public void creatVideoGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .creatCameraGroup(requestBody)
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
    public void addCamera(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .addCamera(requestBody)
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
    public void saveCameraConfig(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .saveCameraConfig(requestBody)
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
    public void cameraType(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .cameraType(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraTypeBean>(getView()) {
                    @Override
                    public void onSuccess(CameraTypeBean o) {
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
    public void addNvrDev(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .addNvrDev(requestBody)
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
    public void getDevsOfGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getDevsOfGroup(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<DevListBean>(getView()) {
                    @Override
                    public void onSuccess(DevListBean o) {
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
    public void devManagerList(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .devManagerList(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<DevListBean>(getView()) {
                    @Override
                    public void onSuccess(DevListBean o) {
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
    public void getCamerasOfGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getCamerasOfGroup(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraListBean>(getView()) {
                    @Override
                    public void onSuccess(CameraListBean o) {
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
    public void getDevsOfNVR(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getDevsOfNVR(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraListBean>(getView()) {
                    @Override
                    public void onSuccess(CameraListBean o) {
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
    public void searchDevByNum(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .searchDevByNum(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<DevToAddBean>(getView()) {
                    @Override
                    public void onSuccess(DevToAddBean o) {
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
    public void transferDev(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .transferDev(requestBody)
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
    public void deleteDev(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .deleteDev(requestBody)
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
    public void deleteGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .deleteGroup(requestBody)
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
    public void updateGroupName(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .updateGroupName(requestBody)
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
    public void getGroupInfo(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getGroupInfo(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<GroupInfoBean>(getView()) {
                    @Override
                    public void onSuccess(GroupInfoBean o) {
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
    public void getPermissionList(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getPermissionList(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<PermissionListBean>(getView()) {
                    @Override
                    public void onSuccess(PermissionListBean o) {
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
    public void getSharedUserList(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getSharedUserList(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<SharedUserBean>(getView()) {
                    @Override
                    public void onSuccess(SharedUserBean o) {
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
    public void getUserListToShare(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getUserListToShare(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<SharedUserBean>(getView()) {
                    @Override
                    public void onSuccess(SharedUserBean o) {
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
    public void addShareAccount(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .addShareAccount(requestBody)
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
    public void delShareAccount(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .delShareAccount(requestBody)
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
    public void cancelShareAccount(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .cancelShareAccount(requestBody)
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
    public void delMyShare(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .delMyShare(requestBody)
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
    public void getSharedLiveType(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getSharedLiveType(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<SharedLiveTypeBean>(getView()) {
                    @Override
                    public void onSuccess(SharedLiveTypeBean o) {
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
    public void requestGlobalLive(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .requestGlobalLive(requestBody)
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
    public void closeGlobalLive(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .closeGlobalLive(requestBody)
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
    public void shareToWchat(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .shareToWchat(requestBody)
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
    public void operateDev(String chanpubid, String devctrltype, String param, String tag) {
        AppNetModule.createrRetrofit()
                .operateDev(chanpubid, devctrltype, param)
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
    public void rebootDev(String chanpubid, String devctrltype, String tag) {
        AppNetModule.createrRetrofit()
                .rebootDev(chanpubid, devctrltype)
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

//    @Override
//    public void preSet(String chanpubid, String tag) {
//        AppNetModule.createrRetrofit()
//                .preSet(chanpubid)
//                .compose(RxScheduler.ObsIoMain(getView()))
//                .subscribe(new BaseObserver<BaseStreamBean>(getView()) {
//                    @Override
//                    public void onSuccess(BaseStreamBean o) {
//                        if (getView() != null) {
//                            getView().onSuccess(tag, o);
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(String msg) {
//                        if (getView() != null) {
//                            getView().onError(tag, msg);
//                        }
//                    }
//                });
//    }

    @Override
    public void recordDownload(String chanpubid, String starttime, String endtime, String tag) {
        AppNetModule.createrRetrofit()
                .recordDownload(chanpubid, starttime, endtime, true)
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


}
