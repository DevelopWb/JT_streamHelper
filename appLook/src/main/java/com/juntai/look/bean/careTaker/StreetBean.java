package com.juntai.look.bean.careTaker;

import com.contrarywind.interfaces.IPickerViewData;
import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  获取街道信息
 * @CreateDate: 2020/7/8 15:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/8 15:22
 */
public class StreetBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : [{"id":1,"street":"河东区","communityVos":[]},{"id":2,"street":"九曲街道办事处","communityVos":[{"id":1,
     * "community":"郁九曲居委会"},{"id":2,"community":"褚庄居委会"}]},{"id":3,"street":"工业园","communityVos":[{"id":42,
     * "community":"彭于埠"},{"id":43,"community":"王于埠"},{"id":44,"community":"尤斜坊"},{"id":45,"community":"耿斜坊"},{"id
     * ":46,"community":"范古墩"},{"id":47,"community":"寇家屯"},{"id":48,"community":"甘家屯"},{"id":49,"community":"陈庄子"}]}]
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
         * communityVos : []
         */

        private int id;
        private String street;
        private List<ChildBean> communityVos;

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

        public List<ChildBean> getCommunityVos() {
            return communityVos;
        }

        public void setCommunityVos(List<ChildBean> communityVos) {
            this.communityVos = communityVos;
        }

        @Override
        public String getPickerViewText() {
            return street;
        }

        public static class ChildBean implements IPickerViewData {
            public ChildBean(String community) {
                this.community = community;
            }

            private int id;
            private String community;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCommunity() {
                return community == null ? "" : community;
            }

            public void setCommunity(String community) {
                this.community = community == null ? "" : community;
            }

            @Override
            public String getPickerViewText() {
                return community;
            }
        }

    }
}
