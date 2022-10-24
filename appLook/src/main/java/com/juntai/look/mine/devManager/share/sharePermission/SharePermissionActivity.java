package com.juntai.look.mine.devManager.share.sharePermission;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.PermissionListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  分享的权限
 * @date 2020/9/14 17:52
 */
public class SharePermissionActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    /**
     * 保存
     */
    private TextView mSaveTv;
    private SharePermissionAdapter adapter;
    public static String PREMISSION = "permission";
    public static String PREMISSION_NAMES = "permissionName";

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_share_permission;
    }

    @Override
    public void initView() {
        setTitleName("分享权限设置");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        mSmartrefreshlayout.setEnableLoadMore(false);
        mSmartrefreshlayout.setEnableRefresh(false);
        adapter = new SharePermissionAdapter(R.layout.select_group_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        mSaveTv = (TextView) findViewById(R.id.save_tv);
        mSaveTv.setOnClickListener(this);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                PermissionListBean.DataBean.ListBean bean =
                        (PermissionListBean.DataBean.ListBean) adapter.getData().get(position);
                if (PlayContract.PERMISSION_PLAY.equals(bean.getName())) {
                    ToastUtils.toast(mContext,"此权限不可取消");
                    return;
                }
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
    public void initData() {
        mPresenter.getPermissionList(getBaseBuilder().build(), "");
    }


    @Override
    public void onSuccess(String tag, Object o) {
        PermissionListBean permissionListBean = (PermissionListBean) o;
        if (permissionListBean != null) {
            List<PermissionListBean.DataBean> types = permissionListBean.getData();
            if (types != null) {
                if (types.size() > 0) {
                    PermissionListBean.DataBean bean = types.get(0);
                    List<PermissionListBean.DataBean.ListBean> arrays = bean.getList();
                    for (int i = 0; i < arrays.size(); i++) {
                        if (0 == i) {
                            arrays.get(0).setSelected(true);
                        }
                    }

                    adapter.setNewData(arrays);
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.save_tv:
                List<PermissionListBean.DataBean.ListBean> arrays = adapter.getData();
                StringBuilder sb = new StringBuilder(arrays.size());
                StringBuilder sbName = new StringBuilder(arrays.size());
                String ids = null;
                String names = null;
                for (PermissionListBean.DataBean.ListBean array : arrays) {
                    if (array.isSelected()) {
                        sb.append(array.getId() + ",");
                        sbName.append(array.getName() + ",");
                    }
                }
                if (sb.toString().length() > 0) {
                    ids = sb.toString().substring(0, sb.toString().length() - 1);
                }
                if (sbName.toString().length() > 0) {
                    names = sbName.toString().substring(0, sbName.toString().length() - 1);
                }
                Intent intent = new Intent();
                intent.putExtra(PREMISSION, ids);
                intent.putExtra(PREMISSION_NAMES, names);
                setResult(BASE_REQUESR, intent);
                finish();
                break;
        }
    }
}
