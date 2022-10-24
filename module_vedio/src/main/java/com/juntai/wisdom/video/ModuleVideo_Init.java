package com.juntai.wisdom.video;

import com.juntai.wisdom.basecomponent.utils.FileCacheUtils;
import com.mabeijianxi.smallvideorecord2.DeviceUtils;
import com.mabeijianxi.smallvideorecord2.JianXiCamera;

import java.io.File;

/**
 * 视频相关初始化
 * @aouther Ma
 * @date 2019/4/5
 */
public class ModuleVideo_Init {
    public static void init(){
        //初始化萤石
//        initVideoPlayer();
        //
        initSmallVideo();
    }
    /**
     * 初始视频拍摄
     */
    public static void initSmallVideo() {
        // 设置拍摄视频缓存路径
        //File dcim = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        //自定义的位置--/ChengGuan/video/
        File dcim = new File(FileCacheUtils.getAppVideoPath());
        if (DeviceUtils.isZte()) {
            if (dcim.exists()) {
                JianXiCamera.setVideoCachePath(dcim.getPath()+"/");
            } else {
                JianXiCamera.setVideoCachePath(dcim.getPath().replace("/sdcard/", "/sdcard-ext/")+"/");
            }
        } else {
            JianXiCamera.setVideoCachePath(dcim.getPath()+"/");
        }
        // 初始化拍摄，遇到问题可选择开启此标记，以方便生成日志
        JianXiCamera.initialize(true,null);
    }

//    /**
//     * 初始化萤石
//     */
//    public static void initVideoPlayer(){
//        //萤石初始化
//        /** * sdk日志开关，正式发布需要去掉 */
//        EZOpenSDK.showSDKLog(true);
//        /** * 设置是否支持P2P取流,详见api */
//        EZOpenSDK.enableP2P(false);
//    }
}
