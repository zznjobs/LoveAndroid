package com.zz.chapter05;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zz.chapter05.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExternalActivity extends AppCompatActivity {

    private static final String TAG = "ExternalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        ((TextView) findViewById(R.id.tv_sd_space_info)).setText(FileUtils.getSpaceInfo(getApplicationContext()));

        EditText et_content = (EditText) findViewById(R.id.et_content);

        findViewById(R.id.bt_check_sd_writable).setOnClickListener(v -> {
            if (FileUtils.isExternalStorageWritable()) {
                Toast.makeText(getApplicationContext(), "SD可写", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "SD不可写", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.bt_check_sd_readable).setOnClickListener(v -> {
            if (FileUtils.isExternalStoryeReadable()) {
                Toast.makeText(getApplicationContext(), "SD可读", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "SD不可读", Toast.LENGTH_SHORT).show();
            }
        });

        RxPermissions rxPermissions = new RxPermissions(this);
        findViewById(R.id.bt_save_to_sd).setOnClickListener(v -> {
            if (FileUtils.isExternalStorageWritable()) {
                String content = et_content.getText().toString().trim();
                Toast.makeText(getApplicationContext(), "SD卡可用", Toast.LENGTH_SHORT).show();
                rxPermissions
                        .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(granted -> {
                            if (granted) {
                                save(content);
                            } else {
                                Toast.makeText(getApplicationContext(), "SD卡没有写权限", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    /**
     写入内容到SD卡文件
     @param content content
     */
    private void save(String content) {
        File file = new File(Environment.getExternalStorageDirectory(), "content.text");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            // 对流进行包装，提高写入效率
            PrintStream printStream = new PrintStream(fos);
            // 写入对应的内容
            printStream.print(content);
            // 关流
            fos.close();
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     获取保存图片的公有文件夹
     @param albumName 相册名字
     @return file
     */
    public File getAlbumPublicStorageDir(String albumName) {
        // 获取保存图片的文件夹
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created.");
        }
        return file;
    }

    /**
     获取保存图片的私有文件夹
     @param context   context
     @param albumName albumName
     @return file
     */
    public File getAlbumPrivateStorageDir(Context context, String albumName) {
        // 获取保存图片的文件夹
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created.");
        }
        return file;
    }

    /**
     获取SD卡根目录
     @return file
     */
    public File getSDCardRootDir() {
        return Environment.getExternalStorageDirectory();
    }
}
