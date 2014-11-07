package com.jobiuz.entidades;

import java.util.Date;

import com.jobiuz.base.interfaces.UserBase;

public class Message<T extends UserBase> {
	private T t;
	private Date fecha;
	private String mensaje;
	private boolean leido;

	public Message(T t, Date fecha, String mensaje, boolean leido) {
		super();
		this.t = t;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.leido = leido;
	}

	public T getT() {
		return t;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setT(T t) {
		this.t = t;
	}

	public String getMensaje() {
		return mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
