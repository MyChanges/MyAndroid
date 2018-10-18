package test.zp.com.myandroid.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import test.zp.com.myandroid.R;

/**
 * Created by change on 2018/10/17.
 * 粘贴功能测试
 */

public class ClipboardActivity extends Activity {
    //获取剪贴板管理器：
    ClipboardManager cm  ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clipboar_activity);
        cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", "￥ktNWbTz7AUc￥");
                // 将ClipData内容放到系统剪贴板里。
                cm.setPrimaryClip(mClipData);

            }
        });


        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData abc = cm.getPrimaryClip();
                ClipData.Item item = abc.getItemAt(0);
                String text = item.getText().toString();
              //  pasteField.setText(text);
                Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT).show();
             Log.e("zhongp", "onClick: "+text);
            }
        });

    }
}

