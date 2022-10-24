package com.juntai.look.homePage.mydevice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.look.homePage.mydevice.allGroup.AllGroupsActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  nvr详情
 * @date 2020/9/13 15:33
 */
public class NVRDevDetailActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    public static String NVR_NUM = "nvr_num";//硬盘录像机的num
    public static String NVR_NAME = "nvr_name";//硬盘录像机的name
    private MyCameraAdapter adapter;
    /**
     * 4个摄像头
     */
    private TextView mNvrCameraAmountTv;
    /**
     * fjdfkaskldjf
     */
    private TextView mNvrDevNameTv;
    /**
     * 324365113456
     */
    private TextView mNvrDevNoTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_devs_of_nvr;
    }

    @Override
    public void initView() {

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        adapter = new MyCameraAdapter(R.layout.my_dev_item);
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(manager);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CameraListBean.DataBean bean = (CameraListBean.DataBean) adapter.getData().get(position);
                startActivity(new Intent(mContext.getApplicationContext(), PlayerLiveActivity.class)
                        .putExtra(PlayerLiveActivity.STREAM_CAMERA_ID, bean.getId())
                        .putExtra(PlayerLiveActivity.ENTER_TYPE, 1)
                        .putExtra(PlayerLiveActivity.STREAM_CAMERA_THUM_URL, bean.getEzopen())
                        .putExtra(PlayerLiveActivity.STREAM_CAMERA_NUM, bean.getNumber()));

            }
        });
        mNvrCameraAmountTv = (TextView) findViewById(R.id.nvr_camera_amount_tv);
        mNvrDevNameTv = (TextView) findViewById(R.id.nvr_dev_name_tv);
        mNvrDevNoTv = (TextView) findViewById(R.id.nvr_dev_no_tv);
    }


    @Override
    public void initData() {
        if (getIntent() != null) {
            String name = getIntent().getStringExtra(NVR_NAME);
            String num = getIntent().getStringExtra(NVR_NUM);
            mNvrDevNoTv.setText(num);
            mNvrDevNameTv.setText(String.format("%s%s", name, "(NVR)"));

            mPresenter.getDevsOfNVR(getBaseBuilder().add("number", num).add("channel",
                    MyDeviceContract.CAMERAS_OF_NVR_1).build(), "");
        }

    }


    @Override
    public void onSuccess(String tag, Object o) {
        CameraListBean devListBean = (CameraListBean) o;
        if (devListBean != null) {
            List<CameraListBean.DataBean> dataBean = devListBean.getData();
            if (dataBean != null&&dataBean.size()>0) {
                mNvrCameraAmountTv.setText(String.format("%s%s", String.valueOf(dataBean.size()), "个摄像头"));
                adapter.setNewData(dataBean);
            }else {
                mNvrCameraAmountTv.setText(String.format("%s%s", String.valueOf(0), "个摄像头"));
            }
        }

    }
}