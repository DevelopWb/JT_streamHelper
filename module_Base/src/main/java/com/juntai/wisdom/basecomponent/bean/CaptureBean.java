package com.juntai.wisdom.basecomponent.bean;

/**
 * @Author: tobato
 * @Description: 作用描述  截图
 * @CreateDate: 2020/9/16 17:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/16 17:47
 */
public class CaptureBean extends BaseStreamBean {

    private String imagetime;
    private String imageurl;


    public String getImagetime() {
        return imagetime == null ? "" : imagetime;
    }

    public void setImagetime(String imagetime) {
        this.imagetime = imagetime == null ? "" : imagetime;
    }

    public String getImageurl() {
        return imageurl == null ? "" : imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? "" : imageurl;
    }
}
