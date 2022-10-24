package com.juntai.look.homePage.mydevice.allGroup.transferDev;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.juntai.look.mine.devManager.DevManagerFragment;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.wisdom.basecomponent.base.BaseMvpFragment;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  转入设备
 * @CreateDate: 2020/8/21 17:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/21 17:14
 */
public class TransferDevFragment extends BaseAppFragment<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {


    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private TransferDevAdapter adapter;
    private TextView mConfirmTv;

    public static TransferDevFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("groupId", type);
        TransferDevFragment fragment = new TransferDevFragment();
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
        return R.layout.fragment_transfer_dev;
    }

    @Override
    protected void initView() {

        mRecyclerview = (RecyclerView) getView(R.id.recyclerview);
        mConfirmTv = (TextView) getView(R.id.confirm_tv);
        mConfirmTv.setOnClickListener(this);
        mSmartrefreshlayout = (SmartRefreshLayout) getView(R.id.smartrefreshlayout);
        adapter = new TransferDevAdapter(R.layout.cameras_of_group_item);
        adapter.setEmptyView(getBaseActivity().getAdapterEmptyView("一个设备也没有",0));
        getBaseActivity().initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                DevListBean.DataBean.ListBean bean = (DevListBean.DataBean.ListBean) adapter.getData().get(position);
                if (bean.isSelected()) {
                    bean.setSelected(false);
                } else {
                    bean.setSelected(true);
                }
                adapter.notifyItemChanged(position);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {

        switch (tag) {
            case MyDeviceContract.TRANSFER_DEV:
                ToastUtils.toast(mContext, "转入成功");
                ((TransferDevActivity)getActivity()).activityFinish();
                break;
            default:
                DevListBean devListBean = (DevListBean) o;
                if (devListBean != null) {
                    DevListBean.DataBean dataBean = devListBean.getData();
                    if (dataBean != null) {
                        List<DevListBean.DataBean.ListBean> arrays = dataBean.getList();
                        if (arrays != null) {
                            if (arrays.size() > 0) {
                                mConfirmTv.setVisibility(View.VISIBLE);
                            } else {
                                mConfirmTv.setVisibility(View.GONE);
                            }
                            adapter.setNewData(arrays);
                        }

                    }
                }
                break;
        }


    }

    @Override
    public void onError(String tag, Object o) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm_tv:
                List<DevListBean.DataBean.ListBean> arrays = adapter.getData();
                StringBuffer sb = new StringBuffer();
                for (DevListBean.DataBean.ListBean array : arrays) {
                    if (array.isSelected()) {
                        sb.append(String.valueOf(array.getId()) + ",");
                    }
                }
                if (sb.length() > 0) {
                    String id = sb.deleteCharAt(sb.length() - 1).toString();
                    int groupId = Hawk.get(HawkProperty.CURRENT_GROUPID, 1);
                    mPresenter.transferDev(getBaseAppActivity().getBaseBuilder().add("id", id).add("groupId",
                            String.valueOf(groupId)).build(), MyDeviceContract.TRANSFER_DEV);
                } else {
                    ToastUtils.toast(mContext, "请选择需要转入的摄像头");

                }
                break;
            default:
                break;
        }
    }
}
