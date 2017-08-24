package br.com.coursera.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class ConverterTemperaturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo_conversao = request.getParameter("conversao");
		String medida_entrada, medida_saida;
		int valor_conversao = Integer.parseInt(request.getParameter("valor-a-ser-convertido"));
		int resultado = converterTemperatura(valor_conversao, tipo_conversao);

		if (tipo_conversao.matches("celsius-fahrenheit")) {
			medida_entrada = " °C ";
			medida_saida = " F ";
		} else {
			medida_entrada = " F ";
			medida_saida = " °C ";
		}

		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Resultado da Conversão</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Convertendo " + valor_conversao + medida_entrada + "em" + medida_saida + "</h1>");
			out.println("<h1>Resulado: " + resultado + medida_saida);
			out.println("</body>");
			out.println("</html>");
		}
	}

	private int converterTemperatura(int valor, String tipo) {
		if(tipo.matches("celsius-fahrenheit"))
			return ((valor * 9) / 5) + 32;
		return ((valor - 32) * 5) / 9;
	}
}
