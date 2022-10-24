package com.juntai.look.mine;

import com.juntai.look.AppNetModule;
import com.juntai.look.bean.MineMenuBean;
import com.juntai.look.bean.ServiceRecordBean;
import com.juntai.look.bean.UserBaseMsgBean;
import com.juntai.look.bean.mine.MyMsgBean;
import com.juntai.look.bean.mine.MyShareBean;
import com.juntai.look.hcb.R;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.mvp.IModel;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/16 16:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/16 16:15
 */
public class MinePresent extends BasePresenter<IModel, MineContract.IMineView> implements MineContract.IMinePresent {
    @Override
    protected IModel createModel() {
        return null;
    }

    /**
     * 获取我的 菜单
     * @return
     */
    public List<MineMenuBean> getMenus() {
        List<MineMenuBean> arrays = new ArrayList<>();
        arrays.add(new MineMenuBean(MineContract.MINE_DEV_MANAGER, R.mipmap.mine_dev_manager, 0));
        arrays.add(new MineMenuBean(MineContract.MINE_MSG, R.mipmap.mine_msg, 0));
        arrays.add(new MineMenuBean(MineContract.MINE_SHARE, R.mipmap.mine_share, 0));
        arrays.add(new MineMenuBean(MineContract.MINE_MODIFY_PWD, R.mipmap.mine_modify_pwd, 0));
        arrays.add(new MineMenuBean(MineContract.MINE_CLEAR, R.mipmap.mine_clear, 0));
        arrays.add(new MineMenuBean(MineContract.MINE_UPDATE, R.mipmap.mine_update, 0));
        arrays.add(new MineMenuBean(MineContract.MINE_ABOUT_US, R.mipmap.mine_about, 0));

        return arrays;
    }

    @Override
    public void logout(RequestBody requestBody, String tag) {
        AppNetModule
                .createrRetrofit()
                .logout(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }


    @Override
    public void getUserBaseInfo(Map<String,String> map, String tag) {
        AppNetModule
                .createrRetrofit()
                .persionalInfo(map)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<UserBaseMsgBean>(getView()) {
                    @Override
                    public void onSuccess(UserBaseMsgBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }

    @Override
    public void modifyHeadIcon(RequestBody requestBody, String tag) {
        AppNetModule
                .createrRetrofit()
                .modifyHeadIcon(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }

    @Override
    public void modifyPwd(RequestBody requestBody, String tag) {
        AppNetModule
                .createrRetrofit()
                .modifyPwd(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }

    @Override
    public void myShare(RequestBody requestBody, String tag) {
        AppNetModule
                .createrRetrofit()
                .myShare(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<MyShareBean>(getView()) {
                    @Override
                    public void onSuccess(MyShareBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }
    @Override
    public void delShare(RequestBody requestBody, String tag) {
        AppNetModule
                .createrRetrofit()
                .delShare(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }



}
