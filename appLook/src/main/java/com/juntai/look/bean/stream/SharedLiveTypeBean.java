package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/10/7 17:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/7 17:01
 */
public class SharedLiveTypeBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"id":5,"name":"农牧"},{"id":4,"name":"手工"},{"id":3,"name":"旅途"},{"id":2,"name":"美食"},{"id":1,"name":"风景"}]
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
         * id : 5
         * name : 农牧
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
