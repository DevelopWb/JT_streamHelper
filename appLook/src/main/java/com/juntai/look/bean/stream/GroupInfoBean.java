package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/10/7 9:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/7 9:24
 */
public class GroupInfoBean extends BaseResult {
    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"id":3,"name":"我的家","count":45}
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
         * id : 3
         * name : 我的家
         * count : 45
         */

        private int id;
        private String name;
        private int count;

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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
