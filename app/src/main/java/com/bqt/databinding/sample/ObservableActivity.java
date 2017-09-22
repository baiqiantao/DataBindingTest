package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityObservableBinding;
import com.bqt.databinding.model.ObservableUser;
import com.bqt.databinding.model.PlainUser;


public class ObservableActivity extends Activity {

    private ObservableUser user = new ObservableUser();
    private PlainUser plainUser = new PlainUser();
    private ObservableArrayMap<String, Object> mapUser = new ObservableArrayMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityObservableBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_observable);

        setMyName(null);

        binding.setUser(user);
        binding.setPlainUser(plainUser);
        binding.setMapUser(mapUser);
    }

    public void setOtherName(View view) {
        user.setFirstName("zhu");
        user.setLastName("chen");

        plainUser.firstName.set("zhu");
        plainUser.lastName.set("chen");
        plainUser.age.set(27);

        mapUser.put("firstName", "zhu");
        mapUser.put("lastName", "chen");
        mapUser.put("age", 27);
    }

    public void setMyName(View view) {
        user.setFirstName("包");
        user.setLastName("青天");

        plainUser.firstName.set("包");
        plainUser.lastName.set("青天");
        plainUser.age.set(27);

        mapUser.put("firstName", "包");
        mapUser.put("lastName", "青天");
        mapUser.put("age", 27);
    }
}
