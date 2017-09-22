package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import android.app.Activity;

import com.bqt.databinding.OkListener;
import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityIncludeBinding;
import com.bqt.databinding.model.User;

public class IncludeActivity extends Activity implements OkListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final ActivityIncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);
		
		binding.setListener(this);
		binding.setOkText("点击有福利");
		
		//in order to get the etName, you must define an id for the include tag.
		binding.layoutInput.etName.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				User user = new User(s.toString(), "包");
				
				binding.setUser(user);
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});
	}
	
	@Override
	public void onClickOk(View view) {
		Toast.makeText(this, "the btn clicked!", Toast.LENGTH_SHORT).show();
	}
}

