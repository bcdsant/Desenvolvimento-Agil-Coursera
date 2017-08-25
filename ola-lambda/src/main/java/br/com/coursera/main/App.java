package br.com.coursera.main;

import java.util.ArrayList;
import java.util.List;

import br.com.coursera.Carrinho;
import br.com.coursera.Produto;

public class App {

	public static void main(String[] args) {
		List<Produto> lista = new ArrayList<Produto>();
		int desconto = 10;
		
		lista.add(new Produto("Tenis", 300));
		lista.add(new Produto("Camiseta", 80));
		lista.add(new Produto("Cinto", 50));

		Carrinho c = new Carrinho(lista);
		c.darDesconto(desconto, p->p.getValor()>100);
		c.getLista().forEach(System.out::println);
	}

}
