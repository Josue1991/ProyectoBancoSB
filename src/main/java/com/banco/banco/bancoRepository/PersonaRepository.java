package com.banco.banco.bancoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banco.banco.bancoEntity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	@Query(value = "Select * FROM Persona p WHERE p.identificacion_persona = ?1",nativeQuery = true)
    Persona personaIdentificacion(String identificacion);	
		
}
