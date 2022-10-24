package com.juntai.look.homePage;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.juntai.look.hcb.R;

import java.util.List;

/**
 * 首页tablayout适配器
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    SparseArray<Fragment> mFragments;
    private int[] images;
    private String[] titles;
    public MainPagerAdapter(FragmentManager fm, Context contexts, String[] title, int[] img, SparseArray<Fragment> fragments) {
        super(fm);
        mContext = contexts;
        images = img;
        mFragments = fragments;
        this.titles = title;
    }
    public MainPagerAdapter(FragmentManager fm, Context contexts, String[] title,  SparseArray<Fragment> fragments) {
        super(fm);
        mContext = contexts;
        mFragments = fragments;
        this.titles = title;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    /**
     * 自定义底部消息tab
     * @param position
     * @return
     */
    public View getTabView(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_tabitem, null);
        ImageView img = v.findViewById(R.id.tabitem_image);
        img.setImageResource(images[position]);
        TextView title = v.findViewById(R.id.tabitem_text);
        title.setText(titles[position]);
        return v;
    }

    /**
     * 自定义顶部消息tab  没有图片
     * @param position
     * @return
     */
    public View getTabViewNoPic(int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_top_tabitem, null);
        TextView title = v.findViewById(R.id.tabitem_text);
        title.setText(titles[position]);
        return v;
    }

    /**
     * 自定义顶部消息tab
     * @param isRead 是否显示未读标记
     * @param position
     * @return
     */
    public View getTopTabView(int position, boolean isRead) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_top_tabitem, null);
        TextView title = v.findViewById(R.id.tabitem_text);
        if (isRead){
            v.findViewById(R.id.read_tag).setVisibility(View.VISIBLE);
        }else {
            v.findViewById(R.id.read_tag).setVisibility(View.GONE);
        }
        title.setText(titles[position]);
        return v;
    }
}
