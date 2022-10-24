package com.juntai.look.mine.devManager.share;

import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.stream.SharedUserBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  账户列表
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class AccountAdapter extends BaseQuickAdapter<SharedUserBean.DataBean, BaseViewHolder> {
    public AccountAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, SharedUserBean.DataBean item) {
        helper.setText(R.id.user_name_tv,item.getNickName());
        helper.setText(R.id.user_phone_tv,item.getShared());
        helper.setText(R.id.operate_user_tv,"移除");
        helper.setTextColor(R.id.operate_user_tv, ContextCompat.getColor(mContext,R.color.orange));
    }
}
