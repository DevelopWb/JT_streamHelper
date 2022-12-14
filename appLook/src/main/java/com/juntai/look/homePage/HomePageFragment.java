package com.juntai.look.homePage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.HeatMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.AppHttpPath;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.bean.HomePageMenuBean;
import com.juntai.look.bean.ServicePeoplePositionBean;
import com.juntai.look.bean.TextListBean;
import com.juntai.look.bean.stream.StreamCameraBean;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.addDev.AddDevActivity;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.look.homePage.map.ClusterClickAdapter;
import com.juntai.look.homePage.map.MapClusterItem;
import com.juntai.look.homePage.search.SearchActivity;
import com.juntai.look.homePage.weather.WeatherActivity;
import com.juntai.look.homePage.weather.WeatherHelper;
import com.juntai.look.uitils.ImageUtil;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.juntai.wisdom.bdmap.service.LocateAndUpload;
import com.juntai.wisdom.bdmap.utils.MapUtil;
import com.juntai.wisdom.bdmap.utils.clusterutil.clustering.Cluster;
import com.juntai.wisdom.bdmap.utils.clusterutil.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @aouther tobato
 * @description ??????  ??????fragment
 * @date 2020/4/21 11:06
 */
public class HomePageFragment extends BaseAppFragment<HomePagePresent> implements BaiduMap.OnMapLoadedCallback,
        View.OnClickListener, LocateAndUpload.Callback, ClusterManager.OnClusterClickListener<MapClusterItem>,
        ClusterManager.OnClusterItemClickListener<MapClusterItem>, HomePageContract.IHomePageView {
    private MapView mBmapView;
    private LinearLayout mSearchLl;
    private RecyclerView mHomePageRightMenuRv;
    private ImageView mZoomplus;
    private ImageView mZoomminus;
    private View infowindow = null;
    private Button mMylocation;
    private ImageView mSatalliteMapIv;
    private ImageView mTwoDMapIv;
    private ImageView mThreeDMapIv;
    private Switch mHeatSw;
    private Switch mTrafficSv;
    private DrawerLayout mDrawerlayout;
    private HomePageMenuAdapter menuAdapter;
    private BaiduMap mBaiduMap;
    private RelativeLayout mDrawerRightLaytoutRl;
    public static String province = null;
    public static String city = null;
    public static String area = null;
    private double lat;
    private double lng;
    private boolean isFisrt = true;
    private PopupWindow popupWindow;
    private List<MapClusterItem> clusterItemList = new ArrayList<>();
    private ClusterManager clusterManager;
    private BitmapDescriptor bitmapDescriptor;
    //???????????????marker
    Marker nowMarker;
    private int clickItemType = 2;//2??????marker?????????1??????????????????
    private MapStatus lastPosition;
    String nowMarkerId = "";//??????markerid
    StreamCameraBean.DataBean currentStreamCamera;
    HeatMap mHeatMap = null;
    private List<LatLng> heatMapItems = new ArrayList<>();
    private BottomSheetDialog mapBottomDialog;
    private ClusterClickAdapter clusterClickAdapter;
    private ImageView mSearchLl1;
    private ConstraintLayout mWeatherLayoutCl;
    private ImageView mWeatherIconIv;

    /**
     * ??????
     */
    private TextView mWeatherNameTv;
    /**
     * 20??C
     */
    private TextView mTemperatureTv;
    /**
     * ????????????:???
     */
    private TextView mAirQualityTv;
    private ImageView mSearchIv;
    private ImageView mAddDevIv;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.satallite_map_iv:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);//??????????????????
                mapType(v.getId());
                break;
            case R.id.two_d_map_iv:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);//
                mapType(v.getId());
                break;
            case R.id.three_d_map_iv:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);//
                mapType(v.getId());
                break;
            case R.id.search_iv:
                //??????
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            case R.id.zoomminus:
                MapUtil.mapZoom(MapUtil.MAP_ZOOM_OUT1, mBaiduMap);
                break;
            case R.id.zoomplus:
                MapUtil.mapZoom(MapUtil.MAP_ZOOM_IN1, mBaiduMap);
                break;

            case R.id.mylocation:
                //????????????
                MapUtil.mapZoom(MapUtil.MAP_ZOOM_TO, mBaiduMap, 16);
                MapUtil.mapMoveTo(mBaiduMap, new LatLng(lat, lng));
                break;
            case R.id.weather_cl:
                //?????????????????????
                if (!StringTools.isStringValueOk(province)) {
                    ToastUtils.warning(mContext, "???????????????");
                } else {
                    startActivity(new Intent(mContext, WeatherActivity.class)
                            .putExtra("province", province)
                            .putExtra("city", city)
                            .putExtra("area", area == null ? "" : area));
                }
                break;
            default:
                break;
            case R.id.add_dev_iv:
                showPopAddDev(v);
                break;
            case R.id.add_dev_ll:
                startActivity(new Intent(getContext(), AddDevActivity.class));
                stopPopWindow();
                break;
            case R.id.scan_ll:
                //todo ???????????????
                ToastUtils.toast(mContext,"????????????");
