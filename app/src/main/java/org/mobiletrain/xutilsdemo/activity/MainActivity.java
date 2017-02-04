package org.mobiletrain.xutilsdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.mobiletrain.xutilsdemo.R;

/**
 * xUtils四大模块：必须在自定义application中初始化！
 * http模块
 * image模块
 * database模块
 * view模块
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void http(View view) {
        startActivity(HttpActivity.class);
    }

    public void image(View view) {
        startActivity(ImageActivity.class);
    }

    public void database(View view) {
        startActivity(DatabaseActivity.class);
    }

    public void view(View view) {
        startActivity(ViewActivity.class);
    }

    private void startActivity(Class target) {
        startActivity(new Intent(this, target));
    }

}
