package com.zz.chapter04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    // 用来记录所有Activity的集合
    protected static final List<BaseActivity> mActivities = new LinkedList<>();
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Log输出当前运行的Activity
        Log.i(TAG, getClass().getSimpleName());

        // 如果Activity调用了onCreate()方法，证明打开了当前Activity，添加到集合中
        synchronized (mActivities) {
            mActivities.add(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 如果Activity调用了onDestroy()方法，证明当前Activity已经销毁了，在集合中移除
        synchronized (mActivities) {
            mActivities.remove(this);
        }
    }

    /**
     退出整个应用
     */
    public static void exitApp() {
        // 步骤一：退出所有页面
        List<BaseActivity> copy;
        // 集合在遍历过程中是不能增删的，因此需要先把mActivities复制到copy中
        synchronized (mActivities) {
            copy = new ArrayList<>(mActivities);
            for (BaseActivity activity : copy) {
                // finish()会调用Activity的onDestroy()方法
                activity.finish();
            }
        }

        // 步骤二：退出App进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}

