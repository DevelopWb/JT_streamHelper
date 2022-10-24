package com.juntai.wisdom.bdmap.act;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.juntai.wisdom.bdmap.BaseRequestLocationActivity;
import com.juntai.wisdom.bdmap.R;
import com.juntai.wisdom.bdmap.adapter.PlaceListAdapter;
import com.juntai.wisdom.bdmap.utils.MapUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  地图中选择地址
 * @date 2020/7/8 10:16
 */
public class LocateSelectionActivity extends BaseRequestLocationActivity implements BaiduMap.OnMapClickListener,
        OnGetGeoCoderResultListener {

    public static int SELECT_ADDR = 998;
    public static String SELECTED_ADDR = "address";//选择后的地址
    public static String SELECTED_LAT = "lat";//选择后的地址
    public static String SELECTED_LNG = "lng";//选择后的地址
    private String address = "";
    private RecyclerView addressListRV;
    private MapView mapView;
    private Double lat = 0.0, lng = 0.0;
    private BaiduMap mBaiduMap = null;
    private BitmapDescriptor locationMarker = null;
    private List<Address> addressList = new ArrayList<>();
    private ProgressBar progressBar = null;
    private PlaceListAdapter adapter = null;
    private int selectedPosition = 0;
    private GeoCoder mGeoCoder = null;

    @Override
    public int getLayoutView() {
        return R.layout.activity_location_seltion;
    }


    @Override
    public void initView() {
        setTitleName("地理位置");

        getTitleRightTv().setVisibility(View.VISIBLE);
        getTitleRightTv().setText("确定");
        getTitleRightTv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (lat != 0.0 && lng != 0.0 && !address.equals("") && lat != 4.9E-324) {
                    intent.putExtra(SELECTED_LAT, String.valueOf(lat));
                    intent.putExtra(SELECTED_LNG, String.valueOf(lng));
                    intent.putExtra(SELECTED_ADDR, address);
                    setResult(SELECT_ADDR, intent);
                    finish();
                } else {
                    ToastUtils.toast(mContext, "未选择位置或位置错误");
                }
            }
        });

        addressListRV = findViewById(R.id.address_listRy);
        mapView = findViewById(R.id.mMapViewRy);
        mBaiduMap = mapView.getMap();
        mapView.showScaleControl(false);
        mapView.showZoomControls(false);
        mapView.removeViewAt(1);
        locationMarker = BitmapDescriptorFactory
                .fromResource(R.drawable.red_marker_im);
        addressListRV = findViewById(R.id.address_listRy);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        addressListRV.setLayoutManager(layoutManager);
        progressBar = findViewById(R.id.progressBarRy);
        mGeoCoder = GeoCoder.newInstance();
        mGeoCoder.setOnGetGeoCodeResultListener(this);
    }

    @Override
    public void initData() {

    }

    private void initLogic() {
        if (lat != 0.0 & lng != 0.0) {
            MapUtil.mapMoveTo(mBaiduMap, new LatLng(lat, lng));
        }
        mBaiduMap.setOnMapClickListener(this);//先搜索再设置监听，有概率收不到回调
        onMapClick(new LatLng(lat, lng));

        MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 18);    //设置地图中心点以及缩放级别
        mBaiduMap.animateMapStatus(u);
    }

    @Override
    public void onMapClick(final LatLng latLng) {
        mGeoCoder.reverseGeoCode(new ReverseGeoCodeOption()
                .location(latLng)
                // POI召回半径，允许设置区间为0-1000米，超过1000米按1000米召回。默认值为1000
                .radius(500));
        //==============================================
        mBaiduMap.clear();
        // 构建MarkerOption，用于在地图上添加Marker
        MarkerOptions options = new MarkerOptions().position(latLng).icon(locationMarker);
        // 在地图上添加Marker，并显示
        mBaiduMap.addOverlay(options);
        progressBar.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    @Override
    public void onMapPoiClick(MapPoi mapPoi) {
        onMapClick(mapPoi.getPosition());
    }

    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
            ToastUtils.toast(mContext, "无结果");
            progressBar.setVisibility(View.INVISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            return;
        } else {
            if (addressList != null) {
                addressList.clear();
            }
            lat = reverseGeoCodeResult.getLocation().latitude;
            lng = reverseGeoCodeResult.getLocation().longitude;
            address = reverseGeoCodeResult.getAddress();
            List<PoiInfo> searchList = reverseGeoCodeResult.getPoiList();
            if (searchList != null) {
                for (int i = 0; i < searchList.size(); i++) {
                    PoiInfo poiInfo = searchList.get(i);
                    if (0==i) {
                        addressList.add(new Address(poiInfo, true));
                    }else {
                        addressList.add(new Address(poiInfo, false));
                    }
                }
            }
            adapter = new PlaceListAdapter(R.layout.item_immap_list, addressList);
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (selectedPosition == position && selectedPosition != 0) {
                        return;
                    } else {
                        PoiInfo poiInfo = addressList.get(position).getPoiInfo();
                        address = poiInfo.getAddress();
                        lat = poiInfo.getLocation().latitude;
                        lng = poiInfo.getLocation().longitude;
                        addressList.get(selectedPosition).setIschecked(false);
                        addressList.get(position).setIschecked(true);
                        adapter.notifyItemChanged(position);
                        adapter.notifyItemChanged(selectedPosition);
                        selectedPosition = position;
                    }
                }
            });
            adapter.openLoadAnimation();
            addressListRV.setAdapter(adapter);
            selectedPosition = 0;
            progressBar.setVisibility(View.INVISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }


    public class Address {
        PoiInfo poiInfo;
        public boolean ischecked;

        public Address(PoiInfo poiInfo, boolean ischecked) {
            this.poiInfo = poiInfo;
            this.ischecked = ischecked;
        }

        public PoiInfo getPoiInfo() {
            return poiInfo;
        }

        public void setPoiInfo(PoiInfo poiInfo) {
            this.poiInfo = poiInfo;
        }

        public boolean ischecked() {
            return ischecked;
        }

        public void setIschecked(boolean ischecked) {
            this.ischecked = ischecked;
        }
    }

    @Override
    public void onLocationReceived(BDLocation bdLocation) {
        lat = bdLocation.getLatitude();
        lng = bdLocation.getLongitude();
        initLogic();
    }

    @Override
    public boolean requestLocation() {
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onResume();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationMarker.recycle();
        locationMarker = null;
        mapView.onDestroy();
        mapView = null;
        mGeoCoder.destroy();
        if (addressList != null) {
            addressList.clear();
            addressList=null;
        }

    }
}
