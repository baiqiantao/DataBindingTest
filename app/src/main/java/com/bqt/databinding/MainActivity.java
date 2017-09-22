package com.bqt.databinding;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bqt.databinding.sample.ConversionsActivity;
import com.bqt.databinding.sample.DynamicActivity;
import com.bqt.databinding.sample.ObservableActivity;
import com.bqt.databinding.sample.ResourceActivity;
import com.bqt.databinding.sample.ViewWithIDsActivity;
import com.bqt.databinding.sample.AttributeSettersActivity;
import com.bqt.databinding.sample.BasicActivity;
import com.bqt.databinding.sample.CollectionActivity;
import com.bqt.databinding.sample.CustomBindingActivity;
import com.bqt.databinding.sample.IncludeActivity;
import com.bqt.databinding.sample.ViewStubActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] array = {"0、A simple basic example",
				"1、Custom Binding",
				"2、includes",
				"3、Collections",
				"4、Resources",
				"5、Observable【】",
				"6、View with IDs",
				"7、ViewStubs【】",
				"8、Dynamic Variables【】",
				"9、Attribute Setters",
				"10、Converters【】",};
		
		setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(array))));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
			case 0:
				startActivity(new Intent(this, BasicActivity.class));
				break;
			case 1:
				startActivity(new Intent(this, CustomBindingActivity.class));
				break;
			case 2:
				startActivity(new Intent(this, IncludeActivity.class));
				break;
			case 3:
				startActivity(new Intent(this, CollectionActivity.class));
				break;
			case 4:
				startActivity(new Intent(this, ResourceActivity.class));
				break;
			case 5:
				startActivity(new Intent(this, ObservableActivity.class));
				break;
			case 6:
				startActivity(new Intent(this, ViewWithIDsActivity.class));
				break;
			case 7:
				startActivity(new Intent(this, ViewStubActivity.class));
				break;
			case 8:
				startActivity(new Intent(this, DynamicActivity.class));
				break;
			case 9:
				startActivity(new Intent(this, AttributeSettersActivity.class));
				break;
			case 10:
				startActivity(new Intent(this, ConversionsActivity.class));
				break;
		}
	}
}
