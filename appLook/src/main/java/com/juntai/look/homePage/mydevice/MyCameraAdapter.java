package com.juntai.look.homePage.mydevice;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.CameraListBean;
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
public class MyCameraAdapter extends BaseQuickAdapter<CameraListBean.DataBean, BaseViewHolder> {
    public MyCameraAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CameraListBean.DataBean item) {
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
        } else {
            helper.setGone(R.id.offline_cl, false);
        }


        helper.setGone(R.id.nvr_status_cl, false);
    }
}
