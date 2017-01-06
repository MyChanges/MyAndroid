package test.zp.com.myandroid.test;

/**
 * Created by change on 2017/1/5.
 */
public class JniUtils {
    /**
     * so库加载测试
     */
    static  {
        System.loadLibrary("NdkJniDemo");
    }
    public static native  String getStringFormC();
}
