package com.jobiuz.user;

import com.jobiuz.R;
import com.jobiuz.base.BaseActivity;
import com.jobiuz.employer.RegistroEmployerActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class RegistroUserActivity extends BaseActivity implements
		OnClickListener {

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tlt_login_here:
			Intent intentL = new Intent(this, LoginUserActivity.class);
			intentL.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentL);
			break;
		case R.id.btn_registrar:
			Intent intentM = new Intent(this, MainActivity.class);
			intentM.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentM);
			break;

		case R.id.btn_im_employer:
			Intent intentRE = new Intent(this, RegistroEmployerActivity.class);
			intentRE.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentRE);
			break;
		default:
			break;
		}
	}

	@Override
	protected int getResLayout() {
		return R.layout.activity_registro_user;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {

	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {
		findViewById(R.id.tlt_login_here).setOnClickListener(this);
		findViewById(R.id.btn_registrar).setOnClickListener(this);
		findViewById(R.id.btn_im_employer).setOnClickListener(this);
	}

	@Override
	protected String getScreenLabel() {
		return "Registro Empresa";
	}
}
