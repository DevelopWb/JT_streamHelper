package com.juntai.wisdom.basecomponent.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.juntai.wisdom.basecomponent.R;

import java.io.File;

/**
 * 图片加载工具
 *
 * @aouther Ma
 * @date 2019/3/5
 */
public class ImageLoadUtil {

    /**
     * 加载本地图片
     *
     * @param context
     * @param recouse
     * @param view
     */
    public static void loadImage(Context context, int recouse, ImageView view) {
        Glide.with(context).load(recouse).into(view);
    }

    /**
     * 加载图片
     */
    public static void loadImage(Context context, Bitmap bitmap, ImageView view) {
        Glide.with(context).load(bitmap).into(view);
    }

    /**
     * @param context
     * @param url     内存缓存和硬盘缓存
     * @param view
     */
    public static void loadImageCache(Context context, String url, ImageView view) {
        try {
            int urlInt = Integer.parseInt(url);
            Glide.with(context).load(urlInt).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.drawable.nopicture).into(view);
        } catch (NumberFormatException ex) {
            Glide.with(context).load(url).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.drawable.nopicture).into(view);
        }
    }

    /**
     * @param context
     * @param url     内存缓存和硬盘缓存
     * @param view
     */
    public static void loadImageCache(Context context, int url, ImageView view) {
        Glide.with(context).load(url).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.drawable.nopicture).into(view);
    }

    /**
     * @param context
     * @param url     加载网络视频的时候 不能使用硬盘缓存
     * @param view
     */
    public static void loadImageNoCache(Context context, String url, ImageView view) {
        Glide.with(context).load(url).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).error(R.drawable.nopicture).into(view);
    }

    /**
     * 内存缓存
     *
     * @param context
     * @param url
     * @param view
     */
    public static void loadMapImgWithCache(Context context, String url, ImageView view) {
        Glide.with(context).load(url).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.drawable.nopicture).into(view);
    }


    /**
     * @param context
     * @param url
     * @param view
     */
    public static void loadImageNoCrash(Context context, String url, ImageView view) {
        Glide.with(context).load(url).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)).into(view);
    }

    /**
     * @param context
     * @param url
     * @param view
     */
    public static void loadImageNoCrash(Context context, String url, ImageView view, int loading, int error) {
        Glide.with(context).load(url).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)).placeholder(loading).dontAnimate().error(error).into(view);
    }


    /**
     * @param context
     * @param url
     * @param error
     * @param placeholder
     * @param view
     */
    public static void loadImage(Context context, String url, int error, int placeholder, ImageView view) {
        Glide.with(context).load(url).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.RESOURCE).apply(new RequestOptions().error(error).placeholder(placeholder)).into(view);
    }

    /**
     * @param context
     * @param url
     * @param view
     */
    public static void loadImage(Context context, String url, ImageView view) {
        Glide.with(context).load(url).skipMemoryCache(false)
                .apply(new RequestOptions().error(R.drawable.nopicture).placeholder(R.drawable.nopicture))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param url
     * @param error
     * @param placeholder
     * @param view
     */
    public static void loadCircularImage(Context context, String url, int error, int placeholder, ImageView view) {
        Glide.with(context).load(url).apply(new RequestOptions().error(error).placeholder(placeholder).circleCrop()).into(view);
    }

    public static void loadCentercropImage(Context context, int url, ImageView view) {
        Glide.with(context).load(url).apply(new RequestOptions().optionalCenterCrop().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)).into(view);
    }

    public static void loadCentercropImage(Context context, String url, ImageView view) {
        Glide.with(context).load(url).apply(new RequestOptions().optionalCenterCrop().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)).into(view);
    }

    /**
     * 加载圆形图片,无缓存
     *
     * @param context
     * @param url
     * @param view
     * @param placeholder
     * @param error
     */
    public static void loadCirImgNoCrash(Context context, String url, ImageView view, int placeholder, int error) {
        Glide.with(context).load(url).apply(new RequestOptions().error(error).placeholder(placeholder).circleCrop().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)).into(view);
    }

    /**
     * 加载圆形图片,无缓存
     *
     * @param context
     * @param view
     */
    public static void loadCirImgNoCrash(Context context, int resId, ImageView view) {
        Glide.with(context).load(resId).apply(new RequestOptions().circleCrop().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)).into(view);
    }


    public interface BitmapCallBack {
        void getBitmap(Bitmap bitmap);
    }

    /**
     * 获取bitmap
     *
     * @param context
     * @param path
     * @param error
     * @param callback
     */
    public static void getBitmap(Context context, String path, int error, BitmapCallBack callback) {
        Glide.with(context).asBitmap().error(error).load(path).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                LogUtil.e("onResourceReady");
                callback.getBitmap(resource);
            }
        });
    }

}
