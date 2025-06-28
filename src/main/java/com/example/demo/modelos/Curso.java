package com.example.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "activo")
	private boolean activo; 
	
	public Long getId() {return id;}
	public String getNombre() {return nombre;}
	public boolean getActivo() {return activo;}
	
	public void setId(Long id) {this.id = id;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setActivo(boolean activo) {this.activo = activo;}
	
}
