package com.jobiuz.user;

import com.jobiuz.R;
import com.jobiuz.base.BaseActivity;
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
			startActivity(new Intent(this, LoginUserActivity.class));
			break;
		case R.id.btn_registrar:
			startActivity(new Intent(this, MainActivity.class));
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
	}

	@Override
	protected String getScreenLabel() {
		return "Registro Empresa";
	}
}
