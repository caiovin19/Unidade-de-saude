package com.rang.seletivo.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_unidadedesaude")
public class UnidadeDeSaude implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name = "cnes")
	private String cnes;
	
	@Column(name = "nome_do_estabelecimento")
	private String nomeDoEstabelecimento;
	
	@Column(name = "cep_inicio")
	private Integer cepInicio;
	
	@Column(name = "cep_fim")
	private Integer cepFim;
	
	public UnidadeDeSaude() {
		
	}
	
	public UnidadeDeSaude(String cnes, String nomeDoEstabelecimento, Integer cepInicio, Integer cepFim) {
		this.cnes = cnes;
		this.nomeDoEstabelecimento = nomeDoEstabelecimento;
		this.cepInicio = cepInicio;
		this.cepFim = cepFim;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public String getNomeDoEstabelecimento() {
		return nomeDoEstabelecimento;
	}

	public void setNomeDoEstabelecimento(String nomeDoEstabelecimento) {
		this.nomeDoEstabelecimento = nomeDoEstabelecimento;
	}

	public Integer getCepInicio() {
		return cepInicio;
	}

	public void setCepInicio(Integer cepInicio) {
		this.cepInicio = cepInicio;
	}

	public Integer getCepFim() {
		return cepFim;
	}

	public void setCepFim(Integer cepFim) {
		this.cepFim = cepFim;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cnes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeDeSaude other = (UnidadeDeSaude) obj;
		return Objects.equals(cnes, other.cnes);
	}
	
	
	
	
	
	

}
