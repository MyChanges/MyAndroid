package test.zp.com.myandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created by change on 2017/1/5.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView,View.OnClickListener {
    private View mView;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mView = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(mView);

    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mPresenter = loadParesenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initData();
        initView();
        setOnClickLintener();

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setOnClickLintener();
    @Override
    public void showErrorMessage(String msg, String content) {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void showProgress(String msg, int progress) {

    }

    @Override
    public void close() {

    }

    @Override
    public void hideProgress() {

    }

    protected abstract P loadParesenter();

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
