package com.juntai.look.mine.myMsg;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.MultipleItem;
import com.juntai.look.bean.mine.MyMsgBean;
import com.juntai.look.hcb.R;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  我的消息
 * @date 2020/7/28 11:50
 */
public class MyMsgActivity extends BaseAppActivity<MinePresent> implements MineContract.IMineView {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private MyMsgAdapter adapter;
    protected int currentPage = 1;
    protected int limit = 10;
    private MyMsgBean.DataBean.DatasBean currentBean;
    private int currentPosition;

    public static int IS_READ_RESULT = 1004;//已读

    @Override
    protected MinePresent createPresenter() {
        return new MinePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.recycleview_layout;
    }

    @Override
    public void initView() {
        setTitleName("我的消息");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        adapter = new MyMsgAdapter(null);
        adapter.setEmptyView(getAdapterEmptyView(getString(R.string.none_message), R.mipmap.none_message));
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getAdapterdata());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                currentBean = (MyMsgBean.DataBean.DatasBean) adapter.getData().get(position);
                currentPosition = position;
            }
        });
    }


    private List<MultipleItem> getAdapterdata() {
        List<MultipleItem> arrays = new ArrayList<>();
        arrays.add(new MultipleItem(MultipleItem.ITEM_TITLE, "系统消息"));
        for (String testDatum : getTestData()) {
            arrays.add(new MultipleItem(MultipleItem.ITEM_CONTENT, testDatum));
        }
        return arrays;
    }

    @Override
    public void initData() {
    }


    @Override
    public void onSuccess(String tag, Object o) {
        mSmartrefreshlayout.finishRefresh();
        mSmartrefreshlayout.finishLoadMore();
    }
}
