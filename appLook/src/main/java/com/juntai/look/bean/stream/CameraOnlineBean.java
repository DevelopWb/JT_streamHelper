package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/10/21 16:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/21 16:11
 */
public class CameraOnlineBean extends BaseStreamBean {


    /**
     * callnum : 1
     * callinfo : [{"prototype":0,"playtype":1,"chanpubid":"11010000001320002060","channame":"IPC_DAHUA",
     * "sessionid":"http-370306-1603073380-0","starttime":"0","endtime":"0","streamrecvip":"192.168.12.10",
     * "streamrecvport":31100,"streamsendip":"192.168.12.206","streamsendport":10538,"rtspurl":"rtsp://192.168.12
     * .10:7554/DevAor=11010000001320002060","rtmpurl":"rtmp://192.168.12.10:32035/video/11010000001320002060",
     * "hlsurl":"http://192.168.12.10:32080/video/11010000001320002060.m3u8","flvurl":"http://192.168.12
     * .10:32080/video/11010000001320002060.flv","rtcurl":"webrtc://192.168.12.10:32085/video/11010000001320002060"}]
     */

    private int callnum;
    private List<CallinfoBean> callinfo;

    public int getCallnum() {
        return callnum;
    }

    public void setCallnum(int callnum) {
        this.callnum = callnum;
    }

    public List<CallinfoBean> getCallinfo() {
        return callinfo;
    }

    public void setCallinfo(List<CallinfoBean> callinfo) {
        this.callinfo = callinfo;
    }

    public static class CallinfoBean {
        /**
         * prototype : 0
         * playtype : 1
         * chanpubid : 11010000001320002060
         * channame : IPC_DAHUA
         * sessionid : http-370306-1603073380-0
         * starttime : 0
         * endtime : 0
         * streamrecvip : 192.168.12.10
         * streamrecvport : 31100
         * streamsendip : 192.168.12.206
         * streamsendport : 10538
         * rtspurl : rtsp://192.168.12.10:7554/DevAor=11010000001320002060
         * rtmpurl : rtmp://192.168.12.10:32035/video/11010000001320002060
         * hlsurl : http://192.168.12.10:32080/video/11010000001320002060.m3u8
         * flvurl : http://192.168.12.10:32080/video/11010000001320002060.flv
         * rtcurl : webrtc://192.168.12.10:32085/video/11010000001320002060
         */

        private int prototype;
        private int playtype;
        private String chanpubid;
        private String channame;
        private String sessionid;
        private String starttime;
        private String endtime;
        private String streamrecvip;
        private int streamrecvport;
        private String streamsendip;
        private int streamsendport;
        private String rtspurl;
        private String rtmpurl;
        private String hlsurl;
        private String flvurl;
        private String rtcurl;

        public int getPrototype() {
            return prototype;
        }

        public void setPrototype(int prototype) {
            this.prototype = prototype;
        }

        public int getPlaytype() {
            return playtype;
        }

        public void setPlaytype(int playtype) {
            this.playtype = playtype;
        }

        public String getChanpubid() {
            return chanpubid;
        }

        public void setChanpubid(String chanpubid) {
            this.chanpubid = chanpubid;
        }

        public String getChanname() {
            return channame;
        }

        public void setChanname(String channame) {
            this.channame = channame;
        }

        public String getSessionid() {
            return sessionid;
        }

        public void setSessionid(String sessionid) {
            this.sessionid = sessionid;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getStreamrecvip() {
            return streamrecvip;
        }

        public void setStreamrecvip(String streamrecvip) {
            this.streamrecvip = streamrecvip;
        }

        public int getStreamrecvport() {
            return streamrecvport;
        }

        public void setStreamrecvport(int streamrecvport) {
            this.streamrecvport = streamrecvport;
        }

        public String getStreamsendip() {
            return streamsendip;
        }

        public void setStreamsendip(String streamsendip) {
            this.streamsendip = streamsendip;
        }

        public int getStreamsendport() {
            return streamsendport;
        }

        public void setStreamsendport(int streamsendport) {
            this.streamsendport = streamsendport;
        }

        public String getRtspurl() {
            return rtspurl;
        }

        public void setRtspurl(String rtspurl) {
            this.rtspurl = rtspurl;
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
}
