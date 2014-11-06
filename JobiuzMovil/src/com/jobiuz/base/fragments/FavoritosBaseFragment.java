package com.jobiuz.base.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.LetraUtils;
import com.jobiuz.base.adapters.FavoritesBaseAdapter;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IBaseActivity;
import com.jobiuz.base.listeners.IButtonClickItemList;

public abstract class FavoritosBaseFragment<T extends UserBase> extends
		BaseFragment<IBaseActivity> implements IButtonClickItemList {

	protected ListView lstfavorites;
	protected FavoritesBaseAdapter<T> favoritosAdapter;
	protected TextView lblName, lblNickEmail;
	private ImageView imgLogo;

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		favoritosAdapter = new FavoritesBaseAdapter<T>(getActivity(),
				obtenerElementos());
		favoritosAdapter.setListerner(this);
	}

	protected abstract List<T> obtenerElementos();

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		lblName = (TextView) v.findViewById(R.id.lbl_nombre_favorite);
		lblNickEmail = (TextView) v
				.findViewById(R.id.lbl_nickname_email_perfil_favorites);
		LetraUtils.setRegularHelveticaNeue(
				(TextView) v.findViewById(R.id.tlt_favorites), lblNickEmail);
		LetraUtils.setBoldHelveticaNeue((TextView) v
				.findViewById(R.id.tlt_favorites));
		lstfavorites = (ListView) v.findViewById(R.id.lst_favoritos);
		lstfavorites.setAdapter(favoritosAdapter);
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_perfil_favoritos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void OnInfoButtonClick(View v, Object tag) {
		switch (v.getId()) {
		case R.id.btn_eliminar_favorite:
			favoritosAdapter.remove((T) tag);
			break;

		default:
			break;
		}
	}

}
