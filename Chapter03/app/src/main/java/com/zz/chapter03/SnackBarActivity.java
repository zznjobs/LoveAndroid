package com.zz.chapter03;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SnackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        View fab_add = findViewById(R.id.fab_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar(view);
            }
        });
    }

    /*
    1. Snackbar的基本用法
        Snackbar.make(view,text,duration).show();
        view --> 推荐是CoordinatorLayout，这会把Snackbar与CoordinatorLayout关联起来，联合显示MD动画。
                （比如右滑删除SnackBar）
                 如果不是，会从该view逐级向上查找父CoordinatorLayout，并试图与之关联。
                 如果查找到最顶级仍然没有CoordinatorLayout，就不显示MD动画。
    2. Snackbar的带Action用法
        Snackbar.make(view,text,duration)
        .setAction(String actionName, View.OnClickListener listener)
        .show();
        actionName --> 就是该操作的名字，如Remove等等

     */
    private void showSnackBar(View view) {
        final Snackbar mSnackbar = Snackbar.make(view, "一个Item显示出来了", Snackbar.LENGTH_LONG);
        mSnackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar.dismiss();
            }
        }).show();
    }
}
