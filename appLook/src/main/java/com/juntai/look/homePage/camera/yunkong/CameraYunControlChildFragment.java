package com.juntai.look.homePage.camera.yunkong;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.camera.PlayPresent;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;

/**
 * @Author: tobato
 * @Description: 作用描述  云台控制
 * @CreateDate: 2020/8/14 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/14 9:23
 */
public class CameraYunControlChildFragment extends BaseAppFragment<PlayPresent> implements PlayContract.IPlayView,
        View.OnClickListener {
    private ImageView mControlUpIv;
    private ImageView mControlLeftIv;
    private ImageView mControlDownIv;
    private ImageView mControlRightIv;
    private TextView mControlStopTv;
    /**
     * 拉近
     */
    private TextView mZoomInTv;
    /**
     * 拉远
     */
    private TextView mZoomOutTv;
    /**
     * 收藏
     */
    private TextView mCollectTv;

    @Override
    protected PlayPresent createPresenter() {
        return new PlayPresent();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_camera_yun_control_child;
    }

    @Override
    protected void initView() {

        mControlUpIv = (ImageView) getView(R.id.control_up_iv);
        mControlUpIv.setOnClickListener(this);
        mControlLeftIv = (ImageView) getView(R.id.control_left_iv);
        mControlLeftIv.setOnClickListener(this);
        mControlDownIv = (ImageView) getView(R.id.control_down_iv);
        mControlDownIv.setOnClickListener(this);
        mControlRightIv = (ImageView) getView(R.id.control_right_iv);
        mControlRightIv.setOnClickListener(this);
        mControlStopTv = (TextView) getView(R.id.control_stop_tv);
        mControlStopTv.setOnClickListener(this);
        mZoomInTv = (TextView) getView(R.id.zoom_in_tv);
        mZoomInTv.setOnClickListener(this);
        mZoomOutTv = (TextView) getView(R.id.zoom_out_tv);
        mZoomOutTv.setOnClickListener(this);
        mCollectTv = (TextView) getView(R.id.collect_tv);
        mCollectTv.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        initViewTopDrawable(mZoomInTv, R.drawable.put_in, 25, 25);
        initViewTopDrawable(mZoomOutTv, R.drawable.put_out, 25, 25);
        initViewTopDrawable(mCollectTv, R.drawable.collect, 25, 25);
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case PlayContract.OPERATE_YUNTAI:
                //                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_STOP, PlayContract
                //                .OPERATE_YUNTAI_SPEED,
                //                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case PlayContract.OPERATE_YUNTAI_STOP:
                break;
            case PlayContract.OPERATE_YUNTAI_COLLECT:
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String tag, Object o) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.control_up_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_UP, PlayContract.OPERATE_YUNTAI_SPEED,
                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_left_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_LEFT, PlayContract.OPERATE_YUNTAI_SPEED,
                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_down_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_DOWN, PlayContract.OPERATE_YUNTAI_SPEED,
                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_right_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_RIGHT, PlayContract.OPERATE_YUNTAI_SPEED,
                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_stop_tv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_STOP, PlayContract.OPERATE_YUNTAI_SPEED,
                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI_STOP);
                break;
            case R.id.zoom_in_tv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_ZOOM_IN, PlayContract.OPERATE_YUNTAI_SPEED,
                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.zoom_out_tv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_ZOOM_OUT, PlayContract.OPERATE_YUNTAI_SPEED,
                        ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.collect_tv:
                ((PlayerLiveActivity) getActivity()).captureAndUploadFile();
                break;
        }
    }
}
