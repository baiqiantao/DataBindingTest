package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityViewWithIdsBinding;

public class ViewWithIDsActivity extends Activity {

    ActivityViewWithIdsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_with_ids);
    }

    public void showMyName(View view) {
        binding.firstName.setText("包");
        binding.lastName.setText("青天");
    }
}
