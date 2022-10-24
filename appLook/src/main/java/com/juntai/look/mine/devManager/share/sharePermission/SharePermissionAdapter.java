package com.juntai.look.mine.devManager.share.sharePermission;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.PermissionListBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  分享权限
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class SharePermissionAdapter extends BaseQuickAdapter<PermissionListBean.DataBean.ListBean, BaseViewHolder> {
    public SharePermissionAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PermissionListBean.DataBean.ListBean item) {
        helper.setText(R.id.camera_type_tv, item.getName());
        if (item.isSelected()) {
            helper.setGone(R.id.group_selected_tag_tv,true);
        }else {
            helper.setGone(R.id.group_selected_tag_tv,false);
        }

    }
}
