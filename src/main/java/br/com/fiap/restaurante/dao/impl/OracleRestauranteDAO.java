package br.com.fiap.restaurante.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.restaurante.bean.Restaurante;
import br.com.fiap.restaurante.dao.RestauranteDAO;
import br.com.fiap.restaurante.exception.DBException;
import br.com.fiap.restaurante.singleton.ConnectionManager;

public class OracleRestauranteDAO implements RestauranteDAO {

	private Connection conexao;
	
	public void cadastrar(Restaurante restaurante) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "INSERT INTO TB_RESTAURANTE (ID_RESTAURANTE, NM_RESTAURANTE, NM_CNPJ, DT_INAUGURACAO, CAT_RESTAURANTE) VALUES (SQ_TB_PRODUTO.NEXTVAL, ?, ?, ?, ?)";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, restaurante.getNome());
				stmt.setString(2, restaurante.getCnpj());
				stmt.setString(3, restaurante.getCategoria());
				java.sql.Date data = new java.sql.Date(restaurante.getdataInauguracao().getTimeInMillis());
				stmt.setDate(4, data);

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Erro ao cadastradar.");
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	public void atualizar(Restaurante restaurante) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "UPDATE TB_RESTAURANTE SET NM_RESTAURANTE = ?, NM_CNPJ = ?, CAT_RESTAURANTE = ?, DT_INAUGURACAO = ? WHERE ID_RESTAURANTE = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, restaurante.getNome());
				stmt.setString(2, restaurante.getCnpj());
				stmt.setString(3, restaurante.getCategoria());
				java.sql.Date data = new java.sql.Date(restaurante.getdataInauguracao().getTimeInMillis());
				stmt.setDate(4, data);
				stmt.setInt(5, restaurante.getCodigo());

				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Erro ao atualizar.");
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	public void remover(int codigo) throws DBException {
				PreparedStatement stmt = null;

				try {
					conexao = ConnectionManager.getInstance().getConnection();
					String sql = "DELETE FROM TB_RESTAURANTE WHERE ID_RESTAURANTE = ?";
					stmt = conexao.prepareStatement(sql);
					stmt.setInt(1, codigo);
					stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DBException("Erro ao remover.");
				} finally {
					try {
						stmt.close();
						conexao.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}

	public Restaurante buscar(int id) {
		Restaurante restaurante = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conexao = ConnectionManager.getInstance().getConnection();
				stmt = conexao.prepareStatement("SELECT * FROM TB_RESTAURANTE WHERE ID_RESTAURANTE = ?");
				stmt.setInt(1, id);
				rs = stmt.executeQuery();

				if (rs.next()){
					int codigo = rs.getInt("ID_RESTAURANTE");
					String nome = rs.getString("NM_RESTAURANTE");
					String cnpj = rs.getString("NM_CNPJ");
					String categoria = rs.getString("CAT_RESTAURANTE");
					java.sql.Date data = rs.getDate("DT_INAUGURACAO");
					Calendar dataInauguracao = Calendar.getInstance();
					dataInauguracao.setTimeInMillis(data.getTime());
					
					restaurante = new Restaurante(codigo, nome, cnpj, dataInauguracao, categoria);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					rs.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return restaurante;
       }
     
	public List<Restaurante> listar() {
			List<Restaurante> lista = new ArrayList<Restaurante>();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conexao = ConnectionManager.getInstance().getConnection();
				stmt = conexao.prepareStatement("SELECT * FROM TB_RESTAURANTE");
				rs = stmt.executeQuery();

				while (rs.next()) {
					int codigo = rs.getInt("ID_RESTAURANTE");
					String nome = rs.getString("NM_RESTAURANTE");
					String cnpj = rs.getString("NM_CNPJ");
					String categoria = rs.getString("CAT_RESTAURANTE");
					java.sql.Date data = rs.getDate("DT_INAUGURACAO");
					Calendar dataInauguracao = Calendar.getInstance();
					dataInauguracao.setTimeInMillis(data.getTime());
					
					Restaurante restaurante =  new Restaurante(codigo, nome, cnpj, dataInauguracao, categoria);
					lista.add(restaurante);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					rs.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return lista;
		}
	}