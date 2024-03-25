package br.com.autenticacao.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.autenticacao.model.Usuario;
import br.com.autenticacao.util.ConnectionFactory;

public class UsuarioDAOImpl implements GenericDAO {

	private Connection conn;
	
	public UsuarioDAOImpl() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Object> listarTodos() {
		List<Object> lista = new ArrayList<Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, nome, email, is_ativo FROM usuario";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setisAtivo(rs.getBoolean("is_ativo"));
				lista.add(usuario);
			}
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Usuário! " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
			}
		}

		return lista;
	}

	@Override
	public Object listarPorId(int id) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuario WHERE id = (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
			}

		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar usuario por id! " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}

		return usuario;
	}

	@Override
	public boolean cadastrar(Object object) {
		Usuario usuario = (Usuario) object;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO usuario (nome) VALUES (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao cadastrar usuario " + ex.getMessage());
			ex.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, null);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean alterar(Object object) {
		Usuario usuario = (Usuario) object;
		PreparedStatement stmt = null;
		String sql = "UPDATE usuario SET nome = ? WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Problemas na DAO ao alterar usuario " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, null);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void excluir(int id) {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM usuario WHERE id = (?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (Exception e) {
			System.out.println("Problemas na DAO ao excluir usuario! " + e.getMessage());
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, null);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão! " + e.getMessage());
				e.printStackTrace();
			}
		}
		
	}
	
}
