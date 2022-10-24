package com.juntai.look.mine;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.MineMenuBean;
import com.juntai.look.hcb.R;

/**
 * @aouther tobato
 * @description 描述  我的菜单适配器
 * @date 2020/7/16 17:02
 */
public class MineMenuAdapter extends BaseQuickAdapter<MineMenuBean, BaseViewHolder> {

    public MineMenuAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineMenuBean item) {
        helper.setText(R.id.menu_name_tv,item.getName());
        helper.setImageResource(R.id.menu_icon_iv,item.getPicRes());
        int unReadNum = item.getUnReadNum();
        if (unReadNum>0){
            unReadNum =  unReadNum>99?99:unReadNum;
            helper.getView(R.id.menu_unread_tv).setVisibility(View.VISIBLE);
            helper.setText(R.id.menu_unread_tv, String.valueOf(unReadNum));
        }else {
            helper.setText(R.id.menu_unread_tv,"");
            helper.setVisible(R.id.menu_unread_tv, false);
        }
    }
}
