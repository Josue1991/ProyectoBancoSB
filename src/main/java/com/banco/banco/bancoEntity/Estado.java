package com.banco.banco.bancoEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "Estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESTADO")
	private long id_estado;
	@Column(name = "DESCRIPCION_ESTADO")
	private String descripcion_estado;
	public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_estado() {
		return id_estado;
	}
	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescripcion_estado() {
		return descripcion_estado;
	}

	public void setDescripcion_estado(String descripcion_estado) {
		this.descripcion_estado = descripcion_estado;
	}

	@Override
	public String toString() {
		return "Estado [id_estado=" + id_estado + ", descripcion_estado=" + descripcion_estado + "]";
	}		
}
