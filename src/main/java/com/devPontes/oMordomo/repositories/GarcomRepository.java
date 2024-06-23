package com.devPontes.oMordomo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devPontes.oMordomo.model.entities.Garcom;

public interface GarcomRepository extends JpaRepository<Garcom, Long> {

	@Query("SELECT g FROM Garcom WHERE g.id =: id" )
	Optional<Garcom> findById(Long id);
	
}
