package com.juntai.look;


import com.juntai.look.bean.CityBean;
import com.juntai.look.bean.UserBaseMsgBean;
import com.juntai.look.bean.careTaker.ServiceTypeBean;
import com.juntai.look.bean.LoginBean;
import com.juntai.look.bean.ServicePeoplePositionBean;
import com.juntai.look.bean.ServiceRecordBean;
import com.juntai.look.bean.search.SearchBean;
import com.juntai.look.bean.careTaker.SearchedPeopleBean;
import com.juntai.look.bean.careTaker.ServicePeoplesBean;
import com.juntai.look.bean.careTaker.StreetBean;
import com.juntai.look.bean.careTaker.YearsBean;
import com.juntai.look.bean.mine.MyMsgBean;
import com.juntai.look.bean.mine.MyShareBean;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.search.SearchResultBean;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.CameraOnlineBean;
import com.juntai.look.bean.stream.CameraTypeBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.bean.stream.GroupInfoBean;
import com.juntai.look.bean.stream.PermissionListBean;
import com.juntai.look.bean.stream.PreSetBean;
import com.juntai.look.bean.stream.SharedLiveTypeBean;
import com.juntai.look.bean.stream.SharedUserBean;
import com.juntai.look.bean.stream.StreamCameraBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.bean.weather.ResponseForcastWeather;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;
import com.juntai.wisdom.basecomponent.bean.CaptureBean;
import com.juntai.wisdom.basecomponent.bean.CareChildListNewestBean;
import com.juntai.wisdom.basecomponent.bean.OpenLiveBean;
import com.juntai.wisdom.basecomponent.bean.PlayUrlBean;
import com.juntai.wisdom.basecomponent.bean.RecordInfoBean;
import com.juntai.wisdom.basecomponent.bean.VideoInfoBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * responseBody里的数据只能调用(取出)一次，第二次为空。可赋值给新的变量使用
 */
public interface AppServer {



    /*==================================================== 登录接口
    ==============================================================*/

    /**
     * 登录
     */
    @POST(AppHttpPath.LOGIN)
    Observable<LoginBean> login(@Query("account") String account, @Query("password") String password);
    /**
     * 找回密码
     */
    @POST(AppHttpPath.RETRIEV_PWD)
    Observable<BaseResult> retrievePwd(@Body RequestBody requestBody);
    /**
     * 注册
     */
    @POST(AppHttpPath.REGIST)
    Observable<BaseResult> regist(@Body RequestBody requestBody);


    //实时天气
    @GET(AppHttpPath.REALTIME_WEATHER)
    Observable<ResponseRealTimeWeather> getWeatherRealtime(@Query("longitude") String longitude,
                                                           @Query("latitude") String latitude);

    //天气预报
    @GET(AppHttpPath.FORCAST_WEATHER)
    Observable<ResponseForcastWeather> getForcast(@Query("longitude") String longitude,
                                                  @Query("latitude") String latitude);

    @GET(AppHttpPath.PROVINCE)
    Observable<CityBean> getProvince();

    @GET(AppHttpPath.CITY)
    Observable<CityBean> getCity(@Query("cityNum") int cityNum);

    @GET(AppHttpPath.AREA)
    Observable<CityBean> getArea(@Query("cityNum") int cityNum);

    @GET(AppHttpPath.STREET)
    Observable<CityBean> getStreet(@Query("cityNum") int townNum);


    /*====================================================    流媒体
    ==============================================================*/


    /**
     * 获取所有的流摄像头
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS)
    Observable<StreamCameraBean> getAllStreamCameras(@Body RequestBody requestBody);


    /**
     * 获取硬盘录像机下的所有的流摄像头
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS_FROM_VCR)
    Observable<StreamCameraBean> getAllStreamCamerasFromVCR(@Body RequestBody requestBody);

    /**
     * 摄像头详情
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS_DETAIL)
    Observable<StreamCameraDetailBean> getStreamCameraDetail(@Body RequestBody requestBody);


    /**
     * 上传封面图
     *
     * @return
     */
    @POST(AppHttpPath.UPLOAD_STREAM_CAMERAS_THUMB)
    Observable<BaseResult> uploadStreamCameraThumbPic(@Body RequestBody requestBody);

