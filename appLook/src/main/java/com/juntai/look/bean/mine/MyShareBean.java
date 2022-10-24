package com.juntai.look.bean.mine;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  我的分享
 * @CreateDate: 2020/10/5 15:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/5 15:37
 */
public class MyShareBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"datas":[{"id":2,"videoId":21,"number":"37131201561327001001","name":"国标测试01",
     * "ezopen":"/camera_img/53fc96c7ec664d22ac4c0327f5d11e36.jpeg","address":"山东省临沂市河东区解放东路"},{"id":1,"videoId":1,
     * "number":"37131201561327001002","name":"GB28181-Test01","ezopen":"/camera_img/01242e2cd2e84f92bd199683a0a82c82
     * .jpeg","address":"公司照着出口的"}],"total":2,"listSize":2,"pageCount":10}
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
         * datas : [{"id":2,"videoId":21,"number":"37131201561327001001","name":"国标测试01",
         * "ezopen":"/camera_img/53fc96c7ec664d22ac4c0327f5d11e36.jpeg","address":"山东省临沂市河东区解放东路"},{"id":1,
         * "videoId":1,"number":"37131201561327001002","name":"GB28181-Test01",
         * "ezopen":"/camera_img/01242e2cd2e84f92bd199683a0a82c82.jpeg","address":"公司照着出口的"}]
         * total : 2
         * listSize : 2
         * pageCount : 10
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

        public static class DatasBean {
            /**
             * id : 2
             * videoId : 21
             * number : 37131201561327001001
             * name : 国标测试01
             * ezopen : /camera_img/53fc96c7ec664d22ac4c0327f5d11e36.jpeg
             * address : 山东省临沂市河东区解放东路
             */

            private int id;
            private int videoId;
            private String number;
            private String name;
            private String ezopen;
            private boolean selected;
            private boolean edit;
            private String address;
            private String sharedName;
            private String shareTime;

            public String getSharedName() {
                return sharedName == null ? "" : sharedName;
            }

            public void setSharedName(String sharedName) {
                this.sharedName = sharedName == null ? "" : sharedName;
            }

            public String getShareTime() {
                return shareTime == null ? "" : shareTime;
            }

            public void setShareTime(String shareTime) {
                this.shareTime = shareTime == null ? "" : shareTime;
            }

            public boolean isEdit() {
                return edit;
            }

            public void setEdit(boolean edit) {
                this.edit = edit;
            }

            public boolean isSelected() {
                return selected;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
        }
    }
}
