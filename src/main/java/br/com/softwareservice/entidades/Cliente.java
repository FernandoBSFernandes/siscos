package br.com.softwareservice.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private Long id;
	
	@Column(name="nome")
	@NotBlank
	@Length(min = 1, max = 50)
	private String nome;
	
	@Column(name="data_nasc")
	@Length(min = 1, max = 14)
	@NotBlank
	private LocalDate dataNascimento;

	@CPF(message = "Digite um CPF válido.")
	@Column(name = "cpf")
	@Length(min = 1, max = 14)
	@NotNull
	private String cpf;
	
	@Column(name = "rg")
	@NotBlank
	private String rg;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Column(name="telefone")
	@NotNull
	private String telefone;
	
	@Column(name="celular")
	private String celular;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Endereco_idEndereco", referencedColumnName="idEndereco")
	private Endereco endereco = new Endereco();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}