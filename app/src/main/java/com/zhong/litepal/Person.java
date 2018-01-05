package com.zhong.litepal;

import org.litepal.crud.DataSupport;

/**
 * @author zhonghuibin
 * @data 2018/1/5 13:21
 */

public class Person extends DataSupport{
    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
