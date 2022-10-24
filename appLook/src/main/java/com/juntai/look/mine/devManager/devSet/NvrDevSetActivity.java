package com.juntai.look.mine.devManager.devSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.addDev.nvr.AddCameraOfNVRActivity;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.mydevice.ModifyNameOrPwdActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.juntai.wisdom.bdmap.act.LocateSelectionActivity;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  nvr设备设置
 * @date 2020/9/2 15:35
 */
public class NvrDevSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mCameraNoTv;
    /**
     * 肯德基法兰
     */
    private TextView mCameraNameTv;
    private RecyclerView mNvrChildRv;
    /**
     * fdasdfsadfsad
     */
    private TextView mCameraAddrTv;
    /**
     * 球防守打法技
     */
    private TextView mCameraGroupTv;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;
    /**
     * 删除设备
     */
    private TextView mDeleteDevTv;
    private int devId;
    public static String DEV_NUM = "devnum";//num
    private NvrSetAdapter adapter;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_nvr_dev_set;
    }

    @Override
    public void initView() {

        setTitleName("设置");
        mCameraNoTv = (TextView) findViewById(R.id.camera_no_tv);
        mCameraNameTv = (TextView) findViewById(R.id.camera_name_tv);
        mCameraNameTv.setOnClickListener(this);
        mNvrChildRv = (RecyclerView) findViewById(R.id.nvr_child_rv);
        mCameraAddrTv = (TextView) findViewById(R.id.camera_addr_tv);
        mCameraAddrTv.setOnClickListener(this);
        mCameraGroupTv = (TextView) findViewById(R.id.camera_group_tv);
        mCameraGroupTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
        adapter = new NvrSetAdapter(R.layout.nvr_child_item);
        initRecyclerview(mNvrChildRv, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CameraListBean.DataBean dataBean = (CameraListBean.DataBean) adapter.getData().get(position);
                int bindingFlag = dataBean.getBindingFlag();//0未绑定；1已绑定
                if (0==bindingFlag) {
                    if (mStreamCameraBean != null) {
                        startActivityForResult(new Intent(mContext, AddCameraOfNVRActivity.class).putExtra(BaseCameraSetActivity.CAMERA_NUM,dataBean.getNumber())
                                .putExtra(BaseCameraSetActivity.DEV_INFO,mStreamCameraBean),BASE_REQUESR);
                    }

                }else {
                    startActivityForResult(new Intent(mContext, CameraOfNvrSetActivity.class)
                                    .putExtra(BaseCameraSetActivity.ENTRANCE_TYPE,1)
                                    .putExtra(BaseCameraSetActivity.DEV_INFO_ID, dataBean.getId())
                            , BaseAppActivity.BASE_REQUESR);
                }

            }
        });
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            String devNum = getIntent().getStringExtra(DEV_NUM);
            devId = getIntent().getIntExtra(BaseCameraSetActivity.DEV_INFO_ID, 0);
            mPresenter.getStreamCameraDetail(getBaseBuilder().add("id", String.valueOf(devId)).build(),
                    PlayContract.GET_STREAM_CAMERA_DETAIL);
            mPresenter.getDevsOfNVR(getBaseBuilder().add("number", devNum).add("channel",
                    MyDeviceContract.CAMERAS_OF_NVR_2).build(), MyDeviceContract.CAMERAS_OF_NVR);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR==requestCode) {
            initData();
        }
        if (LocateSelectionActivity.SELECT_ADDR == resultCode) {
            if (data != null) {
                String addr = data.getStringExtra(LocateSelectionActivity.SELECTED_ADDR);
                String lat = data.getStringExtra(LocateSelectionActivity.SELECTED_LAT);
                String lng = data.getStringExtra(LocateSelectionActivity.SELECTED_LNG);
                mCameraAddrTv.setText(addr);
                //调用设置位置的接口
                if (mStreamCameraBean != null) {
                    mPresenter.saveCameraConfig(getBaseBuilder().add("id", String.valueOf(mStreamCameraBean.getId()))
                                    .add("address", addr)
                                    .add("latitude", lat)
                                    .add("longitude", lng)
                                    .build(),
                            MyDeviceContract.SAVE_CONFIG);
                }



            }
        }
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case PlayContract.GET_STREAM_CAMERA_DETAIL:
                StreamCameraDetailBean detailBean = (StreamCameraDetailBean) o;
                if (detailBean != null) {
                    mStreamCameraBean = detailBean.getData();
                    mCameraNoTv.setText(mStreamCameraBean.getNumber());
                    mCameraNameTv.setText(mStreamCameraBean.getName());
                    mCameraAddrTv.setText(mStreamCameraBean.getAddress());
                    mCameraGroupTv.setText(mStreamCameraBean.getGroupName());

                }
                break;
            case MyDeviceContract.CAMERAS_OF_NVR:
                CameraListBean devListBean = (CameraListBean) o;
                if (devListBean != null) {
                    List<CameraListBean.DataBean> dataBean = devListBean.getData();
                    if (dataBean != null) {
                        adapter.setNewData(dataBean);

                    }
                }
                break;
            case MyDeviceContract.DEL_DEV:
                ToastUtils.toast(mContext,"删除成功");
                finish();
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
            case R.id.camera_name_tv:
                startActivityForResult(new Intent(mContext, ModifyNameOrPwdActivity.class).putExtra(ModifyNameOrPwdActivity.CONTENT,mStreamCameraBean.getName())
                        .putExtra(ModifyNameOrPwdActivity.TYPE,1)
                        .putExtra(SelectGroupActivity.CAMERA_ID, mStreamCameraBean.getId()), BASE_REQUESR);
                break;
            case R.id.camera_addr_tv:
                //更改位置信息
                startActivityForResult(new Intent(mContext, LocateSelectionActivity.class),
                        LocateSelectionActivity.SELECT_ADDR);
                break;
            case R.id.camera_group_tv:
                //设备分组
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, SelectGroupActivity.class).putExtra(SelectGroupActivity.CAMERA_ID,
                            mStreamCameraBean.getId()).putExtra(SelectGroupActivity.GROUP_ID,
                            mStreamCameraBean.getGroupId()),
                            BASE_REQUESR);
                }
                break;
            case R.id.delete_dev_tv:
                //删除设备
                new AlertDialog.Builder(mContext)
                        .setMessage("删除后无法恢复,确定删除设备吗?")
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除设备
                        if (mStreamCameraBean != null) {
                            mPresenter.deleteDev(getBaseBuilder().add("number",
                                    String.valueOf(mStreamCameraBean.getNumber())).build(), MyDeviceContract.DEL_DEV);
                        }

                    }
                }).show();
                break;
        }
    }
}
