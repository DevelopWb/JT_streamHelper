package com.juntai.look.mine.devManager.devSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.SharedLiveTypeBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.mydevice.ModifyNameOrPwdActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.look.main.MainActivity;
import com.juntai.look.mine.devManager.devSet.cameraType.DevTypeEditActivity;
import com.juntai.look.mine.devManager.share.SharedAccountActivity;
import com.juntai.look.mine.devManager.share.shareToWechat.ShareToWeChatActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.juntai.wisdom.bdmap.act.LocateSelectionActivity;
import com.orhanobut.hawk.Hawk;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述   摄像头设置的基类
 * @CreateDate: 2020/9/14 11:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/14 11:35
 */
public abstract class BaseCameraSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView
        , View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mCameraNoTv;
    /**
     * 肯德基法兰
     */
    private TextView mCameraNameTv;
    /**
     * 球技
     */
    private TextView mCameraTypeTv;
    /**
     * fdasdfsadfsad
     */
    private TextView mCameraAddrTv;
    /**
     * 球防守打法技
     */
    private TextView mCameraGroupTv;
    /**
     * 分享到微信
     */
    private TextView mCameraShareWxTv;
    /**
     * 分享给好友账号
     */
    private TextView mCameraShareUserTv;
    /**
     * 本地全时段录像
     */
    private TextView mCameraRecordTv;
    /**
     * 删除设备
     */
    private TextView mDeleteDevTv;
    private LinearLayout mPosLl;
    private LinearLayout mGroupLl;
    public static String DEV_INFO_ID = "devinfoId";//设备信息
    public static String DEV_INFO = "devinfo";//设备信息
    public static String CAMERA_NUM = "cameraNum";//摄像头num
    public static String ENTRANCE_TYPE = "entrance_type";//打开此类的类型  0代表播放界面进入 1代表设备管理界面进入
    private int devId;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;
    private CharSequence[] types = null;
    private List<SharedLiveTypeBean.DataBean> arrays;
    private Switch mShareWorldSw;
    private String liveTypeName = null;
    private int liveTypeId = -1;
    private int position = 0;//直播类型默认选择位置
    private int entranceType = 0;

    protected abstract boolean isCameraOfNvr();

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_camera_set;
    }

    @Override
    public void initView() {
        setTitleName("设置");
        mCameraNoTv = (TextView) findViewById(R.id.camera_no_tv);
        mCameraNoTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               new AlertDialog.Builder(mContext).setMessage("是否确定重启设备？")
                       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                               mPresenter.operateDev(mStreamCameraBean.getNumber(), "reboot", "", MyDeviceContract.RESTART_DEV);
                           }
                       }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               }).show();
                return true;
            }
        });
        mCameraNameTv = (TextView) findViewById(R.id.camera_name_tv);
        mCameraTypeTv = (TextView) findViewById(R.id.camera_type_tv);
        mCameraAddrTv = (TextView) findViewById(R.id.camera_addr_tv);
        mCameraGroupTv = (TextView) findViewById(R.id.camera_group_tv);
        mCameraShareWxTv = (TextView) findViewById(R.id.camera_share_wx_tv);
        mCameraShareWxTv.setOnClickListener(this);
        mCameraShareUserTv = (TextView) findViewById(R.id.camera_share_user_tv);
        mCameraShareUserTv.setOnClickListener(this);
        mCameraRecordTv = (TextView) findViewById(R.id.camera_record_tv);
        mCameraRecordTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
        mCameraNameTv.setOnClickListener(this);
        mCameraTypeTv.setOnClickListener(this);
        mCameraAddrTv.setOnClickListener(this);
        mCameraGroupTv.setOnClickListener(this);

        mPosLl = (LinearLayout) findViewById(R.id.pos_ll);
        mGroupLl = (LinearLayout) findViewById(R.id.group_ll);
        if (isCameraOfNvr()) {
            mPosLl.setVisibility(View.GONE);
            mGroupLl.setVisibility(View.GONE);
        } else {
            mPosLl.setVisibility(View.VISIBLE);
            mGroupLl.setVisibility(View.VISIBLE);
        }

        mPresenter.getSharedLiveType(getBaseBuilder().build(), MyDeviceContract.SHARED_TYPE);
        mShareWorldSw = (Switch) findViewById(R.id.share_world_sw);
        mShareWorldSw.setOnClickListener(this);
        //禁止滑动
        mShareWorldSw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return event.getActionMasked() == MotionEvent.ACTION_MOVE;
            }
        });
    }


    @Override
    public void initData() {
        if (getIntent() != null) {
            devId = getIntent().getIntExtra(DEV_INFO_ID, 0);
            entranceType = getIntent().getIntExtra(ENTRANCE_TYPE,0);
            mPresenter.getStreamCameraDetail(getBaseBuilder().add("id", String.valueOf(devId)).build(),
                    PlayContract.GET_STREAM_CAMERA_DETAIL);
        }

    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.DEL_DEV:
                ToastUtils.toast(mContext, "删除成功");
                if (0==entranceType) {
                    //播放界面进入  删除后跳转到mainactivity
                    startActivity(new Intent(mContext, MainActivity.class));
                }else {
                    finish();
                }

                break;
            case MyDeviceContract.RESTART_DEV:
                ToastUtils.toast(mContext, "重启成功");

                break;
            case PlayContract.GET_STREAM_CAMERA_DETAIL:
                StreamCameraDetailBean detailBean = (StreamCameraDetailBean) o;
                if (detailBean != null) {
                    mStreamCameraBean = detailBean.getData();
                    Hawk.put(HawkProperty.CURRENT_CAMERA_SET, mStreamCameraBean);
                    liveTypeId = mStreamCameraBean.getShareTypeId();
                    liveTypeName = mStreamCameraBean.getShareTypeName();
                    mCameraNoTv.setText(mStreamCameraBean.getNumber());
                    mCameraNameTv.setText(mStreamCameraBean.getName());
                    mCameraTypeTv.setText(mStreamCameraBean.getTypeName());
                    mCameraAddrTv.setText(mStreamCameraBean.getAddress());
                    mCameraGroupTv.setText(mStreamCameraBean.getGroupName());
                    if (0 == mStreamCameraBean.getIsShare()) {
                        // 是否分享到视频广场（0是；1否）
                        mShareWorldSw.setChecked(true);
                    } else {
                        mShareWorldSw.setChecked(false);
                    }

                }
                break;
            case MyDeviceContract.SHARED_TYPE:
                SharedLiveTypeBean sharedLiveTypeBean = (SharedLiveTypeBean) o;
                if (sharedLiveTypeBean != null) {
                    arrays = sharedLiveTypeBean.getData();
                    if (arrays != null) {
                        types = new CharSequence[arrays.size()];
                        for (int i = 0; i < arrays.size(); i++) {
                            types[i] = arrays.get(i).getName();

                        }
                    }
                }

                break;

            case MyDeviceContract.SHARED_LIVE:
                ToastUtils.toast(mContext, "已成功提交申请");
                break;
            case MyDeviceContract.DELETE_LIVE:
                ToastUtils.toast(mContext, "已关闭全球直播");
                initData();
                break;
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.camera_share_wx_tv:
                //分享至微信
                startActivity(new Intent(mContext, ShareToWeChatActivity.class));
                break;
            case R.id.share_world_sw:
                //全球直播
                if (0 == mStreamCameraBean.getIsShare()) {
                    // 是否分享到视频广场（0是；1否）
                    mShareWorldSw.setChecked(true);
                    //调用关闭直播的申请
                    mPresenter.closeGlobalLive(getBaseBuilder().add("number", mStreamCameraBean.getNumber()).build(),
                            MyDeviceContract.DELETE_LIVE);
                } else {
                    mShareWorldSw.setChecked(false);
                    if (!StringTools.isStringValueOk(liveTypeName)) {
                        position = 0;
                    } else {
                        for (int i = 0; i < arrays.size(); i++) {
                            SharedLiveTypeBean.DataBean array = arrays.get(i);
                            if (liveTypeName.equals(array.getName())) {
                                position = i;
                                break;
                            }
                        }
                    }
                    new AlertDialog.Builder(mContext).setTitle("直播类型选择")
                            .setSingleChoiceItems(types, position, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    position = which;
                                }
                            }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            for (int i = 0; i < arrays.size(); i++) {
                                SharedLiveTypeBean.DataBean array = arrays.get(i);
                                if (position == i) {
                                    liveTypeId = array.getId();
                                    break;
                                }
                            }

                            // 调用直播分享的接口
                            mPresenter.requestGlobalLive(getBaseBuilder().add("number",
                                    mStreamCameraBean.getNumber()).add("shareTypeId",
                                    String.valueOf(liveTypeId)).build(), MyDeviceContract.SHARED_LIVE);
                        }
                    }).show();

                }

                break;
            case R.id.camera_share_user_tv:
                //分享到账号
                if (mStreamCameraBean != null) {
                    startActivity(new Intent(mContext, SharedAccountActivity.class).putExtra(CAMERA_NUM,
                            mStreamCameraBean.getNumber()));
                }


                break;
            case R.id.camera_record_tv:
                //录像设置
                startActivity(new Intent(mContext, VideoSetActivity.class));
                break;
            case R.id.delete_dev_tv:
                //删除设备
                new AlertDialog.Builder(mContext)
                        .setMessage("删除后无法恢复,确定删除设备吗?")
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除设备
                        if (mStreamCameraBean != null) {
                            mPresenter.deleteDev(getBaseBuilder().add("number",
                                    String.valueOf(mStreamCameraBean.getNumber())).build(), MyDeviceContract.DEL_DEV);
                        }

                    }
                }).show();
                break;
            case R.id.camera_name_tv:
                //摄像头名称
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, ModifyNameOrPwdActivity.class).putExtra(ModifyNameOrPwdActivity.CONTENT, mStreamCameraBean.getName())
                            .putExtra(ModifyNameOrPwdActivity.TYPE, 1)
                            .putExtra(SelectGroupActivity.CAMERA_ID, mStreamCameraBean.getId()), BASE_REQUESR);
                }
                break;
            case R.id.camera_type_tv:
                //摄像头类型
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, DevTypeEditActivity.class).putExtra(DEV_INFO,
                            mStreamCameraBean), BASE_REQUESR);
                }

                break;
            case R.id.camera_addr_tv:
                startActivityForResult(new Intent(mContext, LocateSelectionActivity.class),
                        LocateSelectionActivity.SELECT_ADDR);
                break;
            case R.id.camera_group_tv:
                //设备分组
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, SelectGroupActivity.class).putExtra(SelectGroupActivity.CAMERA_ID,
                            mStreamCameraBean.getId()).putExtra(SelectGroupActivity.GROUP_ID,
                            mStreamCameraBean.getGroupId()),
                            BASE_REQUESR);
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR == requestCode) {
            initData();
        }
        if (LocateSelectionActivity.SELECT_ADDR == resultCode) {
            if (data != null) {
                String addr = data.getStringExtra(LocateSelectionActivity.SELECTED_ADDR);
                String lat = data.getStringExtra(LocateSelectionActivity.SELECTED_LAT);
                String lng = data.getStringExtra(LocateSelectionActivity.SELECTED_LNG);
                mCameraAddrTv.setText(addr);
                //调用设置位置的接口
                if (mStreamCameraBean != null) {
                    mPresenter.saveCameraConfig(getBaseBuilder().add("id", String.valueOf(mStreamCameraBean.getId()))
                                    .add("address", addr)
                                    .add("latitude", lat)
                                    .add("longitude", lng)
                                    .build(),
                            MyDeviceContract.SAVE_CONFIG);
                }



            }
        }
    }

}