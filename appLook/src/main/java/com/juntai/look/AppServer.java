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
 * responseBody????????????????????????(??????)?????????????????????????????????????????????????????????
 */
public interface AppServer {



    /*==================================================== ????????????
    ==============================================================*/

    /**
     * ??????
     */
    @POST(AppHttpPath.LOGIN)
    Observable<LoginBean> login(@Query("account") String account, @Query("password") String password);
    /**
     * ????????????
     */
    @POST(AppHttpPath.RETRIEV_PWD)
    Observable<BaseResult> retrievePwd(@Body RequestBody requestBody);
    /**
     * ??????
     */
    @POST(AppHttpPath.REGIST)
    Observable<BaseResult> regist(@Body RequestBody requestBody);


    //????????????
    @GET(AppHttpPath.REALTIME_WEATHER)
    Observable<ResponseRealTimeWeather> getWeatherRealtime(@Query("longitude") String longitude,
                                                           @Query("latitude") String latitude);

    //????????????
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


    /*====================================================    ?????????
    ==============================================================*/


    /**
     * ???????????????????????????
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS)
    Observable<StreamCameraBean> getAllStreamCameras(@Body RequestBody requestBody);


    /**
     * ????????????????????????????????????????????????
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS_FROM_VCR)
    Observable<StreamCameraBean> getAllStreamCamerasFromVCR(@Body RequestBody requestBody);

    /**
     * ???????????????
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS_DETAIL)
    Observable<StreamCameraDetailBean> getStreamCameraDetail(@Body RequestBody requestBody);


    /**
     * ???????????????
     *
     * @return
     */
    @POST(AppHttpPath.UPLOAD_STREAM_CAMERAS_THUMB)
    Observable<BaseResult> uploadStreamCameraThumbPic(@Body RequestBody requestBody);

    /**
     * ???????????????
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_OPE_ADDR)
    Observable<PlayUrlBean> openStream(@Body RequestBody requestBody);

    /**
     * ??????id   ???????????????
     *
     * @param sessionid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/video_keepalive/{sessionid}")
    Observable<OpenLiveBean> keepAlive(@Path("sessionid") String sessionid);

    /**
     * ??????
     *
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/get_image/{channelid}/{type}")
    Observable<CaptureBean> capturePic(@Path("channelid") String channelid, @Path("type") String type);

    /**
     * ????????????
     *
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/history_search/{begintime}/{endtime}/{channelid}")
    Observable<VideoInfoBean> searchVideos(@Path("begintime") String begintime, @Path("endtime") String endtime,
                                           @Path("channelid") String channelid);


    /**
     * ???????????? ??????rtmp???
     *
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/playback/start?")
    Observable<RecordInfoBean> getVideosUrl(@QueryMap Map<String, String> options);


    /**
     * ????????????
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
     * ????????????
     * "sessionid":    (?????????) ???????????????sessionid??????
     * "vodctrltype":  (?????????) "play","pause","stop","jump"
     * "vodctrlparam": (?????????)  0(pause,stop) / 0.125,0.25,0.5,1,2,4,8,16(play) (??????:0-32)/ ??????????????????????????????(jump)
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
     * ???????????????
     */
    @GET(AppHttpPath.GET_ONLINE_AMOUNT)
    Observable<CameraOnlineBean> getOnlineAmount(@Query("q") String q);
    /**
     * ???????????????
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
     * ?????????????????????
     *
     * @return
     */
    @POST(AppHttpPath.CAMERA_GROUP)
    Observable<CameraGroupBean> getCameraGroup(@Body RequestBody requestBody);

    /**
     * ?????????????????????
     *
     * @return
     */
    @POST(AppHttpPath.ADD_CAMERA_GROUP)
    Observable<BaseResult> creatCameraGroup(@Body RequestBody requestBody);

    /**
     * ???????????????
     *
     * @return
     */
    @POST(AppHttpPath.ADD_CAMERA)
    Observable<BaseResult> addCamera(@Body RequestBody requestBody);

    /**
     * ?????????????????????
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
     * ??????NVR ??????
     *
     * @return
     */
    @POST(AppHttpPath.ADD_NVR_DEV)
    Observable<BaseResult> addNvrDev(@Body RequestBody requestBody);

    /**
     * ???????????????????????????
     *
     * @return
     */
    @POST(AppHttpPath.GET_DEVS_OF_GROUP)
    Observable<DevListBean> getDevsOfGroup(@Body RequestBody requestBody);

    /**
     * ???????????????????????????(??????nvr)
     *
     * @return
     */
    @POST(AppHttpPath.GET_CAMERAS_OF_GROUP)
    Observable<CameraListBean> getCamerasOfGroup(@Body RequestBody requestBody);

    /**
     * ??????nvr???????????????
     *
     * @return
     */
    @POST(AppHttpPath.GET_DEVS_OF_NVR)
    Observable<CameraListBean> getDevsOfNVR(@Body RequestBody requestBody);

    /**
     * ?????????????????????????????????????????????
     *
     * @return
     */
    @POST(AppHttpPath.SEARCH_DEV_NUM)
    Observable<DevToAddBean> searchDevByNum(@Body RequestBody requestBody);

