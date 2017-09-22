package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ResourceBinding;

public class ResourceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourceBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_resource);

        binding.setLarge(true);

        binding.setFirstName("liang");
        binding.setLastName("fei");

        binding.setBananaCount(2);
        binding.setOrangeCount(10);
    }
}
