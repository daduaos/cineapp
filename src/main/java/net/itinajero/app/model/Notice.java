package net.itinajero.app.model;

import java.util.Date;

public class Notice {

	private int id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;
	
	public Notice() {
		this.fecha = new Date();
		this.estatus = "activa";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notice [id=");
		builder.append(id);
		builder.append("][titulo=");
		builder.append(titulo);
		builder.append("][fecha=");
		builder.append(fecha);
		builder.append("][detalle=");
		builder.append(detalle);
		builder.append("][estatus=");
		builder.append(estatus);
		builder.append("]");
		return builder.toString();
	}
	
	
}
