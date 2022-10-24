package com.juntai.look.homePage.mydevice.allGroup;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.wisdom.basecomponent.utils.LiveDataManager;
import com.juntai.wisdom.basecomponent.utils.PubUtil;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

/**
 * @aouther tobato
 * @description 描述  创建分组
 * @date 2020/9/3 11:34
 */
public class CreateGroupActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private EditText mDevNameEt;
    private ImageView mGroupBg1Iv;
    private ImageView mGroupBg2Iv;
    private ImageView mGroupBg3Iv;
    private ImageView mGroupBg4Iv;
    private int groupIconId = 1;//分组背景图
    /**
     * 创建
     */
    private TextView mCreatTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_create_group;
    }

    @Override
    public void initView() {
        setTitleName("创建分组");
        mDevNameEt = (EditText) findViewById(R.id.dev_name_et);
        mGroupBg1Iv = (ImageView) findViewById(R.id.group_bg1_iv);
        mGroupBg1Iv.setOnClickListener(this);
        mGroupBg2Iv = (ImageView) findViewById(R.id.group_bg2_iv);
        mGroupBg2Iv.setOnClickListener(this);
        mGroupBg3Iv = (ImageView) findViewById(R.id.group_bg3_iv);
        mGroupBg3Iv.setOnClickListener(this);
        mGroupBg4Iv = (ImageView) findViewById(R.id.group_bg4_iv);
        mGroupBg4Iv.setOnClickListener(this);
        mCreatTv = (TextView) findViewById(R.id.creat_tv);
        mCreatTv.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {
        ToastUtils.toast(mContext, "创建分组成功");
        finish();
    }

    /**
     * 初始化分组背景
     */
    private void initBgStatus(int type) {
        groupIconId = type;
        mGroupBg1Iv.setImageResource(R.mipmap.group_bg1_normal);
        mGroupBg2Iv.setImageResource(R.mipmap.group_bg2_normal);
        mGroupBg3Iv.setImageResource(R.mipmap.group_bg3_normal);
        mGroupBg4Iv.setImageResource(R.mipmap.group_bg4_normal);
        switch (type) {
            case 1:
                mGroupBg1Iv.setImageResource(R.mipmap.group_bg1_press);
                break;
            case 2:
                mGroupBg2Iv.setImageResource(R.mipmap.group_bg2_press);
                break;
            case 3:
                mGroupBg3Iv.setImageResource(R.mipmap.group_bg3_press);
                break;
            case 4:
                mGroupBg4Iv.setImageResource(R.mipmap.group_bg4_press);
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
            case R.id.group_bg1_iv:
                initBgStatus(1);
                break;
            case R.id.group_bg2_iv:
                initBgStatus(2);
                break;
            case R.id.group_bg3_iv:
                initBgStatus(3);
                break;
            case R.id.group_bg4_iv:
                initBgStatus(4);
                break;
            case R.id.creat_tv:
                if (!initNickName(mDevNameEt)) {
                    return;
                }
                mPresenter.creatVideoGroup(getBaseBuilder().add("name", getTextViewValue(mDevNameEt)).add("icon",
                        String.valueOf(groupIconId)).build(), "");

                break;
        }
    }


}
