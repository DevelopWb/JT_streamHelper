package com.juntai.look.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述   服务记录实体类
 * @CreateDate: 2020/7/18 17:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/18 17:54
 */
public class ServiceRecordBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : [{"id":2,"name":"彭善想","idNo":"372801197205124830","streetAddress":"九曲街道办事处","communityAddress":"王于埠",
     * "personImg":"/case_image/cef7ea86b339419caabb92c5a3be3e33.jpeg","year":"2020","longitude":118.4019901,
     * "latitude":35.0905211},{"id":4,"name":"彭善想","idNo":"372801197205124830","streetAddress":"九曲街道办事处",
     * "communityAddress":"王于埠","personImg":"/case_image/cef7ea86b339419caabb92c5a3be3e33.jpeg","year":"2019",
     * "longitude":118.4019901,"latitude":35.0905211}]
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
         * id : 2
         * name : 彭善想
         * idNo : 372801197205124830
         * streetAddress : 九曲街道办事处
         * communityAddress : 王于埠
         * personImg : /case_image/cef7ea86b339419caabb92c5a3be3e33.jpeg
         * year : 2020
         * longitude : 118.4019901
         * latitude : 35.0905211
         */

        private int id;
        private String name;
        private String idNo;
        private String streetAddress;
        private String communityAddress;
        private String personImg;
        private String year;
        private String place;
        private double longitude;
        private double latitude;

        public String getPlace() {
            return place == null ? "" : place;
        }

        public void setPlace(String place) {
            this.place = place == null ? "" : place;
        }

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

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getCommunityAddress() {
            return communityAddress;
        }

        public void setCommunityAddress(String communityAddress) {
            this.communityAddress = communityAddress;
        }

        public String getPersonImg() {
            return personImg;
        }

        public void setPersonImg(String personImg) {
            this.personImg = personImg;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
    }
}
