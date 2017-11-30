package br.com.softwareservice.dao;

import br.com.softwareservice.entidades.Funcionario;

public class LoginFacade implements ILogin {

	@Override
	public Funcionario login(String login, String senha) {
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.login(login, senha);
	}

}
