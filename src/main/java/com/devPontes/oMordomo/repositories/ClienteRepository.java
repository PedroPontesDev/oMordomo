package com.devPontes.oMordomo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devPontes.oMordomo.model.entities.BatedorDePonto;

public interface ClienteRepository extends JpaRepository<BatedorDePonto, Long> {

	
}
