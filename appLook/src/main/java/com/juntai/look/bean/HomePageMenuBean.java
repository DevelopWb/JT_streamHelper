package com.juntai.look.bean;

/**
 * @Author: tobato
 * @Description: 作用描述  主页菜单
 * @CreateDate: 2020/7/17 14:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/17 14:39
 */
public class HomePageMenuBean {

    private int  menuId;//菜单id
    private int  resId;//图片id

    public HomePageMenuBean(int menuId, int resId) {
        this.menuId = menuId;
        this.resId = resId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
