package br.com.prog3.trab6.MatheusDeAzevedo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

public class AlunoDAOImp implements AlunoDAO {

	@Override
	public String save(Aluno aluno) {
		String sql = "insert into aluno values (?, ?, ?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, aluno.getMatricula());
			pst.setString(2, aluno.getNome());
			pst.setString(3, aluno.getRegiaoAdministrativa());
			if (pst.executeUpdate() > 0)
				return "Inserido com sucesso.";
			else
				return "Erro do inserir.";
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String delete(int matricula) {
		String sql = "delete from aluno where matricula=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, matricula);
			if (pst.executeUpdate() > 0)
				return "Excluído com sucesso.";
			else
				return "Erro ao excluir.";
		} catch (Exception e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String update(Aluno aluno) {
		String sql = "update aluno set nome=?, ra=? where matricula=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getRegiaoAdministrativa());
			pst.setInt(3, aluno.getMatricula());
			if (pst.executeUpdate() > 0)
				return "Alterado com sucesso.";
			else
				return "Erro ao alterar.";
		} catch (Exception e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Aluno> list() {
		List<Aluno> lista = new ArrayList<>();
		String sql = "select * from aluno";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					lista.add(new Aluno(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			} else {
				lista = null;
			}
		} catch (SQLException e) {
			lista = null;
		} finally {
			ConnectionFactory.close(con);
		}
		return lista;
	}

	@Override
	public Aluno findByMatricula(int matricula) {
		String sql = "select * from aluno where matricula=?";
		Aluno aluno = new Aluno();
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, matricula);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				aluno.setMatricula(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setRegiaoAdministrativa(rs.getString(3));
			} else {
				aluno = null;
			}
		} catch (SQLException e) {
			aluno = null;
		} finally {
			ConnectionFactory.close(con);
		}
		return aluno;
	}

}