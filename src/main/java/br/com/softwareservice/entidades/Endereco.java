package br.com.softwareservice.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEndereco")
	private long id;
	
	
	@Column(name = "logradouro")
	@NotNull(message ="Informa seu endereco")
	@Size(min = 1, max = 50)
	private String logradouro;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "cep")
	@NotNull(message ="Informa seu cep")
	@Size(min = 1, max = 9)
    private	String cep;
	
	@Column (name = "bairro")
	@NotNull(message = "Informa seu bairro")
	private String bairro;
	
	@Column (name = "municipio", nullable = false)
	@NotNull(message = "Informa seu municipio")
	private String municipio;
	
	@Column (name= "uf", nullable = false )
	private String uf;
	
	@Column(name="referencia")
	private String referencia;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getuf() {
		return uf;
	}

	public void setuf(String estado) {
		this.uf = estado;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	
	

	
	

}

