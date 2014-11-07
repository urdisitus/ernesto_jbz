package com.jobiuz.employer.fragment;

import com.jobiuz.base.adapters.UserBaseAdapter;
import com.jobiuz.base.fragments.HomeBaseFragment;
import com.jobiuz.user.adapters.UserAdapter;
import com.jobiuz.user.impl.User;

public class HomeEmployerFragment extends HomeBaseFragment<User> {

	@Override
	public UserBaseAdapter<User> instanciateAdapter() {
		for (int i = 0; i < 100; i++) {
			list.add(new User(
					"Ernesto Perez Moron " + i,
					"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00"));
		}
		return new UserAdapter(getActivity(), list);
	}

}
