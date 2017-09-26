package com.bqt.databinding.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityViewStubBinding;
import com.bqt.databinding.databinding.MViewStubBinding;
import com.bqt.databinding.model.User;

public class ViewStubActivity extends Activity {
    private ActivityViewStubBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        mBinding.mViewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                MViewStubBinding binding = DataBindingUtil.bind(inflated);
                User user = new User("包", "青天");
                binding.setUser(user);
            }
        });

    }


    /**
     * Don't panic for red error reporting. Just ignore it and run the app. Surprise never ends.
     */
    public void inflateViewStub(View view) {
        if (!mBinding.mViewStub.isInflated()) {
            mBinding.mViewStub.getViewStub().inflate();
        }
    }
}