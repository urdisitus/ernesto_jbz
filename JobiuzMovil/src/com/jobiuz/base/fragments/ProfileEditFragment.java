package com.jobiuz.base.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.LetraUtils;
import com.jobiuz.base.listeners.IBaseActivity;

public class ProfileEditFragment extends BaseFragment<IBaseActivity> implements
		OnClickListener {

	private ImageView imgPerfil;
	private TextView lblNombre, lblNickNameEmail, tltSex, tltAge, tltPhone,
			tltAttachment, tltFilters, tltCategories, lblPhone, lblAge, lblSex;

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {

	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		v.findViewById(R.id.btn_age_perfil_edit).setOnClickListener(this);
		v.findViewById(R.id.btn_sex_perfil_edit).setOnClickListener(this);
		v.findViewById(R.id.btn_attachment_perfil_edit)
				.setOnClickListener(this);
		v.findViewById(R.id.btn_categorias_perfil_edit)
				.setOnClickListener(this);
		v.findViewById(R.id.btn_phone_perfil_edit).setOnClickListener(this);
		v.findViewById(R.id.btn_filters_perfil_edit).setOnClickListener(this);
		imgPerfil = (ImageView) v.findViewById(R.id.img_foto_perfil_edit);
		lblNombre = (TextView) v.findViewById(R.id.lbl_nombre_perfil_edit);
		lblNickNameEmail = (TextView) v
				.findViewById(R.id.lbl_nickname_email_perfil_edit);
		tltSex = (TextView) v.findViewById(R.id.tlt_sex_perfil_edit);
		tltAge = (TextView) v.findViewById(R.id.tlt_age_perfil_edit);
		tltPhone = (TextView) v.findViewById(R.id.tlt_phone__perfil_edit);
		tltAttachment = (TextView) v
				.findViewById(R.id.tlt_attachments_perfil_edit);
		tltFilters = (TextView) v.findViewById(R.id.tlt_filters_perfil_edit);
		tltCategories = (TextView) v
				.findViewById(R.id.tlt_categories_perfil_edit);
		lblPhone = (TextView) v.findViewById(R.id.lbl_phone__perfil_edit);
		lblAge = (TextView) v.findViewById(R.id.lbl_age_perfil_edit);
		lblSex = (TextView) v.findViewById(R.id.lbl_sex_perfil_edit);
		LetraUtils.setBoldHelveticaNeue(lblNombre);
		LetraUtils.setRegularHelveticaNeue(lblAge, lblNickNameEmail, lblPhone,
				lblSex, tltAge, tltAttachment, tltCategories, tltFilters,
				tltPhone, tltPhone, tltSex);
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_perfil_edit;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_age_perfil_edit:

			break;
		case R.id.btn_sex_perfil_edit:

			break;
		case R.id.btn_attachment_perfil_edit:

			break;
		case R.id.btn_categorias_perfil_edit:

			break;
		case R.id.btn_phone_perfil_edit:

			break;
		case R.id.btn_filters_perfil_edit:

			break;

		default:
			break;
		}
	}

}
