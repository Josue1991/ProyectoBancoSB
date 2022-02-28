package com.banco.banco.bancoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banco.banco.bancoEntity.Cliente;
import com.banco.banco.bancoEntity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query(value = "Select * FROM Estado c "
			+ " WHERE p.descripcion_estado LIKE ?1%",nativeQuery = true)
    Estado estadoDescripcion(String identificacion);	
	
}