    /**
     * 打开视频流
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_OPE_ADDR)
    Observable<PlayUrlBean> openStream(@Body RequestBody requestBody);

    /**
     * 会话id   保活的接口
     *
     * @param sessionid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/video_keepalive/{sessionid}")
    Observable<OpenLiveBean> keepAlive(@Path("sessionid") String sessionid);

    /**
     * 截图
     *
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/get_image/{channelid}/{type}")
    Observable<CaptureBean> capturePic(@Path("channelid") String channelid, @Path("type") String type);

    /**
     * 录像查询
     *
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/history_search/{begintime}/{endtime}/{channelid}")
    Observable<VideoInfoBean> searchVideos(@Path("begintime") String begintime, @Path("endtime") String endtime,
                                           @Path("channelid") String channelid);


    /**
     * 录像点播 获取rtmp流
     *
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/playback/start?")
    Observable<RecordInfoBean> getVideosUrl(@QueryMap Map<String, String> options);


    /**
     * 云台操控
     *
     * @param ptztype
     * @param ptzparam
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/ptz/{ptztype}/{ptzparam}/{channelid}")
    Observable<BaseStreamBean> operateYunTai(@Path("ptztype") String ptztype, @Path("ptzparam") int ptzparam,
                                             @Path("channelid") String channelid);


    /**
     * 录像控制
     * "sessionid":    (字符串) 点播返回的sessionid句柄
     * "vodctrltype":  (字符串) "play","pause","stop","jump"
     * "vodctrlparam": (字符串)  0(pause,stop) / 0.125,0.25,0.5,1,2,4,8,16(play) (范围:0-32)/ 从开始时间跳转的秒数(jump)
     *
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/his_stream_ctrl/{sessionid}/{vodctrltype}/{vodctrlparam}")
    Observable<BaseStreamBean> operateRecordVideo(@Path("sessionid") String sessionid,
                                                  @Path("vodctrltype") String vodctrltype,
                                                  @Path("vodctrlparam") String vodctrlparam);
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/device_ctrl/{devctrltype}/{channelid}/{param}")
    Observable<BaseStreamBean> restartDev(@Path("devctrltype") String devctrltype,
                                                  @Path("channelid") String channelid,
                                                  @Path("param") String param);


    @GET(AppHttpPath.OPERATE_DEV)
    Observable<BaseStreamBean> operateDev(@Query("chanpubid") String chanpubid,
                                          @Query("devctrltype") String devctrltype,
                                          @Query("param") String param);
    @GET(AppHttpPath.OPERATE_DEV)
    Observable<BaseStreamBean> rebootDev(@Query("chanpubid") String chanpubid,
                                          @Query("devctrltype") String devctrltype);

    /**
     * 获取在线数
     */
    @GET(AppHttpPath.GET_ONLINE_AMOUNT)
    Observable<CameraOnlineBean> getOnlineAmount(@Query("q") String q);
    /**
     * 获取在线数
     */
    @GET(AppHttpPath.STOP_STREAM)
    Observable<BaseStreamBean> stopStream(@Query("sessionid") String q);


    @GET(AppHttpPath.RECORD_DOWNLOAD)
    Observable<RecordInfoBean> recordDownload(@Query("chanpubid") String chanpubid,
                                              @Query("begintime") String begintime,
                                              @Query("endtime") String endtime,
                                              @Query("download") boolean download
    );


    /**
     * 获取摄像头分组
     *
     * @return
     */
    @POST(AppHttpPath.CAMERA_GROUP)
    Observable<CameraGroupBean> getCameraGroup(@Body RequestBody requestBody);

