package com.rang.seletivo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.rang.seletivo.entities.UnidadeDeSaude;
import com.rang.seletivo.repositories.UnidadeDeSaudeRepository;
import com.rang.seletivo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UnidadeDeSaudeService {

	
	@Autowired
	private UnidadeDeSaudeRepository repository;
	
	public List<UnidadeDeSaude> findAll(){
		try{
			return repository.findAll();
		}catch(Exception e) {
			e.getMessage();
		}
		return null;	
	}
	
	public UnidadeDeSaude insert(UnidadeDeSaude obj) {
			return repository.save(obj);
		
	}
	
	public void delete(UnidadeDeSaude entity) {
		try{
			repository.delete(entity);
		}catch(Exception e) {
			throw new ResourceNotFoundException(getClass());
		}
	
	}
	
	public UnidadeDeSaude findByCnes(String cnes) {
		try {
		UnidadeDeSaude entity=repository.findByCnes(cnes);
		return entity;
		}catch(Exception e) {
			throw new ResourceNotFoundException(cnes);
		}
		
	}
	
	
	public UnidadeDeSaude update(String cnes,UnidadeDeSaude obj ) {
		UnidadeDeSaude entity=repository.findByCnes(cnes);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(UnidadeDeSaude entity, UnidadeDeSaude obj) {
		try {
		entity.setNomeDoEstabelecimento(obj.getNomeDoEstabelecimento());
		entity.setCepInicio(obj.getCepInicio());
		entity.setCepFim(obj.getCepFim());
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(entity);
		}
		
	}
	
	public String findUnidadeByCep(Integer cepInformado){
		String unidadeEncontrada=repository.findUnidadeByCep(cepInformado);
		if(unidadeEncontrada==null) {
			throw new ResourceNotFoundException(cepInformado);
		}
		return unidadeEncontrada;
		  
	}
}
