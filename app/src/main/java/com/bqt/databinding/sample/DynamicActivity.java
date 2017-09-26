package com.bqt.databinding.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bqt.databinding.BR;
import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityDynamicBinding;
import com.bqt.databinding.databinding.UserItemBinding;
import com.bqt.databinding.model.User;

import java.util.Arrays;
import java.util.List;

public class DynamicActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActivityDynamicBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dynamic);
		
		binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
		binding.recyclerView.setAdapter(new UserAdapter2(Arrays.asList(new User("包", "青天"), new User("b", "qt"), new User("白", "乾涛"))));
	}
	
	//********************************************第一种方式**********************************************
	static class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
		
		private List<User> mUsers;
		
		public UserAdapter(List<User> mUsers) {
			this.mUsers = mUsers;
		}
		
		static class UserHolder extends RecyclerView.ViewHolder {
			private UserItemBinding mBinding;
			
			public UserHolder(View itemView) {
				super(itemView);
				mBinding = DataBindingUtil.bind(itemView);
			}
			
			public void bind(User user) {
				mBinding.setUser(user);
			}
		}
		
		@Override
		public int getItemCount() {
			return mUsers.size();
		}
		
		@Override
		public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
			View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, viewGroup, false);
			return new UserHolder(itemView);
		}
		
		@Override
		public void onBindViewHolder(UserHolder holder, int position) {
			holder.bind(mUsers.get(position));//只需要为每一个item绑定数据，而不需要手动操作item中的UI
		}
		
	}
	//********************************************第二种方式**********************************************
	
	static class UserAdapter2 extends RecyclerView.Adapter<UserAdapter2.UserHolder> {
		
		private List<User> mUsers;
		
		public UserAdapter2(List<User> mUsers) {
			this.mUsers = mUsers;
		}
		
		static class UserHolder extends RecyclerView.ViewHolder {
			private ViewDataBinding binding;
			
			public UserHolder(View itemView) {
				super(itemView);
			}
			
			public ViewDataBinding getBinding() {
				return binding;
			}
			
			public void setBinding(ViewDataBinding binding) {
				this.binding = binding;
			}
		}
		
		@Override
		public int getItemCount() {
			return mUsers.size();
		}
		
		@Override
		public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
			ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
					R.layout.user_item, viewGroup, false);//在 onCreateViewHolder 的时候创建这个 DataBinding
			UserHolder holder = new UserHolder(binding.getRoot());
			holder.setBinding(binding);
			return holder;
		}
		
		@Override
		public void onBindViewHolder(UserHolder holder, int position) {
			ViewDataBinding binding = holder.getBinding();//在 onBindViewHolder 中获取这个 DataBinding
			binding.setVariable(BR.user, mUsers.get(position));
			binding.executePendingBindings();
		}
	}
}

