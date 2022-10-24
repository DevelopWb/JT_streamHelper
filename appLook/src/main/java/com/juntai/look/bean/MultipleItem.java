package com.juntai.look.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/15 10:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/15 10:08
 */
public class MultipleItem implements MultiItemEntity {
    public static final int ITEM_TITLE = 1;//类型1
    public static final int ITEM_CONTENT = 2;//类型2
    public static final int ITEM_LOAD_MORE = 3;//类型3
    public static final String GROUP_BG_TYPE1 = "1";//分组背景1
    public static final String GROUP_BG_TYPE2 = "2";//类型2
    public static final String GROUP_BG_TYPE3 = "3";//类型3
    public static final String GROUP_BG_TYPE4 = "4";//类型4
    private int itemType;
    private Object object;

    public MultipleItem(int itemType, Object object) {
        this.itemType = itemType;
        this.object = object;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
