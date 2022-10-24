package com.juntai.look.bean.stream;

import android.os.Parcel;
import android.os.Parcelable;

import com.juntai.wisdom.basecomponent.base.BaseResult;

/**
 * @Author: tobato
 * @Description: 作用描述   摄像头详情
 * @CreateDate: 2020/6/3 8:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/3 8:34
 */
public class StreamCameraDetailBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"id":21,"number":"37131201561327001001","address":"山东省临沂市河东区解放东路","longitude":"118.400196",
     * "latitude":"35.073745","name":"国标测试01","ezopen":"/camera_img/53fc96c7ec664d22ac4c0327f5d11e36.jpeg",
     * "typeId":3,"typeName":"枪机","isYuntai":1,"isShare":0,"isOnline":0,"viewNum":6,"groupId":1,"groupName":"我的家",
     * "isMine":0}
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
         * id : 21
         * number : 37131201561327001001
         * address : 山东省临沂市河东区解放东路
         * longitude : 118.400196
         * latitude : 35.073745
         * name : 国标测试01
         * ezopen : /camera_img/53fc96c7ec664d22ac4c0327f5d11e36.jpeg
         * typeId : 3
         * typeName : 枪机
         * isYuntai : 1
         * isShare : 0
         * isOnline : 0
         * viewNum : 6
         * groupId : 1
         * groupName : 我的家
         * isMine : 0
         */
        /**
         * 分享选择类型ID
         */
        private int shareTypeId;
        /**
         * 分享选择类型名称
         */
        private String shareTypeName;
        /**
         * 分享权限名称（多个用英文,分隔）
         */
        private String sharePowerName;
        private int id;
        private String number;
        private String address;
        private String longitude;
        private String latitude;
        private String name;
        private String ezopen;
        private int typeId;
        private String typeName;
        private int isYuntai;
        private int isShare;
        private int isOnline;
        private int viewNum;
        private int groupId;
        private String groupName;
        private int isMine;

        public void setShareTypeId(int shareTypeId) {
            this.shareTypeId = shareTypeId;
        }

        public String getSharePowerName() {
            return sharePowerName == null ? "" : sharePowerName;
        }

        public void setSharePowerName(String sharePowerName) {
            this.sharePowerName = sharePowerName == null ? "" : sharePowerName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public Integer getShareTypeId() {
            return shareTypeId;
        }

        public void setShareTypeId(Integer shareTypeId) {
            this.shareTypeId = shareTypeId;
        }

        public String getShareTypeName() {
            return shareTypeName == null ? "" : shareTypeName;
        }

        public void setShareTypeName(String shareTypeName) {
            this.shareTypeName = shareTypeName == null ? "" : shareTypeName;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEzopen() {
            return ezopen;
        }

        public void setEzopen(String ezopen) {
            this.ezopen = ezopen;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getIsYuntai() {
            return isYuntai;
        }

        public void setIsYuntai(int isYuntai) {
            this.isYuntai = isYuntai;
        }

        public int getIsShare() {
            return isShare;
        }

        public void setIsShare(int isShare) {
            this.isShare = isShare;
        }

        public int getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(int isOnline) {
            this.isOnline = isOnline;
        }

        public int getViewNum() {
            return viewNum;
        }

        public void setViewNum(int viewNum) {
            this.viewNum = viewNum;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public int getIsMine() {
            return isMine;
        }

        public void setIsMine(int isMine) {
            this.isMine = isMine;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.shareTypeId);
            dest.writeString(this.shareTypeName);
            dest.writeString(this.sharePowerName);
            dest.writeInt(this.id);
            dest.writeString(this.number);
            dest.writeString(this.address);
            dest.writeString(this.longitude);
            dest.writeString(this.latitude);
            dest.writeString(this.name);
            dest.writeString(this.ezopen);
            dest.writeInt(this.typeId);
            dest.writeString(this.typeName);
            dest.writeInt(this.isYuntai);
            dest.writeInt(this.isShare);
            dest.writeInt(this.isOnline);
            dest.writeInt(this.viewNum);
            dest.writeInt(this.groupId);
            dest.writeString(this.groupName);
            dest.writeInt(this.isMine);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.shareTypeId = in.readInt();
            this.shareTypeName = in.readString();
            this.sharePowerName = in.readString();
            this.id = in.readInt();
            this.number = in.readString();
            this.address = in.readString();
            this.longitude = in.readString();
            this.latitude = in.readString();
            this.name = in.readString();
            this.ezopen = in.readString();
            this.typeId = in.readInt();
            this.typeName = in.readString();
            this.isYuntai = in.readInt();
            this.isShare = in.readInt();
            this.isOnline = in.readInt();
            this.viewNum = in.readInt();
            this.groupId = in.readInt();
            this.groupName = in.readString();
            this.isMine = in.readInt();
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
