package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {
    private ArrayList<Rota> rotas;

    public VooEscalas(LocalDateTime dh) {
        super(dh);
        rotas = new ArrayList<>();
    }

    public void adicionarRota(Rota rota) {
        rotas.add(rota);
    }

    @Override
    public Duration getDuracao() {
        int decolagemMaisAterrisagem = rotas.size();
        double duration = 0;
        for (Rota r : rotas) {
            duration += Geo.distanciaEntrePontos(r.getOrigem().getLocal(),
                                               r.getDestino().getLocal()) / 805;
        }
        return Duration.ofHours((long) duration + decolagemMaisAterrisagem);
    }

    @Override
    public Rota getRota() {
        return rotas.get(0);
    }
}
