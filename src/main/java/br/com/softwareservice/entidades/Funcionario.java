package br.com.softwareservice.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Funcionario() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFuncionario")
	private Long id;
	
	@Column(name = "nome")
	@Size(min = 1, max = 50)
	@NotNull
	private String nome;
	
	@Column(name = "matricula", unique = true)
	@Max(value = 10)
	@NotNull
	private int matricula;
	
	@Column(name = "login", unique = true)
	@NotNull
	private String login;
	
	@Column(name = "senha", unique = true)
	@Size(min = 1, max = 10)
	@NotBlank
	private String senha;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Cargo_idCargo", referencedColumnName = "idCargo")
	private Cargo cargo = new Cargo();
	
	@OneToMany(mappedBy = "funcionario")
	private List<OrdemServico> ordensServico = new ArrayList<OrdemServico>();

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

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<OrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<OrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}	
}