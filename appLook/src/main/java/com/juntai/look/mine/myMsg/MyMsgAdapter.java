package com.juntai.look.mine.myMsg;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.MultipleItem;
import com.juntai.look.bean.mine.MyMsgBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.utils.CalendarUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

import java.util.List;

/**
 * Describe:我的消息
 * Create by zhangzhenlong
 * 2020-3-25
 * email:954101549@qq.com
 */
public class MyMsgAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyMsgAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.ITEM_TITLE, R.layout.my_msg_title_item);
        addItemType(MultipleItem.ITEM_CONTENT, R.layout.my_sys_msg_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (item.getItemType()) {
            case MultipleItem.ITEM_TITLE:
                String title = (String) item.getObject();
                helper.setText(R.id.item_title_name_tv, title);
                break;
            default:
                break;
        }
    }
}
