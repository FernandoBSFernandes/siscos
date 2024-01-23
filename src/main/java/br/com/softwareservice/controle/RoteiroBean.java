package br.com.softwareservice.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RoteiroBean {
	
	private String numeroOS = "12";
	private String nomeCliente = "Fernando Barros";
	private String data = "12/09/2015";
	private String status = "Aberto";
	
	public String getNumeroOS() {
		return numeroOS;
	}
	
	public void setNumeroOS(String numeroOS) {
		this.numeroOS = numeroOS;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
