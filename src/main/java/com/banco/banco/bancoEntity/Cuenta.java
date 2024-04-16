package com.banco.banco.bancoEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder

@Table(name = "Cuenta")

public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CUENTA")
	private long id_cuenta;
	@Column(name = "ID_CLIENTE")
	private long id_cliente;
	@Column(name = "NUMERO_CUENTA")
	private int numero_cuenta;
	@Column(name = "TIPO_CUENTA")
	private String tipo_cuenta;
	@Column(name = "SALDO_INICIAL_CUENTA")
	private double saldo_inicial_cuenta;
	@Column(name = "ESTADO_CUENTA")
	private int estado_cuenta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false)	
	private Cliente cliente;

	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public double getSaldo_inicial_cuenta() {
		return saldo_inicial_cuenta;
	}

	public void setSaldo_inicial_cuenta(double saldo_inicial_cuenta) {
		this.saldo_inicial_cuenta = saldo_inicial_cuenta;
	}

	

	public int getEstado_cuenta() {
		return estado_cuenta;
	}



	public void setEstado_cuenta(int estado_cuenta) {
		this.estado_cuenta = estado_cuenta;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [id_cuenta=" + id_cuenta + ", id_cliente=" + id_cliente + ", numero_cuenta=" + numero_cuenta
				+ ", tipo_cuenta=" + tipo_cuenta + ", saldo_inicial_cuenta=" + saldo_inicial_cuenta + ", estado_cuenta="
				+ estado_cuenta + ", cliente=" + cliente + "]";
	}
	
}