    /**
     * 创建摄像头分组
     *
     * @return
     */
    @POST(AppHttpPath.ADD_CAMERA_GROUP)
    Observable<BaseResult> creatCameraGroup(@Body RequestBody requestBody);

    /**
     * 添加摄像头
     *
     * @return
     */
    @POST(AppHttpPath.ADD_CAMERA)
    Observable<BaseResult> addCamera(@Body RequestBody requestBody);

    /**
     * 保存摄像头配置
     *
     * @return
     */
    @POST(AppHttpPath.SAVE_CAMERA_CONFIG)
    Observable<BaseResult> saveCameraConfig(@Body RequestBody requestBody);

    /**
     * CAMERA_TYPE
     *
     * @return
     */
    @POST(AppHttpPath.CAMERA_TYPE)
    Observable<CameraTypeBean> cameraType(@Body RequestBody requestBody);

    /**
     * 添加NVR 设备
     *
     * @return
     */
    @POST(AppHttpPath.ADD_NVR_DEV)
    Observable<BaseResult> addNvrDev(@Body RequestBody requestBody);

    /**
     * 获取分组下的摄像头
     *
     * @return
     */
    @POST(AppHttpPath.GET_DEVS_OF_GROUP)
    Observable<DevListBean> getDevsOfGroup(@Body RequestBody requestBody);

    /**
     * 获取分组下的摄像头(不含nvr)
     *
     * @return
     */
    @POST(AppHttpPath.GET_CAMERAS_OF_GROUP)
    Observable<CameraListBean> getCamerasOfGroup(@Body RequestBody requestBody);

    /**
     * 获取nvr下的摄像头
     *
     * @return
     */
    @POST(AppHttpPath.GET_DEVS_OF_NVR)
    Observable<CameraListBean> getDevsOfNVR(@Body RequestBody requestBody);

    /**
     * 设备搜索（搜索设备序列号）接口
     *
     * @return
     */
    @POST(AppHttpPath.SEARCH_DEV_NUM)
    Observable<DevToAddBean> searchDevByNum(@Body RequestBody requestBody);

    /**
     * 转入设备
     *
     * @return
     */
    @POST(AppHttpPath.TRSFER_TO_GROUP)
    Observable<BaseResult> transferDev(@Body RequestBody requestBody);

    /**
     * 删除设备
     *
     * @return
     */
    @POST(AppHttpPath.DEL_DEV)
    Observable<BaseResult> deleteDev(@Body RequestBody requestBody);

    /**
     * 删除分组
     *
     * @return
     */
    @POST(AppHttpPath.DEL_GROUP)
    Observable<BaseResult> deleteGroup(@Body RequestBody requestBody);

    /**
     * 分组名称更改
     *
     * @return
     */
    @POST(AppHttpPath.UPDATE_GROUP_NAME)
    Observable<BaseResult> updateGroupName(@Body RequestBody requestBody);

    /**
     * 分组详情
     *
     * @return
     */
    @POST(AppHttpPath.GROUP_INFO)
    Observable<GroupInfoBean> getGroupInfo(@Body RequestBody requestBody);





    /*==============================================  分享  =============================================*/


    /**
     * 分享的权限列表
     *
     * @return
     */
    @POST(AppHttpPath.VEDIO_PERMISSION_LIST)
    Observable<PermissionListBean> getPermissionList(@Body RequestBody requestBody);

    /**
     * 被分享的用户
     *
     * @return
     */
    @POST(AppHttpPath.SHARED_USERS)
    Observable<SharedUserBean> getSharedUserList(@Body RequestBody requestBody);

    /**
     * 查找待分享的账号
     *
     * @return
     */
    @POST(AppHttpPath.SEARCH_USERS_TO_SHARE)
    Observable<SharedUserBean> getUserListToShare(@Body RequestBody requestBody);

