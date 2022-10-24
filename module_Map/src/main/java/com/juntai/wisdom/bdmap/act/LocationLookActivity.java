package com.juntai.wisdom.bdmap.act;

import android.content.Intent;
import android.view.View;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.juntai.wisdom.basecomponent.base.BaseActivity;
import com.juntai.wisdom.bdmap.R;
import com.juntai.wisdom.bdmap.utils.MapUtil;

public class LocationLookActivity extends BaseActivity{
    private MapView mapView;
    private Double lat = 0.0, lng = 0.0;
    private String address;
    private BaiduMap map = null;
    private BitmapDescriptor locationMarker = null;
    @Override
    public int getLayoutView() {
        return R.layout.activity_location_look;
    }

    @Override
    public void initView() {
        setTitleName("位置");
        getTitleRightTv().setVisibility(View.VISIBLE);
        getTitleRightTv().setText("导航");
        //
        //
        mapView = findViewById(R.id.map_view_tmv);
        map = mapView.getMap();
        mapView.showScaleControl(false);
        mapView.showZoomControls(false);
        mapView.removeViewAt(1);
        locationMarker = BitmapDescriptorFactory
                .fromResource(R.drawable.red_marker_im);

    }

    @Override
    public void initData() {
        lat = getIntent().getDoubleExtra("lat",0.0);
        lng = getIntent().getDoubleExtra("lng",0.0);
        address = getIntent().getStringExtra("address");
        if (lat != 0.0 & lng != 0.0) {
            MapUtil.mapMoveTo(map, new LatLng(lat, lng));
        }

        //
//        map.clear();
        // 构建MarkerOption，用于在地图上添加Marker
        LatLng latLng = new LatLng(lat, lng);
        MarkerOptions options = new MarkerOptions().position(latLng).icon(locationMarker);
        // 在地图上添加Marker，并显示
        map.addOverlay(options);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        ReverseGeoCodeOption op = new ReverseGeoCodeOption();
        op.location(latLng);

        MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 18);    //设置地图中心点以及缩放级别
        map.animateMapStatus(u);
    }


    @Override
    protected void onDestroy() {
        locationMarker.recycle();
        locationMarker = null;
        mapView.onDestroy();
        mapView = null;
        super.onDestroy();
    }

}
