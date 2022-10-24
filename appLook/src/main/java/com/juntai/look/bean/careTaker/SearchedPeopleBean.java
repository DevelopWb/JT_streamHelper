package com.juntai.look.bean.careTaker;

import com.google.gson.annotations.SerializedName;
import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  搜索的人  残疾人 托养人
 * @CreateDate: 2020/7/9 16:29
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/9 16:29
 */
public class SearchedPeopleBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : {"datas":[{"id":3,"caregiversId":null,"name":"孙宝怀","idNo":"372801197811286274",
     * "streetAddress":"九曲街道办事处","communityAddress":"郁九曲居委会","year":null,"status":2},{"id":2,"caregiversId":2,
     * "name":"刘学芹","idNo":"372801195907174825","streetAddress":"九曲街道办事处","communityAddress":"郁九曲居委会","year":"2020",
     * "status":1},{"id":1,"caregiversId":1,"name":"孙德亮","idNo":"372801195811026211","streetAddress":"九曲街道办事处",
     * "communityAddress":"郁九曲居委会","year":"2020","status":0}],"total":45,"listSize":3,"pageCount":15}
     * success : true
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * datas : [{"id":3,"caregiversId":null,"name":"孙宝怀","idNo":"372801197811286274","streetAddress":"九曲街道办事处",
         * "communityAddress":"郁九曲居委会","year":null,"status":2},{"id":2,"caregiversId":2,"name":"刘学芹",
         * "idNo":"372801195907174825","streetAddress":"九曲街道办事处","communityAddress":"郁九曲居委会","year":"2020","status":1
         * },{"id":1,"caregiversId":1,"name":"孙德亮","idNo":"372801195811026211","streetAddress":"九曲街道办事处",
         * "communityAddress":"郁九曲居委会","year":"2020","status":0}]
         * total : 45
         * listSize : 3
         * pageCount : 15
         */

        private int total;
        private int listSize;
        private int pageCount;
        private List<DatasBean> datas;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getListSize() {
            return listSize;
        }

        public void setListSize(int listSize) {
            this.listSize = listSize;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public List<DatasBean> getDatas() {
            if (datas == null) {
                return new ArrayList<>();
            }
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * id : 3
             * caregiversId : null
             * name : 孙宝怀
             * idNo : 372801197811286274
             * streetAddress : 九曲街道办事处
             * communityAddress : 郁九曲居委会
             * year : null
             * status : 2
             */

            private int id;
            private Object caregiversId;
            private String name;
            private String idNo;
            private String streetAddress;
            private String communityAddress;
            private String year;
            private String place;
            private String personImg;
            @SerializedName("status")
            private int statusX;

            public String getPlace() {
                return place == null ? "" : place;
            }

            public void setPlace(String place) {
                this.place = place == null ? "" : place;
            }

            private double longitude;
            private double latitude;

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

            public int getId() {
                return id;
            }

            public String getPersonImg() {
                return personImg == null ? "" : personImg;
            }

            public void setPersonImg(String personImg) {
                this.personImg = personImg == null ? "" : personImg;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getCaregiversId() {
                return caregiversId;
            }

            public void setCaregiversId(Object caregiversId) {
                this.caregiversId = caregiversId;
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

            public String getYear() {
                return year == null ? "" : year;
            }

            public void setYear(String year) {
                this.year = year == null ? "" : year;
            }

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }
        }
    }
}
