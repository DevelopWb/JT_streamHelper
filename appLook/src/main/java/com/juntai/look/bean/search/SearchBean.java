package com.juntai.look.bean.search;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  搜索结果
 * @CreateDate: 2020/4/29 10:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/29 10:11
 */
public class SearchBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"count":2,"typeId":1,"typeName":"视频","searchList":[{"id":1,"number":"37131201561327001002",
     * "ezopen":"/camera_img/01242e2cd2e84f92bd199683a0a82c82.jpeg","address":"中国山东省临沂市河东区九曲街道人民大街中段","name":"002",
     * "dvrFlag":0},{"id":21,"number":"37131201561327001001","ezopen":"/camera_img/53fc96c7ec664d22ac4c0327f5d11e36
     * .jpeg","address":"山东省临沂市河东区解放东路","name":"国标测试01","dvrFlag":0}]},{"count":1,"typeId":2,"typeName":"分组",
     * "searchList":[{"id":6,"number":null,"ezopen":"4","address":"0","name":"喜欢1","dvrFlag":null}]}]
     * type : null
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
         * count : 2
         * typeId : 1
         * typeName : 视频
         * searchList : [{"id":1,"number":"37131201561327001002",
         * "ezopen":"/camera_img/01242e2cd2e84f92bd199683a0a82c82.jpeg","address":"中国山东省临沂市河东区九曲街道人民大街中段",
         * "name":"002","dvrFlag":0},{"id":21,"number":"37131201561327001001",
         * "ezopen":"/camera_img/53fc96c7ec664d22ac4c0327f5d11e36.jpeg","address":"山东省临沂市河东区解放东路","name":"国标测试01",
         * "dvrFlag":0}]
         */

        private int count;
        private int typeId;
        private String typeName;
        private List<SearchListBean> searchList;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
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

        public List<SearchListBean> getSearchList() {
            return searchList;
        }

        public void setSearchList(List<SearchListBean> searchList) {
            this.searchList = searchList;
        }

        public static class SearchListBean {
            /**
             * id : 1
             * number : 37131201561327001002
             * ezopen : /camera_img/01242e2cd2e84f92bd199683a0a82c82.jpeg
             * address : 中国山东省临沂市河东区九曲街道人民大街中段
             * name : 002
             * dvrFlag : 0
             */

            private int id;
            private String number;
            private String ezopen;
            private String address;
            private String name;
            private int dvrFlag;
            private int resultType;//搜索结果的类型

            public int getResultType() {
                return resultType;
            }

            public void setResultType(int resultType) {
                this.resultType = resultType;
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

            public String getEzopen() {
                return ezopen;
            }

            public void setEzopen(String ezopen) {
                this.ezopen = ezopen;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getDvrFlag() {
                return dvrFlag;
            }

            public void setDvrFlag(int dvrFlag) {
                this.dvrFlag = dvrFlag;
            }
        }
    }
}
