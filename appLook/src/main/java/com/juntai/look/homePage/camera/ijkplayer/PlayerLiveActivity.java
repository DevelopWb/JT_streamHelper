package com.juntai.look.homePage.camera.ijkplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.utils.MediaUtils;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraOnlineBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.CameraCommentFragment;
import com.juntai.look.homePage.camera.CameraVideoRecordFragment;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.camera.PlayPresent;
import com.juntai.look.homePage.camera.yunkong.CameraYunControlFragment;
import com.juntai.look.main.MainActivity;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;
import com.juntai.look.mine.devManager.devSet.CameraSetActivity;
import com.juntai.look.mine.devManager.share.shareToWechat.ShareToWeChatActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.base.BaseDownLoadActivity;
import com.juntai.wisdom.basecomponent.bean.CaptureBean;
import com.juntai.wisdom.basecomponent.bean.PlayUrlBean;
import com.juntai.wisdom.basecomponent.bean.RecordInfoBean;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;
import com.juntai.wisdom.basecomponent.utils.FileCacheUtils;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
import com.juntai.wisdom.basecomponent.utils.PubUtil;
import com.juntai.wisdom.basecomponent.utils.SoundPlayer;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @aouther tobato
 * @description 描述   播放视频流
 * @date 2020/7/25 16:44
 */



