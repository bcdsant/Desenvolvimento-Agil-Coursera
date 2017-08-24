package br.com.coursera.modelo;

import java.util.ArrayList;
import java.util.List;

public class Oraculo {

	public Oraculo() {

	}
	
	public List<String> melhoresProdutos(String tipo){
		List<String> listaDeProdutos = new ArrayList<String>();
		
		if(tipo.equals("doce de leite")) {
			listaDeProdutos.add("Viçosa");
			listaDeProdutos.add("Boreal");
		}
		
		if(tipo.equals("queijo mineiro")) {
			listaDeProdutos.add("Candido Tostes");
			listaDeProdutos.add("Humaitá");
		}
		
		return listaDeProdutos;
	}

}
