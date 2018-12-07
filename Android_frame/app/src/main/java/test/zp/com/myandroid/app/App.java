package test.zp.com.myandroid.app;

import android.app.Application;

import test.zp.com.myandroid.util.DensityUtils;

/**
 * @author change
 * @date 2018/12/7
 * @Description: [一句话描述该类的功能]
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DensityUtils.setDensity(this);
    }
}
