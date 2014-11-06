package com.jobiuz.base.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jobiuz.R;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IButtonClickItemList;
import com.jobiuz.base.view.UserBaseView;

public class UserBaseAdapter<T extends UserBase> extends ArrayAdapter<T>
		implements OnClickListener {

	private IButtonClickItemList listerner;

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

	@Override
	public void onClick(View v) {
		if (listerner != null) {
			listerner.OnInfoButtonClick(v, v.getTag());
		}
	}

}
