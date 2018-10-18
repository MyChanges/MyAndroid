package test.zp.com.myandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by change on 2018/10/16.
 */

public class SlideMenuView extends ViewGroup {
    private Scroller scroller;//滑动器

    private final int MENU = 0;//显示菜单标识

    private final int MAIN = 1;//显示主页标识

    private int startx;//起始X位置

    private int currentScreen = MENU;//当前Screen

    public SlideMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    // 测量子view
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View menu = getChildAt(0);
        menu.measure(menu.getLayoutParams().width, heightMeasureSpec);
        View main = getChildAt(1);
        main.measure(widthMeasureSpec, heightMeasureSpec);
    }

    // 将子view进行布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View menu = getChildAt(0);
        menu.layout(-menu.getLayoutParams().width, t, 0, b);
        View main = getChildAt(1);
        main.layout(l, t, r, b);
    }

    // 触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startx = (int) event.getX();// 记录手指按下时，点到屏幕左边的距离
                break;
            case MotionEvent.ACTION_MOVE:
                int movex = (int) event.getX();// 移动后，手指点到屏幕左边的距离
                int diffx = startx - movex;// 屏幕左边的偏移量
                int newscrollx = getScrollX() + diffx;// 偏移后
                if (newscrollx > 0) {
                    scrollTo(0, 0);// 如果屏幕左边超过了主界面左边，那么让屏幕左边与主界面重合
                } else if (newscrollx < -getChildAt(0).getWidth()) {
                    scrollTo(-getChildAt(0).getWidth(), 0);// 如果屏幕左边超过了侧边栏左边，那么让屏幕左边与侧边栏左边重合
                }
                scrollBy(diffx, 0);// 持续偏移
                startx = movex;
                break;
            case MotionEvent.ACTION_UP:
                int scrollx = getScrollX();// 屏幕左边距离主界面左边的距离，屏幕左边在主界面左边的左边，为负值
                if (scrollx > -getChildAt(0).getWidth() / 2) {
                    currentScreen = MAIN;// 拖动屏幕不到侧边栏的一半时，放手，显示主界面
                    switchScreen();
                } else if (scrollx < -getChildAt(0).getWidth() / 2) {
                    currentScreen = MENU;// 拖动屏幕超过了侧边栏的一般，放手，显示侧边栏
                    switchScreen();
                }
                break;

            default:
                break;
        }
        return true;
    }

    // 切换显示侧边栏和主界面
    private void switchScreen() {
        int dx = 0;
        // 获得屏幕左边距离主界面左边的距离
        int startX = getScrollX();
        if (currentScreen == MAIN) {
            // 目标是将屏幕左边与主界面左边重合
            dx = 0 - getScrollX();
        } else if (currentScreen == MENU) {
            // 目标是将屏幕左边与侧边栏的左边重合
            dx = -getChildAt(0).getWidth() - getScrollX();
        }
        scroller.startScroll(startX, 0, dx, 0, Math.abs(dx) * 5);
        invalidate();
    }

    // invalidate()的最终的调用方法就是computeScroll() 因此需要重写该方法
    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), 0);
            invalidate();
        }
    }

    // 判断当前显示的是不是侧边栏
    public boolean isMenuShow() {
        return currentScreen == MENU;
    }

    // 隐藏侧边栏
    public void hideMenu() {
        currentScreen = MAIN;
        switchScreen();
    }

    // 显示侧边栏
    public void showMenu() {
        currentScreen = MENU;
        switchScreen();
    }
}
