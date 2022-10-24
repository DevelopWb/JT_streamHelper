package com.juntai.look;

public class AppHttpPath {
    /**
     * base
     */
    //    public static final String BASE = "http://kb167.cn:25080/zhcl";
    /**
     * base
     */
    //    public static final String BASE_IMAGE = "http://image.kb167.cn/";
    public static final String BASE_IMAGE = "http://61.156.157.132:8092";
    /**
     * 流媒体缩略图地址
     */
    public static final String THUMB_ADDR = "http://61.156.157.132:8092/thumbnail/";
//    /**
//     * 测试接口
//     */
//    public static final String BASE = "http://192.168.124.115:8080/streamingMedia/u/app";
    /**
     * 测试接口
     */
    public static final String BASE = "http://61.156.157.132:35080/streamingMedia/u/app";

    /**
     * 测试接口
     */
    public static final String HEAD_PIC_BASE_URL = "https://www.dgjpcs.cn/server/dongGuanPoliceStation/u/webAlarm";

    /*==============================================  天气  =============================================*/

    //实时天气
    public static final String REALTIME_WEATHER = BASE + "/getRealTimeWeather.shtml";
    //天气预报
    public static final String FORCAST_WEATHER = BASE + "/getForecastWeather.shtml";
    //获取省份
    public static final String PROVINCE = BASE + "/getProvince.shtml";
    //获取城市 u/apiAppAlarm/getProvince.shtml
    public static final String CITY = BASE + "/getCity.shtml";
    //获取地区 u/apiAppAlarm/getProvince.shtml
    public static final String AREA = BASE + "/getArea.shtml";
    //获取街道
    public static final String STREET = BASE + "/getStreet.shtml";






    /*==============================================  流媒体相关  =============================================*/


    //摄像头拉流地址
    public static final String BASE_CAMERA_URL = "http://www.juntaikeji.net:8060";

    /**
     * 硬盘录像机下面的摄像头列表
     */
    public static final String STREAM_CAMERAS_FROM_VCR = BASE + "/u/camera/selectCameraByDvrIdAPP.shtml?";


    /**
     * 视频广场
     */
    public static final String STREAM_CAMERAS = BASE + "/getVideoSquare.shtml";
    /**
     * 获取视频播放地址
     */
    public static final String STREAM_OPE_ADDR = BASE + "/getVideoOpenStream.shtml";


    /**
     * 上传封面图
     */
    public static final String UPLOAD_STREAM_CAMERAS_THUMB = BASE + "/uploadVideoEzopen.shtml";


    //    /**
    //     * 摄像头缩略图
    //     */
    //    public static final String THUMB_ADDR = "https://www.juntaikeji.com:17002/cameraImg/thumbnail/";


    /**
     * 摄像头详情
     */
    public static final String STREAM_CAMERAS_DETAIL = BASE + "/getVideoInfo.shtml";


    /**
     * 查询视频分组
     */
    public static final String CAMERA_GROUP = BASE + "/getVideoGroup.shtml";

    /**
     * 创建视频分组
     */
    public static final String ADD_CAMERA_GROUP = BASE + "/addVideoGroup.shtml";

    /**
     * 创建视频
     */
    public static final String ADD_CAMERA = BASE + "/addVideo.shtml";
    /**
     * 保存视频设置  也可以用于nvr名称修改
     */
    public static final String SAVE_CAMERA_CONFIG = BASE + "/updateVideo.shtml";
    /**
     * 视频leixing
     */
    public static final String CAMERA_TYPE = BASE + "/getVideoType.shtml";
    /**
     * 创建NVR设备
     */
    public static final String ADD_NVR_DEV = BASE + "/addDvr.shtml";


    /**
     * 删除设备
     */
    public static final String DEL_DEV = BASE + "/deleteVideo.shtml";

    /**
     * 转入设备到分组
     */
    public static final String TRSFER_TO_GROUP = BASE + "/shiftVideoGroup.shtml";

    /**
     * 删除分组
     */
    public static final String DEL_GROUP = BASE + "/deleteGroup.shtml";
    /**
     * 更新分组名称
     */
    public static final String UPDATE_GROUP_NAME = BASE + "/updateGroup.shtml";
    /**
     * 分组详情
     */
    public static final String GROUP_INFO = BASE + "/getGroupInfo.shtml";
    /**
     * 设备搜索（搜索设备序列号）接口
     */
    public static final String SEARCH_DEV_NUM = BASE + "/searchSerialNumber.shtml";


    /**
     * 列表模式
     * 获取分组下对应的设备(包含nvr)
     */
    public static final String GET_DEVS_OF_GROUP = BASE + "/getListModel.shtml";
    /**
     * 分组设置  后期逻辑修改了  和列表模式的逻辑一样
     */
    public static final String GET_CAMERAS_OF_GROUP = BASE + "/getVideoBelongGroup.shtml";

