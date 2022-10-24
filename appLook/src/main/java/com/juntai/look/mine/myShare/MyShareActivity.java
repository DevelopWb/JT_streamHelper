package com.juntai.look.mine.myShare;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.mine.MyShareBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  我的分享
 * @date 2020/9/12 14:27
 */
public class MyShareActivity extends BaseAppActivity<MinePresent> implements MineContract.IMineView,
        View.OnClickListener {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private MyShareAdapter adapter;
    private TextView mDeleteTv;
    private int currentPage = 1;//当前的页码
    private int pageSize = 12;//一次显示多少条

    @Override
    protected MinePresent createPresenter() {
        return new MinePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_my_share;
    }

    @Override
    public void initView() {
        setTitleName("我的分享");
        getTitleRightTv().setText("编辑");
        getTitleRightTv().setOnClickListener(this);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        adapter = new MyShareAdapter(R.layout.my_share_item);
        adapter.setEmptyView(getAdapterEmptyView("一条分享记录都没有,快去分享吧",0));
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        mDeleteTv = (TextView) findViewById(R.id.bt_tv);
        mDeleteTv.setText("删除");
        mDeleteTv.setOnClickListener(this);
        mSmartrefreshlayout.setOnRefreshListener(refreshLayout -> {
            currentPage = 1;
            initData();
        });
        mSmartrefreshlayout.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            initData();
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MyShareBean.DataBean.DatasBean bean = (MyShareBean.DataBean.DatasBean) adapter.getData().get(position);
                if (bean.isEdit()) {
                    if (bean.isSelected()) {
                        bean.setSelected(false);
                    } else {
                        bean.setSelected(true);
                    }
                    adapter.notifyItemChanged(position);
                } else {
                    startActivity(new Intent(mContext.getApplicationContext(), PlayerLiveActivity.class)
                            .putExtra(PlayerLiveActivity.STREAM_CAMERA_ID, bean.getVideoId())
                            .putExtra(PlayerLiveActivity.STREAM_CAMERA_THUM_URL, bean.getEzopen())
                            .putExtra(PlayerLiveActivity.STREAM_CAMERA_NUM, bean.getNumber()));
                }

            }
        });
    }


    @Override
    public void initData() {
        mPresenter.myShare(getBaseBuilder().add("currentPage", String.valueOf(currentPage)).add("pageSize",
                String.valueOf(pageSize)).build(), MyDeviceContract.MY_SHARE);
    }


    @Override
    public void onSuccess(String tag, Object o) {
        mSmartrefreshlayout.finishRefresh();
        mSmartrefreshlayout.finishLoadMore();
        switch (tag) {
            case MyDeviceContract.DEL_MY_SHARE:
                ToastUtils.toast(mContext, "删除成功");
                initRightTv(View.GONE, "编辑", false);
                initData();
                break;
            case MyDeviceContract.MY_SHARE:
                MyShareBean myShareBean = (MyShareBean) o;
                if (myShareBean != null) {
                    MyShareBean.DataBean dataBean = myShareBean.getData();
                    if (dataBean != null) {
                        List<MyShareBean.DataBean.DatasBean> arrays = dataBean.getDatas();
                        if (arrays != null&&arrays.size()>0) {
                            getTitleRightTv().setVisibility(View.VISIBLE);
                            if (currentPage == 1) {
                                adapter.setNewData(arrays);
                            } else {
                                if (arrays.size() < pageSize) {
                                    mSmartrefreshlayout.finishLoadMoreWithNoMoreData();
                                } else {
                                    mSmartrefreshlayout.setNoMoreData(false);
                                }
                                adapter.addData(arrays);
                            }

                        }else {
                            adapter.setNewData(null);
                            getTitleRightTv().setVisibility(View.GONE);
                        }
                    }
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_rightTv:
                if ("编辑".equals(getTextViewValue(getTitleRightTv()))) {
                    //编辑按钮
                    //显示选择控件
                    //显示删除按钮
                    initRightTv(View.VISIBLE, "完成", true);

                } else {
                    //隐藏选择控件
                    //隐藏删除按钮
                    initRightTv(View.GONE, "编辑", false);
                }

                break;
            case R.id.bt_tv:
                //删除按钮
                List<MyShareBean.DataBean.DatasBean> arrays = adapter.getData();
                StringBuilder sb = new StringBuilder(arrays.size());
                String ids = null;
                for (MyShareBean.DataBean.DatasBean array : arrays) {
                    if (array.isSelected()) {
                        sb.append(array.getId() + ",");
                    }
                }
                if (sb.toString().length() > 0) {
                    ids = sb.toString().substring(0, sb.toString().length() - 1);
                }
                if (ids != null) {
                    mPresenter.delShare(getBaseBuilder().add("id", ids).build(), MyDeviceContract.DEL_MY_SHARE);
                }

                break;
            default:
                break;
        }
    }

    /**
     *
     * @param gone
     * @param edit
     * @param b
     */
    private void initRightTv(int gone, String edit, boolean b) {
        mDeleteTv.setVisibility(gone);
        getTitleRightTv().setText(edit);
        List<MyShareBean.DataBean.DatasBean> arrays = adapter.getData();
        for (MyShareBean.DataBean.DatasBean array : arrays) {
            array.setEdit(b);
        }
        adapter.notifyDataSetChanged();
    }
}
