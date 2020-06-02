package com.evaluation.demorestapi.model;

public class Busqueda {
	
	private String fechaInicio;
	private String fechaFin;
	
	
	public Busqueda() {
		super();
	}
	public Busqueda(String fechaInicio, String fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

}
