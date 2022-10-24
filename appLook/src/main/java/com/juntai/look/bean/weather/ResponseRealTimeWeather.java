package com.juntai.look.bean.weather;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * author:wong
 * Date: 2019/3/29
 * Description:
 */
public class ResponseRealTimeWeather extends BaseResult {

    /**
     * status : 200
     * data : {"status":"ok","lang":"zh_CN","unit":"metric","server_time":1553844149,"location_icon":[35.089916,118.40289],"api_status":"active","tzshift":28800,"api_version":"v2.2","result":{"status":"ok","o3":82,"co":0.4,"temperature":12,"pm10":70,"skycon":"PARTLY_CLOUDY_DAY","cloudrate":0.3,"aqi":66,"dswrf":85.3,"visibility":10.43,"humidity":0.64,"so2":9,"ultraviolet":{"index":4,"desc":"弱"},"pres":100453.86,"pm25":48,"no2":26,"precipitation":{"nearest":{"status":"ok","distance":69.74,"intensity":0.1875},"local":{"status":"ok","intensity":0,"datasource":"radar"}},"comfort":{"index":8,"desc":"很冷"},"wind":{"direction":194,"speed":19.08}}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * status : ok
         * lang : zh_CN
         * unit : metric
         * server_time : 1553844149
         * location_icon : [35.089916,118.40289]
         * api_status : active
         * tzshift : 28800
         * api_version : v2.2
         * result : {"status":"ok","o3":82,"co":0.4,"temperature":12,"pm10":70,"skycon":"PARTLY_CLOUDY_DAY","cloudrate":0.3,"aqi":66,"dswrf":85.3,"visibility":10.43,"humidity":0.64,"so2":9,"ultraviolet":{"index":4,"desc":"弱"},"pres":100453.86,"pm25":48,"no2":26,"precipitation":{"nearest":{"status":"ok","distance":69.74,"intensity":0.1875},"local":{"status":"ok","intensity":0,"datasource":"radar"}},"comfort":{"index":8,"desc":"很冷"},"wind":{"direction":194,"speed":19.08}}
         */

        private String status;
        private String lang;
        private String unit;
        private int server_time;
        private String api_status;
        private int tzshift;
        private String api_version;
        private ResultBean result;
        private List<Double> location;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getServer_time() {
            return server_time;
        }

        public void setServer_time(int server_time) {
            this.server_time = server_time;
        }

        public String getApi_status() {
            return api_status;
        }

        public void setApi_status(String api_status) {
            this.api_status = api_status;
        }

        public int getTzshift() {
            return tzshift;
        }

        public void setTzshift(int tzshift) {
            this.tzshift = tzshift;
        }

        public String getApi_version() {
            return api_version;
        }

        public void setApi_version(String api_version) {
            this.api_version = api_version;
        }

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public List<Double> getLocation() {
            return location;
        }

        public void setLocation(List<Double> location) {
            this.location = location;
        }

        public static class ResultBean {
            /**
             * status : ok
             * o3 : 82
             * co : 0.4
             * temperature : 12
             * pm10 : 70
             * skycon : PARTLY_CLOUDY_DAY
             * cloudrate : 0.3
             * aqi : 66
             * dswrf : 85.3
             * visibility : 10.43
             * humidity : 0.64
             * so2 : 9
             * ultraviolet : {"index":4,"desc":"弱"}
             * pres : 100453.86
             * pm25 : 48
             * no2 : 26
             * precipitation : {"nearest":{"status":"ok","distance":69.74,"intensity":0.1875},"local":{"status":"ok","intensity":0,"datasource":"radar"}}
             * comfort : {"index":8,"desc":"很冷"}
             * wind : {"direction":194,"speed":19.08}
             */

            private String status;
            private String o3;
            private double co;
            private double temperature;//温度
            private double apparent_temperature;//体感温度
            private double pm10;
            private String skycon;//主要天气现象
            private double cloudrate;//云量
            private int aqi;
            private double dswrf;//向下短波辐射通量
            private double visibility;//能见度
            private double humidity;//相对湿度
            private String so2;
            private UltravioletBean ultraviolet;
            private double pres;//气压
            private String pm25;
            private String no2;
            private PrecipitationBean precipitation;
            private ComfortBean comfort;
            private WindBean wind;//风级

