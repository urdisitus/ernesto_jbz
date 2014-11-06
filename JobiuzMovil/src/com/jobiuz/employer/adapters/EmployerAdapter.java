package com.jobiuz.employer.adapters;

import java.util.List;

import android.content.Context;

import com.jobiuz.base.adapters.UserBaseAdapter;
import com.jobiuz.employer.impl.Employer;

public class EmployerAdapter extends UserBaseAdapter<Employer> {

	public EmployerAdapter(Context context, List<Employer> objects) {
		super(context, objects);
	}

}
