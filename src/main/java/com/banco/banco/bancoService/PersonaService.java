package com.banco.banco.bancoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.banco.bancoEntity.Persona;
import com.banco.banco.bancoRepository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona buscarPersona(String identificacionPersona) {
		var persona = new Persona();
		persona = personaRepository.personaIdentificacion(identificacionPersona);
		return persona;
	}

	@Override
	public List<Persona> listarPersonas() {
		List<Persona> lista = new ArrayList<Persona>();
		lista = personaRepository.findAll();
		return lista;
	}

	@Override
	public Persona crearPersona(Persona nueva) throws Exception {
		Persona retorno = new Persona();
		try {
			var persona = new Persona();
			var PersonaRep = personaRepository.personaIdentificacion(nueva.getIdentificacion_persona());
			if (!Objects.nonNull(PersonaRep)) {
				persona = personaRepository.save(nueva);
				if (Objects.nonNull(persona)) {
					retorno = persona;
				}
			}
		} catch (Exception e) {
			throw new Exception("No se pudo crear el Registro!!");
		}

		return retorno;
	}

	@Override
	public Boolean editarPersona(Persona editar,String identificacion) throws Exception {
		boolean retorno = false;
		try {
			Persona depDB = personaRepository.personaIdentificacion(identificacion);
			if (Objects.nonNull(depDB)) {
				if (Objects.nonNull(editar.getNombre_persona()) && !"".equalsIgnoreCase(editar.getNombre_persona())) {
					depDB.setNombre_persona(editar.getNombre_persona());
				}
				if (Objects.nonNull(editar.getIdentificacion_persona()) && !"".equalsIgnoreCase(editar.getIdentificacion_persona())) {
					depDB.setIdentificacion_persona(editar.getIdentificacion_persona());
				}
				if (Objects.nonNull(editar.getEdad_persona()) && editar.getEdad_persona() > 0) {
					depDB.setEdad_persona(editar.getEdad_persona());
				}
				if (Objects.nonNull(editar.getDIRRECCION_persona())
						&& !"".equalsIgnoreCase(editar.getDIRRECCION_persona())) {
					depDB.setDIRRECCION_persona(editar.getDIRRECCION_persona());
				}
				if (Objects.nonNull(editar.getTELEFONO_persona())) {
					depDB.setTELEFONO_persona(editar.getTELEFONO_persona());
				}
				if (Objects.nonNull(editar.getGenero_persona()) && !"".equalsIgnoreCase(editar.getGenero_persona())) {
					depDB.setGenero_persona(editar.getGenero_persona());
				}
				personaRepository.save(depDB);
				retorno = true;
			} else {
				throw new Exception("Existe mas de un registro con ese numero de cedula");
			}
		} catch (Exception e) {
			throw new Exception("No se pudo actualizar el Registro!!");
		}
		return retorno;
	}

	@Override
	public Boolean eliminarPersona(String identificacionPersona) throws Exception {
		boolean retorno = false;
		try {
			Persona depDB = personaRepository.personaIdentificacion(identificacionPersona);
			if (Objects.nonNull(depDB)) {
				personaRepository.delete(depDB);
				retorno = true;
			} else {
				throw new Exception("Existe mas de un registro con ese numero de cedula");
			}
		} catch (Exception e) {
			throw new Exception("No se pudo eliminar el Registro!!");
		}
		return retorno;
	}

}
