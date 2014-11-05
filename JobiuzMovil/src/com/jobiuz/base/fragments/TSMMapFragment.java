package com.jobiuz.base.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class TSMMapFragment extends SupportMapFragment {

	private OnMapReadyListener listener;

	public TSMMapFragment() {
		super();
	}

	public static TSMMapFragment newInstance() {
		TSMMapFragment fragment = new TSMMapFragment();
		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (listener == null && activity instanceof OnMapReadyListener) {
			listener = (OnMapReadyListener) activity;
		}
	}

	@Override
	public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
		View v = super.onCreateView(arg0, arg1, arg2);
		Fragment fragment = getParentFragment();
		if (fragment != null && listener == null
				&& fragment instanceof OnMapReadyListener) {
			listener = (OnMapReadyListener) fragment;
		}
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		OnMapReadyTask mapReadyTask = new OnMapReadyTask();
		mapReadyTask.execute(20000L, 100L);
	}

	private class OnMapReadyTask extends AsyncTask<Long, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Long... params) {
			long init = SystemClock.currentThreadTimeMillis();
			long duracionInMillis = params[0];
			long sleep = params[1];
			long dif = 0;
			do {
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dif = SystemClock.currentThreadTimeMillis() - init;
			} while (getMap() == null && dif < duracionInMillis);
			if (getMap() == null) {
				return Boolean.FALSE;
			} else {
				return Boolean.TRUE;
			}
		}

		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			if (listener != null) {
				if (result == Boolean.TRUE) {
					listener.onMapReady(getMap());
				} else {
					listener.onTimeExpiredMapNotInstanceYet();
				}
			}
		}
	}

	public static interface OnMapReadyListener {
		void onMapReady(GoogleMap googleMap);

		void onTimeExpiredMapNotInstanceYet();
	}

}
