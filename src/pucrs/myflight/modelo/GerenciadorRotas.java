package pucrs.myflight.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
public class GerenciadorRotas {
    private ArrayList<Rota> rotas;
    private static GerenciadorRotas instance = null;

    private GerenciadorRotas() {
        rotas = new ArrayList<>();
    }

    public static GerenciadorRotas getInstance() {
        if (instance == null)
            instance = new GerenciadorRotas();
        return instance;
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

    public void carregaDados() throws IOException {
        Path path = Paths.get("src/pucrs/myflight/dados/routes.dat");
        BufferedReader br = Files.newBufferedReader(path, Charset.forName("utf8"));
        String line = br.readLine();
        GerenciadorAeronaves naves_temp = GerenciadorAeronaves.getInstance();
        GerenciadorCias cias_temp = GerenciadorCias.getInstance();
        GerenciadorAeroportos portos_temp = GerenciadorAeroportos.getInstance();
        while ((line = br.readLine()) != null) {
            String[] aux = line.split(";", 6);
            CiaAerea cia = cias_temp.buscarCodigo(aux[0]);
            Aeroporto de = portos_temp.buscarPorCodigo(aux[1]);
            Aeroporto para = portos_temp.buscarPorCodigo(aux[2]);
            Aeronave aviao = naves_temp.buscarPorCodigo(aux[5]);
            this.adicionar(new Rota(cia, de, para, aviao));
        }
    }
}
