package com.jobiuz.user.fragments;

import java.util.ArrayList;
import java.util.List;

import com.jobiuz.base.fragments.FavoritosInboxBaseFragment;
import com.jobiuz.employer.impl.Employer;

public class FavoritosInboxUserFragment extends
		FavoritosInboxBaseFragment<Employer> {

	@Override
	protected List<Employer> obtenerElementos() {
		List<Employer> emps = new ArrayList<Employer>();
		emps.add(new Employer(
				"Ernesto",
				"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00",
				-17.789639, -63.182915));
		emps.add(new Employer(
				"Ernesto",
				"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00",
				-17.789946, -63.181529));
		emps.add(new Employer(
				"Ernesto",
				"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00",
				-17.791059, -63.183352));
		emps.add(new Employer(
				"Ernesto",
				"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00",
				-17.788896, -63.181606));
		emps.add(new Employer(
				"Ernesto",
				"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00",
				-17.790301, -63.180115));
		emps.add(new Employer(
				"Gonzalo",
				"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00",
				-17.790694, -63.182679));
		return emps;
	}

}
