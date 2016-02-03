package main.br.com.solid.model.projeto.tarefa;

import java.time.LocalDateTime;

import main.br.com.solid.model.usuario.Usuario;

public class LogWork {

	private LocalDateTime horaInicio;
	private LocalDateTime horaFim;
	private Usuario usuario;

	public LogWork(Usuario usuario, LocalDateTime horaInicio, LocalDateTime horaFim) {
		this.usuario = usuario;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	
	public LocalDateTime getHoraFim() {
		return horaFim;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
