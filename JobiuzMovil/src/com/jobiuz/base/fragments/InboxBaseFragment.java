package com.jobiuz.base.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.adapters.InboxBaseAdapter;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IBaseActivity;
import com.jobiuz.base.listeners.IButtonClickItemList;
import com.jobiuz.entidades.Message;

public abstract class InboxBaseFragment<T extends UserBase> extends
		BaseFragment<IBaseActivity> implements IButtonClickItemList {

	protected ListView lstInbox;
	protected InboxBaseAdapter<T> adapter;

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		adapter = new InboxBaseAdapter<T>(getActivity(), prepararLista());
		adapter.setListener(this);
	}

	protected abstract List<Message<T>> prepararLista();

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		lstInbox = (ListView) v.findViewById(R.id.lst_inbox);
		lstInbox.setAdapter(adapter);
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_message_inbox;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void OnInfoButtonClick(View v, Object tag) {
		adapter.remove((Message<T>) tag);
	}

}
