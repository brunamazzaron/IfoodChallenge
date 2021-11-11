package br.com.fiap.restaurante.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.restaurante.bean.Restaurante;
import br.com.fiap.restaurante.dao.RestauranteDAO;
import br.com.fiap.restaurante.exception.DBException;
import br.com.fiap.restaurante.factory.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/restaurante")
public class RestauranteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RestauranteDAO dao;
	
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getProdutoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String nome = request.getParameter("nome");
			String cnpj = request.getParameter("cnpj");
			String categoria =request.getParameter("categoria");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar inauguracao = Calendar.getInstance();
			inauguracao.setTime(format.parse(request.getParameter("inauguração")));
			
			Restaurante restaurante = new Restaurante(0, nome, cnpj, inauguracao, categoria); 
			dao.cadastrar(restaurante);
			
			request.setAttribute("msg", "restaurante cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-restaurante.jsp").forward(request, response);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "listar":
			List<Restaurante> lista = dao.listar();
			request.setAttribute("restaurante", lista);
			request.getRequestDispatcher("lista-restaurante.jsp").forward(request, response);
			break;
		case "abrir-form-edicao":
			int id = Integer.parseInt(request.getParameter("codigo"));
			Restaurante restaurante = dao.buscar(id);
			request.setAttribute("restaurante", restaurante);
			request.getRequestDispatcher("edicao-restaurante.jsp").forward(request, response);
		}	
	}

}