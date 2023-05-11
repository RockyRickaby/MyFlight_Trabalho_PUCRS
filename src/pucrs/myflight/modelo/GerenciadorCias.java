package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	private static GerenciadorCias instance = null;
	
	private GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public static GerenciadorCias getInstance() {
		if (instance == null)
			instance = new GerenciadorCias();
		return instance;
	}

	public void adicionar(CiaAerea cia) {
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {
		return empresas;
	}

	public CiaAerea buscarCodigo(String cod) {
		for (CiaAerea e : empresas) {
			if (e.getCodigo().equals(cod)) {
				return e;
			}
		}
		return null;
	}

	public CiaAerea buscarNome(String cod) {
		for (CiaAerea e : empresas) {
			if (e.getNome().equals(cod))
				return e;
		}
		return null;
	}

	public void carregaDados() throws IOException {
		Path path = Paths.get("src/pucrs/myflight/dados/airlines.dat");
		BufferedReader br = Files.newBufferedReader(path, Charset.forName("utf8"));
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String[] aux = line.split(";", 2);
			this.adicionar(new CiaAerea(aux[0], aux[1]));
		}
	}
}
