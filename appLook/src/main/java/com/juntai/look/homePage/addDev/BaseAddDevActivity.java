package com.juntai.look.homePage.addDev;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.addDev.nvr.AddNvrDevActivity;
import com.juntai.look.homePage.addDev.nvr.CamerasOfNVRActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.juntai.wisdom.bdmap.act.LocateSelectionActivity;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  添加设备的基类  添加普通摄像头 添加nvr
 * @CreateDate: 2020/9/1 15:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/1 15:37
 */
public abstract class BaseAddDevActivity extends BaseAppActivity<MyDevicePresent> implements View.OnClickListener,
        MyDeviceContract.IMyDeviceView {

    /**
     * 29374237492374973449
     */
    private TextView mAddDevNoTv;
    /**
     * 摄像头
     */
    private TextView mAddDevTypeTv;
    private FrameLayout mAddDevLayoutFl;
    private TextView mAddLocationAddrTv;
    /**
     * 设备名称:
     */
    private TextView mDevNameTv;
    private EditText mDevNameEt;
    /**
     * 保存
     */
    private TextView mSaveDevTv;
    public static String DEV_INFO = "devinfo";//设备信息

    private String addr = null;
    private String lat = null;
    private String lng = null;
    public DevToAddBean.DataBean.DatasBean dataBean;
    private String typeCode;
    private boolean isSavedNvr = false;//nvr是否添加成功

    protected abstract int getLayout();

    @Override
    public int getLayoutView() {
        return R.layout.base_add_dev;
    }

    @Override
    public void initView() {
        setTitleName("设备添加");
        mAddDevNoTv = (TextView) findViewById(R.id.add_dev_no_tv);
        mAddDevTypeTv = (TextView) findViewById(R.id.add_dev_type_tv);
        mAddDevLayoutFl = (FrameLayout) findViewById(R.id.add_dev_layout_fl);
        if (getLayout() != 0) {
            mAddDevLayoutFl.addView(LayoutInflater.from(mContext).inflate(getLayout(), mBaseRootCol, false));
        }
        mAddLocationAddrTv = (TextView) findViewById(R.id.add_location_addr_tv);
        mAddLocationAddrTv.setOnClickListener(this);
        mDevNameTv = (TextView) findViewById(R.id.dev_name_tv);
        mDevNameEt = (EditText) findViewById(R.id.dev_name_et);
        mSaveDevTv = (TextView) findViewById(R.id.save_dev_tv);
        mSaveDevTv.setOnClickListener(this);

    }

    @Override
    public boolean requestLocation() {
        return true;
    }

    @Override
    public void onLocationReceived(BDLocation bdLocation) {
        if (bdLocation != null) {
            //            mAddLocationAddrTv.setText(String.format("%s%s%s", bdLocation.getCity(), bdLocation.getTown(),
            //                    bdLocation.getStreet()));

            addr = bdLocation.getAddrStr();
            mAddLocationAddrTv.setText(addr);
            lat = String.valueOf(bdLocation.getLatitude());
            lng = String.valueOf(bdLocation.getLongitude());
        }

    }

    @Override
    public void initData() {

        if (getIntent() != null) {
            dataBean = getIntent().getParcelableExtra(DEV_INFO);
            if (dataBean != null) {
                mAddDevNoTv.setText(dataBean.getNumber());
                typeCode = dataBean.getTypeCode();
                if ("132".equals(typeCode)) {
                    //设备类型是摄像头
                    mAddDevTypeTv.setText("摄像头");
                    mSaveDevTv.setText("保存");
                } else if ("118".equals(typeCode)) {
                    //nvr
                    mAddDevTypeTv.setText("NVR（硬盘录像机）");
                    mSaveDevTv.setText("下一步");
                }
            }
        }

    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.ADD_NVR:
                isSavedNvr = true;
                startActivity(new Intent(mContext, CamerasOfNVRActivity.class).putExtra(BaseAddDevActivity.DEV_INFO,
                        dataBean));
                break;
            case MyDeviceContract.ADD_CAMERA:
                ToastUtils.toast(mContext, "添加成功");
                finish();
                break;
            default:
                break;
        }

    }

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.add_location_addr_tv:
                startActivityForResult(new Intent(mContext, LocateSelectionActivity.class),
                        LocateSelectionActivity.SELECT_ADDR);
                break;
            case R.id.save_dev_tv:
                String devName = getTextViewValue(mDevNameEt);
                if (!StringTools.isStringValueOk(devName)) {
                    ToastUtils.toast(mContext, "请输入设备名称");
                    return;
                }

                if (!StringTools.isStringValueOk(addr)) {
                    ToastUtils.toast(mContext, "无法获取您的位置 请确保手机gps信号正常");
                    return;
                }
                if ("132".equals(typeCode)) {
                    //设备类型是摄像头
                    if (dataBean != null) {
                        mPresenter.addCamera(getBaseBuilder().add("number", dataBean.getNumber()).add("name", devName)
                                        .add("address", addr).add("latitude", lat).add("longitude", lng).build(),
                                MyDeviceContract.ADD_CAMERA);
                    }
                } else if ("118".equals(typeCode)) {
                    //nvr
                    if (!isSavedNvr) {
                        mPresenter.addNvrDev(getBaseBuilder().add("number", dataBean.getNumber()).add("name", devName)
                                        .add("address", addr).add("latitude", lat).add("longitude", lng).build(),
                                MyDeviceContract.ADD_NVR);
                    } else {
                        startActivity(new Intent(mContext, CamerasOfNVRActivity.class).putExtra(BaseAddDevActivity.DEV_INFO,
                                dataBean));
                    }

                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (LocateSelectionActivity.SELECT_ADDR == resultCode) {
            if (data != null) {
                addr = data.getStringExtra(LocateSelectionActivity.SELECTED_ADDR);
                lat = data.getStringExtra(LocateSelectionActivity.SELECTED_LAT);
                lng = data.getStringExtra(LocateSelectionActivity.SELECTED_LNG);
                mAddLocationAddrTv.setText(addr);
            }
        }
    }
}
