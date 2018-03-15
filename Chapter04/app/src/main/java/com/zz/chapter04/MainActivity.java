package com.zz.chapter04;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_start_demo2_ac_by_explicit_intent).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Demo2Activity.class);
            startActivity(intent);
        });
        findViewById(R.id.bt_start_demo2_ac_by_implicit_intent).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setAction("com.zz.START_ACTIVITY_BY_IMPLICIT_INTENT");
            startActivity(intent);
        });

        findViewById(R.id.bt_start_send_data_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, SendDataActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.bt_start_call_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, CallActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.bt_start_life_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, LifeActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.bt_start_launch_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, LaunchActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.bt_start_actionbar_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, ActionBarActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.bt_start_toolbar_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, ToolBarActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.bt_start_navigation_drawer_ac).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, NavigationDrawerActivity.class);
            startActivity(intent);
        });
    }
}
