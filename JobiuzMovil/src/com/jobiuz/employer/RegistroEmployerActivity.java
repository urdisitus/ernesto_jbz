package com.jobiuz.employer;

import com.jobiuz.R;
import com.jobiuz.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class RegistroEmployerActivity extends BaseActivity implements
		OnClickListener {

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tlt_login_here:
			Intent intentL = new Intent(this, LoginEmployerActivity.class);
			intentL.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentL);
			break;
		case R.id.btn_registrar:
//			Intent intentM = new Intent(this, MainActivity.class);
//			intentM.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			startActivity(intentM);
			break;
		default:
			break;
		}
	}

	@Override
	protected int getResLayout() {
		return R.layout.activity_registro_employer;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {

	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {
		findViewById(R.id.tlt_login_here).setOnClickListener(this);
		findViewById(R.id.btn_registrar).setOnClickListener(this);
	}

	@Override
	protected String getScreenLabel() {
		return "Registro Empresa";
	}
}
