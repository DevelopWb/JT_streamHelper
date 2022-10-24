package com.juntai.look.bean;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/10/18 11:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/18 11:43
 */
public class ShareTimeBean {

    private String name;
    private boolean select;

    public ShareTimeBean(String name, boolean select) {
        this.name = name;
        this.select = select;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
