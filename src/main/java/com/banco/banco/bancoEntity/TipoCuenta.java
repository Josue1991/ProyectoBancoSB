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

@Table(name = "Movimiento")
public class TipoCuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPOCUENTA")
	private long id_tipoCuenta;
	@Column(name = "DESCRIPCION_TIPOCUENTA")
	private String descripcion_tipoCuenta;
	@Column(name = "ESTADO_TIPOCUENTA")
	private int estado_tipoCuenta;
	public TipoCuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_tipoCuenta() {
		return id_tipoCuenta;
	}
	public void setId_tipoCuenta(long id_tipoCuenta) {
		this.id_tipoCuenta = id_tipoCuenta;
	}

	public String getDescripcion_tipoCuenta() {
		return descripcion_tipoCuenta;
	}

	public void setDescripcion_tipoCuenta(String descripcion_tipoCuenta) {
		this.descripcion_tipoCuenta = descripcion_tipoCuenta;
	}

	
	public int getEstado_tipoCuenta() {
		return estado_tipoCuenta;
	}


	public void setEstado_tipoCuenta(int estado_tipoCuenta) {
		this.estado_tipoCuenta = estado_tipoCuenta;
	}


	@Override
	public String toString() {
		return "TipoCuenta [id_tipoCuenta=" + id_tipoCuenta + ", descripcion_tipoCuenta=" + descripcion_tipoCuenta
				+ ", estado_tipoCuenta=" + estado_tipoCuenta + "]";
	}
}
