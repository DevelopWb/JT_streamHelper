package com.juntai.look.homePage;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.HomePageMenuBean;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/17 14:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/17 14:58
 */
public class HomePageMenuAdapter extends BaseQuickAdapter<HomePageMenuBean, BaseViewHolder> {
    public HomePageMenuAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomePageMenuBean item) {
        helper.setImageResource(R.id.home_page_menu_iv,item.getResId());
    }
}
