package test.zp.com.myandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import test.zp.com.myandroid.activity.BroadCaseReceiverActivity;
import test.zp.com.myandroid.activity.ChartActivity;
import test.zp.com.myandroid.activity.ClipboardActivity;
import test.zp.com.myandroid.activity.CustomActivity;
import test.zp.com.myandroid.activity.CustomViewActivity;
import test.zp.com.myandroid.activity.DensityActivity;
import test.zp.com.myandroid.activity.JumpActivity;
import test.zp.com.myandroid.activity.LoginActivity;
import test.zp.com.myandroid.activity.NativeActivity;
import test.zp.com.myandroid.activity.ServiceActivity;
import test.zp.com.myandroid.activity.SharePicActivity;
import test.zp.com.myandroid.adapter.MainRecyclerViewAdapter;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.base.BasePresenter;
import test.zp.com.myandroid.view.DividerItemDecoration;

public class MainActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private String[] mData;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void initData() {
        mData = new String[]{"jni调用", "登陆测试", "Activity跳转测试", "BroadCaseReceiver", "Service", "AndroidChart", "customView", "sharePic", " clipboard", "density","customView"};
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(MainActivity.this, mData);
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
//                mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickLitener(new MainRecyclerViewAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, NativeActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    case 2:
                        startActivity(new Intent(MainActivity.this, JumpActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, BroadCaseReceiverActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, ServiceActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, ChartActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, CustomActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, SharePicActivity.class));
                        break;

                    case 8:
                        startActivity(new Intent(MainActivity.this, ClipboardActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, DensityActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, CustomViewActivity.class));
                        break;
                    default:
                }

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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View v) {

    }
}
