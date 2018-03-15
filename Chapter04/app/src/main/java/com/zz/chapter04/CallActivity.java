package com.zz.chapter04;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class CallActivity extends BaseActivity {

    private static final int REQUEST_CODE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        // API22以下打电话的代码（Android 5.1）
        findViewById(R.id.bt_call_below_api22).setOnClickListener(v -> callBelowApi22());

        // 方法一：简单粗暴，不推荐
        findViewById(R.id.bt_call_above_api23).setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= 23) {
                // API23及以上
                callAboveApi23();
            } else {
                // API22及以下
                callBelowApi22();
            }

        });

        // 方法二：系统Api自动判断，推荐
        findViewById(R.id.bt_call_above_api23_perfect).setOnClickListener(v -> {
            callAboveApi23Perfect();
        });

        // 方法三：RxPermission，推荐
        findViewById(R.id.bt_call_above_api23_rx).setOnClickListener((View v) -> {
            RxPermissions permissions = new RxPermissions(this);
            permissions
                    // 申请权限
                    .request(Manifest.permission.CALL_PHONE)
                    .subscribe(granted -> {
                        if (granted) {
                            // 请求成功
                            callBelowApi22();
                        } else {
                            // 请求失败
                            Toast.makeText(getApplicationContext(), "没有得到电话权限，请在设置中授权", Toast.LENGTH_SHORT).show();
                        }
                    });
        });


    }

    /**
     API22以下打电话的代码（Android 5.1）
     API23以上的Android设备会因为没有权限而崩溃
     */
    private void callBelowApi22() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:10010"));
        startActivity(intent);
    }

    /**
     API23及以上播打电话
     API23及以上可用
     API22及以下会崩溃，因为低版本没有如下方法
     */
    @SuppressLint("NewApi")
    private void callAboveApi23() {
        int i = checkSelfPermission(Manifest.permission.CALL_PHONE);
        if (i != PackageManager.PERMISSION_GRANTED) {
            // 此时系统会弹出权限框
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
            return;
        }
        // 如果有授权直接拨打电话
        callBelowApi22();
    }

    /**
     播打电话
     适配任意版本Android
     */
    private void callAboveApi23Perfect() {
        int i = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (i != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
            return;
        }
        callBelowApi22();
    }

    /**
     重写权限结果方法，以进行操作
     @param requestCode  requestCode
     @param permissions  permissions
     @param grantResults grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_CALL) { // 需要校验requestCode
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 得到权限
                callBelowApi22();
            } else {
                Toast.makeText(getApplicationContext(), "没有得到电话权限，请在设置中授权", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
