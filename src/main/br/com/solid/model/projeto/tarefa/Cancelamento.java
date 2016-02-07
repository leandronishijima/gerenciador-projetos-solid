package main.br.com.solid.model.projeto.tarefa;

import java.time.LocalDateTime;

public class Cancelamento {
	
	private LocalDateTime dataHoraCancelamento;
	private String motivoCancelamento;
	
	public Cancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
		this.dataHoraCancelamento = LocalDateTime.now();
	}
	
	public String getMotivo() {
		return motivoCancelamento;
	}
	
	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}
	
	public LocalDateTime getDataHoraCancelamento() {
		return dataHoraCancelamento;
	}

}