//                startActivity(new Intent(mContext,
//                        QRScanActivity.class));
//                stopPopWindow();
                break;
        }
    }

    /**
     * ???????????????????????????  ??????????????????????????? ???????????????  ????????????????????? ????????????????????????????????????
     */
    public  void refreshCameraList(){
        clearTheMap();
        mPresenter.getAllStreamCameras(mPresenter.getPublishMultipartBody().build(),
                HomePageContract.GET_STREAM_CAMERAS);
    }

    /**
     * ??????????????????
     *
     * @param viewId
     */
    private void mapType(int viewId) {
        switch (viewId) {
            case R.id.satallite_map_iv:
                mTwoDMapIv.setBackgroundColor(getResources().getColor(R.color.transparent));
                mThreeDMapIv.setBackgroundColor(getResources().getColor(R.color.transparent));
                mSatalliteMapIv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                //                weixingTv.setTextColor(getResources().getColor(R.color.colorAccent));
                //                twdTv.setTextColor(Color.parseColor("#8a000000"));
                //                thdTv.setTextColor(Color.parseColor("#8a000000"));
                break;
            case R.id.two_d_map_iv:
                mTwoDMapIv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                mThreeDMapIv.setBackgroundColor(getResources().getColor(R.color.transparent));
                mSatalliteMapIv.setBackgroundColor(getResources().getColor(R.color.transparent));
                //                twdTv.setTextColorx(getResources().getColor(R.color.colorAccent));
                //                thdTv.setTextColor(Color.parseColor("#8a000000"));
                //                weixingTv.setTextColor(Color.parseColor("#8a000000"));
                break;
            case R.id.three_d_map_iv:
                mTwoDMapIv.setBackgroundColor(getResources().getColor(R.color.transparent));
                mThreeDMapIv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                mSatalliteMapIv.setBackgroundColor(getResources().getColor(R.color.transparent));
                //                thdTv.setTextColor(getResources().getColor(R.color.colorAccent));
                //                twdTv.setTextColor(Color.parseColor("#8a000000"));
                //                weixingTv.setTextColor(Color.parseColor("#8a000000"));
                break;
        }
    }

    @Override
    public void onMapLoaded() {
    }

    @Override
    protected HomePagePresent createPresenter() {
        return new HomePagePresent();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.homefragmentnew;
    }

    @Override
    protected void initView() {
        mBmapView = (MapView) getView(R.id.bmapView);
        mBmapView.showZoomControls(false);
        mBaiduMap = mBmapView.getMap();
        mSearchLl1 = getView(R.id.search_iv);
        mSearchLl1.setOnClickListener(this);
        mHomePageRightMenuRv = (RecyclerView) getView(R.id.home_page_right_menu_rv);
        mZoomplus = (ImageView) getView(R.id.zoomplus);
        mZoomplus.setOnClickListener(this);
        mZoomminus = (ImageView) getView(R.id.zoomminus);
        mZoomminus.setOnClickListener(this);
        mMylocation = (Button) getView(R.id.mylocation);
        mMylocation.setOnClickListener(this);
        mWeatherLayoutCl = getView(R.id.weather_cl);
        mWeatherLayoutCl.setOnClickListener(this);
        initUISetting();
        initMenuAdapter();
        initDrawerLayout();
        initClusterManagerAndMap();
        mWeatherIconIv = (ImageView) getView(R.id.weather_icon_iv);
        mWeatherNameTv = (TextView) getView(R.id.weather_name_tv);
        mTemperatureTv = (TextView) getView(R.id.temperature_tv);
        mAirQualityTv = (TextView) getView(R.id.air_quality_tv);
        mSearchIv = (ImageView) getView(R.id.search_iv);
        mSearchIv.setOnClickListener(this);
        mAddDevIv = (ImageView) getView(R.id.add_dev_iv);
        mAddDevIv.setOnClickListener(this);
    }

    /**
     * ??????????????????
     *
     * @param realTimeWeather
     */
    public void setWeatherInfos(ResponseRealTimeWeather realTimeWeather) {
        int aqi = realTimeWeather.getData().getResult().getAqi();
        mTemperatureTv.setText(Math.round(realTimeWeather.getData().getResult().getTemperature()) + "??C");
        mAirQualityTv.setText("????????????:" + WeatherHelper.switchPM25(aqi));
        mWeatherNameTv.setText(WeatherHelper.switchSkycon(realTimeWeather.getData().getResult().getSkycon()));
        mWeatherIconIv.setImageResource(WeatherHelper.switchSkyconInt(realTimeWeather.getData().getResult().getSkycon()));
    }

    /**
     * ????????????????????????
     */
    private void initUISetting() {
        //?????????UiSettings?????????
        UiSettings mUiSettings = mBaiduMap.getUiSettings();
        //????????????enable???true???false ???????????????????????????
        mUiSettings.setCompassEnabled(false);
        //??????????????????
        mBaiduMap.setMyLocationEnabled(true);
        MyLocationConfiguration config = new MyLocationConfiguration(
                MyLocationConfiguration.LocationMode.NORMAL, true, null);
        mBaiduMap.setMyLocationConfiguration(config);
    }

    /**
     * ?????????ClusterManager???map
     */
    private void initClusterManagerAndMap() {
        clusterManager = new ClusterManager<>(mContext, mBaiduMap);
        clusterManager.setOnClusterItemClickListener(HomePageFragment.this);//?????????
        clusterManager.setOnClusterClickListener(HomePageFragment.this);//????????????
        //?????????????????????????????????
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //?????????????????????
                if (!clusterManager.getClusterMarkerCollection().getMarkers().contains(marker)) {
                    if (nowMarker != null) {
                        if (bitmapDescriptor != null) {
                            nowMarker.setIcon(bitmapDescriptor);
                        }

                    }
                    //marker.setIcon(BitmapDescriptorFactory.fromBitmap(compoundBitmap
                    // (BitmapFactory.decodeResource(getResources(),R.mipmap
                    // .ic_client_location_pre), BitmapFactory.decodeResource(getResources(),R
                    // .mipmap.ic_my_default_head))));
                    nowMarker = marker;
                    clickItemType = 2;
                }
                //?????????????????????????????????
                clusterManager.onMarkerClick(marker);
                return false;
            }
        });
        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mBmapView.removeView(infowindow);
            }

            @Override
            public void onMapPoiClick(MapPoi mapPoi) {
                mBmapView.removeView(infowindow);
            }
        });
        //
        //??????????????????????????? ????????????
        mBaiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {
            }

            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
            }

            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
                if (lastPosition != null && lastPosition.zoom != mBaiduMap.getMapStatus().zoom) {
                    mBmapView.removeView(infowindow);
                    clickItemType = 2;
                    if (nowMarker != null) {
                        nowMarker.setIcon(bitmapDescriptor);
                        nowMarker = null;
                    }
                    nowMarkerId = "";
                }
                lastPosition = mBaiduMap.getMapStatus();
                clusterManager.onMapStatusChange(mapStatus);
            }

            @Override
            public void onMapStatusChangeFinish(MapStatus mapStatus) {
            }
        });
    }

    /**
     * ????????????????????????
     */
    private void initDrawerLayout() {
        mSatalliteMapIv = (ImageView) getView(R.id.satallite_map_iv);
        mSatalliteMapIv.setOnClickListener(this);
        mTwoDMapIv = (ImageView) getView(R.id.two_d_map_iv);
        mTwoDMapIv.setOnClickListener(this);
        mThreeDMapIv = (ImageView) getView(R.id.three_d_map_iv);
        mThreeDMapIv.setOnClickListener(this);
        mHeatSw = (Switch) getView(R.id.heat_sw);
        mTrafficSv = (Switch) getView(R.id.traffic_sv);
        mDrawerlayout = (DrawerLayout) getView(R.id.drawerlayout);
        mDrawerRightLaytoutRl = getView(R.id.drawer_right_layout_rl);
        //??????????????????
        mDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //???????????????
        mHeatSw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (clusterItemList.size() > 0) {
                    heatMapItems.clear();
                    for (MapClusterItem item : clusterItemList) {
                        heatMapItems.add(item.getLatLng());
                    }
                    mHeatMap = new HeatMap.Builder().data(heatMapItems).build();
                    mBaiduMap.addHeatMap(mHeatMap);
                } else {
                    ToastUtils.toast(mContext, "???????????????????????????");
                    mHeatSw.setChecked(false);
                }
            } else {
                if (mHeatMap != null) {
                    mHeatMap.removeHeatMap();
                    mHeatSw.setChecked(false);
                }

            }
        });
        //???????????????
        mTrafficSv.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mBaiduMap.setTrafficEnabled(true);
            } else {
                mBaiduMap.setTrafficEnabled(false);
            }

        });
    }

    /**
     * ????????????????????????
     */
    private void initMenuAdapter() {
        menuAdapter = new HomePageMenuAdapter(R.layout.home_page_menu_item);
        getBaseActivity().initRecyclerview(mHomePageRightMenuRv, menuAdapter, LinearLayoutManager.VERTICAL);
        menuAdapter.setNewData(mPresenter.getMenus());
        menuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                nowMarkerId = "";
                nowMarker = null;
                HomePageMenuBean menuBean = (HomePageMenuBean) adapter.getData().get(position);
                switch (menuBean.getMenuId()) {
                    case HomePageContract.MENUE_MAP_TYPE:
                        if (mDrawerlayout.isDrawerVisible(mDrawerRightLaytoutRl)) {
                            mDrawerlayout.closeDrawers();
                        } else {
                            mDrawerlayout.openDrawer(mDrawerRightLaytoutRl);

                        }
                        break;
                    case HomePageContract.MENUE_CHANGE_MODULE:
                        //                        if (!StringTools.isStringValueOk(province)) {
                        //                            ToastUtils.warning(mContext, "???????????????");
                        //                        } else {
                        //                            startActivity(new Intent(mContext, WeatherActivity.class)
                        //                                    .putExtra("province", province)
                        //                                    .putExtra("city", city)
                        //                                    .putExtra("area", area == null ? "" : area));
                        //                        }
                        break;
                    case HomePageContract.MENUE_CAMERA:
                        clearTheMap();
                        //                        mPresenter.getCameras(MapContract.GET_CAMERAS);
                        mPresenter.getAllStreamCameras(mPresenter.getPublishMultipartBody().build(),
                                HomePageContract.GET_STREAM_CAMERAS);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onResume() {
        mBmapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mBmapView.onPause();
        super.onPause();
    }


    @Override
    public void onDestroy() {
        releaseBottomListDialog();
        stopPopWindow();
        mBmapView.onDestroy();
        mBmapView = null;
        super.onDestroy();
    }

    /**
     * ????????????
     */
    private void stopPopWindow() {
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
        }
    }

    @Override
    protected void initData() {
        startUploadLocationService();
    }

    /**
     * ???????????????????????????
     */
    private void startUploadLocationService() {
        HashMap<String, String> params = new HashMap<>();
        params.put("uid", String.valueOf(UserInfoManager.getUserId()));
        params.put("account", UserInfoManager.getUserAccount());
        params.put("token", UserInfoManager.getUserToken());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mContext.startForegroundService(new Intent(mContext, LocateAndUpload.class)
                    .putExtra("historyApiUrl", AppHttpPath.UPLOAD_LOCATION)
                    .putExtra("params", params));
        } else {
            mContext.startService(new Intent(mContext, LocateAndUpload.class)
                    .putExtra("historyApiUrl", AppHttpPath.UPLOAD_LOCATION)
                    .putExtra("params", params));
        }
        LocateAndUpload.setCallback(this);
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case HomePageContract.GET_STREAM_CAMERAS:
                StreamCameraBean streamCameraBean = (StreamCameraBean) o;
                if (streamCameraBean != null) {
                    List<StreamCameraBean.DataBean> datas = streamCameraBean.getData();
                    if (datas != null) {
                        if (datas.size() > 0) {
                            for (StreamCameraBean.DataBean camera : datas) {
                                MapClusterItem mCItem = new MapClusterItem(
                                        new LatLng(camera.getLatitude(), camera.getLongitude()), camera);
                                clusterItemList.add(mCItem);
                            }
                            clusterManager.addItems(clusterItemList);
                            clusterManager.cluster();
                        } else {
                            ToastUtils.toast(mContext, "????????????");
                        }

                    }

                    //                    dateType = 0;
                }
                break;
            case HomePageContract.GET_STREAM_CAMERAS_FROM_VCR:

                StreamCameraBean bean = (StreamCameraBean) o;
                if (bean != null) {
                    List<StreamCameraBean.DataBean> datas = bean.getData();
                    if (datas != null) {
                        List<MapClusterItem> items = new ArrayList<MapClusterItem>();
                        for (StreamCameraBean.DataBean camera : datas) {
                            camera.setFlag(1);
                            MapClusterItem mCItem = new MapClusterItem(
                                    new LatLng(camera.getLatitude(), camera.getLongitude()), camera);
                            items.add(mCItem);
                        }
                    }


                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String tag, Object o) {
        ToastUtils.error(mContext, (String) o);
    }

    @Override
    public void onLocationChange(BDLocation bdLocation) {
        //  161????????????????????????   61???GPS?????????????????????
        if (bdLocation == null) {
            return;
        }
        lat = bdLocation.getLatitude();
        lng = bdLocation.getLongitude();
        city = bdLocation.getCity();
        area = bdLocation.getDistrict();
        province = bdLocation.getProvince();
        if (isFisrt) {
            MapUtil.mapMoveTo(mBaiduMap, new LatLng(lat,
                    lng));
            isFisrt = false;
        }
        MyLocationData data = new MyLocationData.Builder()//?????????????????????
                .latitude(lat)//??????
                .longitude(lng)//??????
                .build();//??????
        mBaiduMap.setMyLocationData(data);
    }

    /**
     * ????????????
     */
    public void showPopAddDev(View addView) {

        View viewPop = LayoutInflater.from(mContext).inflate(R.layout.pop_add_dev, null);
        popupWindow = new PopupWindow(viewPop, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        LinearLayout addDevLl = viewPop.findViewById(R.id.add_dev_ll);
        LinearLayout scanLl = viewPop.findViewById(R.id.scan_ll);
        addDevLl.setOnClickListener(this);
        scanLl.setOnClickListener(this);
        popupWindow.showAsDropDown(addView, -DisplayUtil.dp2px(mContext, 105), -DisplayUtil.dp2px(mContext, 3),
                Gravity.BOTTOM);
    }

    /**
     * ??????????????????
     */
    private void clearTheMap() {
        mBaiduMap.clear();
        clusterItemList.clear();
        clusterManager.clearItems();
        mBmapView.removeView(infowindow);
    }

    /**
     * ???????????????
     *
     * @param cluster
     * @return
     */
    @Override
    public boolean onClusterClick(Cluster<MapClusterItem> cluster) {
        List<MapClusterItem> items = new ArrayList<MapClusterItem>(cluster.getItems());
        if (mapBottomDialog == null) {
            mapBottomDialog = new BottomSheetDialog(mContext);
            View view = LayoutInflater.from(mContext).inflate(R.layout.bottom_list_layout, null);
            mapBottomDialog.setContentView(view);
            RecyclerView bottomRv = view.findViewById(R.id.map_bottom_list_rv);
            clusterClickAdapter = new ClusterClickAdapter(R.layout.care_item_layout);
            getBaseActivity().initRecyclerview(bottomRv, clusterClickAdapter, LinearLayoutManager.VERTICAL);
            clusterClickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    MapClusterItem item = (MapClusterItem) adapter.getData().get(position);
                    if (infowindow != null) {
                        mBmapView.removeView(infowindow);
                    }
                    if (nowMarker != null) {
                        nowMarker.setIcon(bitmapDescriptor);
                    }
                    nowMarker = null;
                    mBaiduMap.hideInfoWindow();
                    clickItemType = 1;
                    onClusterItemClick(item);
//                    releaseBottomListDialog();
                }
            });
//            clusterClickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//                @Override
//                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                    MapClusterItem item = (MapClusterItem) adapter.getData().get(position);
//                    switch (item.getType()) {
//                        case MapClusterItem.CARE_POSITION:
//                            getBaseAppActivity().navigationLogic(new LatLng(item.carePosition.getLatitude(),
//                                    item.carePosition.getLongitude()), item.carePosition.getPlace());
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            });
        }
        clusterClickAdapter.setNewData(items);
        mapBottomDialog.show();
        return false;
    }


    /**
     * ?????????????????????
     *
     * @param item
     * @return
     */
    @Override
    public boolean onClusterItemClick(MapClusterItem item) {
        if (infowindow != null) {
            mBmapView.removeView(infowindow);
        }
        switch (item.getType()) {
            case MapClusterItem.STREAM_CAMERA:
                if (1 == item.streamCamera.getFlag()) {
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap
                            .steam_cameras_tip);
                    //????????????????????????????????????
                    mPresenter.getAllStreamCamerasFromVCR(mPresenter.getPublishMultipartBody()
                                    .addFormDataPart(
                                            "dvrId", String.valueOf(item.streamCamera.getId())).build(),
                            HomePageContract.GET_STREAM_CAMERAS_FROM_VCR);
                } else {
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.camera_tip);
                    updateMarkerIcon(UrlFormatUtil.formatPicUrl(item.streamCamera.getEzopen()));
                }
                if (clickItemType == 1 || nowMarkerId.equals(String.valueOf(item.streamCamera.getNumber
                        ()))) {
                    if (0 == item.streamCamera.getFlag()) {
                        currentStreamCamera = item.streamCamera;
                        startActivity(new Intent(mContext.getApplicationContext(), PlayerLiveActivity.class)
                                .putExtra(PlayerLiveActivity.STREAM_CAMERA_ID, currentStreamCamera.getId())
                                .putExtra(PlayerLiveActivity.STREAM_CAMERA_THUM_URL, currentStreamCamera.getEzopen())
                                .putExtra(PlayerLiveActivity.STREAM_CAMERA_NUM, currentStreamCamera.getNumber()));

                    }
                }
                nowMarkerId = String.valueOf(item.streamCamera.getNumber());
                break;
            case MapClusterItem.CARE_POSITION:
                //                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.care_taker_icon);
                //                //????????????
                //                CareRecordPositionBean.DataBean.DatasBean carePosition = item.carePosition;
                //                String year = carePosition.getYear();
                //                if ("2019".equals(year)) {
                //                    Intent mintent = new Intent(mContext, CareInfoActivity.class);
                //                    mintent.putExtra(CareInfoActivity.CARE_ID, carePosition.getId());
                //                    startActivity(mintent);
                //                } else {
                //                    startActivity(new Intent(mContext, CareTakerInfoActivity.class).putExtra
                //                    (CareTakerInfoActivity.CARE_TAKER_ID, carePosition.getId()));
                //                }
                break;

            case MapClusterItem.PEOPLE:
                //????????????
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.people_tip);
                updateMarkerIcon(UrlFormatUtil.formatPicUrl(item.peoplePosition.getHead()));
                if (clickItemType == 1 || nowMarkerId.equals(String.valueOf(item.peoplePosition.getId()))) {
                    onServicePeopleItemClick(item, mBaiduMap);
                }
                nowMarkerId = String.valueOf(item.peoplePosition.getId());
                break;
        }
        return false;
    }

    /**
     * ??????marker??????
     *
     * @param path
     */
    public void updateMarkerIcon(String path) {
        if (nowMarker == null) {
            return;
        }
        ImageLoadUtil.getBitmap(getContext().getApplicationContext(), path, R.mipmap.ic_error,
                new ImageLoadUtil.BitmapCallBack() {
                    @Override
                    public void getBitmap(Bitmap bitmap) {
                        try {
                            nowMarker.setIcon(BitmapDescriptorFactory.fromBitmap(ImageUtil.combineBitmap(
                                    BitmapFactory.decodeStream(getResources().getAssets().open(
                                            "ic_map_shop_bg.png")),
                                    ImageUtil.getRoundedCornerBitmap(ImageUtil.zoomImg(bitmap), 200))));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    /**
     * ??????dialog
     */
    private void releaseBottomListDialog() {
        if (mapBottomDialog != null) {
            mapBottomDialog.dismiss();
            mapBottomDialog = null;
        }
    }

    /**
     * ????????????item????????? ??????infowidow
     *
     * @param map
     */
    private void onServicePeopleItemClick(MapClusterItem item, BaiduMap map) {
        ServicePeoplePositionBean.DataBean people = item.peoplePosition;
        LatLng peopleLocation = new LatLng(people.getLatitude(), people.getLongitude());
        MapUtil.mapMoveTo(map, peopleLocation);
        infowindow = View.inflate(mContext, R.layout.infowindow_people, null);//????????????????????????????????????view??????
        RecyclerView peopleRv = infowindow.findViewById(R.id.infowindow_people_rv);
        ServicePeopleAdapter adapter = new ServicePeopleAdapter(R.layout.infowindow_people_item);
        getBaseActivity().initRecyclerview(peopleRv, adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getInfoWindowAdapterData(item));
        ImageLoadUtil.loadCirImgNoCrash(mContext.getApplicationContext(),
                UrlFormatUtil.formatPicUrl(people.getHead()),
                (ImageView) infowindow.findViewById(R.id.infowindow_people_head_icon_iv),
                R.mipmap.default_head_icon, R.mipmap.default_head_icon
        );
        MapViewLayoutParams params2 = new MapViewLayoutParams.Builder()
                .layoutMode(MapViewLayoutParams.ELayoutMode.mapMode)
                .position(peopleLocation)
                .width(MapViewLayoutParams.WRAP_CONTENT)
                .height(MapViewLayoutParams.WRAP_CONTENT)
                .yOffset(-item.getBd().getBitmap().getHeight() * clickItemType)
                .build();
        mBmapView.addView(infowindow, params2);
    }

    /**
     * ????????????
     *
     * @return
     */
    private List<TextListBean> getInfoWindowAdapterData(MapClusterItem item) {
        ServicePeoplePositionBean.DataBean people = item.peoplePosition;
        List<TextListBean> beans = new ArrayList<>();
        beans.add(new TextListBean("?????????", people.getName()));
        beans.add(new TextListBean("?????????", people.getStreet()));
        beans.add(new TextListBean("?????????", people.getPhone()));

        return beans;
    }

}
