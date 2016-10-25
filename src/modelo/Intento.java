package modelo;

import java.util.Date;

public class Intento {
	private int numeroIntroducido;
	private Date fechaHora;
	public Intento(int numeroIntroducido, Date fechaHora) {
		super();
		this.numeroIntroducido = numeroIntroducido;
		this.fechaHora = fechaHora;
	}
	public int getNumeroIntroducido() {
		return numeroIntroducido;
	}
	public void setNumeroIntroducido(int numeroIntroducido) {
		this.numeroIntroducido = numeroIntroducido;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
}

