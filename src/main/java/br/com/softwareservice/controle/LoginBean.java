package br.com.softwareservice.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.softwareservice.dao.ILogin;
import br.com.softwareservice.dao.LoginFacade;
import br.com.softwareservice.entidades.Funcionario;

@ManagedBean
@ViewScoped
public class LoginBean {
	
	public LoginBean() {}

	private Funcionario funcionario = new Funcionario();
	private ILogin iLogin = new LoginFacade();
	private String login, senha;
	
	public String login(){
		funcionario = iLogin.login(login, senha);
		
		if (funcionario != null){
			return "homeatendimento.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login e/ou senha incorretos.", null));
			return null;
		}
	}
	
	public String logout(){
		return "/index";
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public ILogin getiLogin() {
		return iLogin;
	}
	public void setiLogin(ILogin iLogin) {
		this.iLogin = iLogin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
