package com.juntai.look.homePage.map;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.model.LatLng;
import com.juntai.look.bean.ServicePeoplePositionBean;
import com.juntai.look.bean.stream.StreamCameraBean;
import com.juntai.look.hcb.R;
import com.juntai.wisdom.bdmap.utils.clusterutil.clustering.ClusterItem;

/**
 * author:wong
 * Date: 2019/3/22
 * Description:
 */
public class MapClusterItem implements ClusterItem {
    private BitmapDescriptor Bd;
    private LatLng latLng;
    private String type;
    //private ResponseCamera.Camera entity;
    public ServicePeoplePositionBean.DataBean  peoplePosition;
    public static final String STREAM_CAMERA = "stream_camera";
    public static final String CARE_POSITION = "care_position";//托养分布
    public static final String PEOPLE = "people";
    public StreamCameraBean.DataBean streamCamera;
//    public boolean isClicked;

    public MapClusterItem(LatLng latLng, StreamCameraBean.DataBean camera) {
        if (1==camera.getFlag()) {
            //硬盘录像机
            Bd = BitmapDescriptorFactory.fromResource(R.mipmap.steam_cameras_tip);
        }else {
            //独立摄像头
            Bd = BitmapDescriptorFactory.fromResource(R.mipmap.camera_tip);
        }
        this.latLng = latLng;
        this.type = STREAM_CAMERA;
        this.streamCamera = camera;
//        this.isClicked = false;
    }
    public MapClusterItem(LatLng latLng, ServicePeoplePositionBean.DataBean  peoplePosition) {
        Bd = BitmapDescriptorFactory.fromResource(R.mipmap.people_tip);
        this.latLng = latLng;
        this.type = PEOPLE;
        this.peoplePosition = peoplePosition;
    }





    public BitmapDescriptor getBd() {
        return Bd;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public String getType() {
        return type;
    }

    public void setBd(int res) {
        Bd = BitmapDescriptorFactory.fromResource(res);;
    }

    @Override
    public LatLng getPosition() {
        return latLng;
    }

    @Override
    public BitmapDescriptor getBitmapDescriptor() {
        return Bd;
    }

}