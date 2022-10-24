package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  权限列表
 * @CreateDate: 2020/10/5 16:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/5 16:01
 */
public class PermissionListBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"id":1,"parentId":0,"name":"基础权限","list":[{"id":2,"parentId":1,"name":"视频预览","list":null},{"id":3,
     * "parentId":1,"name":"录像回放","list":null},{"id":4,"parentId":1,"name":"告警推送","list":null},{"id":5,"parentId":1,
     * "name":"云台控制","list":null}]}]
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
         * id : 1
         * parentId : 0
         * name : 基础权限
         * list : [{"id":2,"parentId":1,"name":"视频预览","list":null},{"id":3,"parentId":1,"name":"录像回放","list":null},{
         * "id":4,"parentId":1,"name":"告警推送","list":null},{"id":5,"parentId":1,"name":"云台控制","list":null}]
         */

        private int id;
        private int parentId;
        private String name;
        private List<ListBean> list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * parentId : 1
             * name : 视频预览
             * list : null
             */

            private int id;
            private int parentId;
            private String name;
            private boolean selected;
            private Object list;

            public int getId() {
                return id;
            }

            public boolean isSelected() {
                return selected;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getList() {
                return list;
            }

            public void setList(Object list) {
                this.list = list;
            }
        }
    }
}
