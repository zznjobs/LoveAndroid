package com.zz.chapter02;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.text01)).setText(BuildConfig.API_URL);
        ((TextView)findViewById(R.id.text02)).setText(Boolean.toString(BuildConfig.LOGGABLE));
        ((TextView)findViewById(R.id.text03)).setText(R.string.str_name);
        ((TextView)findViewById(R.id.text04)).setText(Boolean.toString(BuildConfig.TEST_BOOL));

        LogUtils.i("haha", "Hello");
        Log.i("hehe", "World");

    }
}
