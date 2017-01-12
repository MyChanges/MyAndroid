package test.zp.com.myandroid.base;

import java.lang.ref.WeakReference;

import test.zp.com.myandroid.mvp.IPresenter;
import test.zp.com.myandroid.mvp.IView;

/**
 * Created by change on 2017/1/6.
 * mvp P的处理层
 */
public class BasePresenter<V extends IView> implements IPresenter {
    protected V iView;
    private WeakReference rference;

    @Override
    public void attachView(IView view) {
        rference = new WeakReference(view);
    }

    @Override
    public void detachView() {
        if (rference != null) {
            rference.clear();
            rference = null;
        }
    }

    @Override
    public V getView() {
        return (V) rference.get();
    }
}
