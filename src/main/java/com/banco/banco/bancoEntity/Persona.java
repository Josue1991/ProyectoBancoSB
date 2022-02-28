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

@Table(name="Persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private long id_persona;
	@Column(name = "NOMBRE_PERSONA")
	private String nombre_persona;
	@Column(name = "EDAD_PERSONA")
	private int edad_persona;
	@Column(name = "IDENTIFICACION_PERSONA")
	private String identificacion_persona;
	@Column(name = "DIRRECCION_PERSONA")
	private String  DIRRECCION_persona;
	@Column(name = "telefono_PERSONA")
	private String  TELEFONO_persona;
	@Column(name = "GENERO_PERSONA")
	private String  genero_persona;
	
		
	public Persona() {
		super();
	}

	public long getId_persona() {
		return id_persona;
	}

	public void setId_persona(long id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre_persona() {
		return nombre_persona;
	}

	public void setNombre_persona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}

	public int getEdad_persona() {
		return edad_persona;
	}

	public void setEdad_persona(int edad_persona) {
		this.edad_persona = edad_persona;
	}

	public String getIdentificacion_persona() {
		return identificacion_persona;
	}


	public void setIdentificacion_persona(String identificacion_persona) {
		this.identificacion_persona = identificacion_persona;
	}


	public String getDIRRECCION_persona() {
		return DIRRECCION_persona;
	}

	public void setDIRRECCION_persona(String dIRRECCION_persona) {
		DIRRECCION_persona = dIRRECCION_persona;
	}


	public String getTELEFONO_persona() {
		return TELEFONO_persona;
	}

	public void setTELEFONO_persona(String tELEFONO_persona) {
		TELEFONO_persona = tELEFONO_persona;
	}

	public String getGenero_persona() {
		return genero_persona;
	}

	public void setGenero_persona(String genero_persona) {
		this.genero_persona = genero_persona;
	}
	
	@Override
	public String toString() {
		return "Persona [id_persona=" + id_persona + ", nombre_persona=" + nombre_persona + ", edad_persona="
				+ edad_persona + ", identificacion_persona=" + identificacion_persona + ", DIRRECCION_persona="
				+ DIRRECCION_persona + ", TELEFONO_persona=" + TELEFONO_persona + ", genero_persona=" + genero_persona
				+ "]";
	}




	

}
