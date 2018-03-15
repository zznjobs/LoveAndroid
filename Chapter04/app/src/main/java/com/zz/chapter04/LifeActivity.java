package com.zz.chapter04;

import android.os.Bundle;
import android.util.Log;

public class LifeActivity extends BaseActivity {

    private static final String TAG = "LifeActivity";
    private static final String KEY = "KEY";

    /**
     只在程序异常退出时触发
     @param outState outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState !!!");

        outState.putString(KEY, "我很帅");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        Log.d(TAG, "onCreate !!!");
        if (savedInstanceState != null) {
            String key = savedInstanceState.getString(KEY);
            Log.d(TAG, "onCreate : " + key);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart !!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume !!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause !!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop !!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy !!!");
    }

    /**
     只在程序有异常退出时，并恢复时才会触发
     @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            String key = savedInstanceState.getString(KEY);
            Log.d(TAG, "onRestoreInstanceState : " + key);
        }


    }
}
