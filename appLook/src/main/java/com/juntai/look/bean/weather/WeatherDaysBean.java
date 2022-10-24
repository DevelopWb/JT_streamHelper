package com.juntai.look.bean.weather;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/3/21 14:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 14:10
 */
public class WeatherDaysBean {
    String date;//日期，第一位今天
    String skycon;//天气
    String maxTemp;//最高气温
    String minTemp;//最低气温
    String aqi;//空气质量

    public WeatherDaysBean(String date, String skycon, String maxTemp, String minTemp, String aqi) {
        this.date = date;
        this.skycon = skycon;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.aqi = aqi;
    }

    public String getDate() {
        return date == null ? "" : date;
    }

    public void setDate(String date) {
        this.date = date == null ? "" : date;
    }

    public String getSkycon() {
        return skycon == null ? "" : skycon;
    }

    public void setSkycon(String skycon) {
        this.skycon = skycon == null ? "" : skycon;
    }

    public String getMaxTemp() {
        return maxTemp == null ? "" : maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp == null ? "" : maxTemp;
    }

    public String getMinTemp() {
        return minTemp == null ? "" : minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp == null ? "" : minTemp;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi == null? "" : aqi;
    }
}
