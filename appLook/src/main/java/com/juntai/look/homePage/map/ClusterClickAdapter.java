package com.juntai.look.homePage.map;

import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

/**
 * author:wong  地图底部弹窗的适配器
 * Date: 2019/4/19
 * Description:
 */
public class ClusterClickAdapter extends BaseQuickAdapter<MapClusterItem, BaseViewHolder> {
    public ClusterClickAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MapClusterItem item) {
        ImageView imageView = helper.getView(R.id.care_item_iv);
        helper.setGone(R.id.add_dev_tv, false);
        helper.setBackgroundRes(R.id.dev_tag_tv, 0);
        helper.setTextColor(R.id.dev_tag_tv, ContextCompat.getColor(mContext, R.color.text_default_color));
        helper.getView(R.id.dev_tag_tv).setPadding(0, 0, 0, 0);
        switch (item.getType()) {
            case MapClusterItem.STREAM_CAMERA:
                //                //标识 区分硬盘录像机和独立摄像头
                //                helper.setGone(R.id.care_navigation_tv,true);
                //                if (0==item.streamCamera.getFlag()) {
                //                    //网络视频录像机
                //                    helper.setText(R.id.care_navigation_tv,"NVR");
                //                    helper.setBackgroundColor(R.id.care_navigation_tv,
                //                            ContextCompat.getColor(mContext.getApplicationContext(),R.color.blue));
                //                }else{
                //                    //网络摄像机IP
                //                    helper.setText(R.id.care_navigation_tv,"IPC");
                //                    helper.setBackgroundColor(R.id.care_navigation_tv,
                //                            ContextCompat.getColor(mContext.getApplicationContext(),R.color.green));
                //                }

                ImageLoadUtil.loadImageNoCrash(mContext.getApplicationContext(),
                        UrlFormatUtil.formatStreamCapturePicUrl(item.streamCamera.getEzopen())
                        , imageView);
                helper.setText(R.id.camera_name_tv, item.streamCamera.getName())
                        .setText(R.id.camera_no_tv, "编号:" + item.streamCamera.getNumber())
                        .setText(R.id.dev_tag_tv, item.streamCamera.getAddress());
                break;
            case MapClusterItem.PEOPLE:
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageLoadUtil.loadCirImgNoCrash(mContext.getApplicationContext(),
                        UrlFormatUtil.formatPicUrl(item.peoplePosition.getHead()),
                        imageView,
                        R.mipmap.default_head_icon,
                        R.mipmap.default_head_icon);
                helper.setText(R.id.camera_name_tv, "姓名:" + item.peoplePosition.getName())
                        .setText(R.id.camera_no_tv, "街道:" + item.peoplePosition.getStreet())
                        //                        .setText(R.id.item_case_content, "状态:" + "离线")
                        .setText(R.id.dev_tag_tv, "联系方式:" + item.peoplePosition.getPhone());
                break;
        }
    }
}
