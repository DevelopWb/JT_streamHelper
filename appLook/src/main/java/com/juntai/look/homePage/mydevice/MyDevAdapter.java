package com.juntai.look.homePage.mydevice;

import android.preference.PreferenceActivity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

/**
 * @Author: tobato
 * @Description: 作用描述  我的设备
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class MyDevAdapter extends BaseQuickAdapter<DevListBean.DataBean.ListBean, BaseViewHolder> {
    public MyDevAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DevListBean.DataBean.ListBean item) {
        ImageLoadUtil.loadImageCache(mContext, UrlFormatUtil.formatStreamCapturePicUrl(item.getEzopen()),
                helper.getView(R.id.dev_scan_iv));
        helper.setText(R.id.dev_name_tv,item.getName());
        if (0 == item.getIsShared()) {
            //别人分享我的  0是；1否
            helper.setImageResource(R.id.share_tag_iv,R.mipmap.share_icon);
        } else {
            helper.setImageResource(R.id.share_tag_iv,R.mipmap.my_dev_icon);

        }

        if (0 == item.getIsOnline()) {
            //离线
            helper.setGone(R.id.offline_cl, true);
            helper.setText(R.id.offline_time_tv,String.format("%s%s","时间:",item.getOfflineTime()));
        } else {
            helper.setGone(R.id.offline_cl, false);
        }

        if (1 == item.getDvrFlag()) {
            //nvr设备
            helper.setGone(R.id.nvr_status_cl, true);
            helper.setText(R.id.dev_amount_tv,String.format("%s%s", String.valueOf(item.getCount()), "个摄像头"));
        } else {
            helper.setGone(R.id.nvr_status_cl, false);
            helper.setText(R.id.dev_amount_tv,"");
        }
    }
}
