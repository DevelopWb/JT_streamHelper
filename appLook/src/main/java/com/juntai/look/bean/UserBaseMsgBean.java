package com.juntai.look.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;

import java.util.stream.BaseStream;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/25 17:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/25 17:16
 */
public class UserBaseMsgBean extends BaseStreamBean {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"id":99,"account":"17568086930","password":"56c1bf4b5b23aea41d4dc274f506c9ef","realName":"王彬",
     * "nickName":"王彬","idNumber":"371325198702255555","headPortrait":"/head_img/87f69d64e77648eea17118bab4771080
     * .jpeg","applyForNumber":"20200521164737131","phoneNumber":"17568086930","sex":0,
     * "weChatId":"oEsEVs6HkwCQS-GuT4vlomISCrS8","weChatName":"dG9iYXRv","qqId":"65E26B99A23B654AA59612920747D781",
     * "qqName":"Xw==","workAddress":null,"permanentAddress":null,"realNameStatus":2,"auditOpinion":"审核通过",
     * "rongYunToken":"UEuorJf6JtsomTq7Zs1kY4M7TTnyliJKuJ+CCyHJ2jJtQDP7WhUHZA==@thdm.cn.rongnav.com;thdm.cn.rongcfg
     * .com","status":0,"frozenStatus":0,"gmtCreate":"2020-04-20 10:10:52","lastLoginTime":"2020-08-22 14:34:14",
     * "faceTimeType":0,"appType":1,"flag":1,"score":79,"blacklist":0,
     * "token":"B2AGQ5Q992-RDNI9QK40R5FOC0E8ID53-W00FA5EK-4"}
     * type : null
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * id : 99
         * account : 17568086930
         * password : 56c1bf4b5b23aea41d4dc274f506c9ef
         * realName : 王彬
         * nickName : 王彬
         * idNumber : 371325198702255555
         * headPortrait : /head_img/87f69d64e77648eea17118bab4771080.jpeg
         * applyForNumber : 20200521164737131
         * phoneNumber : 17568086930
         * sex : 0
         * weChatId : oEsEVs6HkwCQS-GuT4vlomISCrS8
         * weChatName : dG9iYXRv
         * qqId : 65E26B99A23B654AA59612920747D781
         * qqName : Xw==
         * workAddress : null
         * permanentAddress : null
         * realNameStatus : 2
         * auditOpinion : 审核通过
         * rongYunToken : UEuorJf6JtsomTq7Zs1kY4M7TTnyliJKuJ+CCyHJ2jJtQDP7WhUHZA==@thdm.cn.rongnav.com;thdm.cn
         * .rongcfg.com
         * status : 0
         * frozenStatus : 0
         * gmtCreate : 2020-04-20 10:10:52
         * lastLoginTime : 2020-08-22 14:34:14
         * faceTimeType : 0
         * appType : 1
         * flag : 1
         * score : 79
         * blacklist : 0
         * token : B2AGQ5Q992-RDNI9QK40R5FOC0E8ID53-W00FA5EK-4
         */

        private int id;
        private String account;
        private String password;
        private String realName;
        private String nickName;
        private String idNumber;
        private String headPortrait;
        private String applyForNumber;
        private String phoneNumber;
        private int sex;
        private String weChatId;
        private String weChatName;
        private String qqId;
        private String qqName;
        private String workAddress;
        private String permanentAddress;
        private int realNameStatus;
        private String auditOpinion;
        private String rongYunToken;
        @SerializedName("status")
        private int statusX;
        private int frozenStatus;
        private String gmtCreate;
        private String lastLoginTime;
        private int faceTimeType;
        private int appType;
        private int flag;
        private int score;
        private int blacklist;
        private String token;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(String headPortrait) {
            this.headPortrait = headPortrait;
        }

        public String getApplyForNumber() {
            return applyForNumber;
        }

        public void setApplyForNumber(String applyForNumber) {
            this.applyForNumber = applyForNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getWeChatId() {
            return weChatId;
        }

        public void setWeChatId(String weChatId) {
            this.weChatId = weChatId;
        }

        public String getWeChatName() {
            return weChatName;
        }

        public void setWeChatName(String weChatName) {
            this.weChatName = weChatName;
        }

        public String getQqId() {
            return qqId;
        }

        public void setQqId(String qqId) {
            this.qqId = qqId;
        }

        public String getQqName() {
            return qqName;
        }

        public void setQqName(String qqName) {
            this.qqName = qqName;
        }

        public String getWorkAddress() {
            return workAddress == null ? "" : workAddress;
        }

        public void setWorkAddress(String workAddress) {
            this.workAddress = workAddress == null ? "" : workAddress;
        }

        public String getPermanentAddress() {
            return permanentAddress == null ? "" : permanentAddress;
        }

        public void setPermanentAddress(String permanentAddress) {
            this.permanentAddress = permanentAddress == null ? "" : permanentAddress;
        }

        public int getRealNameStatus() {
            return realNameStatus;
        }

        public void setRealNameStatus(int realNameStatus) {
            this.realNameStatus = realNameStatus;
        }

        public String getAuditOpinion() {
            return auditOpinion;
        }

        public void setAuditOpinion(String auditOpinion) {
            this.auditOpinion = auditOpinion;
        }

        public String getRongYunToken() {
            return rongYunToken;
        }

        public void setRongYunToken(String rongYunToken) {
            this.rongYunToken = rongYunToken;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }

        public int getFrozenStatus() {
            return frozenStatus;
        }

        public void setFrozenStatus(int frozenStatus) {
            this.frozenStatus = frozenStatus;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public int getFaceTimeType() {
            return faceTimeType;
        }

        public void setFaceTimeType(int faceTimeType) {
            this.faceTimeType = faceTimeType;
        }

        public int getAppType() {
            return appType;
        }

        public void setAppType(int appType) {
            this.appType = appType;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getBlacklist() {
            return blacklist;
        }

        public void setBlacklist(int blacklist) {
            this.blacklist = blacklist;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.account);
            dest.writeString(this.password);
            dest.writeString(this.realName);
            dest.writeString(this.nickName);
            dest.writeString(this.idNumber);
            dest.writeString(this.headPortrait);
            dest.writeString(this.applyForNumber);
            dest.writeString(this.phoneNumber);
            dest.writeInt(this.sex);
            dest.writeString(this.weChatId);
            dest.writeString(this.weChatName);
            dest.writeString(this.qqId);
            dest.writeString(this.qqName);
            dest.writeString(this.workAddress);
            dest.writeString(this.permanentAddress);
            dest.writeInt(this.realNameStatus);
            dest.writeString(this.auditOpinion);
            dest.writeString(this.rongYunToken);
            dest.writeInt(this.statusX);
            dest.writeInt(this.frozenStatus);
            dest.writeString(this.gmtCreate);
            dest.writeString(this.lastLoginTime);
            dest.writeInt(this.faceTimeType);
            dest.writeInt(this.appType);
            dest.writeInt(this.flag);
            dest.writeInt(this.score);
            dest.writeInt(this.blacklist);
            dest.writeString(this.token);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readInt();
            this.account = in.readString();
            this.password = in.readString();
            this.realName = in.readString();
            this.nickName = in.readString();
            this.idNumber = in.readString();
            this.headPortrait = in.readString();
            this.applyForNumber = in.readString();
            this.phoneNumber = in.readString();
            this.sex = in.readInt();
            this.weChatId = in.readString();
            this.weChatName = in.readString();
            this.qqId = in.readString();
            this.qqName = in.readString();
            this.workAddress = in.readString();
            this.permanentAddress = in.readString();
            this.realNameStatus = in.readInt();
            this.auditOpinion = in.readString();
            this.rongYunToken = in.readString();
            this.statusX = in.readInt();
            this.frozenStatus = in.readInt();
            this.gmtCreate = in.readString();
            this.lastLoginTime = in.readString();
            this.faceTimeType = in.readInt();
            this.appType = in.readInt();
            this.flag = in.readInt();
            this.score = in.readInt();
            this.blacklist = in.readInt();
            this.token = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
