package br.com.fiap.restaurante.dao;

import java.util.List;

import br.com.fiap.restaurante.bean.Restaurante;
import br.com.fiap.restaurante.exception.DBException;

public interface RestauranteDAO {
	
	void cadastrar(Restaurante restaurante) throws DBException;
	void atualizar(Restaurante restaurante) throws DBException;
	void remover(int codigo) throws DBException;
	Restaurante buscar(int id);
	List<Restaurante> listar();
}