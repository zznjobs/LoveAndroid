package com.zz.chapter04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveShareActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_share);

        TextView tv_receive = (TextView) findViewById(R.id.tv_receive);
        receiveShareText(tv_receive);
    }

    private void receiveShareText(TextView textView) {
        Intent intent = getIntent();
        if (Intent.ACTION_SEND.equals(intent.getAction()) && "text/plain".equals(intent.getType())) {
            String text = intent.getStringExtra(Intent.EXTRA_TEXT);
            textView.setText(text);
        } else {
            textView.setText("没有接收到文本");
        }
    }
}
