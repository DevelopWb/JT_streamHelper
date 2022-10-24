package com.juntai.look.entrance.regist;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.juntai.look.entrance.EntranceContract;
import com.juntai.look.entrance.EntrancePresent;
import com.juntai.look.entrance.login.LoginActivity;
import com.juntai.look.entrance.sendcode.SmsCheckCodeActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.mine.about.UserProtocalActivity;
import com.juntai.wisdom.basecomponent.base.OnMultiClickListener;
import com.juntai.wisdom.basecomponent.utils.PubUtil;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import cn.smssdk.SMSSDK;
import okhttp3.FormBody;

/**
 * @aouther tobato
 * @description 描述  注册
 * @date 2020/3/8 14:27
 */
public class RegistActivity extends SmsCheckCodeActivity<EntrancePresent> implements EntranceContract.IEntranceView,
        View.OnClickListener {
    /**
     * 登录
     */
    private TextView mLoginTv;
    /**
     * 昵称
     */
    private EditText mNickNameEt;
    /**
     * 密码
     */
    private EditText mPwdEt;
    /**
     * 确认密码
     */
    private EditText mConfirmPwdEt;
    /**
     * 手机号
     */
    private EditText mPhoneEt;
    /**
     * 验证码
     */
    private EditText mRegistCheckCodeEt;
    /**
     * 发送验证码
     */
    private TextView mRegistSendCheckCodeTv;
    private RadioButton mRegistAgreeProtocalRb;
    /**
     * 我已阅读并同意《隐私协议》
     */
    private TextView mRegistProtocalSecrecyTv;
    /**
     * 和《用户协议》
     */
    private TextView mRegistProtocaUserTv;
    /**
     * 注册
     */
    private TextView mRegistTv;

    //是否同意协议
    private boolean isAgreeProtocal = true;
    public Double lat = 0.0;
    public Double lng = 0.0;
    private String nickName;
    private String pwd;
    private String account;

    @Override
    protected void initGetTestCodeButtonStatusStart() {
        mPresenter.initGetTestCodeButtonStatus();
    }

    @Override
    protected void initGetTestCodeButtonStatusStop() {
        mPresenter.receivedCheckCodeAndDispose();
        mRegistSendCheckCodeTv.setText("发送验证码");
        mRegistSendCheckCodeTv.setClickable(true);
        mRegistSendCheckCodeTv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @Override
    protected void checkCodeSuccessed() {
        // 请求注册的接口
        mPresenter.regist(new FormBody.Builder()
                .add("account", account)
                .add("password", encryptPwd(account, pwd))
                .add("nickname", nickName)
                .add("longitude", String.valueOf(lng))
                .add("latitude", String.valueOf(lat)).build(), "");
    }

    @Override
    protected EntrancePresent createPresenter() {
        return new EntrancePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_regist;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
        mBaseRootCol.setFitsSystemWindows(true);
        mImmersionBar.reset().statusBarColorInt(getResources().getColor(R.color.blue_deeper)).init();
        mLoginTv = (TextView) findViewById(R.id.login_tv);
        mLoginTv.setOnClickListener(this);
        mNickNameEt = (EditText) findViewById(R.id.nick_name_et);
        mPwdEt = (EditText) findViewById(R.id.pwd_et);
        mConfirmPwdEt = (EditText) findViewById(R.id.confirm_pwd_et);
        mPhoneEt = (EditText) findViewById(R.id.phone_et);
        mRegistCheckCodeEt = (EditText) findViewById(R.id.regist_check_code_et);
        mRegistSendCheckCodeTv = (TextView) findViewById(R.id.regist_send_check_code_tv);
        mRegistSendCheckCodeTv.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                mPresenter.sendCheckCode(getTextViewValue(mPhoneEt), SMS_TEMP_CODE);
            }
        });
        mRegistAgreeProtocalRb = (RadioButton) findViewById(R.id.regist_agree_protocal_rb);
        mRegistProtocalSecrecyTv = (TextView) findViewById(R.id.regist_protocal_secrecy_tv);
        mRegistProtocalSecrecyTv.setOnClickListener(this);
        mRegistProtocaUserTv = (TextView) findViewById(R.id.regist_protoca_user_tv);
        mRegistProtocaUserTv.setOnClickListener(this);
        mRegistTv = (TextView) findViewById(R.id.regist_tv);
        mRegistTv.setOnClickListener(this);
        mRegistAgreeProtocalRb.setOnClickListener(this);
    }

    @Override
    public void initData() {
        String content = getString(R.string.protocal_notice1);
        StringTools.setTextPartColor(mRegistProtocalSecrecyTv, content, content.lastIndexOf("《"), content.length(), "#2C8FFC");
        String content_user = getString(R.string.protocal_notice2);
        StringTools.setTextPartColor(mRegistProtocaUserTv, content_user, content_user.lastIndexOf("《"), content_user.length(), "#2C8FFC");

    }

    @Override
    public void onSuccess(String tag, Object o) {
        ToastUtils.toast(mContext, "注册成功");
        startActivity(new Intent(mContext, LoginActivity.class).putExtra(LoginActivity.LOGIN_ACCOUNT,account));
    }

    @Override
    public void updateSendCheckCodeViewStatus(long second) {
        if (second > 0) {
            mRegistSendCheckCodeTv.setText("重新发送 " + second + "s");
            mRegistSendCheckCodeTv.setClickable(false);
            mRegistSendCheckCodeTv.setTextColor(ContextCompat.getColor(this, R.color.gray));
        } else {
            mRegistSendCheckCodeTv.setText("发送验证码");
            mRegistSendCheckCodeTv.setClickable(true);
            mRegistSendCheckCodeTv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));

        }
    }

    @Override
    public void onLocationReceived(BDLocation bdLocation) {
        if (bdLocation != null) {
            lat = bdLocation.getLatitude();
            lng = bdLocation.getLongitude();
        }
    }

    @Override
    public boolean requestLocation() {
        return true;
    }

    @Override
    public void checkFormatError(String error) {
        ToastUtils.warning(mContext, error);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_tv:
                startActivity(new Intent(mContext, LoginActivity.class));
                break;
            case R.id.regist_agree_protocal_rb:
                if (isAgreeProtocal) {
                    mRegistAgreeProtocalRb.setChecked(false);
                    isAgreeProtocal = false;
                } else {
                    mRegistAgreeProtocalRb.setChecked(true);
                    isAgreeProtocal = true;
                }
                break;
            case R.id.regist_protocal_secrecy_tv:
                startActivity(new Intent(mContext, UserProtocalActivity.class).putExtra("url", getString(R.string.secret_xieyi_url)));

                break;
            case R.id.regist_protoca_user_tv:
                startActivity(new Intent(mContext, UserProtocalActivity.class).putExtra("url", getString(R.string.user_xieyi_url)));

                break;
            case R.id.regist_tv:
                if (0.0 == lat) {
                    ToastUtils.warning(mContext, "请开启GPS");
                    return;
                }

                nickName = getTextViewValue(mNickNameEt);
                if (!StringTools.isStringValueOk(nickName)) {
                    ToastUtils.warning(mContext, "请输入昵称");
                    return;
                } else {
                    if (!PubUtil.checkAccountMark(nickName)) {
                        ToastUtils.warning(mContext, "不能包含特殊字符");
                        return;
                    }
                }
                pwd = getTextViewValue(mPwdEt);
                if (!StringTools.isStringValueOk(pwd)) {
                    ToastUtils.warning(mContext, "请输入密码");
                    return;
                } else {
                    if (!PubUtil.checkPwdMark(pwd)) {
                        ToastUtils.warning(mContext, "密码仅支持最少6位(字母数字组合)");
                        return;
                    } else {
                        //查看确认密码
                        if (!StringTools.isStringValueOk(getTextViewValue(mConfirmPwdEt))) {
                            ToastUtils.warning(mContext, "请确认密码");
                            return;
                        }
                        if (!pwd.equals(getTextViewValue(mConfirmPwdEt))) {
                            ToastUtils.warning(mContext, "两次输入的密码不一致");
                            return;
                        }
                    }
                }

                account = getTextViewValue(mPhoneEt);
                if (!mPresenter.checkMobile(account)) {
                    return;
                }

                if (!StringTools.isStringValueOk(getTextViewValue(mRegistCheckCodeEt))) {
                    ToastUtils.warning(mContext, "验证码不能为空");
                    return;
                }

                if (!isAgreeProtocal) {
                    ToastUtils.toast(mContext, "请阅读并同意《隐私协议》和《用户协议》");
                    return;
                }
                if (!verify) {
                    SMSSDK.submitVerificationCode("+86", account, getTextViewValue(mRegistCheckCodeEt));
                } else {
                    // 请求注册的接口
                    mPresenter.regist(new FormBody.Builder()
                            .add("account", account)
                            .add("password", encryptPwd(account, pwd))
                            .add("nickname", nickName)
                            .add("longitude", String.valueOf(lng))
                            .add("latitude", String.valueOf(lat)).build(), ""
                    );


                }
                break;
        }
    }
}
