package main.br.com.solid.model.projeto.tarefa.logwork;

import java.time.LocalDateTime;

import main.br.com.solid.model.usuario.Usuario;

public class LogWork {

	private LocalDateTime horaInicio;
	private LocalDateTime horaFim;
	private Usuario usuario;

	protected LogWork() {}
	
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	
	public LocalDateTime getHoraFim() {
		return horaFim;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFim(LocalDateTime horaFim) {
		this.horaFim = horaFim;
	}

	protected void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
