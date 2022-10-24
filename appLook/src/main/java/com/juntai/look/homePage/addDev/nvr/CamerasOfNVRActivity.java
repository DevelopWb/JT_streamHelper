package com.juntai.look.homePage.addDev.nvr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.addDev.AddDevActivity;
import com.juntai.look.homePage.addDev.BaseAddDevActivity;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  硬盘录像机下面的摄像头---添加
 * @date 2020/11/3 16:43
 */
public class CamerasOfNVRActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;
    public DevToAddBean.DataBean.DatasBean dataBean;

    /**
     * 完成
     */
    private TextView mCompletevTv;
    private NvrChildAdapter adapter;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_camera_of_nvr;
    }

    @Override
    public void initView() {
        setTitleName("NVR中的摄像头添加");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        mCompletevTv = (TextView) findViewById(R.id.completev_tv);
        mCompletevTv.setOnClickListener(this);

        adapter = new NvrChildAdapter(R.layout.nvr_child_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CameraListBean.DataBean bean = (CameraListBean.DataBean) adapter.getData().get(position);
                int flag = bean.getBindingFlag();
                if (0 == flag) {
                    //未绑定
                    if (mStreamCameraBean != null) {
                        startActivityForResult(new Intent(mContext, AddCameraOfNVRActivity.class).putExtra(BaseCameraSetActivity.CAMERA_NUM, bean.getNumber())
                                .putExtra(BaseCameraSetActivity.DEV_INFO, mStreamCameraBean), BASE_REQUESR);
                    }
                } else {
                    ToastUtils.toast(mContext, "已添加");
                }

            }
        });
    }

    @Override
    public void initData() {
        dataBean = getIntent().getParcelableExtra(BaseAddDevActivity.DEV_INFO);
        if (dataBean != null) {
            mPresenter.getDevsOfNVR(getBaseBuilder().add("number", dataBean.getNumber()).add("channel",
                    MyDeviceContract.CAMERAS_OF_NVR_2).build(), MyDeviceContract.CAMERAS_OF_NVR);
            mPresenter.getStreamCameraDetail(getBaseBuilder().add("id", String.valueOf(dataBean.getId())).build(),
                    PlayContract.GET_STREAM_CAMERA_DETAIL);
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.CAMERAS_OF_NVR:
                CameraListBean devListBean = (CameraListBean) o;
                if (devListBean != null) {
                    List<CameraListBean.DataBean> dataBean = devListBean.getData();
                    if (dataBean != null) {
                        adapter.setNewData(dataBean);

                    }
                }
                break;
            case PlayContract.GET_STREAM_CAMERA_DETAIL:
                StreamCameraDetailBean detailBean = (StreamCameraDetailBean) o;
                if (detailBean != null) {
                    mStreamCameraBean = detailBean.getData();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (BASE_REQUESR == requestCode) {
            mPresenter.getDevsOfNVR(getBaseBuilder().add("number", dataBean.getNumber()).add("channel",
                    MyDeviceContract.CAMERAS_OF_NVR_2).build(), MyDeviceContract.CAMERAS_OF_NVR);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.completev_tv:
               startActivity(new Intent(this, AddDevActivity.class));
                break;
        }
    }

}
