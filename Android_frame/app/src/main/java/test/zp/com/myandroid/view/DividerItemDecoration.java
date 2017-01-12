package test.zp.com.myandroid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by change on 2017/1/12.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private Context mContext;
    private int mOrientation;
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    private static final String TAG = DividerItemDecoration.class.getSimpleName();

    public DividerItemDecoration(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS); // 也可自定义
        mDivider = a.getDrawable(0);
        a.recycle();
        this.mContext = context;
        setOrientation(orientation);

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == VERTICAL_LIST) {
            drawHorizontalLine(c, parent);
        } else {
            drawVerticalLine(c, parent);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == HORIZONTAL_LIST) {
            //画竖线，就是往右偏移一个分割线的宽度
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        } else {
            //画横线，就是往下偏移一个分割线的高度
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }


    }

    public void setOrientation(int mOrientation) {
        if (mOrientation != HORIZONTAL_LIST && mOrientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.mOrientation = mOrientation;
    }

    /**
     * 画横线
     */
    public void drawHorizontalLine(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            //获得child的布局信息
            final RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + lp.bottomMargin;
            final int button = top + mDivider.getIntrinsicHeight();
            Log.e(TAG, "drawHorizontalLine: mDivider.getIntrinsicHeight():   " + mDivider.getIntrinsicHeight());
            Log.e(TAG, "drawHorizontalLine:   " + "left:  " + left + "    top:    " + top + "    right:   " + right + "    button: " + button);
            mDivider.setBounds(left, top, right, button);
            mDivider.draw(c);
        }
    }

    /**
     * 画竖线
     */
    public void drawVerticalLine(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int button = parent.getHeight() - parent.getPaddingTop();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getLeft() + lp.rightMargin;
            final int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, button);
            mDivider.draw(c);
        }
    }
}
