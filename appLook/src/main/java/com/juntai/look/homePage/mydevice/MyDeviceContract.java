package com.juntai.look.homePage.mydevice;

import com.juntai.wisdom.basecomponent.mvp.BaseIView;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.QueryMap;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/21 16:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/21 16:05
 */
public interface MyDeviceContract {
    String CAMERAS_OF_NVR_1 = "1";//列表模式  nvr下的摄像头  只显示已添加的摄像头
    String CAMERAS_OF_NVR_2 = "2";//添加设备  所有添加和未添加的摄像头
    String DEFAULT_GROUP_NAME_1 = "我的家";//我的家
    String DEFAULT_GROUP_NAME_2 = "分享给我的";//
    /**
     * 查询视频分组
     */
    String CAMERA_GROUP = "/getVideoGroup.shtml";
    String GROUP_INFO = "/getVideoGinfo.shtml";

    /**
     * 创建视频分组
     */
    String ADD_CAMERA_GROUP = "/addVideoGroup.shtml";
    String ADD_CAMERA = "/addVideo.shtml";
    String ADD_NVR = "/addNVR.shtml";
    /**
     * 转入设备
     */
    String TRANSFER_DEV = "/transfer.shtml";

    String DEL_DEV = "/deleteVideo.shtml";
    String RESTART_DEV = "/restart.shtml";
    String CANCEL_DEV = "/cancelteVideo.shtml";
    String DEL_MY_SHARE= "/deletemyshare.shtml";
    String DOWNLOAD= "/download.shtml";
    String DEL_ACCOUNT = "/deleteaccount.shtml";
    String DEL_GROUP = "/deletegroup.shtml";
    String SAVE_CONFIG = "/saveconfig.shtml";
    String SHARED_USERS = "/shared.shtml";
    String MY_SHARE = "/myshare.shtml";
    String SHARED_TYPE = "/sharedtype.shtml";
    String SHARED_LIVE = "/sharedlibe.shtml";
    String DELETE_LIVE = "/deletesharedlibe.shtml";
    String CAMERAS_OF_NVR = "/camerasofnvr.shtml";
    String SHARE_TO_WCHAT = "/addWechatShare.shtml";
    interface IMyDeviceView extends BaseIView {
    }

    interface IMyDevicePresent {
        /**
         * 获取摄像头分组
         *
         * @param requestBody
         * @param tag
         */
        void getVideoGroup(RequestBody requestBody, String tag);

        /**
         * 创建摄像头分组
         *
         * @param requestBody
         * @param tag
         */
        void creatVideoGroup(RequestBody requestBody, String tag);

        /**
         * 添加摄像头
         *
         * @param requestBody
         * @param tag
         */
        void addCamera(RequestBody requestBody, String tag);

        /**
         * 保存摄像头配置
         *
         * @param requestBody
         * @param tag
         */
        void saveCameraConfig(RequestBody requestBody, String tag);

        /**
         * 摄像头类型
         *
         * @param requestBody
         * @param tag
         */
        void cameraType(RequestBody requestBody, String tag);

        /**
         * 添加NVR
         *
         * @param requestBody
         * @param tag
         */
        void addNvrDev(RequestBody requestBody, String tag);


        /**
         * 获取分组下的设备列表
         *
         * @param requestBody
         * @param tag
         */
        void getDevsOfGroup(RequestBody requestBody, String tag);
        /**
         * 个人中心 设备管理列表
         *
         * @param requestBody
         * @param tag
         */
        void devManagerList(RequestBody requestBody, String tag);

        /**
         * 获取分组下的设备列表(不含nvr)
         *
         * @param requestBody
         * @param tag
         */
        void getCamerasOfGroup(RequestBody requestBody, String tag);

        /**
         * 获取nvr下的设备列表
         *
         * @param requestBody
         * @param tag
         */
        void getDevsOfNVR(RequestBody requestBody, String tag);

        /**
         * 设备搜索（搜索设备序列号）接口
         *
         * @param requestBody
         * @param tag
         */
        void searchDevByNum(RequestBody requestBody, String tag);

        /**
         * 转入设备
         *
         * @param requestBody
         * @param tag
         */
        void transferDev(RequestBody requestBody, String tag);

        /**
         * 删除设备
         *
         * @param requestBody
         * @param tag
         */
        void deleteDev(RequestBody requestBody, String tag);

        /**
         * 删除分组
         *
         * @param requestBody
         * @param tag
         */
        void deleteGroup(RequestBody requestBody, String tag);

        /**
         * 分组名称修改
         *
         * @param requestBody
         * @param tag
         */
        void updateGroupName(RequestBody requestBody, String tag);
        /**
         * 分组详情
         *
         * @param requestBody
         * @param tag
         */
        void getGroupInfo(RequestBody requestBody, String tag);

        /**
         * 权限列表
         *
         * @param requestBody
         * @param tag
         */
        void getPermissionList(RequestBody requestBody, String tag);

        /**
         * 被分享的账号列表
         *
         * @param requestBody
         * @param tag
         */
        void getSharedUserList(RequestBody requestBody, String tag);
        /**
         *
         *查找待分享的账号列表
         * @param requestBody
         * @param tag
         */
        void getUserListToShare(RequestBody requestBody, String tag);
        /**
         *
         * @param requestBody
         * @param tag
         */
        void addShareAccount(RequestBody requestBody, String tag);


        /**
         *
         * @param requestBody
         * @param tag
         */
        void delShareAccount(RequestBody requestBody, String tag);


        /**
         *
         * @param requestBody
         * @param tag
         */
        void cancelShareAccount(RequestBody requestBody, String tag);

        /**
         *
         * @param requestBody
         * @param tag
         */
        void delMyShare(RequestBody requestBody, String tag);


        /**
         * 视频直播类型
         *
         * @param requestBody
         * @param tag
         */
        void getSharedLiveType(RequestBody requestBody, String tag);
        /**
         * 全球直播申请
         *
         * @param requestBody
         * @param tag
         */
        void requestGlobalLive(RequestBody requestBody, String tag);
        /**
         * 全球直播申请
         *
         * @param requestBody
         * @param tag
         */
        void closeGlobalLive(RequestBody requestBody, String tag);
        /**
         * 分享至微信
         *
         * @param requestBody
         * @param tag
         */
        void shareToWchat(RequestBody requestBody, String tag);
        /**
         * 设备控制
         *
         * @return
         */
        void operateDev(String chanpubid, String devctrltype, String param,String tag);
//        /**
//         * 预置位
//         *
//         * @return
//         */
//        void preSet(String chanpubid,String tag);
        /**
         * 录像下载
         *
         * @return
         */
        void recordDownload(String chanpubid, String starttime, String endtime,String tag);

    }

}
