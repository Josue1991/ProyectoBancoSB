package com.banco.banco.bancoEntity;



import java.util.Date;

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

@Table(name = "Movimiento")

public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MOVIMIENTO")
	private long id_Movimiento;
	@Column(name = "ID_CUENTA")
	private long id_cuenta;
	@Column(name = "FECHA_MOVIMIENTO")
	private Date fecha_movimiento;
	@Column(name = "TIPO_MOVIMIENTO")
	private String tipo_movimiento;
	@Column(name = "SALDO_MOVIMIENTO")
	private double saldo_movimiento;
	@Column(name = "ESTADO_MOVIMIENTO")
	private int estado_movimiento;
	@Column(name = "DESCRIPCION_MOVIMIENTO")
	private String descripcion_movimiento;
	@Column(name = "SALDO_ACTUAL_MOVIMIENTO")
	private double saldo_actual_movimiento;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cuenta", insertable = false, updatable = false)	
	private Cuenta cuenta;

	public Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_Movimiento() {
		return id_Movimiento;
	}

	public void setId_Movimiento(long id_Movimiento) {
		this.id_Movimiento = id_Movimiento;
	}

	public long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public Date getFecha_movimiento() {
		return fecha_movimiento;
	}

	public void setFecha_movimiento(Date fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}

	public String getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	public double getSaldo_movimiento() {
		return saldo_movimiento;
	}

	public void setSaldo_movimiento(double saldo_movimiento) {
		this.saldo_movimiento = saldo_movimiento;
	}

	public int getEstado_movimiento() {
		return estado_movimiento;
	}

	public void setEstado_movimiento(int estado_movimiento) {
		this.estado_movimiento = estado_movimiento;
	}

	public String getDescripcion_movimiento() {
		return descripcion_movimiento;
	}

	public void setDescripcion_movimiento(String descripcion_movimiento) {
		this.descripcion_movimiento = descripcion_movimiento;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public double getSaldo_actual_movimiento() {
		return saldo_actual_movimiento;
	}

	public void setSaldo_actual_movimiento(double saldo_actual_movimiento) {
		this.saldo_actual_movimiento = saldo_actual_movimiento;
	}

	@Override
	public String toString() {
		return "Movimiento [id_Movimiento=" + id_Movimiento + ", id_cuenta=" + id_cuenta + ", fecha_movimiento="
				+ fecha_movimiento + ", tipo_movimiento=" + tipo_movimiento + ", saldo_movimiento=" + saldo_movimiento
				+ ", estado_movimiento=" + estado_movimiento + ", descripcion_movimiento=" + descripcion_movimiento
				+ ", saldo_actual_movimiento=" + saldo_actual_movimiento + ", cuenta=" + cuenta + "]";
	}

	
	
	

}
