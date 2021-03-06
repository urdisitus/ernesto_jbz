package com.jobiuz.user;

import com.jobiuz.R;
import com.jobiuz.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LoginUserActivity extends BaseActivity implements OnClickListener {

	@Override
	protected int getResLayout() {
		return R.layout.activity_login_user;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
	}	

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {
		findViewById(R.id.btn_login).setOnClickListener(this);
	}

	@Override
	protected String getScreenLabel() {
		return "Registro login";
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			Intent intentM = new Intent(this, MainActivity.class);
			intentM.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentM);
			break;

		default:
			break;
		}
	}
}
