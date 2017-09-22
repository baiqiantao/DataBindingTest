package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityBasicBinding;
import com.bqt.databinding.model.User;

public class BasicActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBasicBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_basic);
        User user = new User("fei", "Liang", 27);
        binding.setUser(user);
    }
}

