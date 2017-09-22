package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.app.Activity;

import com.bqt.databinding.ContractBinding;
import com.bqt.databinding.R;
import com.bqt.databinding.model.Contact;

public class CustomBindingActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ContractBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_binding);
		
		Contact contact = new Contact("18680536603", "广州市珠江新城，富力东山新天地中心");
		binding.setContact(contact);
	}
}
