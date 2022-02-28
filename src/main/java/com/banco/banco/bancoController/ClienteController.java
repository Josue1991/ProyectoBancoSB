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

import com.banco.banco.bancoEntity.Cliente;
import com.banco.banco.bancoService.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("api")
public class ClienteController {
	
	@Autowired 
	private ClienteService clienteService;
	
	@PostMapping("/cliente/crear")
    public String crear(@RequestBody Cliente clienteNuevo)
    {		
		try {
			clienteService.crearCliente(clienteNuevo);			
		}catch (Exception e) {
			throw new RuntimeException("No se puede insertar el registro: "+clienteNuevo.getPersona().getIdentificacion_persona());
		}
        return "El regisrtro se creo correctamente!!";
    }


    @GetMapping("/cliente/listaClientes")
    public List<Cliente> listaClientes()
    {
    	List<Cliente> listaRetorno = new ArrayList<Cliente>();
    	try {
    		listaRetorno = clienteService.listarClientes();
		} catch (Exception e) {
			throw new RuntimeException("No se encuentran registros");
		}
        return listaRetorno;
    }
 
    @PutMapping("/cliente/editar/{id}")
    public String editar(@RequestBody Cliente clienteEdit,@PathVariable("id") String id)
    {
    	try {
    		clienteService.editarCliente(clienteEdit,id);
		} catch (Exception e) {
			throw new RuntimeException("No se puede editar el registro "+ clienteEdit.getPersona().getIdentificacion_persona());
		}
        return "El Registro se modifico satisfactoriamente!!";
    }
 
    @DeleteMapping("/cliente/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id)
    {
        try {
			clienteService.eliminarCliente(id);
		} catch (Exception e) {
			throw new RuntimeException("No se puede eliminar el registro"+id);
		}
        return "Eliminado Correctamente";
    }

}

