package com.juntai.look.homePage.mydevice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  我的设备
 * @CreateDate: 2020/8/21 17:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/21 17:14
 */
public class MyDevContentFragment extends BaseAppFragment<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {


    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private MyDevAdapter adapter;
    /**
     * 共28个摄像头
     */
    private TextView mDevTotalAmountTv;

    public static MyDevContentFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("groupId", type);
        MyDevContentFragment fragment = new MyDevContentFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    protected void lazyLoad() {
        int groupId = getArguments().getInt("groupId");
        mPresenter.getDevsOfGroup(getBaseAppActivity().getBaseBuilder().add("id", String.valueOf(groupId)).build(), "");
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.dev_content;
    }

    @Override
    protected void initView() {

        mRecyclerview = (RecyclerView) getView(R.id.recyclerview);
        mDevTotalAmountTv = (TextView) getView(R.id.dev_total_amount_tv);
        mSmartrefreshlayout = (SmartRefreshLayout) getView(R.id.smartrefreshlayout);
        mSmartrefreshlayout.setEnableLoadMore(false);
        mSmartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                lazyLoad();
            }
        });
        adapter = new MyDevAdapter(R.layout.my_dev_item);
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(manager);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                DevListBean.DataBean.ListBean bean = (DevListBean.DataBean.ListBean) adapter.getData().get(position);
                if (1 == bean.getDvrFlag()) {
                    String num = bean.getNumber();
                    //硬盘录像机
                    startActivity(new Intent(mContext, NVRDevDetailActivity.class).putExtra(NVRDevDetailActivity.NVR_NUM, num)
                            .putExtra(NVRDevDetailActivity.NVR_NAME, bean.getName())
                            );
                } else {
                    startActivity(new Intent(mContext.getApplicationContext(), PlayerLiveActivity.class)
                            .putExtra(PlayerLiveActivity.STREAM_CAMERA_ID, bean.getId())
                            .putExtra(PlayerLiveActivity.STREAM_CAMERA_THUM_URL, bean.getEzopen())
                            .putExtra(PlayerLiveActivity.STREAM_CAMERA_NUM, bean.getNumber()));
                }

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {
        mSmartrefreshlayout.finishRefresh();
        DevListBean devListBean = (DevListBean) o;
        if (devListBean != null) {
            DevListBean.DataBean dataBean = devListBean.getData();
            if (dataBean != null) {
                List<DevListBean.DataBean.ListBean> arrays = dataBean.getList();
                if (arrays != null) {
                    adapter.setNewData(arrays);
                    mDevTotalAmountTv.setText(String.format("%s%s%s", "共", String.valueOf(arrays.size()), "个设备"));
                }

            }
        }


    }

    @Override
    public void onError(String tag, Object o) {

    }

}
