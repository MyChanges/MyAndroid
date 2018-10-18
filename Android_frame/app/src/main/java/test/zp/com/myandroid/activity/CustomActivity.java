package test.zp.com.myandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import test.zp.com.myandroid.R;

/**
 * Created by change on 2018/10/16.
 */

public class CustomActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

}
