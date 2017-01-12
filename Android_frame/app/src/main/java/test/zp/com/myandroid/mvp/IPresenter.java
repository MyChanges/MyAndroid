package test.zp.com.myandroid.mvp;

/**
 * Created by change on 2017/1/6.
 * mvp 之p
 */
public interface IPresenter<V extends IView> {
    /**
     * 添加View
     */
    void attachView(V view);

    /**
     * 移除View
     */
    void detachView();


    /**
     * 获取View
     *
     * @return
     */
    IView getView();

}
