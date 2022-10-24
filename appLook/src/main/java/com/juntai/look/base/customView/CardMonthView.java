package com.juntai.look.base.customView;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;

/**
 * 下标标记的日历控件
 * Created by huanghaibin on 2017/11/15.
 */

public class CardMonthView extends MonthView {
    /**
     * 被选择的日期背景色
     */
    protected Paint selectedPaint = new Paint();
    private Paint mSchemeBasicPaint = new Paint();
    private int mPadding;
    private int mH, mW;
    private int mRadius;
    /**
     * 今天的背景色
     */
    private Paint mCurrentDayPaint = new Paint();
    /**
     * 圆点半径  底部红色小圆点
     */
    private float mPointRadius;

    public CardMonthView(Context context) {
        super(context);
        mSchemeBasicPaint.setAntiAlias(true);
        mSchemeBasicPaint.setStyle(Paint.Style.FILL);
        mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER);
        mSchemeBasicPaint.setColor(Color.RED);
        mPadding = dipToPx(getContext(), 4);
        mH = dipToPx(getContext(), 2);
        mW = dipToPx(getContext(), 8);
        mPointRadius = dipToPx(context, 2);
        //兼容硬件加速无效的代码
        setLayerType(View.LAYER_TYPE_SOFTWARE, mSelectedPaint);
        //4.0以上硬件加速会导致无效
        mSelectedPaint.setMaskFilter(new BlurMaskFilter(28, BlurMaskFilter.Blur.SOLID));
        mCurrentDayPaint.setAntiAlias(true);
        mCurrentDayPaint.setStyle(Paint.Style.FILL);
        mCurrentDayPaint.setColor(Color.parseColor("#46C9C3"));

        selectedPaint.setAntiAlias(true);
        selectedPaint.setStyle(Paint.Style.FILL);
        selectedPaint.setColor(Color.parseColor("#46C9C3"));//绿色 当前

        mCurMonthTextPaint.setFakeBoldText(false);
        mCurMonthTextPaint.setTextSize(dipToPx(context,10));

        /**
         * 有标签的日期的文本格式
         */
        mSchemeTextPaint.setFakeBoldText(false);

    }

    /**
     * dp转px
     *
     * @param context context
     * @param dpValue dp
     * @return px
     */
    private static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void onPreviewHook() {
        mRadius = Math.min(mItemWidth, mItemHeight)/3;
        selectedPaint.setColor(Color.parseColor("#aa46C9C3"));//选中淡绿色

    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        int cx = x + mItemWidth / 2;
        int cy = y + mItemHeight / 2 - dipToPx(getContext(), 6);
        canvas.drawCircle(cx, cy, mRadius, selectedPaint);
        return true;
    }

    /**
     * onDrawSelected
     *
     * @param canvas   canvas
     * @param calendar 日历calendar
     * @param x        日历Card x起点坐标
     * @param y        日历Card y起点坐标
     */
    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
        mSchemeBasicPaint.setColor(calendar.getSchemeColor());
        canvas.drawCircle(x + mItemWidth / 2, y + mItemHeight -  2*mPadding, mPointRadius, mSchemeBasicPaint);
    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        int cx = x + mItemWidth / 2;
        int cy = y + mItemHeight / 2 - dipToPx(getContext(), 6);
        int top = y - mItemHeight / 6;
        if (calendar.isCurrentDay() && !isSelected) {
            canvas.drawCircle(cx, cy, mRadius, mCurrentDayPaint);
        }
        if (isSelected) {
            mSelectTextPaint.setColor(Color.parseColor("#ffffff"));
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    mSelectTextPaint);
        } else if (hasScheme) {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentDay() ? mCurDayTextPaint :
                            calendar.isCurrentMonth() ? mSchemeTextPaint : mOtherMonthTextPaint);


        } else {
            mCurDayTextPaint.setColor(Color.parseColor("#ffffff"));
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentDay() ? mCurDayTextPaint :
                            calendar.isCurrentMonth() ? mCurMonthTextPaint : mOtherMonthTextPaint);
        }
    }
}
