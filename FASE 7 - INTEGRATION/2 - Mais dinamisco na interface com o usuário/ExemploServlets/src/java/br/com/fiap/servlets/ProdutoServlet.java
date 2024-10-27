package br.com.fiap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/produto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		System.out.println("Código: " + codigo);
		
		request.setAttribute("cod", codigo);
		request.setAttribute("nome", "Caneta Vermelha");
		request.getRequestDispatcher("busca-produto.jsp").forward(request, response);
	}
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar os parâmetros do formulário HTML
    	String nome = request.getParameter("nome");
    	int qtd = Integer.parseInt(request.getParameter("quantidade"));
    	double valor = Double.parseDouble(request.getParameter("valor"));
    	
    	//Exibe os valores no console do eclipse
    	System.out.println(nome + " " + qtd + " " + valor);
    	
    	//Adiciona atributos no request para exibir na página
    	request.setAttribute("nomeProduto", nome);
    	request.setAttribute("quantidade", qtd);
    	request.setAttribute("valorProduto", valor);
    	
    	request.getRequestDispatcher("sucesso.jsp").forward(request, response);
	}
}