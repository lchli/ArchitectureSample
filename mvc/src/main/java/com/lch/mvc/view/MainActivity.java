package com.lch.mvc.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.lch.mvc.R;
import com.lch.mvc.controller.MainController;
import com.lch.mvc.model.MainModel;

/**
 * 经典的mvc分层。
 */
public class MainActivity extends AppCompatActivity implements MainModel.DataChangedListener {
    private MainModel mMainModel;
    private MainController mMainController;

    private TextView nameViewText;
    private TextView ageViewText;
    private TextView sexViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameViewText = findViewById(R.id.nameViewText);
        ageViewText = findViewById(R.id.ageViewText);
        sexViewText = findViewById(R.id.sexViewText);

        final EditText nameView = findViewById(R.id.nameView);
        final EditText ageView = findViewById(R.id.ageView);
        final EditText sexView = findViewById(R.id.sexView);
        nameView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mMainController.changeName(nameView.getText().toString());
            }
        });

        ageView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mMainController.changeAge(ageView.getText().toString());
            }
        });

        sexView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mMainController.changeSex(sexView.getText().toString());
            }
        });


        mMainModel = new MainModel();
        mMainController = new MainController(mMainModel);
        mMainModel.addListener(this);
    }

    @Override
    public void onNameChanged() {
        nameViewText.setText(mMainModel.getName());

    }

    @Override
    public void onAgeChanged() {
        ageViewText.setText(mMainModel.getAge() + "");

    }

    @Override
    public void onSexChanged() {
        sexViewText.setText(mMainModel.getSex());

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainModel.removeListener(this);
    }
}
