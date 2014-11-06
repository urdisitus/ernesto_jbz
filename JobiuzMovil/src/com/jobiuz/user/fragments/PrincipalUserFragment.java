package com.jobiuz.user.fragments;

import com.jobiuz.base.fragments.HomeBaseFragment;
import com.jobiuz.base.fragments.LocationFragment;
import com.jobiuz.base.fragments.PrincipalBaseFragment;
import com.jobiuz.base.fragments.ProfileBaseFragment;
import com.jobiuz.employer.impl.Employer;
import com.jobiuz.user.impl.User;

public class PrincipalUserFragment extends
		PrincipalBaseFragment<User, Employer> {

	@Override
	public HomeBaseFragment<Employer> instanciateHomeFragment() {
		return new HomeUserFragment();
	}

	@Override
	public LocationFragment<User, Employer> instanciateLocationFragment() {
		return new LocationUserFragment();
	}

	@Override
	public ProfileBaseFragment<User> instanciateProfileFragment() {
		return new ProfileUserFragment();
	}

}
