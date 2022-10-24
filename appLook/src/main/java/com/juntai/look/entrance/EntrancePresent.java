package com.juntai.look.entrance;

import com.juntai.look.AppNetModule;
import com.juntai.look.bean.LoginBean;
import com.juntai.look.entrance.sendcode.ISendCode;
import com.juntai.look.entrance.sendcode.SendCodeModel;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.mvp.IModel;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import cn.smssdk.SMSSDK;
import okhttp3.RequestBody;


/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/9 14:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/9 14:13
 */
public class EntrancePresent extends BasePresenter<IModel, EntranceContract.IEntranceView> implements EntranceContract.IEntrancePresent, ISendCode.IUpdateView {

    private SendCodeModel sendCodeModel;

    @Override
    protected IModel createModel() {
        return null;
    }

    public EntrancePresent() {
        sendCodeModel = new SendCodeModel(this);
    }

    @Override
    public void login(String username, String password, String tag) {
        AppNetModule
                .createrRetrofit()
                .login(username, password)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<LoginBean>(getView()) {
                    @Override
                    public void onSuccess(LoginBean o) {
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
    public void retrievePwd(RequestBody body, String tag) {
        AppNetModule
                .createrRetrofit()
                .retrievePwd(body)
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
    public void regist(RequestBody body, String tag) {
        AppNetModule
                .createrRetrofit()
                .regist(body)
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
    public void sendCheckCode(String mobile, String tempCode) {
        if (checkMobile(mobile)) {
            getCheckCodeFromNet(mobile,tempCode);
        }
    }

    /**
     * 初始化获取验证码
     */
    public void initGetTestCodeButtonStatus() {
        sendCodeModel.initGetTestCodeButtonStatus();
    }
    @Override
    public void receivedCheckCodeAndDispose() {
        sendCodeModel.receivedCheckCodeAndDispose();
    }
    /**
     * 从网络获取验证码
     *
     * @param mobile
     */
    public void getCheckCodeFromNet(String mobile,String tempCode) {
        // 请求验证码，其中country表示国家代码，如“86”；phone表示手机号码，如“13800138000”
        SMSSDK.getVerificationCode(tempCode,"+86", mobile);
    }

    @Override
    public void startTiming(long value) {
        if (getView() != null) {
            getView().updateSendCheckCodeViewStatus(value);
        }
    }

    @Override
    public void endTiming(long value) {
        if (getView() != null) {
            getView().updateSendCheckCodeViewStatus(value);
        }
    }

    @Override
    public void checkFormatError(String error) {
        if (getView() != null) {
            getView().checkFormatError(error);
        }
    }
    public void modifyPwd(RequestBody requestBody, String tag) {
        AppNetModule
                .createrRetrofit()
                .modifyPwd(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }
    /**
     * 检查手机号的格式
     */
    public boolean checkMobile(String mobile) {
        return sendCodeModel.checkMobile(mobile);
    }
}
