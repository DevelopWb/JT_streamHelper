package com.juntai.look.bean;

/**
 * @Author: tobato
 * @Description: 作用描述  我的模块里的菜单
 * @CreateDate: 2020/7/16 16:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/16 16:59
 */
public class MineMenuBean {

    private String name;
    private int picRes;
    private int unReadNum;

    public MineMenuBean(String name, int picRes, int unReadNum) {
        this.name = name;
        this.picRes = picRes;
        this.unReadNum = unReadNum;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public int getPicRes() {
        return picRes;
    }

    public void setPicRes(int picRes) {
        this.picRes = picRes;
    }

    public int getUnReadNum() {
        return unReadNum;
    }

    public void setUnReadNum(int unReadNum) {
        this.unReadNum = unReadNum;
    }
}
