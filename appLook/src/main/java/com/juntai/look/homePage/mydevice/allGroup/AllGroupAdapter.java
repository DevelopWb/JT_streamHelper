package com.juntai.look.homePage.mydevice.allGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  所有分组适配器
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class AllGroupAdapter extends BaseQuickAdapter<CameraGroupBean.DataBean, BaseViewHolder> {
    public AllGroupAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CameraGroupBean.DataBean item) {
        int id = item.getId();
        if (-1==id) {
            //添加分组
            helper.setGone(R.id.group_infos_gp,false);
            helper.setGone(R.id.add_group_iv,true);
        }else {
            helper.setGone(R.id.group_infos_gp,true);
            helper.setGone(R.id.add_group_iv,false);
        }

        int iconId = item.getIcon();
        switch (iconId) {
            case 1:
                helper.setImageResource(R.id.group_icon_iv,R.mipmap.group_bg1_normal);
                break;
            case 2:
                helper.setImageResource(R.id.group_icon_iv,R.mipmap.group_bg2_normal);
                break;
            case 3:
                helper.setImageResource(R.id.group_icon_iv,R.mipmap.group_bg3_normal);
                break;
            case 4:
                helper.setImageResource(R.id.group_icon_iv,R.mipmap.group_bg4_normal);
                break;
            default:
                break;
        }
        helper.setText(R.id.camera_type_tv,item.getName());
        helper.addOnClickListener(R.id.group_set_tv);
        helper.addOnClickListener(R.id.add_group_iv);
    }
}
