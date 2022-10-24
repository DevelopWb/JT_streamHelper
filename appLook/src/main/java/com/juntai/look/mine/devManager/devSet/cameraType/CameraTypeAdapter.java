package com.juntai.look.mine.devManager.devSet.cameraType;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.CameraTypeBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  摄像头类型

 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class CameraTypeAdapter extends BaseQuickAdapter<CameraTypeBean.DataBean, BaseViewHolder> {
    public CameraTypeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CameraTypeBean.DataBean item) {
        if (item.isSelect()) {
            helper.setImageResource(R.id.camera_type_select_iv,R.mipmap.select_circle_true_blue);
        }else {
            helper.setImageResource(R.id.camera_type_select_iv,R.mipmap.select_circle_false_icon);
        }
        helper.setText(R.id.camera_type_name_tv,item.getName());
    }
}
