package com.jobiuz.user.fragments;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jobiuz.base.fragments.InboxBaseFragment;
import com.jobiuz.employer.impl.Employer;
import com.jobiuz.entidades.Message;

public class InboxUserFragment extends InboxBaseFragment<Employer> {

	@Override
	protected List<Message<Employer>> prepararLista() {
		List<Message<Employer>> ls = new ArrayList<Message<Employer>>();
		for (int i = 0; i < 10; i++) {
			ls.add(new Message<Employer>(
					new Employer(
							"Cocacola Company " + i,
							"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00"),
					Calendar.getInstance().getTime(),
					"Se necesita empleado para realizar labores de trabajo.\nBs. 800.- /Lun a Vie 8:00 - 18:00",
					(i % 2) == 0));
		}
		return ls;
	}

}
