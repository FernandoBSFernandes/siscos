package br.com.softwareservice.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareservice.dao.DAOFacade;
import br.com.softwareservice.dao.IDAO;
import br.com.softwareservice.entidades.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {

	public ClienteBean() {}
	
	private IDAO dao = new DAOFacade();
	private Cliente cliente = new Cliente();

	public void salvar(){
		
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
	
}