package com.zz.chapter03;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ProgressDialogActivity extends AppCompatActivity {
    // TODO NOTICE
    // ProgressDialog这个类已经过时了。。。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

        // 环形Dialog
        findViewById(R.id.bt_progress).setOnClickListener(view -> {
            ProgressDialog dialog = new ProgressDialog(this); // this必须是Activity
            dialog.setMessage("正在加载，请稍后…");
            dialog.setCancelable(true);
            dialog.show();
        });

        // 水平Dialog
        findViewById(R.id.bt_progress_horizontal).setOnClickListener(view -> {
            ProgressDialog dialog = new ProgressDialog(this); // this必须是Activity
            dialog.setMessage("正在加载，请稍后…");
            // 设置进度条风格（水平）
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setCancelable(true);
            dialog.setMax(100);
            dialog.show();
            dialog.setProgress(56); // 显示之后，才能设置 NOTICE
        });
    }
}
