package com.jobiuz.user;

import com.jobiuz.R;
import com.jobiuz.base.BaseActivity;
import android.os.Bundle;

public class LoginUserActivity extends BaseActivity {

	@Override
	protected int getResLayout() {
		return R.layout.activity_login_user;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {
	}

	@Override
	protected String getScreenLabel() {
		return "Registro login";
	}
}
