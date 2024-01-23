package br.com.softwareservice.dao;

import br.com.softwareservice.entidades.Funcionario;

public class FuncionarioFacade implements IFuncionario{
	
	@Override
	public Funcionario buscarFuncionario(String matricula){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.buscarFuncionario(matricula);
	}
}
