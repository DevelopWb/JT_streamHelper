package com.juntai.look.mine;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.TextListBean;
import com.juntai.look.hcb.R;

/**
 * 我的信息适配器
 * @aouther Ma
 * @date 2019/3/17
 */
public class MyInfoAdapter extends BaseQuickAdapter<TextListBean, BaseViewHolder> {

    public MyInfoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, TextListBean item) {
        helper.setText(R.id.item_myinfo_name, item.getLeft());
        helper.setText(R.id.item_myinfo_value, item.getRight());

    }
}