package com.jobiuz.user.impl;

import com.jobiuz.base.interfaces.UserBase;

public class User implements UserBase {
	private String nombre;
	private String descripcion;
	private double latitud;
	private double longitud;

	public User(String nombre, String descripcion, double latitud,
			double longitud) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public User(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

}
