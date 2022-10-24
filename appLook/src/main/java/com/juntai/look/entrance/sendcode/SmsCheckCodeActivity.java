package com.juntai.look.entrance.sendcode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.utils.LogUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


/**
 * @aouther tobato 短信验证码接收
 * @description 描述
 * @date 2020/3/25 8:46
 */
public abstract class SmsCheckCodeActivity<P extends BasePresenter> extends BaseAppActivity<P> {

    protected boolean verify = false;//验证是否成功
    protected  String SMS_TEMP_CODE = "16132134";//模板编号
    EventHandler eventHandler = new EventHandler() {
        @Override
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
                            ToastUtils.success(SmsCheckCodeActivity.this, "发送成功");
                            initGetTestCodeButtonStatusStart();
                        } else if(result==SMSSDK.RESULT_ERROR){
                            //一天一个手机号只能接收10条短信
                            ToastUtils.error(SmsCheckCodeActivity.this, "一天一个手机号只能发送10次验证");
                        }else{
                            LogUtil.d("发送失败");
                            ((Throwable) data).printStackTrace();
                        }
                    } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            verify = true;
                            initGetTestCodeButtonStatusStop();
                            checkCodeSuccessed();
                        } else {
                            verify = false;
                            ToastUtils.error(SmsCheckCodeActivity.this, "验证码输入有误");
                            initGetTestCodeButtonStatusStop();
                            //  处理错误的结果
                            ((Throwable) data).printStackTrace();
                        }
                    }
                    // 其他接口的返回结果也类似，根据event判断当前数据属于哪个接口
                    return false;
                }
            }).sendMessage(msg);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注册一个事件回调，用于处理SMSSDK接口请求的结果
        SMSSDK.registerEventHandler(eventHandler);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }

    /**
     * 更改获取验证码按钮得状态
     */
    protected abstract void initGetTestCodeButtonStatusStart();

    protected abstract void initGetTestCodeButtonStatusStop();

    /**
     * 验证成功
     */
    protected abstract void checkCodeSuccessed();
}
