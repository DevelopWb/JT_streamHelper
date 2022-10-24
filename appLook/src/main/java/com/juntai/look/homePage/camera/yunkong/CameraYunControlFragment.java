package com.juntai.look.homePage.camera.yunkong;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.MainPagerAdapter;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.camera.PlayPresent;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.wisdom.basecomponent.utils.PubUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  云台控制
 * @CreateDate: 2020/8/14 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/14 9:23
 */
public class CameraYunControlFragment extends BaseAppFragment<PlayPresent> implements PlayContract.IPlayView,
        View.OnClickListener {
    private TabLayout mYunControlTab;
    private ImageView mFinishIv;
    private ViewPager mYunControlVp;
    private String[] tabs = {"云台控制", "收藏位置"};

    @Override
    protected PlayPresent createPresenter() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_camera_yun_control;
    }

    @Override
    protected void initView() {

        mYunControlTab = (TabLayout) getView(R.id.yun_control_tab);
        mFinishIv = (ImageView) getView(R.id.finish_iv);
        mFinishIv.setOnClickListener(this);
        mYunControlVp = (ViewPager) getView(R.id.yun_control_vp);
        initViewPageWithTabLayout();
    }

    /**
     * viewpage和tablayout绑定数据
     */
    private void initViewPageWithTabLayout() {

        FragmentManager fragmentManager = getChildFragmentManager();//外面如果还有一层fragment时，使用这个方法
        //        FragmentManager fragmentManager = getSupportFragmentManager();//外面不是fragment包裹时，使用这个方法
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(fragmentManager,
                mContext,tabs, getFragments());
        mYunControlVp.setAdapter(pagerAdapter);
        mYunControlTab.setupWithViewPager(mYunControlVp);

        for (int i = 0; i < tabs.length; i++) {
            TabLayout.Tab tab = mYunControlTab.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(pagerAdapter.getTabViewNoPic(i));//自定义View

            }
        }
        //tab的字体选择器,默认黑色,选择时红色
        mYunControlTab.setTabTextColors(ContextCompat.getColor(mContext, R.color.black), ContextCompat.getColor(mContext,
                R.color.blue));
        //tab的下划线颜色,默认是粉红色
        mYunControlTab.setSelectedTabIndicatorColor(ContextCompat.getColor(mContext, R.color.black));
        //        //        //更改tab下划线的宽度
        //        PubUtil.setIndicator(mYunControlTab, 15, 15);
//        将tab下划线隐藏，也可以在xml里面配置高的值为0dp来实现隐藏
                mYunControlTab.setSelectedTabIndicatorHeight(0);

    }

    /**
     * 获取fragment
     *
     * @return
     */
    private SparseArray<Fragment> getFragments() {
        SparseArray<Fragment> fragments = new SparseArray<>();
        fragments.append(0,new CameraYunControlChildFragment());
        fragments.append(1,new CameraYunControlChildPositionsFragment());
        return fragments;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onError(String tag, Object o) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.finish_iv:
                ((PlayerLiveActivity) getActivity()).initControlBtStatus(0);
                break;
        }
    }
}
