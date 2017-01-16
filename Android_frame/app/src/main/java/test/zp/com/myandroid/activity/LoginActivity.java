package test.zp.com.myandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.activity.login.LoginContract;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.bean.User;
import test.zp.com.myandroid.presenter.LoginPresenter;

/**
 * Created by change on 2017/1/12.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {
    private EditText edUserName;
    private EditText edUserPassWord;
    private AppCompatButton mBtnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        edUserName = (EditText) findViewById(R.id.ed_login_username);
        edUserPassWord = (EditText) findViewById(R.id.ed_login_userpassword);
        mBtnLogin = (AppCompatButton) findViewById(R.id.btn_login);
        edUserName.setText("zp");
        edUserPassWord.setText("123456");
    }

    @Override
    protected void setOnClickLintener() {
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    protected LoginPresenter loadParesenter() {
        return new LoginPresenter();
    }

    @Override
    public String getUserName() {
        return edUserName.getText().toString();
    }

    @Override
    public String getPwd() {
        return edUserPassWord.getText().toString();
    }

    @Override
    public void toMainActivity(User str) {
        showMessage("登陆成功!");
    }

    @Override
    public void showFailedError(String failMsg) {
        showMessage(failMsg);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                getPresenter().login(getUserName(), getPwd());
                break;
        }

    }
}
