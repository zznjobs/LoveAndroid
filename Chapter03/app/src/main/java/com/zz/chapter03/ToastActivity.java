package com.zz.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
    /*
        不使用this作为Toast引用的上下文对象，即可防止内存泄露
        可将this替换为getApplicationContext()
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button bt_normal_toast = findViewById(R.id.bt_normal_toast);
        /*
        TODO
        关于断言 assert
        在C / C++ 中都很常用
        但是在Java中的用法我还没有掌握

        貌似：
        1. 在Java中默认并没有开启assert功能，此时，assert语句是被忽略掉的
        2. 不推荐直接用assert语句，而是用JUnit来代替
         */
        assert bt_normal_toast != null; // 好像没啥用
        bt_normal_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToastActivity.this, "最普通的Toast", Toast.LENGTH_SHORT).show();
            }
        });

        /*
        弹出通过Margin修改的Toast

        Toast.setMargin(float horizontalMargin, float verticalMargin);
        特殊之处在于，此处是百分比
        float horizontalMargin --> 左负右正
        float verticalMargin --> 上正下负

         */
        findViewById(R.id.bt_margin_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast mToastMargin = Toast.makeText(ToastActivity.this, "弹出通过Margin修改的Toast", Toast.LENGTH_SHORT);
                mToastMargin.setMargin(0F, 0F); // 默认位置
                mToastMargin.setMargin(0F, 0.5F); // 默认位置之上空间50%的位置
                mToastMargin.show();

            }
        });

        /*
        弹出通过Gravity修改的Toast

        Toast.setGravity(int gravity, int xOffset, int yOffset);
        int gravity --> Gravity.Bottom这样 / 可以通过｜来复选 --> TODO 原理是什么？
        int xOffset
        int yOffset --> 像素 --> 无论如何修改，Toast都能被保证完整显示
         */
        findViewById(R.id.bt_gravity_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast mToastGravity = Toast.makeText(ToastActivity.this, "弹出通过Gravity修改的Toast", Toast.LENGTH_SHORT);
                mToastGravity.setGravity(Gravity.BOTTOM | Gravity.END, 0, 0);
                mToastGravity.show();
            }
        });

        /*
        弹出代码自定义的Toast
         */
        findViewById(R.id.bt_custom_code_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomToast(CustomToast.TOAST_FROM_CODE);
            }
        });
        /*
        弹出XML自定义的Toast
         */
        findViewById(R.id.bt_custom_xml_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomToast(CustomToast.TOAST_FROM_XML);
            }
        });
    }

    enum CustomToast {
        TOAST_FROM_CODE, TOAST_FROM_XML
    }

    private void showCustomToast(CustomToast type) {
        // 定义一个Toast

        Toast mToast = new Toast(getApplicationContext());
        // 通过Code自定义Toast
        if (type == CustomToast.TOAST_FROM_CODE) {
            // 定义一个ImageView
            ImageView mImageView = new ImageView(getApplicationContext());
            mImageView.setImageResource(R.mipmap.ic_launcher);
            // 定义一个Layout
            LinearLayout mLinearLayout = new LinearLayout(getApplicationContext());
            mLinearLayout.setOrientation(LinearLayout.HORIZONTAL); // 横向
            // 将ImageView放入LinearLayout中
            mLinearLayout.addView(mImageView);
            // 设置Toast的View
            mToast.setView(mLinearLayout);
        }
        // 通过XML自定义Toast
        if (type == CustomToast.TOAST_FROM_XML) {
            // 获取一个Inflater
            LayoutInflater mInflater = getLayoutInflater();
            View mToastView = mInflater.inflate(R.layout.toast_image, null);
            // 设置Toast的View
            mToast.setView(mToastView);
        }
        // 设置Toast的时长并显示
        if (mToast.getView() != null) {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show();
        }
    }

}
