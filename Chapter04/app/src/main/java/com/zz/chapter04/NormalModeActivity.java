package com.zz.chapter04;

import android.os.Bundle;

public class NormalModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);

        findViewById(R.id.bt_exit_app).setOnClickListener(v ->
                exitApp());
    }
}
