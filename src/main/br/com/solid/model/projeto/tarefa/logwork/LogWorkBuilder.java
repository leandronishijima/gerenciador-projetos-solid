package main.br.com.solid.model.projeto.tarefa.logwork;

import java.time.LocalDateTime;

import main.br.com.solid.model.usuario.Usuario;

public class LogWorkBuilder {
	
	private LogWork log;
	
	private LogWorkBuilder() {
		log = new LogWork();
	}
	
	public static LogWorkBuilder builder() {
		return new LogWorkBuilder();
	}
	
	public LogWorkBuilder usuario(Usuario usuario) {
		log.setUsuario(usuario);
		return this;
	}
	
	public LogWorkBuilder iniciouEm(LocalDateTime inicio) {
		log.setHoraInicio(inicio);
		return this;
	}
	
	public LogWorkBuilder finalizouEm(LocalDateTime fim) {
		log.setHoraFim(fim);
		return this;
	}
	
	public LogWork build() {
		return log;
	}

}
