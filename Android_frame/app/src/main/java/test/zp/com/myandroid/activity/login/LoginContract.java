package test.zp.com.myandroid.activity.login;

import test.zp.com.myandroid.base.BaseView;
import test.zp.com.myandroid.bean.User;

/**
 * Created by change on 2017/1/13.
 * 合同类,定义登录用到的一些接口方法
 */
public class LoginContract {
   public interface LoginView extends BaseView {
        String getUserName();

        String getPwd();

        void toMainActivity(User user);

        void showFailedError(String failMsg);

    }

    public interface LoginPresenter{
        void login(String name, String pwd);
    }


}
