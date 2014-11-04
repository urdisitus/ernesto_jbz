package com.jobiuz.user.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jobiuz.R;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.view.UserBaseView;

public class UserBaseAdapter<T extends UserBase> extends ArrayAdapter<T> {

	public UserBaseAdapter(Context context, List<T> objects) {
		super(context, R.layout.item_principal_list, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		UserBaseView userBaseView = null;
		if (convertView == null) {
			userBaseView = new UserBaseView(getContext());
		} else {
			userBaseView = (UserBaseView) convertView;
		}
		T item = getItem(position);
		userBaseView.setUserBase(item);
		return userBaseView;
	}

}
