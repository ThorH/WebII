import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BancoDAO {

	private Connection con = Conexao.getConnection();
	
	public void cadastrarAluno (Aluno aluno){
		String sql = "INSERT INTO aluno (nome, endereco, situacao) values (?,?,?)";
		
		try {
		
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, aluno.getNome());
			preparador.setString(2, aluno.getEndereco());
			preparador.setString(3, aluno.getSituacao());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Dados cadastrados!");
			
		} catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
	}
	public void cadastrarBiblioteca (Biblioteca biblioteca){
		String sql = "INSERT INTO biblioteca (nome, endereco) values (?,?)";
		
		try {
		
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, biblioteca.getNome());
			preparador.setString(2, biblioteca.getEndereco());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Dados cadastrados!");
			
		} catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
	}
	
	public void cadastrarCategoria (Categoria categoria){
		String sql = "INSERT INTO categoria (descricao) values (?)";
		
		try {
		
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, categoria.getDescricao());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Dados cadastrados!");
			
		} catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
	}
	
	public void pesquisarAluno (Aluno aluno) {

		String sql = "SELECT * FROM aluno WHERE nome=?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, aluno.getNome());
			
			ResultSet rs = preparador.executeQuery();

			while(rs.next()) {
				aluno.setId(rs.getString("codmatricula"));
			    aluno.setNome(rs.getString("nome"));
			    aluno.setEndereco(rs.getString("endereco"));
			    aluno.setSituacao(rs.getString("situacao"));
			}
			
		}

		catch (SQLException se) {
			se.printStackTrace();
		}
	
		
	}
	
	public void pesquisarBiblioteca (Biblioteca biblioteca) {

		String sql = "SELECT * FROM biblioteca WHERE nome=?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, biblioteca.getNome());
			
			ResultSet rs = preparador.executeQuery();

			while(rs.next()) {
				biblioteca.setId(rs.getString("codbib"));
			    biblioteca.setNome(rs.getString("nome"));
			    biblioteca.setEndereco(rs.getString("endereco"));
			}
			
		}

		catch (SQLException se) {
			se.printStackTrace();
		}
	
		
	}
	

}