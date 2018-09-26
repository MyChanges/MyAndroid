package test.zp.com.myandroid.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Toast;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.base.BasePresenter;

/**
 * Created by change on 2018/9/26.
 */

public class BroadCaseReceiverActivity extends BaseActivity {
    private IntentFilter intentFilter; // 动态注册//
    private NetworkChangeReceiver networkChangeReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_receiver);
        //得到本地广播管理器的实例
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
//        //动态接受网络变化的广播接收器
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();

        /*---------------本地广播注册--------------------------------*/
        //注册本地广播监听器
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example1.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
        findViewById(R.id.btn_receiver_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerReceiver(networkChangeReceiver, intentFilter);
            }
        });


        findViewById(R.id.btn_receiver_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent("com.demo.test.action"));
            }
        });

        // 发送本地广播
        findViewById(R.id.btn_receiver_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送本地广播
                Intent intent = new Intent("com.example1.LOCAL_BROADCAST"); // 自己手动发 但注册广播和发送广播时action应该保持一致
              //  intent.setAction("com.example.LOCAL_BROADCAST"); // 也可以这样写
                localBroadcastManager.sendBroadcast(intent);
            }
        });


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setOnClickLintener() {

    }

    @Override
    protected BasePresenter loadParesenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }



    //自定义接受网络变化的广播接收器
    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//这个广播是系统发送
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //本地广播接收器
    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() .equals( "com.example1.LOCAL_BROADCAST")) {
                Toast.makeText(context,"接受到本地广播",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);//关闭本地广播
    }
}
