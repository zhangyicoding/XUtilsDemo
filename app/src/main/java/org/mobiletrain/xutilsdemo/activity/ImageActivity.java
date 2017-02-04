package org.mobiletrain.xutilsdemo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import org.mobiletrain.xutilsdemo.R;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * 图片模块
 * 下载的图片自动做二级缓存处理：内存缓存、文件缓存
 */
public class ImageActivity extends AppCompatActivity {
    public static final String IMG_URL = "https://www.baidu.com/img/bd_logo1.png";

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        imageView = (ImageView) findViewById(R.id.iv);


        // 普通方式展示网络图片
//        x.image().bind(imageView, IMG_URL);

        // 设置参数展示网络图片
        ImageOptions options = new ImageOptions.Builder()
                .setRadius(50)// 圆角半径
//                .setCircular(true)// 圆图
                .setSize(200, 200)// 固定大小
                .build();
        x.image().bind(imageView, IMG_URL, options);


        // 清除磁盘上的缓存图片文件
//        x.image().clearCacheFiles();
        // 清除内存中的缓存图片
//        x.image().clearMemCache();
    }




    // 权限请求码
    private final int REQUEST_CODE = 1;



    // Android6.0系统申请读写外部存储的运行时权限（该方法在需要操作外部存储时调用，或在相关初始化操作中调用）
    private void requestPermissions() {
        // 如果未获得外部存储读写权限，则申请
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        }
    }



    // 请求运行时权限的回调方法
    // requestCode：用于识别申请权限的请求码
    // permissions：请求的权限
    // grantResults：对应权限的请求结果
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 允许权限
                    Toast.makeText(ImageActivity.this, "允许权限", Toast.LENGTH_SHORT).show();
                } else {
                    // 拒绝权限
                    Toast.makeText(ImageActivity.this, "拒绝权限", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
