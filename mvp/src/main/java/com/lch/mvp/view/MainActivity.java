package com.lch.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.lch.mvp.R;
import com.lch.mvp.presenter.MainPresenter;

/**
 * mvp分层(实际上是mvc分层的改进版本)。
 */
public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    private MainPresenter mMainPresenter;

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
                mMainPresenter.changeName(nameView.getText().toString());
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
                mMainPresenter.changeAge(ageView.getText().toString());
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
                mMainPresenter.changeSex(sexView.getText().toString());
            }
        });


        mMainPresenter = new MainPresenter(this);
    }


    @Override
    public void showName(String name) {
        nameViewText.setText(name);
    }

    @Override
    public void showAge(String age) {
        ageViewText.setText(age);
    }

    @Override
    public void showSex(String sex) {
        sexViewText.setText(sex);

    }


}
