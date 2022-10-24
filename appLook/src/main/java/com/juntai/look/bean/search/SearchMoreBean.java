package com.juntai.look.bean.search;

import com.juntai.wisdom.basecomponent.base.BaseResult;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/15 13:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/15 13:48
 */
public class SearchMoreBean extends BaseResult {

    private int  typeId ;
    private int currentOffset;//起点
    private String msg;

    public SearchMoreBean(int typeId, int currentPage, String msg) {
        this.typeId = typeId;
        this.currentOffset = currentPage;
        this.msg = msg;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getCurrentOffset() {
        return currentOffset;
    }

    public void setCurrentOffset(int currentOffset) {
        this.currentOffset = currentOffset;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? "" : msg;
    }
}
