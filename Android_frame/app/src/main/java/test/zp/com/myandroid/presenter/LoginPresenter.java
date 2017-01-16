package test.zp.com.myandroid.presenter;

import java.util.HashMap;

import test.zp.com.myandroid.activity.login.LoginContract;
import test.zp.com.myandroid.activity.login.LoginMondel;
import test.zp.com.myandroid.base.BasePresenter;
import test.zp.com.myandroid.bean.User;
import test.zp.com.myandroid.mvp.IModel;

/**
 * Created by change on 2017/1/12.
 * 登陆处理类
 */
public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    @Override
    public void login(String name, String pwd) {
        if (null != getView()) {
            ((LoginMondel) getModelMap().get("login")).login(name, pwd, new LoginMondel.LoginResult() {
                @Override
                public void LoginSuccess(User user) {
                    getView().toMainActivity(user);

                }

                @Override
                public void LoginFail(String str) {
                    getView().showMessage(str);
                }
            });
        }


    }

    @Override
    public HashMap<String, IModel> getModelMap() {
        return LoadModelMap(new LoginMondel());
    }

    @Override
    public HashMap<String, IModel> LoadModelMap(IModel... models) {
        HashMap<String, IModel> hashMap = new HashMap<String, IModel>();
        hashMap.put("login", models[0]);
        return hashMap;
    }
}
