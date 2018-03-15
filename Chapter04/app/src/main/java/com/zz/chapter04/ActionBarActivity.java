package com.zz.chapter04;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionBarActivity extends BaseActivity {


    /**
     通过重写该方法加载菜单
     @param menu menu
     @return true --> 显示该菜单，false --> 不显示该菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return true;
    }

    /**
     通过重写该方法，实现菜单的点击事件
     @param item item
     @return 布尔返回false，允许正常的菜单处理继续进行，true在这里消费。？啥意思？
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_action_settings:
                Toast.makeText(getApplicationContext(), "点击了设置", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_action_bt1:
                Toast.makeText(getApplicationContext(), "点击了按钮1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_action_bt2:
                Toast.makeText(getApplicationContext(), "点击了按钮2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        // 获取兼容版本的ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("我是ActionBar");
            actionBar.setSubtitle("我是子标题");
        }


    }
}
