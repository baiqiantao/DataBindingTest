package com.bqt.databinding.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityBindEachOtherBinding;
import com.bqt.databinding.model.PlainUser;

public class BindEachOtherActivity extends Activity {
	private PlainUser user = new PlainUser();
	private PlainUser user2 = new PlainUser();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityBindEachOtherBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_each_other);
		binding.setUser(user);
		binding.setUser2(user2);
		
		user.name.set("采用  @{user.name}  方式");
		user2.name.set("采用  @={user.name}  方式");
	}
	
	public void showUser(View view) {
		//通过【 @{user.name} 】方式绑定时，当用户更改EditText中的内容时，和它绑定的变量【不会】同步改变。
		//通过【 @={user.name} 】方式绑定时，当用户更改EditText中的内容时，和它绑定的变量【会】同步改变。
		Toast.makeText(this, user.name.get() + "\n" + user2.name.get(), Toast.LENGTH_SHORT).show();
	}
}