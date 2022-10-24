package com.juntai.look.homePage.search;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.MultipleItem;
import com.juntai.look.bean.search.SearchBean;
import com.juntai.look.bean.search.SearchMoreBean;
import com.juntai.look.bean.search.SearchResultBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.HomePageContract;
import com.juntai.look.homePage.HomePagePresent;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.look.homePage.mydevice.NVRDevDetailActivity;
import com.juntai.look.main.MainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;


/**
 * @aouther tobato
 * @description 描述  搜索
 * @date 2020/3/14 14:47
 */
public class SearchActivity extends BaseAppActivity<HomePagePresent> implements HomePageContract.IHomePageView,
        View.OnClickListener, SearchFragment.OnSearchCallBack {

    private SearchFragment searchTopFragment;
    //tab条目中的内容
    // 0：监控1：分组
    public final static int INFO_TYPE_CAMERA = 1;//监控
    public final static int INFO_TYPE_GROUP = 2;//group
    private RecyclerView mSearchInfoRv;
    private SmartRefreshLayout mSearchRfl;
    private SearchAdapter searchAdapter;
    private String textContent;
    private int limit = 10;//默认条数
    private int insertPosition;//插入的位置

    @Override
    public int getLayoutView() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
        mBaseRootCol.setFitsSystemWindows(true);
        mImmersionBar.statusBarColor(com.juntai.wisdom.basecomponent.R.color.white).statusBarDarkFont(true).init();
        searchTopFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_serach_top);
        mSearchInfoRv = (RecyclerView) findViewById(R.id.search_info_rv);
        mSearchRfl = (SmartRefreshLayout) findViewById(R.id.search_srl);
        mSearchRfl.setEnableLoadMore(false);
        searchAdapter = new SearchAdapter(null);
        initRecyclerview(mSearchInfoRv, searchAdapter, LinearLayoutManager.VERTICAL);
    }

    @Override
    public void initData() {
        mSearchRfl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.search(getBaseBuilder().add("keyword", textContent).build(),
                        HomePageContract.SEARCH);
            }
        });
        searchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleItem multipleItem = (MultipleItem) adapter.getItem(position);
                switch (multipleItem.getItemType()) {
                    case MultipleItem.ITEM_TITLE:
                        break;
                    case MultipleItem.ITEM_CONTENT:
                        SearchBean.DataBean.SearchListBean databean = (SearchBean.DataBean
                                .SearchListBean) multipleItem.getObject();
                        switch (databean.getResultType()) {
                            case INFO_TYPE_CAMERA:
                                //0是监控 1是nvr
                                int flag = databean.getDvrFlag();
                                if (0 == flag) {
                                    startActivity(new Intent(mContext
                                            .getApplicationContext(), PlayerLiveActivity.class)
                                            .putExtra(PlayerLiveActivity
                                                    .STREAM_CAMERA_ID, databean
                                                    .getId())
                                            .putExtra(PlayerLiveActivity
                                                            .STREAM_CAMERA_THUM_URL,
                                                    databean.getEzopen())
                                            .putExtra(PlayerLiveActivity
                                                    .STREAM_CAMERA_NUM, databean
                                                    .getNumber()));
                                } else {
                                    String num = databean.getNumber();
                                    startActivity(new Intent(mContext, NVRDevDetailActivity.class).putExtra(NVRDevDetailActivity.NVR_NUM, num)
                                            .putExtra(NVRDevDetailActivity.NVR_NAME, databean.getName()));
                                }
                                break;
                            case INFO_TYPE_GROUP:
                                //跳转到列表模式
                                startActivity(new Intent(mContext, MainActivity.class).putExtra(MainActivity.SEARCH_RESULT,databean.getName()));
                                break;
                            default:
                                break;
                        }
                        break;
                    case MultipleItem.ITEM_LOAD_MORE:
                        SearchMoreBean searchMoreBean = (SearchMoreBean) multipleItem.getObject();
                        String loadMoreMsg = searchMoreBean.getMsg();
                        if (getString(R.string.load_more).equals(loadMoreMsg)) {
                            insertPosition = position;
                            mPresenter.searchMore(getBaseBuilder().add("keyword", textContent).add("typeId",
                                    String.valueOf(searchMoreBean.getTypeId()))
                                            .add("startRow", String.valueOf(searchMoreBean.getCurrentOffset())).add(
                                            "pageSize", String.valueOf(limit)).build(),
                                    HomePageContract.SEARCH_MORE);
                        }
                        break;
                    default:
                        break;
                }


            }
        });
    }

    @Override
    protected HomePagePresent createPresenter() {
        return new HomePagePresent();
    }


    @Override
    public void onSuccess(String tag, Object o) {
        mSearchRfl.finishRefresh();
        switch (tag) {
            case HomePageContract.SEARCH:
                SearchBean searchBean = (SearchBean) o;
                if (searchBean != null) {
                    List<SearchBean.DataBean> item_des = searchBean.getData();
                    List<MultipleItem> multipleItems = new ArrayList<>();
                    if (item_des != null) {
                        for (SearchBean.DataBean item_de : item_des) {
                            List<SearchBean.DataBean.SearchListBean> itemMsgs = item_de.getSearchList();
                            if (itemMsgs != null && itemMsgs.size() > 0) {
                                int resultType = item_de.getTypeId();
                                multipleItems.add(new MultipleItem(MultipleItem.ITEM_TITLE, item_de));
                                for (SearchBean.DataBean.SearchListBean itemMsg : itemMsgs) {
                                    itemMsg.setResultType(resultType);
                                    multipleItems.add(new MultipleItem(MultipleItem.ITEM_CONTENT, itemMsg));
                                }
                                if (itemMsgs.size() < 3) {
                                    //没有更多数据了
                                    multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE,
                                            new SearchMoreBean(item_de.getTypeId(), 0,
                                                    getString(R.string.load_more_no_data))));
                                } else {
                                    if (item_de.getCount() != 3) {
                                        //总共3条数据
                                        multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE,
                                                new SearchMoreBean(item_de.getTypeId(), 3,
                                                        getString(R.string.load_more))));
                                    }

                                }
                            }

                        }
                    }
                    if (multipleItems.size() < 1) {
                        searchAdapter.setEmptyView(getAdapterEmptyView("很遗憾，没搜出相关信息", 0));
                    }
                    searchAdapter.setNewData(multipleItems);

                }
                break;
            case HomePageContract.SEARCH_MORE:
                SearchResultBean loadmoreBean = (SearchResultBean) o;
                if (loadmoreBean != null) {
                    SearchResultBean.DataBean dataBean = loadmoreBean.getData();
                    if (dataBean != null) {
                        List<SearchBean.DataBean.SearchListBean> list = dataBean.getDatas();
                        List<MultipleItem> multipleItems = new ArrayList<>();
                        for (SearchBean.DataBean.SearchListBean listBean : list) {
                            listBean.setResultType(dataBean.getTotal());
                            multipleItems.add(new MultipleItem(MultipleItem.ITEM_CONTENT, listBean));
                        }
                        if (list.size() < limit) {
                            //没有更多数据了
                            multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE,
                                    new SearchMoreBean(dataBean.getTotal(), 0, getString(R.string.load_more_no_data))));
                        } else {
                            multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE,
                                    new SearchMoreBean(dataBean.getTotal(), dataBean.getPageCount(),
                                            getString(R.string.load_more))));
                        }
                        searchAdapter.addData(insertPosition, multipleItems);
                        searchAdapter.remove(insertPosition + list.size() + 1);
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String tag, Object o) {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onSearch(String textContent) {
        this.textContent = textContent;
        mPresenter.search(getBaseBuilder().add("keyword", textContent).build(),
                HomePageContract.SEARCH);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        textContent = null;
    }

}
