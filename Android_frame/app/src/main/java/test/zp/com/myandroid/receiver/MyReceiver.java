package test.zp.com.myandroid.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by change on 2018/9/26.
 */

public class MyReceiver extends BroadcastReceiver {
    public static final String RECEIVER_TEST_ACTION = "com.demo.test.action";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(RECEIVER_TEST_ACTION)) {
            Toast.makeText(context, "接受到静态注册广播", Toast.LENGTH_SHORT).show();

        }

    }
}
