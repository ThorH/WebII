
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/AlteraBiblioteca")
public class AlteraBiblioteca extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		
		Biblioteca bib = new Biblioteca();
		
		bib.setId(id);
		bib.setNome(nome);
		bib.setEndereco(endereco);
		
		BancoDAO bibDAO = new BancoDAO();
		
		bibDAO.alteraBiblioteca(bib);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>"
				+"<head>"
				+"<meta charset='ISO-8859-1'>"
				+"<link rel='shortcut icon' href='Imagens/bibliotecaicone.png' type='image/png'>"
				+"<title>Biblioteca</title>"
				+"<head>"
				+"<meta charset='ISO-8859-1'>"
				+"<link rel='shortcut icon' href='Imagens/bibliotecaicone.png' type='image/png'>"
				+"<title>Biblioteca</title>"
				+"<link rel='stylesheet' type='text/css' href='Estilo.css'/>"
				+"</head>"
				+"<body>"
					+"<div id='interface' >"
						+"<nav>"
							+"<ul>"
								+"<li><a href='Home.html'>Home</a></li>"
								+"<li><a href=''>Cadastro</a>"
									+"<ul>"
										+"<li><a href='CadastroAluno.html'>Alunos</a></li>"
										+"<li><a href='CadastroBiblioteca.html'>Biblioteca</a></li>"
										+"<li><a href='CadastroCategoria.html'>Categoria</a></li>"
										+"<li><a href='CadastroFuncionario.html'>Funcionario</a></li>"
										+"<li><a href='CadastroLivro.html'>Livro</a></li>"
									+"</ul>"
								+"</li>"
								+"<li><a href=''>Pesquisa</a>"
									+"<ul>"
										+"<li><a href='PesquisaAluno'>Alunos</a></li>"
										+"<li><a href='PesquisaBiblioteca'>Biblioteca</a></li>"
										+"<li><a href='PesquisaCategoria'>Categoria</a></li>"
										+"<li><a href='PesquisaFuncionario'>Funcionario</a></li>"
										+"<li><a href='PesquisaLivro'>Livro</a></li>"
									+"</ul>"
								+"</li>"
								+"<li><a href='Emprestimo.html'>Emprestimo</a></li>"
								+"<li><a href='Relatorio' style='border-right:0'>Relatório</a></li>"
							+"</ul>"
						+"</nav>"
						+"<header id='cabecalho'>"
							+"<hgroup style='text-align: center'>"
								+"<h1>Gerenciador de bibliotecas</h1>"
							+"</hgroup>"	
						+"</header>"			
						+"<h1>Sua atualização foi atendida!</h1>"
						+"<footer id='rodape'>"
							+"<h2>Por Thor Haubert</h2>" 
						+"</footer>"		
					+"</div>"
				+"</body>");
					
	}

}