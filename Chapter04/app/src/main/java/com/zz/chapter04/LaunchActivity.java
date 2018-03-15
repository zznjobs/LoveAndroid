package com.zz.chapter04;

import android.content.Intent;
import android.os.Bundle;

public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        findViewById(R.id.bt_start_exclude_from_recents_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, NormalModeActivity.class);
            startActivity(intent);
        });
    }
}
