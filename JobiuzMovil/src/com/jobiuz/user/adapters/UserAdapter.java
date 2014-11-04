package com.jobiuz.user.adapters;

import java.util.List;

import android.content.Context;

import com.jobiuz.user.impl.User;

public class UserAdapter extends UserBaseAdapter<User> {

	public UserAdapter(Context context, List<User> objects) {
		super(context, objects);
	}

}
