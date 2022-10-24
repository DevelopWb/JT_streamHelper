package com.juntai.look.homePage.mydevice.allGroup.transferDev;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

/**
 * @Author: tobato
 * @Description: 作用描述  转移设备的适配器
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class TransferDevAdapter extends BaseQuickAdapter<DevListBean.DataBean.ListBean, BaseViewHolder> {
    public TransferDevAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DevListBean.DataBean.ListBean item) {
        helper.setGone(R.id.arrow_right_tag_iv, false);
        helper.setGone(R.id.selected_status_iv, true);
        helper.setGone(R.id.share_tag_iv, true);
        if (0 == item.getIsShared()) {
            //别人分享我的  0是；1否
            helper.setImageResource(R.id.share_tag_iv,R.mipmap.share_icon);
        } else {
            helper.setImageResource(R.id.share_tag_iv,R.mipmap.my_dev_icon);

        }
        if (item.isSelected()) {
            helper.setImageResource(R.id.selected_status_iv,R.mipmap.check_true_icon);
        }else {
            helper.setImageResource(R.id.selected_status_iv,R.mipmap.check_false_icon);
        }


        helper.setText(R.id.camera_name_tv, item.getName());
        helper.setText(R.id.camera_no_tv,item.getNumber());

        if (0==item.getDvrFlag()) {
            helper.setGone(R.id.camera_pic_iv,true);
            helper.setGone(R.id.nvr_tag_iv,false);

            //摄像头
            ImageLoadUtil.loadImageCache(mContext, UrlFormatUtil.formatStreamCapturePicUrl(item.getEzopen()),
                    helper.getView(R.id.camera_pic_iv));
        }else {
            helper.setGone(R.id.camera_pic_iv,false);
            helper.setGone(R.id.nvr_tag_iv,true);
        }
    }
}
