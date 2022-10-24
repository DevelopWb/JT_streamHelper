package com.juntai.look.mine.devManager.share.shareToWechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.ShareTimeBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.wisdom.basecomponent.utils.PickerManager;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  分享时间设置
 * @date 2020/10/18 9:45
 */
public class SetShareTimeActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private RecyclerView mRecyclerview;
    /**
     * 选择开始时间
     */
    private TextView mStartTimeValueTv;
    /**
     * 选择开始时间
     */
    private TextView mEndTimeValueTv;
    private ShareTimeAdapter adapter;
    /**
     * 保存
     */
    private TextView mSaveConfigTv;
    private LinearLayout mCustomTimeLl;
    private Long startDate = null;
    private Long endDate = null;
    public static String TIME_TYPE = "type";//时间类型  0是全时段 1是自定义时段
    public static String START_TIME = "startTIme";//开始时间
    public static String END_TIME = "endTIme";//结束时间
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    protected MyDevicePresent createPresenter() {
        return null;
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_set_share_time;
    }

    @Override
    public void initView() {

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mStartTimeValueTv = (TextView) findViewById(R.id.start_time_value_tv);
        mStartTimeValueTv.setOnClickListener(this);
        mEndTimeValueTv = (TextView) findViewById(R.id.end_time_value_tv);
        mEndTimeValueTv.setOnClickListener(this);
        adapter = new ShareTimeAdapter(R.layout.select_group_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<ShareTimeBean> arrays = adapter.getData();
                for (ShareTimeBean array : arrays) {
                    array.setSelect(false);
                }
                ShareTimeBean bean = arrays.get(position);
                if ("自定义时段".equals(bean.getName())) {
                    mCustomTimeLl.setVisibility(View.VISIBLE);
                } else {
                    mCustomTimeLl.setVisibility(View.GONE);

                }
                bean.setSelect(true);
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setNewData(getData());
        mSaveConfigTv = (TextView) findViewById(R.id.save_config_tv);
        mSaveConfigTv.setOnClickListener(this);
        mCustomTimeLl = (LinearLayout) findViewById(R.id.custom_time_ll);
    }

    private List<ShareTimeBean> getData() {

        List<ShareTimeBean> arrays = new ArrayList<>();
        arrays.add(new ShareTimeBean("全时段", true));
        arrays.add(new ShareTimeBean("自定义时段", false));
        return arrays;
    }

    @Override
    public void initData() {
        setTitleName("分享时段设置");

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.start_time_value_tv:
                PickerManager.getInstance().showTimePickerView(mContext, PickerManager.getInstance().getTimeType(
                        "minute"), "分享开始时间", new PickerManager.OnTimePickerTimeSelectedListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        startDate = date.getTime();
                        mStartTimeValueTv.setText(sdf.format(date));
                    }
                });
                break;
            case R.id.end_time_value_tv:
                PickerManager.getInstance().showTimePickerView(mContext, PickerManager.getInstance().getTimeType(
                        "minute"), "分享结束时间", new PickerManager.OnTimePickerTimeSelectedListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        endDate = date.getTime();
                        mEndTimeValueTv.setText(sdf.format(date));
                    }
                });
                break;
            case R.id.save_config_tv:
                Intent intent = new Intent();
                if (mCustomTimeLl.getVisibility() == View.VISIBLE) {
                    if (startDate == null) {
                        ToastUtils.toast(mContext, "请选择开始时间");
                        return;
                    }
                    if (endDate == null) {
                        ToastUtils.toast(mContext, "请选择结束时间");
                        return;
                    }
                    if (endDate < startDate) {
                        ToastUtils.toast(mContext, "开始时间不能大于结束时间");
                        return;
                    }

                    intent.putExtra(TIME_TYPE, 1)
                            .putExtra(START_TIME, getTextViewValue(mStartTimeValueTv))
                            .putExtra(END_TIME, getTextViewValue(mEndTimeValueTv));
                } else {
                    intent.putExtra(TIME_TYPE, 0);
                }
                setResult(BASE_RESULT,intent);
                finish();
                break;
        }
    }

}
