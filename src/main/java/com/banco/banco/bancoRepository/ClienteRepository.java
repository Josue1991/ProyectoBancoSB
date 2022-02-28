package com.banco.banco.bancoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banco.banco.bancoEntity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query(value = "Select * FROM Cliente c "
			+ " inner join Persona p on c.id_persona = p.id_persona"
			+ " WHERE p.identificacion_persona = ?1",nativeQuery = true)
    Cliente clienteIdPersona(String identificacion);	
	
}
