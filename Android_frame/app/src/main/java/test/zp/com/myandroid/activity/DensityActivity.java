package test.zp.com.myandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.base.BasePresenter;
import test.zp.com.myandroid.util.DensityUtils;
/**
 * Created by change on 2018/11/6.
 */

public class DensityActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DensityUtils.setOrientation(DensityActivity.this,DensityUtils.WIDTH);
        setContentView(R.layout.activity_density);
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
}
