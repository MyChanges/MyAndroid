package test.zp.com.myandroid.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.base.BasePresenter;
import test.zp.com.myandroid.service.MyBindService;
import test.zp.com.myandroid.service.MyStartService;

/**
 * Created by change on 2018/9/26.
 * startService
 * 1、通过startService方式启动
 如果运行在后台的Service甚至不需要和UI（主）线程间进行交互，这种情况下，一般是调用startService来启动Service。
 2、通过bindService方式启动
 两个不同进程间通信 或者 某个应用中Service方法的暴露出去（同个进程间），一般是调用bindService来启动Service。
 ---------------------
 */

public class ServiceActivity extends BaseActivity {
    MyBindService mService;
    boolean mBound = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        //启动服务
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, MyStartService.class);
                startService(intent);

            }
        });

        // 停止服务
        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, MyStartService.class);
                stopService(intent);
            }
        });

        findViewById(R.id.tv_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) {
                    ((TextView)findViewById(R.id.tv_result)).setText( mService.getRandomNumber()+"");
                }
            }
        });

        findViewById(R.id.btn_bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(ServiceActivity.this,MyBindService.class);
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE); //表明只要绑定存在，就自动建立
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


    }
    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyBindService.LocalBinder binder = (MyBindService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

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

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }
}
