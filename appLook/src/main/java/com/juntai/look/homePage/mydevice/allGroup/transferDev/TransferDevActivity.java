package com.juntai.look.homePage.mydevice.allGroup.transferDev;

import android.os.Bundle;
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
import com.juntai.look.homePage.mydevice.MyDeviceFragment;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.devManager.DevManagerFragment;
import com.juntai.look.uitils.HawkProperty;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  转移设备
 * @date 2020/9/3 11:41
 */
public class TransferDevActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        ViewPager.OnPageChangeListener, View.OnClickListener {

    private TabLayout mTablayout;
    private CustomViewPager mViewpager;
    List<Fragment> mFragments = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private ImageView mAppBackIv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_transfer_dev;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
        //状态栏配置
        mBaseRootCol.setFitsSystemWindows(true);
        mImmersionBar.reset().transparentStatusBar().statusBarDarkFont(true).init();
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewpager = (CustomViewPager) findViewById(R.id.viewpager);
        mAppBackIv = (ImageView) findViewById(R.id.app_back_iv);
        mAppBackIv.setOnClickListener(this);
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
            mFragments.add(TransferDevFragment.newInstance(titleArray.getId()));
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

    public void  activityFinish(){
        super.onBackPressed();
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
            case R.id.app_back_iv:
                activityFinish();
                break;
        }
    }
}
