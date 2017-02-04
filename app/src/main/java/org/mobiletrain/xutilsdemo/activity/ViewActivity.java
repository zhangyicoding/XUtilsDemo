package org.mobiletrain.xutilsdemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.mobiletrain.xutilsdemo.R;
import org.mobiletrain.xutilsdemo.fragment.ViewFragment;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * View模块
 * 不再使用代码初始化UI控件，而是采用注解+反射机制初始化
 */

@ContentView(R.layout.activity_view)
public class ViewActivity extends AppCompatActivity {

    @ViewInject(R.id.tv)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view);
        // 注入布局及UI控件
        x.view().inject(this);

        textView.setText("View模块");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new ViewFragment());
        fragmentTransaction.commit();
    }

    // 默认单击事件
    @Event(R.id.click_btn)
    private void clickBtn(View view) {
        Toast.makeText(this, "默认单击", Toast.LENGTH_SHORT).show();
    }

    // 长点击事件
    @Event(type = View.OnLongClickListener.class, value = R.id.long_click_btn)
    private boolean longClickBtn(View view) {
        Toast.makeText(this, "长点击", Toast.LENGTH_LONG).show();
        return true;
    }

}
