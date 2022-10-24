package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/5/31 13:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/5/31 13:50
 */
public class StreamCameraBean  extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * list : null
     * type : null
     * data : [{"id":3,"place":"永恒华府","latitude":35.07212,"longitude":118.366617,"flag":1,"remark":"永恒华府 能看到河的三岔口",
     * "ezopen":"https://www.juntaikeji.com:17002/cameraImg/thumbnail/37130201561327011001.jpeg",
     * "number":"37130201561327011001"},{"id":26,"place":"黄山镇西山","latitude":35.045528,"longitude":118.397357,
     * "flag":1,"remark":"黄山镇西山","ezopen":"https://www.juntaikeji.com:17002/cameraImg/thumbnail/37130201561327011016
     * .jpeg","number":"37130201561327011016"}]
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * place : 永恒华府
         * latitude : 35.07212
         * longitude : 118.366617
         * flag : 1
         * remark : 永恒华府 能看到河的三岔口
         * ezopen : https://www.juntaikeji.com:17002/cameraImg/thumbnail/37130201561327011001.jpeg
         * number : 37130201561327011001
         */

        private int id;
        private String name;
        private double latitude;
        private double longitude;
        private int flag;  //1是硬盘录像机 2是独立摄像头
        private String address;
        private String ezopen;
        private String number;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEzopen() {
            return ezopen;
        }

        public void setEzopen(String ezopen) {
            this.ezopen = ezopen;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
