package br.com.softwareservice.dao;

public class DAOFacade implements IDAO{

	@Override
	public void salvar(Object entidade) {
		DAOGenerico<Object> dao = new DAOGenerico<Object>();
		dao.salvar(entidade);
	}

	@Override
	public void excluir(Object entidade) {
		DAOGenerico<Object> dao = new DAOGenerico<Object>();
		dao.excluir(entidade);
	}

}
