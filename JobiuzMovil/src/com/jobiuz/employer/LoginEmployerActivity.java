package com.jobiuz.employer;

import com.jobiuz.R;
import com.jobiuz.base.BaseActivity;
import com.jobiuz.user.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LoginEmployerActivity extends BaseActivity implements
		OnClickListener {

	@Override
	protected int getResLayout() {
		return R.layout.activity_login_employer;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {
		findViewById(R.id.tlt_sing_on_here).setOnClickListener(this);
		findViewById(R.id.btn_login).setOnClickListener(this);
	}

	@Override
	protected String getScreenLabel() {
		return "Registro login";
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tlt_sing_on_here:
			Intent intentSO = new Intent(this, RegistroEmployerActivity.class);
			intentSO.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentSO);
			break;
		case R.id.btn_login:
//			Intent intentM = new Intent(this, MainActivity.class);
//			intentM.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			startActivity(intentM);
			break;
		default:
			break;
		}

	}
}
