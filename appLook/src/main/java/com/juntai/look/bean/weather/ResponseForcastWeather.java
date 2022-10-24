package com.juntai.look.bean.weather;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * author:wong
 * Date: 2019/3/31
 * Description:
 */
public class ResponseForcastWeather extends BaseResult {

    /**
     * status : 200
     * data : {"status":"ok","lang":"zh_CN","result":{"hourly":{"status":"ok","description":"未来24小时晴","skycon":[{"value":"CLEAR_DAY","datetime":"2019-03-31 15:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 16:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 17:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 00:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 01:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 02:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 03:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 04:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 05:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 06:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 07:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 08:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 09:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 10:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 11:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 12:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 13:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 14:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 15:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 16:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 17:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-02 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 02:00"},{"value":"CLOUDY","datetime":"2019-04-02 03:00"},{"value":"CLOUDY","datetime":"2019-04-02 04:00"},{"value":"CLOUDY","datetime":"2019-04-02 05:00"},{"value":"CLOUDY","datetime":"2019-04-02 06:00"},{"value":"CLOUDY","datetime":"2019-04-02 07:00"},{"value":"CLOUDY","datetime":"2019-04-02 08:00"},{"value":"CLOUDY","datetime":"2019-04-02 09:00"},{"value":"CLOUDY","datetime":"2019-04-02 10:00"},{"value":"CLOUDY","datetime":"2019-04-02 11:00"},{"value":"CLOUDY","datetime":"2019-04-02 12:00"},{"value":"CLOUDY","datetime":"2019-04-02 13:00"},{"value":"CLOUDY","datetime":"2019-04-02 14:00"}],"cloudrate":[{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0.04,"datetime":"2019-04-01 23:00"},{"value":0.17,"datetime":"2019-04-02 00:00"},{"value":0.31,"datetime":"2019-04-02 01:00"},{"value":0.43,"datetime":"2019-04-02 02:00"},{"value":1,"datetime":"2019-04-02 03:00"},{"value":1,"datetime":"2019-04-02 04:00"},{"value":0.99,"datetime":"2019-04-02 05:00"},{"value":0.97,"datetime":"2019-04-02 06:00"},{"value":0.96,"datetime":"2019-04-02 07:00"},{"value":0.97,"datetime":"2019-04-02 08:00"},{"value":1,"datetime":"2019-04-02 09:00"},{"value":1,"datetime":"2019-04-02 10:00"},{"value":1,"datetime":"2019-04-02 11:00"},{"value":1,"datetime":"2019-04-02 12:00"},{"value":1,"datetime":"2019-04-02 13:00"},{"value":1,"datetime":"2019-04-02 14:00"}],"aqi":[{"value":61,"datetime":"2019-03-31 15:00"},{"value":43,"datetime":"2019-03-31 16:00"},{"value":47,"datetime":"2019-03-31 17:00"},{"value":51,"datetime":"2019-03-31 18:00"},{"value":54,"datetime":"2019-03-31 19:00"},{"value":55,"datetime":"2019-03-31 20:00"},{"value":55,"datetime":"2019-03-31 21:00"},{"value":55,"datetime":"2019-03-31 22:00"},{"value":56,"datetime":"2019-03-31 23:00"},{"value":57,"datetime":"2019-04-01 00:00"},{"value":59,"datetime":"2019-04-01 01:00"},{"value":59,"datetime":"2019-04-01 02:00"},{"value":57,"datetime":"2019-04-01 03:00"},{"value":56,"datetime":"2019-04-01 04:00"},{"value":55,"datetime":"2019-04-01 05:00"},{"value":55,"datetime":"2019-04-01 06:00"},{"value":56,"datetime":"2019-04-01 07:00"},{"value":59,"datetime":"2019-04-01 08:00"},{"value":61,"datetime":"2019-04-01 09:00"},{"value":62,"datetime":"2019-04-01 10:00"},{"value":60,"datetime":"2019-04-01 11:00"},{"value":55,"datetime":"2019-04-01 12:00"},{"value":49,"datetime":"2019-04-01 13:00"},{"value":43,"datetime":"2019-04-01 14:00"},{"value":43,"datetime":"2019-04-01 15:00"},{"value":46,"datetime":"2019-04-01 16:00"},{"value":47,"datetime":"2019-04-01 17:00"},{"value":49,"datetime":"2019-04-01 18:00"},{"value":47,"datetime":"2019-04-01 19:00"},{"value":46,"datetime":"2019-04-01 20:00"},{"value":47,"datetime":"2019-04-01 21:00"},{"value":47,"datetime":"2019-04-01 22:00"},{"value":47,"datetime":"2019-04-01 23:00"},{"value":46,"datetime":"2019-04-02 00:00"},{"value":44,"datetime":"2019-04-02 01:00"},{"value":46,"datetime":"2019-04-02 02:00"},{"value":50,"datetime":"2019-04-02 03:00"},{"value":55,"datetime":"2019-04-02 04:00"},{"value":59,"datetime":"2019-04-02 05:00"},{"value":60,"datetime":"2019-04-02 06:00"},{"value":59,"datetime":"2019-04-02 07:00"},{"value":55,"datetime":"2019-04-02 08:00"},{"value":50,"datetime":"2019-04-02 09:00"},{"value":43,"datetime":"2019-04-02 10:00"},{"value":37,"datetime":"2019-04-02 11:00"},{"value":31,"datetime":"2019-04-02 12:00"},{"value":27,"datetime":"2019-04-02 13:00"},{"value":24,"datetime":"2019-04-02 14:00"}],"dswrf":[{"value":740,"datetime":"2019-03-31 15:00"},{"value":650,"datetime":"2019-03-31 16:00"},{"value":550,"datetime":"2019-03-31 17:00"},{"value":450,"datetime":"2019-03-31 18:00"},{"value":360,"datetime":"2019-03-31 19:00"},{"value":298.77686,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":13,"datetime":"2019-04-01 07:00"},{"value":56.611572,"datetime":"2019-04-01 08:00"},{"value":490,"datetime":"2019-04-01 09:00"},{"value":586.1157,"datetime":"2019-04-01 10:00"},{"value":663.9161,"datetime":"2019-04-01 11:00"},{"value":722.22314,"datetime":"2019-04-01 12:00"},{"value":760.47186,"datetime":"2019-04-01 13:00"},{"value":776.3916,"datetime":"2019-04-01 14:00"},{"value":740,"datetime":"2019-04-01 15:00"},{"value":650,"datetime":"2019-04-01 16:00"},{"value":550,"datetime":"2019-04-01 17:00"},{"value":450,"datetime":"2019-04-01 18:00"},{"value":360,"datetime":"2019-04-01 19:00"},{"value":300.13654,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":11.97124,"datetime":"2019-04-02 07:00"},{"value":45.053425,"datetime":"2019-04-02 08:00"},{"value":384.38672,"datetime":"2019-04-02 09:00"},{"value":504.38672,"datetime":"2019-04-02 10:00"},{"value":586.90576,"datetime":"2019-04-02 11:00"},{"value":628.7348,"datetime":"2019-04-02 12:00"},{"value":660.68134,"datetime":"2019-04-02 13:00"},{"value":680.13495,"datetime":"2019-04-02 14:00"}],"visibility":[{"value":16.47,"datetime":"2019-03-31 15:00"},{"value":16.47,"datetime":"2019-03-31 16:00"},{"value":16.47,"datetime":"2019-03-31 17:00"},{"value":16.47,"datetime":"2019-03-31 18:00"},{"value":16.47,"datetime":"2019-03-31 19:00"},{"value":16.47,"datetime":"2019-03-31 20:00"},{"value":16.47,"datetime":"2019-03-31 21:00"},{"value":16.47,"datetime":"2019-03-31 22:00"},{"value":16.47,"datetime":"2019-03-31 23:00"},{"value":14.97,"datetime":"2019-04-01 00:00"},{"value":13.72,"datetime":"2019-04-01 01:00"},{"value":13.72,"datetime":"2019-04-01 02:00"},{"value":14.97,"datetime":"2019-04-01 03:00"},{"value":16.47,"datetime":"2019-04-01 04:00"},{"value":16.47,"datetime":"2019-04-01 05:00"},{"value":16.47,"datetime":"2019-04-01 06:00"},{"value":16.47,"datetime":"2019-04-01 07:00"},{"value":13.72,"datetime":"2019-04-01 08:00"},{"value":11.76,"datetime":"2019-04-01 09:00"},{"value":10.98,"datetime":"2019-04-01 10:00"},{"value":12.67,"datetime":"2019-04-01 11:00"},{"value":16.47,"datetime":"2019-04-01 12:00"},{"value":16.47,"datetime":"2019-04-01 13:00"},{"value":16.47,"datetime":"2019-04-01 14:00"},{"value":16.47,"datetime":"2019-04-01 15:00"},{"value":16.47,"datetime":"2019-04-01 16:00"},{"value":16.47,"datetime":"2019-04-01 17:00"},{"value":16.47,"datetime":"2019-04-01 18:00"},{"value":16.47,"datetime":"2019-04-01 19:00"},{"value":16.47,"datetime":"2019-04-01 20:00"},{"value":16.47,"datetime":"2019-04-01 21:00"},{"value":16.47,"datetime":"2019-04-01 22:00"},{"value":16.47,"datetime":"2019-04-01 23:00"},{"value":16.47,"datetime":"2019-04-02 00:00"},{"value":16.47,"datetime":"2019-04-02 01:00"},{"value":16.47,"datetime":"2019-04-02 02:00"},{"value":16.47,"datetime":"2019-04-02 03:00"},{"value":16.47,"datetime":"2019-04-02 04:00"},{"value":13.72,"datetime":"2019-04-02 05:00"},{"value":12.67,"datetime":"2019-04-02 06:00"},{"value":13.72,"datetime":"2019-04-02 07:00"},{"value":16.47,"datetime":"2019-04-02 08:00"},{"value":16.47,"datetime":"2019-04-02 09:00"},{"value":16.47,"datetime":"2019-04-02 10:00"},{"value":16.47,"datetime":"2019-04-02 11:00"},{"value":16.47,"datetime":"2019-04-02 12:00"},{"value":16.47,"datetime":"2019-04-02 13:00"},{"value":16.47,"datetime":"2019-04-02 14:00"}],"humidity":[{"value":0.14,"datetime":"2019-03-31 15:00"},{"value":0.21,"datetime":"2019-03-31 16:00"},{"value":0.24,"datetime":"2019-03-31 17:00"},{"value":0.32,"datetime":"2019-03-31 18:00"},{"value":0.31,"datetime":"2019-03-31 19:00"},{"value":0.32,"datetime":"2019-03-31 20:00"},{"value":0.33,"datetime":"2019-03-31 21:00"},{"value":0.34,"datetime":"2019-03-31 22:00"},{"value":0.34,"datetime":"2019-03-31 23:00"},{"value":0.36,"datetime":"2019-04-01 00:00"},{"value":0.4,"datetime":"2019-04-01 01:00"},{"value":0.43,"datetime":"2019-04-01 02:00"},{"value":0.45,"datetime":"2019-04-01 03:00"},{"value":0.47,"datetime":"2019-04-01 04:00"},{"value":0.48,"datetime":"2019-04-01 05:00"},{"value":0.49,"datetime":"2019-04-01 06:00"},{"value":0.51,"datetime":"2019-04-01 07:00"},{"value":0.44,"datetime":"2019-04-01 08:00"},{"value":0.39,"datetime":"2019-04-01 09:00"},{"value":0.34,"datetime":"2019-04-01 10:00"},{"value":0.31,"datetime":"2019-04-01 11:00"},{"value":0.27,"datetime":"2019-04-01 12:00"},{"value":0.24,"datetime":"2019-04-01 13:00"},{"value":0.22,"datetime":"2019-04-01 14:00"},{"value":0.21,"datetime":"2019-04-01 15:00"},{"value":0.21,"datetime":"2019-04-01 16:00"},{"value":0.25,"datetime":"2019-04-01 17:00"},{"value":0.31,"datetime":"2019-04-01 18:00"},{"value":0.31,"datetime":"2019-04-01 19:00"},{"value":0.3,"datetime":"2019-04-01 20:00"},{"value":0.3,"datetime":"2019-04-01 21:00"},{"value":0.29,"datetime":"2019-04-01 22:00"},{"value":0.28,"datetime":"2019-04-01 23:00"},{"value":0.3,"datetime":"2019-04-02 00:00"},{"value":0.38,"datetime":"2019-04-02 01:00"},{"value":0.48,"datetime":"2019-04-02 02:00"},{"value":0.53,"datetime":"2019-04-02 03:00"},{"value":0.56,"datetime":"2019-04-02 04:00"},{"value":0.58,"datetime":"2019-04-02 05:00"},{"value":0.59,"datetime":"2019-04-02 06:00"},{"value":0.58,"datetime":"2019-04-02 07:00"},{"value":0.45,"datetime":"2019-04-02 08:00"},{"value":0.37,"datetime":"2019-04-02 09:00"},{"value":0.31,"datetime":"2019-04-02 10:00"},{"value":0.28,"datetime":"2019-04-02 11:00"},{"value":0.27,"datetime":"2019-04-02 12:00"},{"value":0.26,"datetime":"2019-04-02 13:00"},{"value":0.26,"datetime":"2019-04-02 14:00"}],"pres":[{"value":101444.95,"datetime":"2019-03-31 15:00"},{"value":101402.45,"datetime":"2019-03-31 16:00"},{"value":101364.95,"datetime":"2019-03-31 17:00"},{"value":101382.555,"datetime":"2019-03-31 18:00"},{"value":101402.45,"datetime":"2019-03-31 19:00"},{"value":101482.45,"datetime":"2019-03-31 20:00"},{"value":101513.78,"datetime":"2019-03-31 21:00"},{"value":101513.78,"datetime":"2019-03-31 22:00"},{"value":101513.78,"datetime":"2019-03-31 23:00"},{"value":101482.45,"datetime":"2019-04-01 00:00"},{"value":101464.85,"datetime":"2019-04-01 01:00"},{"value":101433.78,"datetime":"2019-04-01 02:00"},{"value":101402.45,"datetime":"2019-04-01 03:00"},{"value":101353.78,"datetime":"2019-04-01 04:00"},{"value":101384.85,"datetime":"2019-04-01 05:00"},{"value":101384.85,"datetime":"2019-04-01 06:00"},{"value":101402.45,"datetime":"2019-04-01 07:00"},{"value":101402.45,"datetime":"2019-04-01 08:00"},{"value":101433.78,"datetime":"2019-04-01 09:00"},{"value":101433.78,"datetime":"2019-04-01 10:00"},{"value":101384.85,"datetime":"2019-04-01 11:00"},{"value":101364.95,"datetime":"2019-04-01 12:00"},{"value":101322.45,"datetime":"2019-04-01 13:00"},{"value":101242.45,"datetime":"2019-04-01 14:00"},{"value":101204.95,"datetime":"2019-04-01 15:00"},{"value":101173.625,"datetime":"2019-04-01 16:00"},{"value":101204.95,"datetime":"2019-04-01 17:00"},{"value":101222.555,"datetime":"2019-04-01 18:00"},{"value":101302.555,"datetime":"2019-04-01 19:00"},{"value":101382.555,"datetime":"2019-04-01 20:00"},{"value":101493.625,"datetime":"2019-04-01 21:00"},{"value":101562.45,"datetime":"2019-04-01 22:00"},{"value":101562.45,"datetime":"2019-04-01 23:00"},{"value":101562.45,"datetime":"2019-04-02 00:00"},{"value":101542.555,"datetime":"2019-04-02 01:00"},{"value":101482.45,"datetime":"2019-04-02 02:00"},{"value":101462.555,"datetime":"2019-04-02 03:00"},{"value":101444.95,"datetime":"2019-04-02 04:00"},{"value":101462.555,"datetime":"2019-04-02 05:00"},{"value":101482.45,"datetime":"2019-04-02 06:00"},{"value":101482.45,"datetime":"2019-04-02 07:00"},{"value":101524.95,"datetime":"2019-04-02 08:00"},{"value":101562.45,"datetime":"2019-04-02 09:00"},{"value":101562.45,"datetime":"2019-04-02 10:00"},{"value":101562.45,"datetime":"2019-04-02 11:00"},{"value":101524.95,"datetime":"2019-04-02 12:00"},{"value":101482.45,"datetime":"2019-04-02 13:00"},{"value":101402.45,"datetime":"2019-04-02 14:00"}],"pm25":[{"value":25,"datetime":"2019-03-31 15:00"},{"value":30,"datetime":"2019-03-31 16:00"},{"value":33,"datetime":"2019-03-31 17:00"},{"value":36,"datetime":"2019-03-31 18:00"},{"value":38,"datetime":"2019-03-31 19:00"},{"value":39,"datetime":"2019-03-31 20:00"},{"value":39,"datetime":"2019-03-31 21:00"},{"value":39,"datetime":"2019-03-31 22:00"},{"value":40,"datetime":"2019-03-31 23:00"},{"value":41,"datetime":"2019-04-01 00:00"},{"value":42,"datetime":"2019-04-01 01:00"},{"value":42,"datetime":"2019-04-01 02:00"},{"value":41,"datetime":"2019-04-01 03:00"},{"value":40,"datetime":"2019-04-01 04:00"},{"value":39,"datetime":"2019-04-01 05:00"},{"value":39,"datetime":"2019-04-01 06:00"},{"value":40,"datetime":"2019-04-01 07:00"},{"value":42,"datetime":"2019-04-01 08:00"},{"value":44,"datetime":"2019-04-01 09:00"},{"value":45,"datetime":"2019-04-01 10:00"},{"value":43,"datetime":"2019-04-01 11:00"},{"value":39,"datetime":"2019-04-01 12:00"},{"value":34,"datetime":"2019-04-01 13:00"},{"value":30,"datetime":"2019-04-01 14:00"},{"value":30,"datetime":"2019-04-01 15:00"},{"value":32,"datetime":"2019-04-01 16:00"},{"value":33,"datetime":"2019-04-01 17:00"},{"value":34,"datetime":"2019-04-01 18:00"},{"value":33,"datetime":"2019-04-01 19:00"},{"value":32,"datetime":"2019-04-01 20:00"},{"value":33,"datetime":"2019-04-01 21:00"},{"value":33,"datetime":"2019-04-01 22:00"},{"value":33,"datetime":"2019-04-01 23:00"},{"value":32,"datetime":"2019-04-02 00:00"},{"value":31,"datetime":"2019-04-02 01:00"},{"value":32,"datetime":"2019-04-02 02:00"},{"value":35,"datetime":"2019-04-02 03:00"},{"value":39,"datetime":"2019-04-02 04:00"},{"value":42,"datetime":"2019-04-02 05:00"},{"value":43,"datetime":"2019-04-02 06:00"},{"value":42,"datetime":"2019-04-02 07:00"},{"value":39,"datetime":"2019-04-02 08:00"},{"value":35,"datetime":"2019-04-02 09:00"},{"value":30,"datetime":"2019-04-02 10:00"},{"value":26,"datetime":"2019-04-02 11:00"},{"value":22,"datetime":"2019-04-02 12:00"},{"value":19,"datetime":"2019-04-02 13:00"},{"value":17,"datetime":"2019-04-02 14:00"}],"precipitation":[{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":0,"datetime":"2019-04-02 07:00"},{"value":0,"datetime":"2019-04-02 08:00"},{"value":0,"datetime":"2019-04-02 09:00"},{"value":0,"datetime":"2019-04-02 10:00"},{"value":0,"datetime":"2019-04-02 11:00"},{"value":0,"datetime":"2019-04-02 12:00"},{"value":0,"datetime":"2019-04-02 13:00"},{"value":0,"datetime":"2019-04-02 14:00"}],"wind":[{"direction":269,"speed":30.96,"datetime":"2019-03-31 15:00"},{"direction":288.88,"speed":15.32,"datetime":"2019-03-31 16:00"},{"direction":289.11,"speed":12.43,"datetime":"2019-03-31 17:00"},{"direction":289.6,"speed":5.78,"datetime":"2019-03-31 18:00"},{"direction":284.68,"speed":3.59,"datetime":"2019-03-31 19:00"},{"direction":278.21,"speed":2.89,"datetime":"2019-03-31 20:00"},{"direction":275.5,"speed":3.26,"datetime":"2019-03-31 21:00"},{"direction":257.79,"speed":3.07,"datetime":"2019-03-31 22:00"},{"direction":199.01,"speed":4.63,"datetime":"2019-03-31 23:00"},{"direction":189.3,"speed":7.84,"datetime":"2019-04-01 00:00"},{"direction":191.43,"speed":9.33,"datetime":"2019-04-01 01:00"},{"direction":198.27,"speed":9.94,"datetime":"2019-04-01 02:00"},{"direction":200.78,"speed":10.56,"datetime":"2019-04-01 03:00"},{"direction":205.63,"speed":11.21,"datetime":"2019-04-01 04:00"},{"direction":217.29,"speed":11.74,"datetime":"2019-04-01 05:00"},{"direction":223.35,"speed":11.65,"datetime":"2019-04-01 06:00"},{"direction":223.39,"speed":11.64,"datetime":"2019-04-01 07:00"},{"direction":235.91,"speed":17.03,"datetime":"2019-04-01 08:00"},{"direction":252.87,"speed":20.7,"datetime":"2019-04-01 09:00"},{"direction":265.17,"speed":23.25,"datetime":"2019-04-01 10:00"},{"direction":275.81,"speed":24.27,"datetime":"2019-04-01 11:00"},{"direction":290.14,"speed":23.1,"datetime":"2019-04-01 12:00"},{"direction":307.13,"speed":21.27,"datetime":"2019-04-01 13:00"},{"direction":320.15,"speed":19.46,"datetime":"2019-04-01 14:00"},{"direction":332.21,"speed":17.57,"datetime":"2019-04-01 15:00"},{"direction":346.73,"speed":15.84,"datetime":"2019-04-01 16:00"},{"direction":11.63,"speed":13.11,"datetime":"2019-04-01 17:00"},{"direction":38.23,"speed":13.18,"datetime":"2019-04-01 18:00"},{"direction":51.21,"speed":17.41,"datetime":"2019-04-01 19:00"},{"direction":53.94,"speed":18.9,"datetime":"2019-04-01 20:00"},{"direction":55.06,"speed":16.1,"datetime":"2019-04-01 21:00"},{"direction":58.05,"speed":13.72,"datetime":"2019-04-01 22:00"},{"direction":65.94,"speed":12.2,"datetime":"2019-04-01 23:00"},{"direction":76.37,"speed":11.73,"datetime":"2019-04-02 00:00"},{"direction":87.82,"speed":11.55,"datetime":"2019-04-02 01:00"},{"direction":99.09,"speed":11.32,"datetime":"2019-04-02 02:00"},{"direction":101.53,"speed":10.66,"datetime":"2019-04-02 03:00"},{"direction":101.44,"speed":9.83,"datetime":"2019-04-02 04:00"},{"direction":104.8,"speed":9,"datetime":"2019-04-02 05:00"},{"direction":103.18,"speed":8.74,"datetime":"2019-04-02 06:00"},{"direction":97.6,"speed":9.23,"datetime":"2019-04-02 07:00"},{"direction":110.48,"speed":13.98,"datetime":"2019-04-02 08:00"},{"direction":117.11,"speed":14.92,"datetime":"2019-04-02 09:00"},{"direction":119.88,"speed":15.93,"datetime":"2019-04-02 10:00"},{"direction":119.47,"speed":16.72,"datetime":"2019-04-02 11:00"},{"direction":118.93,"speed":16.8,"datetime":"2019-04-02 12:00"},{"direction":122.32,"speed":16.92,"datetime":"2019-04-02 13:00"},{"direction":119.26,"speed":16.16,"datetime":"2019-04-02 14:00"}],"temperature":[{"value":15,"datetime":"2019-03-31 15:00"},{"value":14.17,"datetime":"2019-03-31 16:00"},{"value":13.33,"datetime":"2019-03-31 17:00"},{"value":12.5,"datetime":"2019-03-31 18:00"},{"value":10.67,"datetime":"2019-03-31 19:00"},{"value":10.83,"datetime":"2019-03-31 20:00"},{"value":10,"datetime":"2019-03-31 21:00"},{"value":9,"datetime":"2019-03-31 22:00"},{"value":9,"datetime":"2019-03-31 23:00"},{"value":7.33,"datetime":"2019-04-01 00:00"},{"value":7.67,"datetime":"2019-04-01 01:00"},{"value":7,"datetime":"2019-04-01 02:00"},{"value":6.33,"datetime":"2019-04-01 03:00"},{"value":6.67,"datetime":"2019-04-01 04:00"},{"value":6,"datetime":"2019-04-01 05:00"},{"value":6.67,"datetime":"2019-04-01 06:00"},{"value":8.33,"datetime":"2019-04-01 07:00"},{"value":9.17,"datetime":"2019-04-01 08:00"},{"value":12,"datetime":"2019-04-01 09:00"},{"value":14.83,"datetime":"2019-04-01 10:00"},{"value":17.67,"datetime":"2019-04-01 11:00"},{"value":18.83,"datetime":"2019-04-01 12:00"},{"value":20,"datetime":"2019-04-01 13:00"},{"value":19.65,"datetime":"2019-04-01 14:00"},{"value":19.3,"datetime":"2019-04-01 15:00"},{"value":18.67,"datetime":"2019-04-01 16:00"},{"value":17.35,"datetime":"2019-04-01 17:00"},{"value":14.08,"datetime":"2019-04-01 18:00"},{"value":11.42,"datetime":"2019-04-01 19:00"},{"value":9.92,"datetime":"2019-04-01 20:00"},{"value":8.47,"datetime":"2019-04-01 21:00"},{"value":7.41,"datetime":"2019-04-01 22:00"},{"value":6.76,"datetime":"2019-04-01 23:00"},{"value":6.38,"datetime":"2019-04-02 00:00"},{"value":6.18,"datetime":"2019-04-02 01:00"},{"value":6.31,"datetime":"2019-04-02 02:00"},{"value":6.26,"datetime":"2019-04-02 03:00"},{"value":6.04,"datetime":"2019-04-02 04:00"},{"value":5.99,"datetime":"2019-04-02 05:00"},{"value":6,"datetime":"2019-04-02 06:00"},{"value":6.89,"datetime":"2019-04-02 07:00"},{"value":9.15,"datetime":"2019-04-02 08:00"},{"value":11.12,"datetime":"2019-04-02 09:00"},{"value":13.53,"datetime":"2019-04-02 10:00"},{"value":15.12,"datetime":"2019-04-02 11:00"},{"value":16.06,"datetime":"2019-04-02 12:00"},{"value":17.24,"datetime":"2019-04-02 13:00"},{"value":18,"datetime":"2019-04-02 14:00"}]},"forecast_keypoint":"未来两小时不会下雨，放心出门吧","primary":0,"daily":{"status":"ok","comfort":[{"index":"7","desc":"冷","datetime":"2019-03-31"},{"index":"6","desc":"凉爽","datetime":"2019-04-01"},{"index":"7","desc":"冷","datetime":"2019-04-02"},{"index":"6","desc":"凉爽","datetime":"2019-04-03"},{"index":"5","desc":"舒适","datetime":"2019-04-04"}],"skycon_20h_32h":[{"date":"2019-03-31","value":"CLEAR_NIGHT"},{"date":"2019-04-01","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-02","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-03","value":"CLOUDY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_NIGHT"}],"temperature":[{"date":"2019-03-31","max":15.33,"avg":11.61,"min":2},{"date":"2019-04-01","max":20,"avg":11.73,"min":6},{"date":"2019-04-02","max":18,"avg":10.36,"min":5.99},{"date":"2019-04-03","max":19,"avg":12.33,"min":5.88},{"date":"2019-04-04","max":23,"avg":14.85,"min":8.95}],"dswrf":[{"date":"2019-03-31","max":785.3,"avg":338.8,"min":0},{"date":"2019-04-01","max":776.4,"avg":296.6,"min":0},{"date":"2019-04-02","max":680.1,"avg":239.5,"min":0},{"date":"2019-04-03","max":786.4,"avg":292.7,"min":0},{"date":"2019-04-04","max":781.2,"avg":297.7,"min":0}],"cloudrate":[{"date":"2019-03-31","max":1,"avg":0,"min":0},{"date":"2019-04-01","max":0.04,"avg":0,"min":0},{"date":"2019-04-02","max":1,"avg":0.9,"min":0.17},{"date":"2019-04-03","max":1,"avg":0.56,"min":0},{"date":"2019-04-04","max":1,"avg":0.48,"min":0}],"aqi":[{"date":"2019-03-31","max":107,"avg":53,"min":43},{"date":"2019-04-01","max":62,"avg":52.58,"min":43},{"date":"2019-04-02","max":60,"avg":38.04,"min":21},{"date":"2019-04-03","max":65,"avg":50.42,"min":37},{"date":"2019-04-04","max":82,"avg":66.17,"min":50}],"skycon":[{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_DAY"}],"visibility":[{"date":"2019-03-31","max":24.1,"avg":16.47,"min":16.47},{"date":"2019-04-01","max":16.47,"avg":15.42,"min":10.98},{"date":"2019-04-02","max":16.47,"avg":16.08,"min":12.67},{"date":"2019-04-03","max":16.47,"avg":14.94,"min":9.69},{"date":"2019-04-04","max":16.47,"avg":10.04,"min":4.39}],"humidity":[{"date":"2019-03-31","max":0.35,"avg":0.28,"min":0.14},{"date":"2019-04-01","max":0.51,"avg":0.34,"min":0.21},{"date":"2019-04-02","max":0.59,"avg":0.43,"min":0.26},{"date":"2019-04-03","max":0.76,"avg":0.5,"min":0.27},{"date":"2019-04-04","max":0.74,"avg":0.52,"min":0.32}],"astro":[{"date":"2019-03-31","sunset":{"time":"18:26"},"sunrise":{"time":"05:55"}},{"date":"2019-04-01","sunset":{"time":"18:27"},"sunrise":{"time":"05:53"}},{"date":"2019-04-02","sunset":{"time":"18:27"},"sunrise":{"time":"05:52"}},{"date":"2019-04-03","sunset":{"time":"18:28"},"sunrise":{"time":"05:51"}},{"date":"2019-04-04","sunset":{"time":"18:29"},"sunrise":{"time":"05:49"}}],"coldRisk":[{"index":"4","desc":"极易发","datetime":"2019-03-31"},{"index":"4","desc":"极易发","datetime":"2019-04-01"},{"index":"4","desc":"极易发","datetime":"2019-04-02"},{"index":"4","desc":"极易发","datetime":"2019-04-03"},{"index":"4","desc":"极易发","datetime":"2019-04-04"}],"ultraviolet":[{"index":"4","desc":"强","datetime":"2019-03-31"},{"index":"4","desc":"强","datetime":"2019-04-01"},{"index":"1","desc":"最弱","datetime":"2019-04-02"},{"index":"4","desc":"强","datetime":"2019-04-03"},{"index":"4","desc":"强","datetime":"2019-04-04"}],"pres":[{"date":"2019-03-31","max":101802.45,"avg":101446.8,"min":101364.96},{"date":"2019-04-01","max":101562.45,"avg":101375.16,"min":101173.63},{"date":"2019-04-02","max":101782.55,"avg":101527.8,"min":101382.55},{"date":"2019-04-03","max":102004.96,"avg":101709.44,"min":101433.78},{"date":"2019-04-04","max":101433.78,"avg":100865.45,"min":100393.78}],"pm25":[{"date":"2019-03-31","max":54,"avg":35.44,"min":16},{"date":"2019-04-01","max":45,"avg":37.25,"min":30},{"date":"2019-04-02","max":43,"avg":26.79,"min":15},{"date":"2019-04-03","max":47,"avg":35.71,"min":26},{"date":"2019-04-04","max":61,"avg":48,"min":35}],"dressing":[{"index":"5","desc":"凉爽","datetime":"2019-03-31"},{"index":"6","desc":"冷","datetime":"2019-04-01"},{"index":"5","desc":"凉爽","datetime":"2019-04-02"},{"index":"5","desc":"凉爽","datetime":"2019-04-03"},{"index":"6","desc":"冷","datetime":"2019-04-04"}],"carWashing":[{"index":"1","desc":"适宜","datetime":"2019-03-31"},{"index":"1","desc":"适宜","datetime":"2019-04-01"},{"index":"1","desc":"适宜","datetime":"2019-04-02"},{"index":"1","desc":"适宜","datetime":"2019-04-03"},{"index":"1","desc":"适宜","datetime":"2019-04-04"}],"precipitation":[{"date":"2019-03-31","max":0,"avg":0,"min":0},{"date":"2019-04-01","max":0,"avg":0,"min":0},{"date":"2019-04-02","max":0,"avg":0,"min":0},{"date":"2019-04-03","max":0,"avg":0,"min":0},{"date":"2019-04-04","max":0,"avg":0,"min":0}],"wind":[{"date":"2019-03-31","max":{"direction":269,"speed":30.96},"avg":{"direction":272.64,"speed":7.3},"min":{"direction":266.59,"speed":0.84}},{"date":"2019-04-01","max":{"direction":275.81,"speed":24.27},"avg":{"direction":293.22,"speed":15.46},"min":{"direction":189.3,"speed":7.84}},{"date":"2019-04-02","max":{"direction":122.32,"speed":16.92},"avg":{"direction":107.32,"speed":13},"min":{"direction":120.66,"speed":8.19}},{"date":"2019-04-03","max":{"direction":159.67,"speed":10.14},"avg":{"direction":143.21,"speed":8.22},"min":{"direction":79.64,"speed":6.27}},{"date":"2019-04-04","max":{"direction":221.7,"speed":22.01},"avg":{"direction":213.64,"speed":15.47},"min":{"direction":205.01,"speed":10.24}}],"skycon_08h_20h":[{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"CLEAR_DAY"}]},"minutely":{"status":"ok","description":"未来两小时不会下雨，放心出门吧","probability":[0,0,0,0],"probability_4h":[0,0,0.051129088,0.063936174],"datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]}},"server_time":1554016135,"api_status":"active","tzshift":28800,"api_version":"v2.2","unit":"metric","location_icon":[35.089916,118.40289]}
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
         * result : {"hourly":{"status":"ok","description":"未来24小时晴","skycon":[{"value":"CLEAR_DAY","datetime":"2019-03-31 15:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 16:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 17:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 00:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 01:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 02:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 03:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 04:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 05:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 06:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 07:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 08:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 09:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 10:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 11:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 12:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 13:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 14:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 15:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 16:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 17:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-02 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 02:00"},{"value":"CLOUDY","datetime":"2019-04-02 03:00"},{"value":"CLOUDY","datetime":"2019-04-02 04:00"},{"value":"CLOUDY","datetime":"2019-04-02 05:00"},{"value":"CLOUDY","datetime":"2019-04-02 06:00"},{"value":"CLOUDY","datetime":"2019-04-02 07:00"},{"value":"CLOUDY","datetime":"2019-04-02 08:00"},{"value":"CLOUDY","datetime":"2019-04-02 09:00"},{"value":"CLOUDY","datetime":"2019-04-02 10:00"},{"value":"CLOUDY","datetime":"2019-04-02 11:00"},{"value":"CLOUDY","datetime":"2019-04-02 12:00"},{"value":"CLOUDY","datetime":"2019-04-02 13:00"},{"value":"CLOUDY","datetime":"2019-04-02 14:00"}],"cloudrate":[{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0.04,"datetime":"2019-04-01 23:00"},{"value":0.17,"datetime":"2019-04-02 00:00"},{"value":0.31,"datetime":"2019-04-02 01:00"},{"value":0.43,"datetime":"2019-04-02 02:00"},{"value":1,"datetime":"2019-04-02 03:00"},{"value":1,"datetime":"2019-04-02 04:00"},{"value":0.99,"datetime":"2019-04-02 05:00"},{"value":0.97,"datetime":"2019-04-02 06:00"},{"value":0.96,"datetime":"2019-04-02 07:00"},{"value":0.97,"datetime":"2019-04-02 08:00"},{"value":1,"datetime":"2019-04-02 09:00"},{"value":1,"datetime":"2019-04-02 10:00"},{"value":1,"datetime":"2019-04-02 11:00"},{"value":1,"datetime":"2019-04-02 12:00"},{"value":1,"datetime":"2019-04-02 13:00"},{"value":1,"datetime":"2019-04-02 14:00"}],"aqi":[{"value":61,"datetime":"2019-03-31 15:00"},{"value":43,"datetime":"2019-03-31 16:00"},{"value":47,"datetime":"2019-03-31 17:00"},{"value":51,"datetime":"2019-03-31 18:00"},{"value":54,"datetime":"2019-03-31 19:00"},{"value":55,"datetime":"2019-03-31 20:00"},{"value":55,"datetime":"2019-03-31 21:00"},{"value":55,"datetime":"2019-03-31 22:00"},{"value":56,"datetime":"2019-03-31 23:00"},{"value":57,"datetime":"2019-04-01 00:00"},{"value":59,"datetime":"2019-04-01 01:00"},{"value":59,"datetime":"2019-04-01 02:00"},{"value":57,"datetime":"2019-04-01 03:00"},{"value":56,"datetime":"2019-04-01 04:00"},{"value":55,"datetime":"2019-04-01 05:00"},{"value":55,"datetime":"2019-04-01 06:00"},{"value":56,"datetime":"2019-04-01 07:00"},{"value":59,"datetime":"2019-04-01 08:00"},{"value":61,"datetime":"2019-04-01 09:00"},{"value":62,"datetime":"2019-04-01 10:00"},{"value":60,"datetime":"2019-04-01 11:00"},{"value":55,"datetime":"2019-04-01 12:00"},{"value":49,"datetime":"2019-04-01 13:00"},{"value":43,"datetime":"2019-04-01 14:00"},{"value":43,"datetime":"2019-04-01 15:00"},{"value":46,"datetime":"2019-04-01 16:00"},{"value":47,"datetime":"2019-04-01 17:00"},{"value":49,"datetime":"2019-04-01 18:00"},{"value":47,"datetime":"2019-04-01 19:00"},{"value":46,"datetime":"2019-04-01 20:00"},{"value":47,"datetime":"2019-04-01 21:00"},{"value":47,"datetime":"2019-04-01 22:00"},{"value":47,"datetime":"2019-04-01 23:00"},{"value":46,"datetime":"2019-04-02 00:00"},{"value":44,"datetime":"2019-04-02 01:00"},{"value":46,"datetime":"2019-04-02 02:00"},{"value":50,"datetime":"2019-04-02 03:00"},{"value":55,"datetime":"2019-04-02 04:00"},{"value":59,"datetime":"2019-04-02 05:00"},{"value":60,"datetime":"2019-04-02 06:00"},{"value":59,"datetime":"2019-04-02 07:00"},{"value":55,"datetime":"2019-04-02 08:00"},{"value":50,"datetime":"2019-04-02 09:00"},{"value":43,"datetime":"2019-04-02 10:00"},{"value":37,"datetime":"2019-04-02 11:00"},{"value":31,"datetime":"2019-04-02 12:00"},{"value":27,"datetime":"2019-04-02 13:00"},{"value":24,"datetime":"2019-04-02 14:00"}],"dswrf":[{"value":740,"datetime":"2019-03-31 15:00"},{"value":650,"datetime":"2019-03-31 16:00"},{"value":550,"datetime":"2019-03-31 17:00"},{"value":450,"datetime":"2019-03-31 18:00"},{"value":360,"datetime":"2019-03-31 19:00"},{"value":298.77686,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":13,"datetime":"2019-04-01 07:00"},{"value":56.611572,"datetime":"2019-04-01 08:00"},{"value":490,"datetime":"2019-04-01 09:00"},{"value":586.1157,"datetime":"2019-04-01 10:00"},{"value":663.9161,"datetime":"2019-04-01 11:00"},{"value":722.22314,"datetime":"2019-04-01 12:00"},{"value":760.47186,"datetime":"2019-04-01 13:00"},{"value":776.3916,"datetime":"2019-04-01 14:00"},{"value":740,"datetime":"2019-04-01 15:00"},{"value":650,"datetime":"2019-04-01 16:00"},{"value":550,"datetime":"2019-04-01 17:00"},{"value":450,"datetime":"2019-04-01 18:00"},{"value":360,"datetime":"2019-04-01 19:00"},{"value":300.13654,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":11.97124,"datetime":"2019-04-02 07:00"},{"value":45.053425,"datetime":"2019-04-02 08:00"},{"value":384.38672,"datetime":"2019-04-02 09:00"},{"value":504.38672,"datetime":"2019-04-02 10:00"},{"value":586.90576,"datetime":"2019-04-02 11:00"},{"value":628.7348,"datetime":"2019-04-02 12:00"},{"value":660.68134,"datetime":"2019-04-02 13:00"},{"value":680.13495,"datetime":"2019-04-02 14:00"}],"visibility":[{"value":16.47,"datetime":"2019-03-31 15:00"},{"value":16.47,"datetime":"2019-03-31 16:00"},{"value":16.47,"datetime":"2019-03-31 17:00"},{"value":16.47,"datetime":"2019-03-31 18:00"},{"value":16.47,"datetime":"2019-03-31 19:00"},{"value":16.47,"datetime":"2019-03-31 20:00"},{"value":16.47,"datetime":"2019-03-31 21:00"},{"value":16.47,"datetime":"2019-03-31 22:00"},{"value":16.47,"datetime":"2019-03-31 23:00"},{"value":14.97,"datetime":"2019-04-01 00:00"},{"value":13.72,"datetime":"2019-04-01 01:00"},{"value":13.72,"datetime":"2019-04-01 02:00"},{"value":14.97,"datetime":"2019-04-01 03:00"},{"value":16.47,"datetime":"2019-04-01 04:00"},{"value":16.47,"datetime":"2019-04-01 05:00"},{"value":16.47,"datetime":"2019-04-01 06:00"},{"value":16.47,"datetime":"2019-04-01 07:00"},{"value":13.72,"datetime":"2019-04-01 08:00"},{"value":11.76,"datetime":"2019-04-01 09:00"},{"value":10.98,"datetime":"2019-04-01 10:00"},{"value":12.67,"datetime":"2019-04-01 11:00"},{"value":16.47,"datetime":"2019-04-01 12:00"},{"value":16.47,"datetime":"2019-04-01 13:00"},{"value":16.47,"datetime":"2019-04-01 14:00"},{"value":16.47,"datetime":"2019-04-01 15:00"},{"value":16.47,"datetime":"2019-04-01 16:00"},{"value":16.47,"datetime":"2019-04-01 17:00"},{"value":16.47,"datetime":"2019-04-01 18:00"},{"value":16.47,"datetime":"2019-04-01 19:00"},{"value":16.47,"datetime":"2019-04-01 20:00"},{"value":16.47,"datetime":"2019-04-01 21:00"},{"value":16.47,"datetime":"2019-04-01 22:00"},{"value":16.47,"datetime":"2019-04-01 23:00"},{"value":16.47,"datetime":"2019-04-02 00:00"},{"value":16.47,"datetime":"2019-04-02 01:00"},{"value":16.47,"datetime":"2019-04-02 02:00"},{"value":16.47,"datetime":"2019-04-02 03:00"},{"value":16.47,"datetime":"2019-04-02 04:00"},{"value":13.72,"datetime":"2019-04-02 05:00"},{"value":12.67,"datetime":"2019-04-02 06:00"},{"value":13.72,"datetime":"2019-04-02 07:00"},{"value":16.47,"datetime":"2019-04-02 08:00"},{"value":16.47,"datetime":"2019-04-02 09:00"},{"value":16.47,"datetime":"2019-04-02 10:00"},{"value":16.47,"datetime":"2019-04-02 11:00"},{"value":16.47,"datetime":"2019-04-02 12:00"},{"value":16.47,"datetime":"2019-04-02 13:00"},{"value":16.47,"datetime":"2019-04-02 14:00"}],"humidity":[{"value":0.14,"datetime":"2019-03-31 15:00"},{"value":0.21,"datetime":"2019-03-31 16:00"},{"value":0.24,"datetime":"2019-03-31 17:00"},{"value":0.32,"datetime":"2019-03-31 18:00"},{"value":0.31,"datetime":"2019-03-31 19:00"},{"value":0.32,"datetime":"2019-03-31 20:00"},{"value":0.33,"datetime":"2019-03-31 21:00"},{"value":0.34,"datetime":"2019-03-31 22:00"},{"value":0.34,"datetime":"2019-03-31 23:00"},{"value":0.36,"datetime":"2019-04-01 00:00"},{"value":0.4,"datetime":"2019-04-01 01:00"},{"value":0.43,"datetime":"2019-04-01 02:00"},{"value":0.45,"datetime":"2019-04-01 03:00"},{"value":0.47,"datetime":"2019-04-01 04:00"},{"value":0.48,"datetime":"2019-04-01 05:00"},{"value":0.49,"datetime":"2019-04-01 06:00"},{"value":0.51,"datetime":"2019-04-01 07:00"},{"value":0.44,"datetime":"2019-04-01 08:00"},{"value":0.39,"datetime":"2019-04-01 09:00"},{"value":0.34,"datetime":"2019-04-01 10:00"},{"value":0.31,"datetime":"2019-04-01 11:00"},{"value":0.27,"datetime":"2019-04-01 12:00"},{"value":0.24,"datetime":"2019-04-01 13:00"},{"value":0.22,"datetime":"2019-04-01 14:00"},{"value":0.21,"datetime":"2019-04-01 15:00"},{"value":0.21,"datetime":"2019-04-01 16:00"},{"value":0.25,"datetime":"2019-04-01 17:00"},{"value":0.31,"datetime":"2019-04-01 18:00"},{"value":0.31,"datetime":"2019-04-01 19:00"},{"value":0.3,"datetime":"2019-04-01 20:00"},{"value":0.3,"datetime":"2019-04-01 21:00"},{"value":0.29,"datetime":"2019-04-01 22:00"},{"value":0.28,"datetime":"2019-04-01 23:00"},{"value":0.3,"datetime":"2019-04-02 00:00"},{"value":0.38,"datetime":"2019-04-02 01:00"},{"value":0.48,"datetime":"2019-04-02 02:00"},{"value":0.53,"datetime":"2019-04-02 03:00"},{"value":0.56,"datetime":"2019-04-02 04:00"},{"value":0.58,"datetime":"2019-04-02 05:00"},{"value":0.59,"datetime":"2019-04-02 06:00"},{"value":0.58,"datetime":"2019-04-02 07:00"},{"value":0.45,"datetime":"2019-04-02 08:00"},{"value":0.37,"datetime":"2019-04-02 09:00"},{"value":0.31,"datetime":"2019-04-02 10:00"},{"value":0.28,"datetime":"2019-04-02 11:00"},{"value":0.27,"datetime":"2019-04-02 12:00"},{"value":0.26,"datetime":"2019-04-02 13:00"},{"value":0.26,"datetime":"2019-04-02 14:00"}],"pres":[{"value":101444.95,"datetime":"2019-03-31 15:00"},{"value":101402.45,"datetime":"2019-03-31 16:00"},{"value":101364.95,"datetime":"2019-03-31 17:00"},{"value":101382.555,"datetime":"2019-03-31 18:00"},{"value":101402.45,"datetime":"2019-03-31 19:00"},{"value":101482.45,"datetime":"2019-03-31 20:00"},{"value":101513.78,"datetime":"2019-03-31 21:00"},{"value":101513.78,"datetime":"2019-03-31 22:00"},{"value":101513.78,"datetime":"2019-03-31 23:00"},{"value":101482.45,"datetime":"2019-04-01 00:00"},{"value":101464.85,"datetime":"2019-04-01 01:00"},{"value":101433.78,"datetime":"2019-04-01 02:00"},{"value":101402.45,"datetime":"2019-04-01 03:00"},{"value":101353.78,"datetime":"2019-04-01 04:00"},{"value":101384.85,"datetime":"2019-04-01 05:00"},{"value":101384.85,"datetime":"2019-04-01 06:00"},{"value":101402.45,"datetime":"2019-04-01 07:00"},{"value":101402.45,"datetime":"2019-04-01 08:00"},{"value":101433.78,"datetime":"2019-04-01 09:00"},{"value":101433.78,"datetime":"2019-04-01 10:00"},{"value":101384.85,"datetime":"2019-04-01 11:00"},{"value":101364.95,"datetime":"2019-04-01 12:00"},{"value":101322.45,"datetime":"2019-04-01 13:00"},{"value":101242.45,"datetime":"2019-04-01 14:00"},{"value":101204.95,"datetime":"2019-04-01 15:00"},{"value":101173.625,"datetime":"2019-04-01 16:00"},{"value":101204.95,"datetime":"2019-04-01 17:00"},{"value":101222.555,"datetime":"2019-04-01 18:00"},{"value":101302.555,"datetime":"2019-04-01 19:00"},{"value":101382.555,"datetime":"2019-04-01 20:00"},{"value":101493.625,"datetime":"2019-04-01 21:00"},{"value":101562.45,"datetime":"2019-04-01 22:00"},{"value":101562.45,"datetime":"2019-04-01 23:00"},{"value":101562.45,"datetime":"2019-04-02 00:00"},{"value":101542.555,"datetime":"2019-04-02 01:00"},{"value":101482.45,"datetime":"2019-04-02 02:00"},{"value":101462.555,"datetime":"2019-04-02 03:00"},{"value":101444.95,"datetime":"2019-04-02 04:00"},{"value":101462.555,"datetime":"2019-04-02 05:00"},{"value":101482.45,"datetime":"2019-04-02 06:00"},{"value":101482.45,"datetime":"2019-04-02 07:00"},{"value":101524.95,"datetime":"2019-04-02 08:00"},{"value":101562.45,"datetime":"2019-04-02 09:00"},{"value":101562.45,"datetime":"2019-04-02 10:00"},{"value":101562.45,"datetime":"2019-04-02 11:00"},{"value":101524.95,"datetime":"2019-04-02 12:00"},{"value":101482.45,"datetime":"2019-04-02 13:00"},{"value":101402.45,"datetime":"2019-04-02 14:00"}],"pm25":[{"value":25,"datetime":"2019-03-31 15:00"},{"value":30,"datetime":"2019-03-31 16:00"},{"value":33,"datetime":"2019-03-31 17:00"},{"value":36,"datetime":"2019-03-31 18:00"},{"value":38,"datetime":"2019-03-31 19:00"},{"value":39,"datetime":"2019-03-31 20:00"},{"value":39,"datetime":"2019-03-31 21:00"},{"value":39,"datetime":"2019-03-31 22:00"},{"value":40,"datetime":"2019-03-31 23:00"},{"value":41,"datetime":"2019-04-01 00:00"},{"value":42,"datetime":"2019-04-01 01:00"},{"value":42,"datetime":"2019-04-01 02:00"},{"value":41,"datetime":"2019-04-01 03:00"},{"value":40,"datetime":"2019-04-01 04:00"},{"value":39,"datetime":"2019-04-01 05:00"},{"value":39,"datetime":"2019-04-01 06:00"},{"value":40,"datetime":"2019-04-01 07:00"},{"value":42,"datetime":"2019-04-01 08:00"},{"value":44,"datetime":"2019-04-01 09:00"},{"value":45,"datetime":"2019-04-01 10:00"},{"value":43,"datetime":"2019-04-01 11:00"},{"value":39,"datetime":"2019-04-01 12:00"},{"value":34,"datetime":"2019-04-01 13:00"},{"value":30,"datetime":"2019-04-01 14:00"},{"value":30,"datetime":"2019-04-01 15:00"},{"value":32,"datetime":"2019-04-01 16:00"},{"value":33,"datetime":"2019-04-01 17:00"},{"value":34,"datetime":"2019-04-01 18:00"},{"value":33,"datetime":"2019-04-01 19:00"},{"value":32,"datetime":"2019-04-01 20:00"},{"value":33,"datetime":"2019-04-01 21:00"},{"value":33,"datetime":"2019-04-01 22:00"},{"value":33,"datetime":"2019-04-01 23:00"},{"value":32,"datetime":"2019-04-02 00:00"},{"value":31,"datetime":"2019-04-02 01:00"},{"value":32,"datetime":"2019-04-02 02:00"},{"value":35,"datetime":"2019-04-02 03:00"},{"value":39,"datetime":"2019-04-02 04:00"},{"value":42,"datetime":"2019-04-02 05:00"},{"value":43,"datetime":"2019-04-02 06:00"},{"value":42,"datetime":"2019-04-02 07:00"},{"value":39,"datetime":"2019-04-02 08:00"},{"value":35,"datetime":"2019-04-02 09:00"},{"value":30,"datetime":"2019-04-02 10:00"},{"value":26,"datetime":"2019-04-02 11:00"},{"value":22,"datetime":"2019-04-02 12:00"},{"value":19,"datetime":"2019-04-02 13:00"},{"value":17,"datetime":"2019-04-02 14:00"}],"precipitation":[{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":0,"datetime":"2019-04-02 07:00"},{"value":0,"datetime":"2019-04-02 08:00"},{"value":0,"datetime":"2019-04-02 09:00"},{"value":0,"datetime":"2019-04-02 10:00"},{"value":0,"datetime":"2019-04-02 11:00"},{"value":0,"datetime":"2019-04-02 12:00"},{"value":0,"datetime":"2019-04-02 13:00"},{"value":0,"datetime":"2019-04-02 14:00"}],"wind":[{"direction":269,"speed":30.96,"datetime":"2019-03-31 15:00"},{"direction":288.88,"speed":15.32,"datetime":"2019-03-31 16:00"},{"direction":289.11,"speed":12.43,"datetime":"2019-03-31 17:00"},{"direction":289.6,"speed":5.78,"datetime":"2019-03-31 18:00"},{"direction":284.68,"speed":3.59,"datetime":"2019-03-31 19:00"},{"direction":278.21,"speed":2.89,"datetime":"2019-03-31 20:00"},{"direction":275.5,"speed":3.26,"datetime":"2019-03-31 21:00"},{"direction":257.79,"speed":3.07,"datetime":"2019-03-31 22:00"},{"direction":199.01,"speed":4.63,"datetime":"2019-03-31 23:00"},{"direction":189.3,"speed":7.84,"datetime":"2019-04-01 00:00"},{"direction":191.43,"speed":9.33,"datetime":"2019-04-01 01:00"},{"direction":198.27,"speed":9.94,"datetime":"2019-04-01 02:00"},{"direction":200.78,"speed":10.56,"datetime":"2019-04-01 03:00"},{"direction":205.63,"speed":11.21,"datetime":"2019-04-01 04:00"},{"direction":217.29,"speed":11.74,"datetime":"2019-04-01 05:00"},{"direction":223.35,"speed":11.65,"datetime":"2019-04-01 06:00"},{"direction":223.39,"speed":11.64,"datetime":"2019-04-01 07:00"},{"direction":235.91,"speed":17.03,"datetime":"2019-04-01 08:00"},{"direction":252.87,"speed":20.7,"datetime":"2019-04-01 09:00"},{"direction":265.17,"speed":23.25,"datetime":"2019-04-01 10:00"},{"direction":275.81,"speed":24.27,"datetime":"2019-04-01 11:00"},{"direction":290.14,"speed":23.1,"datetime":"2019-04-01 12:00"},{"direction":307.13,"speed":21.27,"datetime":"2019-04-01 13:00"},{"direction":320.15,"speed":19.46,"datetime":"2019-04-01 14:00"},{"direction":332.21,"speed":17.57,"datetime":"2019-04-01 15:00"},{"direction":346.73,"speed":15.84,"datetime":"2019-04-01 16:00"},{"direction":11.63,"speed":13.11,"datetime":"2019-04-01 17:00"},{"direction":38.23,"speed":13.18,"datetime":"2019-04-01 18:00"},{"direction":51.21,"speed":17.41,"datetime":"2019-04-01 19:00"},{"direction":53.94,"speed":18.9,"datetime":"2019-04-01 20:00"},{"direction":55.06,"speed":16.1,"datetime":"2019-04-01 21:00"},{"direction":58.05,"speed":13.72,"datetime":"2019-04-01 22:00"},{"direction":65.94,"speed":12.2,"datetime":"2019-04-01 23:00"},{"direction":76.37,"speed":11.73,"datetime":"2019-04-02 00:00"},{"direction":87.82,"speed":11.55,"datetime":"2019-04-02 01:00"},{"direction":99.09,"speed":11.32,"datetime":"2019-04-02 02:00"},{"direction":101.53,"speed":10.66,"datetime":"2019-04-02 03:00"},{"direction":101.44,"speed":9.83,"datetime":"2019-04-02 04:00"},{"direction":104.8,"speed":9,"datetime":"2019-04-02 05:00"},{"direction":103.18,"speed":8.74,"datetime":"2019-04-02 06:00"},{"direction":97.6,"speed":9.23,"datetime":"2019-04-02 07:00"},{"direction":110.48,"speed":13.98,"datetime":"2019-04-02 08:00"},{"direction":117.11,"speed":14.92,"datetime":"2019-04-02 09:00"},{"direction":119.88,"speed":15.93,"datetime":"2019-04-02 10:00"},{"direction":119.47,"speed":16.72,"datetime":"2019-04-02 11:00"},{"direction":118.93,"speed":16.8,"datetime":"2019-04-02 12:00"},{"direction":122.32,"speed":16.92,"datetime":"2019-04-02 13:00"},{"direction":119.26,"speed":16.16,"datetime":"2019-04-02 14:00"}],"temperature":[{"value":15,"datetime":"2019-03-31 15:00"},{"value":14.17,"datetime":"2019-03-31 16:00"},{"value":13.33,"datetime":"2019-03-31 17:00"},{"value":12.5,"datetime":"2019-03-31 18:00"},{"value":10.67,"datetime":"2019-03-31 19:00"},{"value":10.83,"datetime":"2019-03-31 20:00"},{"value":10,"datetime":"2019-03-31 21:00"},{"value":9,"datetime":"2019-03-31 22:00"},{"value":9,"datetime":"2019-03-31 23:00"},{"value":7.33,"datetime":"2019-04-01 00:00"},{"value":7.67,"datetime":"2019-04-01 01:00"},{"value":7,"datetime":"2019-04-01 02:00"},{"value":6.33,"datetime":"2019-04-01 03:00"},{"value":6.67,"datetime":"2019-04-01 04:00"},{"value":6,"datetime":"2019-04-01 05:00"},{"value":6.67,"datetime":"2019-04-01 06:00"},{"value":8.33,"datetime":"2019-04-01 07:00"},{"value":9.17,"datetime":"2019-04-01 08:00"},{"value":12,"datetime":"2019-04-01 09:00"},{"value":14.83,"datetime":"2019-04-01 10:00"},{"value":17.67,"datetime":"2019-04-01 11:00"},{"value":18.83,"datetime":"2019-04-01 12:00"},{"value":20,"datetime":"2019-04-01 13:00"},{"value":19.65,"datetime":"2019-04-01 14:00"},{"value":19.3,"datetime":"2019-04-01 15:00"},{"value":18.67,"datetime":"2019-04-01 16:00"},{"value":17.35,"datetime":"2019-04-01 17:00"},{"value":14.08,"datetime":"2019-04-01 18:00"},{"value":11.42,"datetime":"2019-04-01 19:00"},{"value":9.92,"datetime":"2019-04-01 20:00"},{"value":8.47,"datetime":"2019-04-01 21:00"},{"value":7.41,"datetime":"2019-04-01 22:00"},{"value":6.76,"datetime":"2019-04-01 23:00"},{"value":6.38,"datetime":"2019-04-02 00:00"},{"value":6.18,"datetime":"2019-04-02 01:00"},{"value":6.31,"datetime":"2019-04-02 02:00"},{"value":6.26,"datetime":"2019-04-02 03:00"},{"value":6.04,"datetime":"2019-04-02 04:00"},{"value":5.99,"datetime":"2019-04-02 05:00"},{"value":6,"datetime":"2019-04-02 06:00"},{"value":6.89,"datetime":"2019-04-02 07:00"},{"value":9.15,"datetime":"2019-04-02 08:00"},{"value":11.12,"datetime":"2019-04-02 09:00"},{"value":13.53,"datetime":"2019-04-02 10:00"},{"value":15.12,"datetime":"2019-04-02 11:00"},{"value":16.06,"datetime":"2019-04-02 12:00"},{"value":17.24,"datetime":"2019-04-02 13:00"},{"value":18,"datetime":"2019-04-02 14:00"}]},"forecast_keypoint":"未来两小时不会下雨，放心出门吧","primary":0,"daily":{"status":"ok","comfort":[{"index":"7","desc":"冷","datetime":"2019-03-31"},{"index":"6","desc":"凉爽","datetime":"2019-04-01"},{"index":"7","desc":"冷","datetime":"2019-04-02"},{"index":"6","desc":"凉爽","datetime":"2019-04-03"},{"index":"5","desc":"舒适","datetime":"2019-04-04"}],"skycon_20h_32h":[{"date":"2019-03-31","value":"CLEAR_NIGHT"},{"date":"2019-04-01","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-02","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-03","value":"CLOUDY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_NIGHT"}],"temperature":[{"date":"2019-03-31","max":15.33,"avg":11.61,"min":2},{"date":"2019-04-01","max":20,"avg":11.73,"min":6},{"date":"2019-04-02","max":18,"avg":10.36,"min":5.99},{"date":"2019-04-03","max":19,"avg":12.33,"min":5.88},{"date":"2019-04-04","max":23,"avg":14.85,"min":8.95}],"dswrf":[{"date":"2019-03-31","max":785.3,"avg":338.8,"min":0},{"date":"2019-04-01","max":776.4,"avg":296.6,"min":0},{"date":"2019-04-02","max":680.1,"avg":239.5,"min":0},{"date":"2019-04-03","max":786.4,"avg":292.7,"min":0},{"date":"2019-04-04","max":781.2,"avg":297.7,"min":0}],"cloudrate":[{"date":"2019-03-31","max":1,"avg":0,"min":0},{"date":"2019-04-01","max":0.04,"avg":0,"min":0},{"date":"2019-04-02","max":1,"avg":0.9,"min":0.17},{"date":"2019-04-03","max":1,"avg":0.56,"min":0},{"date":"2019-04-04","max":1,"avg":0.48,"min":0}],"aqi":[{"date":"2019-03-31","max":107,"avg":53,"min":43},{"date":"2019-04-01","max":62,"avg":52.58,"min":43},{"date":"2019-04-02","max":60,"avg":38.04,"min":21},{"date":"2019-04-03","max":65,"avg":50.42,"min":37},{"date":"2019-04-04","max":82,"avg":66.17,"min":50}],"skycon":[{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_DAY"}],"visibility":[{"date":"2019-03-31","max":24.1,"avg":16.47,"min":16.47},{"date":"2019-04-01","max":16.47,"avg":15.42,"min":10.98},{"date":"2019-04-02","max":16.47,"avg":16.08,"min":12.67},{"date":"2019-04-03","max":16.47,"avg":14.94,"min":9.69},{"date":"2019-04-04","max":16.47,"avg":10.04,"min":4.39}],"humidity":[{"date":"2019-03-31","max":0.35,"avg":0.28,"min":0.14},{"date":"2019-04-01","max":0.51,"avg":0.34,"min":0.21},{"date":"2019-04-02","max":0.59,"avg":0.43,"min":0.26},{"date":"2019-04-03","max":0.76,"avg":0.5,"min":0.27},{"date":"2019-04-04","max":0.74,"avg":0.52,"min":0.32}],"astro":[{"date":"2019-03-31","sunset":{"time":"18:26"},"sunrise":{"time":"05:55"}},{"date":"2019-04-01","sunset":{"time":"18:27"},"sunrise":{"time":"05:53"}},{"date":"2019-04-02","sunset":{"time":"18:27"},"sunrise":{"time":"05:52"}},{"date":"2019-04-03","sunset":{"time":"18:28"},"sunrise":{"time":"05:51"}},{"date":"2019-04-04","sunset":{"time":"18:29"},"sunrise":{"time":"05:49"}}],"coldRisk":[{"index":"4","desc":"极易发","datetime":"2019-03-31"},{"index":"4","desc":"极易发","datetime":"2019-04-01"},{"index":"4","desc":"极易发","datetime":"2019-04-02"},{"index":"4","desc":"极易发","datetime":"2019-04-03"},{"index":"4","desc":"极易发","datetime":"2019-04-04"}],"ultraviolet":[{"index":"4","desc":"强","datetime":"2019-03-31"},{"index":"4","desc":"强","datetime":"2019-04-01"},{"index":"1","desc":"最弱","datetime":"2019-04-02"},{"index":"4","desc":"强","datetime":"2019-04-03"},{"index":"4","desc":"强","datetime":"2019-04-04"}],"pres":[{"date":"2019-03-31","max":101802.45,"avg":101446.8,"min":101364.96},{"date":"2019-04-01","max":101562.45,"avg":101375.16,"min":101173.63},{"date":"2019-04-02","max":101782.55,"avg":101527.8,"min":101382.55},{"date":"2019-04-03","max":102004.96,"avg":101709.44,"min":101433.78},{"date":"2019-04-04","max":101433.78,"avg":100865.45,"min":100393.78}],"pm25":[{"date":"2019-03-31","max":54,"avg":35.44,"min":16},{"date":"2019-04-01","max":45,"avg":37.25,"min":30},{"date":"2019-04-02","max":43,"avg":26.79,"min":15},{"date":"2019-04-03","max":47,"avg":35.71,"min":26},{"date":"2019-04-04","max":61,"avg":48,"min":35}],"dressing":[{"index":"5","desc":"凉爽","datetime":"2019-03-31"},{"index":"6","desc":"冷","datetime":"2019-04-01"},{"index":"5","desc":"凉爽","datetime":"2019-04-02"},{"index":"5","desc":"凉爽","datetime":"2019-04-03"},{"index":"6","desc":"冷","datetime":"2019-04-04"}],"carWashing":[{"index":"1","desc":"适宜","datetime":"2019-03-31"},{"index":"1","desc":"适宜","datetime":"2019-04-01"},{"index":"1","desc":"适宜","datetime":"2019-04-02"},{"index":"1","desc":"适宜","datetime":"2019-04-03"},{"index":"1","desc":"适宜","datetime":"2019-04-04"}],"precipitation":[{"date":"2019-03-31","max":0,"avg":0,"min":0},{"date":"2019-04-01","max":0,"avg":0,"min":0},{"date":"2019-04-02","max":0,"avg":0,"min":0},{"date":"2019-04-03","max":0,"avg":0,"min":0},{"date":"2019-04-04","max":0,"avg":0,"min":0}],"wind":[{"date":"2019-03-31","max":{"direction":269,"speed":30.96},"avg":{"direction":272.64,"speed":7.3},"min":{"direction":266.59,"speed":0.84}},{"date":"2019-04-01","max":{"direction":275.81,"speed":24.27},"avg":{"direction":293.22,"speed":15.46},"min":{"direction":189.3,"speed":7.84}},{"date":"2019-04-02","max":{"direction":122.32,"speed":16.92},"avg":{"direction":107.32,"speed":13},"min":{"direction":120.66,"speed":8.19}},{"date":"2019-04-03","max":{"direction":159.67,"speed":10.14},"avg":{"direction":143.21,"speed":8.22},"min":{"direction":79.64,"speed":6.27}},{"date":"2019-04-04","max":{"direction":221.7,"speed":22.01},"avg":{"direction":213.64,"speed":15.47},"min":{"direction":205.01,"speed":10.24}}],"skycon_08h_20h":[{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"CLEAR_DAY"}]},"minutely":{"status":"ok","description":"未来两小时不会下雨，放心出门吧","probability":[0,0,0,0],"probability_4h":[0,0,0.051129088,0.063936174],"datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]}}
         * server_time : 1554016135
         * api_status : active
         * tzshift : 28800
         * api_version : v2.2
         * unit : metric
         * location_icon : [35.089916,118.40289]
         */

