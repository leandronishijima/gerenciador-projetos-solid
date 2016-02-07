package main.br.com.solid.model.projeto.tarefa;

import static java.util.Collections.unmodifiableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.logwork.LogWork;

public class DetalhesProgressoTarefa {
	
	private LocalDate inicioPrevisto;
	private LocalDate fimPrevisto;
	private Estimativa estimativa;
	private List<LogWork> logsWorks;
	
	public DetalhesProgressoTarefa() {
		this.logsWorks = new ArrayList<LogWork>();
	}
	
	public LocalDate getFimPrevisto() {
		return fimPrevisto;
	}

	public void setFimPrevisto(LocalDate fimPrevisto) {
		this.fimPrevisto = fimPrevisto;
	}

	public LocalDate getInicioPrevisto() {
		return inicioPrevisto;
	}

	public void setInicioPrevisto(LocalDate inicioPrevisto) {
		this.inicioPrevisto = inicioPrevisto;
	}

	public Estimativa getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(Estimativa estimativa) {
		this.estimativa = estimativa;
	}
	
	public void adicionaLogWork(LogWork logWork) {
		logsWorks.add(logWork);
	}

	public List<LogWork> getLogsWorks() {
		return unmodifiableList(logsWorks);
	}

}
