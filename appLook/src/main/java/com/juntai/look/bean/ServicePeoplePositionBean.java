package com.juntai.look.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/22 17:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/22 17:42
 */
public class ServicePeoplePositionBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : [{"id":2,"name":"test","phone":"test","department":null,"street":"河东区",
     * "head":"/head_img/thumbnail/d010677248934f47a9bac391c2ffc8b8.jpeg","onlineState":0,"longitude":118.402088,
     * "latitude":35.090599},{"id":3,"name":"api","phone":"api","department":null,"street":"河东区",
     * "head":"/caregivers_img/2020-07/thumbnail/23550acf12b94f38932e3eb0c00a7006.jpeg","onlineState":0,
     * "longitude":118.402081,"latitude":35.090588}]
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
         * name : test
         * phone : test
         * department : null
         * street : 河东区
         * head : /head_img/thumbnail/d010677248934f47a9bac391c2ffc8b8.jpeg
         * onlineState : 0
         * longitude : 118.402088
         * latitude : 35.090599
         */

        private int id;
        private String name;
        private String phone;
        private Object department;
        private String street;
        private String head;
        private int onlineState;
        private double longitude;
        private double latitude;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getDepartment() {
            return department;
        }

        public void setDepartment(Object department) {
            this.department = department;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public int getOnlineState() {
            return onlineState;
        }

        public void setOnlineState(int onlineState) {
            this.onlineState = onlineState;
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
