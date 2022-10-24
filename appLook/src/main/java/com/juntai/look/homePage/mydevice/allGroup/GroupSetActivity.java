package com.juntai.look.homePage.mydevice.allGroup;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.GroupInfoBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.ModifyNameOrPwdActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.camerasOfGroup.CamerasListActivity;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  分组设置
 * @date 2020/9/3 11:17
 */
public class GroupSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    /**
     * 罗庄摄像头
     */
    private TextView mGroupNameTv;
    /**
     * 3个摄像头
     */
    private TextView mDevsOfGroupTv;
    /**
     * 删除设备
     */
    private TextView mDeleteDevTv;

    public static String GROUP_INFO = "groupInfo";//分组信息
    private CameraGroupBean.DataBean dataBean;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_group_set;
    }

    @Override
    public void initView() {
        setTitleName("分组设置");
        mGroupNameTv = (TextView) findViewById(R.id.camera_type_tv);
        mGroupNameTv.setOnClickListener(this);
        mDevsOfGroupTv = (TextView) findViewById(R.id.devs_of_group_tv);
        mDevsOfGroupTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            dataBean = getIntent().getParcelableExtra(GROUP_INFO);
            if (dataBean != null) {
                String groupName = dataBean.getName();
                Drawable drawableRight = getResources().getDrawable(R.mipmap.right);
                drawableRight.setBounds(0, 0, drawableRight.getMinimumWidth(), drawableRight.getMinimumHeight());
                if (MyDeviceContract.DEFAULT_GROUP_NAME_1.equals(groupName) || MyDeviceContract.DEFAULT_GROUP_NAME_2.equals(groupName)) {
                    //不可更改分组名
                    mGroupNameTv.setCompoundDrawables(null, null, null, null);
                    mGroupNameTv.setClickable(false);
                    mDeleteDevTv.setVisibility(View.GONE);
                } else {
                    mGroupNameTv.setCompoundDrawables(null, null, drawableRight, null);
                    mGroupNameTv.setClickable(true);
                    mDeleteDevTv.setVisibility(View.VISIBLE);
                }

                mGroupNameTv.setCompoundDrawablePadding(DisplayUtil.dp2px(mContext, 10));
                mGroupNameTv.setText(groupName);
                mPresenter.getCamerasOfGroup(getBaseBuilder().add("id", String.valueOf(dataBean.getId())).build(), "");
                mPresenter.getGroupInfo(getBaseBuilder().add("id", String.valueOf(dataBean.getId())).build(),
                        MyDeviceContract.GROUP_INFO);
            }

        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.DEL_GROUP:
                ToastUtils.toast(mContext, "删除成功");
                finish();
                break;
            case MyDeviceContract.GROUP_INFO:
                GroupInfoBean groupInfoBean = (GroupInfoBean) o;
                if (groupInfoBean != null) {
                    GroupInfoBean.DataBean dataBean =  groupInfoBean.getData();
                    if (dataBean != null) {
                        mGroupNameTv.setText(dataBean.getName());
                    }

                }
                break;
            default:
                CameraListBean cameraListBean = (CameraListBean) o;
                if (cameraListBean != null) {
                    List<CameraListBean.DataBean> arrays = cameraListBean.getData();
                    if (arrays != null) {
                        mDevsOfGroupTv.setText(String.format("%s%s", arrays.size(), "个设备"));
                    }
                }
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.camera_type_tv:
                if (dataBean != null) {
                    startActivityForResult(new Intent(mContext, ModifyNameOrPwdActivity.class).putExtra(ModifyNameOrPwdActivity.CONTENT, dataBean.getName())
                            .putExtra(ModifyNameOrPwdActivity.TYPE, 0)
                            .putExtra(SelectGroupActivity.CAMERA_ID, dataBean.getId()), BASE_REQUESR);
                }

                break;
            case R.id.devs_of_group_tv:
                startActivityForResult(new Intent(mContext, CamerasListActivity.class).putExtra(CamerasListActivity.GROUP_ID, dataBean.getId()), BASE_REQUESR);
                break;
            case R.id.delete_dev_tv:
                //删除分组
                new AlertDialog.Builder(mContext)
                        .setMessage("删除前请确认本分组无设备，分组内 有设备无法删除，确定删除分组吗？")
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除分组
                        if (dataBean != null) {
                            mPresenter.deleteGroup(getBaseBuilder().add("id", String.valueOf(dataBean.getId())).build(),
                                    MyDeviceContract.DEL_GROUP);
                        }

                    }
                }).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR == requestCode) {
            initData();
        }
    }
}
