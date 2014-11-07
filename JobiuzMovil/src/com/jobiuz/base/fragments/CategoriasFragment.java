package com.jobiuz.base.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.adapters.CategoriaAdapter;
import com.jobiuz.base.adapters.IToggleItemListListener;
import com.jobiuz.entidades.Categoria;

public class CategoriasFragment extends BaseFragment<IToggleItemListListener>
		implements IToggleItemListListener {

	private ListView lstCategorias;
	private CategoriaAdapter adapter;
	private List<Categoria> categorias;

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		categorias = new ArrayList<Categoria>();
		for (int i = 0; i < 100; i++) {
			categorias.add(new Categoria("Tag " + i));
		}
		adapter = new CategoriaAdapter(getActivity(), categorias);
		adapter.setListener(this);
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		lstCategorias = (ListView) v.findViewById(R.id.lst_categoria);
		lstCategorias.setAdapter(adapter);
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_categoria;
	}

	@Override
	public void onTogglePressed(CompoundButton buttonView, boolean isChecked,
			Object tag) {
		if (listener != null) {
			listener.onTogglePressed(buttonView, isChecked, tag);
		}
	}

	public void actualizarLista(String criterio) {

	}

}
