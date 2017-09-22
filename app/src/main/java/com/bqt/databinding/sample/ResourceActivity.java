package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.app.Activity;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ResourceBinding;

public class ResourceActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ResourceBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_resource);
		
		binding.setLarge(true);
		
		binding.setFirstName("包");
		binding.setLastName("青天");
		
		binding.setBananaCount(1);
		binding.setOrangeCount(10);
	}
}
