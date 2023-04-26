package pucrs.myflight.consoleApp;
import pucrs.myflight.modelo.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

//Work in progress... 
public class GerenciadorSistema {
    private GerenciadorAeronaves aeronaves;
    private GerenciadorAeroportos aeroportos;
    private GerenciadorCias empresas;
    private GerenciadorRotas rotas;
    private GerenciadorVoos voos;

    public GerenciadorSistema() {
        this.aeronaves = new GerenciadorAeronaves();
        this.aeroportos = new GerenciadorAeroportos();
        this.empresas = new GerenciadorCias();
        this.rotas = new GerenciadorRotas();
        this.voos = new GerenciadorVoos();
    }

    public void adicionarAeronave(Aeronave aviao) {
        aeronaves.adicionar(aviao);
    }

    public void adicionarAeroporto(Aeroporto porto) {
        aeroportos.adicionar(porto);
    }

    public void adicionarEmpresa(CiaAerea cia) {
        empresas.adicionar(cia);
    }

    public void adicionarRota(Rota rota) {
        rotas.adicionar(rota);
    }

    public void adicionarVoo(Voo voo) {
        voos.adicionar(voo);
    }

    public Aeronave buscarAeronave(String cod) {
        return aeronaves.buscarPorCodigo(cod);
    }

    public Aeroporto buscarAeroporto(String cod) {
        return aeroportos.buscarPorCodigo(cod);
    }

    public CiaAerea buscarEmpresaPorCodigo(String cod) {
        return empresas.buscarCodigo(cod);
    }

    public CiaAerea buscarEmpresaPorNome(String cod) {
        return empresas.buscarNome(cod);
    }

    public ArrayList<Rota> buscarRota(Aeroporto origem) {
        return rotas.buscarPorOrigem(origem);
    }

    public ArrayList<Voo> buscarVoo(LocalDateTime data) {
        return voos.buscarData(data);
    }

    public ArrayList<Aeronave> listarAeronaves() {
        return aeronaves.listarTodas();
    }

    public ArrayList<Aeroporto> listarAeroportos() {
        return aeroportos.listarTodos();
    }

    public ArrayList<CiaAerea> listarEmpresas() {
        return empresas.listarTodas();
    }

    public ArrayList<Rota> listarRotas() {
        return rotas.listarTodas();
    }

    public ArrayList<Voo> listarVoos() {
        return voos.listarTodos();
    }
}