    /**
     * 获取硬盘录像机下对应的设备
     */
    public static final String GET_DEVS_OF_NVR = BASE + "/getVideoBelongDvr.shtml";




    /*==============================================  搜索  =============================================*/
    /**
     * 搜索
     */
    public static final String SEARCH = BASE + "/search.shtml";


    /**
     * 搜索更多
     */
    public static final String SEARCH_MORE = BASE + "/searchMore.shtml";





    /*==============================================  登录注册  =============================================*/


    /**
     * 登录
     */
    public static final String LOGIN = BASE + "/login.shtml";
    /**
     * 找回密码
     */
    public static final String RETRIEV_PWD = BASE + "/retrievePassword.shtml";
    /**
     * 注册
     */
    public static final String REGIST = BASE + "/register.shtml";

    /**
     * 上传位置信息
     */
    public static final String UPLOAD_LOCATION = BASE + "/u/appConnector/insertUserHistory.shtml";




    /*====================================================
    我的=============================================================*/


    /**
     * 退出登录
     */
    public static final String LOG_OUT = BASE + "/logout.shtml";

    /**
     * 个人基本信息
     */
    public static final String USER_INFO = BASE + "/getUserInfo.shtml";


    /**
     * 检查更新
     */
    public static final String APP_UPDATE = BASE + "/getAppVersions.shtml";
    /**
     * 修改用户密码
     */
    public static final String MODIFY_PWD = BASE + "/updatePassword.shtml";
    /**
     * 修改用户头像
     */
    public static final String MODIFY_HEAD_ICON = HEAD_PIC_BASE_URL+"/updateHeadImg.shtml";


    /*==============================================  个人中心  =============================================*/


    /**
     * 我的分享
     */
    public static final String MY_SHARE = BASE + "/getUserShare.shtml";
    /**
     * 删除分享
     */
    public static final String DEL_SHARE = BASE + "/deleteUserShare.shtml";
    /**
     * 设备管理列表
     */
    public static final String DEV_MANAGER_LIST = BASE + "/getUserEquipment.shtml";






    /*==============================================  分享  =============================================*/

    /**
     * 权限列表
     */
    public static final String VEDIO_PERMISSION_LIST = BASE + "/getVideoSharePower.shtml";
    /**
     * 被分享的好友
     */
    public static final String SHARED_USERS = BASE + "/getVideoShare.shtml";
    /**
     * 查找账号列表
     */
    public static final String SEARCH_USERS_TO_SHARE = BASE + "/searchVideoShare.shtml";
    /**
     * 添加分享的账号
     */
    public static final String ADD_SHARE_ACCOUNT = BASE + "/addVideoShare.shtml";
    /**
     * 删除分享的账号
     */
    public static final String DEL_SHARE_ACCOUNT = BASE + "/deleteVideoShare.shtml";
    /**
     * 取消分享
     */
    public static final String CANCEL_SHARE = BASE + "/cancelVideoShare.shtml";
    /**
     * 删除我的分享
     */
    public static final String DEL_MY_SHARE = BASE + "/deleteUserShare.shtml";

    /**
     * 分享类型
     */
    public static final String SHARED_LIVE_TYPE = BASE + "/getVideoShareType.shtml";
    /**
     * 全球直播申请
     */
    public static final String GLOBAL_LIVE_REQUEST = BASE + "/auditVideoShare.shtml";
    /**
     * 全球直播申请
     */
    public static final String CLOSE_GLOBAL_LIVE = BASE + "/closeVideoShare.shtml";
    /**
     * 分享到微信
     */
    public static final String SHARE_TO_WCHAT = BASE + "/addWechatShare.shtml";




    /*==============================================  云台预置位  =============================================*/
    /**
     * 添加预置位
     */
    public static final String ADD_PRE_POSITION = BASE + "/addVideoPTZCollect.shtml";


    /**
     * 删除预置位
     */
    public static final String DEL_PRE_POSITION = BASE + "/deleteVideoPTZCollect.shtml";


    /**
     * 查询预置位
     */
    public static final String GET_PRE_POSITIONS = BASE + "/getVideoPTZCollect.shtml";








    /*==============================================  厂家api  =============================================*/

    /**
     * 录像下载
     */
    public static final String RECORD_DOWNLOAD = BASE_CAMERA_URL + "/vss/playback/start?";
    /**
     * 操作设备
     */
    public static final String OPERATE_DEV = BASE_CAMERA_URL + "/vss/device/control?";
    /**
     * 获取当前在线数
     */
    public static final String GET_ONLINE_AMOUNT = BASE_CAMERA_URL + "/vss/getcallinfo?";
    /**
     * 停止当前的播放流
     * http://www.jthw110.cn:8060/vss/stream/stop?sessionid=http-1295687-1603349681-834
     */
    public static final String STOP_STREAM = BASE_CAMERA_URL + "/vss/stream/stop?";


}
