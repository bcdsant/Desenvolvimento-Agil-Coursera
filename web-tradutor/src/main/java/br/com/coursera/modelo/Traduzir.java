package br.com.coursera.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Traduzir {
	
	private List<String> palavras_pt_br = new ArrayList<>();
	private List<String> palavras_eng = new ArrayList<>();
	private List<String> palavrasParaTraducao;
	private FileReader fileReader;
	private String caminho;
	
	
	public Traduzir(String caminho) {
		 this.caminho = caminho;
	}

	public String fazerTraducao(String palavra)  throws IOException{
		inicializar();
		
		palavrasParaTraducao = Arrays.asList(palavra.split("(, )|( )+"));

		return traduzirFrase(palavrasParaTraducao);
		
	}
	
	private String traduzirFrase(List<String> palavrasParaTraducao) {
		String frase = "";
		int index=1;
		for(String palavra:palavrasParaTraducao) {
			if(palavrasParaTraducao.size()>1 && index!=palavrasParaTraducao.size()) {
				frase += traduzir(palavra) + ", ";
			}else {
				frase += traduzir(palavra);
			}
			index++;
		}
		return frase;
	}

	private String traduzir(String palavra) {
		if(palavras_eng.contains(palavra))
			return palavras_pt_br.get(palavras_eng.indexOf(palavra));
		if(palavras_pt_br.contains(palavra))
			return palavras_eng.get(palavras_pt_br.indexOf(palavra));
		return palavra;
	}
	
	private void inicializar()  throws IOException{
		fileReader = new FileReader(caminho);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linhaAtual;
		
		while((linhaAtual = bufferedReader.readLine()) != null) {
			palavras_pt_br.add(linhaAtual.split(" ")[0]);
			try {
				palavras_eng.add(linhaAtual.split(" ")[1]);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
