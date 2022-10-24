package com.juntai.look.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juntai.look.base.selectPics.BaseSelectPicActivity;
import com.juntai.look.bean.TextListBean;
import com.juntai.look.bean.UserBaseMsgBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @aouther tobato
 * @description 描述  我的基本信息
 * @date 2020/7/25 17:42
 */
public class MyBaseInfoActivity extends BaseSelectPicActivity<MinePresent> implements MineContract.IMineView {


    public static final int MODIFY_HEAD_ICON = 1032;//修改头像
    public static final int START_CROP_IMAGE_REQUEST = 0x4;
    MyInfoAdapter myInfoAdapter;
    ImageView imageView;
    TextView nicknameTv;
    private LinearLayout headLayout;
    //裁切前压缩图片
    File fileCrash;

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private UserBaseMsgBean.DataBean userBean;

    @Override
    public int getLayoutView() {
        return R.layout.recycleview_layout;
    }

    @Override
    public void initView() {
        setTitleName("我的信息");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);

        mSmartrefreshlayout.setEnableLoadMore(false);
        mSmartrefreshlayout.setEnableRefresh(false);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        myInfoAdapter = new MyInfoAdapter(R.layout.item_my_info);
        mRecyclerview.setAdapter(myInfoAdapter);
        //
        setHeadView();
    }

    /**
     * 添加头部
     */
    public void setHeadView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_base_info_head_layout, null);
        myInfoAdapter.setHeaderView(view);
        headLayout = view.findViewById(R.id.myinfo_headLayout);
        imageView = view.findViewById(R.id.myinfo_headimage);
        nicknameTv = view.findViewById(R.id.myinfo_nickname);
        headLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choseImage(0, MyBaseInfoActivity.this, 1);
            }
        });
    }

    @Override
    public void initData() {
        userBean = (UserBaseMsgBean.DataBean) getIntent().getParcelableExtra("user_head_default");
        List<TextListBean> beanList = new ArrayList<>();
        beanList.add(new TextListBean("账号", userBean.getAccount()));
        beanList.add(new TextListBean("性别", userBean.getSex()==0?"男":"女"));
        beanList.add(new TextListBean("地址", userBean.getPermanentAddress()));
        myInfoAdapter.setNewData(beanList);
        nicknameTv.setText(userBean.getNickName());
        ImageLoadUtil.loadCircularImage(getApplicationContext(), userBean.getHeadPortrait(),
                R.mipmap.default_head_icon,R.mipmap.default_head_icon, imageView);
    }



    @Override
    protected MinePresent createPresenter() {
        return new MinePresent();
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            default:
                ToastUtils.toast(mContext,"更换成功");
                setResult(MODIFY_HEAD_ICON);
                break;
        }
    }

    @Override
    public void onError(String tag, Object o) {
        ToastUtils.error(mContext, String.valueOf(o));

    }

    @Override
    protected void selectedPicsAndEmpressed(List<String> icons) {
        if (icons.size() > 0) {
            String path = icons.get(0);
           ImageLoadUtil.loadCirImgNoCrash(mContext,path,imageView,R.mipmap.default_head_icon,R.mipmap.default_head_icon);
            if (StringTools.isStringValueOk(path)) {
                mPresenter.modifyHeadIcon(getPublishMultipartBody().addFormDataPart("file","file",
                        RequestBody.create(MediaType.parse("file"), new File(path))).build(),"");
            }
        }
    }
}
