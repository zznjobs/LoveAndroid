package com.zz.chapter04;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Demo2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
    }

    // 打开浏览器
    public void gotoBrowser(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.baidu.com"));
        startActivity(intent);
    }

    // 播打电话
    // 需要权限
    public void dial(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:10010"));
        startActivity(intent);
    }

    // 分享？？？
    public void share(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        // 设置参数的类型
        intent.setType("text/plain"); // "image/png"
        // 设置要分享的文本
        intent.putExtra(Intent.EXTRA_TEXT, "我很帅！"); // Intent.EXTRA_TEXT是Android中约定的文本分享name
        startActivity(intent);

    }
}