        private String status;
        private String lang;
        private ResultBean result;
        private int server_time;
        private String api_status;
        private int tzshift;
        private String api_version;
        private String unit;
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

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
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

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public List<Double> getLocation() {
            return location;
        }

        public void setLocation(List<Double> location) {
            this.location = location;
        }

        public static class ResultBean {
            /**
             * hourly : {"status":"ok","description":"未来24小时晴","skycon":[{"value":"CLEAR_DAY","datetime":"2019-03-31 15:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 16:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 17:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 00:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 01:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 02:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 03:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 04:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 05:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 06:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 07:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 08:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 09:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 10:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 11:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 12:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 13:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 14:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 15:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 16:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 17:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-02 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 02:00"},{"value":"CLOUDY","datetime":"2019-04-02 03:00"},{"value":"CLOUDY","datetime":"2019-04-02 04:00"},{"value":"CLOUDY","datetime":"2019-04-02 05:00"},{"value":"CLOUDY","datetime":"2019-04-02 06:00"},{"value":"CLOUDY","datetime":"2019-04-02 07:00"},{"value":"CLOUDY","datetime":"2019-04-02 08:00"},{"value":"CLOUDY","datetime":"2019-04-02 09:00"},{"value":"CLOUDY","datetime":"2019-04-02 10:00"},{"value":"CLOUDY","datetime":"2019-04-02 11:00"},{"value":"CLOUDY","datetime":"2019-04-02 12:00"},{"value":"CLOUDY","datetime":"2019-04-02 13:00"},{"value":"CLOUDY","datetime":"2019-04-02 14:00"}],"cloudrate":[{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0.04,"datetime":"2019-04-01 23:00"},{"value":0.17,"datetime":"2019-04-02 00:00"},{"value":0.31,"datetime":"2019-04-02 01:00"},{"value":0.43,"datetime":"2019-04-02 02:00"},{"value":1,"datetime":"2019-04-02 03:00"},{"value":1,"datetime":"2019-04-02 04:00"},{"value":0.99,"datetime":"2019-04-02 05:00"},{"value":0.97,"datetime":"2019-04-02 06:00"},{"value":0.96,"datetime":"2019-04-02 07:00"},{"value":0.97,"datetime":"2019-04-02 08:00"},{"value":1,"datetime":"2019-04-02 09:00"},{"value":1,"datetime":"2019-04-02 10:00"},{"value":1,"datetime":"2019-04-02 11:00"},{"value":1,"datetime":"2019-04-02 12:00"},{"value":1,"datetime":"2019-04-02 13:00"},{"value":1,"datetime":"2019-04-02 14:00"}],"aqi":[{"value":61,"datetime":"2019-03-31 15:00"},{"value":43,"datetime":"2019-03-31 16:00"},{"value":47,"datetime":"2019-03-31 17:00"},{"value":51,"datetime":"2019-03-31 18:00"},{"value":54,"datetime":"2019-03-31 19:00"},{"value":55,"datetime":"2019-03-31 20:00"},{"value":55,"datetime":"2019-03-31 21:00"},{"value":55,"datetime":"2019-03-31 22:00"},{"value":56,"datetime":"2019-03-31 23:00"},{"value":57,"datetime":"2019-04-01 00:00"},{"value":59,"datetime":"2019-04-01 01:00"},{"value":59,"datetime":"2019-04-01 02:00"},{"value":57,"datetime":"2019-04-01 03:00"},{"value":56,"datetime":"2019-04-01 04:00"},{"value":55,"datetime":"2019-04-01 05:00"},{"value":55,"datetime":"2019-04-01 06:00"},{"value":56,"datetime":"2019-04-01 07:00"},{"value":59,"datetime":"2019-04-01 08:00"},{"value":61,"datetime":"2019-04-01 09:00"},{"value":62,"datetime":"2019-04-01 10:00"},{"value":60,"datetime":"2019-04-01 11:00"},{"value":55,"datetime":"2019-04-01 12:00"},{"value":49,"datetime":"2019-04-01 13:00"},{"value":43,"datetime":"2019-04-01 14:00"},{"value":43,"datetime":"2019-04-01 15:00"},{"value":46,"datetime":"2019-04-01 16:00"},{"value":47,"datetime":"2019-04-01 17:00"},{"value":49,"datetime":"2019-04-01 18:00"},{"value":47,"datetime":"2019-04-01 19:00"},{"value":46,"datetime":"2019-04-01 20:00"},{"value":47,"datetime":"2019-04-01 21:00"},{"value":47,"datetime":"2019-04-01 22:00"},{"value":47,"datetime":"2019-04-01 23:00"},{"value":46,"datetime":"2019-04-02 00:00"},{"value":44,"datetime":"2019-04-02 01:00"},{"value":46,"datetime":"2019-04-02 02:00"},{"value":50,"datetime":"2019-04-02 03:00"},{"value":55,"datetime":"2019-04-02 04:00"},{"value":59,"datetime":"2019-04-02 05:00"},{"value":60,"datetime":"2019-04-02 06:00"},{"value":59,"datetime":"2019-04-02 07:00"},{"value":55,"datetime":"2019-04-02 08:00"},{"value":50,"datetime":"2019-04-02 09:00"},{"value":43,"datetime":"2019-04-02 10:00"},{"value":37,"datetime":"2019-04-02 11:00"},{"value":31,"datetime":"2019-04-02 12:00"},{"value":27,"datetime":"2019-04-02 13:00"},{"value":24,"datetime":"2019-04-02 14:00"}],"dswrf":[{"value":740,"datetime":"2019-03-31 15:00"},{"value":650,"datetime":"2019-03-31 16:00"},{"value":550,"datetime":"2019-03-31 17:00"},{"value":450,"datetime":"2019-03-31 18:00"},{"value":360,"datetime":"2019-03-31 19:00"},{"value":298.77686,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":13,"datetime":"2019-04-01 07:00"},{"value":56.611572,"datetime":"2019-04-01 08:00"},{"value":490,"datetime":"2019-04-01 09:00"},{"value":586.1157,"datetime":"2019-04-01 10:00"},{"value":663.9161,"datetime":"2019-04-01 11:00"},{"value":722.22314,"datetime":"2019-04-01 12:00"},{"value":760.47186,"datetime":"2019-04-01 13:00"},{"value":776.3916,"datetime":"2019-04-01 14:00"},{"value":740,"datetime":"2019-04-01 15:00"},{"value":650,"datetime":"2019-04-01 16:00"},{"value":550,"datetime":"2019-04-01 17:00"},{"value":450,"datetime":"2019-04-01 18:00"},{"value":360,"datetime":"2019-04-01 19:00"},{"value":300.13654,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":11.97124,"datetime":"2019-04-02 07:00"},{"value":45.053425,"datetime":"2019-04-02 08:00"},{"value":384.38672,"datetime":"2019-04-02 09:00"},{"value":504.38672,"datetime":"2019-04-02 10:00"},{"value":586.90576,"datetime":"2019-04-02 11:00"},{"value":628.7348,"datetime":"2019-04-02 12:00"},{"value":660.68134,"datetime":"2019-04-02 13:00"},{"value":680.13495,"datetime":"2019-04-02 14:00"}],"visibility":[{"value":16.47,"datetime":"2019-03-31 15:00"},{"value":16.47,"datetime":"2019-03-31 16:00"},{"value":16.47,"datetime":"2019-03-31 17:00"},{"value":16.47,"datetime":"2019-03-31 18:00"},{"value":16.47,"datetime":"2019-03-31 19:00"},{"value":16.47,"datetime":"2019-03-31 20:00"},{"value":16.47,"datetime":"2019-03-31 21:00"},{"value":16.47,"datetime":"2019-03-31 22:00"},{"value":16.47,"datetime":"2019-03-31 23:00"},{"value":14.97,"datetime":"2019-04-01 00:00"},{"value":13.72,"datetime":"2019-04-01 01:00"},{"value":13.72,"datetime":"2019-04-01 02:00"},{"value":14.97,"datetime":"2019-04-01 03:00"},{"value":16.47,"datetime":"2019-04-01 04:00"},{"value":16.47,"datetime":"2019-04-01 05:00"},{"value":16.47,"datetime":"2019-04-01 06:00"},{"value":16.47,"datetime":"2019-04-01 07:00"},{"value":13.72,"datetime":"2019-04-01 08:00"},{"value":11.76,"datetime":"2019-04-01 09:00"},{"value":10.98,"datetime":"2019-04-01 10:00"},{"value":12.67,"datetime":"2019-04-01 11:00"},{"value":16.47,"datetime":"2019-04-01 12:00"},{"value":16.47,"datetime":"2019-04-01 13:00"},{"value":16.47,"datetime":"2019-04-01 14:00"},{"value":16.47,"datetime":"2019-04-01 15:00"},{"value":16.47,"datetime":"2019-04-01 16:00"},{"value":16.47,"datetime":"2019-04-01 17:00"},{"value":16.47,"datetime":"2019-04-01 18:00"},{"value":16.47,"datetime":"2019-04-01 19:00"},{"value":16.47,"datetime":"2019-04-01 20:00"},{"value":16.47,"datetime":"2019-04-01 21:00"},{"value":16.47,"datetime":"2019-04-01 22:00"},{"value":16.47,"datetime":"2019-04-01 23:00"},{"value":16.47,"datetime":"2019-04-02 00:00"},{"value":16.47,"datetime":"2019-04-02 01:00"},{"value":16.47,"datetime":"2019-04-02 02:00"},{"value":16.47,"datetime":"2019-04-02 03:00"},{"value":16.47,"datetime":"2019-04-02 04:00"},{"value":13.72,"datetime":"2019-04-02 05:00"},{"value":12.67,"datetime":"2019-04-02 06:00"},{"value":13.72,"datetime":"2019-04-02 07:00"},{"value":16.47,"datetime":"2019-04-02 08:00"},{"value":16.47,"datetime":"2019-04-02 09:00"},{"value":16.47,"datetime":"2019-04-02 10:00"},{"value":16.47,"datetime":"2019-04-02 11:00"},{"value":16.47,"datetime":"2019-04-02 12:00"},{"value":16.47,"datetime":"2019-04-02 13:00"},{"value":16.47,"datetime":"2019-04-02 14:00"}],"humidity":[{"value":0.14,"datetime":"2019-03-31 15:00"},{"value":0.21,"datetime":"2019-03-31 16:00"},{"value":0.24,"datetime":"2019-03-31 17:00"},{"value":0.32,"datetime":"2019-03-31 18:00"},{"value":0.31,"datetime":"2019-03-31 19:00"},{"value":0.32,"datetime":"2019-03-31 20:00"},{"value":0.33,"datetime":"2019-03-31 21:00"},{"value":0.34,"datetime":"2019-03-31 22:00"},{"value":0.34,"datetime":"2019-03-31 23:00"},{"value":0.36,"datetime":"2019-04-01 00:00"},{"value":0.4,"datetime":"2019-04-01 01:00"},{"value":0.43,"datetime":"2019-04-01 02:00"},{"value":0.45,"datetime":"2019-04-01 03:00"},{"value":0.47,"datetime":"2019-04-01 04:00"},{"value":0.48,"datetime":"2019-04-01 05:00"},{"value":0.49,"datetime":"2019-04-01 06:00"},{"value":0.51,"datetime":"2019-04-01 07:00"},{"value":0.44,"datetime":"2019-04-01 08:00"},{"value":0.39,"datetime":"2019-04-01 09:00"},{"value":0.34,"datetime":"2019-04-01 10:00"},{"value":0.31,"datetime":"2019-04-01 11:00"},{"value":0.27,"datetime":"2019-04-01 12:00"},{"value":0.24,"datetime":"2019-04-01 13:00"},{"value":0.22,"datetime":"2019-04-01 14:00"},{"value":0.21,"datetime":"2019-04-01 15:00"},{"value":0.21,"datetime":"2019-04-01 16:00"},{"value":0.25,"datetime":"2019-04-01 17:00"},{"value":0.31,"datetime":"2019-04-01 18:00"},{"value":0.31,"datetime":"2019-04-01 19:00"},{"value":0.3,"datetime":"2019-04-01 20:00"},{"value":0.3,"datetime":"2019-04-01 21:00"},{"value":0.29,"datetime":"2019-04-01 22:00"},{"value":0.28,"datetime":"2019-04-01 23:00"},{"value":0.3,"datetime":"2019-04-02 00:00"},{"value":0.38,"datetime":"2019-04-02 01:00"},{"value":0.48,"datetime":"2019-04-02 02:00"},{"value":0.53,"datetime":"2019-04-02 03:00"},{"value":0.56,"datetime":"2019-04-02 04:00"},{"value":0.58,"datetime":"2019-04-02 05:00"},{"value":0.59,"datetime":"2019-04-02 06:00"},{"value":0.58,"datetime":"2019-04-02 07:00"},{"value":0.45,"datetime":"2019-04-02 08:00"},{"value":0.37,"datetime":"2019-04-02 09:00"},{"value":0.31,"datetime":"2019-04-02 10:00"},{"value":0.28,"datetime":"2019-04-02 11:00"},{"value":0.27,"datetime":"2019-04-02 12:00"},{"value":0.26,"datetime":"2019-04-02 13:00"},{"value":0.26,"datetime":"2019-04-02 14:00"}],"pres":[{"value":101444.95,"datetime":"2019-03-31 15:00"},{"value":101402.45,"datetime":"2019-03-31 16:00"},{"value":101364.95,"datetime":"2019-03-31 17:00"},{"value":101382.555,"datetime":"2019-03-31 18:00"},{"value":101402.45,"datetime":"2019-03-31 19:00"},{"value":101482.45,"datetime":"2019-03-31 20:00"},{"value":101513.78,"datetime":"2019-03-31 21:00"},{"value":101513.78,"datetime":"2019-03-31 22:00"},{"value":101513.78,"datetime":"2019-03-31 23:00"},{"value":101482.45,"datetime":"2019-04-01 00:00"},{"value":101464.85,"datetime":"2019-04-01 01:00"},{"value":101433.78,"datetime":"2019-04-01 02:00"},{"value":101402.45,"datetime":"2019-04-01 03:00"},{"value":101353.78,"datetime":"2019-04-01 04:00"},{"value":101384.85,"datetime":"2019-04-01 05:00"},{"value":101384.85,"datetime":"2019-04-01 06:00"},{"value":101402.45,"datetime":"2019-04-01 07:00"},{"value":101402.45,"datetime":"2019-04-01 08:00"},{"value":101433.78,"datetime":"2019-04-01 09:00"},{"value":101433.78,"datetime":"2019-04-01 10:00"},{"value":101384.85,"datetime":"2019-04-01 11:00"},{"value":101364.95,"datetime":"2019-04-01 12:00"},{"value":101322.45,"datetime":"2019-04-01 13:00"},{"value":101242.45,"datetime":"2019-04-01 14:00"},{"value":101204.95,"datetime":"2019-04-01 15:00"},{"value":101173.625,"datetime":"2019-04-01 16:00"},{"value":101204.95,"datetime":"2019-04-01 17:00"},{"value":101222.555,"datetime":"2019-04-01 18:00"},{"value":101302.555,"datetime":"2019-04-01 19:00"},{"value":101382.555,"datetime":"2019-04-01 20:00"},{"value":101493.625,"datetime":"2019-04-01 21:00"},{"value":101562.45,"datetime":"2019-04-01 22:00"},{"value":101562.45,"datetime":"2019-04-01 23:00"},{"value":101562.45,"datetime":"2019-04-02 00:00"},{"value":101542.555,"datetime":"2019-04-02 01:00"},{"value":101482.45,"datetime":"2019-04-02 02:00"},{"value":101462.555,"datetime":"2019-04-02 03:00"},{"value":101444.95,"datetime":"2019-04-02 04:00"},{"value":101462.555,"datetime":"2019-04-02 05:00"},{"value":101482.45,"datetime":"2019-04-02 06:00"},{"value":101482.45,"datetime":"2019-04-02 07:00"},{"value":101524.95,"datetime":"2019-04-02 08:00"},{"value":101562.45,"datetime":"2019-04-02 09:00"},{"value":101562.45,"datetime":"2019-04-02 10:00"},{"value":101562.45,"datetime":"2019-04-02 11:00"},{"value":101524.95,"datetime":"2019-04-02 12:00"},{"value":101482.45,"datetime":"2019-04-02 13:00"},{"value":101402.45,"datetime":"2019-04-02 14:00"}],"pm25":[{"value":25,"datetime":"2019-03-31 15:00"},{"value":30,"datetime":"2019-03-31 16:00"},{"value":33,"datetime":"2019-03-31 17:00"},{"value":36,"datetime":"2019-03-31 18:00"},{"value":38,"datetime":"2019-03-31 19:00"},{"value":39,"datetime":"2019-03-31 20:00"},{"value":39,"datetime":"2019-03-31 21:00"},{"value":39,"datetime":"2019-03-31 22:00"},{"value":40,"datetime":"2019-03-31 23:00"},{"value":41,"datetime":"2019-04-01 00:00"},{"value":42,"datetime":"2019-04-01 01:00"},{"value":42,"datetime":"2019-04-01 02:00"},{"value":41,"datetime":"2019-04-01 03:00"},{"value":40,"datetime":"2019-04-01 04:00"},{"value":39,"datetime":"2019-04-01 05:00"},{"value":39,"datetime":"2019-04-01 06:00"},{"value":40,"datetime":"2019-04-01 07:00"},{"value":42,"datetime":"2019-04-01 08:00"},{"value":44,"datetime":"2019-04-01 09:00"},{"value":45,"datetime":"2019-04-01 10:00"},{"value":43,"datetime":"2019-04-01 11:00"},{"value":39,"datetime":"2019-04-01 12:00"},{"value":34,"datetime":"2019-04-01 13:00"},{"value":30,"datetime":"2019-04-01 14:00"},{"value":30,"datetime":"2019-04-01 15:00"},{"value":32,"datetime":"2019-04-01 16:00"},{"value":33,"datetime":"2019-04-01 17:00"},{"value":34,"datetime":"2019-04-01 18:00"},{"value":33,"datetime":"2019-04-01 19:00"},{"value":32,"datetime":"2019-04-01 20:00"},{"value":33,"datetime":"2019-04-01 21:00"},{"value":33,"datetime":"2019-04-01 22:00"},{"value":33,"datetime":"2019-04-01 23:00"},{"value":32,"datetime":"2019-04-02 00:00"},{"value":31,"datetime":"2019-04-02 01:00"},{"value":32,"datetime":"2019-04-02 02:00"},{"value":35,"datetime":"2019-04-02 03:00"},{"value":39,"datetime":"2019-04-02 04:00"},{"value":42,"datetime":"2019-04-02 05:00"},{"value":43,"datetime":"2019-04-02 06:00"},{"value":42,"datetime":"2019-04-02 07:00"},{"value":39,"datetime":"2019-04-02 08:00"},{"value":35,"datetime":"2019-04-02 09:00"},{"value":30,"datetime":"2019-04-02 10:00"},{"value":26,"datetime":"2019-04-02 11:00"},{"value":22,"datetime":"2019-04-02 12:00"},{"value":19,"datetime":"2019-04-02 13:00"},{"value":17,"datetime":"2019-04-02 14:00"}],"precipitation":[{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":0,"datetime":"2019-04-02 07:00"},{"value":0,"datetime":"2019-04-02 08:00"},{"value":0,"datetime":"2019-04-02 09:00"},{"value":0,"datetime":"2019-04-02 10:00"},{"value":0,"datetime":"2019-04-02 11:00"},{"value":0,"datetime":"2019-04-02 12:00"},{"value":0,"datetime":"2019-04-02 13:00"},{"value":0,"datetime":"2019-04-02 14:00"}],"wind":[{"direction":269,"speed":30.96,"datetime":"2019-03-31 15:00"},{"direction":288.88,"speed":15.32,"datetime":"2019-03-31 16:00"},{"direction":289.11,"speed":12.43,"datetime":"2019-03-31 17:00"},{"direction":289.6,"speed":5.78,"datetime":"2019-03-31 18:00"},{"direction":284.68,"speed":3.59,"datetime":"2019-03-31 19:00"},{"direction":278.21,"speed":2.89,"datetime":"2019-03-31 20:00"},{"direction":275.5,"speed":3.26,"datetime":"2019-03-31 21:00"},{"direction":257.79,"speed":3.07,"datetime":"2019-03-31 22:00"},{"direction":199.01,"speed":4.63,"datetime":"2019-03-31 23:00"},{"direction":189.3,"speed":7.84,"datetime":"2019-04-01 00:00"},{"direction":191.43,"speed":9.33,"datetime":"2019-04-01 01:00"},{"direction":198.27,"speed":9.94,"datetime":"2019-04-01 02:00"},{"direction":200.78,"speed":10.56,"datetime":"2019-04-01 03:00"},{"direction":205.63,"speed":11.21,"datetime":"2019-04-01 04:00"},{"direction":217.29,"speed":11.74,"datetime":"2019-04-01 05:00"},{"direction":223.35,"speed":11.65,"datetime":"2019-04-01 06:00"},{"direction":223.39,"speed":11.64,"datetime":"2019-04-01 07:00"},{"direction":235.91,"speed":17.03,"datetime":"2019-04-01 08:00"},{"direction":252.87,"speed":20.7,"datetime":"2019-04-01 09:00"},{"direction":265.17,"speed":23.25,"datetime":"2019-04-01 10:00"},{"direction":275.81,"speed":24.27,"datetime":"2019-04-01 11:00"},{"direction":290.14,"speed":23.1,"datetime":"2019-04-01 12:00"},{"direction":307.13,"speed":21.27,"datetime":"2019-04-01 13:00"},{"direction":320.15,"speed":19.46,"datetime":"2019-04-01 14:00"},{"direction":332.21,"speed":17.57,"datetime":"2019-04-01 15:00"},{"direction":346.73,"speed":15.84,"datetime":"2019-04-01 16:00"},{"direction":11.63,"speed":13.11,"datetime":"2019-04-01 17:00"},{"direction":38.23,"speed":13.18,"datetime":"2019-04-01 18:00"},{"direction":51.21,"speed":17.41,"datetime":"2019-04-01 19:00"},{"direction":53.94,"speed":18.9,"datetime":"2019-04-01 20:00"},{"direction":55.06,"speed":16.1,"datetime":"2019-04-01 21:00"},{"direction":58.05,"speed":13.72,"datetime":"2019-04-01 22:00"},{"direction":65.94,"speed":12.2,"datetime":"2019-04-01 23:00"},{"direction":76.37,"speed":11.73,"datetime":"2019-04-02 00:00"},{"direction":87.82,"speed":11.55,"datetime":"2019-04-02 01:00"},{"direction":99.09,"speed":11.32,"datetime":"2019-04-02 02:00"},{"direction":101.53,"speed":10.66,"datetime":"2019-04-02 03:00"},{"direction":101.44,"speed":9.83,"datetime":"2019-04-02 04:00"},{"direction":104.8,"speed":9,"datetime":"2019-04-02 05:00"},{"direction":103.18,"speed":8.74,"datetime":"2019-04-02 06:00"},{"direction":97.6,"speed":9.23,"datetime":"2019-04-02 07:00"},{"direction":110.48,"speed":13.98,"datetime":"2019-04-02 08:00"},{"direction":117.11,"speed":14.92,"datetime":"2019-04-02 09:00"},{"direction":119.88,"speed":15.93,"datetime":"2019-04-02 10:00"},{"direction":119.47,"speed":16.72,"datetime":"2019-04-02 11:00"},{"direction":118.93,"speed":16.8,"datetime":"2019-04-02 12:00"},{"direction":122.32,"speed":16.92,"datetime":"2019-04-02 13:00"},{"direction":119.26,"speed":16.16,"datetime":"2019-04-02 14:00"}],"temperature":[{"value":15,"datetime":"2019-03-31 15:00"},{"value":14.17,"datetime":"2019-03-31 16:00"},{"value":13.33,"datetime":"2019-03-31 17:00"},{"value":12.5,"datetime":"2019-03-31 18:00"},{"value":10.67,"datetime":"2019-03-31 19:00"},{"value":10.83,"datetime":"2019-03-31 20:00"},{"value":10,"datetime":"2019-03-31 21:00"},{"value":9,"datetime":"2019-03-31 22:00"},{"value":9,"datetime":"2019-03-31 23:00"},{"value":7.33,"datetime":"2019-04-01 00:00"},{"value":7.67,"datetime":"2019-04-01 01:00"},{"value":7,"datetime":"2019-04-01 02:00"},{"value":6.33,"datetime":"2019-04-01 03:00"},{"value":6.67,"datetime":"2019-04-01 04:00"},{"value":6,"datetime":"2019-04-01 05:00"},{"value":6.67,"datetime":"2019-04-01 06:00"},{"value":8.33,"datetime":"2019-04-01 07:00"},{"value":9.17,"datetime":"2019-04-01 08:00"},{"value":12,"datetime":"2019-04-01 09:00"},{"value":14.83,"datetime":"2019-04-01 10:00"},{"value":17.67,"datetime":"2019-04-01 11:00"},{"value":18.83,"datetime":"2019-04-01 12:00"},{"value":20,"datetime":"2019-04-01 13:00"},{"value":19.65,"datetime":"2019-04-01 14:00"},{"value":19.3,"datetime":"2019-04-01 15:00"},{"value":18.67,"datetime":"2019-04-01 16:00"},{"value":17.35,"datetime":"2019-04-01 17:00"},{"value":14.08,"datetime":"2019-04-01 18:00"},{"value":11.42,"datetime":"2019-04-01 19:00"},{"value":9.92,"datetime":"2019-04-01 20:00"},{"value":8.47,"datetime":"2019-04-01 21:00"},{"value":7.41,"datetime":"2019-04-01 22:00"},{"value":6.76,"datetime":"2019-04-01 23:00"},{"value":6.38,"datetime":"2019-04-02 00:00"},{"value":6.18,"datetime":"2019-04-02 01:00"},{"value":6.31,"datetime":"2019-04-02 02:00"},{"value":6.26,"datetime":"2019-04-02 03:00"},{"value":6.04,"datetime":"2019-04-02 04:00"},{"value":5.99,"datetime":"2019-04-02 05:00"},{"value":6,"datetime":"2019-04-02 06:00"},{"value":6.89,"datetime":"2019-04-02 07:00"},{"value":9.15,"datetime":"2019-04-02 08:00"},{"value":11.12,"datetime":"2019-04-02 09:00"},{"value":13.53,"datetime":"2019-04-02 10:00"},{"value":15.12,"datetime":"2019-04-02 11:00"},{"value":16.06,"datetime":"2019-04-02 12:00"},{"value":17.24,"datetime":"2019-04-02 13:00"},{"value":18,"datetime":"2019-04-02 14:00"}]}
             * forecast_keypoint : 未来两小时不会下雨，放心出门吧
             * primary : 0
             * daily : {"status":"ok","comfort":[{"index":"7","desc":"冷","datetime":"2019-03-31"},{"index":"6","desc":"凉爽","datetime":"2019-04-01"},{"index":"7","desc":"冷","datetime":"2019-04-02"},{"index":"6","desc":"凉爽","datetime":"2019-04-03"},{"index":"5","desc":"舒适","datetime":"2019-04-04"}],"skycon_20h_32h":[{"date":"2019-03-31","value":"CLEAR_NIGHT"},{"date":"2019-04-01","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-02","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-03","value":"CLOUDY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_NIGHT"}],"temperature":[{"date":"2019-03-31","max":15.33,"avg":11.61,"min":2},{"date":"2019-04-01","max":20,"avg":11.73,"min":6},{"date":"2019-04-02","max":18,"avg":10.36,"min":5.99},{"date":"2019-04-03","max":19,"avg":12.33,"min":5.88},{"date":"2019-04-04","max":23,"avg":14.85,"min":8.95}],"dswrf":[{"date":"2019-03-31","max":785.3,"avg":338.8,"min":0},{"date":"2019-04-01","max":776.4,"avg":296.6,"min":0},{"date":"2019-04-02","max":680.1,"avg":239.5,"min":0},{"date":"2019-04-03","max":786.4,"avg":292.7,"min":0},{"date":"2019-04-04","max":781.2,"avg":297.7,"min":0}],"cloudrate":[{"date":"2019-03-31","max":1,"avg":0,"min":0},{"date":"2019-04-01","max":0.04,"avg":0,"min":0},{"date":"2019-04-02","max":1,"avg":0.9,"min":0.17},{"date":"2019-04-03","max":1,"avg":0.56,"min":0},{"date":"2019-04-04","max":1,"avg":0.48,"min":0}],"aqi":[{"date":"2019-03-31","max":107,"avg":53,"min":43},{"date":"2019-04-01","max":62,"avg":52.58,"min":43},{"date":"2019-04-02","max":60,"avg":38.04,"min":21},{"date":"2019-04-03","max":65,"avg":50.42,"min":37},{"date":"2019-04-04","max":82,"avg":66.17,"min":50}],"skycon":[{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_DAY"}],"visibility":[{"date":"2019-03-31","max":24.1,"avg":16.47,"min":16.47},{"date":"2019-04-01","max":16.47,"avg":15.42,"min":10.98},{"date":"2019-04-02","max":16.47,"avg":16.08,"min":12.67},{"date":"2019-04-03","max":16.47,"avg":14.94,"min":9.69},{"date":"2019-04-04","max":16.47,"avg":10.04,"min":4.39}],"humidity":[{"date":"2019-03-31","max":0.35,"avg":0.28,"min":0.14},{"date":"2019-04-01","max":0.51,"avg":0.34,"min":0.21},{"date":"2019-04-02","max":0.59,"avg":0.43,"min":0.26},{"date":"2019-04-03","max":0.76,"avg":0.5,"min":0.27},{"date":"2019-04-04","max":0.74,"avg":0.52,"min":0.32}],"astro":[{"date":"2019-03-31","sunset":{"time":"18:26"},"sunrise":{"time":"05:55"}},{"date":"2019-04-01","sunset":{"time":"18:27"},"sunrise":{"time":"05:53"}},{"date":"2019-04-02","sunset":{"time":"18:27"},"sunrise":{"time":"05:52"}},{"date":"2019-04-03","sunset":{"time":"18:28"},"sunrise":{"time":"05:51"}},{"date":"2019-04-04","sunset":{"time":"18:29"},"sunrise":{"time":"05:49"}}],"coldRisk":[{"index":"4","desc":"极易发","datetime":"2019-03-31"},{"index":"4","desc":"极易发","datetime":"2019-04-01"},{"index":"4","desc":"极易发","datetime":"2019-04-02"},{"index":"4","desc":"极易发","datetime":"2019-04-03"},{"index":"4","desc":"极易发","datetime":"2019-04-04"}],"ultraviolet":[{"index":"4","desc":"强","datetime":"2019-03-31"},{"index":"4","desc":"强","datetime":"2019-04-01"},{"index":"1","desc":"最弱","datetime":"2019-04-02"},{"index":"4","desc":"强","datetime":"2019-04-03"},{"index":"4","desc":"强","datetime":"2019-04-04"}],"pres":[{"date":"2019-03-31","max":101802.45,"avg":101446.8,"min":101364.96},{"date":"2019-04-01","max":101562.45,"avg":101375.16,"min":101173.63},{"date":"2019-04-02","max":101782.55,"avg":101527.8,"min":101382.55},{"date":"2019-04-03","max":102004.96,"avg":101709.44,"min":101433.78},{"date":"2019-04-04","max":101433.78,"avg":100865.45,"min":100393.78}],"pm25":[{"date":"2019-03-31","max":54,"avg":35.44,"min":16},{"date":"2019-04-01","max":45,"avg":37.25,"min":30},{"date":"2019-04-02","max":43,"avg":26.79,"min":15},{"date":"2019-04-03","max":47,"avg":35.71,"min":26},{"date":"2019-04-04","max":61,"avg":48,"min":35}],"dressing":[{"index":"5","desc":"凉爽","datetime":"2019-03-31"},{"index":"6","desc":"冷","datetime":"2019-04-01"},{"index":"5","desc":"凉爽","datetime":"2019-04-02"},{"index":"5","desc":"凉爽","datetime":"2019-04-03"},{"index":"6","desc":"冷","datetime":"2019-04-04"}],"carWashing":[{"index":"1","desc":"适宜","datetime":"2019-03-31"},{"index":"1","desc":"适宜","datetime":"2019-04-01"},{"index":"1","desc":"适宜","datetime":"2019-04-02"},{"index":"1","desc":"适宜","datetime":"2019-04-03"},{"index":"1","desc":"适宜","datetime":"2019-04-04"}],"precipitation":[{"date":"2019-03-31","max":0,"avg":0,"min":0},{"date":"2019-04-01","max":0,"avg":0,"min":0},{"date":"2019-04-02","max":0,"avg":0,"min":0},{"date":"2019-04-03","max":0,"avg":0,"min":0},{"date":"2019-04-04","max":0,"avg":0,"min":0}],"wind":[{"date":"2019-03-31","max":{"direction":269,"speed":30.96},"avg":{"direction":272.64,"speed":7.3},"min":{"direction":266.59,"speed":0.84}},{"date":"2019-04-01","max":{"direction":275.81,"speed":24.27},"avg":{"direction":293.22,"speed":15.46},"min":{"direction":189.3,"speed":7.84}},{"date":"2019-04-02","max":{"direction":122.32,"speed":16.92},"avg":{"direction":107.32,"speed":13},"min":{"direction":120.66,"speed":8.19}},{"date":"2019-04-03","max":{"direction":159.67,"speed":10.14},"avg":{"direction":143.21,"speed":8.22},"min":{"direction":79.64,"speed":6.27}},{"date":"2019-04-04","max":{"direction":221.7,"speed":22.01},"avg":{"direction":213.64,"speed":15.47},"min":{"direction":205.01,"speed":10.24}}],"skycon_08h_20h":[{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"CLEAR_DAY"}]}
             * minutely : {"status":"ok","description":"未来两小时不会下雨，放心出门吧","probability":[0,0,0,0],"probability_4h":[0,0,0.051129088,0.063936174],"datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]}
             */

