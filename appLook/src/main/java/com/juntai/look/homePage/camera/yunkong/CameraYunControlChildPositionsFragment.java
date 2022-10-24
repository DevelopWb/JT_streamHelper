package com.juntai.look.homePage.camera.yunkong;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.bean.stream.PreSetBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.camera.PlayPresent;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.look.uitils.StringTools;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  云控 收藏的位置
 * @CreateDate: 2020/8/14 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/14 9:23
 */
public class CameraYunControlChildPositionsFragment extends BaseAppFragment<PlayPresent> implements PlayContract.IPlayView, View.OnClickListener {
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    /**
     * 编辑
     */
    private TextView mEditSavedPositionTv;
    private String mCameraNum;
    private CameraPrePositionAdapter adapter;
    private PreSetBean.DataBean currentDataBean;

    @Override
    protected PlayPresent createPresenter() {
        return new PlayPresent();
    }

    @Override
    protected void lazyLoad() {
        mCameraNum = ((PlayerLiveActivity) getActivity()).getStreamCameraNum();
        if (StringTools.isStringValueOk(mCameraNum)) {
            mPresenter.getPrePositions(mPresenter.getPublishMultipartBody().addFormDataPart("number",
                    String.valueOf(mCameraNum)).build(), PlayContract.GET_PRE_POSITIONS);
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_camera_yun_control_child_position;
    }

    @Override
    protected void initView() {

        mRecyclerview = (RecyclerView) getView(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) getView(R.id.smartrefreshlayout);
        mSmartrefreshlayout.setEnableLoadMore(false);
        mSmartrefreshlayout.setEnableRefresh(false);
        mEditSavedPositionTv = (TextView) getView(R.id.edit_saved_position_tv);
        mEditSavedPositionTv.setOnClickListener(this);

        adapter = new CameraPrePositionAdapter(R.layout.yun_property_item);
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        mRecyclerview.setLayoutManager(manager);
        mRecyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                currentDataBean = (PreSetBean.DataBean) adapter.getData().get(position);
                if (!currentDataBean.isEdit()) {
                    //调用预置位
                    mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_CALL_POS, currentDataBean.getPosition(),
                            mCameraNum, PlayContract.CALL_PRE_POSITION);
                } else {
                    //删除预置位
                    new AlertDialog.Builder(mContext).setMessage("是否删除当前预置位？")
                            .setNegativeButton("否", null)
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mPresenter.delPrePosition(mPresenter.getPublishMultipartBody().addFormDataPart("id",
                                            String.valueOf(currentDataBean.getId())).build(),
                                            PlayContract.DEL_PRE_POSITION);
                                }
                            }).show();

                }
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case PlayContract.GET_PRE_POSITIONS:
                //获取预置位列表
                PreSetBean preSetBean = (PreSetBean) o;
                List<PreSetBean.DataBean> arrays = preSetBean.getData();
                List<PreSetBean.DataBean> data = new ArrayList<>();
                if (arrays != null) {
                    for (PreSetBean.DataBean array : arrays) {
                        if (StringTools.isStringValueOk(array.getPicture())) {
                            if ("编辑".equals(mEditSavedPositionTv.getText().toString().trim())) {
                                array.setEdit(false);
                            } else {
                                array.setEdit(true);
                            }
                            data.add(array);
                        }
                    }
                }
                adapter.setNewData(data);
                break;

            case PlayContract.DEL_PRE_POSITION:
                mPresenter.getPrePositions(mPresenter.getPublishMultipartBody().addFormDataPart("number",
                        String.valueOf(mCameraNum)).build(), PlayContract.GET_PRE_POSITIONS);
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
            case R.id.edit_saved_position_tv:
                //编辑
                if ("编辑".equals(mEditSavedPositionTv.getText().toString().trim())) {
                    initEditView("完成", true);
                } else {
                    initEditView("编辑", false);
                }

                break;
        }
    }

    /**
     * 初始化编辑按钮
     *
     * @param editContent
     * @param b
     */
    private void initEditView(String editContent, boolean b) {
        List<PreSetBean.DataBean> arrays = adapter.getData();
        if (arrays.size() > 0) {
            mEditSavedPositionTv.setText(editContent);
            for (PreSetBean.DataBean array : arrays) {
                array.setEdit(b);
            }
            adapter.notifyDataSetChanged();
        }
    }
}
