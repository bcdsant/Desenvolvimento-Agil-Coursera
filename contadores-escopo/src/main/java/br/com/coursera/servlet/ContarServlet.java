package br.com.coursera.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.contador.Contador;

@WebServlet("/contar")
public class ContarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request
		if (request.getAttribute("contador") == null) {
			request.setAttribute("contador", new Contador("request"));
		}
		((Contador) request.getAttribute("contador")).contar();
		
		// session
		if (request.getSession().getAttribute("contador") == null) {
			request.getSession().setAttribute("contador", new Contador("session"));
		}
		((Contador) request.getSession().getAttribute("contador")).contar();
		
		// application
		if (getServletContext().getAttribute("contador") == null) {
			getServletContext().setAttribute("contador", new Contador("application"));
		}
		((Contador) getServletContext().getAttribute("contador")).contar();
		
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<head>");
		out.append("<title>Contadores</title>");
		out.append("</head>");
		out.append("<body>");
		out.append("<h1>Contadores: <h1>");
		out.append("<h2>"+request.getAttribute("contador").toString()+"</h2>");
		out.append("<h2>"+request.getSession().getAttribute("contador").toString()+"</h2>");
		out.append("<h2>"+getServletContext().getAttribute("contador").toString()+"</h2>");
		out.append("</body>");
		out.append("</html>");
	}

}
