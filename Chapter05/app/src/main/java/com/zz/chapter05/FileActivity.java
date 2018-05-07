package com.zz.chapter05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileActivity extends AppCompatActivity {

    private static final String TAG = "FileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        EditText et_content = (EditText) findViewById(R.id.et_content);
        findViewById(R.id.bt_save_to_file).setOnClickListener(v -> {
            String content;
            if (et_content != null) {
                content = et_content.getText().toString();
                try {
                    // 写入内容到File
                    // File路径 /data/data/com.zz.chapter05/file/save.txt
//                    FileOutputStream fos = openFileOutput("save.text", MODE_PRIVATE);

                    // 写入内容到Cache
                    // File路径 /data/data/com.zz.chapter05/cache/cache.txt
                    FileOutputStream fos = new FileOutputStream(new File(getCacheDir(), "cache.text"));

                    // 对流进行包装
                    PrintStream printStream = new PrintStream(fos);
                    printStream.print(content);
                    // 关流
                    fos.close();
                    printStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