            private HourlyBean hourly;//小时级预报
            private String forecast_keypoint;
            private int primary;
            private DailyBean daily;//天级预报
            private MinutelyBean minutely;//分钟级预报

            public HourlyBean getHourly() {
                return hourly;
            }

            public void setHourly(HourlyBean hourly) {
                this.hourly = hourly;
            }

            public String getForecast_keypoint() {
                return forecast_keypoint;
            }

            public void setForecast_keypoint(String forecast_keypoint) {
                this.forecast_keypoint = forecast_keypoint;
            }

            public int getPrimary() {
                return primary;
            }

            public void setPrimary(int primary) {
                this.primary = primary;
            }

            public DailyBean getDaily() {
                return daily;
            }

            public void setDaily(DailyBean daily) {
                this.daily = daily;
            }

            public MinutelyBean getMinutely() {
                return minutely;
            }

            public void setMinutely(MinutelyBean minutely) {
                this.minutely = minutely;
            }

            public static class HourlyBean {
                /**
                 * status : ok
                 * description : 未来24小时晴
                 * skycon : [{"value":"CLEAR_DAY","datetime":"2019-03-31 15:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 16:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 17:00"},{"value":"CLEAR_DAY","datetime":"2019-03-31 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-03-31 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 00:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 01:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 02:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 03:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 04:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 05:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 06:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 07:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 08:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 09:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 10:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 11:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 12:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 13:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 14:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 15:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 16:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 17:00"},{"value":"CLEAR_DAY","datetime":"2019-04-01 18:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 19:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 20:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 21:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 22:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-01 23:00"},{"value":"CLEAR_NIGHT","datetime":"2019-04-02 00:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 01:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2019-04-02 02:00"},{"value":"CLOUDY","datetime":"2019-04-02 03:00"},{"value":"CLOUDY","datetime":"2019-04-02 04:00"},{"value":"CLOUDY","datetime":"2019-04-02 05:00"},{"value":"CLOUDY","datetime":"2019-04-02 06:00"},{"value":"CLOUDY","datetime":"2019-04-02 07:00"},{"value":"CLOUDY","datetime":"2019-04-02 08:00"},{"value":"CLOUDY","datetime":"2019-04-02 09:00"},{"value":"CLOUDY","datetime":"2019-04-02 10:00"},{"value":"CLOUDY","datetime":"2019-04-02 11:00"},{"value":"CLOUDY","datetime":"2019-04-02 12:00"},{"value":"CLOUDY","datetime":"2019-04-02 13:00"},{"value":"CLOUDY","datetime":"2019-04-02 14:00"}]
                 * cloudrate : [{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0.04,"datetime":"2019-04-01 23:00"},{"value":0.17,"datetime":"2019-04-02 00:00"},{"value":0.31,"datetime":"2019-04-02 01:00"},{"value":0.43,"datetime":"2019-04-02 02:00"},{"value":1,"datetime":"2019-04-02 03:00"},{"value":1,"datetime":"2019-04-02 04:00"},{"value":0.99,"datetime":"2019-04-02 05:00"},{"value":0.97,"datetime":"2019-04-02 06:00"},{"value":0.96,"datetime":"2019-04-02 07:00"},{"value":0.97,"datetime":"2019-04-02 08:00"},{"value":1,"datetime":"2019-04-02 09:00"},{"value":1,"datetime":"2019-04-02 10:00"},{"value":1,"datetime":"2019-04-02 11:00"},{"value":1,"datetime":"2019-04-02 12:00"},{"value":1,"datetime":"2019-04-02 13:00"},{"value":1,"datetime":"2019-04-02 14:00"}]
                 * aqi : [{"value":61,"datetime":"2019-03-31 15:00"},{"value":43,"datetime":"2019-03-31 16:00"},{"value":47,"datetime":"2019-03-31 17:00"},{"value":51,"datetime":"2019-03-31 18:00"},{"value":54,"datetime":"2019-03-31 19:00"},{"value":55,"datetime":"2019-03-31 20:00"},{"value":55,"datetime":"2019-03-31 21:00"},{"value":55,"datetime":"2019-03-31 22:00"},{"value":56,"datetime":"2019-03-31 23:00"},{"value":57,"datetime":"2019-04-01 00:00"},{"value":59,"datetime":"2019-04-01 01:00"},{"value":59,"datetime":"2019-04-01 02:00"},{"value":57,"datetime":"2019-04-01 03:00"},{"value":56,"datetime":"2019-04-01 04:00"},{"value":55,"datetime":"2019-04-01 05:00"},{"value":55,"datetime":"2019-04-01 06:00"},{"value":56,"datetime":"2019-04-01 07:00"},{"value":59,"datetime":"2019-04-01 08:00"},{"value":61,"datetime":"2019-04-01 09:00"},{"value":62,"datetime":"2019-04-01 10:00"},{"value":60,"datetime":"2019-04-01 11:00"},{"value":55,"datetime":"2019-04-01 12:00"},{"value":49,"datetime":"2019-04-01 13:00"},{"value":43,"datetime":"2019-04-01 14:00"},{"value":43,"datetime":"2019-04-01 15:00"},{"value":46,"datetime":"2019-04-01 16:00"},{"value":47,"datetime":"2019-04-01 17:00"},{"value":49,"datetime":"2019-04-01 18:00"},{"value":47,"datetime":"2019-04-01 19:00"},{"value":46,"datetime":"2019-04-01 20:00"},{"value":47,"datetime":"2019-04-01 21:00"},{"value":47,"datetime":"2019-04-01 22:00"},{"value":47,"datetime":"2019-04-01 23:00"},{"value":46,"datetime":"2019-04-02 00:00"},{"value":44,"datetime":"2019-04-02 01:00"},{"value":46,"datetime":"2019-04-02 02:00"},{"value":50,"datetime":"2019-04-02 03:00"},{"value":55,"datetime":"2019-04-02 04:00"},{"value":59,"datetime":"2019-04-02 05:00"},{"value":60,"datetime":"2019-04-02 06:00"},{"value":59,"datetime":"2019-04-02 07:00"},{"value":55,"datetime":"2019-04-02 08:00"},{"value":50,"datetime":"2019-04-02 09:00"},{"value":43,"datetime":"2019-04-02 10:00"},{"value":37,"datetime":"2019-04-02 11:00"},{"value":31,"datetime":"2019-04-02 12:00"},{"value":27,"datetime":"2019-04-02 13:00"},{"value":24,"datetime":"2019-04-02 14:00"}]
                 * dswrf : [{"value":740,"datetime":"2019-03-31 15:00"},{"value":650,"datetime":"2019-03-31 16:00"},{"value":550,"datetime":"2019-03-31 17:00"},{"value":450,"datetime":"2019-03-31 18:00"},{"value":360,"datetime":"2019-03-31 19:00"},{"value":298.77686,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":13,"datetime":"2019-04-01 07:00"},{"value":56.611572,"datetime":"2019-04-01 08:00"},{"value":490,"datetime":"2019-04-01 09:00"},{"value":586.1157,"datetime":"2019-04-01 10:00"},{"value":663.9161,"datetime":"2019-04-01 11:00"},{"value":722.22314,"datetime":"2019-04-01 12:00"},{"value":760.47186,"datetime":"2019-04-01 13:00"},{"value":776.3916,"datetime":"2019-04-01 14:00"},{"value":740,"datetime":"2019-04-01 15:00"},{"value":650,"datetime":"2019-04-01 16:00"},{"value":550,"datetime":"2019-04-01 17:00"},{"value":450,"datetime":"2019-04-01 18:00"},{"value":360,"datetime":"2019-04-01 19:00"},{"value":300.13654,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":11.97124,"datetime":"2019-04-02 07:00"},{"value":45.053425,"datetime":"2019-04-02 08:00"},{"value":384.38672,"datetime":"2019-04-02 09:00"},{"value":504.38672,"datetime":"2019-04-02 10:00"},{"value":586.90576,"datetime":"2019-04-02 11:00"},{"value":628.7348,"datetime":"2019-04-02 12:00"},{"value":660.68134,"datetime":"2019-04-02 13:00"},{"value":680.13495,"datetime":"2019-04-02 14:00"}]
                 * visibility : [{"value":16.47,"datetime":"2019-03-31 15:00"},{"value":16.47,"datetime":"2019-03-31 16:00"},{"value":16.47,"datetime":"2019-03-31 17:00"},{"value":16.47,"datetime":"2019-03-31 18:00"},{"value":16.47,"datetime":"2019-03-31 19:00"},{"value":16.47,"datetime":"2019-03-31 20:00"},{"value":16.47,"datetime":"2019-03-31 21:00"},{"value":16.47,"datetime":"2019-03-31 22:00"},{"value":16.47,"datetime":"2019-03-31 23:00"},{"value":14.97,"datetime":"2019-04-01 00:00"},{"value":13.72,"datetime":"2019-04-01 01:00"},{"value":13.72,"datetime":"2019-04-01 02:00"},{"value":14.97,"datetime":"2019-04-01 03:00"},{"value":16.47,"datetime":"2019-04-01 04:00"},{"value":16.47,"datetime":"2019-04-01 05:00"},{"value":16.47,"datetime":"2019-04-01 06:00"},{"value":16.47,"datetime":"2019-04-01 07:00"},{"value":13.72,"datetime":"2019-04-01 08:00"},{"value":11.76,"datetime":"2019-04-01 09:00"},{"value":10.98,"datetime":"2019-04-01 10:00"},{"value":12.67,"datetime":"2019-04-01 11:00"},{"value":16.47,"datetime":"2019-04-01 12:00"},{"value":16.47,"datetime":"2019-04-01 13:00"},{"value":16.47,"datetime":"2019-04-01 14:00"},{"value":16.47,"datetime":"2019-04-01 15:00"},{"value":16.47,"datetime":"2019-04-01 16:00"},{"value":16.47,"datetime":"2019-04-01 17:00"},{"value":16.47,"datetime":"2019-04-01 18:00"},{"value":16.47,"datetime":"2019-04-01 19:00"},{"value":16.47,"datetime":"2019-04-01 20:00"},{"value":16.47,"datetime":"2019-04-01 21:00"},{"value":16.47,"datetime":"2019-04-01 22:00"},{"value":16.47,"datetime":"2019-04-01 23:00"},{"value":16.47,"datetime":"2019-04-02 00:00"},{"value":16.47,"datetime":"2019-04-02 01:00"},{"value":16.47,"datetime":"2019-04-02 02:00"},{"value":16.47,"datetime":"2019-04-02 03:00"},{"value":16.47,"datetime":"2019-04-02 04:00"},{"value":13.72,"datetime":"2019-04-02 05:00"},{"value":12.67,"datetime":"2019-04-02 06:00"},{"value":13.72,"datetime":"2019-04-02 07:00"},{"value":16.47,"datetime":"2019-04-02 08:00"},{"value":16.47,"datetime":"2019-04-02 09:00"},{"value":16.47,"datetime":"2019-04-02 10:00"},{"value":16.47,"datetime":"2019-04-02 11:00"},{"value":16.47,"datetime":"2019-04-02 12:00"},{"value":16.47,"datetime":"2019-04-02 13:00"},{"value":16.47,"datetime":"2019-04-02 14:00"}]
                 * humidity : [{"value":0.14,"datetime":"2019-03-31 15:00"},{"value":0.21,"datetime":"2019-03-31 16:00"},{"value":0.24,"datetime":"2019-03-31 17:00"},{"value":0.32,"datetime":"2019-03-31 18:00"},{"value":0.31,"datetime":"2019-03-31 19:00"},{"value":0.32,"datetime":"2019-03-31 20:00"},{"value":0.33,"datetime":"2019-03-31 21:00"},{"value":0.34,"datetime":"2019-03-31 22:00"},{"value":0.34,"datetime":"2019-03-31 23:00"},{"value":0.36,"datetime":"2019-04-01 00:00"},{"value":0.4,"datetime":"2019-04-01 01:00"},{"value":0.43,"datetime":"2019-04-01 02:00"},{"value":0.45,"datetime":"2019-04-01 03:00"},{"value":0.47,"datetime":"2019-04-01 04:00"},{"value":0.48,"datetime":"2019-04-01 05:00"},{"value":0.49,"datetime":"2019-04-01 06:00"},{"value":0.51,"datetime":"2019-04-01 07:00"},{"value":0.44,"datetime":"2019-04-01 08:00"},{"value":0.39,"datetime":"2019-04-01 09:00"},{"value":0.34,"datetime":"2019-04-01 10:00"},{"value":0.31,"datetime":"2019-04-01 11:00"},{"value":0.27,"datetime":"2019-04-01 12:00"},{"value":0.24,"datetime":"2019-04-01 13:00"},{"value":0.22,"datetime":"2019-04-01 14:00"},{"value":0.21,"datetime":"2019-04-01 15:00"},{"value":0.21,"datetime":"2019-04-01 16:00"},{"value":0.25,"datetime":"2019-04-01 17:00"},{"value":0.31,"datetime":"2019-04-01 18:00"},{"value":0.31,"datetime":"2019-04-01 19:00"},{"value":0.3,"datetime":"2019-04-01 20:00"},{"value":0.3,"datetime":"2019-04-01 21:00"},{"value":0.29,"datetime":"2019-04-01 22:00"},{"value":0.28,"datetime":"2019-04-01 23:00"},{"value":0.3,"datetime":"2019-04-02 00:00"},{"value":0.38,"datetime":"2019-04-02 01:00"},{"value":0.48,"datetime":"2019-04-02 02:00"},{"value":0.53,"datetime":"2019-04-02 03:00"},{"value":0.56,"datetime":"2019-04-02 04:00"},{"value":0.58,"datetime":"2019-04-02 05:00"},{"value":0.59,"datetime":"2019-04-02 06:00"},{"value":0.58,"datetime":"2019-04-02 07:00"},{"value":0.45,"datetime":"2019-04-02 08:00"},{"value":0.37,"datetime":"2019-04-02 09:00"},{"value":0.31,"datetime":"2019-04-02 10:00"},{"value":0.28,"datetime":"2019-04-02 11:00"},{"value":0.27,"datetime":"2019-04-02 12:00"},{"value":0.26,"datetime":"2019-04-02 13:00"},{"value":0.26,"datetime":"2019-04-02 14:00"}]
                 * pres : [{"value":101444.95,"datetime":"2019-03-31 15:00"},{"value":101402.45,"datetime":"2019-03-31 16:00"},{"value":101364.95,"datetime":"2019-03-31 17:00"},{"value":101382.555,"datetime":"2019-03-31 18:00"},{"value":101402.45,"datetime":"2019-03-31 19:00"},{"value":101482.45,"datetime":"2019-03-31 20:00"},{"value":101513.78,"datetime":"2019-03-31 21:00"},{"value":101513.78,"datetime":"2019-03-31 22:00"},{"value":101513.78,"datetime":"2019-03-31 23:00"},{"value":101482.45,"datetime":"2019-04-01 00:00"},{"value":101464.85,"datetime":"2019-04-01 01:00"},{"value":101433.78,"datetime":"2019-04-01 02:00"},{"value":101402.45,"datetime":"2019-04-01 03:00"},{"value":101353.78,"datetime":"2019-04-01 04:00"},{"value":101384.85,"datetime":"2019-04-01 05:00"},{"value":101384.85,"datetime":"2019-04-01 06:00"},{"value":101402.45,"datetime":"2019-04-01 07:00"},{"value":101402.45,"datetime":"2019-04-01 08:00"},{"value":101433.78,"datetime":"2019-04-01 09:00"},{"value":101433.78,"datetime":"2019-04-01 10:00"},{"value":101384.85,"datetime":"2019-04-01 11:00"},{"value":101364.95,"datetime":"2019-04-01 12:00"},{"value":101322.45,"datetime":"2019-04-01 13:00"},{"value":101242.45,"datetime":"2019-04-01 14:00"},{"value":101204.95,"datetime":"2019-04-01 15:00"},{"value":101173.625,"datetime":"2019-04-01 16:00"},{"value":101204.95,"datetime":"2019-04-01 17:00"},{"value":101222.555,"datetime":"2019-04-01 18:00"},{"value":101302.555,"datetime":"2019-04-01 19:00"},{"value":101382.555,"datetime":"2019-04-01 20:00"},{"value":101493.625,"datetime":"2019-04-01 21:00"},{"value":101562.45,"datetime":"2019-04-01 22:00"},{"value":101562.45,"datetime":"2019-04-01 23:00"},{"value":101562.45,"datetime":"2019-04-02 00:00"},{"value":101542.555,"datetime":"2019-04-02 01:00"},{"value":101482.45,"datetime":"2019-04-02 02:00"},{"value":101462.555,"datetime":"2019-04-02 03:00"},{"value":101444.95,"datetime":"2019-04-02 04:00"},{"value":101462.555,"datetime":"2019-04-02 05:00"},{"value":101482.45,"datetime":"2019-04-02 06:00"},{"value":101482.45,"datetime":"2019-04-02 07:00"},{"value":101524.95,"datetime":"2019-04-02 08:00"},{"value":101562.45,"datetime":"2019-04-02 09:00"},{"value":101562.45,"datetime":"2019-04-02 10:00"},{"value":101562.45,"datetime":"2019-04-02 11:00"},{"value":101524.95,"datetime":"2019-04-02 12:00"},{"value":101482.45,"datetime":"2019-04-02 13:00"},{"value":101402.45,"datetime":"2019-04-02 14:00"}]
                 * pm25 : [{"value":25,"datetime":"2019-03-31 15:00"},{"value":30,"datetime":"2019-03-31 16:00"},{"value":33,"datetime":"2019-03-31 17:00"},{"value":36,"datetime":"2019-03-31 18:00"},{"value":38,"datetime":"2019-03-31 19:00"},{"value":39,"datetime":"2019-03-31 20:00"},{"value":39,"datetime":"2019-03-31 21:00"},{"value":39,"datetime":"2019-03-31 22:00"},{"value":40,"datetime":"2019-03-31 23:00"},{"value":41,"datetime":"2019-04-01 00:00"},{"value":42,"datetime":"2019-04-01 01:00"},{"value":42,"datetime":"2019-04-01 02:00"},{"value":41,"datetime":"2019-04-01 03:00"},{"value":40,"datetime":"2019-04-01 04:00"},{"value":39,"datetime":"2019-04-01 05:00"},{"value":39,"datetime":"2019-04-01 06:00"},{"value":40,"datetime":"2019-04-01 07:00"},{"value":42,"datetime":"2019-04-01 08:00"},{"value":44,"datetime":"2019-04-01 09:00"},{"value":45,"datetime":"2019-04-01 10:00"},{"value":43,"datetime":"2019-04-01 11:00"},{"value":39,"datetime":"2019-04-01 12:00"},{"value":34,"datetime":"2019-04-01 13:00"},{"value":30,"datetime":"2019-04-01 14:00"},{"value":30,"datetime":"2019-04-01 15:00"},{"value":32,"datetime":"2019-04-01 16:00"},{"value":33,"datetime":"2019-04-01 17:00"},{"value":34,"datetime":"2019-04-01 18:00"},{"value":33,"datetime":"2019-04-01 19:00"},{"value":32,"datetime":"2019-04-01 20:00"},{"value":33,"datetime":"2019-04-01 21:00"},{"value":33,"datetime":"2019-04-01 22:00"},{"value":33,"datetime":"2019-04-01 23:00"},{"value":32,"datetime":"2019-04-02 00:00"},{"value":31,"datetime":"2019-04-02 01:00"},{"value":32,"datetime":"2019-04-02 02:00"},{"value":35,"datetime":"2019-04-02 03:00"},{"value":39,"datetime":"2019-04-02 04:00"},{"value":42,"datetime":"2019-04-02 05:00"},{"value":43,"datetime":"2019-04-02 06:00"},{"value":42,"datetime":"2019-04-02 07:00"},{"value":39,"datetime":"2019-04-02 08:00"},{"value":35,"datetime":"2019-04-02 09:00"},{"value":30,"datetime":"2019-04-02 10:00"},{"value":26,"datetime":"2019-04-02 11:00"},{"value":22,"datetime":"2019-04-02 12:00"},{"value":19,"datetime":"2019-04-02 13:00"},{"value":17,"datetime":"2019-04-02 14:00"}]
                 * precipitation : [{"value":0,"datetime":"2019-03-31 15:00"},{"value":0,"datetime":"2019-03-31 16:00"},{"value":0,"datetime":"2019-03-31 17:00"},{"value":0,"datetime":"2019-03-31 18:00"},{"value":0,"datetime":"2019-03-31 19:00"},{"value":0,"datetime":"2019-03-31 20:00"},{"value":0,"datetime":"2019-03-31 21:00"},{"value":0,"datetime":"2019-03-31 22:00"},{"value":0,"datetime":"2019-03-31 23:00"},{"value":0,"datetime":"2019-04-01 00:00"},{"value":0,"datetime":"2019-04-01 01:00"},{"value":0,"datetime":"2019-04-01 02:00"},{"value":0,"datetime":"2019-04-01 03:00"},{"value":0,"datetime":"2019-04-01 04:00"},{"value":0,"datetime":"2019-04-01 05:00"},{"value":0,"datetime":"2019-04-01 06:00"},{"value":0,"datetime":"2019-04-01 07:00"},{"value":0,"datetime":"2019-04-01 08:00"},{"value":0,"datetime":"2019-04-01 09:00"},{"value":0,"datetime":"2019-04-01 10:00"},{"value":0,"datetime":"2019-04-01 11:00"},{"value":0,"datetime":"2019-04-01 12:00"},{"value":0,"datetime":"2019-04-01 13:00"},{"value":0,"datetime":"2019-04-01 14:00"},{"value":0,"datetime":"2019-04-01 15:00"},{"value":0,"datetime":"2019-04-01 16:00"},{"value":0,"datetime":"2019-04-01 17:00"},{"value":0,"datetime":"2019-04-01 18:00"},{"value":0,"datetime":"2019-04-01 19:00"},{"value":0,"datetime":"2019-04-01 20:00"},{"value":0,"datetime":"2019-04-01 21:00"},{"value":0,"datetime":"2019-04-01 22:00"},{"value":0,"datetime":"2019-04-01 23:00"},{"value":0,"datetime":"2019-04-02 00:00"},{"value":0,"datetime":"2019-04-02 01:00"},{"value":0,"datetime":"2019-04-02 02:00"},{"value":0,"datetime":"2019-04-02 03:00"},{"value":0,"datetime":"2019-04-02 04:00"},{"value":0,"datetime":"2019-04-02 05:00"},{"value":0,"datetime":"2019-04-02 06:00"},{"value":0,"datetime":"2019-04-02 07:00"},{"value":0,"datetime":"2019-04-02 08:00"},{"value":0,"datetime":"2019-04-02 09:00"},{"value":0,"datetime":"2019-04-02 10:00"},{"value":0,"datetime":"2019-04-02 11:00"},{"value":0,"datetime":"2019-04-02 12:00"},{"value":0,"datetime":"2019-04-02 13:00"},{"value":0,"datetime":"2019-04-02 14:00"}]
                 * wind : [{"direction":269,"speed":30.96,"datetime":"2019-03-31 15:00"},{"direction":288.88,"speed":15.32,"datetime":"2019-03-31 16:00"},{"direction":289.11,"speed":12.43,"datetime":"2019-03-31 17:00"},{"direction":289.6,"speed":5.78,"datetime":"2019-03-31 18:00"},{"direction":284.68,"speed":3.59,"datetime":"2019-03-31 19:00"},{"direction":278.21,"speed":2.89,"datetime":"2019-03-31 20:00"},{"direction":275.5,"speed":3.26,"datetime":"2019-03-31 21:00"},{"direction":257.79,"speed":3.07,"datetime":"2019-03-31 22:00"},{"direction":199.01,"speed":4.63,"datetime":"2019-03-31 23:00"},{"direction":189.3,"speed":7.84,"datetime":"2019-04-01 00:00"},{"direction":191.43,"speed":9.33,"datetime":"2019-04-01 01:00"},{"direction":198.27,"speed":9.94,"datetime":"2019-04-01 02:00"},{"direction":200.78,"speed":10.56,"datetime":"2019-04-01 03:00"},{"direction":205.63,"speed":11.21,"datetime":"2019-04-01 04:00"},{"direction":217.29,"speed":11.74,"datetime":"2019-04-01 05:00"},{"direction":223.35,"speed":11.65,"datetime":"2019-04-01 06:00"},{"direction":223.39,"speed":11.64,"datetime":"2019-04-01 07:00"},{"direction":235.91,"speed":17.03,"datetime":"2019-04-01 08:00"},{"direction":252.87,"speed":20.7,"datetime":"2019-04-01 09:00"},{"direction":265.17,"speed":23.25,"datetime":"2019-04-01 10:00"},{"direction":275.81,"speed":24.27,"datetime":"2019-04-01 11:00"},{"direction":290.14,"speed":23.1,"datetime":"2019-04-01 12:00"},{"direction":307.13,"speed":21.27,"datetime":"2019-04-01 13:00"},{"direction":320.15,"speed":19.46,"datetime":"2019-04-01 14:00"},{"direction":332.21,"speed":17.57,"datetime":"2019-04-01 15:00"},{"direction":346.73,"speed":15.84,"datetime":"2019-04-01 16:00"},{"direction":11.63,"speed":13.11,"datetime":"2019-04-01 17:00"},{"direction":38.23,"speed":13.18,"datetime":"2019-04-01 18:00"},{"direction":51.21,"speed":17.41,"datetime":"2019-04-01 19:00"},{"direction":53.94,"speed":18.9,"datetime":"2019-04-01 20:00"},{"direction":55.06,"speed":16.1,"datetime":"2019-04-01 21:00"},{"direction":58.05,"speed":13.72,"datetime":"2019-04-01 22:00"},{"direction":65.94,"speed":12.2,"datetime":"2019-04-01 23:00"},{"direction":76.37,"speed":11.73,"datetime":"2019-04-02 00:00"},{"direction":87.82,"speed":11.55,"datetime":"2019-04-02 01:00"},{"direction":99.09,"speed":11.32,"datetime":"2019-04-02 02:00"},{"direction":101.53,"speed":10.66,"datetime":"2019-04-02 03:00"},{"direction":101.44,"speed":9.83,"datetime":"2019-04-02 04:00"},{"direction":104.8,"speed":9,"datetime":"2019-04-02 05:00"},{"direction":103.18,"speed":8.74,"datetime":"2019-04-02 06:00"},{"direction":97.6,"speed":9.23,"datetime":"2019-04-02 07:00"},{"direction":110.48,"speed":13.98,"datetime":"2019-04-02 08:00"},{"direction":117.11,"speed":14.92,"datetime":"2019-04-02 09:00"},{"direction":119.88,"speed":15.93,"datetime":"2019-04-02 10:00"},{"direction":119.47,"speed":16.72,"datetime":"2019-04-02 11:00"},{"direction":118.93,"speed":16.8,"datetime":"2019-04-02 12:00"},{"direction":122.32,"speed":16.92,"datetime":"2019-04-02 13:00"},{"direction":119.26,"speed":16.16,"datetime":"2019-04-02 14:00"}]
                 * temperature : [{"value":15,"datetime":"2019-03-31 15:00"},{"value":14.17,"datetime":"2019-03-31 16:00"},{"value":13.33,"datetime":"2019-03-31 17:00"},{"value":12.5,"datetime":"2019-03-31 18:00"},{"value":10.67,"datetime":"2019-03-31 19:00"},{"value":10.83,"datetime":"2019-03-31 20:00"},{"value":10,"datetime":"2019-03-31 21:00"},{"value":9,"datetime":"2019-03-31 22:00"},{"value":9,"datetime":"2019-03-31 23:00"},{"value":7.33,"datetime":"2019-04-01 00:00"},{"value":7.67,"datetime":"2019-04-01 01:00"},{"value":7,"datetime":"2019-04-01 02:00"},{"value":6.33,"datetime":"2019-04-01 03:00"},{"value":6.67,"datetime":"2019-04-01 04:00"},{"value":6,"datetime":"2019-04-01 05:00"},{"value":6.67,"datetime":"2019-04-01 06:00"},{"value":8.33,"datetime":"2019-04-01 07:00"},{"value":9.17,"datetime":"2019-04-01 08:00"},{"value":12,"datetime":"2019-04-01 09:00"},{"value":14.83,"datetime":"2019-04-01 10:00"},{"value":17.67,"datetime":"2019-04-01 11:00"},{"value":18.83,"datetime":"2019-04-01 12:00"},{"value":20,"datetime":"2019-04-01 13:00"},{"value":19.65,"datetime":"2019-04-01 14:00"},{"value":19.3,"datetime":"2019-04-01 15:00"},{"value":18.67,"datetime":"2019-04-01 16:00"},{"value":17.35,"datetime":"2019-04-01 17:00"},{"value":14.08,"datetime":"2019-04-01 18:00"},{"value":11.42,"datetime":"2019-04-01 19:00"},{"value":9.92,"datetime":"2019-04-01 20:00"},{"value":8.47,"datetime":"2019-04-01 21:00"},{"value":7.41,"datetime":"2019-04-01 22:00"},{"value":6.76,"datetime":"2019-04-01 23:00"},{"value":6.38,"datetime":"2019-04-02 00:00"},{"value":6.18,"datetime":"2019-04-02 01:00"},{"value":6.31,"datetime":"2019-04-02 02:00"},{"value":6.26,"datetime":"2019-04-02 03:00"},{"value":6.04,"datetime":"2019-04-02 04:00"},{"value":5.99,"datetime":"2019-04-02 05:00"},{"value":6,"datetime":"2019-04-02 06:00"},{"value":6.89,"datetime":"2019-04-02 07:00"},{"value":9.15,"datetime":"2019-04-02 08:00"},{"value":11.12,"datetime":"2019-04-02 09:00"},{"value":13.53,"datetime":"2019-04-02 10:00"},{"value":15.12,"datetime":"2019-04-02 11:00"},{"value":16.06,"datetime":"2019-04-02 12:00"},{"value":17.24,"datetime":"2019-04-02 13:00"},{"value":18,"datetime":"2019-04-02 14:00"}]
                 */

