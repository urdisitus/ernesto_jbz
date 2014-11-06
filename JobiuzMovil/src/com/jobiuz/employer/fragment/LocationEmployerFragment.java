package com.jobiuz.employer.fragment;

import java.util.ArrayList;
import java.util.List;

import android.location.Location;

import com.jobiuz.R;
import com.jobiuz.base.fragments.LocationFragment;
import com.jobiuz.employer.impl.Employer;
import com.jobiuz.user.impl.User;

public class LocationEmployerFragment extends LocationFragment<Employer, User> {

	@Override
	protected int getLResDrawable() {
		return R.drawable.locador_user;
	}

	@Override
	protected int getTResDrawable() {
		return R.drawable.locador_employe;
	}

	@Override
	public List<User> obtenerPuntosCercanos(Location location,
			boolean recalcular) {
		List<User> emps = new ArrayList<User>();
		emps.add(new User("Ernesto", "Quiero empleo de desarrollador",
				-17.789639, -63.182915));
		emps.add(new User("Ernesto", "Quiero empleo de desarrollador",
				-17.789946, -63.181529));
		emps.add(new User("Ernesto", "Quiero empleo de desarrollador",
				-17.791059, -63.183352));
		emps.add(new User("Ernesto", "Quiero empleo de desarrollador",
				-17.788896, -63.181606));
		emps.add(new User("Ernesto", "Quiero empleo de desarrollador",
				-17.790301, -63.180115));
		emps.add(new User("Gonzalo", "Quiero empleo de desarrollador",
				-17.790694, -63.182679));
		return emps;
	}
}
