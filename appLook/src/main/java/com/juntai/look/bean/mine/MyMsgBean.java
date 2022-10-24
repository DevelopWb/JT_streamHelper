package com.juntai.look.bean.mine;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  我的消息
 * @CreateDate: 2020/7/28 15:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/28 15:00
 */
public class MyMsgBean extends BaseResult {
    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : {"datas":[{"id":3,"title":"王伟丽-申请修改：通过","content":"王伟丽-申请修改:申请修改通过","isRead":0,"logId":3,
     * "publishTime":"2020-07-26 11:49:18","caregiversId":1}],"total":2,"listSize":3,"pageCount":1}
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
         * datas : [{"id":3,"title":"王伟丽-申请修改：通过","content":"王伟丽-申请修改:申请修改通过","isRead":0,"logId":3,
         * "publishTime":"2020-07-26 11:49:18","caregiversId":1}]
         * total : 2
         * listSize : 3
         * pageCount : 1
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
             * id : 3
             * title : 王伟丽-申请修改：通过
             * content : 王伟丽-申请修改:申请修改通过
             * isRead : 0
             * logId : 3
             * publishTime : 2020-07-26 11:49:18
             * caregiversId : 1
             */

            private int id;
            private String title;
            private String content;
            private int isRead;
            private int logId;
            private String publishTime;
            private int caregiversId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getIsRead() {
                return isRead;
            }

            public void setIsRead(int isRead) {
                this.isRead = isRead;
            }

            public int getLogId() {
                return logId;
            }

            public void setLogId(int logId) {
                this.logId = logId;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public int getCaregiversId() {
                return caregiversId;
            }

            public void setCaregiversId(int caregiversId) {
                this.caregiversId = caregiversId;
            }
        }
    }
}
