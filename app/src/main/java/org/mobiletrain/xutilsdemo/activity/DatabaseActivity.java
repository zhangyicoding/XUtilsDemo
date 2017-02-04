package org.mobiletrain.xutilsdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import org.mobiletrain.xutilsdemo.R;
import org.mobiletrain.xutilsdemo.application.MyApp;
import org.mobiletrain.xutilsdemo.bean.PersonEntity;
import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;

import java.util.List;

/**
 * 数据库模块
 * 查询和插入对象
 */
public class DatabaseActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private EditText nameET, ageET;
    private CheckBox sexBox;
    private TextView textView;

    // 全局的数据库管理者
    private DbManager dbManager;

    private boolean isMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        initView();
        MyApp app = (MyApp) getApplication();
        dbManager = app.getDbManager();
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.tv);
        nameET = (EditText) findViewById(R.id.name_et);
        ageET = (EditText) findViewById(R.id.age_et);
        sexBox = (CheckBox) findViewById(R.id.sex_box);
        sexBox.setOnCheckedChangeListener(this);
    }

    // 插入数据
    public void insert(View view) {
        String name = nameET.getText().toString();
        String ageString = ageET.getText().toString();
        int age = Integer.parseInt(ageString);
        PersonEntity person = new PersonEntity(name, age, isMale);

        try {
            // 核心插入语句
            dbManager.save(person);
            // 自己写的查询方法，见下，下同
            query(null);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    // 删除数据
    public void delete(View view) {
        try {
            // 核心删除语句
            dbManager.delete(PersonEntity.class, WhereBuilder.b("age", "=", 19));
//            dbManager.deleteById(PersonEntity.class, 1);
            query(null);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    // 修改数据
    public void update(View view) {
        try {
            // 核心修改语句
            dbManager.update(PersonEntity.class, WhereBuilder.b("age", "=", "18"), new KeyValue("name", "赵四s"), new KeyValue("sex", true));
            query(null);
        } catch (DbException e) {
            e.printStackTrace();
        }

    }

    // 查询数据
    public void query(View view) {
        try {
            // 查询全部数据
            List<PersonEntity> personEntityList = dbManager.selector(PersonEntity.class)
//                    .where("age", ">", 18)// 查询条件，可选项
                    .findAll();
            for (PersonEntity personEntity : personEntityList) {
                String name = personEntity.getName();
                int age = personEntity.getAge();
                boolean sex = personEntity.isSex();
                Log.d("tag", "name : " + name + ", age : " + age + ", sex : " + sex);
            }
            Log.d("tag", "————————————————————");
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isMale = isChecked;
    }
}
