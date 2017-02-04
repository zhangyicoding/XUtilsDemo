package org.mobiletrain.xutilsdemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import org.mobiletrain.xutilsdemo.R;
import org.mobiletrain.xutilsdemo.fragment.GetBytesFragment;
import org.mobiletrain.xutilsdemo.fragment.GetStringFragment;
import org.mobiletrain.xutilsdemo.fragment.PostFileFragment;
import org.mobiletrain.xutilsdemo.fragment.PostStringFragment;

/**
 * http模块
 * 需要实现Callback.CommonCallback<T>接口，监听数据下载情况
 * 泛型T：请求访问的数据类型，例如String、byte[]等
 * 详情见http模块对应Fragment
 */
public class HttpActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup group;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private GetStringFragment getStringFragment;
    private GetBytesFragment getBytesFragment;
    private PostStringFragment postStringFragment;
    private PostFileFragment postFileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        group = (RadioGroup) findViewById(R.id.http_group);
        group.setOnCheckedChangeListener(this);

        manager = getSupportFragmentManager();

        getStringFragment = new GetStringFragment();
        getBytesFragment = new GetBytesFragment();
        postStringFragment = new PostStringFragment();
        postFileFragment = new PostFileFragment();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = manager.beginTransaction();
        switch (checkedId) {
            case R.id.get_string_btn:
                transaction.replace(R.id.fragment_container, getStringFragment);
                break;
            case R.id.get_bytes_btn:
                transaction.replace(R.id.fragment_container, getBytesFragment);
                break;
            case R.id.post_string_btn:
                transaction.replace(R.id.fragment_container, postStringFragment);
                break;
            case R.id.post_File_btn:
                transaction.replace(R.id.fragment_container, postFileFragment);
                break;
        }
        transaction.commit();
    }
}
