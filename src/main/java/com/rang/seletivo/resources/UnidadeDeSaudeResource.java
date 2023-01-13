package com.rang.seletivo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rang.seletivo.entities.UnidadeDeSaude;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeDeSaudeResource {
	
	public ResponseEntity<UnidadeDeSaude>findAll(){
		
	}
}
