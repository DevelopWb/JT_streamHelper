package com.juntai.look.entrance.sendcode;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:wang_sir
 * Time:2018/7/16 18:18
 * Description:This is SendCodeModel
 */
public class SendCodeModel implements ISendCode {


    private ISendCode.IUpdateView iUpdateView;
    private Disposable disposable;

    public SendCodeModel(IUpdateView iUpdateView) {
        this.iUpdateView = iUpdateView;
        // 注册一个事件回调，用于处理SMSSDK接口请求的结果
        SMSSDK.registerEventHandler(eventHandler);
    }

    EventHandler eventHandler = new EventHandler() {
        public void afterEvent(int event, int result, Object data) {
            // afterEvent会在子线程被调用，因此如果后续有UI相关操作，需要将数据发送到UI线程
            Message msg = new Message();
            msg.arg1 = event;
            msg.arg2 = result;
            msg.obj = data;
            new Handler(Looper.getMainLooper(), new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    int event = msg.arg1;
                    int result = msg.arg2;
                    Object data = msg.obj;
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
//                            ToastUtils.success(mContext,"发送成功");
                            //  处理成功得到验证码的结果
                        } else {
                            //  处理错误的结果
                            ((Throwable) data).printStackTrace();
                        }
                    } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
//                            isVerifyed = true;
//                            submit();
                            //  处理验证码验证通过的结果
                        } else {
                            //  处理错误的结果
                            ((Throwable) data).printStackTrace();
                        }
                    }
                    //  其他接口的返回结果也类似，根据event判断当前数据属于哪个接口
                    return false;
                }
            }).sendMessage(msg);
        }
    };
    @Override
    public void initGetTestCodeButtonStatus() {
        disposable = Observable.interval(0, 1000, TimeUnit.MILLISECONDS)
                .take(60)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (iUpdateView != null) {
                            iUpdateView.startTiming(59 - aLong);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                    }
                });
    }

    @Override
    public void receivedCheckCodeAndDispose() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    /**
     * 检查手机号的格式
     */
    public boolean checkMobile(String mobile) {
        if (mobile == null || TextUtils.isEmpty(mobile)) {
            if (iUpdateView != null) {
                iUpdateView.checkFormatError("手机号码不能为空");
            }

            return false;
        }
        if (!isMobileNO(mobile)) {
            if (iUpdateView != null) {
                iUpdateView.checkFormatError("手机号码格式不正确");
            }
            return false;
        }
        return true;

    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][23456789]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        return !TextUtils.isEmpty(mobiles) && mobiles.matches(telRegex);
    }
}
