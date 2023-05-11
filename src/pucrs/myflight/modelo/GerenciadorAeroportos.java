package pucrs.myflight.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;
    private static GerenciadorAeroportos instance = null;

    private GerenciadorAeroportos() {
        aeroportos = new ArrayList<>();
    }

    public static GerenciadorAeroportos getInstance() {
        if (instance == null)
            instance = new GerenciadorAeroportos();
        return instance;
    }

    public void adicionar(Aeroporto aero) {
        aeroportos.add(aero);
    }

    public ArrayList<Aeroporto> listarTodos() {
        return aeroportos;
    }

    public void ordenarPorNome() {
        Collections.sort(aeroportos);
    }

    public Aeroporto buscarPorCodigo(String cod) {
        for (Aeroporto p : aeroportos) {
            if (p.getCodigo().equals(cod))
                return p;
        }
        return null;
    }

    public void carregaDados() throws IOException {
        Path path = Paths.get("src/pucrs/myflight/dados/airports.dat");
        BufferedReader br = Files.newBufferedReader(path, Charset.forName("utf8"));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] aux = line.split(";", 5);
            Geo loc = new Geo(Double.parseDouble(aux[1]), Double.parseDouble(aux[2]));
            this.adicionar(new Aeroporto(aux[0], aux[3] + " " + aux[4], loc));
        }
    }
}
