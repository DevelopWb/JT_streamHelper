package com.juntai.look.base;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.hcb.R;

/**
 * 单个text的适配器
 *
 * @aouther Ma
 * @date 2019/3/17
 */
public class SingleTextAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private boolean hidePresentBg = false;//隐藏背景

    public SingleTextAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.single_text_tv, item);

    }
}