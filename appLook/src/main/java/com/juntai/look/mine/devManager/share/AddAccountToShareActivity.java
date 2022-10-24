package com.juntai.look.mine.devManager.share;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.SharedUserBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.devManager.share.sharePermission.SharePermissionActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

/**
 * @aouther tobato
 * @description 描述  添加账号分享
 * @date 2020/9/14 17:49
 */
public class AddAccountToShareActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mSharedAccountValueTv;
    /**
     * 全时段
     */
    private TextView mSharedTimeValueTv;
    /**
     * 肯德基法兰
     */
    private TextView mSharedPermissionTv;
    /**
     * 保存
     */
    private TextView mAddAccountTv;
    private String ids = null;
    private String names = null;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_add_account;
    }

    @Override
    public void initView() {
        setTitleName("分享账号添加");
        mSharedAccountValueTv = (TextView) findViewById(R.id.shared_account_value_tv);
        mSharedTimeValueTv = (TextView) findViewById(R.id.shared_time_value_tv);
        mSharedPermissionTv = (TextView) findViewById(R.id.shared_permission_tv);
        mSharedPermissionTv.setOnClickListener(this);
        mAddAccountTv = (TextView) findViewById(R.id.add_account_tv);
        mAddAccountTv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            SharedUserBean.DataBean bean = getIntent().getParcelableExtra(PUBLIC_OBJECT_KEY);
            if (bean != null) {
                mSharedAccountValueTv.setText(bean.getAccount());
            }
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        ToastUtils.toast(mContext, "添加成功");
        startActivity(new Intent(mContext,SharedAccountActivity.class));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.shared_permission_tv:
                //分享权限
                startActivityForResult(new Intent(mContext, SharePermissionActivity.class), BASE_REQUESR);
                break;
            case R.id.add_account_tv:
                //保存
                if (ids == null) {
                    ToastUtils.toast(mContext, "请选择分享权限");
                    return;
                }
                StreamCameraDetailBean.DataBean mStreamCameraBean = Hawk.get(HawkProperty.CURRENT_CAMERA_SET);
                if (mStreamCameraBean != null) {
                    //shareTimeintervalId  目前默认传0（0全时段；1自定义时段）
                    mPresenter.addShareAccount(getBaseBuilder().add("number", mStreamCameraBean.getNumber()).add(
                            "shared", getTextViewValue(mSharedAccountValueTv)).add("shareTimeintervalId",
                            String.valueOf(0)).add("sharePowerIds", ids).build(), "");
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR == resultCode) {
            if (data != null) {
                ids = data.getStringExtra(SharePermissionActivity.PREMISSION);
                names = data.getStringExtra(SharePermissionActivity.PREMISSION_NAMES);
                mSharedPermissionTv.setText(names);
            }
        }
    }
}
