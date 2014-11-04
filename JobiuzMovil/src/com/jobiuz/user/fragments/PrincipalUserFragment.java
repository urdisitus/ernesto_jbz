package com.jobiuz.user.fragments;

import com.jobiuz.base.fragments.HomeBaseFragment;
import com.jobiuz.base.fragments.PrincipalBaseFragment;
import com.jobiuz.base.fragments.ProfileBaseFragment;
import com.jobiuz.user.impl.User;

public class PrincipalUserFragment extends PrincipalBaseFragment<User> {

	@Override
	public HomeBaseFragment<User> instanciateHomeFragment() {
		return new HomeUserFragment();
	}

	@Override
	public LocationFragment instanciateLocationFragment() {
		return new LocationFragment();
	}

	@Override
	public ProfileBaseFragment<User> instanciateProfileFragment() {
		return new ProfileUserFragment();
	}

}
