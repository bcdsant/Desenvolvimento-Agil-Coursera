package br.com.coursera.logica;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.modelo.Traduzir;

public class TraduzirLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String fraseASerTraduzida = request.getParameter("traduzir");
		String fraseTraduzida = "";
		String caminho;

		try {
			String caminhoDoProjeto = request.getSession().getServletContext().getRealPath("/");
			String caminhoDoDicionario = caminhoDoProjeto + "/WEB-INF/resources/palavras_ptbr_eng.txt";
			System.out.println(caminhoDoDicionario);
			caminho = new File(caminhoDoDicionario).getCanonicalPath();
			Traduzir tradutor = new Traduzir(caminho);
			fraseTraduzida = tradutor.fazerTraducao(fraseASerTraduzida);
		} catch (IOException e) {
			e.printStackTrace();
		}

		request.setAttribute("traduzir", fraseASerTraduzida);
		request.setAttribute("traducao", fraseTraduzida);
		return "index.jsp";
	}

}
