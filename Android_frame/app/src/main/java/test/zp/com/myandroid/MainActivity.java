package test.zp.com.myandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import test.zp.com.myandroid.activity.NativeActivity;
import test.zp.com.myandroid.adapter.MainRecyclerViewAdapter;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.view.DividerItemDecoration;

public class MainActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private String[] mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void initData() {
        mData = new String[]{"jni调用", "test1", "test2", "test3"};
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(MainActivity.this, mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                }

            }
        });
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


}
