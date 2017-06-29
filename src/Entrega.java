import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Entrega")
public class Entrega extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idmatricula = request.getParameter("idmatricula");
		String idlivro = request.getParameter("idlivro");
		String diaretirada = request.getParameter("diaretirada");
		String mesretirada = request.getParameter("mesretirada");
		String anoretirada = request.getParameter("anoretirada");
		String diaentrega = request.getParameter("diaentrega");
		String mesentrega = request.getParameter("mesentrega");
		String anoentrega = request.getParameter("anoentrega");
		String dataretirada = anoretirada+"-"+mesretirada+"-"+diaretirada;
		String dataentrega = anoentrega+"-"+mesentrega+"-"+diaentrega;
		
		BancoDAO empDAO = new BancoDAO();
		
		
		Emprestimo emp = new Emprestimo();
		
		emp.setIdlivro(idlivro);
		emp.setIdmatricula(idmatricula);
		emp.setDataentrega(dataentrega);
		emp.setDataretirada(dataretirada);

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
						empDAO.entrega(emp);
								out.println("<h1>Sua entrega foi atendida!</h1>");
									
				out.println("<footer id='rodape'>"
					+"<h2>Por Thor Haubert</h2>" 
						+"</footer>"		
					+"</div>"
				+"</body>");
	}
}