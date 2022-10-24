package com.juntai.look.homePage;

import com.juntai.wisdom.basecomponent.mvp.BaseIView;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/21 16:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/21 16:05
 */
public interface HomePageContract {
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
    String GET_STREAM_CAMERAS_FROM_VCR = "get_stream_camera_from";//获取硬盘录像机下的所有的流摄像头

    String CARE_RECORD_POSITIONS = "CARE_RECORD_POSITIONS";//托养分布
    String GET_STREAM_CAMERAS = "get_stream_camera";//获取所有的流摄像头

    interface IHomePageView extends BaseIView {
    }

    interface IHomePagePresent {

        /**
         * 获取所有的流摄像头
         *
         * @param tag
         */
        void getAllStreamCameras(RequestBody requestBody, String tag);


        /**
         * 搜索
         *
         * @param tag
         */
        void search(RequestBody body, String tag);
        /**
         * 搜索更多
         *
         * @param tag
         */
        void searchMore(RequestBody body, String tag);

        /**
         * 获取硬盘录像机下的所有的流摄像头
         *
         * @param tag
         */
        void getAllStreamCamerasFromVCR(RequestBody requestBody, String tag);

        /**
         * 获取实时数据 天气
         *
         * @param tag
         * @param lng
         * @param lat
         */
        void getWeatherRealTime(String tag, String lng, String lat);

        /**
         * 获取预报 天气
         *
         * @param tag
         * @param lng
         * @param lat
         */
        void getForcastWeather(String tag, String lng, String lat);

        /**
         * 获取省列表
         *
         * @param tag
         */
        void getPrivince(String tag);

        /**
         * 获取城市列表
         *
         * @param tag
         * @param privinceNum
         */
        void getCitys(String tag, int privinceNum);

        /**
         * 获取县列表
         *
         * @param tag
         * @param cityNum
         */
        void getTowns(String tag, int cityNum);

        /**
         * 获取街道列表
         *
         * @param tag
         * @param townNum
         */
        void getStreets(String tag, int townNum);



    }

}
