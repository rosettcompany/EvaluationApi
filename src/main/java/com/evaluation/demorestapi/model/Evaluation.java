package com.evaluation.demorestapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Evaluation {

	@Id
	private String id;
	private String correo;
	private String nombres;
	private String fecha;
	private Integer calificacion;
	
	public Evaluation() {
	}
	
	
	public Evaluation(String id, String correo, String nombres, String fecha, Integer calificacion) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombres = nombres;
		this.fecha = fecha;
		this.calificacion = calificacion;
	}
	
	public Evaluation(String id) {
		super();
		this.id = id;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	};

}
