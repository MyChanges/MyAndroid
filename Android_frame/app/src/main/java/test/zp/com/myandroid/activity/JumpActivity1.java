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

public class JumpActivity1 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump1);
        Log.e("zhongp", "onCreate: "+"========JumpActivity1");
        Log.e("zhongp", "onCreate:JumpActivity1=== 栈id==>>>>"+getTaskId());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("zhongp", "onNewIntent: "+"========JumpActivity1");
    }

    @Override
    protected void initView() {
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpActivity1.this, JumpActivity.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.btn_back1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JumpActivity1.this, JumpActivity1.class);
                startActivity(intent);

            }
        });

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
    protected void onDestroy() {
        super.onDestroy();
        Log.e("zhongp", "onDestroy: "+"========JumpActivity1");
    }
}
