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

import com.banco.banco.bancoEntity.Estado;
import com.banco.banco.bancoEntity.TipoCuenta;
import com.banco.banco.bancoService.EstadoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("api")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@PostMapping("/estado/crear")
    public String crear(@RequestBody Estado nuevo)
    {		
		try {
			estadoService.crearEstado(nuevo);			
		}catch (Exception e) {
			throw new RuntimeException("No se puede insertar el registro"+ nuevo.getDescripcion_estado());
		}
        return "El regisrtro se creo correctamente!!";
    }


    @GetMapping("/estado/listaTipo")
    public List<Estado> listaPersonas()
    {
    	List<Estado> listaRetorno = new ArrayList<Estado>();
    	try {
    		listaRetorno = estadoService.listarEstados();
		} catch (Exception e) {
			throw new RuntimeException("No se encuentran registros");
		}
        return listaRetorno;
    }
 
    @PutMapping("/estado/editar")
    public String editar(@RequestBody Estado estado)
    {
    	try {
    		estadoService.editarEstado(estado);
		} catch (Exception e) {
			throw new RuntimeException("No se puede editar el registro "+ estado.getDescripcion_estado());
		}
        return "El Registro se modifico satisfactoriamente!!";
    }
 
    @DeleteMapping("/estado/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id)
    {
        try {
        	estadoService.eliminarEstado(id);
		} catch (Exception e) {
			throw new RuntimeException("No se puede eliminar el registro"+id);
		}
        return "Se borro Correctamente";
    }
	
	

}
