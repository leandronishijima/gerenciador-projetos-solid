package main.br.com.solid.model.projeto.tarefa.logwork;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.concurrent.TimeUnit.HOURS;

import java.util.List;

public class CalculadoraDeTempoDecorrido {
	
	private List<LogWork> logs;

	private CalculadoraDeTempoDecorrido(List<LogWork> logs) {
		this.logs = logs;
	}
	
	public static long horasDecorridas(List<LogWork> logs) {
		return new CalculadoraDeTempoDecorrido(logs).calculaHorasDecorridas();
	}
	
	private long calculaHorasDecorridas() {
		return HOURS.toMinutes(logs.stream()
				.mapToLong(log -> log.getHoraInicio().until(log.getHoraFim(), MINUTES)).sum());
	}

}