    /**
     * @return
     */
    @POST(AppHttpPath.ADD_SHARE_ACCOUNT)
    Observable<BaseResult> addShareAccount(@Body RequestBody requestBody);

    /**
     * @return
     */
    @POST(AppHttpPath.DEL_SHARE_ACCOUNT)
    Observable<BaseResult> delShareAccount(@Body RequestBody requestBody);

    /**
     * 取消分享
     *
     * @return
     */
    @POST(AppHttpPath.CANCEL_SHARE)
    Observable<BaseResult> cancelShareAccount(@Body RequestBody requestBody);

    /**
     * 删除我的分享
     *
     * @return
     */
    @POST(AppHttpPath.DEL_MY_SHARE)
    Observable<BaseResult> delMyShare(@Body RequestBody requestBody);

    /**
     * 分享直播类型
     *
     * @return
     */
    @POST(AppHttpPath.SHARED_LIVE_TYPE)
    Observable<SharedLiveTypeBean> getSharedLiveType(@Body RequestBody requestBody);

    /**
     * 全球直播申请
     *
     * @return
     */
    @POST(AppHttpPath.GLOBAL_LIVE_REQUEST)
    Observable<BaseResult> requestGlobalLive(@Body RequestBody requestBody);

    /**
     * 全球直播申请
     *
     * @return
     */
    @POST(AppHttpPath.CLOSE_GLOBAL_LIVE)
    Observable<BaseResult> closeGlobalLive(@Body RequestBody requestBody);
    /**
     * 分享至微信
     *
     * @return
     */
    @POST(AppHttpPath.SHARE_TO_WCHAT)
    Observable<BaseResult> shareToWchat(@Body RequestBody requestBody);


    /**
     * 退出登录
     */
    @POST(AppHttpPath.LOG_OUT)
    Observable<BaseResult> logout(@Body RequestBody requestBody);

    /**
     * 个人资料
     */
    @GET(AppHttpPath.USER_INFO)
    Observable<UserBaseMsgBean> persionalInfo(@QueryMap Map<String, String> options);

    /**
     * 修改头像
     */
    @POST(AppHttpPath.MODIFY_HEAD_ICON)
    Observable<BaseResult> modifyHeadIcon(@Body RequestBody requestBody);

    /**
     * 修改密码
     */
    @POST(AppHttpPath.MODIFY_PWD)
    Observable<BaseResult> modifyPwd(@Body RequestBody requestBody);

    /**
     * 我的分享
     */
    @POST(AppHttpPath.MY_SHARE)
    Observable<MyShareBean> myShare(@Body RequestBody requestBody);

    /**
     * 删除分享
     */
    @POST(AppHttpPath.DEL_SHARE)
    Observable<BaseResult> delShare(@Body RequestBody requestBody);


    /**
     * 设备管理列表
     */
    @POST(AppHttpPath.DEV_MANAGER_LIST)
    Observable<DevListBean> devManagerList(@Body RequestBody requestBody);








    /*==============================================  搜索  =============================================*/

    /**
     * 搜索
     */
    @POST(AppHttpPath.SEARCH)
    Observable<SearchBean> search(@Body RequestBody body);

    /**
     * 搜索
     */
    @POST(AppHttpPath.SEARCH_MORE)
    Observable<SearchResultBean> searchMore(@Body RequestBody body);





    /*==============================================  云台预置位  =============================================*/


    @POST(AppHttpPath.ADD_PRE_POSITION)
    Observable<BaseResult> addPrePosition(@Body RequestBody body);

    /**
     * 删除预置位
     *
     * @param body
     * @return
     */
    @POST(AppHttpPath.DEL_PRE_POSITION)
    Observable<BaseResult> delPrePosition(@Body RequestBody body);

    /**
     * 删除预置位
     *
     * @param body
     * @return
     */
    @POST(AppHttpPath.GET_PRE_POSITIONS)
    Observable<PreSetBean> getPrePositions(@Body RequestBody body);

}
