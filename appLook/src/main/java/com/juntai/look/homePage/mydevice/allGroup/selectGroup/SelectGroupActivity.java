package com.juntai.look.homePage.mydevice.allGroup.selectGroup;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.CreateGroupActivity;
import com.juntai.look.homePage.mydevice.allGroup.camerasOfGroup.CamerasListActivity;
import com.juntai.look.homePage.mydevice.allGroup.transferDev.TransferDevActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.utils.LiveDataManager;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  选择分组
 * @date 2020/9/3 11:33
 */
public class SelectGroupActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private SelectGroupAdapter adapter;

    public static String CAMERA_ID = "cameraid";
    public static String GROUP_ID = "groupid";
    private int cameraId;
    private int groupId;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.recycleview_layout;
    }

    @Override
    public void initView() {
        setTitleName("设备分组");
        getTitleRightTv().setText("新建");
        getTitleRightTv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(mContext, CreateGroupActivity.class), BASE_REQUESR);
            }
        });
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        adapter = new SelectGroupAdapter(R.layout.select_group_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CameraGroupBean.DataBean bean = (CameraGroupBean.DataBean) adapter.getData().get(position);
                if (bean.isSelected()) {
                    bean.setSelected(false);
                } else {
                    bean.setSelected(true);
                }
                adapter.notifyItemChanged(position);
                    //将摄像头转入group
                    mPresenter.transferDev(getBaseBuilder().add("id", String.valueOf(cameraId)).add("groupId",
                            String.valueOf(bean.getId())).build(), MyDeviceContract.TRANSFER_DEV);

            }
        });
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            cameraId = getIntent().getIntExtra(CAMERA_ID,0);
            groupId = getIntent().getIntExtra(GROUP_ID,0);
        }
        mPresenter.getVideoGroup(getBaseBuilder().build(), MyDeviceContract.CAMERA_GROUP);
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.CAMERA_GROUP:
                CameraGroupBean cameraGroupBean = (CameraGroupBean) o;
                if (cameraGroupBean != null) {
                    List<CameraGroupBean.DataBean> arrays = cameraGroupBean.getData();
                    if (arrays != null) {
                        for (CameraGroupBean.DataBean array : arrays) {
                            if (array.getId() == groupId) {
                                array.setSelected(true);
                            } else {
                                array.setSelected(false);
                            }
                        }
                        Hawk.put(HawkProperty.CAMERA_GROUP, arrays);
                        MutableLiveData<String> bean =
                                LiveDataManager.getInstance().with(LiveDataManager.GROUP_LIST_KEY, String.class);
                        bean.postValue("测试测试");
                        adapter.setNewData(arrays);
                    }

                }
                break;
            case MyDeviceContract.TRANSFER_DEV:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR==requestCode) {
            mPresenter.getVideoGroup(getBaseBuilder().build(), MyDeviceContract.CAMERA_GROUP);

        }
    }
}
