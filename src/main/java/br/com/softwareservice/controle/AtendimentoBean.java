package br.com.softwareservice.controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputmask.InputMask;

import br.com.softwareservice.dao.ClienteFacade;
import br.com.softwareservice.dao.DAOFacade;
import br.com.softwareservice.dao.FuncionarioFacade;
import br.com.softwareservice.dao.ICliente;
import br.com.softwareservice.dao.IDAO;
import br.com.softwareservice.dao.IFuncionario;
import br.com.softwareservice.entidades.Atendimento;
import br.com.softwareservice.entidades.Cliente;
import br.com.softwareservice.entidades.Funcionario;
import br.com.softwareservice.entidades.OrdemServico;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AtendimentoBean implements Serializable{

	public AtendimentoBean() {}

	private Atendimento atendimento = new Atendimento();
	private OrdemServico ordemServico = new OrdemServico();
	private IDAO idao = new DAOFacade();
	private Cliente cliente = new Cliente();
	private FacesMessage message;
	private ICliente iCliente = new ClienteFacade();
	private IFuncionario iFuncionario = new FuncionarioFacade();

	public Cliente buscarCliente(AjaxBehaviorEvent event){

		InputMask cpfCliente = (InputMask) event.getSource();
		String cpf = (String) cpfCliente.getValue();

		cliente = iCliente.buscarCliente(cpf);
		
		if (cliente == null){
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Este CPF n�o est� cadastrado no sistema. Cadastre-o na op��o Clientes.", null);
		}
		return cliente;
	}
	
	public String novoAtendimento(){
		return "cadastroatendimento.xhtml";
	}
	
	public Funcionario getFuncionario(AjaxBehaviorEvent event){
		
		InputMask matriculaFuncionario = (InputMask) event.getSource();
		String matricula = (String) matriculaFuncionario.getValue();

		Funcionario funcionario = iFuncionario.buscarFuncionario(matricula);
		
		if (funcionario == null){
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Este funcion�rio n�o existe.", null);
		}
		
		return funcionario;
		
	}

	public void salvarAtendimentoEOrdemServico(){
		try {
			idao.salvar(atendimento);
			idao.salvar(ordemServico);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendimento e Ordem de Servi�o registrados com sucesso.", null);

		} catch (Exception e){
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar registrar o atendimento e/ou a ordem de servi�o: " + e.getMessage(), null);

		} finally {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);
		}
	}
	
	public void salvarAtendimento(){

		FacesMessage msg = null;		
		try {
			idao.salvar(atendimento);
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendimento registrado com sucesso.", null);
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

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public IDAO getIdao() {
		return idao;
	}

	public void setIdao(IDAO idao) {
		this.idao = idao;
	}

	public FacesMessage getMessage() {
		return message;
	}

	public void setMessage(FacesMessage message) {
		this.message = message;
	}

	public ICliente getiCliente() {
		return iCliente;
	}

	public void setiCliente(ICliente iCliente) {
		this.iCliente = iCliente;
	}

	public IFuncionario getiFuncionario() {
		return iFuncionario;
	}

	public void setiFuncionario(IFuncionario iFuncionario) {
		this.iFuncionario = iFuncionario;
	}
}
