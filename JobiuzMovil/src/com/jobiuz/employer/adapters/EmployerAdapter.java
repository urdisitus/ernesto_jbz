package com.jobiuz.employer.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jobiuz.base.adapters.UserBaseAdapter;
import com.jobiuz.employer.impl.Employer;

public class EmployerAdapter extends UserBaseAdapter<Employer> {

	public EmployerAdapter(Context context, List<Employer> objects) {
		super(context, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = super.getView(position, convertView, parent);
		ViewHolder vh = (ViewHolder) v.getTag();
		vh.btnNews.setVisibility(View.INVISIBLE);
		return v;
	}
}
