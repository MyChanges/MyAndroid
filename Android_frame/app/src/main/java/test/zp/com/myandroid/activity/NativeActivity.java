package test.zp.com.myandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.test.JniUtils;


/**
 * Created by change on 2017/1/5.
 * Native 方法调用测试
 */
public class NativeActivity extends BaseActivity {
    private TextView mTvShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_native);
        mTvShow = (TextView) findViewById(R.id.tv_native_show);
        mTvShow.setText(JniUtils.getStringFormC());
    }
}
