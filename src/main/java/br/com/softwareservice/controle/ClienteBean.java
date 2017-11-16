package br.com.softwareservice.controle;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.softwareservice.dao.DAOFacade;
import br.com.softwareservice.dao.IDAO;
import br.com.softwareservice.entidades.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{

	public ClienteBean() {}
	
	private IDAO dao = new DAOFacade();
	private Cliente cliente = new Cliente();
	private String data = "";

	public void salvar(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = cliente.getDataNascimento().format(formatter);
		LocalDate dataNasc = LocalDate.parse(dataFormatada);
		cliente.setDataNascimento(dataNasc);
		
		FacesMessage msg = null;		
		try {
			dao.salvar(cliente);
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cliente" + cliente.getNome() + " salvo com sucesso!");
			setCliente(new Cliente());
			
		} catch (Exception e){
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao tentar salvar os dados do cliente: " + e);
			
		} finally {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
		}
	}
	
	public IDAO getDao() {
		return dao;
	}
	
	public void setDao(IDAO dao) {
		this.dao = dao;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}