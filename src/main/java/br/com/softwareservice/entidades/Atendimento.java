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
import javax.persistence.Table;

@Entity
@Table(name="Atendimento")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="idAtendimento")
	private Long id;
	
	@Column(name = "data")
	private LocalDate data;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "Funcionario_idFuncionario", referencedColumnName = "idFuncionario")
	private Funcionario atendenteResponsavel = new Funcionario();
	
	@Column(name = "numero")
	private Integer numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Funcionario getAtendenteResponsavel() {
		return atendenteResponsavel;
	}

	public void setAtendenteResponsavel(Funcionario atendenteResponsavel) {
		this.atendenteResponsavel = atendenteResponsavel;
	}
	
}
