package com.juntai.look.mine;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.main.MainActivity;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.bean.MineMenuBean;
import com.juntai.look.bean.UserBaseMsgBean;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.hcb.R;
import com.juntai.look.entrance.login.LoginActivity;
import com.juntai.look.mine.about.AboutUsActivity;
import com.juntai.look.mine.myMsg.MyMsgActivity;
import com.juntai.look.mine.devManager.DevManagerActivity;
import com.juntai.look.mine.myShare.MyShareActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ActivityManagerTool;
import com.juntai.wisdom.basecomponent.utils.DialogUtil;
import com.juntai.wisdom.basecomponent.utils.FileCacheUtils;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
import com.juntai.wisdom.basecomponent.utils.RxTask;
import com.juntai.wisdom.basecomponent.utils.RxTaskManager;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;


/**
 * @aouther tobato
 * @description 描述  个人中心
 * @date 2020/7/16 16:14
 */

public class MineFragment extends BaseAppFragment<MinePresent> implements MineContract.IMineView, View.OnClickListener {
    private ImageView mUserHeadIv;
    /**
     * 测试姓名
     */
    private TextView mUserNickNameTv;
    /**
     * 职位
     */
    private TextView mUserWorkerTv;
    private ConstraintLayout mMineUserCl;
    private RecyclerView mMineMenuRv;
    /**
     * 退出账号
     */
    private TextView mLoginOutTv;
    private MineMenuAdapter mineMenuAdapter;
    private UserBaseMsgBean.DataBean userBean;

    @Override
    protected MinePresent createPresenter() {
        return new MinePresent();
    }

    @Override
    protected void lazyLoad() {
        mPresenter.getUserBaseInfo(getBaseAppActivity().getBaseMapOfGET(), MineContract.USER_INFO);

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.mine_fragment_layout;
    }

    @Override
    protected void initView() {

        mUserHeadIv = (ImageView) getView(R.id.user_head_iv);
        mUserNickNameTv = (TextView) getView(R.id.user_nick_name_tv);
        mUserWorkerTv = (TextView) getView(R.id.user_worker_tv);
        mMineUserCl = (ConstraintLayout) getView(R.id.mine_user_cl);
        mMineUserCl.setOnClickListener(this);
        mMineMenuRv = (RecyclerView) getView(R.id.mine_menu_rv);
        mLoginOutTv = (TextView) getView(R.id.login_out_tv);
        mLoginOutTv.setOnClickListener(this);
        mineMenuAdapter = new MineMenuAdapter(R.layout.mine_menu_item);
        getBaseActivity().initRecyclerview(mMineMenuRv, mineMenuAdapter, LinearLayoutManager.VERTICAL);
        mineMenuAdapter.setNewData(mPresenter.getMenus());
        mineMenuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MineMenuBean menuBean = (MineMenuBean) adapter.getData().get(position);
                switch (menuBean.getName()) {
                    case MineContract.MINE_DEV_MANAGER:
                        startActivity(new Intent(mContext, DevManagerActivity.class));
                        break;
                    case MineContract.MINE_MSG:
                        ToastUtils.toast(mContext,"暂未开放");
//                        startActivityForResult(new Intent(mContext, MyMsgActivity.class), MyMsgActivity.IS_READ_RESULT);
                        break;
                    case MineContract.MINE_SHARE:
                        startActivity(new Intent(mContext, MyShareActivity.class));
                        break;
                    case MineContract.MINE_MODIFY_PWD:
                        startActivity(new Intent(mContext, ModifyPwdActivity.class));
                        break;
                    case MineContract.MINE_CLEAR:
                        DialogUtil.getMessageDialog(mContext, "将清理掉应用本地的图片和视频缓存文件",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        RxTaskManager.doTask((MainActivity) getActivity(), new RxTask<String>() {
                                            @Override
                                            public String doOnIoThread() {
                                                FileCacheUtils.clearAll(mContext.getApplicationContext());
                                                return "清理成功";
                                            }

                                            @Override
                                            public void doOnUIThread(String s) {
                                                ToastUtils.success(mContext.getApplicationContext(), s);
                                            }
                                        });
                                    }
                                }).show();
                        break;
                    case MineContract.MINE_UPDATE:
                        ((MainActivity) getActivity()).update(true);
                        break;
                    case MineContract.MINE_ABOUT_US:
                        startActivity(new Intent(mContext, AboutUsActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MineContract.LOGOUT:
                Hawk.delete(HawkProperty.USER_INFO);
                ActivityManagerTool.getInstance().finishApp();
                startActivity(new Intent(mContext, LoginActivity.class));
                break;
            case MineContract.USER_INFO:
                //个人基本信息
                UserBaseMsgBean userBaseMsgBean = (UserBaseMsgBean) o;
                if (userBaseMsgBean != null) {
                    userBean = userBaseMsgBean.getData();
                    if (userBean != null) {
                        ImageLoadUtil.loadCircularImage(mContext, userBean.getHeadPortrait(), R.mipmap.default_head_icon, R.mipmap.default_head_icon,
                                mUserHeadIv);
                        mUserNickNameTv.setText(userBean.getNickName());
                        mUserWorkerTv.setText(userBean.getPermanentAddress());
                    }
                }
                break;

            default:
                break;
        }
    }

    /**
     * 获取未读消息数
     * @param unReadMsgBean
     */
    public void  setUnReadMsg(UnReadMsgBean unReadMsgBean){
        int size = unReadMsgBean.getData();
        if (size > 0) {
            if (mineMenuAdapter!=null) {
                ((MineMenuBean) mineMenuAdapter.getData().get(1)).setUnReadNum(size);
                mineMenuAdapter.notifyItemChanged(1);
            }

        }else{
            if (mineMenuAdapter!=null) {
                ((MineMenuBean) mineMenuAdapter.getData().get(1)).setUnReadNum(0);
                mineMenuAdapter.notifyItemChanged(1);
            }

        }
    }
    @Override
    public void onError(String tag, Object o) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (MyBaseInfoActivity.MODIFY_HEAD_ICON == resultCode) {
            lazyLoad();
        } else if (MyMsgActivity.IS_READ_RESULT == resultCode) {
            lazyLoad();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mine_user_cl:
                startActivityForResult(new Intent(mContext, MyBaseInfoActivity.class).putExtra("user_head_default", userBean),
                        MyBaseInfoActivity.MODIFY_HEAD_ICON);
                break;
            case R.id.login_out_tv:
                mPresenter.logout(getBaseAppActivity().getPublishMultipartBody().build(), MineContract.LOGOUT);
                break;
        }
    }
}

