package com.juntai.look.entrance;

import com.juntai.wisdom.basecomponent.mvp.BaseIView;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/9 14:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/9 14:08
 */
public interface EntranceContract {

    String LOGIN = "login";
    String REGIST = "regist";
    String RETRIEVE_PWD = "retrievePwd";

    interface IEntranceView extends BaseIView {
        /**
         * 接收到验证码后更改view得状态
         *
         * @param second
         */
        void updateSendCheckCodeViewStatus(long second);

        /**
         * 校验手机号错误
         *
         * @param error
         */
        void checkFormatError(String error);
    }

    interface IEntrancePresent {
        /**
         * 登录
         * @param username
         * @param password
         * @param tag
         */
        void login(String username, String password,String tag);
        /**
         * 找回密码
         * @param tag
         */
        void retrievePwd(RequestBody body,String tag);

        /**
         * 注册
         * @param body
         * @param tag
         */
        void regist(RequestBody body, String tag);

        /**
         * 发送验证码
         *
         * @param mobile
         * @param tempCode 短信模板
         */
        void sendCheckCode(String mobile,String tempCode);

        /**
         * 接收到验证码了 将observerble dispose
         */
        void receivedCheckCodeAndDispose();
    }
}
