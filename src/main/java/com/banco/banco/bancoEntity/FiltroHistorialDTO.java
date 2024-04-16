package com.banco.banco.bancoEntity;

public class FiltroHistorialDTO {
	
	private Long cedula;
	private String fecha_Desde;
	private String fecha_Hasta;
	
	public FiltroHistorialDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public String getFecha_Desde() {
		return fecha_Desde;
	}
	public void setFecha_Desde(String fecha_Desde) {
		this.fecha_Desde = fecha_Desde;
	}
	public String getFecha_Hasta() {
		return fecha_Hasta;
	}
	public void setFecha_Hasta(String fecha_Hasta) {
		this.fecha_Hasta = fecha_Hasta;
	}
	@Override
	public String toString() {
		return "FiltroHistorialDTO [cedula=" + cedula + ", fecha_Desde=" + fecha_Desde + ", fecha_Hasta=" + fecha_Hasta
				+ "]";
	}
	
	
	
}
