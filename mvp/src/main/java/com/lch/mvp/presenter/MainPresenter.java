package com.lch.mvp.presenter;

import com.lch.mvp.model.MainModel;

/**
 * Created by lichenghang on 2019/3/17.
 */

public class MainPresenter implements MainModel.DataChangedListener {


    public interface View {
        void showName(String name);

        void showAge(String age);

        void showSex(String sex);
    }

    private View view;
    private MainModel mMainModel;

    public MainPresenter(View view) {
        this.view = view;
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
        view.showName(mMainModel.getName());
    }

    @Override
    public void onAgeChanged() {
        view.showAge(mMainModel.getAge());

    }

    @Override
    public void onSexChanged() {
        view.showSex(mMainModel.getSex());

    }
}
