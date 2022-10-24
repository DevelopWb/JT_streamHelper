package com.juntai.look.bean.careTaker;

import com.contrarywind.interfaces.IPickerViewData;
import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  服务人员
 * @CreateDate: 2020/7/14 16:28
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/14 16:28
 */
public class ServicePeoplesBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : [{"id":1,"street":"河东区","servicerVOsVos":[]},{"id":11,"street":"区直","servicerVOsVos":[{"id":2,
     * "name":"牛爱花"},{"id":1,"name":"星仔"}]},{"id":14,"street":"朝阳街道","servicerVOsVos":[]}]
     * success : true
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements IPickerViewData {
        /**
         * id : 1
         * street : 河东区
         * servicerVOsVos : []
         */

        private int id;
        private String street;
        private List<ServicerVOsVosBean> servicerVOsVos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public List<ServicerVOsVosBean> getServicerVOsVos() {
            return servicerVOsVos;
        }

        public void setServicerVOsVos(List<ServicerVOsVosBean> servicerVOsVos) {
            this.servicerVOsVos = servicerVOsVos;
        }

        @Override
        public String getPickerViewText() {
            return street;
        }

        public class ServicerVOsVosBean{
            private int id;
            private String name;
            private String head;
            private boolean isSelected;

            @Override
            public String toString() {
                return "ServicerVOsVosBean{" +
                        "name='" + name + '\'' +
                        '}';
            }

            public boolean isSelected() {
                return isSelected;
            }

            public void setSelected(boolean selected) {
                isSelected = selected;
            }

            public String getHead() {
                return head == null ? "" : head;
            }

            public void setHead(String head) {
                this.head = head == null ? "" : head;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name == null ? "" : name;
            }

            public void setName(String name) {
                this.name = name == null ? "" : name;
            }
        }
    }
}
