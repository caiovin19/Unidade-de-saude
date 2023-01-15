package com.rang.seletivo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rang.seletivo.entities.UnidadeDeSaude;
import com.rang.seletivo.services.UnidadeDeSaudeService;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeDeSaudeResource {
	
	@Autowired
	private UnidadeDeSaudeService service;
	
	@GetMapping
	public ResponseEntity <List<UnidadeDeSaude>>FindAll(){
		List<UnidadeDeSaude>list=service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping
	public ResponseEntity<UnidadeDeSaude> insert(@RequestBody UnidadeDeSaude obj){
		obj=service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@DeleteMapping(value="/{cnes}")
	public ResponseEntity<Void> delete(@PathVariable String cnes){
		UnidadeDeSaude obj=service.findByCnes(cnes);
		service.delete(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value="/{cnes}")
	public ResponseEntity<UnidadeDeSaude> update(@PathVariable String cnes, @RequestBody UnidadeDeSaude obj){
		obj=service.update(cnes, obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value="/{cepInformado}")
	public ResponseEntity<String> findUnidadeByCep(@PathVariable Integer cepInformado){
		String cepFront=service.findUnidadeByCep(cepInformado);
		return ResponseEntity.ok().body(cepFront);
	}
}
