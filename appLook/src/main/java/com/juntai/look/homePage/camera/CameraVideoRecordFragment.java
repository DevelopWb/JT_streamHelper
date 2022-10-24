package com.juntai.look.homePage.camera;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.hdl.ruler.RulerView;
import com.hdl.ruler.bean.OnBarMoveListener;
import com.hdl.ruler.bean.TimeSlot;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.wisdom.basecomponent.bean.VideoInfoBean;
import com.juntai.wisdom.basecomponent.utils.CalendarUtil;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tobato
 * @Description: 作用描述  云台控制
 * @CreateDate: 2020/8/14 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/14 9:23
 */
public class CameraVideoRecordFragment extends BaseAppFragment<PlayPresent> implements PlayContract.IPlayView,
        View.OnClickListener {
    private ImageView mFinishIv;
    private ImageView mPreMonthIv;
    private ImageView mNextMonthIv;
    private CalendarView mMonthRecordCalendarView;
    private Date currentDate = new Date();
    private TextView mSelectMonth;
    private Map<String, Calendar> map = new HashMap<>();
    private ConstraintLayout mSelectVideoDayCl;
    /**
     * 共10个视频
     */
    private TextView mVideoAccountTv;
    /**
     * 2020-08-20 10:00:00
     */
    private TextView mCurrentVideoTimeTv;
    /**
     * 回到直播
     */
    private TextView mBackToLiveTv;
    private ImageView mZoomplus;
    private ImageView mZoomminus;
    private ConstraintLayout mOperateVideoCl;
    private long currentRealDateTime = System.currentTimeMillis();
    private java.util.Calendar calendar;

    private static long ONE_MINUTE_IN_MS = 60 * 1000;
    private static long ONE_HOUR_IN_MS = 60 * ONE_MINUTE_IN_MS;
    private static long ONE_DAY_IN_MS = 24 * ONE_HOUR_IN_MS;
    private RulerView rulerView;
    private String yunSdf = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat sdfOfYunControl = new SimpleDateFormat(yunSdf);//云控时间格式
    private long startTime, endTimeOfDay;//时间轴的开始时间段
    private long selectedTime;//选中的时间
    private boolean onLine = false;
    private boolean isOneDayRecord = true;//当天的视频

    @Override
    protected PlayPresent createPresenter() {
        return new PlayPresent();
    }

    @Override
    protected void lazyLoad() {
        calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calendar.set(java.util.Calendar.MINUTE, 0);
        calendar.set(java.util.Calendar.SECOND, 0);
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1);
        mPresenter.searchVideos(sdfOfYunControl.format(calendar.getTime()).replace(" ", "T"),
                sdfOfYunControl.format(new Date()).replace(" ", "T"),
                ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.SEARCH_MONTH_OF_VIDEOABLE);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_camera_video;
    }

    public void setOnlineStatus(boolean onLine) {
        this.onLine = onLine;
    }

    @Override
    protected void initView() {

        mSelectMonth = getView(R.id.selected_month_tv);
        mSelectMonth.setText(String.format("%s%s%s", CalendarUtil.getCurrentYear(), "-",
                CalendarUtil.getCurrentMonth()));
        mFinishIv = (ImageView) getView(R.id.finish_iv);
        mFinishIv.setOnClickListener(this);
        mPreMonthIv = (ImageView) getView(R.id.pre_month_iv);
        mPreMonthIv.setOnClickListener(this);
        mNextMonthIv = (ImageView) getView(R.id.next_month_iv);
        mNextMonthIv.setOnClickListener(this);
        mMonthRecordCalendarView = (CalendarView) getView(R.id.month_record_calendarView);

        mMonthRecordCalendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
            @Override
            public void onCalendarOutOfRange(Calendar calendar) {

            }

            @Override
            public void onCalendarSelect(Calendar calendar, boolean isClick) {
                if (calendar.hasScheme()) {
                    mSelectVideoDayCl.setVisibility(View.GONE);
                    mOperateVideoCl.setVisibility(View.VISIBLE);
                    //查询当天的录像视频
                    java.util.Calendar calendarSys = java.util.Calendar.getInstance();
                    calendarSys.set(java.util.Calendar.HOUR_OF_DAY, 0);
                    calendarSys.set(java.util.Calendar.MINUTE, 0);
                    calendarSys.set(java.util.Calendar.SECOND, 0);
                    calendarSys.set(java.util.Calendar.YEAR, calendar.getYear());
                    calendarSys.set(java.util.Calendar.MONTH, calendar.getMonth() - 1);
                    calendarSys.set(java.util.Calendar.DAY_OF_MONTH, calendar.getDay());
                    startTime = calendarSys.getTimeInMillis();
                    java.util.Calendar calendarSysEnd = java.util.Calendar.getInstance();
                    calendarSysEnd.set(java.util.Calendar.HOUR_OF_DAY, 0);
                    calendarSysEnd.set(java.util.Calendar.MINUTE, 0);
                    calendarSysEnd.set(java.util.Calendar.SECOND, 0);
                    calendarSysEnd.set(java.util.Calendar.YEAR, calendar.getYear());
                    calendarSysEnd.set(java.util.Calendar.MONTH, calendar.getMonth() - 1);
                    calendarSysEnd.set(java.util.Calendar.DAY_OF_MONTH, calendar.getDay() + 1);
                    endTimeOfDay = calendarSysEnd.getTimeInMillis();
                    mPresenter.searchVideos(sdfOfYunControl.format(calendarSys.getTime()).replace(" ", "T"),
                            sdfOfYunControl.format(calendarSysEnd.getTime()).replace(" ", "T"),
                            ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.SEARCH_DAY_OF_VIDEOABLE);

                }
            }
        });
        mSelectVideoDayCl = (ConstraintLayout) getView(R.id.select_video_day_cl);
        mVideoAccountTv = (TextView) getView(R.id.video_account_tv);
        mCurrentVideoTimeTv = (TextView) getView(R.id.current_video_time_tv);
        mCurrentVideoTimeTv.setOnClickListener(this);
        mCurrentVideoTimeTv.setText(sdfOfYunControl.format(new Date()));
        mBackToLiveTv = (TextView) getView(R.id.back_to_live_tv);
        mBackToLiveTv.setOnClickListener(this);
        rulerView = getView(R.id.ruler_view);
        mZoomplus = (ImageView) getView(R.id.zoomplus);
        mZoomplus.setOnClickListener(this);
        mZoomminus = (ImageView) getView(R.id.zoomminus);
        mZoomminus.setOnClickListener(this);
        mOperateVideoCl = (ConstraintLayout) getView(R.id.operate_video_cl);
        initOperateVideoLayout();
    }

    /**
     * 操控录像的布局控件
     */
    private void initOperateVideoLayout() {

        rulerView.setCurrentTimeMillis(System.currentTimeMillis());
        rulerView.openMove();
        rulerView.setOnBarMoveListener(new OnBarMoveListener() {
            @Override
            public void onDragBar(boolean isLeftDrag, long currentTime) {
                mCurrentVideoTimeTv.setText(sdfOfYunControl.format(currentTime));
            }

            @Override
            public void onBarMoving(long currentTime) {
                mCurrentVideoTimeTv.setText(sdfOfYunControl.format(currentTime));
            }

            @Override
            public void onBarMoveFinish(long currentTime) {
                selectedTime = currentTime;
                isOneDayRecord = true;
                //停止录像流
                ((PlayerLiveActivity) getActivity()).stopStream();


            }

            @Override
            public void onMoveExceedStartTime() {
            }

            @Override
            public void onMoveExceedEndTime() {
            }

            @Override
            public void onMaxScale() {

            }

            @Override
            public void onMinScale() {

            }
        });

    }

    /**
     * 获取录像的流地址
     */
    public void getVideoRtmpUrl() {
        if (!onLine) {
            if (!isOneDayRecord) {
                //获取录像的流地址  当天的0点到第二天的0点
                ((PlayerLiveActivity) getActivity()).getVideoRtmpUrl(mPresenter.formatTimeToYun(startTime),
                        mPresenter.formatTimeToYun(endTimeOfDay));
            } else {
                ((PlayerLiveActivity) getActivity()).getVideoRtmpUrl(mPresenter.formatTimeToYun(selectedTime),
                        mPresenter.formatTimeToYun(endTimeOfDay));
            }

        }

    }

    private Calendar getSchemeCalendar(String time) {
        String[] times = time.split("-");
        Calendar calendar = new Calendar();
        calendar.setYear(Integer.parseInt(times[0]));
        calendar.setMonth(Integer.parseInt(times[1]));
        calendar.setDay(Integer.parseInt(times[2]));
        calendar.setSchemeColor(Color.parseColor("#F7805C"));//如果单独标记颜色、则会使用这个颜色
        //        calendar.setScheme(text);
        return calendar;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            //获取那些天有录像
            case PlayContract.SEARCH_MONTH_OF_VIDEOABLE:
                map.clear();
                VideoInfoBean videoInfoBean = (VideoInfoBean) o;
                if (videoInfoBean != null) {
                    List<VideoInfoBean.DataBean> infos = videoInfoBean.getData();
                    if (infos != null && infos.size() > 0) {
                        List<String> times = new ArrayList<>();
                        for (VideoInfoBean.DataBean info : infos) {
                            String beginTime = info.getBegintime();
                            if (StringTools.isStringValueOk(beginTime)) {
                                if (beginTime.length() > 10) {
                                    beginTime = beginTime.substring(0, 10);
                                }
                                if (!times.contains(beginTime)) {
                                    times.add(beginTime);
                                }
                            }
                        }
                        //将对应的日期在日历上画点
                        for (String time : times) {
                            map.put(getSchemeCalendar(time).toString(), getSchemeCalendar(time));
                        }
                        //此方法在巨大的数据量上不影响遍历性能，推荐使用
                        mMonthRecordCalendarView.setSchemeDate(map);
                    } else {
                        ToastUtils.toast(mContext, "当月没有录像");
                    }
                }
                break;
            case PlayContract.SEARCH_DAY_OF_VIDEOABLE:
                VideoInfoBean videoBean = (VideoInfoBean) o;
                if (videoBean != null) {
                    List<VideoInfoBean.DataBean> infos = videoBean.getData();
                    if (infos != null && infos.size() > 0) {
                        List<TimeSlot> recordDataList = new ArrayList<>();
                        for (int i = 0; i < infos.size(); i++) {
                            VideoInfoBean.DataBean info = infos.get(i);
                            String beginTime = info.getBegintime();
                            String endTime = info.getEndtime();
                            if (StringTools.isStringValueOk(beginTime) && StringTools.isStringValueOk(endTime)) {
                                if (beginTime.contains("T") && endTime.contains("T")) {
                                    beginTime = beginTime.replace("T", " ");
                                    endTime = endTime.replace("T", " ");
                                    try {
                                        Date beginDate = sdfOfYunControl.parse(beginTime);
                                        Date endDate = sdfOfYunControl.parse(endTime);
                                        recordDataList.add(new TimeSlot(startTime,
                                                CalendarUtil.formatTime(beginDate),
                                                CalendarUtil.formatTime(endDate)));
                                        if (i == 0) {
                                            rulerView.setCurrentTimeMillis(startTime);
                                            rulerView.openMove();
                                            isOneDayRecord = false;
                                            //停止录像流
                                            ((PlayerLiveActivity) getActivity()).stopStream();
                                        }

                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        rulerView.setVedioTimeSlot(recordDataList);
                    } else {
                        ToastUtils.toast(mContext, "当天没有录像");
                    }
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onError(String tag, Object o) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.finish_iv:
                ((PlayerLiveActivity) getActivity()).initControlBtStatus(0);
                break;
            case R.id.pre_month_iv:
                int month = CalendarUtil.getMonthOfPreMonth(currentDate);
                int year = CalendarUtil.getYearOfPreMonth(currentDate);
                currentDate = CalendarUtil.getDateOfPreMonth(currentDate);
                afterChangeMonth(month, year);
                searchVideosCustomMonth(month, year);
                break;
            case R.id.next_month_iv:
                int monthNex = CalendarUtil.getMonthOfNexMonth(currentDate);
                int yearNex = CalendarUtil.getYearOfNexMonth(currentDate);
                currentDate = CalendarUtil.getDateOfNexMonth(currentDate);
                afterChangeMonth(monthNex, yearNex);
                searchVideosCustomMonth(monthNex, yearNex);
                break;
            case R.id.back_to_live_tv:
                //回到直播
                onLine = true;
                ((PlayerLiveActivity) getActivity()).stopStream();
                ((PlayerLiveActivity) getActivity()).initControlBtStatus(3);
                mCurrentVideoTimeTv.performClick();
                break;
            case R.id.zoomplus:
                break;
            case R.id.zoomminus:
                break;
            case R.id.current_video_time_tv:
                mSelectVideoDayCl.setVisibility(View.VISIBLE);
                mOperateVideoCl.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 自定义月份查询录像
     *
     * @param month
     * @param year
     */
    private void searchVideosCustomMonth(int month, int year) {
        calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calendar.set(java.util.Calendar.MINUTE, 0);
        calendar.set(java.util.Calendar.SECOND, 0);
        calendar.set(java.util.Calendar.YEAR, year);
        calendar.set(java.util.Calendar.MONTH, month - 1);
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1);
        String startTime = sdfOfYunControl.format(calendar.getTime()).replace(" ", "T");
        calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calendar.set(java.util.Calendar.MINUTE, 0);
        calendar.set(java.util.Calendar.SECOND, 0);
        calendar.set(java.util.Calendar.YEAR, year);
        calendar.set(java.util.Calendar.MONTH, month);
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1);
        String endTime = sdfOfYunControl.format(calendar.getTime()).replace(" ", "T");
        mPresenter.searchVideos(startTime, endTime,
                ((PlayerLiveActivity) getActivity()).mCameraNum, PlayContract.SEARCH_MONTH_OF_VIDEOABLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 切换月份之后
     *
     * @param month
     * @param year
     */
    private void afterChangeMonth(int month, int year) {
        mSelectMonth.setText(String.format("%s%s%s", year, "-", month));
        if (CalendarUtil.getTimeFromDate("yyyy-MM", currentDate).equals(CalendarUtil.getTimeFromDate("yyyy-MM",
                new Date()))) {//当月界面
            //滚动到指定日期的日历
            mMonthRecordCalendarView.scrollToCalendar(year, month, CalendarUtil.getCurrentDay());

        } else {
            //滚动到指定日期的日历
            mMonthRecordCalendarView.scrollToCalendar(year, month, 1);

        }
    }

    @Override
    public void onDestroyView() {
        rulerView.releaseRes();
        super.onDestroyView();
    }
}
