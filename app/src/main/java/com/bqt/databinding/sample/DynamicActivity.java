package com.bqt.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bqt.databinding.R;
import com.bqt.databinding.databinding.ActivityDynamicBinding;
import com.bqt.databinding.databinding.UserItemBinding;
import com.bqt.databinding.model.User;
import com.bqt.databinding.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DynamicActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActivityDynamicBinding binding = DataBindingUtil.setContentView(
				this, R.layout.activity_dynamic);
		
		binding.recyclerView.setHasFixedSize(true);
		binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
		binding.recyclerView.setAdapter(new UserAdapter());
	}
	
	static class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
		private static final int USER_COUNT = 10;
		
		@NonNull
		private List<User> mUsers;
		
		public UserAdapter() {
			mUsers = new ArrayList<>(10);
			for (int i = 0; i < USER_COUNT; i++) {
				User user = new User(Randoms.nextFirstName(), Randoms.nextLastName());
				mUsers.add(user);
			}
		}
		
		static class UserHolder extends RecyclerView.ViewHolder {
			private UserItemBinding mBinding;
			
			public UserHolder(View itemView) {
				super(itemView);
				mBinding = DataBindingUtil.bind(itemView);
			}
			
			public void bind(@NonNull User user) {
				mBinding.setUser(user);
			}
		}
		
		@Override
		public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
			View itemView = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.user_item, viewGroup, false);
			return new UserHolder(itemView);
		}
		
		@Override
		public void onBindViewHolder(UserHolder holder, int position) {
			holder.bind(mUsers.get(position));
		}
		
		@Override
		public int getItemCount() {
			return mUsers.size();
		}
	}
}