package com.juntai.look.bean.careTaker;

import com.contrarywind.interfaces.IPickerViewData;
import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  年份选择
 * @CreateDate: 2020/7/9 9:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/9 9:25
 */
public class YearsBean  extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : [{"id":1,"year":"2019"},{"id":2,"year":"2020"}]
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
         * year : 2019
         */

        private int id;
        private String year;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        @Override
        public String getPickerViewText() {
            return year;
        }
    }
}
