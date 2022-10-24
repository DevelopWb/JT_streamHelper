package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述 预置位实体类
 * @CreateDate: 2020/10/15 17:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/15 17:15
 */
public class PreSetBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"id":29,"number":"37131201561327001002","position":0,
     * "picture":"/camera_ptz_collect_img/f1d9ccfec73d464cae272495b61cffef.jpeg"},{"id":37,
     * "number":"37131201561327001002","position":8,
     * "picture":"/camera_ptz_collect_img/3586004c3df449cc8ae059641d0095c1.jpeg"},{"id":36,
     * "number":"37131201561327001002","position":7,
     * "picture":"/camera_ptz_collect_img/ad2c61c68cd6435b89c5a5398a59a506.jpeg"},{"id":35,
     * "number":"37131201561327001002","position":6,
     * "picture":"/camera_ptz_collect_img/43cfe814bc2147d7ad35f214e560bb61.jpeg"},{"id":33,
     * "number":"37131201561327001002","position":4,
     * "picture":"/camera_ptz_collect_img/6d2df92ae4a744d3b5bbd1a479548ef0.jpeg"},{"id":34,
     * "number":"37131201561327001002","position":5,
     * "picture":"/camera_ptz_collect_img/b8c57bb8b6cc4d7a85e78e497fa0aed0.jpeg"},{"id":32,
     * "number":"37131201561327001002","position":3,
     * "picture":"/camera_ptz_collect_img/b33248d3d0e84f3aa8b1f58f41b24fe5.jpeg"},{"id":31,
     * "number":"37131201561327001002","position":2,
     * "picture":"/camera_ptz_collect_img/277bb1ceaf9b432cae9ac1f77fb49ebb.jpeg"},{"id":30,
     * "number":"37131201561327001002","position":1,
     * "picture":"/camera_ptz_collect_img/85db81dedfa84a829ab5d4a20f03fde3.jpeg"}]
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
         * id : 29
         * number : 37131201561327001002
         * position : 0
         * picture : /camera_ptz_collect_img/f1d9ccfec73d464cae272495b61cffef.jpeg
         */

        private int id;
        private String number;
        private int position;
        private String picture;
        private boolean isEdit;

        public boolean isEdit() {
            return isEdit;
        }

        public void setEdit(boolean edit) {
            isEdit = edit;
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

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
