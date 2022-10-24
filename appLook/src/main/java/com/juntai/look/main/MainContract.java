package com.juntai.look.main;

import com.juntai.wisdom.basecomponent.mvp.BaseIView;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/21 16:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/21 16:05
 */
public interface MainContract {
    String GET_WEATHER_REAL_TIME = "get_real_time";//实时数据
    String GET_FORCAST_WEATHER = "get_forcast";//预报
    String GET_PRIVINCE = "get_privince";//省份
    String GET_CITY = "get_city";//市
    String GET_TOWN = "get_town";//县
    String GET_STREET = "get_street";//街道
    String SEARCH = "search";//搜索
    String SEARCH_MORE = "search_more";//搜索更多
    String SERVICE_PEOPLES_POSITIONS = "/u/appConnector/selectServicerList.shtml";
    String HEATH_ORGANIZE_POSITIONS = "/u/appConnector/selectKeyunitList.shtml";
    String HEATH_ORGANIZE_DETAIL = "health_detial";


    int MENUE_MAP_TYPE = 0;//地图类型
    int MENUE_CHANGE_MODULE = 1;//模式切换
    int MENUE_CAMERA = 2;//监控
    int MENUE_CARE_TAKER = 3;//托养分布
    int MENUE_SERVICE_PEOPLE = 4;//服务人员
    int MENUE_HEALTH_ORGNAIZE = 5;//康复机构
    String GET_STREAM_CAMERAS_FROM_VCR = "get_stream_camera_from";//获取硬盘录像机下的所有的流摄像头

    String CARE_RECORD_POSITIONS = "CARE_RECORD_POSITIONS";//托养分布
    String GET_STREAM_CAMERAS = "get_stream_camera";//获取所有的流摄像头

    interface IMainView extends BaseIView {
    }

    interface IMainPresent {



    }

}
