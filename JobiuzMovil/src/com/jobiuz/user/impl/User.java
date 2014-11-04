package com.jobiuz.user.impl;

import com.jobiuz.base.interfaces.UserBase;

public class User implements UserBase{
	private String nombre;
	private String descripcion;

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

}
