import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/PesquisaCategoria")
public class PesquisaCategoria extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		BancoDAO bibDAO = new BancoDAO();
		categorias = bibDAO.pesquisarCategoria();
	
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
								+"<li><a href='Relatorio' style='border-right:0'>Relat�rio</a></li>"
							+"</ul>"
						+"</nav>"
						+"<header id='cabecalho'>"
							+"<hgroup style='text-align: center'>"
								+"<h1>Gerenciador de bibliotecas</h1>"
							+"</hgroup>"	
						+"</header>"
						+"<table style='border: 1px solid black'>"
						+"<caption>Pesquisa de Categorias</caption>"
						+"<tr style='border: 1px solid black'>"
						+"<th style='border: 1px solid black'>ID</th>"
						+"<th style='border: 1px solid black'>Descri��o</th>"
						+"<th style='border: 1px solid black'>Ajustes</th>");
		for(Categoria c : categorias){
			out.println("<tr><td style='border: 1px solid black'>"+c.getId()+"</td>"
						+"<td style='border: 1px solid black'>"+c.getDescricao()+"</td>"
						+"<td style='border: 1px solid black'>"
						+ "<form action='ExcluiCategoria'><input style='opacity:0' name='exclui' value='"+c.getId()+"'><input style='position:relative; left:-170px' type='submit' value='Deleta'></input></form></td></tr>");
		}
		out.println("</tr>"
					+"</table>"
					+"<footer id='rodape'>"
						+"<h2>Por Thor Haubert</h2>" 
					+"</footer>"		
				+"</div>"
				+"</body>");
					
	}
}