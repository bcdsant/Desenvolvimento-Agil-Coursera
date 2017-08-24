package br.com.coursera.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.modelo.Oraculo;

@WebServlet("/oraculoController")
public class OraculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// pegar o parâmetro
		String tipoProduto = request.getParameter("produto");

		// chamar a regra de negócios do model
		Oraculo oraculo = new Oraculo();
		List<String> produtos = oraculo.melhoresProdutos(tipoProduto);

		// passar o controle para um view
		request.setAttribute("produtos", produtos);
		request.getRequestDispatcher("resposta.jsp").forward(request, response);

	}
}
