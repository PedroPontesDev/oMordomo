package com.devPontes.oMordomo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devPontes.oMordomo.model.entities.Garcom;

public interface GarcomRepository extends JpaRepository<Garcom, Long> {

	@Query("SELECT g FROM Garcom g WHERE g.id = :id" )
	Optional<Garcom> findById(Long id);

	@Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
	Optional<Garcom> procurarPorCpf(@Param("cpf") Long cpf);
	
}
