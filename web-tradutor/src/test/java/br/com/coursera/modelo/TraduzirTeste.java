package br.com.coursera.modelo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class TraduzirTeste {
	private Traduzir tradutor;
	private String caminho;

	@Before
	public void inicializa() throws IOException {
		String caminhoDoProjeto = System.getProperty("user.dir");
		caminho = new File(caminhoDoProjeto + "/src/main/webapp/WEB-INF/resources/palavras_ptbr_eng.txt")
				.getCanonicalPath();
		tradutor = new Traduzir(caminho);
	}

	@Test
	public void testeTraduzirUmaPalavraDoDicionario() throws IOException {
		assertEquals("today", tradutor.fazerTraducao("hoje"));
	}

	@Test
	public void testeTraduzieMaisDeUmaPalavraDoDicionario() throws IOException {
		assertEquals("today, tomorrow, yesterday", tradutor.fazerTraducao("hoje amanhã ontem"));
	}

	@Test
	public void traduzirUmaPalavraInexistente() throws IOException {
		assertEquals("cavalo", tradutor.fazerTraducao("cavalo"));
		assertEquals("horse, horse", tradutor.fazerTraducao("horse  horse"));
		assertNotEquals("horse", tradutor.fazerTraducao("cavalo"));
	}

	@Test
	public void simbolosEspeciaisPresentes() throws IOException {
		assertEquals("pai, mãe, sol", tradutor.fazerTraducao("father, mother, sun"));
	}

}
