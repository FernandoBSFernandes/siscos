package br.com.softwareservice.dao;

import br.com.softwareservice.entidades.Funcionario;

public interface ILogin {
	
	public Funcionario login (String login, String senha);

}
