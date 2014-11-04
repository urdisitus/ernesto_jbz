package com.jobiuz.base;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements
		OnDateSetListener {

	private OnDateDialogFragmentListener listener;

	public void setListener(OnDateDialogFragmentListener listener) {
		this.listener = listener;
	}

	public static final String DAY = "DatePickerFragment.DAY";
	public static final String MONTH = "DatePickerFragment.MONTH";
	public static final String YEAR = "DatePickerFragment.YEAR";
	public long lastNotify;

	public static DatePickerFragment newInstance(Calendar c) {
		Bundle b = new Bundle();
		b.putInt(DAY, c.get(Calendar.DAY_OF_MONTH));
		b.putInt(MONTH, c.get(Calendar.MONTH));
		b.putInt(YEAR, c.get(Calendar.YEAR));
		return newInstance(b, null);
	}

	public static DatePickerFragment newInstance(Calendar c,
			OnDateDialogFragmentListener listener) {
		Bundle b = new Bundle();
		b.putInt(DAY, c.get(Calendar.DAY_OF_MONTH));
		b.putInt(MONTH, c.get(Calendar.MONTH));
		b.putInt(YEAR, c.get(Calendar.YEAR));
		return newInstance(b, listener);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = super.onCreateView(inflater, container, savedInstanceState);
		Fragment fragment = getParentFragment();
		if (fragment != null && listener == null
				&& fragment instanceof OnDateDialogFragmentListener) {
			listener = (OnDateDialogFragmentListener) fragment;
		}
		return v;

	}

	public static DatePickerFragment newInstance(Bundle arguments,
			OnDateDialogFragmentListener listener) {
		DatePickerFragment fr = new DatePickerFragment();
		fr.setArguments(arguments);
		fr.setListener(listener);
		return fr;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		int year = getArguments().getInt(YEAR);
		int month = getArguments().getInt(MONTH);
		int day = getArguments().getInt(DAY);
		DatePickerDialog dpd = new DatePickerDialog(getActivity(), this, year,
				month, day);
		return dpd;
	}

	public void onDateSet(DatePicker view, int year, int month, int day) {
		Log.d("validarFecha", "DatePickerFragment.onDateSet");
		if (listener != null
				&& (lastNotify == 0 || lastNotify + 1000 <= SystemClock
						.currentThreadTimeMillis())) {
			lastNotify = SystemClock.currentThreadTimeMillis();
			listener.onDateSet(year, month, day);
		}
	}
}
