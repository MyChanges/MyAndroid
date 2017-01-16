package test.zp.com.myandroid.activity.login;

import android.os.Handler;
import android.support.annotation.NonNull;

import test.zp.com.myandroid.bean.User;
import test.zp.com.myandroid.mvp.IModel;

/**
 * Created by change on 2017/1/13.
 * 数据处理
 */
public class LoginMondel implements IModel {
    private boolean isLogin = false;
    public boolean login(@NonNull final String username, @NonNull final String pwd, @NonNull final LoginResult
            result) {
        /**
         * 模拟网络请求
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 模式登陆成功
                if (username.equals("zp") &&  pwd.equals("123456")){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(pwd);
                    result.LoginSuccess(user);
                    isLogin = true;
                } else {
                    result.LoginFail("登陆失败了！");
                }


            }
        }, 1000);

        return isLogin;

    }

    /**
     * 登陆结果回调
     */

    public interface LoginResult {
        void LoginSuccess(User str);

        void LoginFail(String str);
    }

}


