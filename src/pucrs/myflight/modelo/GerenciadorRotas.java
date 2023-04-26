package pucrs.myflight.modelo;
import java.util.ArrayList;
import java.util.Collections;
public class GerenciadorRotas {
    private ArrayList<Rota> rotas;

    public GerenciadorRotas() {
        rotas = new ArrayList<>();
    }

    public void adicionar(Rota rota) {
        rotas.add(rota);
    }

    public ArrayList<Rota> listarTodas() {
        return rotas;
    }

    public void ordenarPorNomeCia() {
        Collections.sort(rotas);
    }

    public ArrayList<Rota> buscarPorOrigem(Aeroporto origem) {
        ArrayList<Rota> aux = new ArrayList<>();
        for (Rota r : rotas) {
            if (r.getOrigem().equals(origem))
                aux.add(r);
        }
        return aux;
    }
}
