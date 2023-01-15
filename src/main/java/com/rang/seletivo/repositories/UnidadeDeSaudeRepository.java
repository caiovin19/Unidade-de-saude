package com.rang.seletivo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rang.seletivo.entities.UnidadeDeSaude;

@Repository
public interface UnidadeDeSaudeRepository extends JpaRepository<UnidadeDeSaude, String>{
	
	@Query(value= "SELECT cnes , cep_fim, cep_inicio , nome_do_estabelecimento FROM tb_unidadedesaude WHERE cnes = :cnes", nativeQuery = true)
	public UnidadeDeSaude findByCnes(@Param("cnes") String cnes);
	
	@Query(value="SELECT nome_do_estabelecimento FROM tb_unidadedesaude "
			+ "WHERE  :cepInformado BETWEEN cep_inicio AND cep_fim", nativeQuery = true)
	public String findUnidadeByCep(@Param("cepInformado") Integer cepInformado);
	
	@Query(value="SELECT * "
			+ "FROM tb_unidadesaude "
			+ "WHERE EXISTS (SELECT cep_inicio , cep_fim FROM tb_unidadesaude WHERE cep_inicio =:cep_inicio AND cep_fim = :cep_fim)", nativeQuery = true)
	public Boolean validaCep(@Param("cep_inicio") Integer cepInicio,@Param("cep_fim") Integer cepFim);
	
}
