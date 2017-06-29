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
@WebServlet("/Empresta")
public class Empresta extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idmatricula = request.getParameter("idmatricula");
		String idlivro = request.getParameter("idlivro");
		String diaretirada = request.getParameter("diaretirada");
		String mesretirada = request.getParameter("mesretirada");
		String anoretirada = request.getParameter("anoretirada");
		String diaprevisto = request.getParameter("diaprevisto");
		String dataretirada = anoretirada+"-"+mesretirada+"-"+diaretirada;
		String dataprevisto = anoretirada+"-"+mesretirada+"-"+diaprevisto;
		
		int diaretiradaint = Integer.parseInt(diaretirada);
		int diaprevistoint = Integer.parseInt(diaprevisto);
		int max = diaretiradaint+14;
		
		BancoDAO empDAO = new BancoDAO();
		
		
		Emprestimo emp = new Emprestimo();
		
		emp.setIdmatricula(idmatricula);
		emp.setIdlivro(idlivro);
		emp.setDataprevisao(dataprevisto);
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
						boolean verifica = empDAO.verificaLivro(idlivro);
						boolean verificaalu = empDAO.verificaAluno(idmatricula);
						String verificasitalu = empDAO.verificaSituacaoAluno(idmatricula);
						String verificasitliv = empDAO.verificaSituacaoLivro(idlivro);
						if(verifica==true){
							if(verificaalu==true){
								if(verificasitalu.equals("Ativo")){
									if(verificasitliv.equals("Disponivel")){
										if(diaprevistoint==max){
											empDAO.empresta(emp, idlivro, idmatricula);
											out.println("<h1>Sua atualização foi atendida!</h1>");
										} else {
											out.println("<h1>O tempo previsto nao respeita o prazo de 10 dias(sem contar Sabado e Domingo) !</h1>");
											
										}
										
									} else {
										out.println("<h1>O livro está indisponivel atualmente!</h1>");
										
									}
								} else {
									out.println("<h1>O aluno está inativo atualmente!</h1>");
									
								}
							} else {
								out.println("<h1>O id do aluno nao foi encontrado, Faça uma busca por seu nome para saber seu id!</h1>");
						
							}
						} else {
							out.println("<h1>O id do livro nao foi encontrado, Faça uma busca por seu nome para saber seu id!</h1>");
					
						}
				out.println("<footer id='rodape'>"
					+"<h2>Por Thor Haubert</h2>" 
						+"</footer>"		
					+"</div>"
				+"</body>");
	}
}