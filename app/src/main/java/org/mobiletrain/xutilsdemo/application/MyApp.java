package org.mobiletrain.xutilsdemo.application;

import android.app.Application;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * xUtils必须执行全局初始化
 * 数据库模块需要执行全局初始化
 */
public class MyApp extends Application {
    public DbManager dbManager;

    public DbManager getDbManager() {
        return dbManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // xUtils全局初始化
        x.Ext.init(this);

        // 初始化数据库
       initDB();
    }

    private void initDB() {
        DbManager.DaoConfig config = new DbManager
                .DaoConfig()
                .setDbName("my_databse")// 数据库文件名
                .setDbVersion(1)// 数据库版本号
                .setDbUpgradeListener(null);// 数据库版本升级监听器

        dbManager = x.getDb(config);
    }

}
