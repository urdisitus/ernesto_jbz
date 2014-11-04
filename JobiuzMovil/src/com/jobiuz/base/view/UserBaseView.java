package com.jobiuz.base.view;

import com.jobiuz.R;
import com.jobiuz.base.interfaces.UserBase;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class UserBaseView extends LinearLayout implements OnClickListener {

	// public UserBaseView(Context context, AttributeSet attrs, int defStyle) {
	// super(context, attrs, defStyle);
	// }

	public UserBaseView(Context context) {
		super(context);
	}

	public UserBaseView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private TextView lblNombre, lblDescripcion;
	private UserBase userBase;

	{
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.item_principal_list, this);
		// btnLeft = (ImageView) findViewById(R.id.img_banca_movil_atencion);
		// btnRigth = (ImageView)
		// findViewById(R.id.btn_ir_banca_movil_activity);
		// btnRigth.setOnClickListener(this);
		lblDescripcion = (TextView) findViewById(R.id.lbl_desc_item);
		lblNombre = (TextView) findViewById(R.id.lbl_nombre_item);
		// if (getContext() instanceof itemBancaMovilListener) {
		// listener = (itemBancaMovilListener) getContext();
		// }
	}

	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
		lblDescripcion.setText(userBase.getDescripcion());
		lblNombre.setText(userBase.getNombre());
	}

	@Override
	public void onClick(View v) {
		// switch (v.getId()) {
		// case R.id.btn:
		//
		// break;
		//
		// default:
		// break;
		// }
	}

}
