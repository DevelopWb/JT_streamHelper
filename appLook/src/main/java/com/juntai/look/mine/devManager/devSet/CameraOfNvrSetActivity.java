package com.juntai.look.mine.devManager.devSet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * @aouther tobato
 * @description 描述  nvr中的摄像头的设置
 * @date 2020/9/14 11:42
 */
public class CameraOfNvrSetActivity extends BaseCameraSetActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected boolean isCameraOfNvr() {
        return true;
    }
}
