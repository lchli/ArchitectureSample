package com.lch.mvc.controller;

import com.lch.mvc.model.MainModel;

/**
 * Created by lichenghang on 2019/3/17.
 */

public class MainController {

    private MainModel mainModel;

    public MainController(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void changeName(String newname) {
        mainModel.setName(newname);
    }

    public void changeAge(String age) {
        mainModel.setAge(age);
    }

    public void changeSex(String sex) {
        mainModel.setSex(sex);
    }
}
