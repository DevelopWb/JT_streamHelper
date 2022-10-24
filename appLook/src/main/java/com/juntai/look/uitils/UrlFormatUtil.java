package com.juntai.look.uitils;


import com.juntai.look.AppHttpPath;

/**
 * author:wong
 * Date: 2019/3/27
 * Description:
 */
public class UrlFormatUtil {


    /**
     * 内容图片url拼接
     *
     * @param path
     * @return
     */
    public static String formatPicUrl(String path) {
        return AppHttpPath.BASE_IMAGE + path;
    }
    /**
     * 内容图片url拼接
     *
     * @param //STREAM_CAMERA_THUMBNAI_IMAGE
     * @return
     */
    public static String formatStreamCapturePicUrl(String  url) {
        return  String.format("%s%s", AppHttpPath.THUMB_ADDR , url);
    }


}
