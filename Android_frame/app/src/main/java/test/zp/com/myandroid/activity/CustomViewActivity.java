package test.zp.com.myandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import test.zp.com.myandroid.R;

/**
 * @author change
 * @date 2018/12/7
 * @Description: [自定义Activity]
 */

public class CustomViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
    }
}
