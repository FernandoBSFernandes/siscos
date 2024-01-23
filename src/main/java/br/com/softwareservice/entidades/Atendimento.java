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

@Entity
@Table(name = "Atendimento")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAtendimento")
	private Long id;
	
	@Column(name = "dataAbertura")
	@NotNull
	private LocalDate dataAbertura;
	
	@Column(name = "numero")
	@NotNull
	private Integer numero;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Funcionario_idFuncionario", referencedColumnName = "idFuncionario")
	private Funcionario atendenteResponsavel = new Funcionario();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
	private Cliente cliente = new Cliente();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Funcionario getAtendenteResponsavel() {
		return atendenteResponsavel;
	}

	public void setAtendenteResponsavel(Funcionario atendenteResponsavel) {
		this.atendenteResponsavel = atendenteResponsavel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}