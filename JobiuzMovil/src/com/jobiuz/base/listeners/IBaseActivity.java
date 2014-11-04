package com.jobiuz.base.listeners;

import com.jobiuz.base.DialogoConfirmacion;
import com.jobiuz.base.IDialogoConfirmarSoloAceptar;

import android.os.Parcelable;

public interface IBaseActivity {
	DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, String TAG);

	DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, Parcelable object, String okName,
			String cancelName, String TAG);

	DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, String okName, String cancelName,
			String TAG);

	void showConsumoError(IDialogoConfirmarSoloAceptar listener, String TAG);

	void showInternetError(IDialogoConfirmarSoloAceptar listener, String TAG);

	String getString(int res);
}
