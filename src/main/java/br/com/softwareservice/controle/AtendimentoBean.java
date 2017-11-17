package br.com.softwareservice.controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.softwareservice.dao.DAOFacade;
import br.com.softwareservice.dao.IDAO;
import br.com.softwareservice.entidades.Atendimento;
import br.com.softwareservice.entidades.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AtendimentoBean implements Serializable{

	public AtendimentoBean() {}

	private Atendimento atendimento = new Atendimento();
	private IDAO idao = new DAOFacade();
	private Cliente cliente = new Cliente();
	
	/*public Cliente buscarCliente(AjaxBehaviorEvent event, String cpf){
	 * 
	 * InputText cpfCliente = (InputText) event.getSource();
		String cpf = (String) cpfCliente.getValue()
	 * 
	 * cliente = iCliente.buscarCliente(cpf);
	 * return cliente;
		
	}*/

	public void salvar(){

		FacesMessage msg = null;		
		try {
			idao.salvar(atendimento);
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendimento registrado com sucesso", null);


		} catch (Exception e){
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar registrar o atendimento: " + e.getMessage(), null);

		} finally {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
		}
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
