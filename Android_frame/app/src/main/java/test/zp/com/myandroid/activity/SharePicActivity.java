package test.zp.com.myandroid.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.File;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.util.ImageUtils;

/**
 * Created by change on 2018/10/17.
 */

public class SharePicActivity extends Activity {
    ImageView aaa ;
    String picPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_pic_activity);
        View v = LayoutInflater.from(this).inflate(R.layout.view_photo, null, false);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;   // 屏幕高度（像素）
        ImageUtils.layoutView(v,width,height);
        final ScrollView tv = (ScrollView) v.findViewById(R.id.textView);
        aaa = (ImageView) findViewById(R.id.aaa);
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                picPath = ImageUtils.viewSaveToImage(tv,"makemone");
                Log.i("2333", picPath);
                Uri imageUri = Uri.fromFile(new File(picPath));
                Log.i("2333", imageUri.toString());
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                intent.putExtra(Intent.EXTRA_TEXT,"文本内容");
                intent.setType("image/*");
                startActivity(Intent.createChooser(intent,"分享到 "));
            }
        };
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().post(runnable);
            }
        });

//        ComponentName componet = new ComponentName(pkg, cls);
//        //pkg 就是第三方应用的包名
//        //cls 就是第三方应用的进入的第一个Activity
//        Intent intent = new Intent();
//        intent.setComponent(componet);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);


        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        ComponentName componet = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
        //pkg 就是第三方应用的包名
        //cls 就是第三方应用的进入的第一个Activity
        Intent intent = new Intent();
        intent.setComponent(componet);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
            }
        });


        /*
        *
        * Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager mPackageManager = this.getPackageManager();
        List<ResolveInfo> mAllApps = mPackageManager.queryIntentActivities(mainIntent, 0);
        //按报名排序
        Collections.sort(mAllApps, new ResolveInfo.DisplayNameComparator(mPackageManager));

        for(ResolveInfo res : mAllApps){
            //该应用的包名和主Activity
            String pkg = res.activityInfo.packageName;
            String cls = res.activityInfo.name;
            Log.d("pkg_cls","pkg---" +pkg +"  cls---" + cls );

        }
---------------------
作者：风吹过wu
来源：CSDN
原文：https://blog.csdn.net/u010844304/article/details/52950909?utm_source=copy
版权声明：本文为博主原创文章，转载请附上博文链接！
        *
        *
        * */
    }

}
