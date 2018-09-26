package test.zp.com.myandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.base.BasePresenter;

/**
 * Created by change on 2018/9/25.
 */

public class JumpActivity extends BaseActivity {
    /*standard.singleTop. SingleTask. singleInstance*/

    // 启动模式是指要启动的Activity的模式
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        Log.e("zhongp", "onCreate: 1111111111111111==" + "JumpActivity");
        Log.e("zhongp", "onCreate:JumpActivity=== 栈id==>>>>"+getTaskId());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("zhongp", "onNewIntent: " + "JumpActivity");
    }

    @Override
    protected void initView() {
        // 默认启动模式启本身每次新建一个实例   Standard模式 方式1
//        findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(JumpActivity.this, JumpActivity.class);
//                startActivity(intent);
//
//            }
//        });

        /*
        *
        * 另一种就是通过在开启Activity的时候，通过设置Intent Flag来设置，比如：

Intent intent=new Intent(this,TransitionActivity.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(intent);

下面就来介绍第二种方式几个常用的Flag

（1）FLAG_ACTIVITY_SINGLE_TOP

其效果和第一种singleTop模式一样

（2）FLAG_ACTIVITY_CLEAR_TOP

其效果和第一种singleTask模式一样

（3）FLAG_ACTIVITY_NO_HISTORY

其效果是当某个Activity以这种方式启动的时候，其再去启动其他Activity，则该Activity就消失了；比如，A以这种方式启动B，B启动了C，那么Activity的任务栈中就只有AC了

（4）FLAG_ACTIVITY_NEW_TASK

其效果是启动的activity在一个新的任务栈中，功能和第一种singleInstance模式一样，通常用于在一个没有Activity任务栈的环境里开启一个Activity，就好比我们经常使用的服务里面。

---------------------

本文来自 hfut_why 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/hfut_why/article/details/81916141?utm_source=copy */

        /**/
        findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpActivity.this, JumpActivity.class);
            //    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });


        /*singleTask 回到栈顶，其他在栈内移除*/
        findViewById(R.id.btn_jump1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpActivity.this, JumpActivity1.class);
             //   intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        /**
         * https://blog.csdn.net/su20145104009/article/details/50662731
         * singleInstance 测试
         */
        // 栈内独享、再次启动会调用onNewIntent




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
}
