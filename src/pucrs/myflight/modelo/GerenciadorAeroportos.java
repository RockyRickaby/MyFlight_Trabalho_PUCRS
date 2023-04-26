package pucrs.myflight.modelo;
import java.util.ArrayList;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() {
        aeroportos = new ArrayList<>();
    }

    public void adicionar(Aeroporto aero) {
        aeroportos.add(aero);
    }

    public ArrayList<Aeroporto> listarTodos() {
        return aeroportos;
    }

    public Aeroporto buscarPorCodigo(String cod) {
        for (Aeroporto p : aeroportos) {
            if (p.getCodigo().equals(cod))
                return p;
        }
        return null;
    }
}
