package com.juntai.look.bean.search;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  搜索返回结果
 * @CreateDate: 2020/3/23 10:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/23 10:52
 */
public class SearchResultBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"datas":[{"id":64,"name":"册山镇","content":"山东省临沂市罗庄区","picture":"/cameraImg/f0e7b530a237476699282d76a78b14c9.jpeg","account":null,"imEi":null}],"total":1,"listSize":1,"pageCount":1}
     * type : null
     * message : null
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
         * datas : [{"id":64,"name":"册山镇","content":"山东省临沂市罗庄区","picture":"/cameraImg/f0e7b530a237476699282d76a78b14c9.jpeg","account":null,"imEi":null}]
         * total : 1
         * listSize : 1
         * pageCount : 1
         */

        private int total;//类型
        private int listSize;
        private int pageCount;


        private List<SearchBean.DataBean.SearchListBean> datas;

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

        public List<SearchBean.DataBean.SearchListBean> getDatas() {
            return datas;
        }

        public void setDatas(List<SearchBean.DataBean.SearchListBean> datas) {
            this.datas = datas;
        }

    }
}