                private String status;
                private String description;
                private List<SkyconBean> skycon;
                private List<CloudrateBean> cloudrate;
                private List<AqiBean> aqi;
                private List<DswrfBean> dswrf;
                private List<VisibilityBean> visibility;
                private List<HumidityBean> humidity;
                private List<PresBean> pres;
                private List<Pm25Bean> pm25;
                private List<PrecipitationBean> precipitation;
                private List<WindBean> wind;
                private List<TemperatureBean> temperature;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public List<SkyconBean> getSkycon() {
                    return skycon;
                }

                public void setSkycon(List<SkyconBean> skycon) {
                    this.skycon = skycon;
                }

                public List<CloudrateBean> getCloudrate() {
                    return cloudrate;
                }

                public void setCloudrate(List<CloudrateBean> cloudrate) {
                    this.cloudrate = cloudrate;
                }

                public List<AqiBean> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBean> aqi) {
                    this.aqi = aqi;
                }

                public List<DswrfBean> getDswrf() {
                    return dswrf;
                }

                public void setDswrf(List<DswrfBean> dswrf) {
                    this.dswrf = dswrf;
                }

                public List<VisibilityBean> getVisibility() {
                    return visibility;
                }

                public void setVisibility(List<VisibilityBean> visibility) {
                    this.visibility = visibility;
                }

