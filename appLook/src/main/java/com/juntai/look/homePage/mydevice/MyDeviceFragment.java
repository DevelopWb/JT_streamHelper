package com.juntai.look.homePage.mydevice;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.base.ViewPagerAdapter;
import com.juntai.look.base.customView.CustomViewPager;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.QRScanActivity;
import com.juntai.look.homePage.addDev.AddDevActivity;
import com.juntai.look.homePage.mydevice.allGroup.AllGroupsActivity;
import com.juntai.look.homePage.search.SearchActivity;
import com.juntai.look.homePage.weather.WeatherActivity;
import com.juntai.look.homePage.weather.WeatherHelper;
import com.juntai.look.main.MainContract;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.base.BaseMvpFragment;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;
import com.juntai.wisdom.basecomponent.utils.LiveDataManager;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  我的设备（模式切换）
 * @date 2020/7/6 16:08
 */
public class MyDeviceFragment extends BaseAppFragment<MyDevicePresent> implements MainContract.IMainView,
        ViewPager.OnPageChangeListener, View.OnClickListener {
    private PopupWindow popupWindow;

    private TabLayout mTablayout;
    private CustomViewPager mViewpager;
    List<Fragment> mFragments = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private ImageView mWeatherIconIv;
    /**
     * 晴朗
     */
    private TextView mWeatherNameTv;
    /**
     * 20°C
     */
    private TextView mTemperatureTv;
    /**
     * 空气质量:优
     */
    private TextView mAirQualityTv;
    private ConstraintLayout mWeatherCl;
    private ImageView mSearchIv;
    private ImageView mAddDevIv;
    private ConstraintLayout mTopLayoutCl;
    private ImageView mMoreFuctionIv;

    private String switchTitleName = null;
    private List<String> titles;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    protected void lazyLoad() {
        List<CameraGroupBean.DataBean> titleArrays = Hawk.get(HawkProperty.CAMERA_GROUP);
        mFragments.clear();
        if (titleArrays == null) {
            return;
        }
        titles = new ArrayList<>();
        for (CameraGroupBean.DataBean titleArray : titleArrays) {
            mFragments.add(MyDevContentFragment.newInstance(titleArray.getId()));
            titles.add(titleArray.getName());
        }
        adapter = new ViewPagerAdapter(getChildFragmentManager(), mContext, titles, mFragments);
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(titles.size());
        /*viewpager切换监听，包含滑动点击两种*/
        mViewpager.addOnPageChangeListener(this);
        mTablayout.setupWithViewPager(mViewpager);
        initTablayoutView(0, adapter);

        if (StringTools.isStringValueOk(switchTitleName)) {
            setCurrentItem();
        } else {
            /*viewpager切换默认第一个*/
            mViewpager.setCurrentItem(0);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

    //搜索结果是分组的时候  切换标题
    public void switchTitile(String titleName) {
        switchTitleName = titleName;
        if (mViewpager != null) {
            setCurrentItem();
        }
    }

    /**
     * 更改标题
     */
    private void setCurrentItem() {
        for (int i = 0; i < titles.size(); i++) {
            String name = titles.get(i);
            if (switchTitleName.equals(name)) {
                mViewpager.setCurrentItem(i);
                break;
            }
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.mine_device;
    }


    @Override
    protected void initView() {
        mTablayout = (TabLayout) getView(R.id.tablayout);
        mViewpager = (CustomViewPager) getView(R.id.viewpager);
        mWeatherIconIv = (ImageView) getView(R.id.weather_icon_iv);
        mWeatherNameTv = (TextView) getView(R.id.weather_name_tv);
        mTemperatureTv = (TextView) getView(R.id.temperature_tv);
        mAirQualityTv = (TextView) getView(R.id.air_quality_tv);
        mWeatherCl = (ConstraintLayout) getView(R.id.weather_cl);
        mWeatherCl.setOnClickListener(this);
        mSearchIv = (ImageView) getView(R.id.search_iv);
        mSearchIv.setOnClickListener(this);
        mAddDevIv = (ImageView) getView(R.id.add_dev_iv);
        mAddDevIv.setOnClickListener(this);
        mTopLayoutCl = (ConstraintLayout) getView(R.id.top_layout_cl);
        mTablayout = (TabLayout) getView(R.id.tablayout);
        mMoreFuctionIv = (ImageView) getView(R.id.more_fuction_iv);
        mMoreFuctionIv.setOnClickListener(this);
        mViewpager = (CustomViewPager) getView(R.id.viewpager);
        MutableLiveData<String> bean =
                LiveDataManager.getInstance().with(LiveDataManager.GROUP_LIST_KEY, String.class);
        bean.observeForever(new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                lazyLoad();
            }
        });
    }

    @Override
    protected void initData() {


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

    //    /**
    //     * 配置天气信息
    //     *
    //     * @param realTimeWeather
    //     */
    //    public void setWeatherInfos(ResponseRealTimeWeather realTimeWeather) {
    //        int aqi = realTimeWeather.getData().getResult().getAqi();
    //        mTemperatureTv.setText(Math.round(realTimeWeather.getData().getResult().getTemperature()) + "°C");
    //        mAirQualityTv.setText("空气质量:" + WeatherHelper.switchPM25(aqi));
    //        mWeatherNameTv.setText(WeatherHelper.switchSkycon(realTimeWeather.getData().getResult().getSkycon()));
    //        mWeatherIconIv.setImageResource(WeatherHelper.switchSkyconInt(realTimeWeather.getData().getResult()
    //        .getSkycon()));
    //    }

    @Override
    public void onSuccess(String tag, Object o) {


    }

    @Override
    public void onError(String tag, Object o) {

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
            case R.id.weather_cl:
                break;
            case R.id.search_iv:
                //搜索
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            case R.id.add_dev_iv:
                showPopAddDev(v);
                break;
            case R.id.add_dev_ll:
                startActivity(new Intent(getContext(), AddDevActivity.class));
                stopPopWindow();
                break;
            case R.id.scan_ll:
                //todo 二维码扫描
                ToastUtils.toast(mContext,"暂不支持");
//                startActivity(new Intent(mContext,
//                        QRScanActivity.class));
//                stopPopWindow();
                break;
            case R.id.more_fuction_iv:
                startActivityForResult(new Intent(mContext, AllGroupsActivity.class),
                        AllGroupsActivity.ALL_GROUPS_RESULT);

                break;
        }
    }

    /**
     * 释放资源
     */
    private void stopPopWindow() {
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
        }
    }

    /**
     * 添加设备
     */
    public void showPopAddDev(View addView) {

        View viewPop = LayoutInflater.from(getActivity()).inflate(R.layout.pop_add_dev, null);
        popupWindow = new PopupWindow(viewPop, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        LinearLayout addDevLl = viewPop.findViewById(R.id.add_dev_ll);
        LinearLayout scanLl = viewPop.findViewById(R.id.scan_ll);
        addDevLl.setOnClickListener(this);
        scanLl.setOnClickListener(this);
        popupWindow.showAsDropDown(addView, -DisplayUtil.dp2px(mContext, 105), -DisplayUtil.dp2px(mContext, 3),
                Gravity.BOTTOM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (AllGroupsActivity.ALL_GROUPS_RESULT == resultCode) {
            if (data != null) {
                lazyLoad();
                int position = data.getIntExtra(AllGroupsActivity.ALL_GROUPS_POSITION, 0);
                mViewpager.setCurrentItem(position);
            }
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopPopWindow();
    }
}
