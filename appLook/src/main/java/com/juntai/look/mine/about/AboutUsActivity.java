package com.juntai.look.mine.about;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.utils.BaseAppUtils;

/**
 * @aouther tobato
 * @description 描述  关于我们
 * @date 2020/7/18 16:59
 */
public class AboutUsActivity extends BaseAppActivity implements View.OnClickListener {

    /**
     * 当前版本:V1.0
     */
    private TextView mVersionText;
    /**
     * 《用户协议》
     */
    private TextView mUserXieyi;
    /**
     * 《隐私协议》
     */
    private TextView mSecretXieyi;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initView() {
        setTitleName("关于我们");
        mVersionText = (TextView) findViewById(R.id.version_text);
        mUserXieyi = (TextView) findViewById(R.id.user_xieyi);
        mUserXieyi.setOnClickListener(this);
        mSecretXieyi = (TextView) findViewById(R.id.secret_xieyi);
        mSecretXieyi.setOnClickListener(this);
        mVersionText.setText("当前版本：V" + BaseAppUtils.getVersionName(mContext));
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.user_xieyi:
                startActivity(new Intent(mContext, UserProtocalActivity.class).putExtra("url",
                        getString(R.string.user_xieyi_url)));
                break;
            case R.id.secret_xieyi:
                startActivity(new Intent(mContext, UserProtocalActivity.class).putExtra("url",
                        getString(R.string.secret_xieyi_url)));
                break;
        }
    }
}