                public List<HumidityBean> getHumidity() {
                    return humidity;
                }

                public void setHumidity(List<HumidityBean> humidity) {
                    this.humidity = humidity;
                }

                public List<PresBean> getPres() {
                    return pres;
                }

                public void setPres(List<PresBean> pres) {
                    this.pres = pres;
                }

                public List<Pm25Bean> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25Bean> pm25) {
                    this.pm25 = pm25;
                }

                public List<PrecipitationBean> getPrecipitation() {
                    return precipitation;
                }

                public void setPrecipitation(List<PrecipitationBean> precipitation) {
                    this.precipitation = precipitation;
                }

                public List<WindBean> getWind() {
                    return wind;
                }

                public void setWind(List<WindBean> wind) {
                    this.wind = wind;
                }

                public List<TemperatureBean> getTemperature() {
                    return temperature;
                }

                public void setTemperature(List<TemperatureBean> temperature) {
                    this.temperature = temperature;
                }

                public static class SkyconBean {
                    /**
                     * value : CLEAR_DAY
                     * datetime : 2019-03-31 15:00
                     */

                    private String value;
                    private String datetime;

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class CloudrateBean {
                    /**
                     * value : 0
                     * datetime : 2019-03-31 15:00
                     */

                    private double value;
                    private String datetime;

                    public double getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class AqiBean {
                    /**
                     * value : 61
                     * datetime : 2019-03-31 15:00
                     */

                    private int value;
                    private String datetime;

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class DswrfBean {
                    /**
                     * value : 740
                     * datetime : 2019-03-31 15:00
                     */

                    private double value;
                    private String datetime;

                    public double getValue() {
                        return value;
                    }

                    public void setValue(double value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class VisibilityBean {
                    /**
                     * value : 16.47
                     * datetime : 2019-03-31 15:00
                     */

                    private double value;
                    private String datetime;

                    public double getValue() {
                        return value;
                    }

                    public void setValue(double value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class HumidityBean {
                    /**
                     * value : 0.14
                     * datetime : 2019-03-31 15:00
                     */

                    private double value;
                    private String datetime;

                    public double getValue() {
                        return value;
                    }

                    public void setValue(double value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class PresBean {
                    /**
                     * value : 101444.95
                     * datetime : 2019-03-31 15:00
                     */

                    private double value;
                    private String datetime;

                    public double getValue() {
                        return value;
                    }

                    public void setValue(double value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class Pm25Bean {
                    /**
                     * value : 25
                     * datetime : 2019-03-31 15:00
                     */

                    private int value;
                    private String datetime;

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class PrecipitationBean {
                    /**
                     * value : 0
                     * datetime : 2019-03-31 15:00
                     */

                    private double value;
                    private String datetime;

                    public double getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class WindBean {
                    /**
                     * direction : 269
                     * speed : 30.96
                     * datetime : 2019-03-31 15:00
                     */

                    private double direction;
                    private double speed;
                    private String datetime;

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

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class TemperatureBean {
                    /**
                     * value : 15
                     * datetime : 2019-03-31 15:00
                     */

                    private double value;
                    private String datetime;

                    public double getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }
            }

            public static class DailyBean {
                /**
                 * status : ok
                 * comfort : [{"index":"7","desc":"冷","datetime":"2019-03-31"},{"index":"6","desc":"凉爽","datetime":"2019-04-01"},{"index":"7","desc":"冷","datetime":"2019-04-02"},{"index":"6","desc":"凉爽","datetime":"2019-04-03"},{"index":"5","desc":"舒适","datetime":"2019-04-04"}]
                 * skycon_20h_32h : [{"date":"2019-03-31","value":"CLEAR_NIGHT"},{"date":"2019-04-01","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-02","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-04-03","value":"CLOUDY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_NIGHT"}]
                 * temperature : [{"date":"2019-03-31","max":15.33,"avg":11.61,"min":2},{"date":"2019-04-01","max":20,"avg":11.73,"min":6},{"date":"2019-04-02","max":18,"avg":10.36,"min":5.99},{"date":"2019-04-03","max":19,"avg":12.33,"min":5.88},{"date":"2019-04-04","max":23,"avg":14.85,"min":8.95}]
                 * dswrf : [{"date":"2019-03-31","max":785.3,"avg":338.8,"min":0},{"date":"2019-04-01","max":776.4,"avg":296.6,"min":0},{"date":"2019-04-02","max":680.1,"avg":239.5,"min":0},{"date":"2019-04-03","max":786.4,"avg":292.7,"min":0},{"date":"2019-04-04","max":781.2,"avg":297.7,"min":0}]
                 * cloudrate : [{"date":"2019-03-31","max":1,"avg":0,"min":0},{"date":"2019-04-01","max":0.04,"avg":0,"min":0},{"date":"2019-04-02","max":1,"avg":0.9,"min":0.17},{"date":"2019-04-03","max":1,"avg":0.56,"min":0},{"date":"2019-04-04","max":1,"avg":0.48,"min":0}]
                 * aqi : [{"date":"2019-03-31","max":107,"avg":53,"min":43},{"date":"2019-04-01","max":62,"avg":52.58,"min":43},{"date":"2019-04-02","max":60,"avg":38.04,"min":21},{"date":"2019-04-03","max":65,"avg":50.42,"min":37},{"date":"2019-04-04","max":82,"avg":66.17,"min":50}]
                 * skycon : [{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"PARTLY_CLOUDY_DAY"}]
                 * visibility : [{"date":"2019-03-31","max":24.1,"avg":16.47,"min":16.47},{"date":"2019-04-01","max":16.47,"avg":15.42,"min":10.98},{"date":"2019-04-02","max":16.47,"avg":16.08,"min":12.67},{"date":"2019-04-03","max":16.47,"avg":14.94,"min":9.69},{"date":"2019-04-04","max":16.47,"avg":10.04,"min":4.39}]
                 * humidity : [{"date":"2019-03-31","max":0.35,"avg":0.28,"min":0.14},{"date":"2019-04-01","max":0.51,"avg":0.34,"min":0.21},{"date":"2019-04-02","max":0.59,"avg":0.43,"min":0.26},{"date":"2019-04-03","max":0.76,"avg":0.5,"min":0.27},{"date":"2019-04-04","max":0.74,"avg":0.52,"min":0.32}]
                 * astro : [{"date":"2019-03-31","sunset":{"time":"18:26"},"sunrise":{"time":"05:55"}},{"date":"2019-04-01","sunset":{"time":"18:27"},"sunrise":{"time":"05:53"}},{"date":"2019-04-02","sunset":{"time":"18:27"},"sunrise":{"time":"05:52"}},{"date":"2019-04-03","sunset":{"time":"18:28"},"sunrise":{"time":"05:51"}},{"date":"2019-04-04","sunset":{"time":"18:29"},"sunrise":{"time":"05:49"}}]
                 * coldRisk : [{"index":"4","desc":"极易发","datetime":"2019-03-31"},{"index":"4","desc":"极易发","datetime":"2019-04-01"},{"index":"4","desc":"极易发","datetime":"2019-04-02"},{"index":"4","desc":"极易发","datetime":"2019-04-03"},{"index":"4","desc":"极易发","datetime":"2019-04-04"}]
                 * ultraviolet : [{"index":"4","desc":"强","datetime":"2019-03-31"},{"index":"4","desc":"强","datetime":"2019-04-01"},{"index":"1","desc":"最弱","datetime":"2019-04-02"},{"index":"4","desc":"强","datetime":"2019-04-03"},{"index":"4","desc":"强","datetime":"2019-04-04"}]
                 * pres : [{"date":"2019-03-31","max":101802.45,"avg":101446.8,"min":101364.96},{"date":"2019-04-01","max":101562.45,"avg":101375.16,"min":101173.63},{"date":"2019-04-02","max":101782.55,"avg":101527.8,"min":101382.55},{"date":"2019-04-03","max":102004.96,"avg":101709.44,"min":101433.78},{"date":"2019-04-04","max":101433.78,"avg":100865.45,"min":100393.78}]
                 * pm25 : [{"date":"2019-03-31","max":54,"avg":35.44,"min":16},{"date":"2019-04-01","max":45,"avg":37.25,"min":30},{"date":"2019-04-02","max":43,"avg":26.79,"min":15},{"date":"2019-04-03","max":47,"avg":35.71,"min":26},{"date":"2019-04-04","max":61,"avg":48,"min":35}]
                 * dressing : [{"index":"5","desc":"凉爽","datetime":"2019-03-31"},{"index":"6","desc":"冷","datetime":"2019-04-01"},{"index":"5","desc":"凉爽","datetime":"2019-04-02"},{"index":"5","desc":"凉爽","datetime":"2019-04-03"},{"index":"6","desc":"冷","datetime":"2019-04-04"}]
                 * carWashing : [{"index":"1","desc":"适宜","datetime":"2019-03-31"},{"index":"1","desc":"适宜","datetime":"2019-04-01"},{"index":"1","desc":"适宜","datetime":"2019-04-02"},{"index":"1","desc":"适宜","datetime":"2019-04-03"},{"index":"1","desc":"适宜","datetime":"2019-04-04"}]
                 * precipitation : [{"date":"2019-03-31","max":0,"avg":0,"min":0},{"date":"2019-04-01","max":0,"avg":0,"min":0},{"date":"2019-04-02","max":0,"avg":0,"min":0},{"date":"2019-04-03","max":0,"avg":0,"min":0},{"date":"2019-04-04","max":0,"avg":0,"min":0}]
                 * wind : [{"date":"2019-03-31","max":{"direction":269,"speed":30.96},"avg":{"direction":272.64,"speed":7.3},"min":{"direction":266.59,"speed":0.84}},{"date":"2019-04-01","max":{"direction":275.81,"speed":24.27},"avg":{"direction":293.22,"speed":15.46},"min":{"direction":189.3,"speed":7.84}},{"date":"2019-04-02","max":{"direction":122.32,"speed":16.92},"avg":{"direction":107.32,"speed":13},"min":{"direction":120.66,"speed":8.19}},{"date":"2019-04-03","max":{"direction":159.67,"speed":10.14},"avg":{"direction":143.21,"speed":8.22},"min":{"direction":79.64,"speed":6.27}},{"date":"2019-04-04","max":{"direction":221.7,"speed":22.01},"avg":{"direction":213.64,"speed":15.47},"min":{"direction":205.01,"speed":10.24}}]
                 * skycon_08h_20h : [{"date":"2019-03-31","value":"CLEAR_DAY"},{"date":"2019-04-01","value":"CLEAR_DAY"},{"date":"2019-04-02","value":"CLOUDY"},{"date":"2019-04-03","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-04-04","value":"CLEAR_DAY"}]
                 */

                private String status;
                private List<ComfortBean> comfort;
                private List<Skycon20h32hBean> skycon_20h_32h;
                private List<TemperatureBeanX> temperature;
                private List<DswrfBeanX> dswrf;
                private List<CloudrateBeanX> cloudrate;
                private List<AqiBeanX> aqi;
                private List<SkyconBeanX> skycon;
                private List<VisibilityBeanX> visibility;
                private List<HumidityBeanX> humidity;
                private List<AstroBean> astro;
                private List<ColdRiskBean> coldRisk;
                private List<UltravioletBean> ultraviolet;
                private List<PresBeanX> pres;
                private List<Pm25BeanX> pm25;
                private List<DressingBean> dressing;
                private List<CarWashingBean> carWashing;
                private List<PrecipitationBeanX> precipitation;
                private List<WindBeanX> wind;
                private List<Skycon08h20hBean> skycon_08h_20h;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public List<ComfortBean> getComfort() {
                    return comfort;
                }

                public void setComfort(List<ComfortBean> comfort) {
                    this.comfort = comfort;
                }

                public List<Skycon20h32hBean> getSkycon_20h_32h() {
                    return skycon_20h_32h;
                }

                public void setSkycon_20h_32h(List<Skycon20h32hBean> skycon_20h_32h) {
                    this.skycon_20h_32h = skycon_20h_32h;
                }

                public List<TemperatureBeanX> getTemperature() {
                    return temperature;
                }

                public void setTemperature(List<TemperatureBeanX> temperature) {
                    this.temperature = temperature;
                }

                public List<DswrfBeanX> getDswrf() {
                    return dswrf;
                }

                public void setDswrf(List<DswrfBeanX> dswrf) {
                    this.dswrf = dswrf;
                }

                public List<CloudrateBeanX> getCloudrate() {
                    return cloudrate;
                }

                public void setCloudrate(List<CloudrateBeanX> cloudrate) {
                    this.cloudrate = cloudrate;
                }

                public List<AqiBeanX> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBeanX> aqi) {
                    this.aqi = aqi;
                }

                public List<SkyconBeanX> getSkycon() {
                    return skycon;
                }

                public void setSkycon(List<SkyconBeanX> skycon) {
                    this.skycon = skycon;
                }

                public List<VisibilityBeanX> getVisibility() {
                    return visibility;
                }

                public void setVisibility(List<VisibilityBeanX> visibility) {
                    this.visibility = visibility;
                }

                public List<HumidityBeanX> getHumidity() {
                    return humidity;
                }

                public void setHumidity(List<HumidityBeanX> humidity) {
                    this.humidity = humidity;
                }

                public List<AstroBean> getAstro() {
                    return astro;
                }

                public void setAstro(List<AstroBean> astro) {
                    this.astro = astro;
                }

                public List<ColdRiskBean> getColdRisk() {
                    return coldRisk;
                }

                public void setColdRisk(List<ColdRiskBean> coldRisk) {
                    this.coldRisk = coldRisk;
                }

                public List<UltravioletBean> getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(List<UltravioletBean> ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public List<PresBeanX> getPres() {
                    return pres;
                }

                public void setPres(List<PresBeanX> pres) {
                    this.pres = pres;
                }

                public List<Pm25BeanX> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25BeanX> pm25) {
                    this.pm25 = pm25;
                }

                public List<DressingBean> getDressing() {
                    return dressing;
                }

                public void setDressing(List<DressingBean> dressing) {
                    this.dressing = dressing;
                }

                public List<CarWashingBean> getCarWashing() {
                    return carWashing;
                }

                public void setCarWashing(List<CarWashingBean> carWashing) {
                    this.carWashing = carWashing;
                }

                public List<PrecipitationBeanX> getPrecipitation() {
                    return precipitation;
                }

                public void setPrecipitation(List<PrecipitationBeanX> precipitation) {
                    this.precipitation = precipitation;
                }

                public List<WindBeanX> getWind() {
                    return wind;
                }

                public void setWind(List<WindBeanX> wind) {
                    this.wind = wind;
                }

                public List<Skycon08h20hBean> getSkycon_08h_20h() {
                    return skycon_08h_20h;
                }

                public void setSkycon_08h_20h(List<Skycon08h20hBean> skycon_08h_20h) {
                    this.skycon_08h_20h = skycon_08h_20h;
                }

                public static class ComfortBean {
                    /**
                     * index : 7
                     * desc : 冷
                     * datetime : 2019-03-31
                     */

                    private String index;
                    private String desc;
                    private String datetime;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class Skycon20h32hBean {
                    /**
                     * date : 2019-03-31
                     * value : CLEAR_NIGHT
                     */

                    private String date;
                    private String value;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class TemperatureBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 15.33
                     * avg : 11.61
                     * min : 2
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private double min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(double max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public double getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }

                public static class DswrfBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 785.3
                     * avg : 338.8
                     * min : 0
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private int min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(double max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public int getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }

                public static class CloudrateBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 1
                     * avg : 0
                     * min : 0
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private double min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(int avg) {
                        this.avg = avg;
                    }

                    public double getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }

                public static class AqiBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 107
                     * avg : 53
                     * min : 43
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private double min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(int avg) {
                        this.avg = avg;
                    }

                    public double getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }

                public static class SkyconBeanX {
                    /**
                     * date : 2019-03-31
                     * value : CLEAR_DAY
                     */

                    private String date;
                    private String value;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class VisibilityBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 24.1
                     * avg : 16.47
                     * min : 16.47
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private double min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(double max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public double getMin() {
                        return min;
                    }

                    public void setMin(double min) {
                        this.min = min;
                    }
                }

                public static class HumidityBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 0.35
                     * avg : 0.28
                     * min : 0.14
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private double min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(double max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public double getMin() {
                        return min;
                    }

                    public void setMin(double min) {
                        this.min = min;
                    }
                }

                public static class AstroBean {
                    /**
                     * date : 2019-03-31
                     * sunset : {"time":"18:26"}
                     * sunrise : {"time":"05:55"}
                     */

                    private String date;
                    private SunsetBean sunset;
                    private SunriseBean sunrise;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public SunsetBean getSunset() {
                        return sunset;
                    }

                    public void setSunset(SunsetBean sunset) {
                        this.sunset = sunset;
                    }

                    public SunriseBean getSunrise() {
                        return sunrise;
                    }

                    public void setSunrise(SunriseBean sunrise) {
                        this.sunrise = sunrise;
                    }

                    public static class SunsetBean {
                        /**
                         * time : 18:26
                         */

                        private String time;

                        public String getTime() {
                            return time;
                        }

                        public void setTime(String time) {
                            this.time = time;
                        }
                    }

                    public static class SunriseBean {
                        /**
                         * time : 05:55
                         */

                        private String time;

                        public String getTime() {
                            return time;
                        }

                        public void setTime(String time) {
                            this.time = time;
                        }
                    }
                }

                public static class ColdRiskBean {
                    /**
                     * index : 4
                     * desc : 极易发
                     * datetime : 2019-03-31
                     */

                    private String index;
                    private String desc;
                    private String datetime;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class UltravioletBean {
                    /**
                     * index : 4
                     * desc : 强
                     * datetime : 2019-03-31
                     */

                    private String index;
                    private String desc;
                    private String datetime;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class PresBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 101802.45
                     * avg : 101446.8
                     * min : 101364.96
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private double min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(double max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public double getMin() {
                        return min;
                    }

                    public void setMin(double min) {
                        this.min = min;
                    }
                }

                public static class Pm25BeanX {
                    /**
                     * date : 2019-03-31
                     * max : 54
                     * avg : 35.44
                     * min : 16
                     */

                    private String date;
                    private int max;
                    private double avg;
                    private int min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public int getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(double avg) {
                        this.avg = avg;
                    }

                    public int getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }

                public static class DressingBean {
                    /**
                     * index : 5
                     * desc : 凉爽
                     * datetime : 2019-03-31
                     */

                    private String index;
                    private String desc;
                    private String datetime;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class CarWashingBean {
                    /**
                     * index : 1
                     * desc : 适宜
                     * datetime : 2019-03-31
                     */

                    private String index;
                    private String desc;
                    private String datetime;

                    public String getIndex() {
                        return index;
                    }

                    public void setIndex(String index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }
                }

                public static class PrecipitationBeanX {
                    /**
                     * date : 2019-03-31
                     * max : 0
                     * avg : 0
                     * min : 0
                     */

                    private String date;
                    private double max;
                    private double avg;
                    private double min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public double getMax() {
                        return max;
                    }

                    public void setMax(int max) {
                        this.max = max;
                    }

                    public double getAvg() {
                        return avg;
                    }

                    public void setAvg(int avg) {
                        this.avg = avg;
                    }

                    public double getMin() {
                        return min;
                    }

                    public void setMin(int min) {
                        this.min = min;
                    }
                }

                public static class WindBeanX {
                    /**
                     * date : 2019-03-31
                     * max : {"direction":269,"speed":30.96}
                     * avg : {"direction":272.64,"speed":7.3}
                     * min : {"direction":266.59,"speed":0.84}
                     */

                    private String date;
                    private MaxBean max;
                    private AvgBean avg;
                    private MinBean min;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public MaxBean getMax() {
                        return max;
                    }

                    public void setMax(MaxBean max) {
                        this.max = max;
                    }

                    public AvgBean getAvg() {
                        return avg;
                    }

                    public void setAvg(AvgBean avg) {
                        this.avg = avg;
                    }

                    public MinBean getMin() {
                        return min;
                    }

                    public void setMin(MinBean min) {
                        this.min = min;
                    }

                    public static class MaxBean {
                        /**
                         * direction : 269
                         * speed : 30.96
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

                    public static class AvgBean {
                        /**
                         * direction : 272.64
                         * speed : 7.3
                         */

                        private double direction;
                        private double speed;

                        public double getDirection() {
                            return direction;
                        }

                        public void setDirection(double direction) {
                            this.direction = direction;
                        }

                        public double getSpeed() {
                            return speed;
                        }

                        public void setSpeed(double speed) {
                            this.speed = speed;
                        }
                    }

                    public static class MinBean {
                        /**
                         * direction : 266.59
                         * speed : 0.84
                         */

                        private double direction;
                        private double speed;

                        public double getDirection() {
                            return direction;
                        }

                        public void setDirection(double direction) {
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

                public static class Skycon08h20hBean {
                    /**
                     * date : 2019-03-31
                     * value : CLEAR_DAY
                     */

                    private String date;
                    private String value;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }
            }

            public static class MinutelyBean {
                /**
                 * status : ok
                 * description : 未来两小时不会下雨，放心出门吧
                 * probability : [0,0,0,0]
                 * probability_4h : [0,0,0.051129088,0.063936174]
                 * datasource : radar
                 * precipitation_2h : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
                 * precipitation : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
                 */

                private String status;
                private String description;
                private String datasource;
                private List<Double> probability;
                private List<Double> probability_4h;
                private List<Double> precipitation_2h;
                private List<Double> precipitation;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getDatasource() {
                    return datasource;
                }

                public void setDatasource(String datasource) {
                    this.datasource = datasource;
                }

                public List<Double> getProbability() {
                    return probability;
                }

                public void setProbability(List<Double> probability) {
                    this.probability = probability;
                }

                public List<Double> getProbability_4h() {
                    return probability_4h;
                }

                public void setProbability_4h(List<Double> probability_4h) {
                    this.probability_4h = probability_4h;
                }

                public List<Double> getPrecipitation_2h() {
                    return precipitation_2h;
                }

                public void setPrecipitation_2h(List<Double> precipitation_2h) {
                    this.precipitation_2h = precipitation_2h;
                }

                public List<Double> getPrecipitation() {
                    return precipitation;
                }

                public void setPrecipitation(List<Double> precipitation) {
                    this.precipitation = precipitation;
                }
            }
        }
    }
}
