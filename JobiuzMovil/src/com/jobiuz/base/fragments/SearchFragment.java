package com.jobiuz.base.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.listeners.IBaseActivity;

public class SearchFragment extends BaseFragment<IBaseActivity> implements
		OnClickListener {

	private EditText txtSearch;
	private CategoriasFragment categoriasFragment;

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		categoriasFragment = new CategoriasFragment();
		if (savedInstanceState == null) {
			getChildFragmentManager()
					.beginTransaction()
					.replace(R.id.contenido_search, categoriasFragment,
							"categoriasFragment").commit();
		}
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		v.findViewById(R.id.btn_filtro_search).setOnClickListener(this);
		txtSearch = (EditText) v.findViewById(R.id.txt_search);
		txtSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				categoriasFragment.actualizarLista(s.toString());
			}
		});
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_search;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_filtro_search:

			break;

		default:
			break;
		}
	}

}
