package com.juntai.look.bean.stream;

import android.os.Parcel;
import android.os.Parcelable;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  分组下的摄像头或者硬盘录像机
 * @CreateDate: 2020/9/24 15:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/24 15:27
 */
public class DevListBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"total":45,"list":[{"id":2,"number":"37130201561187053901","name":"东关街NVR",
     * "ezopen":"/camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg","dvrFlag":1,"dvrId":"0","count":11,"isOnline":1,
     * "isShared":1},{"id":24,"number":"37132301561327000001","name":"地下画廊",
     * "ezopen":"/camera_img/f246be2ae9144e2499972d08dd7ee360.jpeg","dvrFlag":0,"dvrId":"0","count":0,"isOnline":1,
     * "isShared":1}]}
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
         * total : 45
         * list : [{"id":2,"number":"37130201561187053901","name":"东关街NVR",
         * "ezopen":"/camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg","dvrFlag":1,"dvrId":"0","count":11,
         * "isOnline":1,"isShared":1},{"id":24,"number":"37132301561327000001","name":"地下画廊",
         * "ezopen":"/camera_img/f246be2ae9144e2499972d08dd7ee360.jpeg","dvrFlag":0,"dvrId":"0","count":0,
         * "isOnline":1,"isShared":1}]
         */

        private int total;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Parcelable {
            /**
             * id : 2
             * number : 37130201561187053901
             * name : 东关街NVR
             * ezopen : /camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg
             * dvrFlag : 1
             * dvrId : 0
             * count : 11
             * isOnline : 1
             * isShared : 1
             */

            private int id;
            private String number;
            private String name;
            private String offlineTime;
            private String ezopen;
            private int dvrFlag;//1是nvr  0是普通摄像
            private int groupId;
            private String dvrId;
            private int count;
            private int isOnline;
            private int isShared;
            private boolean selected;

            public String getOfflineTime() {
                return offlineTime == null ? "" : offlineTime;
            }

            public void setOfflineTime(String offlineTime) {
                this.offlineTime = offlineTime == null ? "" : offlineTime;
            }

            public boolean isSelected() {
                return selected;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public int getGroupId() {
                return groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            /**
             * 设备绑定标识（0未绑定；1已绑定）  是否绑定nvr
             */
            private Integer bindingFlag;
            public int getId() {
                return id;
            }

            public Integer getBindingFlag() {
                return bindingFlag;
            }

            public void setBindingFlag(Integer bindingFlag) {
                this.bindingFlag = bindingFlag;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
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

            public int getDvrFlag() {
                return dvrFlag;
            }

            public void setDvrFlag(int dvrFlag) {
                this.dvrFlag = dvrFlag;
            }

            public String getDvrId() {
                return dvrId;
            }

            public void setDvrId(String dvrId) {
                this.dvrId = dvrId;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getIsOnline() {
                return isOnline;
            }

            public void setIsOnline(int isOnline) {
                this.isOnline = isOnline;
            }

            public int getIsShared() {
                return isShared;
            }

            public void setIsShared(int isShared) {
                this.isShared = isShared;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.number);
                dest.writeString(this.name);
                dest.writeString(this.ezopen);
                dest.writeInt(this.dvrFlag);
                dest.writeInt(this.groupId);
                dest.writeString(this.dvrId);
                dest.writeInt(this.count);
                dest.writeInt(this.isOnline);
                dest.writeInt(this.isShared);
                dest.writeByte(this.selected ? (byte) 1 : (byte) 0);
                dest.writeValue(this.bindingFlag);
            }

            public ListBean() {
            }

            protected ListBean(Parcel in) {
                this.id = in.readInt();
                this.number = in.readString();
                this.name = in.readString();
                this.ezopen = in.readString();
                this.dvrFlag = in.readInt();
                this.groupId = in.readInt();
                this.dvrId = in.readString();
                this.count = in.readInt();
                this.isOnline = in.readInt();
                this.isShared = in.readInt();
                this.selected = in.readByte() != 0;
                this.bindingFlag = (Integer) in.readValue(Integer.class.getClassLoader());
            }

            public static final Parcelable.Creator<ListBean> CREATOR = new Parcelable.Creator<ListBean>() {
                @Override
                public ListBean createFromParcel(Parcel source) {
                    return new ListBean(source);
                }

                @Override
                public ListBean[] newArray(int size) {
                    return new ListBean[size];
                }
            };
        }
    }
}
