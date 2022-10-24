package com.juntai.look.mine.devManager.devSet;

import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  硬盘录像机 设置中的适配器
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class NvrSetAdapter extends BaseQuickAdapter<CameraListBean.DataBean, BaseViewHolder> {
    public NvrSetAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CameraListBean.DataBean item) {
        helper.setText(R.id.nvr_child_dev_no_tv,String.format("%s%s","摄像头:",item.getNumber()));
        int bindingFlag = item.getBindingFlag();//0未绑定；1已绑定
        if (0==bindingFlag) {
            helper.setText(R.id.nvr_camera_status_tv,"添加");
            helper.setBackgroundRes(R.id.nvr_camera_status_tv,0);
            helper.setTextColor(R.id.nvr_camera_status_tv, ContextCompat.getColor(mContext,R.color.green));
        }else {
            helper.setText(R.id.nvr_camera_status_tv,"设置");
            helper.setBackgroundRes(R.id.nvr_camera_status_tv,0);
            helper.setTextColor(R.id.nvr_camera_status_tv, ContextCompat.getColor(mContext,R.color.text_content));
        }
    }
}
