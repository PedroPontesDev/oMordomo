package com.devPontes.oMordomo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devPontes.oMordomo.model.entities.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {

	
}
