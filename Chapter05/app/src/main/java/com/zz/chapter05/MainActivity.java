package com.zz.chapter05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String USERNAME = "USERNAME";
    private static final String PASSWORD = "PASSWORD";
    private static final String CHECKED = "CHECKED";
    private SharedPreferences spConfig;

    private EditText et_username;
    private EditText et_password;
    private CheckBox cb_remember_pwd;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spConfig = getSharedPreferences("config", MODE_PRIVATE);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_remember_pwd = (CheckBox) findViewById(R.id.cb_remember_pwd);

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(v -> {
            SharedPreferences.Editor editor = spConfig.edit();
            if (cb_remember_pwd.isChecked()) {
                // 记住密码
                editor.putString(USERNAME, et_username.getText().toString());
                editor.putString(PASSWORD, et_password.getText().toString());
                editor.putBoolean(CHECKED, true);
            } else {
                // 不记住密码，清空之前保存的数据
                editor.putString(USERNAME, "");
                editor.putString(PASSWORD, "");
                editor.putBoolean(CHECKED, false);
            }
            editor.apply();
            finish();
        });

        // 数据的回显
        et_username.setText(spConfig.getString(USERNAME, ""));
        et_password.setText(spConfig.getString(PASSWORD, ""));
        cb_remember_pwd.setChecked(spConfig.getBoolean(CHECKED, false));

        // 打开FileActivity
        findViewById(R.id.bt_open_file_ac).setOnClickListener(v -> {
            startActivity(new Intent(this, FileActivity.class));
        });

        // 打开ExternalActivity
        findViewById(R.id.bt_open_external_ac).setOnClickListener(v -> {
            startActivity(new Intent(this, ExternalActivity.class));
        });


    }
}
