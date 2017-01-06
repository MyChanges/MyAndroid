package test.zp.com.myandroid.test;

/**
 * Created by change on 2017/1/5.
 */
public class JniUtils {
    /**
     * 架子.so文件
     */
    static  {
        System.loadLibrary("NdkJniDemo");
    }
    public static native  String getStringFormC();
}
