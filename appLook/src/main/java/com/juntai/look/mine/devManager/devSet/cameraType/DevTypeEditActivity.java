package com.juntai.look.mine.devManager.devSet.cameraType;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraTypeBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  设备类型编辑
 * @date 2020/9/14 16:28
 */
public class DevTypeEditActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private RecyclerView mCameraTypeRv;
    private CameraTypeAdapter adapter;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;

    private int typeId;
    private int isYuntai;//是否有云台（0是；1否）
    private ImageView mHasYunIv;
    private ImageView mUnHasYunIv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_dev_type_edit;
    }

    @Override
    public void initView() {
        setTitleName("设备类型编辑");
        getTitleRightTv().setText("保存");
        getTitleRightTv().setOnClickListener(this);
        mCameraTypeRv = (RecyclerView) findViewById(R.id.camera_type_rv);
        adapter = new CameraTypeAdapter(R.layout.camera_type_item);
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        mCameraTypeRv.setAdapter(adapter);
        mCameraTypeRv.setLayoutManager(manager);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<CameraTypeBean.DataBean> arrays = adapter.getData();
                CameraTypeBean.DataBean typeBean = arrays.get(position);
                for (int i = 0; i < arrays.size(); i++) {
                    CameraTypeBean.DataBean bean = arrays.get(i);
                    bean.setSelect(false);
                    adapter.notifyItemChanged(i);
                }
                typeBean.setSelect(true);
                typeId = typeBean.getId();
                adapter.notifyItemChanged(position);
            }
        });

        mHasYunIv = (ImageView) findViewById(R.id.has_yun_iv);
        mHasYunIv.setOnClickListener(this);
        mUnHasYunIv = (ImageView) findViewById(R.id.un_has_yun_iv);
        mUnHasYunIv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            mStreamCameraBean = getIntent().getParcelableExtra(BaseCameraSetActivity.DEV_INFO);
            if (mStreamCameraBean != null) {
                typeId = mStreamCameraBean.getTypeId();
                isYuntai = mStreamCameraBean.getIsYuntai();
                if (0 == isYuntai) {
                    mHasYunIv.setImageResource(R.mipmap.select_circle_true_blue);
                    mUnHasYunIv.setImageResource(R.mipmap.select_circle_false_icon);
                } else {
                    mHasYunIv.setImageResource(R.mipmap.select_circle_false_icon);
                    mUnHasYunIv.setImageResource(R.mipmap.select_circle_true_blue);
                }
            }
        }
        mPresenter.cameraType(getBaseBuilder().build(), "");
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.SAVE_CONFIG:
                ToastUtils.toast(mContext,"保存成功");
                finish();
                break;
            default:
                CameraTypeBean typeBean = (CameraTypeBean) o;
                if (typeBean != null) {
                    List<CameraTypeBean.DataBean> arrays = typeBean.getData();
                    for (CameraTypeBean.DataBean array : arrays) {
                        array.setSelect(false);
                        if (mStreamCameraBean != null) {
                            if (mStreamCameraBean.getTypeName().equals(array.getName())) {
                                array.setSelect(true);
                            }
                        }
                    }
                    adapter.setNewData(arrays);
                }
                break;
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_rightTv:
                //保存
                mPresenter.saveCameraConfig(getBaseBuilder().add("id",String.valueOf(mStreamCameraBean.getId())).add(
                        "typeId",String.valueOf(typeId)).add("isYuntai",String.valueOf(isYuntai)).build(),
                        MyDeviceContract.SAVE_CONFIG);

                break;
            default:
                break;
            case R.id.has_yun_iv:
                isYuntai = 0;
                mHasYunIv.setImageResource(R.mipmap.select_circle_true_blue);
                mUnHasYunIv.setImageResource(R.mipmap.select_circle_false_icon);
                break;
            case R.id.un_has_yun_iv:
                isYuntai = 1;
                mHasYunIv.setImageResource(R.mipmap.select_circle_false_icon);
                mUnHasYunIv.setImageResource(R.mipmap.select_circle_true_blue);
                break;
        }
    }

}
