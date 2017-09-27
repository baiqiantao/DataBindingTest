package com.bqt.databinding.sample;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityConversionsBinding;

public class ConversionsActivity extends Activity {
	
	private ObservableBoolean mIsError = new ObservableBoolean();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityConversionsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_conversions);
		mIsError.set(true);
		binding.setIsError(mIsError);
		binding.setHeight(567.8f);
	}
	
	public void toggleIsError(View view) {
		mIsError.set(!mIsError.get());
	}
	
	@BindingConversion
	public static ColorDrawable convertColorToDrawable(int color) {
		return new ColorDrawable(color);
	}
	
	@BindingAdapter("layout_height")
	public static void setLayoutHeight(View view, float height) {
		ViewGroup.LayoutParams params = view.getLayoutParams();
		params.height = (int) height;
		view.setLayoutParams(params);
	}
	
	/**
	 * !!! Binding conversion should be forbidden, otherwise it will conflict with{@code android:visiblity} attribute.
	 */
	@BindingConversion
	public static int convertColorToString(int color) {
		switch (color) {
			case Color.RED:
				return R.string.red;
			case Color.WHITE:
				return R.string.white;
		}
		return R.string.app_name;
	}
}
