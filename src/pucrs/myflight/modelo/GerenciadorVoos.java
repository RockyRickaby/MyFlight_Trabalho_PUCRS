package pucrs.myflight.modelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    public GerenciadorVoos() {
        voos = new ArrayList<>();
    }

    public void adicionar(Voo voo) {
        voos.add(voo);
    }

    public ArrayList<Voo> listarTodos() {
        return voos;
    }

    public ArrayList<Voo> buscarData(LocalDateTime data) {
        ArrayList<Voo> aux = new ArrayList<>();
        for (Voo v : voos) {
            if (v.getDatahora().equals(data)) {
                aux.add(v);
            }
        }
        return aux;
    }
}
