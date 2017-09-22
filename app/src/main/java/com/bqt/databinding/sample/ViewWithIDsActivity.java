package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityViewWithIdsBinding;

public class ViewWithIDsActivity extends BaseActivity {

    ActivityViewWithIdsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_with_ids);
    }

    public void showMyName(View view) {
        binding.firstName.setText("liang");
        binding.lastName.setText("fei");
    }
}
