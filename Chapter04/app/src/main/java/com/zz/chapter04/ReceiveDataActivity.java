package com.zz.chapter04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ReceiveDataActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        // 返回数据
        findViewById(R.id.bt_exit_ac_n_return_data).setOnClickListener(v -> {
            Intent intent = getIntent();
            intent.putExtra("result", "你好棒！");
            setResult(0, intent);
            finish();
        });

        // 单纯接收数据
        receiveData();

    }

    /**
     单纯接收数据
     */
    private void receiveData() {
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
    }

    // 静态工厂设计模式
    public static Intent newIntent(Context context, String value) {
        Intent intent = new Intent(context, ReceiveDataActivity.class);
        intent.putExtra("key", value);
        return intent;
    }

    /**
     监听返回键
     */
    @Override
    public void onBackPressed() {
        // 模拟点击Button
        findViewById(R.id.bt_exit_ac_n_return_data).performClick();
        super.onBackPressed();
    }
}
