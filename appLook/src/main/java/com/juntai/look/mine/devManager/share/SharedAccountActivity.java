package com.juntai.look.mine.devManager.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.SharedUserBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  分享至账号
 * @date 2020/9/14 17:45
 */
public class SharedAccountActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView
        , View.OnClickListener {

    /**
     * 搜索用户名或账号
     */
    private TextView mSearchUsersTv;
    private RecyclerView mAddedUsersRv;
    /**
     * 取消分享
     */
    private TextView mCancelShareTv;
    private AccountAdapter adapter;
    /**
     * 已添加
     */
    private TextView mAddedUsersTv;
    private String cameraNum;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_share_to_account;
    }

    @Override
    public void initView() {
        setTitleName("分享到账号");
        mSearchUsersTv = (TextView) findViewById(R.id.search_users_tv);
        mSearchUsersTv.setOnClickListener(this);
        mAddedUsersRv = (RecyclerView) findViewById(R.id.added_users_rv);
        mCancelShareTv = (TextView) findViewById(R.id.cancel_share_tv);
        mCancelShareTv.setOnClickListener(this);
        adapter = new AccountAdapter(R.layout.account_item);
        initRecyclerview(mAddedUsersRv, adapter, LinearLayoutManager.VERTICAL);
        mAddedUsersTv = (TextView) findViewById(R.id.added_users_tv);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SharedUserBean.DataBean bean = (SharedUserBean.DataBean) adapter.getData().get(position);
                int id = bean.getId();
                new AlertDialog.Builder(mContext).setMessage("是否移除当前账号？")
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //移除
                        mPresenter.delShareAccount(getBaseBuilder().add("id", String.valueOf(id)).build(),
                                MyDeviceContract.DEL_ACCOUNT);
                    }
                }).show();

            }
        });
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            cameraNum = getIntent().getStringExtra(BaseCameraSetActivity.CAMERA_NUM);
            mPresenter.getSharedUserList(getBaseBuilder().add("number", cameraNum).build(),
                    MyDeviceContract.SHARED_USERS);
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initData();
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.SHARED_USERS:
                SharedUserBean sharedUserBean = (SharedUserBean) o;
                if (sharedUserBean != null) {
                    List<SharedUserBean.DataBean> arrays = sharedUserBean.getData();
                    if (arrays != null && arrays.size() > 0) {
                        adapter.setNewData(arrays);
                        mCancelShareTv.setVisibility(View.VISIBLE);
                        mAddedUsersTv.setVisibility(View.VISIBLE);
                    } else {
                        adapter.setNewData(null);
                        mCancelShareTv.setVisibility(View.GONE);
                        mAddedUsersTv.setVisibility(View.GONE);
                    }
                }
                break;
            case MyDeviceContract.DEL_ACCOUNT:
                initData();
                ToastUtils.toast(mContext, "移除成功");
                break;
            case MyDeviceContract.CANCEL_DEV:
                ToastUtils.toast(mContext, "已取消");
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
            case R.id.search_users_tv:
                //搜索用户
                startActivity(new Intent(mContext, SearchAccountToShareActivity.class));
                break;
            case R.id.cancel_share_tv:
                //取消分享
                new AlertDialog.Builder(mContext)
                        .setMessage("是否取消？")
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mPresenter.cancelShareAccount(getBaseBuilder().add("number", cameraNum).build(),
                                MyDeviceContract.CANCEL_DEV);
                    }
                }).show();
                break;
        }
    }

}
