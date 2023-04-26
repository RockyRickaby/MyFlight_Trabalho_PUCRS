package pucrs.myflight.modelo;

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
}