public class PlayerLiveActivity extends BaseDownLoadActivity<PlayPresent> implements PlayContract.IPlayView,
        View.OnClickListener, BaseDownLoadActivity.OnFileDownloaded {

    private PlayerView player;
    //    private String url = "rtmp://juntaikeji.net:1935/video/37130201561327011011";
    private PowerManager.WakeLock wakeLock;
    private Intent intent;
    public static String STREAM_CAMERA_ID = "stream";
    public static String ENTER_TYPE = "entry_type";//进入的入口
    private int enterType = 0;//1代表从硬盘录像机进入
    public static String STREAM_CAMERA_NUM = "stream_num";
    public static String STREAM_CAMERA_THUM_URL = "stream_thum_url";//缩略图路径
    private int mCameraId;//
    public String mCameraNum;//
    private StreamCameraDetailBean.DataBean mStreamCameraBean;//详情
    private String playUrl;
    private CameraCommentFragment cameraCommentFragment;
    private CameraYunControlFragment cameraYunControlFragment;
    private CameraVideoRecordFragment videoRecordFragment;
    private String COMMENT = "COMMENT";//评价
    private String YUN_CONTROL = "YUN_CONTROL";//云控制
    private String VIDEO_RECORD = "VIDEO_RECORD";
    private ImageView mVideoIv, mShareCamera;
    private ImageView mYuntaiIv;
    private ImageView mCalendarIv;
    private String mThumUrl;
    private boolean isPlay = false;
    private String videoStrsessionid = null;
    private ImageView mCameraFloatSet;//摄像头悬浮窗上的设置  右上角那个
    /**
     * 1121321
     */
    private TextView mTopVisitAmountTv;
    public static boolean isVerScreen = true;//是否是竖屏
    private LinearLayout mVideoViewLl;
    private DrawerLayout mDrawerlayout;
    private Group mOperateRightIvsG, mHorSuspensionG, mVerSuspensionG;


    private ImageView mControlUpIv;
    private ImageView mControlLeftIv;
    private ImageView mControlDownIv;
    private ImageView mControlRightIv;
    private TextView mControlStopTv;
    private ImageView mZoomOutIv;
    private ImageView mZoomInIv;
    private ImageView mCollectIv;//收藏预置位
    private ImageView mCutPicIv;
    private ImageView mRecordIv;
    private LinearLayout mFullScreenRightLl;
    private ImageView mYuntaiFloatIv;//悬浮窗上的云台控制
    private ImageView mTopVideoCaptureIv;
    private ImageView mTopVideoRecordIv;
    private ConstraintLayout mFullScreenRightMoreCl;
    private LinearLayout mFullScreenRightControlLl;
    private ImageView mFullScreenShareIv;
    private ImageView mFullScreenSetIv;
    private ImageView mTopMoreIv;
    private TextView mFullScreenVisitAmountTv;
    private TextView mFullScreenOnlineAmountTv;
    private ImageView mZoomShrinkIv;
    private ImageView mVerCaptureIv;//竖屏模式下的截屏
    private boolean isMyDev = true;//默认是我的设备
    private boolean devHasYunTai = false;//设备是否有云台
    private TextView mFullScreenSetTv;
    private boolean hideAllScreen = false;//是否隐藏所有按钮
    private TextView mHorVisitAmountTv;
    private SoundPlayer soundPlayer;

    /**
     * 获取摄像头num
     *
     * @return
     */
    public String getStreamCameraNum() {
        return mCameraNum;
    }

    @Override
    protected PlayPresent createPresenter() {
        return new PlayPresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.simple_player_view_player;
    }

    @Override
    public void initView() {
        if (getIntent() != null) {
            mCameraId = getIntent().getIntExtra(STREAM_CAMERA_ID, 0);
            mCameraNum = getIntent().getStringExtra(STREAM_CAMERA_NUM);
            mThumUrl = getIntent().getStringExtra(STREAM_CAMERA_THUM_URL);
            enterType = getIntent().getIntExtra(ENTER_TYPE, 0);
        }
        hideBottomVirtureBar();
        setFileDownLoadCallBack(this);
        setTitleName("摄像头");
        mVideoIv = (ImageView) findViewById(R.id.video_iv);
        mVideoIv.setOnClickListener(this);
        mShareCamera = (ImageView) findViewById(R.id.share_camera_iv);
        mShareCamera.setOnClickListener(this);
        mCameraFloatSet = (ImageView) findViewById(R.id.top_set_iv);
        mCameraFloatSet.setOnClickListener(this);
        mYuntaiIv = (ImageView) findViewById(R.id.yuntai_iv);
        mYuntaiIv.setOnClickListener(this);
        mCalendarIv = (ImageView) findViewById(R.id.calendar_iv);
        mCalendarIv.setOnClickListener(this);
        mTopVisitAmountTv = (TextView) findViewById(R.id.top_visit_amount_tv);
        mVideoViewLl = (LinearLayout) findViewById(R.id.video_view_ll);
        initDrawerlayout();
        mControlUpIv = (ImageView) findViewById(R.id.control_up_iv);
        mControlUpIv.setOnClickListener(this);
        mControlLeftIv = (ImageView) findViewById(R.id.control_left_iv);
        mControlLeftIv.setOnClickListener(this);
        mControlDownIv = (ImageView) findViewById(R.id.control_down_iv);
        mControlDownIv.setOnClickListener(this);
        mControlRightIv = (ImageView) findViewById(R.id.control_right_iv);
        mControlRightIv.setOnClickListener(this);
        mControlStopTv = (TextView) findViewById(R.id.control_stop_tv);
        mControlStopTv.setOnClickListener(this);
        mZoomOutIv = (ImageView) findViewById(R.id.zoom_out_iv);
        mZoomOutIv.setOnClickListener(this);
        mZoomShrinkIv = (ImageView) findViewById(R.id.zoom_shrink_iv);
        mZoomShrinkIv.setOnClickListener(this);
        mZoomInIv = (ImageView) findViewById(R.id.zoom_in_iv);
        mZoomInIv.setOnClickListener(this);
        mCollectIv = (ImageView) findViewById(R.id.collect_iv);
        mCollectIv.setOnClickListener(this);
        mCutPicIv = (ImageView) findViewById(R.id.cut_pic_iv);
        mCutPicIv.setOnClickListener(this);
        mRecordIv = (ImageView) findViewById(R.id.record_iv);
        mRecordIv.setOnClickListener(this);
        mFullScreenRightLl = (LinearLayout) findViewById(R.id.full_screen_right_control_cl);
        mFullScreenRightControlLl = (LinearLayout) findViewById(R.id.yun_control_Ll);
        mFullScreenRightMoreCl = (ConstraintLayout) findViewById(R.id.full_screen_right_more_cl);
        mTopMoreIv = (ImageView) findViewById(R.id.hor_top_more_iv);
        mTopMoreIv.setOnClickListener(this);
        mYuntaiFloatIv = (ImageView) findViewById(R.id.top_yuntai_iv);
        mYuntaiFloatIv.setOnClickListener(this);
        mTopVideoCaptureIv = (ImageView) findViewById(R.id.top_video_capture_iv);
        mTopVideoCaptureIv.setOnClickListener(this);
        mTopVideoRecordIv = (ImageView) findViewById(R.id.top_video_record_iv);
        mTopVideoRecordIv.setOnClickListener(this);
        mFullScreenShareIv = (ImageView) findViewById(R.id.full_screen_share_iv);
        mFullScreenSetIv = (ImageView) findViewById(R.id.full_screen_set_iv);
        mFullScreenSetTv = (TextView) findViewById(R.id.full_screen_set_tv);
        mFullScreenVisitAmountTv = (TextView) findViewById(R.id.full_screen_visit_amount_tv);
        mFullScreenOnlineAmountTv = (TextView) findViewById(R.id.full_screen_online_amount_tv);
        mHorVisitAmountTv = (TextView) findViewById(R.id.hor_top_visit_amount_tv);
        mFullScreenShareIv.setOnClickListener(this);
        mFullScreenSetIv.setOnClickListener(this);
        mVerCaptureIv = (ImageView) findViewById(R.id.app_video_capture);
        mVerCaptureIv.setOnClickListener(this);
    }

    /**
     * 初始化抽屉布局
     */
    private void initDrawerlayout() {
        mDrawerlayout = findViewById(R.id.drawerlayout);
        mOperateRightIvsG = findViewById(R.id.operate_right_ivs_g);
        mHorSuspensionG = findViewById(R.id.horizontal_suspension_g);
        mVerSuspensionG = findViewById(R.id.vertical_suspension_g);
        mDrawerlayout.setScrimColor(Color.TRANSPARENT);
        mDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerlayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                mOperateRightIvsG.setVisibility(View.GONE);
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                mOperateRightIvsG.setVisibility(View.VISIBLE);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }


    @Override
    public void initData() {
        initControlBtStatus(0);
        //获取摄像头信息
        mPresenter.getStreamCameraDetail(mPresenter.getPublishMultipartBody()
                        .addFormDataPart("id", String.valueOf(mCameraId)).build(),
                PlayContract.GET_STREAM_CAMERA_DETAIL);
        /**
         * 注意！！！注意！！！注意！！！注意！！！注意！！！
         *
         * 播放摄像头流数据的时候 只有流地址是不行的  需要开流  并且还要保活 要不一分钟之后流就断了
         *
         */
        //打开流数据
        mPresenter.openStream(getBaseBuilder().add("chanpubid",
                mCameraNum)
                .add("transport", "udp").add("videourltype", "rtmp").build(), PlayContract.GET_URL_PATH);


    }

    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //去除这个Activity的标题栏
        super.onCreate(savedInstanceState);
        /**常亮*/
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "liveTAG");
        wakeLock.acquire();
        soundPlayer = new SoundPlayer(mContext);

        initPlayer();


    }

    private void initPlayer() {
        player = new PlayerView(this, mBaseRootCol)
                //隐藏顶部布局
                .hideHideTopBar(false)
                //分辨率
                .hideSteam(true)
                //旋转
                .hideRotation(true)
                //隐藏全屏按钮，true隐藏，false为显示
                .hideFullscreen(false)
                .hideCenterPlayer(false)
                .forbidTouch(false)
                .setForbidDoulbeUp(true)
                .setThumPic(UrlFormatUtil.formatStreamCapturePicUrl(mThumUrl))
                .setScaleType(PlayStateParams.fitxy).showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        ImageLoadUtil.loadImageCache(mContext,
                                UrlFormatUtil.formatStreamCapturePicUrl(mThumUrl), ivThumbnail);
                    }
                });
        player.getFullScreenView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(playUrl)) {
                    player.setOnlyFullScreen(true);
                } else {
                    ToastUtils.toast(mContext, "无法获取流地址");
                }
            }
        });

        player.getBackView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换到竖屏模式
                player.setOnlyFullScreen(false);
            }
        });
    }


    /**
     * 获取builder
     *
     * @return
     */
    public FormBody.Builder getBaseBuilder() {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("account", UserInfoManager.getUserAccount());
        builder.add("token", UserInfoManager.getUserToken());
        return builder;
    }

    @Override
    protected String getTitleRightName() {
        return null;
    }

    @Override
    protected String getDownLoadPath() {
        return null;
    }

    @Override
    public void onError(String tag, Object o) {
        super.onError(tag, o);
        switch (tag) {
            case PlayContract.GET_URL_PATH:
                cameraCommentFragment.initStatusData("离线");
                player.isOffLine(true);
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_iv:
                ToastUtils.toast(mContext, "暂未开放");
                break;
            case R.id.share_camera_iv:
                //分享微信
                startActivity(new Intent(mContext, ShareToWeChatActivity.class));
                break;
            case R.id.yuntai_iv:
                //云控
                initControlBtStatus(1);
                break;
            case R.id.top_set_iv:
                //设置
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, CameraSetActivity.class)
                            .putExtra(BaseCameraSetActivity.ENTRANCE_TYPE, 0)
                            .putExtra(BaseCameraSetActivity.DEV_INFO_ID,
                                    mStreamCameraBean.getId()), BaseAppActivity.BASE_REQUESR);
                }

                break;
            case R.id.calendar_iv:
                //查看录像记录
                initControlBtStatus(2);
                break;

            case R.id.control_up_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_UP, PlayContract.OPERATE_YUNTAI_SPEED,
                        mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_left_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_LEFT, PlayContract.OPERATE_YUNTAI_SPEED,
                        mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_down_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_DOWN, PlayContract.OPERATE_YUNTAI_SPEED,
                        mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_right_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_RIGHT, PlayContract.OPERATE_YUNTAI_SPEED,
                        mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_stop_tv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_STOP, PlayContract.OPERATE_YUNTAI_SPEED,
                        mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.zoom_out_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_ZOOM_OUT, PlayContract.OPERATE_YUNTAI_SPEED,
                        mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.zoom_in_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_ZOOM_IN, PlayContract.OPERATE_YUNTAI_SPEED,
                        mCameraNum, PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.collect_iv:
                captureAndUploadFile();
                break;
            case R.id.cut_pic_iv:
                mVerCaptureIv.performClick();
                break;
            case R.id.app_video_capture:
                //竖屏模式下的截屏
                soundPlayer.play();
                mPresenter.capturePic(mCameraNum, "1", PlayContract.GET_STREAM_CAPTURE);
                break;
            case R.id.zoom_shrink_iv:
                //切换到竖屏模式
                player.setOnlyFullScreen(false);
                break;
            case R.id.record_iv:
                ToastUtils.toast(mContext, "暂未开放");
                break;
            case R.id.hor_top_more_iv:
                //更多
                mPresenter.getOnlineAmount(mCameraNum, PlayContract.ONLINE);

                break;
            case R.id.top_yuntai_iv:
                mDrawerlayout.openDrawer(mFullScreenRightLl);
                mFullScreenRightControlLl.setVisibility(View.VISIBLE);
                mFullScreenRightMoreCl.setVisibility(View.GONE);
                break;
            case R.id.top_video_capture_iv:
                mVerCaptureIv.performClick();
                break;
            case R.id.top_video_record_iv:
                ToastUtils.toast(mContext, "暂未开放");
                break;
            case R.id.full_screen_share_iv:
                //分享微信
                startActivity(new Intent(mContext, ShareToWeChatActivity.class));
                break;
            case R.id.full_screen_set_iv:
                mCameraFloatSet.performClick();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BaseAppActivity.BASE_REQUESR == requestCode) {
            //获取摄像头信息
            mPresenter.getStreamCameraDetail(mPresenter.getPublishMultipartBody()
                            .addFormDataPart("id", String.valueOf(mCameraId)).build(),
                    PlayContract.GET_STREAM_CAMERA_DETAIL);
        }
    }

    /**
     * 截图并上传文件  预置位封面图
     */
    public void captureAndUploadFile() {
        mPresenter.capturePic(mCameraNum, "1", PlayContract.GET_STREAM_CAMERA_THUMBNAIL_UPLOAD);
    }


    @Override
    protected void onPause() {
        super.onPause();
        MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaUtils.muteAudioFocus(mContext, false);
        if (wakeLock != null) {
            wakeLock.acquire();
        }
    }

    @Override
    public void onBackPressed() {
        if (player.isOnlyFullScreen) {
            //切换到竖屏模式
            player.setOnlyFullScreen(false);
            return;
        }

        if (wakeLock != null) {
            wakeLock.release();
        }
        if (player != null && player.onBackPressed()) {
            return;
        }
        if (0 == enterType) {
            startActivity(new Intent(mContext, MainActivity.class));
        }

        super.onBackPressed();

    }


    @Override
    public void onSuccess(String tag, Object o) {


        switch (tag) {
            case PlayContract.GET_URL_PATH:
                PlayUrlBean.DataBean bean = (PlayUrlBean.DataBean) o;
                player.isOffLine(false);
                cameraCommentFragment.initStatusData("在线");
                playUrl = bean.getRtmpurl();
                String strsessionid = bean.getStrsessionid();
                player.setPlaySource(playUrl).startPlay();
                /**
                 * 保活
                 */
                intent = new Intent(this, KeepAliveService.class);
                intent.putExtra("sessionId", strsessionid);
                startService(intent);

                break;
            case PlayContract.GET_STREAM_CAMERA_THUMBNAIL_UPLOAD:
                //截图并保存本地 上传  每个num本地始终保存一个图片
                CaptureBean captureBean = (CaptureBean) o;
                int errCode = captureBean.getErrcode();
                if (errCode < 0) {
                    //截图失败
                    ToastUtils.toast(mContext, "截图失败");
                } else {
                    //截图成功 上传封面图（将图片路径上传后台）  http://60.213.43.241:8080/image/37131201561327001001.jpg
                    String imagePath = captureBean.getImageurl();
                    if (!TextUtils.isEmpty(imagePath)) {
                        if (imagePath.contains("image")) {
                            //截图成功 保存本地STREAM_THUMBNAIL
                            downloadFileContentUnique(FileCacheUtils.STREAM_THUMBNAIL, imagePath);
                        }
                    }
                }
                break;
            case PlayContract.GET_STREAM_CAPTURE:
                //单纯截图并保存本地  每个摄像头有N个截图  每次下载完有提示
                CaptureBean captureBeanToLocal = (CaptureBean) o;
                int errMsg = captureBeanToLocal.getErrcode();
                if (errMsg < 0) {
                    //截图失败
                    ToastUtils.toast(mContext, "截图失败");
                } else {
                    //截图成功 保存本地
                    String imagePath = captureBeanToLocal.getImageurl();
                    if (!TextUtils.isEmpty(imagePath)) {
                        downloadFileContent(FileCacheUtils.STREAM_CAPTURE + mStreamCameraBean.getName
                                () + "(" + mStreamCameraBean.getNumber() + ")", imagePath);
                    }
                }
                break;
            case PlayContract.GET_VIDEO_RTMP_URL:
                //获取录像的流地址
                RecordInfoBean videoLiveBean = (RecordInfoBean) o;
                if (videoLiveBean != null) {
                    if (videoLiveBean.getErrcode() == 0) {
                        //有录像
                        playUrl = videoLiveBean.getVideourl();
                        player.setPlaySource(playUrl).startPlay();
                        videoStrsessionid = videoLiveBean.getStrsessionid();
                        Log.e("播放的地址-----------", playUrl);
                        //                    Log.e("播放的地址------sessionid-----",videoStrsessionid);
                        intent.putExtra("sessionId", videoStrsessionid);
                        startService(intent);
                    } else {
                        ToastUtils.toast(mContext, "暂无录像");
                    }

                }
                break;
            case PlayContract.UPLOAD_CAMERA_CAPTURE:
                //上传预置位的封面图
                ToastUtils.toast(mContext, "收藏成功");
                break;
            case PlayContract.STOP_VEDIO_STREAM:
                //停止录像的流
                videoRecordFragment.getVideoRtmpUrl();
                break;
            case PlayContract.ONLINE:
                //获取在线数
                CameraOnlineBean cameraOnlineBean = (CameraOnlineBean) o;
                if (cameraOnlineBean != null) {
                    mDrawerlayout.openDrawer(mFullScreenRightLl);
                    mFullScreenRightControlLl.setVisibility(View.GONE);
                    mFullScreenRightMoreCl.setVisibility(View.VISIBLE);
                    int callNum = cameraOnlineBean.getCallnum();
                    mFullScreenOnlineAmountTv.setText(getString(R.string.online) + String.valueOf(callNum));

                }

                break;
            case PlayContract.GET_STREAM_CAMERA_DETAIL:
                StreamCameraDetailBean detailBean = (StreamCameraDetailBean) o;
                if (detailBean != null) {
                    mStreamCameraBean = detailBean.getData();
                    Hawk.put(HawkProperty.CURRENT_CAMERA_SET, mStreamCameraBean);
                    cameraCommentFragment.initAddrData(mStreamCameraBean.getAddress());
                    int isMine = mStreamCameraBean.getIsMine();
                    int viewNum = mStreamCameraBean.getViewNum();
                    String visitContent = String.format("%s%s", "访问量:", String.valueOf(viewNum));
                    mTopVisitAmountTv.setText(visitContent);
                    mHorVisitAmountTv.setText(visitContent);
                    mFullScreenVisitAmountTv.setText(visitContent);
                    int isYunTai = mStreamCameraBean.getIsYuntai();
                    //是否有云台（0是；1否）
                    if (0 == isYunTai) {
                        devHasYunTai = true;
                    } else {
                        devHasYunTai = false;
                    }
                    //（0是；1否）
                    if (0 == isMine) {
                        isMyDev = true;
                    } else {
                        isMyDev = false;
                    }
                }
                initLayoutByOritation();

                break;
            case PlayContract.OPERATE_RECORD_VIDEO:
                player.isLive = false;
                player.onPlayPause();

                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isVerScreen = true;
        soundPlayer.release();
        if (player != null) {
            player.onDestroy();
        }
        if (intent != null) {
            stopService(intent);
        }
        setFileDownLoadCallBack(null);
    }

    /**
     * 停止流
     */
    public void stopStream() {
        if (videoStrsessionid != null) {
            mPresenter.stopStream(videoStrsessionid, PlayContract.STOP_VEDIO_STREAM);
        } else {
            videoRecordFragment.getVideoRtmpUrl();
        }

    }


    @Override
    public void onFileDownloaded(String filePath) {
        if (!filePath.contains(FileCacheUtils.STREAM_CAPTURE)) {
            //截图保存  每个num只有一张
            String fileName = filePath.substring(filePath.lastIndexOf(
                    "/") + 1, filePath.lastIndexOf("."));
            //压缩图片作为缩略图
            compressImage(filePath, FileCacheUtils.STREAM_THUMBNAIL, fileName, new OnImageCompressedPath() {
                @Override
                public void compressedImagePath(File file) {
                    if (mPresenter == null) {
                        return;
                    }
                    MultipartBody.Builder builder = mPresenter.getPublishMultipartBody()
                            .addFormDataPart("number", String.valueOf(mCameraNum))
                            .addFormDataPart("file", fileName, RequestBody.create(MediaType.parse("file"),
                                    file));
                    //上传缩略图
                    mPresenter.addPrePosition(builder.build(), PlayContract
                            .UPLOAD_CAMERA_CAPTURE);
                }
            });
        }

    }


    /**
     * 初始化控件的状态
     *
     * @param i
     */
    public void initControlBtStatus(int i) {
        mYuntaiIv.setImageResource(R.mipmap.playview_icon_yuntai_nor);
        mCalendarIv.setImageResource(R.mipmap.playview_calendar_video_normal);
        switch (i) {
            case 0:
                initFragmentSelected(0);
                break;
            case 1:
                initFragmentSelected(1);
                mYuntaiIv.setImageResource(R.mipmap.playview_icon_yuntai_pre);
                break;
            case 2:
                initFragmentSelected(2);
                mCalendarIv.setImageResource(R.mipmap.playview_calendar_video_press);
                break;
            case 3:
                initFragmentSelected(0);
                //回到直播
                //                String playUrl = Hawk.get(HawkProperty.LIVE_PlAY_URL);
                //                String sessionId = Hawk.get(HawkProperty.LIVE_CAMERA_SESSION_ID);
                //                player.setPlaySource(playUrl).startPlay();
                //                intent.putExtra("sessionId", sessionId);
                //                startService(intent);
                //打开流数据
                mPresenter.openStream(getBaseBuilder().add("chanpubid",
                        mCameraNum)
                        .add("transport", "udp").add("videourltype", "rtmp").build(), PlayContract.GET_URL_PATH);
                break;
            default:
                break;
        }
    }

    /**
     * 获取各个fragment对象
     */
    private void initFragments() {
        if (cameraCommentFragment == null) {
            cameraCommentFragment = new CameraCommentFragment();
        }
        if (cameraYunControlFragment == null) {
            cameraYunControlFragment = new CameraYunControlFragment();
        }
        if (videoRecordFragment == null) {
            videoRecordFragment = new CameraVideoRecordFragment();
        }
    }

    /**
     * 初始化fragment
     *
     * @param i
     */
    private void initFragmentSelected(int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hindFragments(fragmentTransaction);
        initFragments();
        switch (i) {
            case 0:
                if (!cameraCommentFragment.isAdded()) {
                    fragmentTransaction.add(R.id.camera_fl, cameraCommentFragment, COMMENT);
                }
                fragmentTransaction.show(cameraCommentFragment);
                break;
            case 1:
                if (!cameraYunControlFragment.isAdded()) {
                    fragmentTransaction.add(R.id.camera_fl, cameraYunControlFragment, YUN_CONTROL);
                }
                fragmentTransaction.show(cameraYunControlFragment);
                break;
            case 2:
                if (!videoRecordFragment.isAdded()) {
                    fragmentTransaction.add(R.id.camera_fl, videoRecordFragment, VIDEO_RECORD);
                }
                videoRecordFragment.setOnlineStatus(false);
                fragmentTransaction.show(videoRecordFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏所有的fragment
     *
     * @param fragmentTransaction
     */
    private void hindFragments(FragmentTransaction fragmentTransaction) {

        if (cameraCommentFragment != null) {
            fragmentTransaction.hide(cameraCommentFragment);
        }
        if (cameraYunControlFragment != null) {
            fragmentTransaction.hide(cameraYunControlFragment);
        }
        if (videoRecordFragment != null) {
            fragmentTransaction.hide(videoRecordFragment);
        }
    }

    /**
     * //获取录像的流地址
     *
     * @param begintime
     * @param endtime
     */
    public void getVideoRtmpUrl(String begintime, String endtime) {
        Map<String, String> map = new ArrayMap<>();
        map.put("channelid", mCameraNum);
        map.put("begintime", begintime);
        map.put("endtime", endtime);
        map.put("transport", "udp");
        map.put("videourltype", "rtmp");
        mPresenter.playHisVideo(map, PlayContract.GET_VIDEO_RTMP_URL);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏

            isVerScreen = false;
            //显示横屏的布局
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mVideoViewLl.getLayoutParams();
            params.height = ConstraintLayout.LayoutParams.MATCH_PARENT;
            params.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
            mVideoViewLl.setLayoutParams(params);
            mPresenter.setMarginOfConstraintLayout(mVideoViewLl, mContext, 0, 0, 0, 0);
            getToolbar().setVisibility(View.GONE);
            mVideoViewLl.postDelayed(new Runnable() {
                @Override
                public void run() {
                    player.setFatherW_H(mVideoViewLl.getTop(), mVideoViewLl.getBottom());
                }
            }, 100);
            player.updateRender();
            initLayoutByOritation();
        } else {
            //竖屏
            //            showBottomVirtureBar();
            isVerScreen = true;
            //显示竖屏的布局
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mVideoViewLl.getLayoutParams();
            params.height = DisplayUtil.dp2px(mContext, 190);
            params.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
            mVideoViewLl.setLayoutParams(params);
            getToolbar().setVisibility(View.VISIBLE);
            mPresenter.setMarginOfConstraintLayout(mVideoViewLl, mContext, 10, 10, 10, 10);
            getToolbar().setVisibility(View.VISIBLE);
            player.updateRender();
            initLayoutByOritation();


        }
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    /**
     * 初始化布局
     */
    private void initLayoutByOritation() {

        if (isVerScreen) {
            //隐藏横屏悬浮布局 显示竖屏 悬浮布局

            mHorSuspensionG.setVisibility(View.GONE);
            mOperateRightIvsG.setVisibility(View.GONE);
            if (hideAllScreen) {
                mVerSuspensionG.setVisibility(View.GONE);
            } else {
                mVerSuspensionG.setVisibility(View.VISIBLE);
            }
        } else {
            //隐藏竖屏悬浮布局 显示横屏 悬浮布局
            mVerSuspensionG.setVisibility(View.GONE);
            if (hideAllScreen) {
                mHorSuspensionG.setVisibility(View.GONE);
                mOperateRightIvsG.setVisibility(View.GONE);
            } else {
                mHorSuspensionG.setVisibility(View.VISIBLE);
                mOperateRightIvsG.setVisibility(View.VISIBLE);
            }

        }
        if (isMyDev) {
            if (isVerScreen) {
                if (hideAllScreen) {
                    mCameraFloatSet.setVisibility(View.GONE);
                } else {
                    mCameraFloatSet.setVisibility(View.VISIBLE);
                }

            } else {
                mCameraFloatSet.setVisibility(View.GONE);
            }
            if (hideAllScreen) {
                mFullScreenSetTv.setVisibility(View.GONE);
            } else {
                mFullScreenSetTv.setVisibility(View.VISIBLE);

            }
            //自己的设备 可以查看录像回放
            mCalendarIv.setVisibility(View.VISIBLE);
            if (devHasYunTai) {
                mYuntaiIv.setVisibility(View.VISIBLE);
                if (isVerScreen) {
                    mYuntaiFloatIv.setVisibility(View.INVISIBLE);
                } else {
                    if (hideAllScreen) {
                        mYuntaiFloatIv.setVisibility(View.INVISIBLE);
                    } else {
                        mYuntaiFloatIv.setVisibility(View.VISIBLE);
                    }

                }
            } else {
                mYuntaiIv.setVisibility(View.INVISIBLE);
                mYuntaiFloatIv.setVisibility(View.INVISIBLE);
            }

        } else {
            String permission = mStreamCameraBean.getSharePowerName();
            mCameraFloatSet.setVisibility(View.GONE);
            mFullScreenSetTv.setVisibility(View.GONE);
            mFullScreenSetIv.setVisibility(View.GONE);
            if (devHasYunTai) {
                // 看分享权限 如果有云台控制权限 就显示
                if (StringTools.isStringValueOk(permission)) {
                    if (permission.contains(PlayContract.PERMISSION_CONTROL)) {
                        if (hideAllScreen) {
                            mYuntaiIv.setVisibility(View.GONE);
                        } else {
                            mYuntaiIv.setVisibility(View.VISIBLE);
                        }

                        if (isVerScreen) {
                            mYuntaiFloatIv.setVisibility(View.INVISIBLE);
                        } else {
                            if (hideAllScreen) {
                                mYuntaiFloatIv.setVisibility(View.GONE);
                            } else {
                                mYuntaiFloatIv.setVisibility(View.VISIBLE);
                            }
                        }
                    } else {
                        mYuntaiIv.setVisibility(View.INVISIBLE);
                        mYuntaiFloatIv.setVisibility(View.INVISIBLE);
                    }
                }
            } else {
                mYuntaiIv.setVisibility(View.INVISIBLE);
                mYuntaiFloatIv.setVisibility(View.INVISIBLE);
            }
            // 看分享权限 如果有录像回放权限 就显示日历按钮
            if (StringTools.isStringValueOk(permission)) {
                if (permission.contains(PlayContract.PERMISSION_RECORD)) {
                    if (hideAllScreen) {
                        mCalendarIv.setVisibility(View.GONE);
                    } else {
                        mCalendarIv.setVisibility(View.VISIBLE);
                    }
                } else {
                    mCalendarIv.setVisibility(View.GONE);
                }
            }


        }

    }


    /**
     * 隐藏pad底部虚拟键
     */
    protected void hideBottomVirtureBar() {
        Window window;
        window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
        window.setAttributes(params);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onOneClick(String msg) {
        switch (msg) {
            case PubUtil.ONE_CLICK_EVENT:
                hideAllScreen = !hideAllScreen;
                if (hideAllScreen) {
                    player.getBarPlayerView().setVisibility(View.GONE);
                    player.getBarSoundView().setVisibility(View.GONE);
                } else {
                    player.getBarPlayerView().setVisibility(View.VISIBLE);
                    player.getBarSoundView().setVisibility(View.VISIBLE);
                }
                initLayoutByOritation();

                break;
            default:
                break;
        }
    }


}
