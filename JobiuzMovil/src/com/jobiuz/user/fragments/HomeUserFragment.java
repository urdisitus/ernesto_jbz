package com.jobiuz.user.fragments;

import com.jobiuz.base.adapters.UserBaseAdapter;
import com.jobiuz.base.fragments.HomeBaseFragment;
import com.jobiuz.employer.impl.Employer;
import com.jobiuz.user.impl.User;

public class HomeUserFragment extends HomeBaseFragment<Employer> {

	@Override
	public UserBaseAdapter<Employer> instanciateAdapter() {
		for (int i = 0; i < 10; i++) {
			list.add(new Employer(
					"Cocacola Company" + i,
					"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00"));
		}
		return new UserBaseAdapter<Employer>(getActivity(), list);
	}

}
