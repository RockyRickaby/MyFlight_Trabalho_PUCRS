package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo {
    private Rota rotaFinal;

    public VooEscalas(Rota r1, Rota r2, LocalDateTime dh, Duration dur) {
        super(r1, dh, dur);
        rotaFinal = r2;
    }

    public Rota getRotaFinal() {
        return rotaFinal;
    }
}
