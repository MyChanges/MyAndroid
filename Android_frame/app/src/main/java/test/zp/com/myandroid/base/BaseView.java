package test.zp.com.myandroid.base;

import test.zp.com.myandroid.mvp.IView;

/**
 * Created by change on 2017/1/13.
 */
public interface BaseView extends IView {
    void showMessage(String msg);

    void close();

    void showProgress(String msg);

    void showProgress(String msg, int progress);

    void hideProgress();

    void showErrorMessage(String msg, String content);

}
