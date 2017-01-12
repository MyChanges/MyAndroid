package test.zp.com.myandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by change on 2017/1/5.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    private View mView;
    private P mPresenter;
    protected View mContentView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mContentView = view;
        initData();
        initView();
    }

    protected abstract void initData();
    protected abstract void initView();

}
