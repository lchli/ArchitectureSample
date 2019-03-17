package com.lch.mvvm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichenghang on 2019/3/17.
 */

public class MainModel {
    private String name;
    private String age;
    private String sex;

    private final List<DataChangedListener> listeners = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        for (DataChangedListener lsn : listeners) {
            lsn.onNameChanged();
        }
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        for (DataChangedListener lsn : listeners) {
            lsn.onAgeChanged();
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        for (DataChangedListener lsn : listeners) {
            lsn.onSexChanged();
        }
    }

    public void addListener(DataChangedListener lsn) {
        listeners.add(lsn);
    }

    public void removeListener(DataChangedListener lsn) {
        listeners.remove(lsn);
    }


    public interface DataChangedListener {
        void onNameChanged();

        void onAgeChanged();

        void onSexChanged();

    }
}
