package com.juntai.look.mine.devManager.share.shareToWechat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.ShareTimeBean;
import com.juntai.look.bean.stream.PermissionListBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  分享时间
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class ShareTimeAdapter extends BaseQuickAdapter<ShareTimeBean, BaseViewHolder> {
    public ShareTimeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper,ShareTimeBean item) {
        helper.setText(R.id.camera_type_tv, item.getName());
        if (item.isSelect()) {
            helper.setGone(R.id.group_selected_tag_tv,true);
        }else {
            helper.setGone(R.id.group_selected_tag_tv,false);
        }

    }
}
