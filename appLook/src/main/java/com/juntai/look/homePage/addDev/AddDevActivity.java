package com.juntai.look.homePage.addDev;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;

import com.baidu.location.BDLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.QRScanActivity;
import com.juntai.look.homePage.addDev.nvr.AddNvrDevActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  添加设备
 * @date 2020/9/1 15:22
 */
public class AddDevActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private ImageView mScanDevIv;
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private long currentTime;
    private SearchView mSearchContentSv;
    private AddDevAdapter adapter;
    private int currentPage = 1;//当前的页码
    private int pageSize = 12;//一次显示多少条

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_add_dev;
    }


    @Override
    public void initView() {
        setTitleName("添加设备");
        mScanDevIv = (ImageView) findViewById(R.id.scan_dev_iv);
        mScanDevIv.setOnClickListener(this);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        mSearchContentSv = (SearchView) findViewById(R.id.search_content_sv);
        SearchView.SearchAutoComplete textView =
                (SearchView.SearchAutoComplete) mSearchContentSv.findViewById(R.id.search_src_text);
        textView.setTextSize(12);
        adapter = new AddDevAdapter(R.layout.add_dev_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                DevToAddBean.DataBean.DatasBean datasBean =
                        (DevToAddBean.DataBean.DatasBean) adapter.getData().get(position);
                int bingflag = datasBean.getBindingFlag();
                if (1 == bingflag) {
                    //已绑定
                    ToastUtils.toast(mContext, "已绑定");
                } else {
                    String typeCode = datasBean.getTypeCode();
                    if ("132".equals(typeCode)) {
                        //设备类型是摄像头
                        startActivityForResult(new Intent(mContext, AddNornalCameraActivity.class).putExtra(BaseAddDevActivity.DEV_INFO,datasBean),
                                BASE_REQUESR);
                    } else if ("118".equals(typeCode)) {
                        //nvr
                        startActivityForResult(new Intent(mContext, AddNvrDevActivity.class).putExtra(BaseAddDevActivity.DEV_INFO,datasBean),
                                BASE_REQUESR);
                    } else {
                        startActivity(new Intent(mContext, AddNornalCameraActivity.class));
                    }
                }

            }
        });
        mSmartrefreshlayout.setOnRefreshListener(refreshLayout -> {
            currentPage = 1;
            initData(currentPage, true);
        });
        mSmartrefreshlayout.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            initData(currentPage, true);
        });
        mSearchContentSv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!StringTools.isStringValueOk(s)) {
                    ToastUtils.warning(mContext, "请输入设备序列号");
                    return false;
                } else {
                    currentPage = 1;
                    initData(currentPage, true);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public void initData() {
        currentPage = 1;
        initData(currentPage, false);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initData();
    }

    private void initData(int currentPage, boolean showToast) {
        String keyWord = mSearchContentSv.getQuery().toString();
        if (StringTools.isStringValueOk(keyWord)) {
            mPresenter.searchDevByNum(getBaseBuilder().add("keyword", keyWord).add("currentPage",
                    String.valueOf(currentPage)
            ).add("pageSize", String.valueOf(pageSize)).build(), "");
        } else {
            if (showToast) {
                ToastUtils.toast(mContext, "请输入设备序列号");
                mSmartrefreshlayout.finishRefresh();
                mSmartrefreshlayout.finishLoadMore();
            }
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        releaseFocuse(mSearchContentSv);
        mSmartrefreshlayout.finishRefresh();
        mSmartrefreshlayout.finishLoadMore();
        DevToAddBean devListBean = (DevToAddBean) o;
        if (devListBean != null) {
            DevToAddBean.DataBean dataBean = devListBean.getData();
            if (dataBean != null) {
                List<DevToAddBean.DataBean.DatasBean> arrays = dataBean.getDatas();
                if (arrays != null) {
                    if (currentPage == 1) {
                        adapter.setNewData(arrays);
                        adapter.setEmptyView(getAdapterEmptyView("很遗憾，没有相符的设备", 0));
                    } else {
                        if (arrays.size() < pageSize) {
                            mSmartrefreshlayout.finishLoadMoreWithNoMoreData();
                        } else {
                            mSmartrefreshlayout.setNoMoreData(false);
                        }
                        adapter.addData(arrays);
                    }

                }

            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.scan_dev_iv:
                //todo 二维码扫描
                ToastUtils.toast(mContext,"暂不支持");
//                if ((System.currentTimeMillis() - currentTime) < 800) {
//                    return;
//                }
//                currentTime = System.currentTimeMillis();
//                startActivity(new Intent(mContext,
//                        QRScanActivity.class));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR==requestCode) {
            initData();
        }
    }
}
