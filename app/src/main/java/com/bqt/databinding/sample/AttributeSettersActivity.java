package com.bqt.databinding.sample;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityAttributeSettersBinding;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class AttributeSettersActivity extends Activity {
	private ActivityAttributeSettersBinding mBinding;
	
	public View.OnClickListener mClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mBinding.setImageUrl("http://img1.mm131.com/pic/2958/" + new Random().nextInt(10) + ".jpg");
			mBinding.setPt(10 * new Random().nextInt(10));
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_attribute_setters);
		mBinding.setActivity(this);
		mBinding.setImageUrl("http://img1.mm131.com/pic/2958/1.jpg");
	}
	
	@BindingAdapter({"imageUrl", "error"})//自定义 namespaces 将被忽略
	public static void loadBqtImage(ImageView view, String url, Drawable error) {//方法名随意，但参数必须和注解中指定的属性一一对应
		Toast.makeText(view.getContext(), "loadBqtImage被调用了", Toast.LENGTH_SHORT).show();
		Picasso.with(view.getContext()).load(url).error(error).into(view);
	}
	
	@BindingAdapter({"android:paddingTop"})
	public static void setPaddingTopAndBottom(View view, int paddingTB) {
		//当设置paddingTop时，同时设置paddingTop和paddingBottom
		view.setPadding(view.getPaddingLeft(), paddingTB, view.getPaddingRight(), paddingTB);
	}
}

