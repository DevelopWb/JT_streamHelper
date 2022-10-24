package com.juntai.look.homePage.mydevice.allGroup.selectGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  选择分组
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class SelectGroupAdapter extends BaseQuickAdapter<CameraGroupBean.DataBean, BaseViewHolder> {
    public SelectGroupAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CameraGroupBean.DataBean item) {
        helper.setText(R.id.camera_type_tv, item.getName());
        if (item.isSelected()) {
            helper.setGone(R.id.group_selected_tag_tv,true);
        }else {
            helper.setGone(R.id.group_selected_tag_tv,false);
        }

    }
}
