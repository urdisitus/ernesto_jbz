package com.jobiuz.base.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IBaseActivity;
import com.jobiuz.user.adapters.UserBaseAdapter;

public abstract class HomeBaseFragment<T extends UserBase> extends
		BaseFragment<IBaseActivity> implements OnItemClickListener {

	protected List<T> list = new ArrayList<T>();
	protected UserBaseAdapter<T> adapter;
	protected ListView lstHome;

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		adapter = instanciateAdapter();
	}

	public abstract UserBaseAdapter<T> instanciateAdapter();

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		lstHome = (ListView) v.findViewById(R.id.lst_home);
		lstHome.setAdapter(adapter);
		lstHome.setOnItemClickListener(this);
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_home;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}
}
