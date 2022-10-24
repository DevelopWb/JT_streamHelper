package com.juntai.look.entrance.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.LoginBean;
import com.juntai.look.entrance.EntranceContract;
import com.juntai.look.entrance.EntrancePresent;
import com.juntai.look.entrance.RetrievePwdActivity;
import com.juntai.look.entrance.regist.RegistActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.main.MainActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.utils.ActivityManagerTool;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

/**
 * @aouther tobato
 * @description 描述  登录
 * @date 2020/7/9 11:57
 */
public class LoginActivity extends BaseAppActivity<EntrancePresent> implements View.OnClickListener,
        EntranceContract.IEntranceView {
    /**
     * 登录
     */
    private Button mLoginBt;
    /**
     * 注册
     */
    private TextView mRegistTv;
    /**
     * 手机号
     */
    private EditText mPhoneEt;
    /**
     * 密码
     */
    private EditText mPwdEt;
    /**
     * 登录
     */
    private TextView mLoginTv;
    /**
     * 找回密码
     */
    private TextView mRetrievePwdTv;
    public static String  LOGIN_ACCOUNT  = "login_account";//登录账户
    @Override

    public int getLayoutView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
        mBaseRootCol.setFitsSystemWindows(true);
        mImmersionBar.reset().statusBarColorInt(getResources().getColor(R.color.blue_deeper)).init();
        mRegistTv = (TextView) findViewById(R.id.regist_tv);
        mPhoneEt = (EditText) findViewById(R.id.phone_et);
        mPwdEt = (EditText) findViewById(R.id.pwd_et);
        mLoginTv = (TextView) findViewById(R.id.login_tv);
        mRetrievePwdTv = (TextView) findViewById(R.id.retrieve_pwd_tv);
        mRegistTv.setOnClickListener(this);
        mLoginTv.setOnClickListener(this);
        mRetrievePwdTv.setOnClickListener(this);
        if (getIntent() != null) {
            String account = getIntent().getStringExtra(LOGIN_ACCOUNT);
            if (StringTools.isStringValueOk(account)) {
                mPhoneEt.setText(account);
            }
        }
    }

    @Override
    public void initData() {

    }


    @Override
    public void onBackPressed() {
        ActivityManagerTool.getInstance().finishApp();
        super.onBackPressed();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.regist_tv:
                startActivity(new Intent(mContext, RegistActivity.class));
                break;
            case R.id.retrieve_pwd_tv:
                startActivity(new Intent(mContext, RetrievePwdActivity.class));
                break;
            case R.id.login_tv:
                String account = getTextViewValue(mPhoneEt);
                String pwd = getTextViewValue(mPwdEt);

                if (!StringTools.isStringValueOk(account)) {
                    ToastUtils.toast(mContext, "请输入用户名");
                    return;
                }
                if (!StringTools.isStringValueOk(pwd)) {
                    ToastUtils.toast(mContext, "请输入密码");
                    return;
                }

                mPresenter.login(account, encryptPwd(account, pwd), EntranceContract.LOGIN);
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            String account = intent.getStringExtra(LOGIN_ACCOUNT);
            if (StringTools.isStringValueOk(account)) {
                mPhoneEt.setText(account);
            }
        }

        super.onNewIntent(intent);
    }

    @Override
    protected EntrancePresent createPresenter() {
        return new EntrancePresent();
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case EntranceContract.LOGIN:
                LoginBean loginBean = (LoginBean) o;
                if (loginBean != null) {
                    LoginBean.UserBean userBean = loginBean.getData();
                    Hawk.put(HawkProperty.USER_INFO, userBean);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void updateSendCheckCodeViewStatus(long second) {

    }

    @Override
    public void checkFormatError(String error) {

    }
}

