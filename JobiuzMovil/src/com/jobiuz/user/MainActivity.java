package com.jobiuz.user;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.jobiuz.R;
import com.jobiuz.base.BaseActivity;
import com.jobiuz.base.adapters.IToggleItemListListener;
import com.jobiuz.user.fragments.PrincipalUserFragment;

public class MainActivity extends BaseActivity implements IToggleItemListListener{

	@Override
	protected int getResLayout() {
		return R.layout.activity_main;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.contenido_principal, new PrincipalUserFragment())
					.commit();
		}
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {

	}

	@Override
	protected String getScreenLabel() {
		return "Principal";
	}

	@Override
	public void onTogglePressed(CompoundButton buttonView, boolean isChecked,
			Object tag) {
		
	}
}
