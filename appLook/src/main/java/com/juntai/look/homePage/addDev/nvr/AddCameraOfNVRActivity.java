package com.juntai.look.homePage.addDev.nvr;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

/**
 * @aouther tobato
 * @description 描述 添加nvr 里面的摄像头
 * @date 2020/9/13 11:18
 */
public class AddCameraOfNVRActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mAddDevNoTv;
    private EditText mDevNameEt;
    /**
     * 保存
     */
    private TextView mSaveDevTv;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;
    private String devNum;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_add_camera_of_n_v_r;
    }

    @Override
    public void initView() {
        setTitleName("设备添加");
        mAddDevNoTv = (TextView) findViewById(R.id.add_dev_no_tv);
        mDevNameEt = (EditText) findViewById(R.id.dev_name_et);
        mSaveDevTv = (TextView) findViewById(R.id.save_dev_tv);
        mSaveDevTv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            devNum = getIntent().getStringExtra(BaseCameraSetActivity.CAMERA_NUM);
            mAddDevNoTv.setText(devNum);
            mStreamCameraBean = getIntent().getParcelableExtra(BaseCameraSetActivity.DEV_INFO);
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        ToastUtils.toast(mContext, "绑定成功");
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.save_dev_tv:

                String devName = getTextViewValue(mDevNameEt);
                if (!StringTools.isStringValueOk(devName)) {
                    ToastUtils.toast(mContext, "请输入设备名称");
                    return;
                }

                if (mStreamCameraBean != null) {
                    mPresenter.addCamera(getBaseBuilder().add("number", devNum).add("name", devName)
                                    .add("address", mStreamCameraBean.getAddress()).add("latitude",
                                    mStreamCameraBean.getLatitude()).add("longitude",
                                    mStreamCameraBean.getLongitude()).build(),
                            MyDeviceContract.ADD_CAMERA);
                }
                break;
        }
    }
}
