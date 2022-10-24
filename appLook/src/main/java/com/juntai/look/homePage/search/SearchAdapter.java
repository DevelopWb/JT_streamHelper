package com.juntai.look.homePage.search;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.MultipleItem;
import com.juntai.look.bean.search.SearchBean;
import com.juntai.look.bean.search.SearchMoreBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/15 10:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/15 10:10
 */
public class SearchAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public SearchAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.ITEM_TITLE, R.layout.item_title);
        addItemType(MultipleItem.ITEM_CONTENT, R.layout.all_info_item);
        addItemType(MultipleItem.ITEM_LOAD_MORE, R.layout.item_content_load_more);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (item.getItemType()) {
            case MultipleItem.ITEM_TITLE:
                SearchBean.DataBean dataBean = (SearchBean.DataBean) item.getObject();
                helper.setText(R.id.item_title_name_tv, dataBean.getTypeName());

                break;
            case MultipleItem.ITEM_CONTENT:
                SearchBean.DataBean.SearchListBean listBean = (SearchBean.DataBean.SearchListBean) item.getObject();
                helper.setText(R.id.all_info_item_title_tv, listBean.getName());

                int resultType = listBean.getResultType();
                switch (resultType) {
                    case SearchActivity.INFO_TYPE_CAMERA:
                        //监控
                        helper.setText(R.id.all_info_item_des_tv, listBean.getAddress());
                        int nvrflog = listBean.getDvrFlag();
                        if (0 == nvrflog) {
                            helper.setGone(R.id.nvr_tag_iv, false);
                            helper.setGone(R.id.all_info_item_iv, true);
                            ImageLoadUtil.loadImageCache(mContext.getApplicationContext(),
                                    UrlFormatUtil.formatStreamCapturePicUrl(listBean.getEzopen()),
                                    helper.getView(R.id.all_info_item_iv));
                        } else if (1 == nvrflog) {
                            helper.setGone(R.id.nvr_tag_iv, true);
                            helper.setGone(R.id.all_info_item_iv, false);
                        }
                        break;
                    case SearchActivity.INFO_TYPE_GROUP:
                        helper.setText(R.id.all_info_item_des_tv, String.format("%s%s",listBean.getAddress(),"个设备"));
                        helper.setGone(R.id.nvr_tag_iv, false);
                        helper.setGone(R.id.all_info_item_iv, true);
                        String ezopen = listBean.getEzopen();
                        switch (ezopen) {
                            case MultipleItem.GROUP_BG_TYPE1:
                                helper.setImageResource(R.id.all_info_item_iv, R.mipmap.group_bg1_press);
                                break;
                            case MultipleItem.GROUP_BG_TYPE2:
                                helper.setImageResource(R.id.all_info_item_iv, R.mipmap.group_bg2_press);
                                break;
                            case MultipleItem.GROUP_BG_TYPE3:
                                helper.setImageResource(R.id.all_info_item_iv, R.mipmap.group_bg3_press);

                                break;
                            case MultipleItem.GROUP_BG_TYPE4:
                                helper.setImageResource(R.id.all_info_item_iv, R.mipmap.group_bg4_press);

                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }

                break;
            case MultipleItem.ITEM_LOAD_MORE:
                SearchMoreBean searchMoreBean = (SearchMoreBean) item.getObject();
                String msg = searchMoreBean.getMsg();
                if (!mContext.getString(R.string.load_more_no_data).equals(msg)) {
                    helper.setGone(R.id.item_load_more_tv, true);
                } else {
                    helper.setGone(R.id.item_load_more_tv, false);
                }
                helper.setText(R.id.item_load_more_tv, searchMoreBean.getMsg());
                break;
            default:
                break;
        }
    }
}
