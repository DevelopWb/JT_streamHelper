package com.juntai.look.bean.weather;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/3/21 14:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 14:08
 */
public class WeatherHoursBean {
    String time;
    String skycon;
    String temp;
    String aqi;
    String windSpeed;
    double windDirection;

    public WeatherHoursBean(String time, String skycon, String temp, String aqi, String windSpeed, double windDirection) {
        this.time = time;
        this.skycon = skycon;
        this.temp = temp;
        this.aqi = aqi;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public String getTime() {
        return time == null ? "" : time;
    }

    public void setTime(String time) {
        this.time = time == null ? "" : time;
    }

    public String getSkycon() {
        return skycon == null ? "" : skycon;
    }

    public void setSkycon(String skycon) {
        this.skycon = skycon == null ? "" : skycon;
    }

    public String getTemp() {
        return temp == null ? "" : temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? "" : temp;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }
}
