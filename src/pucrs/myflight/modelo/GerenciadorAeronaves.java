package pucrs.myflight.modelo;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;
    private static GerenciadorAeronaves instance = null;

    private GerenciadorAeronaves() {
        aeronaves = new ArrayList<>();
    }

    public static GerenciadorAeronaves getInstance() {
        if (instance == null)
            instance = new GerenciadorAeronaves();
        return instance;
    }

    public void adicionar(Aeronave aviao) {
        aeronaves.add(aviao);
    }

    public ArrayList<Aeronave> listarTodas() {
        return aeronaves;
    }

    public Aeronave buscarPorCodigo(String cod) {
        for (Aeronave a : aeronaves) {  
            if (a.getCodigo().equals(cod))
                return a;
        }
        return null;
    }

    public void carregaDados() throws IOException {        
        Path path = Paths.get("src/pucrs/myflight/dados/equipment.dat");
        BufferedReader br = Files.newBufferedReader(path, Charset.forName("utf8"));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] aux = line.split(";", 3);
            this.adicionar(new Aeronave(aux[0], aux[1]));
        }
    }
}
