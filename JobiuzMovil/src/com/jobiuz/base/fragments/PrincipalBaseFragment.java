package com.jobiuz.base.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TabHost;

import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.TabsAdapter;
import com.jobiuz.base.TabsAdapter.TabsListener;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IBaseActivity;
import com.jobiuz.base.view.TabView;

public abstract class PrincipalBaseFragment<T extends UserBase, L extends UserBase>
		extends BaseFragment<IBaseActivity> implements TabsListener {
	private TabHost mTabHost;
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;

	private TabView getTabView(int drawable, int drawableSelected) {
		TabView v = new TabView(getActivity(), drawableSelected, drawable);
		return v;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("tab", mTabHost.getCurrentTabTag());
	}

	public abstract HomeBaseFragment<L> instanciateHomeFragment();

	public abstract LocationFragment<T, L> instanciateLocationFragment();

	public abstract ProfileBaseFragment<T> instanciateProfileFragment();

	@Override
	public Fragment getFragment(int position, String tag) {
		switch (position) {
		case 0:
			return instanciateHomeFragment();
		case 2:
			return instanciateLocationFragment();
		case 3:
			return instanciateProfileFragment();
		default:
			break;
		}
		return instanciateHomeFragment();
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {

	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		mTabHost = (TabHost) v.findViewById(android.R.id.tabhost);
		mTabHost.setup();

		mViewPager = (ViewPager) v.findViewById(R.id.pager);
		mTabsAdapter = new TabsAdapter(getActivity(), mTabHost, mViewPager,
				this);

		mTabsAdapter.addTab(mTabHost.newTabSpec("one").setIndicator(
				getTabView(R.drawable.ichouseoff, R.drawable.ichouseon)));

		mTabsAdapter.addTab(mTabHost.newTabSpec("two").setIndicator(
				getTabView(R.drawable.searchoff, R.drawable.searchon)));

		mTabsAdapter.addTab(mTabHost.newTabSpec("tree").setIndicator(
				getTabView(R.drawable.locationoff, R.drawable.locationon)));

		mTabsAdapter.addTab(mTabHost.newTabSpec("four").setIndicator(
				getTabView(R.drawable.mailoff, R.drawable.maionl)));

		mTabsAdapter.addTab(mTabHost.newTabSpec("five").setIndicator(
				getTabView(R.drawable.useroff, R.drawable.useron)));

		if (savedInstanceState != null) {
			mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}

	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_principal;
	}
}
