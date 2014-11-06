package com.jobiuz.employer.fragment;

import com.jobiuz.base.fragments.HomeBaseFragment;
import com.jobiuz.base.fragments.LocationFragment;
import com.jobiuz.base.fragments.PrincipalBaseFragment;
import com.jobiuz.base.fragments.ProfileBaseFragment;
import com.jobiuz.employer.impl.Employer;
import com.jobiuz.user.impl.User;

public class PrincipalEmployerFragment extends
		PrincipalBaseFragment<Employer, User> {

	@Override
	public HomeBaseFragment<User> instanciateHomeFragment() {
		return new HomeEmployerFragment();
	}

	@Override
	public LocationFragment<Employer, User> instanciateLocationFragment() {
		return new LocationEmployerFragment();
	}	

	@Override
	public ProfileBaseFragment<Employer> instanciateProfileFragment() {
		return new ProfileUserFragment();
	}

}
