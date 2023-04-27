package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Status status;
	
	public Voo(LocalDateTime dh) {
		this.datahora = dh;
		this.status = Status.CONFIRMADO; // default é confirmado
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}

	public abstract Duration getDuracao();

	public abstract Rota getRota();
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}
}
