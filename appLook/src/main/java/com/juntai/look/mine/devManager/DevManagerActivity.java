package com.juntai.look.mine.devManager;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.base.ViewPagerAdapter;
import com.juntai.look.base.customView.CustomViewPager;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDevContentFragment;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.AllGroupsActivity;
import com.juntai.look.homePage.mydevice.allGroup.GroupSetActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.wisdom.basecomponent.utils.LiveDataManager;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  设备管理
 * @date 2020/7/16 17:56
 */
public class DevManagerActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        ViewPager.OnPageChangeListener, View.OnClickListener {


    private TabLayout mTablayout;
    private CustomViewPager mViewpager;
    List<Fragment> mFragments = new ArrayList<>();
    private ViewPagerAdapter adapter;
    /**
     * 28个摄像头
     */
    private TextView mDevTotalAmountTv;
    private ImageView mMoreFuctionIv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_my_dev_manager;
    }

    @Override
    public void initView() {
        setTitleName("设备管理");
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewpager = (CustomViewPager) findViewById(R.id.viewpager);
        mDevTotalAmountTv = (TextView) findViewById(R.id.dev_total_amount_tv);
        mMoreFuctionIv = (ImageView) findViewById(R.id.more_fuction_iv);
        mMoreFuctionIv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        List<CameraGroupBean.DataBean> titleArrays = Hawk.get(HawkProperty.CAMERA_GROUP);
        mFragments.clear();
        if (titleArrays == null) {
            return;
        }
        List<String> titles = new ArrayList<>();
        for (CameraGroupBean.DataBean titleArray : titleArrays) {
            mFragments.add(DevManagerFragment.newInstance(titleArray.getId()));
            titles.add(titleArray.getName());
        }
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), mContext, titles, mFragments);
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(titleArrays.size());
        /*viewpager切换监听，包含滑动点击两种*/
        mViewpager.addOnPageChangeListener(this);
        mTablayout.setupWithViewPager(mViewpager);
        initTablayoutView(0, adapter);
        /*viewpager切换默认第一个*/
        mViewpager.setCurrentItem(0);
    }

    /**
     * 添加自定义tab布局
     */
    private void initTablayoutView(int currentPosition, ViewPagerAdapter adapter) {

        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            if (tab != null) {
                View view = tab.getCustomView();
                if (view == null) {
                    view = adapter.getTabViewNoPic(i);
                    tab.setCustomView(view);
                }
                TextView titleTv = view.findViewById(R.id.tabitem_text);
                if (i == currentPosition) {
                    titleTv.setTextSize(22);
                } else {
                    titleTv.setTextSize(14);
                }
            }
        }
    }

    @Override
    public void onSuccess(String tag, Object o) {
    }

    @Override
    public void onError(String tag, Object o) {
        super.onError(tag, o);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        initTablayoutView(i, adapter);

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.more_fuction_iv:
                startActivityForResult(new Intent(mContext, AllGroupsActivity.class),
                        AllGroupsActivity.ALL_GROUPS_RESULT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (AllGroupsActivity.ALL_GROUPS_RESULT == resultCode) {
            if (data != null) {
                initData();
                int position = data.getIntExtra(AllGroupsActivity.ALL_GROUPS_POSITION, 0);
                mViewpager.setCurrentItem(position);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
