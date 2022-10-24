package com.juntai.look.bean.weather;

/**
 * Describe:天气日常数据
 * Create by zhangzhenlong
 * 2020-6-27
 * email:954101549@qq.com
 */
public class WeatherEveryDayBean {
    private String name;
    private String content;
    private int imageInt;

    public WeatherEveryDayBean(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public WeatherEveryDayBean(String content, int imageInt) {
        this.content = content;
        this.imageInt = imageInt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageInt() {
        return imageInt;
    }

    public void setImageInt(int imageInt) {
        this.imageInt = imageInt;
    }
}
