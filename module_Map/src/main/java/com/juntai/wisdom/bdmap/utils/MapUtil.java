package com.juntai.wisdom.bdmap.utils;

import android.content.Context;
import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.juntai.wisdom.basecomponent.utils.LogUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.juntai.wisdom.bdmap.R;
import com.juntai.wisdom.bdmap.utils.clusterutil.projection.Bounds;

import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.List;

/**
 * author:wong
 * Date: 2019/3/24
 * Description:
 */
public class MapUtil {
    public final static int MAP_ZOOM_TO = 1;
    public final static int MAP_ZOOM_IN1 = 2;
    public final static int MAP_ZOOM_OUT1 = 3;
    public final static int MAP_ZOOM_PLUS = 4;
    public final static int MAP_ZOOM_MINUS = 5;


    public static void mapMoveTo(BaiduMap map, LatLng latLng) {
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        map.animateMapStatus(msu);
    }

    public static void mapZoom(int type, BaiduMap mBaiduMap) {
        //直接缩放至缩放级别16
        switch (type) {
            case MAP_ZOOM_IN1:
                //使缩放级别增大一级
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomIn());
                break;
            case MAP_ZOOM_OUT1:
                //使缩放级别减小一级
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomOut());
                break;
        }

    }

    public static void mapZoom(int type, BaiduMap mBaiduMap, int level) {
        switch (type) {
            case MAP_ZOOM_TO:
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomTo(level));
                break;
            case MAP_ZOOM_PLUS:
                //在当前的缩放级别上增加或减小具体的缩放级别
                // 4 在当前的缩放级别上增加4
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomBy(level));
//                LogUtil.d("mapLevel",String.valueOf(mBaiduMap.getMaxZoomLevel()));
                break;
            case MAP_ZOOM_MINUS:
                // -4 在当前的缩放级别上减小4
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomBy(level));
                break;

        }
    }

    public static void showMapScope(LatLng westSouth,LatLng eastNorth,BaiduMap map){
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(westSouth)
                .include(eastNorth)
                .build();
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(bounds));
    }

    public static void drawLine(Context context,List<LatLng> latLngs, BaiduMap map){

        if(latLngs.size()<2) {
            ToastUtils.toast(context, "点数量太少");
            return;
        }
        OverlayOptions mOverlayOptions = new PolylineOptions()
                .width(10)
                .color(0xff5ea7ff)
                .points(latLngs);
        Overlay mPolyline = map.addOverlay(mOverlayOptions);

    }

    public static Marker mapMarker(BaiduMap map,LatLng latLng, Bundle bundle){
//构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.mission_point_tip);
//构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(latLng)
                .icon(bitmap);
//在地图上添加Marker，并显示
        return (Marker)map.addOverlay(option);
//        Marker marker = map.addOverlay()
    }

    public static List<Marker> mapMarkers(BaiduMap map, List<OverlayOptions> list){
        int i = 0;
        List<Marker> markerList = new ArrayList<>();
        for(OverlayOptions overlayOptions:list){
            Marker marker = (Marker)map.addOverlay(overlayOptions);
            Bundle bundle = new Bundle();
            bundle.putInt("id",i);
            marker.setExtraInfo(bundle);
            markerList.add(marker);
            i++;
        }
        return markerList;
    }
}
