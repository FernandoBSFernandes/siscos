package br.com.softwareservice.dao;

import br.com.softwareservice.entidades.Cliente;

public class ClienteFacade implements ICliente {

	@Override
	public Cliente buscarCliente(String cpf) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.buscarCliente(cpf);
	}

}
