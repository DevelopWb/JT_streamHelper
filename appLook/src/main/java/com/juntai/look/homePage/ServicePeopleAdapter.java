package com.juntai.look.homePage;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.TextListBean;
import com.juntai.look.hcb.R;

/**
 * 服务人员中的列表
 *
 * @aouther Ma
 * @date 2019/3/17
 */
public class ServicePeopleAdapter extends BaseQuickAdapter<TextListBean, BaseViewHolder> {


    public ServicePeopleAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, TextListBean item) {
        helper.setText(R.id.item_text_list_left, item.getLeft());
        helper.setText(R.id.item_text_list_right, item.getRight());
        TextView keyTv = helper.getView(R.id.item_text_list_left);
        TextView keyValue = helper.getView(R.id.item_text_list_right);

    }
}