package com.juntai.wisdom.basecomponent.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述    云台录像记录
 * @CreateDate: 2020/8/20 16:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/20 16:03
 */
public class VideoInfoBean extends BaseStreamBean {

    /**
     * errcode : 0
     * errdesc : OK
     * totalsize : 313
     * onepagesize : 313
     * totalpage : 1
     * pageno : 1
     * count : 313
     * data : [{"channelid":"37130201561327011008","begintime":"2020-05-31T23:51:03","endtime":"2020-06-01T02:10:48",
     * "filename":"北立杆向北","type":"time","filesize":0,"frames":0,"framerate":0,"address":"Address 1","recorderid":""},
     * {"channelid":"37130201561327011008","begintime":"2020-06-30T16:50:45","endtime":"2020-06-30T19:09:41",
     * "filename":"北立杆向北","type":"time","filesize":0,"frames":0,"framerate":0,"address":"Address 1","recorderid":""}]
     */

    private int totalsize;
    private int onepagesize;
    private int totalpage;
    private int pageno;
    private int count;
    private List<DataBean> data;


    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
    }

    public int getOnepagesize() {
        return onepagesize;
    }

    public void setOnepagesize(int onepagesize) {
        this.onepagesize = onepagesize;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * channelid : 37130201561327011008
         * begintime : 2020-05-31T23:51:03
         * endtime : 2020-06-01T02:10:48
         * filename : 北立杆向北
         * type : time
         * filesize : 0
         * frames : 0
         * framerate : 0
         * address : Address 1
         * recorderid :
         */

        private String channelid;
        private String begintime;
        private String endtime;
        private String filename;
        private String type;
        private int filesize;
        private int frames;
        private int framerate;
        private String address;
        private String recorderid;

        public String getChannelid() {
            return channelid;
        }

        public void setChannelid(String channelid) {
            this.channelid = channelid;
        }

        public String getBegintime() {
            return begintime;
        }

        public void setBegintime(String begintime) {
            this.begintime = begintime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getFilesize() {
            return filesize;
        }

        public void setFilesize(int filesize) {
            this.filesize = filesize;
        }

        public int getFrames() {
            return frames;
        }

        public void setFrames(int frames) {
            this.frames = frames;
        }

        public int getFramerate() {
            return framerate;
        }

        public void setFramerate(int framerate) {
            this.framerate = framerate;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRecorderid() {
            return recorderid;
        }

        public void setRecorderid(String recorderid) {
            this.recorderid = recorderid;
        }
    }
}
