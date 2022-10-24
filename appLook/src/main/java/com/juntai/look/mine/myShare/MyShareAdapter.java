package com.juntai.look.mine.myShare;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.mine.MyShareBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

/**
 * @Author: tobato
 * @Description: 作用描述  我的分享
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class MyShareAdapter extends BaseQuickAdapter<MyShareBean.DataBean.DatasBean, BaseViewHolder> {
    public MyShareAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyShareBean.DataBean.DatasBean item) {
        helper.setText(R.id.camera_name_tv, item.getName());
        helper.setText(R.id.camera_no_tv, item.getNumber());
        helper.setText(R.id.shared_user_name_tv, item.getSharedName());
        helper.setText(R.id.shared_time_tv, String.format("%s%s","时间:",item.getShareTime()));
        ImageLoadUtil.loadImageCache(mContext, UrlFormatUtil.formatStreamCapturePicUrl(item.getEzopen()),
                helper.getView(R.id.camera_pic_iv));
        if (item.isEdit()) {
            helper.setGone(R.id.selected_status_iv, true);
        } else {
            helper.setGone(R.id.selected_status_iv, false);
        }

        if (item.isSelected()) {
            helper.setImageResource(R.id.selected_status_iv, R.mipmap.check_true_icon);
        } else {
            helper.setImageResource(R.id.selected_status_iv, R.mipmap.check_false_icon);
        }
    }
}
