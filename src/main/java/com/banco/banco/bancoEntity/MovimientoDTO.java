package com.banco.banco.bancoEntity;

import java.util.Date;

public class MovimientoDTO {
	private String Cliente;
	private Date Fecha;
	private int Numero_Cuenta;	
	private String Tipo;
	private double saldo_inicial;
	private int Estado;
	private String Movimiento;
	private double saldoDisponible;
	public MovimientoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovimientoDTO(String cliente, Date fecha, int numero_Cuenta, String tipo, double saldo_inicial, int estado,
			String movimiento, double saldoDisponible) {
		super();
		Cliente = cliente;
		Fecha = fecha;
		Numero_Cuenta = numero_Cuenta;
		Tipo = tipo;
		this.saldo_inicial = saldo_inicial;
		Estado = estado;
		Movimiento = movimiento;
		this.saldoDisponible = saldoDisponible;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public int getNumero_Cuenta() {
		return Numero_Cuenta;
	}
	public void setNumero_Cuenta(int numero_Cuenta) {
		Numero_Cuenta = numero_Cuenta;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public double getSaldo_inicial() {
		return saldo_inicial;
	}
	public void setSaldo_inicial(double saldo_inicial) {
		this.saldo_inicial = saldo_inicial;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public String getMovimiento() {
		return Movimiento;
	}
	public void setMovimiento(String movimiento) {
		Movimiento = movimiento;
	}
	public double getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	@Override
	public String toString() {
		return "MovimientoDTO [Cliente=" + Cliente + ", Fecha=" + Fecha + ", Numero_Cuenta=" + Numero_Cuenta + ", Tipo="
				+ Tipo + ", saldo_inicial=" + saldo_inicial + ", Estado=" + Estado + ", Movimiento=" + Movimiento
				+ ", saldoDisponible=" + saldoDisponible + "]";
	}
	
	
}
