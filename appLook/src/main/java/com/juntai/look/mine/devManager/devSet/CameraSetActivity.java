package com.juntai.look.mine.devManager.devSet;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  普通摄像头配置
 * @date 2020/9/2 15:34
 */
public class CameraSetActivity extends BaseCameraSetActivity{


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected boolean isCameraOfNvr() {
      return false;
    }
}
