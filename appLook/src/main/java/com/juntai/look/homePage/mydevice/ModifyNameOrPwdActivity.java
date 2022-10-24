package com.juntai.look.homePage.mydevice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.exoplayer2.C;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.look.mine.devManager.devSet.CameraSetActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.ToolShare;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;

/**
 * @aouther tobato
 * @description 描述 修改名称或者密码 (0分组的名称 或者1摄像头的名称,2是配置密码)
 * @date 2020/9/13 14:59
 */
public class ModifyNameOrPwdActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private int cameraId;
    /**
     * 摄像头名称
     */
    private EditText mNameTv;
    private ImageView mClearContentIv;
    /**
     * 摄像头名称
     */
    private EditText mNameEt;

    public static String TYPE = "modifytype";//0分组的名称 或者1摄像头的名称//2是设置密码
    public static String SHARE_TIME_TYPE = "share_time_type";//分享时间类型
    public static String SHARE_TIME_START_TIME = "share_time_type_start";//分享时间 开始时间
    public static String SHARE_TIME_END_TIME = "share_time_type_end";//分享时间 开始时间
    public static String CAMERA_NUM = "cameranum";//分享时间 开始时间
    public static String CONTENT = "content";//修改的内容
    private int type;
    private int share_type;//分享时间类型
    private String startTime = null;
    private String endTime = null;
    private String cameraNum;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_modify_name;
    }

    @Override
    public void initView() {

        getTitleRightTv().setOnClickListener(this);
        mNameEt = (EditText) findViewById(R.id.name_et);
        mClearContentIv = (ImageView) findViewById(R.id.clear_content_iv);
        mClearContentIv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            type = getIntent().getIntExtra(TYPE, 0);
            cameraNum = getIntent().getStringExtra(CAMERA_NUM);
            startTime = getIntent().getStringExtra(SHARE_TIME_START_TIME);
            endTime = getIntent().getStringExtra(SHARE_TIME_END_TIME);
            share_type = getIntent().getIntExtra(SHARE_TIME_TYPE, 0);
            if (1 == type || 0 == type) {
                //修改摄像头或者分组名称
                setTitleName("修改名称");
                getTitleRightTv().setText("完成");
                mNameEt.setHint("请输入摄像头名称");
                cameraId = getIntent().getIntExtra(SelectGroupActivity.CAMERA_ID, 0);
                mNameEt.setText(getIntent().getStringExtra(CONTENT));
            } else {
                setTitleName("设置密码");
                getTitleRightTv().setText("分享");
                mNameEt.setHint("请输入6~12位密码");
            }
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.SAVE_CONFIG:
                ToastUtils.toast(mContext, "保存成功");
                finish();
                break;
            case MyDeviceContract.SHARE_TO_WCHAT:
                BaseResult baseResult = (BaseResult) o;
                String msg = baseResult.getMsg();
                StreamCameraDetailBean.DataBean mStreamCameraBean = Hawk.get(HawkProperty.CURRENT_CAMERA_SET);
                ToolShare.shareForMob(mContext, mStreamCameraBean.getName(), msg, mStreamCameraBean.getAddress(),
                        UrlFormatUtil.formatStreamCapturePicUrl(mStreamCameraBean.getEzopen()), callback);
                break;
            default:
                break;
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
            finish();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.clear_content_iv:
                mNameEt.setText("");
                break;
            case R.id.title_rightTv:
                //完成

                switch (type) {
                    case 0:
                        //修改分组名称
                        //修改分组名称
                        mPresenter.updateGroupName(getBaseBuilder().add("id", String.valueOf(cameraId)).add(
                                "name", getTextViewValue(mNameEt)).build(),
                                MyDeviceContract.SAVE_CONFIG);
                        break;
                    case 1:
                        mPresenter.saveCameraConfig(getBaseBuilder().add("id", String.valueOf(cameraId)).add(
                                "name", getTextViewValue(mNameEt)).build(),
                                MyDeviceContract.SAVE_CONFIG);
                        break;
                    case 2:
                        //修改分享密码后分享
                        //调用分享微信的接口
                        //ispwd  0是需要密码 1是不需要
                        if (0 == share_type) {
                            //全时段
                            mPresenter.shareToWchat(getBaseBuilder()
                                            .add("number", cameraNum)
                                            .add("isPwd", String.valueOf(0))
                                            .add("password", encryptPwd(UserInfoManager.getUserAccount(),
                                                    getTextViewValue(mNameEt)))
                                            .add("timeintervalType", String.valueOf(0)).build(),
                                    MyDeviceContract.SHARE_TO_WCHAT);
                        } else {
                            //自定义时段
                            mPresenter.shareToWchat(getBaseBuilder()
                                            .add("number", cameraNum)
                                            .add("isPwd", String.valueOf(0))
                                            .add("password", encryptPwd(UserInfoManager.getUserAccount(),
                                                    getTextViewValue(mNameEt)))
                                            .add("timeintervalType", String.valueOf(1))
                                            .add("beginTime", startTime)
                                            .add("endTime", endTime)
                                            .build(),
                                    MyDeviceContract.SHARE_TO_WCHAT);
                        }

                        break;
                    default:
                        break;
                }

                break;
        }
    }
}
