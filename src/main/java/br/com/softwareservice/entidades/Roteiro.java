package br.com.softwareservice.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Roteiro")
public class Roteiro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRoteiro")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataGeracao")
	public LocalDate dataGeracao;
	
	@OneToOne
	@JoinColumn(name="Funcionario_idFuncionario", referencedColumnName = "idFuncionario")
	public Funcionario tecnicoResponsavel = new Funcionario();
	
	public List<OrdemServico> ordensServico = new ArrayList<OrdemServico>();
}
