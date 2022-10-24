package com.juntai.look.mine;

import com.juntai.wisdom.basecomponent.mvp.BaseIView;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/16 16:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/16 16:15
 */
public interface MineContract {
    /**
     * 个人基本信息
     */
     String USER_INFO =  "/u/appConnector/getUserInfoById.shtml";
     String UNREAD_MSG =  "/u/appConnector/unread.shtml";
     String READ_MSG =  "/u/appConnector/read.shtml";


    /**
     * 检查更新
     */
     String APP_UPDATE =  "/u/appConnector/detectionAppVersions.shtml";
    /**
     * 修改用户密码
     */
     String MODIFY_PWD =  "/u/appConnector/updateUserPassWord.shtml";
    /**
     * 修改用户头像
     */
     String MODIFY_HEAD_ICON =  "/u/appConnector/updateUserHead.shtml";
    /**
     * 我的消息
     */
     String MY_NOTICE =  "/u/appConnector/getMsgList.shtml";
    /**
     * 全部已读
     */
     String READ_ALL =  "/u/appConnector/allRead.shtml";
    String MINE_DEV_MANAGER = "设备管理";//
    String MINE_MSG = "我的消息";//
    String MINE_SHARE = "我的分享";//
    String MINE_MODIFY_PWD = "修改密码";//
    String MINE_CLEAR = "清理缓存";//
    String MINE_UPDATE = "检查更新";//
    String MINE_ABOUT_US = "关于我们";//
    String LOGOUT = "logout";//
    String SERVICE_RECORD = "SERVICE_RECORD";//

    interface IMineView extends BaseIView {

    }


    interface IMinePresent {
        /**
         * 注销登录
         * @param requestBody
         * @param tag
         */
        void  logout(RequestBody requestBody,String tag);

        /**
         * 个人基本信息
         * @param map
         * @param tag
         */
        void getUserBaseInfo(Map<String,String> map, String tag);
        /**
         * 更改头像
         * @param requestBody
         * @param tag
         */
        void modifyHeadIcon(RequestBody requestBody,String tag);
        /**
         * 更改密码
         * @param requestBody
         * @param tag
         */
        void modifyPwd(RequestBody requestBody,String tag);
        /**
         * 我的分享
         * @param requestBody
         * @param tag
         */
        void myShare(RequestBody requestBody,String tag);
        /**
         * 删除分享
         * @param requestBody
         * @param tag
         */
        void delShare(RequestBody requestBody,String tag);

    }
}
