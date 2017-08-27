package br.com.coursera.main;

import java.util.List;

import br.com.coursera.Comparador;
import br.com.coursera.Diferenca;
import br.com.coursera.Pessoa;

public class App {

	public static void main(String[] args) throws Exception{
		Pessoa p1 = new Pessoa("Eduardo", "Guerra","Pesquisador", 36);
		Pessoa p2 = new Pessoa("Eduardo", "Guerra","Coordenador", 37);
		
		List<Diferenca> diferencas = Comparador.comparar(p1, p2);

		diferencas.forEach(System.out::println);
		
	}

}
