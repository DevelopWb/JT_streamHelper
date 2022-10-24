package com.juntai.look.homePage.addDev;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  添加设备
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class AddDevAdapter extends BaseQuickAdapter<DevToAddBean.DataBean.DatasBean, BaseViewHolder> {
    public AddDevAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DevToAddBean.DataBean.DatasBean item) {
        helper.setText(R.id.dev_no_tv, item.getNumber());
        helper.setText(R.id.dev_tag_tv, item.getTypeName());

        String typeCode = item.getTypeCode();
        if ("132".equals(typeCode)) {
            //设备类型是摄像头
            helper.setBackgroundRes(R.id.dev_tag_tv, R.color.orange);
        } else if ("118".equals(typeCode)) {
            //nvr
            helper.setBackgroundRes(R.id.dev_tag_tv, R.color.green);
        } else {
            helper.setBackgroundRes(R.id.dev_tag_tv, R.color.green);
        }
        int bindingFlag = item.getBindingFlag();
        if (0 == bindingFlag) {
            //未绑定
            helper.setText(R.id.add_dev_tv,"添加");
            helper.setBackgroundRes(R.id.add_dev_tv,R.drawable.sp_blue_square_button);
        }else {
            helper.setText(R.id.add_dev_tv,"已绑定");
            helper.setBackgroundRes(R.id.add_dev_tv,R.drawable.sp_gray_deeper_square_button);
        }

    }

}
