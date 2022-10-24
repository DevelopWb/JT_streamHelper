package com.juntai.look.bean.stream;

import android.os.Parcel;
import android.os.Parcelable;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  待添加的设备
 * @CreateDate: 2020/9/25 10:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/25 10:49
 */
public class DevToAddBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"datas":[{"id":1,"number":"37131201561327001002","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":2,"number":"37130201561187053901","typeCode":"118","typeName":"硬盘录像机","bindingFlag":1,
     * "count":11},{"id":43,"number":"37130201561327011013","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":42,"number":"37130201561327011003","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":41,"number":"37130201561327011008","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":40,"number":"37130201561327011005","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":46,"number":"37130201561327011007","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":44,"number":"37130201561327011006","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":47,"number":"37130201561327011004","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":45,"number":"37130201561327011009","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":48,"number":"37130201561327011010","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0},{"id":49,"number":"37130201561327011012","typeCode":"132","typeName":"摄像头","bindingFlag":1,
     * "count":0}],"total":50,"listSize":12,"pageCount":12}
     * type : null
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
         * datas : [{"id":1,"number":"37131201561327001002","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":2,"number":"37130201561187053901","typeCode":"118","typeName":"硬盘录像机","bindingFlag":1,
         * "count":11},{"id":43,"number":"37130201561327011013","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":42,"number":"37130201561327011003","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":41,"number":"37130201561327011008","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":40,"number":"37130201561327011005","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":46,"number":"37130201561327011007","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":44,"number":"37130201561327011006","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":47,"number":"37130201561327011004","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":45,"number":"37130201561327011009","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":48,"number":"37130201561327011010","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0},{"id":49,"number":"37130201561327011012","typeCode":"132","typeName":"摄像头","bindingFlag":1,
         * "count":0}]
         * total : 50
         * listSize : 12
         * pageCount : 12
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
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean implements Parcelable {
            /**
             * id : 1
             * number : 37131201561327001002
             * typeCode : 132
             * typeName : 摄像头
             * bindingFlag : 1
             * count : 0
             */

            private int id;
            private String number;
            private String typeCode;
            private String typeName;
            private int bindingFlag;
            private int count;

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

            public String getTypeCode() {
                return typeCode;
            }

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public int getBindingFlag() {
                return bindingFlag;
            }

            public void setBindingFlag(int bindingFlag) {
                this.bindingFlag = bindingFlag;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.number);
                dest.writeString(this.typeCode);
                dest.writeString(this.typeName);
                dest.writeInt(this.bindingFlag);
                dest.writeInt(this.count);
            }

            public DatasBean() {
            }

            protected DatasBean(Parcel in) {
                this.id = in.readInt();
                this.number = in.readString();
                this.typeCode = in.readString();
                this.typeName = in.readString();
                this.bindingFlag = in.readInt();
                this.count = in.readInt();
            }

            public static final Parcelable.Creator<DatasBean> CREATOR = new Parcelable.Creator<DatasBean>() {
                @Override
                public DatasBean createFromParcel(Parcel source) {
                    return new DatasBean(source);
                }

                @Override
                public DatasBean[] newArray(int size) {
                    return new DatasBean[size];
                }
            };
        }
    }
}
