package com.rang.seletivo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rang.seletivo.entities.UnidadeDeSaude;

@Repository
public interface UnidadeDeSaudeRepository extends JpaRepository<UnidadeDeSaude, Long>{

}
