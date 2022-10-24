package com.juntai.look.bean;

/**
 * 左右文字的列表
 * Created by Ma
 * on 2019/4/18
 */
public class TextListBean {
    private String left;
    private String right;

    public TextListBean(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
