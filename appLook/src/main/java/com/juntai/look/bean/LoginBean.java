package com.juntai.look.bean;

import com.google.gson.annotations.SerializedName;
import com.juntai.wisdom.basecomponent.base.BaseResult;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/9 10:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/9 10:06
 */
public class LoginBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * list : null
     * type : null
     * data : {"id":1,"account":"admin","nickname":"管理员","password":"57eb72e6b78a87a12d46a7f5e9315138","sex":"男",
     * "status":1,"address":"临沂市","street":1,"streetName":"河东区","createTime":"2020-04-18 18:06:05",
     * "lastLoginTime":"2020-07-07 16:52:21","token":"B2AGYCW992-JEDHP8FB3821U7N57O7Q3-VUGDPCCK-0"}
     * success : true
     */

    private UserBean data;

    public UserBean getData() {
        return data;
    }

    public void setData(UserBean data) {
        this.data = data;
    }

    public static class UserBean {
        /**
         * id : 1
         * account : admin
         * nickname : 管理员
         * password : 57eb72e6b78a87a12d46a7f5e9315138
         * sex : 男
         * status : 1
         * address : 临沂市
         * street : 1
         * streetName : 河东区
         * createTime : 2020-04-18 18:06:05
         * lastLoginTime : 2020-07-07 16:52:21
         * token : B2AGYCW992-JEDHP8FB3821U7N57O7Q3-VUGDPCCK-0
         */

        private int id;
        private String account;
        private String nickname;
        private String password;
        private String sex;
        @SerializedName("status")
        private int statusX;
        private String address;
        private int street;
        private String streetName;
        private String createTime;
        private String lastLoginTime;
        private String token;
        private boolean test;//测试权限（false：关闭；true：开通）
        public int getId() {
            return id;
        }

        public boolean isTest() {
            return test;
        }

        public void setTest(boolean test) {
            this.test = test;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAccount() {
            return account == null ? "" : account;
        }

        public void setAccount(String account) {
            this.account = account == null ? "" : account;
        }

        public String getNickname() {
            return nickname == null ? "" : nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname == null ? "" : nickname;
        }

        public String getPassword() {
            return password == null ? "" : password;
        }

        public void setPassword(String password) {
            this.password = password == null ? "" : password;
        }

        public String getSex() {
            return sex == null ? "" : sex;
        }

        public void setSex(String sex) {
            this.sex = sex == null ? "" : sex;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }

        public String getAddress() {
            return address == null ? "" : address;
        }

        public void setAddress(String address) {
            this.address = address == null ? "" : address;
        }

        public int getStreet() {
            return street;
        }

        public void setStreet(int street) {
            this.street = street;
        }

        public String getStreetName() {
            return streetName == null ? "" : streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName == null ? "" : streetName;
        }

        public String getCreateTime() {
            return createTime == null ? "" : createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime == null ? "" : createTime;
        }

        public String getLastLoginTime() {
            return lastLoginTime == null ? "" : lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime == null ? "" : lastLoginTime;
        }

        public String getToken() {
            return token == null ? "" : token;
        }

        public void setToken(String token) {
            this.token = token == null ? "" : token;
        }
    }
}
