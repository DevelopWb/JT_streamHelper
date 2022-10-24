package com.juntai.wisdom.basecomponent.bean;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/10/16 15:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/16 15:09
 */
public class RecordInfoBean extends BaseStreamBean {

    /**
     * videourl : rtmp://60.213.43.241:1935/video/http-1988776-1602830728-10420
     * strsessionid : http-1988776-1602830728-10420
     * filesize : 0
     * keepalivetime : 60
     * rtmpurl : rtmp://60.213.43.241:1935/video/http-1988776-1602830728-10420
     * hlsurl : http://60.213.43.241:8080/video/http-1988776-1602830728-10420.m3u8
     * flvurl : http://60.213.43.241:8080/video/http-1988776-1602830728-10420.flv
     * rtcurl : webrtc://60.213.43.241:32085/video/http-1988776-1602830728-10420
     */

    private String videourl;
    private String strsessionid;
    private int filesize;
    private int keepalivetime;
    private String rtmpurl;
    private String hlsurl;
    private String flvurl;
    private String rtcurl;

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getStrsessionid() {
        return strsessionid;
    }

    public void setStrsessionid(String strsessionid) {
        this.strsessionid = strsessionid;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public int getKeepalivetime() {
        return keepalivetime;
    }

    public void setKeepalivetime(int keepalivetime) {
        this.keepalivetime = keepalivetime;
    }

    public String getRtmpurl() {
        return rtmpurl;
    }

    public void setRtmpurl(String rtmpurl) {
        this.rtmpurl = rtmpurl;
    }

    public String getHlsurl() {
        return hlsurl;
    }

    public void setHlsurl(String hlsurl) {
        this.hlsurl = hlsurl;
    }

    public String getFlvurl() {
        return flvurl;
    }

    public void setFlvurl(String flvurl) {
        this.flvurl = flvurl;
    }

    public String getRtcurl() {
        return rtcurl;
    }

    public void setRtcurl(String rtcurl) {
        this.rtcurl = rtcurl;
    }
}
