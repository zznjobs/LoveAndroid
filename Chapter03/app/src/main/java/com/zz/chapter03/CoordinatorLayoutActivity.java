package com.zz.chapter03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    /*
    TODO
    CoordinatorLayout是一个增强版的FrameLayout
    强大之处在于可以处理各子View之间的依赖关系

    啥意思？
    不懂啊？
    太简略了…

     --> 见SnackBarActivity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CoordinatorLayoutActivity.this,"点击了FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
