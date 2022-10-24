package com.juntai.look.bean.stream;

import android.os.Parcel;
import android.os.Parcelable;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  被分享的用户列表
 * @CreateDate: 2020/10/5 17:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/5 17:07
 */
public class SharedUserBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"id":2,"shared":"15615691823","nickName":"韩国杰"},{"id":1,"shared":"17568086930","nickName":"王彬"}]
     * type : null
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
         * id : 2
         * shared : 15615691823
         * nickName : 韩国杰
         */

        private int id;
        private String shared;
        private String account;
        private String nickName;

        public String getAccount() {
            return account == null ? "" : account;
        }

        public void setAccount(String account) {
            this.account = account == null ? "" : account;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShared() {
            return shared;
        }

        public void setShared(String shared) {
            this.shared = shared;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.shared);
            dest.writeString(this.account);
            dest.writeString(this.nickName);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readInt();
            this.shared = in.readString();
            this.account = in.readString();
            this.nickName = in.readString();
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
