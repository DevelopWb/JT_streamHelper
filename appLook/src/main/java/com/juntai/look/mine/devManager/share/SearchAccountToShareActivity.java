package com.juntai.look.mine.devManager.share;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.SharedUserBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  搜索要分享的账号
 * @date 2020/9/14 17:47
 */
public class SearchAccountToShareActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {

    private RecyclerView mUsersRv;
    private SearchView mSearchContentSv;
    private SearchedAccountAdapter adapter;
    /**
     * 账号
     */
    private TextView mAccountTagTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_select_account_to_share;
    }

    @Override
    public void initView() {

        setTitleName("分享账号搜索");
        mUsersRv = (RecyclerView) findViewById(R.id.users_rv);
        adapter = new SearchedAccountAdapter(R.layout.account_item);
        initRecyclerview(mUsersRv, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SharedUserBean.DataBean bean = (SharedUserBean.DataBean) adapter.getData().get(position);
                startActivity(new Intent(mContext, AddAccountToShareActivity.class).putExtra(PUBLIC_OBJECT_KEY,bean));
            }
        });
        mSearchContentSv = (SearchView) findViewById(R.id.search_content_sv);
        SearchView.SearchAutoComplete textView =
                (SearchView.SearchAutoComplete) mSearchContentSv.findViewById(R.id.search_src_text);
        textView.setTextSize(14);
        mSearchContentSv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!StringTools.isStringValueOk(s)) {
                    ToastUtils.toast(mContext, "请输入用户名或账号");
                    return false;
                } else {
                    mPresenter.getUserListToShare(getBaseBuilder().add("keyword", s).build(), "");
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        mAccountTagTv = (TextView) findViewById(R.id.account_tag_tv);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSuccess(String tag, Object o) {
        releaseFocuse(mSearchContentSv);
        SharedUserBean sharedUserBean = (SharedUserBean) o;
        if (sharedUserBean != null) {
            List<SharedUserBean.DataBean> arrays = sharedUserBean.getData();
            if (arrays != null && arrays.size() > 0) {
                adapter.setNewData(arrays);
                mAccountTagTv.setVisibility(View.VISIBLE);
            } else {
                mAccountTagTv.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }

}
