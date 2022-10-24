package com.juntai.look.mine.devManager.share.shareToWechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.Group;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.ModifyNameOrPwdActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.ToolShare;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;

/**
 * @aouther tobato
 * @description 描述  分享至微信
 * @date 2020/10/17 16:28
 */
public class ShareToWeChatActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView
        , View.OnClickListener {

    private ImageView mSharePicIv;
    /**
     * 肯德基法兰
     */
    private TextView mShareTimeValueTv;
    private Switch mVisitPwdSv;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;
    private int type = 0;//分享时间段的类型  0代表全时段 1代表 自定义时段
    private String startTime = null;
    private String endTime = null;
    private boolean showMoreSet = false;//展示更多设置
    private Group mMoreSetG;
    /**
     * 下一步
     */
    private TextView mShareToWchatNextTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_share_to_we_chat;
    }

    @Override
    public void initView() {
        setTitleName("分享至微信");
        getTitleRightTv().setText("更多");
        getTitleRightTv().setOnClickListener(this);
        mSharePicIv = (ImageView) findViewById(R.id.share_pic_iv);
        mShareTimeValueTv = (TextView) findViewById(R.id.share_time_value_tv);
        mShareTimeValueTv.setText("全时段");
        mVisitPwdSv = (Switch) findViewById(R.id.visit_pwd_sv);
        mShareTimeValueTv.setOnClickListener(this);
        mMoreSetG = (Group) findViewById(R.id.more_set_g);
        mShareToWchatNextTv = (TextView) findViewById(R.id.share_to_wchat_next_tv);
        mShareToWchatNextTv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mStreamCameraBean = Hawk.get(HawkProperty.CURRENT_CAMERA_SET);
        if (mStreamCameraBean != null) {
            ImageLoadUtil.loadImageCache(mContext,
                    UrlFormatUtil.formatStreamCapturePicUrl(mStreamCameraBean.getEzopen()), mSharePicIv);
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.SHARE_TO_WCHAT:
                BaseResult baseResult = (BaseResult) o;
                String msg = baseResult.getMsg();
                ToolShare.shareForMob(mContext, mStreamCameraBean.getName(), msg, mStreamCameraBean.getAddress(),
                        UrlFormatUtil.formatStreamCapturePicUrl(mStreamCameraBean.getEzopen()), callback);

                break;
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.share_time_value_tv:
                startActivityForResult(new Intent(mContext, SetShareTimeActivity.class), BASE_REQUESR);

                break;
            case R.id.title_rightTv:
                //更多
                showMoreSet = !showMoreSet;
                if (showMoreSet) {
                    mMoreSetG.setVisibility(View.VISIBLE);
                }else {
                    mMoreSetG.setVisibility(View.GONE);
                    //初始化时间段和访问密码的状态
                    mShareTimeValueTv.setText("全时段");
                    type=0;
                    mVisitPwdSv.setChecked(false);
                }

                break;
            case R.id.share_to_wchat_next_tv:
                //下一步
                if (!StringTools.isStringValueOk(getTextViewValue(mShareTimeValueTv))) {
                    ToastUtils.toast(mContext, "请选择分享时间段");
                    return;
                }
                if (mVisitPwdSv.isChecked()) {
                    if (mStreamCameraBean != null) {
                        startActivityForResult(new Intent(mContext, ModifyNameOrPwdActivity.class)
                                        .putExtra(ModifyNameOrPwdActivity.TYPE, 2)
                                        .putExtra(ModifyNameOrPwdActivity.CAMERA_NUM, mStreamCameraBean.getNumber())
                                        .putExtra(ModifyNameOrPwdActivity.SHARE_TIME_TYPE, type)
                                        .putExtra(ModifyNameOrPwdActivity.SHARE_TIME_START_TIME, startTime)
                                        .putExtra(ModifyNameOrPwdActivity.SHARE_TIME_END_TIME, endTime)
                                , BASE_REQUESR);
                    }

                } else {
                    //调用分享微信的接口
                    //ispwd  0是需要密码 1是不需要
                    if (0 == type) {
                        //全时段
                        mPresenter.shareToWchat(getBaseBuilder().add("number", mStreamCameraBean.getNumber()).add(
                                "isPwd",
                                String.valueOf(1)).add("timeintervalType", String.valueOf(0)).build(),
                                MyDeviceContract.SHARE_TO_WCHAT);
                    } else {
                        //自定义时段
                        mPresenter.shareToWchat(getBaseBuilder().add("number", mStreamCameraBean.getNumber()).add(
                                "isPwd", String.valueOf(1)).add("timeintervalType", String.valueOf(1))
                                        .add("beginTime", startTime)
                                        .add("endTime", endTime)
                                        .build(),
                                MyDeviceContract.SHARE_TO_WCHAT);
                    }

                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == BASE_RESULT) {
            if (data != null) {
                type = data.getIntExtra(SetShareTimeActivity.TIME_TYPE, 0);
                if (0 == type) {
                    mShareTimeValueTv.setText("全时段");
                } else {
                    startTime = data.getStringExtra(SetShareTimeActivity.START_TIME);
                    endTime = data.getStringExtra(SetShareTimeActivity.END_TIME);
                    mShareTimeValueTv.setText(String.format("%s%s%s", startTime, getString(R.string.to), endTime));
                }
            }
        }
    }

    /**
     * 分享外部回调
     */
    protected PlatformActionListener callback = new PlatformActionListener() {
        @Override
        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            //  分享成功后的操作或者提示
            ToastUtils.success(mContext, "分享成功！");
        }

        @Override
        public void onError(Platform platform, int i, Throwable throwable) {
            //  失败，打印throwable为错误码
            ToastUtils.warning(mContext, "分享失败！");
        }

        @Override
        public void onCancel(Platform platform, int i) {
            //  分享取消操作
            ToastUtils.warning(mContext, "分享已取消！");
        }
    };

}
