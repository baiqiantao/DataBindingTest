package com.bqt.databinding.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.view.View;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityObservableBinding;
import com.bqt.databinding.model.ObservableUser;
import com.bqt.databinding.model.PlainUser;
import com.bqt.databinding.model.User;

public class ObservableActivity extends Activity {
	
	private User user = new User();
	private ObservableUser observableUser = new ObservableUser();
	private PlainUser plainUser = new PlainUser();
	private ObservableArrayMap<String, Object> mapUser = new ObservableArrayMap<>();
	private ObservableArrayList<Object> listUser = new ObservableArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
		
		binding.setUser(user);
		binding.setObservableUser(observableUser);
		binding.setPlainUser(plainUser);
		binding.setMapUser(mapUser);
		binding.setListUser(listUser);
	}
	
	public void setOtherName(View view) {
		user.firstName = "包青天，普通User(数据更改后并不会自动更新UI)";
		
		observableUser.setName("包青天，BaseObservable");
		
		plainUser.name.set("包青天，ObservableField");
		plainUser.age.set(27);
		
		mapUser.put("name", "包青天，ObservableArrayMap");
		mapUser.put("age", 27);
		
		listUser.set(0, "包青天，ObservableArrayList");
		listUser.set(1, 27);
	}
	
	public void setMyName(View view) {
		observableUser.setName("BaseObservable");
		
		plainUser.name.set("ObservableField");
		plainUser.age.set(27);
		
		mapUser.put("name", "ObservableArrayMap");
		mapUser.put("age", 27);
		
		if (listUser.size() == 0) {
			listUser.add("ObservableArrayList");
			listUser.add(27);
		} else {
			listUser.set(0, "ObservableArrayList");
			listUser.set(1, 27);
		}
	}
}
