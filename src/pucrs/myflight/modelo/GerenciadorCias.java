package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
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
		Path path = Paths.get("airlines.dat");
		BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line).useDelimiter(";");
			String cod = sc.next(), nome = sc.next();
			this.adicionar(new CiaAerea(cod, nome));
			sc.close();
		}
	}
}
