package com.jobiuz.base.fragments;

import java.util.HashMap;
import java.util.List;

import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jobiuz.R;
import com.jobiuz.base.BaseFragment;
import com.jobiuz.base.fragments.TSMMapFragment.OnMapReadyListener;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IBaseActivity;

public abstract class LocationFragment<T extends UserBase, L extends UserBase>
		extends BaseFragment<IBaseActivity> implements OnMapReadyListener,
		OnMyLocationChangeListener, OnMyLocationButtonClickListener,
		OnMarkerClickListener, OnInfoWindowClickListener {

	private T actualBase;
	private GoogleMap googleMap;
	private Marker marker;
	private HashMap<Marker, L> marcadorPunto = new HashMap<Marker, L>();

	protected abstract int getLResDrawable();

	protected abstract int getTResDrawable();

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			getChildFragmentManager().beginTransaction()
					.add(R.id.contenido_location, TSMMapFragment.newInstance())
					.commit();
		}
	}

	private Marker agregarMarcador(LatLng location, int icoRes) {
		if (location != null) {
			MarkerOptions markerOptions = new MarkerOptions()
					.position(location).icon(
							BitmapDescriptorFactory.fromResource(icoRes));
			return googleMap.addMarker(markerOptions);
		}
		return null;
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {

	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_localizacion;
	}

	@Override
	public boolean onMyLocationButtonClick() {
		if (googleMap != null) {
			if (googleMap.getMyLocation() != null) {
				repintarPuntos(
						obtenerPuntosCercanos(googleMap.getMyLocation(), true),
						googleMap.getMyLocation());
			}
		}
		return true;

	}

	@Override
	public void onMyLocationChange(Location arg0) {
//		if (googleMap != null) {
//			if (googleMap.getMyLocation() != null) {
//				repintarPuntos(
//						obtenerPuntosCercanos(googleMap.getMyLocation(), true),
//						googleMap.getMyLocation());
//			}
//		}
//		return true;
	}

	public void repintarPuntos(List<L> puntosCercanos, Location location) {
		if (googleMap != null) {
			googleMap.clear();
			marcadorPunto.clear();
			marker = agregarMarcador(new LatLng(location.getLatitude(),
					location.getLongitude()), getTResDrawable());
			for (L l : puntosCercanos) {
				Marker m = agregarMarcador(
						new LatLng(l.getLatitud(), l.getLongitud()),
						getLResDrawable());
				marcadorPunto.put(m, l);
			}
			googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
					location.getLatitude(), location.getLongitude()), 15));
		}
	}

	public abstract List<L> obtenerPuntosCercanos(Location location,
			boolean recalcular);

	@Override
	public void onMapReady(GoogleMap googleMap) {
		if (googleMap != null) {
			this.googleMap = googleMap;
			googleMap.setMyLocationEnabled(true);
			googleMap.getUiSettings().setMyLocationButtonEnabled(true);
			googleMap.setMyLocationEnabled(true);
			googleMap.getUiSettings().setAllGesturesEnabled(true);
			googleMap.clear();
			googleMap.setOnMyLocationButtonClickListener(this);
			googleMap.setOnMyLocationChangeListener(this);
		}
	}

	@Override
	public void onTimeExpiredMapNotInstanceYet() {

	}

	@Override
	public void onInfoWindowClick(Marker arg0) {
		L l = marcadorPunto.get(arg0);
	}

	@Override
	public boolean onMarkerClick(Marker arg0) {
		L l = marcadorPunto.get(arg0);
		return false;
	}

}
