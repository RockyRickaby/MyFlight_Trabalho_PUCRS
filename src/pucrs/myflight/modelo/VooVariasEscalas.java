package pucrs.myflight.modelo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

//Sinto que foi pobremente implementada...
public class VooVariasEscalas extends Voo {
    private ArrayList<Rota> escalas;

    public VooVariasEscalas(Rota r, LocalDateTime dh, Duration dur) {
        super(r, dh, dur);
        escalas = new ArrayList<>();
    }

    public void adicionarRota(Rota r) {
        escalas.add(r);
    }

    public ArrayList<Rota> getEscalas() {
        return escalas;
    }
}
