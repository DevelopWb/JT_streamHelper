package com.juntai.look.entrance.login;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.juntai.look.main.MainActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.utils.SPTools;
import com.orhanobut.hawk.Hawk;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

/**
 * @aouther tobato
 * @description 描述
 * @date 2020/4/23 10:08  更新 欢迎页面
 */
public class SplashActivity extends RxAppCompatActivity {

    String[] permissions = new String[]{
            Manifest.permission.CALL_PHONE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new RxPermissions(this)
                .request(permissions)
                .delay(1, TimeUnit.SECONDS)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            //所有权限通过
                        } else {
                            //有一个权限没通过
                        }
                        if (SPTools.getBoolean(SplashActivity.this, "first_start", true)) {
                            //                            SplashActivity(new Intent(SplashActivity.this,
                            //                            GuideActivity.class));
                            //                            finish();
                            //                            return;
                        }
                        if (Hawk.get(HawkProperty.USER_INFO) != null) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        } else {
                            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }

}
