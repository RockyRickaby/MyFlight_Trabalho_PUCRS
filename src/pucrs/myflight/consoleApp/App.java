package pucrs.myflight.consoleApp;
import java.io.IOException;
import java.time.LocalDateTime;

import pucrs.myflight.modelo.*;
public class App {

	public static void main(String[] args) {
		System.out.println("\nMyFlight project...");
		CiaAerea cia = new CiaAerea(null, null);
		Geo loc1 = new Geo(35.683333, 139.766667);
		Geo loc2 = new Geo(41.881944, -87.627778);
		System.out.printf("%s\n", loc1.distancia(loc2));
		Aeroporto origem = new Aeroporto(null, null, loc1);
		Aeroporto destino = new Aeroporto(null, null, loc2);
		Aeronave av = new Aeronave(null, null);
		Rota rota = new Rota(cia, origem, destino, av);
		Rota rota2 = new Rota(cia, destino, origem, av);
		VooDireto voo = new VooDireto(LocalDateTime.now(),  rota);
		VooEscalas voos = new VooEscalas(LocalDateTime.now());
		voos.adicionarRota(rota);
		voos.adicionarRota(rota2);
		System.out.printf("%s\n%s\n\n", voo.getDuracao(), voos.getDuracao());

		GerenciadorCias ger = new GerenciadorCias();
		try {
			ger.carregaDados();
		}
		catch (IOException e) {
			System.out.println("Oops!");
		}
		ger.listarTodas().forEach(System.out::println);
	}
}
