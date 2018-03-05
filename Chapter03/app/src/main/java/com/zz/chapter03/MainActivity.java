package com.zz.chapter03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_test_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Start ImageView Test", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ImageViewTestActivity.class));

            }
        });
        findViewById(R.id.tv_test_relativelayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Start RelativeLayout Test", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RelativeLayoutTestActivity.class));

            }
        });
        findViewById(R.id.tv_test_framelayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Start FrameLayout Test", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, FrameLayoutActivity.class));

            }
        });
        findViewById(R.id.tv_test_gridlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Start GridLayout Test", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, GridLayoutActivity.class));

            }
        });
        findViewById(R.id.tv_test_coordinatorlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Start CoordinatorLayout Test", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));

            }
        });
        findViewById(R.id.tv_test_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ToastActivity.class));

            }
        });
        findViewById(R.id.tv_test_snackbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SnackBarActivity.class));

            }
        });

        // TODO  测试内存泄漏因工期问题没有完成
        // 以下代码演示了Lambda表达式的三种写法
        // (params) -> expression
        // (params) -> statement
        // (params) -> {statement}
        // 注意！需要在APP的项目配置中修改Source Compatibility & Target Compatibility 为1.8
        // 注意！开启Lambda表达式后，需要特殊配置混淆文件，详见p73 & 本项目的混淆文件

        findViewById(R.id.tv_test_click).setOnClickListener(
//                view -> startActivity(new Intent(MainActivity.this, ClickActivity.class))

                view -> {
                    startActivity(new Intent(MainActivity.this, ClickActivity.class));
                    Toast.makeText(getApplicationContext(), "点击了点击测试", Toast.LENGTH_SHORT).show();
                }
        );

        findViewById(R.id.tv_test_alertdialog).setOnClickListener(
                view -> startActivity(new Intent(MainActivity.this, AlertDialogActivity.class))
        );

        findViewById(R.id.tv_test_progress).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ProgressDialogActivity.class));
        });


    }
}
