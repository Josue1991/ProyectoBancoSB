package com.banco.banco.bancoController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banco.banco.bancoEntity.Persona;
import com.banco.banco.bancoService.PersonaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("api")
public class PersonaController {
	
	@Autowired 
	private PersonaService personaService;
	
	@PostMapping("/persona/crear")
    public String crear(@RequestBody Persona personaNuevo)
    {		
		try {
			personaService.crearPersona(personaNuevo);			
		}catch (Exception e) {
			throw new RuntimeException("No se puede insertar el registro"+personaNuevo.getIdentificacion_persona());
		}
        return "El regisrtro se creo correctamente!!";
    }


    @GetMapping("/persona/listaPersonas")
    public List<Persona> listaPersonas()
    {
    	List<Persona> listaRetorno = new ArrayList<Persona>();
    	try {
    		listaRetorno = personaService.listarPersonas();
		} catch (Exception e) {
			throw new RuntimeException("No se encuentran registros");
		}
        return listaRetorno;
    }
 
    @PutMapping("/persona/editar/{identificacion}")
    public String editar(@RequestBody Persona persona, @PathVariable("identificacion") String identificacion)
    {
    	try {
    		personaService.editarPersona(persona,identificacion);
		} catch (Exception e) {
			throw new RuntimeException("No se puede editar el registro "+persona.getId_persona());
		}
        return "El Registro se modifico satisfactoriamente!!";
    }
 
    @DeleteMapping("/persona/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id)
    {
        try {
			personaService.eliminarPersona(id);
		} catch (Exception e) {
			throw new RuntimeException("No se puede eliminar el registro"+id);
		}
        return "Se ha eliminado el registro con exito";
    }
	

}
