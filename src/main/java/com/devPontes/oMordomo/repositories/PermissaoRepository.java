package com.devPontes.oMordomo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devPontes.oMordomo.model.entities.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
    List<Permissao> findAllById(Iterable<Long> ids); // Método para buscar permissões por IDs
}

