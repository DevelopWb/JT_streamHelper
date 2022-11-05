package com.juntai.look.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.juntai.look.base.customView.CustomViewPager;
import com.juntai.look.base.update.UpdateActivity;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.HomePageContract;
import com.juntai.look.homePage.HomePageFragment;
import com.juntai.look.homePage.MainPagerAdapter;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDeviceFragment;
import com.juntai.look.homePage.search.SearchFragment;
import com.juntai.look.mine.MineFragment;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.mvp.BaseIView;
import com.juntai.wisdom.bdmap.service.LocateAndUpload;
import com.mob.MobSDK;
import com.orhanobut.hawk.Hawk;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  首页
 * @date 2020/7/29 16:55
 */
public class MainActivity extends UpdateActivity<MainPresent> implements SearchFragment.OnSearchCallBack, BaseIView,
        View.OnClickListener {
    private long mExitTime;
    private String HOME_PAGE = "COMMENT";//首页
    private String MY_DEV = "YUN_CONTROL";//我的设备
    private String MINE = "VIDEO_RECORD";//我饿
    private MyDeviceFragment mDeviceFragment;
    private HomePageFragment mHomePageFragment;
    private MineFragment mMineFragment;
    private ImageView mHomePageImage;
    /**
     * 首页
     */
    private TextView mHomePageText;
    private ConstraintLayout mHomePageCl;
    private ImageView mModeChangeImage;
    /**
     * 模式切换
     */
    private TextView mModeChangeText;
    private ConstraintLayout mModeChangeCl;
    private ImageView mMineImageIv;
    /**
     * 我的
     */
    private TextView mMineTextTv;
    private ConstraintLayout mMineCl;
    public static String SEARCH_RESULT = "search_result";//搜索结果是分组的时候用到

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
        update(false);
        mHomePageImage = (ImageView) findViewById(R.id.home_page_image);
        mHomePageText = (TextView) findViewById(R.id.home_page_text);
        mHomePageCl = (ConstraintLayout) findViewById(R.id.home_page_cl);
        mHomePageCl.setOnClickListener(this);
        mModeChangeImage = (ImageView) findViewById(R.id.mode_change_image);
        mModeChangeText = (TextView) findViewById(R.id.mode_change_text);
        mModeChangeCl = (ConstraintLayout) findViewById(R.id.mode_change_cl);
        mModeChangeCl.setOnClickListener(this);
        mMineImageIv = (ImageView) findViewById(R.id.mine_image_iv);
        mMineTextTv = (TextView) findViewById(R.id.mine_text_tv);
        mMineCl = (ConstraintLayout) findViewById(R.id.mine_cl);
        mMineCl.setOnClickListener(this);
        MobSDK.submitPolicyGrantResult(true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mHomePageFragment = (HomePageFragment) getSupportFragmentManager().findFragmentByTag(HOME_PAGE);
            mDeviceFragment = (MyDeviceFragment) getSupportFragmentManager().findFragmentByTag(MY_DEV);
            mMineFragment = (MineFragment) getSupportFragmentManager().findFragmentByTag(MINE);
        } else {
            initFragments();
        }
        initStatus(0);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            String groupName = intent.getStringExtra(SEARCH_RESULT);
            if (StringTools.isStringValueOk(groupName)) {
                initStatus(1);
                mDeviceFragment.switchTitile(groupName);
            }else {
                mHomePageFragment.refreshCameraList();
            }
        }

        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getVideoGroup(getBaseBuilder().build(), MyDeviceContract.CAMERA_GROUP);
        //        mPresenter.unReadMsg(getPublishMultipartBody().build(), MineContract.UNREAD_MSG);
    }

    @Override
    public boolean requestLocation() {
        return true;
    }

    @Override
    public void onLocationReceived(BDLocation bdLocation) {

        if (bdLocation != null) {
            String latStr = String.valueOf(bdLocation.getLatitude());
            String lngStr = String.valueOf(bdLocation.getLongitude());
            mPresenter.getWeatherRealTime(HomePageContract.GET_WEATHER_REAL_TIME, lngStr, latStr);
        }
    }


    /**
     * 初始化状态
     *
     * @param position
     */
    private void initStatus(int position) {
        initFragmentSelected(position);
        initNavigationBtStatus(position);
        switch (position) {
            case 0:
                //状态栏配置
                mBaseRootCol.setFitsSystemWindows(true);
                mImmersionBar.statusBarColor(R.color.colorAccent)
                        .statusBarDarkFont(false)
                        .init();
                break;
            case 1:
                //状态栏配置
                mBaseRootCol.setFitsSystemWindows(true);
                mImmersionBar.statusBarColor(R.color.white)
                        .statusBarDarkFont(true)
                        .init();
                break;
            case 2:
                //状态栏配置
                mBaseRootCol.setFitsSystemWindows(true);
                mImmersionBar.statusBarColor(R.color.white)
                        .statusBarDarkFont(true)
                        .init();
                break;
            default:
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case HomePageContract.GET_WEATHER_REAL_TIME:
                ResponseRealTimeWeather realTimeWeather = (ResponseRealTimeWeather) o;
                mHomePageFragment.setWeatherInfos(realTimeWeather);
                break;

            case MyDeviceContract.CAMERA_GROUP:
                CameraGroupBean bean = (CameraGroupBean) o;
                if (bean != null) {
                    List<CameraGroupBean.DataBean> dataBeans = bean.getData();
                    Hawk.put(HawkProperty.CAMERA_GROUP, dataBeans);
                }

                break;
            default:
                //未读消息
                UnReadMsgBean unReadMsgBean = (UnReadMsgBean) o;
                int size = unReadMsgBean.getData();
                mMineFragment.setUnReadMsg(unReadMsgBean);

                break;
        }


    }

    @Override
    public void onSearch(String textContent) {

    }


    @Override
    public void onBackPressed() {
        exit();
    }


    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再次点击返回退出软件", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            //            ModuleIm_Init.logout();
            finish();
            System.exit(0);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected MainPresent createPresenter() {
        return new MainPresent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(MainActivity.this, LocateAndUpload.class));
    }

    /**
     * 获取各个fragment对象
     */
    private void initFragments() {
        if (mHomePageFragment == null) {
            mHomePageFragment = new HomePageFragment();
        }
        if (mDeviceFragment == null) {
            mDeviceFragment = new MyDeviceFragment();
        }
        if (mMineFragment == null) {
            mMineFragment = new MineFragment();
        }
    }

    /**
     * 初始化fragment
     *
     * @param i
     */
    private void initFragmentSelected(int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hindFragments(fragmentTransaction);
        initFragments();
        switch (i) {
            case 0:
                if (!mHomePageFragment.isAdded()) {
                    fragmentTransaction.add(R.id.main_fl, mHomePageFragment, HOME_PAGE);
                }
                fragmentTransaction.show(mHomePageFragment);
                break;
            case 1:
                if (!mDeviceFragment.isAdded()) {
                    fragmentTransaction.add(R.id.main_fl, mDeviceFragment, MY_DEV);
                }
                fragmentTransaction.show(mDeviceFragment);
                break;
            case 2:
                if (!mMineFragment.isAdded()) {
                    fragmentTransaction.add(R.id.main_fl, mMineFragment, MINE);
                }
                fragmentTransaction.show(mMineFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏所有的fragment
     *
     * @param fragmentTransaction
     */
    private void hindFragments(FragmentTransaction fragmentTransaction) {

        if (mHomePageFragment != null) {
            fragmentTransaction.hide(mHomePageFragment);
        }
        if (mDeviceFragment != null) {
            fragmentTransaction.hide(mDeviceFragment);
        }
        if (mMineFragment != null) {
            fragmentTransaction.hide(mMineFragment);
        }
    }

    /**
     * 初始化底部按钮
     */
    private void initNavigationBtStatus(int position) {
        mHomePageImage.setSelected(false);
        mModeChangeImage.setSelected(false);
        mMineImageIv.setSelected(false);
        mHomePageText.setSelected(false);
        mModeChangeText.setSelected(false);
        mMineTextTv.setSelected(false);
        switch (position) {
            case 0:
                mHomePageImage.setSelected(true);
                mHomePageText.setSelected(true);
                break;
            case 1:
                mModeChangeImage.setSelected(true);
                mModeChangeText.setSelected(true);
                break;
            case 2:
                mMineImageIv.setSelected(true);
                mMineTextTv.setSelected(true);
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
            case R.id.home_page_cl:
                initStatus(0);
                break;
            case R.id.mode_change_cl:
                initStatus(1);
                break;
            case R.id.mine_cl:
                initStatus(2);
                break;
        }
    }
}