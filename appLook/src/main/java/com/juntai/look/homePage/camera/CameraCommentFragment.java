package com.juntai.look.homePage.camera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  摄像头评论
 * @CreateDate: 2020/8/14 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/14 9:23
 */
public class CameraCommentFragment extends BaseAppFragment<PlayPresent> implements PlayContract.IPlayView {
    /**
     * 设备位置:
     */
    private TextView mDeviceplace;
    /**
     * 设备状态:
     */
    private TextView mDevicestate;

    @Override
    protected PlayPresent createPresenter() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_camera_comment;
    }

    @Override
    protected void initView() {

        mDeviceplace = (TextView) getView(R.id.deviceplace);
        mDevicestate = (TextView) getView(R.id.devicestate);
    }

    /**
     * 初始化数据
     * @param addr
     */
    public  void  initAddrData(String addr){
        mDeviceplace.setText(String.format("%s%s","设备位置:",addr));
    }
    /**
     * 初始化数据
     */
    public  void  initStatusData(String status){
        mDevicestate.setText(String.format("%s%s","设备状态:",status));
    }
    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onError(String tag, Object o) {

    }

}
