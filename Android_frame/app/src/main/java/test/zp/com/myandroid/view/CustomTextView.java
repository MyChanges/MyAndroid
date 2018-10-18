package test.zp.com.myandroid.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import test.zp.com.myandroid.R;

public class CustomTextView extends View {
    private Paint mPaint;//画笔

    private int backColor;//背景色

    private int textColor;//文字颜色

    private float textSize;//文字大小

    private String textContent;//文字内容

    public CustomTextView(Context context) {
        super(context);
    }

    //关联自定义属性
    public CustomTextView(Context context, AttributeSet attr) {
        super(context);
        TypedArray array = context.obtainStyledAttributes(attr, R.styleable.CustomTextView);
        textColor = array.getColor(R.styleable.CustomTextView_textColor, 0X000000);
        backColor = array.getColor(R.styleable.CustomTextView_backColor, 0XFFFFFF);
        textSize = array.getDimension(R.styleable.CustomTextView_textSize, 32);
        textContent = array.getString(R.styleable.CustomTextView_textContent);
        array.recycle();
    }

    //开始绘画
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setStyle(Style.FILL);//填充方式
        mPaint.setTextSize(textSize);
        mPaint.setColor(backColor);
        canvas.drawRect(new Rect(10, 10, 200, 100), mPaint);
        mPaint.setColor(textColor);
        canvas.drawText(textContent, 20, 60, mPaint);
    }
}
