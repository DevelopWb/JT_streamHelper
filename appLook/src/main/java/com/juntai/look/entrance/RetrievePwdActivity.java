package com.juntai.look.entrance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.juntai.look.entrance.login.LoginActivity;
import com.juntai.look.entrance.sendcode.SmsCheckCodeActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.base.OnMultiClickListener;
import com.juntai.wisdom.basecomponent.utils.PubUtil;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import cn.smssdk.SMSSDK;
import okhttp3.FormBody;

/**
 * @aouther tobato
 * @description 描述  找回密码
 * @date 2020/9/9 14:17
 */
public class RetrievePwdActivity extends SmsCheckCodeActivity<EntrancePresent> implements EntranceContract.IEntranceView, View.OnClickListener {

    /**
     * 请输入手机号
     */
    private EditText mPhoneEt;
    /**
     * 请输入新密码
     */
    private EditText mPwdEt;
    /**
     * 请输入验证码
     */
    private EditText mCheckCodeEt;
    /**
     * 获取验证码
     */
    private TextView mGetCheckCodeTv;
    private String newPwd;
    private String account;

    @Override
    protected EntrancePresent createPresenter() {
        return new EntrancePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_retrieve_pwd;
    }

    @Override
    public void initView() {
        setTitleName("找回密码");
        getTitleRightTv().setText("重置");
        getTitleRightTv().setOnClickListener(this);
        mPhoneEt = (EditText) findViewById(R.id.phone_et);
        mPwdEt = (EditText) findViewById(R.id.pwd_et);
        mCheckCodeEt = (EditText) findViewById(R.id.check_code_et);
        mGetCheckCodeTv = (TextView) findViewById(R.id.get_check_code_tv);
        mGetCheckCodeTv.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                mPresenter.sendCheckCode(getTextViewValue(mPhoneEt), SMS_TEMP_CODE);
            }
        });
    }

    @Override
    public void initData() {

    }


    @Override
    protected void initGetTestCodeButtonStatusStart() {
        mPresenter.initGetTestCodeButtonStatus();
    }

    @Override
    protected void initGetTestCodeButtonStatusStop() {
        mPresenter.receivedCheckCodeAndDispose();
        mGetCheckCodeTv.setText("发送验证码");
        mGetCheckCodeTv.setClickable(true);
        mGetCheckCodeTv.setBackgroundResource(R.drawable.bt_green_clicked);
        mGetCheckCodeTv.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    protected void checkCodeSuccessed() {
        //  请求更改密码的接口
        mPresenter. retrievePwd(new FormBody.Builder().add("account", account).add("newPassWord",encryptPwd(account,
                newPwd)).build(),"");
    }

    @Override
    public void updateSendCheckCodeViewStatus(long second) {
        if (second > 0) {
            mGetCheckCodeTv.setText("重新发送 " + second + "s");
            mGetCheckCodeTv.setClickable(false);
            mGetCheckCodeTv.setBackgroundResource(R.drawable.sp_circle_gray);
            mGetCheckCodeTv.setTextColor(ContextCompat.getColor(this, R.color.text_default_color));
        } else {
            mGetCheckCodeTv.setText("发送验证码");
            mGetCheckCodeTv.setClickable(true);
            mGetCheckCodeTv.setBackgroundResource(R.drawable.bt_green_clicked);
            mGetCheckCodeTv.setTextColor(ContextCompat.getColor(this, R.color.white));

        }
    }

    @Override
    public void checkFormatError(String error) {
        ToastUtils.warning(mContext, error);
    }

    @Override
    public void onSuccess(String tag, Object o) {
        ToastUtils.toast(mContext, "找回成功");
        startActivity(new Intent(mContext, LoginActivity.class).putExtra(LoginActivity.LOGIN_ACCOUNT,account));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.title_rightTv:
                //重置
                account = getTextViewValue(mPhoneEt);
                if (!mPresenter.checkMobile(account)) {
                    return;
                }
                newPwd = getTextViewValue(mPwdEt);
                if (!StringTools.isStringValueOk(newPwd)) {
                    ToastUtils.warning(mContext, "请输入密码");
                    return;
                } else {
                    if (!PubUtil.checkPwdMark(newPwd)) {
                        ToastUtils.warning(mContext, "密码仅支持最少6位(字母数字组合)");
                        return;
                    }
                }
                if (!StringTools.isStringValueOk(getTextViewValue(mCheckCodeEt))) {
                    ToastUtils.warning(mContext, "验证码不能为空");
                    return;
                }
                if (!verify) {
                    SMSSDK.submitVerificationCode("+86", account, getTextViewValue(mCheckCodeEt));
                } else {
                    //  请求更改密码的接口
                    mPresenter. retrievePwd(new FormBody.Builder().add("account", account).add("newPassWord",encryptPwd(account,
                            newPwd)).build(),"");
                }
                break;
        }
    }
}
