package com.juntai.look.homePage.weather;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.weather.WeatherEveryDayBean;
import com.juntai.look.hcb.R;

import java.util.List;

/**
 * Describe: 天气日常
 * Create by zhangzhenlong
 * 2020-6-27
 * email:954101549@qq.com
 */
public class WeatherEveryDayAdapter extends BaseQuickAdapter<WeatherEveryDayBean, BaseViewHolder> {

    public WeatherEveryDayAdapter(int layoutResId, @Nullable List<WeatherEveryDayBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherEveryDayBean item) {
        helper.setImageResource(R.id.camera_pic_iv,item.getImageInt());
        helper.setText(R.id.camera_name_tv,item.getContent());
    }
}
