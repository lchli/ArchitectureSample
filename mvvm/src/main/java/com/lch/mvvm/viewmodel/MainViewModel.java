package com.lch.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.lch.mvvm.model.MainModel;

/**
 * Created by lichenghang on 2019/3/17.
 */

public class MainViewModel extends ViewModel implements MainModel.DataChangedListener {
    public final MutableLiveData<String> name = new MutableLiveData<>();
    public final MutableLiveData<String> age = new MutableLiveData<>();
    public final MutableLiveData<String> sex = new MutableLiveData<>();

    private MainModel mMainModel;

    public MainViewModel() {
        mMainModel = new MainModel();
        mMainModel.addListener(this);
    }

    public void changeName(String newname) {
        mMainModel.setName(newname);

    }

    public void changeAge(String age) {
        mMainModel.setAge(age);
    }

    public void changeSex(String sex) {
        mMainModel.setSex(sex);
    }


    @Override
    public void onNameChanged() {
        name.postValue(mMainModel.getName());
    }

    @Override
    public void onAgeChanged() {
        age.postValue(mMainModel.getAge() + "");

    }

    @Override
    public void onSexChanged() {
        sex.postValue(mMainModel.getSex());

    }
}
