package br.com.softwareservice.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StatusOS")
public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStatus")
	private Long id;
	
	@Column(name = "statusOS")
	private String status;
	
	@OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrdemServico> ordensServico = new ArrayList<OrdemServico>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(List<OrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}

}