package org.mobiletrain.xutilsdemo.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "table_person")
public class PersonEntity {

    @Column(name = "_id", isId = true)
    private int _id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name =  "sex")
    private boolean sex;

    // 必须有一个无参构造方法
    public PersonEntity() {
    }

    public PersonEntity(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
