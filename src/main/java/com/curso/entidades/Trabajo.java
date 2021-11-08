package com.curso.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Trabajo {

	@Id
	@Column(name = "JOB_ID")
	private String idTrabajo;
	
	@Column(name = "JOB_TITLE")
	private String titulo;
	
	@Column(name = "MIN_SALARY")
	private double salarioMin;
	
	@Column(name = "MAX_SALARY")
	private double salarioMax;
	
	public Trabajo() {
	}

	public Trabajo(String idTrabajo, String titulo, double salarioMin, double salarioMax) {
		super();
		this.idTrabajo = idTrabajo;
		this.titulo = titulo;
		this.salarioMin = salarioMin;
		this.salarioMax = salarioMax;
	}

	public String getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(String idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getSalarioMin() {
		return salarioMin;
	}

	public void setSalarioMin(double salarioMin) {
		this.salarioMin = salarioMin;
	}

	public double getSalarioMax() {
		return salarioMax;
	}

	public void setSalarioMax(double salarioMax) {
		this.salarioMax = salarioMax;
	}
	
	
	
}
