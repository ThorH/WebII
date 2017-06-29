
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
@WebServlet("/AlteraLivro")
public class AlteraLivro extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String editora = request.getParameter("editora");
		String valor = request.getParameter("valor");
		String situacao = request.getParameter("situacao");
		String idbiblioteca = request.getParameter("idbiblioteca");
		String idcategoria = request.getParameter("idcategoria");
		
		Livro liv = new Livro();
		
		liv.setId(id);
		liv.setTitulo(titulo);
		liv.setEditora(editora);
		liv.setValor(valor);
		liv.setSituacao(situacao);
		liv.setIdbiblioteca(idbiblioteca);
		liv.setIdcategoria(idcategoria);
		
		BancoDAO livDAO = new BancoDAO();
		
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
						+"</header>");
						boolean verifica = livDAO.verificaBiblioteca(idbiblioteca);
						boolean verificacat = livDAO.verificaCategoria(idcategoria);
						if(verifica==true){
							if(verificacat==true){
								livDAO.alteraLivro(liv);
								out.println("<h1>Sua atualização foi atendida!</h1>");
							} else {
								out.println("<h1>O id da categoria nao foi encontrado, Faça uma busca por seu nome para saber seu id!</h1>");
								
							}
						} else {
							out.println("<h1>O id da biblioteca nao foi encontrado, Faça uma busca por seu nome para saber seu id!</h1>");
							
						}
						out.println("<footer id='rodape'>"
							+"<h2>Por Thor Haubert</h2>" 
						+"</footer>"		
					+"</div>"
				+"</body>");
					
	}

}