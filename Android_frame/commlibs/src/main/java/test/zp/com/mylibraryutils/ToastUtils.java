package test.zp.com.mylibraryutils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by change on 2017/1/16.
 */
public class ToastUtils {
    private static Toast sToast;
    private static Handler sHandler;
    static {
        sHandler = new Handler(Looper.getMainLooper());
    }


}

