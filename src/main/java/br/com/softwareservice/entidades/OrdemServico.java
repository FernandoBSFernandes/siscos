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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "OrdemServico")
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOS")
	private Long id;
	
	@Column(name = "protocolo", unique = true)
	private Integer protocolo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "data")
	@NotNull
	private LocalDate dataEmissao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Prioridade_idPrioridade", referencedColumnName = "idPrioridade")
	private Prioridade prioridade = new Prioridade();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
	private Cliente cliente = new Cliente();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Status_idStatus", referencedColumnName = "idStatus")
	private Status status = new Status();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Funcionario_idFuncionario", referencedColumnName = "idFuncionario")
	private Funcionario funcionario = new Funcionario();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Integer protocolo) {
		this.protocolo = protocolo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}