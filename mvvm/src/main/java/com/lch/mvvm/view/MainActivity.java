package com.lch.mvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lch.mvvm.R;
import com.lch.mvvm.databinding.ActivityMainBinding;
import com.lch.mvvm.viewmodel.MainViewModel;

/**
 * mvvm分层模式。
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_main, null);
        setContentView(view);
        binding = ActivityMainBinding.bind(view);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        binding.setViewmodel(mMainViewModel);////
        binding.setLifecycleOwner(this);
    }
}
