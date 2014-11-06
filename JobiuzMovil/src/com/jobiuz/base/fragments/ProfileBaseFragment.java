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
import com.jobiuz.user.fragments.FavoritosUserFragment;
import com.jobiuz.user.fragments.LocationUserFragment;

public class ProfileBaseFragment<T extends UserBase> extends
		BaseFragment<IBaseActivity> implements TabsListener {

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

	@Override
	public Fragment getFragment(int position, String tag) {
		switch (position) {
		case 0:
			return new FavoritosUserFragment();
		case 2:
			return new ProfileEditFragment();

		default:
			break;
		}
		return new LocationUserFragment();
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {

	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		mTabHost = (TabHost) v.findViewById(android.R.id.tabhost);
		mTabHost.setup();

		mViewPager = (ViewPager) v.findViewById(R.id.pager_profile);
		mTabsAdapter = new TabsAdapter(getActivity(), mTabHost, mViewPager,
				this);

		mTabsAdapter.addTab(mTabHost.newTabSpec("one").setIndicator(
				getTabView(R.drawable.paperclipon, R.drawable.paperclipoff)));

		mTabsAdapter.addTab(mTabHost.newTabSpec("two").setIndicator(
				getTabView(R.drawable.ic_newspaperoff,
						R.drawable.ic_newspaperon)));

		mTabsAdapter.addTab(mTabHost.newTabSpec("tree").setIndicator(
				getTabView(R.drawable.penciloff, R.drawable.pencilon)));

		if (savedInstanceState != null) {
			mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_profile;
	}

}
