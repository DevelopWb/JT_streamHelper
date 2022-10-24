package com.juntai.look.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/3/22 10:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/22 10:13
 */
public class CityBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"id":1,"name":"北京","latitude":39.904987,"longitude":116.405289,"cityNum":110000},{"id":2,"name":"天津","latitude":39.125595,"longitude":117.190186,"cityNum":120000},{"id":3,"name":"河北省","latitude":38.045475,"longitude":114.502464,"cityNum":130000},{"id":4,"name":"山西省","latitude":37.857014,"longitude":112.549248,"cityNum":140000},{"id":5,"name":"内蒙古自治区","latitude":40.81831,"longitude":111.670799,"cityNum":150000},{"id":6,"name":"辽宁省","latitude":41.796768,"longitude":123.429092,"cityNum":210000},{"id":7,"name":"吉林省","latitude":43.886841,"longitude":125.324501,"cityNum":220000},{"id":8,"name":"黑龙江省","latitude":45.756966,"longitude":126.642464,"cityNum":230000},{"id":9,"name":"上海","latitude":31.231707,"longitude":121.472641,"cityNum":310000},{"id":10,"name":"江苏省","latitude":32.041546,"longitude":118.76741,"cityNum":320000},{"id":11,"name":"浙江省","latitude":30.287458,"longitude":120.15358,"cityNum":330000},{"id":12,"name":"安徽省","latitude":31.861191,"longitude":117.283043,"cityNum":340000},{"id":13,"name":"福建省","latitude":26.075302,"longitude":119.306236,"cityNum":350000},{"id":14,"name":"江西省","latitude":28.676493,"longitude":115.892151,"cityNum":360000},{"id":15,"name":"山东省","latitude":36.675808,"longitude":117.000923,"cityNum":370000},{"id":16,"name":"河南省","latitude":34.757977,"longitude":113.665413,"cityNum":410000},{"id":17,"name":"湖北省","latitude":30.584354,"longitude":114.298569,"cityNum":420000},{"id":18,"name":"湖南省","latitude":28.19409,"longitude":112.982277,"cityNum":430000},{"id":19,"name":"广东省","latitude":23.125177,"longitude":113.28064,"cityNum":440000},{"id":20,"name":"广西壮族自治区","latitude":22.82402,"longitude":108.320007,"cityNum":450000},{"id":21,"name":"海南省","latitude":20.031971,"longitude":110.331192,"cityNum":460000},{"id":22,"name":"重庆","latitude":29.533155,"longitude":106.504959,"cityNum":500000},{"id":23,"name":"四川省","latitude":30.659462,"longitude":104.065735,"cityNum":510000},{"id":24,"name":"贵州省","latitude":26.578342,"longitude":106.713478,"cityNum":520000},{"id":25,"name":"云南省","latitude":25.040609,"longitude":102.71225,"cityNum":530000},{"id":26,"name":"西藏自治区","latitude":29.66036,"longitude":91.13221,"cityNum":540000},{"id":27,"name":"陕西省","latitude":34.263161,"longitude":108.948021,"cityNum":610000},{"id":28,"name":"甘肃省","latitude":36.058041,"longitude":103.823555,"cityNum":620000},{"id":29,"name":"青海省","latitude":36.623177,"longitude":101.778915,"cityNum":630000},{"id":30,"name":"宁夏回族自治区","latitude":38.46637,"longitude":106.278175,"cityNum":640000},{"id":31,"name":"新疆维吾尔自治区","latitude":43.792816,"longitude":87.617729,"cityNum":650000},{"id":32,"name":"台湾","latitude":25.044333,"longitude":121.509064,"cityNum":710000},{"id":33,"name":"香港特别行政区","latitude":22.320047,"longitude":114.173355,"cityNum":810000},{"id":34,"name":"澳门特别行政区","latitude":22.198952,"longitude":113.549088,"cityNum":820000}]
     * type : null
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 1
         * name : 北京
         * latitude : 39.904987
         * longitude : 116.405289
         * cityNum : 110000
         */

        private int id;
        private String name;
        private double latitude;
        private double longitude;
        private int cityNum;

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

        public int getCityNum() {
            return cityNum;
        }

        public void setCityNum(int cityNum) {
            this.cityNum = cityNum;
        }
    }
}
