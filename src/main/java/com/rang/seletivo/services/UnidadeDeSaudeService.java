package com.rang.seletivo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.rang.seletivo.entities.UnidadeDeSaude;
import com.rang.seletivo.repositories.UnidadeDeSaudeRepository;

@Service
public class UnidadeDeSaudeService {

	
	@Autowired
	private UnidadeDeSaudeRepository repository;
	
	public List<UnidadeDeSaude> findAll(){
		return repository.findAll();
	}
	
	public UnidadeDeSaude insert(UnidadeDeSaude obj) {
		return repository.save(obj);
	}
	
	public void delete(UnidadeDeSaude entity) {
		repository.delete(entity);
	
	}
	
	public UnidadeDeSaude findByCnes(String cnes) {
		UnidadeDeSaude entity=repository.findByCnes(cnes);
		return entity;
	}
	
	
	public UnidadeDeSaude update(String cnes,UnidadeDeSaude obj ) {
		UnidadeDeSaude entity=repository.findByCnes(cnes);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(UnidadeDeSaude entity, UnidadeDeSaude obj) {
		entity.setNomeDoEstabelecimento(obj.getNomeDoEstabelecimento());
		entity.setCepInicio(obj.getCepInicio());
		entity.setCepFim(obj.getCepFim());
	}
	
	public String findUnidadeByCep(Integer cepInformado) {
		return repository.findUnidadeByCep(cepInformado);
	}
}
