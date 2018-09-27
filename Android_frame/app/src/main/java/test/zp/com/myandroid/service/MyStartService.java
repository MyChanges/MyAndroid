package test.zp.com.myandroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by change on 2018/9/26.
 *开启的服务与activity没有关系
 */
public class MyStartService extends Service {
    /**
     * 创建参数
     */
    boolean threadDisable;
    int count;

    @Override
    public void onCreate() {
        Log.i("zhongp", "onCreate - Thread ID = " + Thread.currentThread().getId());
        super.onCreate();
        /** 创建一个线程，每秒计数器加一，并在控制台进行Log输出 */
        new Thread(new Runnable() {
            public void run() {
                while (!threadDisable) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    count++;
                    Log.v("zhongp", "Count is" + count);
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("zhongp", "onStartCommand - startId = " + startId + ", Thread ID = " + Thread.currentThread().getId());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("zhongp", "onBind - Thread ID = " + Thread.currentThread().getId());

        return null;
    }

    @Override
    public void onDestroy() {
        Log.i("zhongp", "onDestroy - Thread ID = " + Thread.currentThread().getId());
        super.onDestroy();
        /** 服务停止时，终止计数进程 */
        this.threadDisable = true;
    }
    //此方法是为了可以在Acitity中获得服务的实例

    class ServiceBinder extends Binder {
        public MyStartService getService() {
            return MyStartService.this;
        }
    }
}
