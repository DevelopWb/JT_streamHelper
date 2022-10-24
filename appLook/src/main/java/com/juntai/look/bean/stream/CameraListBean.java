package com.juntai.look.bean.stream;

import android.os.Parcel;
import android.os.Parcelable;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  nvr下的摄像头列表
 * @CreateDate: 2020/9/24 18:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/24 18:03
 */
public class CameraListBean extends BaseResult implements Parcelable {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * status : 200
     * data : [{"id":6,"number":"37130201561327011005","name":"南监控立杆向北",
     * "ezopen":"/camera_img/4f129690302d467190b9a6615cc67697.jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id
     * ":5,"number":"37130201561327011008","name":"北立杆向北","ezopen":"/camera_img/7378a3f686c045d1abdd026e5fd122fa
     * .jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id":4,"number":"37130201561327011003","name":"东关南立杆向南",
     * "ezopen":"/camera_img/dc724fa2e7f44a6eb33f6e18bf654a95.jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id
     * ":3,"number":"37130201561327011013","name":"一楼大厅北向南","ezopen":"/camera_img/17d0c4ed2ac24d3397a247d2845a9baf
     * .jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id":8,"number":"37130201561327011006","name":"北立杆向南车位方向",
     * "ezopen":"/camera_img/bc4f03f756ee4d1082622bb48bafb6e6.jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id
     * ":10,"number":"37130201561327011009","name":" 一楼大厅南向北","ezopen":"/camera_img/0b44b2c3d4fc4b0ea90da903101d0f9e
     * .jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id":7,"number":"37130201561327011007","name":"审讯室安全检查区",
     * "ezopen":"/camera_img/81da13036a9a483b9d79dd8ed06c823e.jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id
     * ":9,"number":"37130201561327011004","name":"全景球机","ezopen":"/camera_img/7ceff72845604b54a35dbda09ba3a4ff
     * .jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id":11,"number":"37130201561327011010","name":"楼顶西南角摄像头",
     * "ezopen":"/camera_img/51a87b87881c49eaafc1efef471d7e68.jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id
     * ":12,"number":"37130201561327011012","name":"楼顶西北角摄像头","ezopen":"/camera_img/196b27e570294aebb2479c93086030b8
     * .jpeg","isOnline":1,"isShared":1,"bindingFlag":1},{"id":13,"number":"37130201561327011011","name":"楼顶东北角摄像头",
     * "ezopen":"/camera_img/c2ada60ec0d549b0a9e757302065fada.jpeg","isOnline":1,"isShared":1,"bindingFlag":1}]
     * type : null
     * message : 查询成功！
     * success : true
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * id : 6
         * number : 37130201561327011005
         * name : 南监控立杆向北
         * ezopen : /camera_img/4f129690302d467190b9a6615cc67697.jpeg
         * isOnline : 1
         * isShared : 1
         * bindingFlag : 1
         */

        private int id;
        private String number;
        private String name;
        private String ezopen;
        private int isOnline;
        private int isShared;
        private int dvrFlag;
        private int groupId;
        private int bindingFlag;

        public int getDvrFlag() {
            return dvrFlag;
        }

        public void setDvrFlag(int dvrFlag) {
            this.dvrFlag = dvrFlag;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
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

        public int getBindingFlag() {
            return bindingFlag;
        }

        public void setBindingFlag(int bindingFlag) {
            this.bindingFlag = bindingFlag;
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
            dest.writeInt(this.isOnline);
            dest.writeInt(this.isShared);
            dest.writeInt(this.groupId);
            dest.writeInt(this.bindingFlag);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readInt();
            this.number = in.readString();
            this.name = in.readString();
            this.ezopen = in.readString();
            this.isOnline = in.readInt();
            this.isShared = in.readInt();
            this.groupId = in.readInt();
            this.bindingFlag = in.readInt();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.data);
    }

    public CameraListBean() {
    }

    protected CameraListBean(Parcel in) {
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<CameraListBean> CREATOR = new Parcelable.Creator<CameraListBean>() {
        @Override
        public CameraListBean createFromParcel(Parcel source) {
            return new CameraListBean(source);
        }

        @Override
        public CameraListBean[] newArray(int size) {
            return new CameraListBean[size];
        }
    };
}
