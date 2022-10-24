package com.juntai.look.homePage.addDev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.location.BDLocation;
import com.juntai.look.hcb.R;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

/**
 * @aouther tobato
 * @description 描述  添加普通摄像头
 * @date 2020/9/1 17:22
 */
public class AddNornalCameraActivity extends BaseAddDevActivity {


    @Override
    public void onSuccess(String tag, Object o) {
        ToastUtils.toast(mContext,"添加成功");
        finish();
    }

    @Override
    public void initView() {

        super.initView();
    }

    @Override
    protected int getLayout() {
        return 0;
    }


}
