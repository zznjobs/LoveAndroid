package com.zz.chapter04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SendDataActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        findViewById(R.id.bt_start_receive_data_ac).setOnClickListener(v -> {

            // 传统写法
//            Intent intent = new Intent(this, ReceiveDataActivity.class);
//            intent.putExtra("key", "我很棒！");
//            startActivity(intent);

            // 静态工厂设计模式 写法
            Intent intent = ReceiveDataActivity.newIntent(this, "我好棒！");
            // 单纯发送数据
//            startActivity(intent);
            // 发送数据，并接收返回数据
            startActivityForResult(intent, 0);
        });
    }

    /**
     接收返回数据
     @param requestCode requestCode
     @param resultCode  resultCode
     @param data        data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0 && data != null) {
            String result = data.getStringExtra("result");
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }
    }
}