    /**
     * ????????????
     *
     * @return
     */
    @POST(AppHttpPath.TRSFER_TO_GROUP)
    Observable<BaseResult> transferDev(@Body RequestBody requestBody);

    /**
     * ????????????
     *
     * @return
     */
    @POST(AppHttpPath.DEL_DEV)
    Observable<BaseResult> deleteDev(@Body RequestBody requestBody);

    /**
     * ????????????
     *
     * @return
     */
    @POST(AppHttpPath.DEL_GROUP)
    Observable<BaseResult> deleteGroup(@Body RequestBody requestBody);

    /**
     * ??????????????????
     *
     * @return
     */
    @POST(AppHttpPath.UPDATE_GROUP_NAME)
    Observable<BaseResult> updateGroupName(@Body RequestBody requestBody);

    /**
     * ????????????
     *
     * @return
     */
    @POST(AppHttpPath.GROUP_INFO)
    Observable<GroupInfoBean> getGroupInfo(@Body RequestBody requestBody);





    /*==============================================  ??????  =============================================*/


    /**
     * ?????????????????????
     *
     * @return
     */
    @POST(AppHttpPath.VEDIO_PERMISSION_LIST)
    Observable<PermissionListBean> getPermissionList(@Body RequestBody requestBody);

    /**
     * ??????????????????
     *
     * @return
     */
    @POST(AppHttpPath.SHARED_USERS)
    Observable<SharedUserBean> getSharedUserList(@Body RequestBody requestBody);

    /**
     * ????????????????????????
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
     * ????????????
     *
     * @return
     */
    @POST(AppHttpPath.CANCEL_SHARE)
    Observable<BaseResult> cancelShareAccount(@Body RequestBody requestBody);

    /**
     * ??????????????????
     *
     * @return
     */
    @POST(AppHttpPath.DEL_MY_SHARE)
    Observable<BaseResult> delMyShare(@Body RequestBody requestBody);

    /**
     * ??????????????????
     *
     * @return
     */
    @POST(AppHttpPath.SHARED_LIVE_TYPE)
    Observable<SharedLiveTypeBean> getSharedLiveType(@Body RequestBody requestBody);

    /**
     * ??????????????????
     *
     * @return
     */
    @POST(AppHttpPath.GLOBAL_LIVE_REQUEST)
    Observable<BaseResult> requestGlobalLive(@Body RequestBody requestBody);

    /**
     * ??????????????????
     *
     * @return
     */
    @POST(AppHttpPath.CLOSE_GLOBAL_LIVE)
    Observable<BaseResult> closeGlobalLive(@Body RequestBody requestBody);
    /**
     * ???????????????
     *
     * @return
     */
    @POST(AppHttpPath.SHARE_TO_WCHAT)
    Observable<BaseResult> shareToWchat(@Body RequestBody requestBody);


    /**
     * ????????????
     */
    @POST(AppHttpPath.LOG_OUT)
    Observable<BaseResult> logout(@Body RequestBody requestBody);

    /**
     * ????????????
     */
    @GET(AppHttpPath.USER_INFO)
    Observable<UserBaseMsgBean> persionalInfo(@QueryMap Map<String, String> options);

    /**
     * ????????????
     */
    @POST(AppHttpPath.MODIFY_HEAD_ICON)
    Observable<BaseResult> modifyHeadIcon(@Body RequestBody requestBody);

    /**
     * ????????????
     */
    @POST(AppHttpPath.MODIFY_PWD)
    Observable<BaseResult> modifyPwd(@Body RequestBody requestBody);

    /**
     * ????????????
     */
    @POST(AppHttpPath.MY_SHARE)
    Observable<MyShareBean> myShare(@Body RequestBody requestBody);

    /**
     * ????????????
     */
    @POST(AppHttpPath.DEL_SHARE)
    Observable<BaseResult> delShare(@Body RequestBody requestBody);


    /**
     * ??????????????????
     */
    @POST(AppHttpPath.DEV_MANAGER_LIST)
    Observable<DevListBean> devManagerList(@Body RequestBody requestBody);








    /*==============================================  ??????  =============================================*/

    /**
     * ??????
     */
    @POST(AppHttpPath.SEARCH)
    Observable<SearchBean> search(@Body RequestBody body);

    /**
     * ??????
     */
    @POST(AppHttpPath.SEARCH_MORE)
    Observable<SearchResultBean> searchMore(@Body RequestBody body);





    /*==============================================  ???????????????  =============================================*/


    @POST(AppHttpPath.ADD_PRE_POSITION)
    Observable<BaseResult> addPrePosition(@Body RequestBody body);

    /**
     * ???????????????
     *
     * @param body
     * @return
     */
    @POST(AppHttpPath.DEL_PRE_POSITION)
    Observable<BaseResult> delPrePosition(@Body RequestBody body);

    /**
     * ???????????????
     *
     * @param body
     * @return
     */
    @POST(AppHttpPath.GET_PRE_POSITIONS)
    Observable<PreSetBean> getPrePositions(@Body RequestBody body);

}
