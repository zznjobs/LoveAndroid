package com.zz.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ClickActivity extends AppCompatActivity {

    /*
    TODO
    本节原本是为了测试点击事件的几件写法
    现在是为了测试内部类的写法会不会导致内存泄露
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        findViewById(R.id.bt_show_toast).setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "显示了一个Toast", Toast.LENGTH_LONG).show();
        }
    }
}
