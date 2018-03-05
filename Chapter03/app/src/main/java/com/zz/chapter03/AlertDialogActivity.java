package com.zz.chapter03;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    private static final String TAG = "AlertDialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);


    }

    // 一般对话框
    public void normalDialog(View view) {
        // 先得到构造器
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // 此处必须是Activity，不能是getApplicationContext()
        // 样式
        builder.setTitle("提示"); // 标题
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setMessage("是否确认退出");
        builder.setCancelable(false); // 点击框外不可退出
        // 点击确认
        builder.setPositiveButton("确认",
                (dialogInterface, i) -> dialogInterface.dismiss());
        // 点击取消
        builder.setNegativeButton("取消",
                (dialogInterface, i) -> dialogInterface.dismiss());
        // 点击忽略
        builder.setNeutralButton("忽略",
                ((dialogInterface, i) -> dialogInterface.dismiss()));
        // 显示Dialog
        builder.show();

    }

    // 列表对话框
    public void listDialog(View view) {
        // 条目的标题
        String items[] = {"AAA", "BBB", "CCC"}; // 不推荐在代码中写死，推荐写法见下一节
        // Dialog构造器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 样式 --> 设置列表显示，就不要设置Message了，否则列表不起作用
        builder.setTitle("提示");
        builder.setIcon(R.mipmap.ic_launcher_round);
//        builder.setMessage("真的不起作用吗？"); // NOTICE 真的不起作用。。
        // 样式 --> 列表
        builder.setItems(items, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
        });
        // 样式 --> 按钮
        // 点击确认
        builder.setPositiveButton("确认",
                (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                    Toast.makeText(getApplicationContext(), "确认", Toast.LENGTH_SHORT).show();
                });
        // 点击取消
        builder.setNegativeButton("取消",
                (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                    Toast.makeText(getApplicationContext(), "取消", Toast.LENGTH_SHORT).show();
                });
        // 点击忽略
        builder.setNeutralButton("忽略",
                (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                    Toast.makeText(getApplicationContext(), "忽略", Toast.LENGTH_SHORT).show();
                });
        // 显示Dialog
        builder.show();
    }

    // 单选对话框
    public void singleDialog(View view) {
        // 条目的标题
//        String items[] = {"男", "女", "其它"}; // 项目中不能这么用，要用资源文件调取资源
        String items[] = getResources().getStringArray(R.array.sex);
        final int[] iItemsChoiced = {0};
        // Dialog构造器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 样式 --> 设置列表显示，就不要设置Message了，否则列表不起作用
        builder.setTitle("提示");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setCancelable(false);
        // 样式 --> 单选列表
        builder.setSingleChoiceItems(items, 0, (dialogInterface, i) -> { // 第二个参数是DefaultItem，-1为无默认选项
            Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
            iItemsChoiced[0] = i;
        });
        // 点击确认
        builder.setPositiveButton("确认", (dialogInterface, i) -> {
            dialogInterface.dismiss();
            Toast.makeText(getApplicationContext(), "确认 ： " + items[iItemsChoiced[0]], Toast.LENGTH_SHORT).show();
        });
        // 显示Dialog
        builder.show();
    }

    // 多选对话框
    public void multiDialog(View view) {
        // 条目的标题
        String[] items = getResources().getStringArray(R.array.hobby);
        // 选择的条目
        boolean[] itemsChoiced = new boolean[items.length];
        // 默认初始化都不选
        for (int i = 0; i < itemsChoiced.length; i++) {
            itemsChoiced[i] = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("爱好");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setCancelable(false);
        // 样式 --> 多选列表
        builder.setMultiChoiceItems(items, itemsChoiced,
                (dialogInterface, i, b) -> {
                    itemsChoiced[i] = b;
                    Toast.makeText(getApplicationContext(), items[i] + " isChecked", Toast.LENGTH_SHORT).show();
                });

        builder.setPositiveButton(R.string.ok, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            Toast.makeText(getApplicationContext(), R.string.ok, Toast.LENGTH_SHORT).show();
            for (boolean anItemsChoiced : itemsChoiced) {
                Log.i(TAG, "multiDialog: " + anItemsChoiced);
            }
        });
        builder.show();
    }

    // 自定义对话框
    public void customDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义的Dialog");
        builder.setIcon(R.mipmap.ic_launcher);

        // 载入自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_custom, null);
        builder.setView(layout);

        // 得到控件
        EditText et_name = layout.findViewById(R.id.et_name);
        EditText et_pwd = layout.findViewById(R.id.et_pwd);

        // 确认按钮
        builder.setPositiveButton(R.string.ok, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            Toast.makeText(getApplicationContext(), et_name.getText().toString() + " : " + et_pwd.getText().toString(), Toast.LENGTH_SHORT).show();
        });

        builder.show();

    }
}
