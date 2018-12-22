package test.zp.com.myandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author change
 * @date 2018/12/7
 * @Description: [一句话描述该类的功能]
 */

public class TriangleView extends View {
    private Paint mPaint;

    public TriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TriangleView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //实例化路径
        Path path = new Path();
        /**
         * 此点为多边形的起点
         */
        path.moveTo(50, 50);
        path.lineTo(70, 50);
        path.lineTo(90,70);
        path.lineTo(450,140);
        path.lineTo(450,180);
        path.lineTo(90,110);
        /**
         * 使这些点构成封闭的多边形
         */
        path.close();
        canvas.drawPath(path, mPaint);
    }
}
