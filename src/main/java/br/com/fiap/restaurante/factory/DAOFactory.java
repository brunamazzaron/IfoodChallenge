package br.com.fiap.restaurante.factory;

import br.com.fiap.restaurante.dao.RestauranteDAO;
import br.com.fiap.restaurante.dao.impl.OracleRestauranteDAO;

public class DAOFactory {

	public static RestauranteDAO getProdutoDAO() {
		return new OracleRestauranteDAO();
	}
	
}