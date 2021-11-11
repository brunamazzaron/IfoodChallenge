package br.com.fiap.testes;

import java.util.Calendar;
import java.util.List;
import br.com.fiap.restaurante.bean.Restaurante;
import br.com.fiap.restaurante.dao.RestauranteDAO;
import br.com.fiap.restaurante.exception.DBException;
import br.com.fiap.restaurante.factory.DAOFactory;

public class RestauranteDAOteste {
	public static void main(String[] args) {
		RestauranteDAO dao = DAOFactory.getProdutoDAO();
		
		Restaurante restaurante = new Restaurante(0,"Tasty","20",Calendar.getInstance(),"100");
		try {
			dao.cadastrar(restaurante);
			System.out.println("restaurante cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		restaurante = dao.buscar(1);
		restaurante.setNome("Chau");
		restaurante.setCnpj("12.121.121/0001-11");
		try {
			dao.atualizar(restaurante);
			System.out.println("restaurante atualizado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		List<Restaurante> lista = dao.listar();
		for (Restaurante item : lista) {
			System.out.println(item.getNome() + " " + item.getCnpj() + " " + item.getCategoria());
		}
		
		try {
			dao.remover(1);
			System.out.println("restaurante removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}	
	}	
}