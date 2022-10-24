package com.juntai.look.bean.careTaker;

import com.contrarywind.interfaces.IPickerViewData;
import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/25 9:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/25 9:11
 */
public class ServiceTypeBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * list : null
     * type : null
     * data : [{"id":1,"name":"卫生清洁服务大包"},{"id":2,"name":"入户调查"},{"id":12,"name":"摸底调查"}]
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean  implements IPickerViewData {
        /**
         * id : 1
         * name : 卫生清洁服务大包
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

        @Override
        public String getPickerViewText() {
            return name;
        }
    }
}
