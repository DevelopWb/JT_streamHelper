package com.juntai.look.base;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.juntai.wisdom.basecomponent.base.BaseMvpFragment;
import com.juntai.wisdom.basecomponent.mvp.IPresenter;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;

/**
 * @aouther tobato
 * @description 描述  app的fragment的基类
 * @date 2020/7/18 16:43
 */
public abstract class BaseAppFragment<P extends IPresenter> extends BaseMvpFragment<P> {


    /**
     * 获取activity
     *
     * @return
     */
    public BaseAppActivity getBaseAppActivity() {
        return (BaseAppActivity) getActivity();
    }

    /**
     * 设置顶部图标
     * @param textView
     * @param drawableId
     */
    public void initViewTopDrawable(TextView textView, int drawableId, int width, int height) {
        Drawable drawable = getResources().getDrawable(drawableId);
        drawable.setBounds(0, 0, DisplayUtil.dp2px(mContext, width), DisplayUtil.dp2px(mContext, height));//第一个 0 是距左边距离，第二个 0
        // 是距上边距离，40 分别是长宽
        textView.setCompoundDrawables(null, drawable, null, null);//放顶部
    }
}