            public double getApparent_temperature() {
                return apparent_temperature;
            }

            public void setApparent_temperature(double apparent_temperature) {
                this.apparent_temperature = apparent_temperature;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public double getCo() {
                return co;
            }

            public void setCo(double co) {
                this.co = co;
            }

            public double getTemperature() {
                return temperature;
            }

            public void setTemperature(double temperature) {
                this.temperature = temperature;
            }

            public double getPm10() {
                return pm10;
            }

            public void setPm10(double pm10) {
                this.pm10 = pm10;
            }

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public double getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(double cloudrate) {
                this.cloudrate = cloudrate;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public double getDswrf() {
                return dswrf;
            }

            public void setDswrf(double dswrf) {
                this.dswrf = dswrf;
            }

            public double getVisibility() {
                return visibility;
            }

            public void setVisibility(double visibility) {
                this.visibility = visibility;
            }

            public double getHumidity() {
                return humidity;
            }

            public void setHumidity(double humidity) {
                this.humidity = humidity;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public UltravioletBean getUltraviolet() {
                return ultraviolet;
            }

            public void setUltraviolet(UltravioletBean ultraviolet) {
                this.ultraviolet = ultraviolet;
            }

            public double getPres() {
                return pres;
            }

            public void setPres(double pres) {
                this.pres = pres;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public PrecipitationBean getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(PrecipitationBean precipitation) {
                this.precipitation = precipitation;
            }

            public ComfortBean getComfort() {
                return comfort;
            }

            public void setComfort(ComfortBean comfort) {
                this.comfort = comfort;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class UltravioletBean {
                /**
                 * 紫外线指数及其自然语言描述
                 * index : 4
                 * desc : 弱
                 */

                private int index;
                private String desc;

                public int getIndex() {
                    return index;
                }

                public void setIndex(int index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }

            public static class PrecipitationBean {
                /**
                 * nearest : {"status":"ok","distance":69.74,"intensity":0.1875}
                 * local : {"status":"ok","intensity":0,"datasource":"radar"}
                 */

                private NearestBean nearest;
                private LocalBean local;

                public NearestBean getNearest() {
                    return nearest;
                }

                public void setNearest(NearestBean nearest) {
                    this.nearest = nearest;
                }

                public LocalBean getLocal() {
                    return local;
                }

                public void setLocal(LocalBean local) {
                    this.local = local;
                }

                public static class NearestBean {
                    /**
                     * status : ok
                     * distance : 69.74
                     * intensity : 0.1875
                     */

                    private String status;
                    private double distance;
                    private double intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public double getDistance() {
                        return distance;
                    }

                    public void setDistance(double distance) {
                        this.distance = distance;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(double intensity) {
                        this.intensity = intensity;
                    }
                }

                public static class LocalBean {
                    /**
                     * status : ok
                     * intensity : 0
                     * datasource : radar
                     */

                    private String status;
                    private double intensity;//本地降水强度（单位为雷达降水强度）
                    private String datasource;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public double getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(int intensity) {
                        this.intensity = intensity;
                    }

                    public String getDatasource() {
                        return datasource;
                    }

                    public void setDatasource(String datasource) {
                        this.datasource = datasource;
                    }
                }
            }

            public static class ComfortBean {
                /**
                 * 舒适度指数及其自然语言描述
                 * index : 8
                 * desc : 很冷
                 */

                private int index;
                private String desc;

                public int getIndex() {
                    return index;
                }

                public void setIndex(int index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }

            public static class WindBean {
                /**
                 * direction : 194
                 * speed : 19.08
                 */

                private double direction;
                private double speed;

                public double getDirection() {
                    return direction;
                }

                public void setDirection(int direction) {
                    this.direction = direction;
                }

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }
            }
        }
    }
}
