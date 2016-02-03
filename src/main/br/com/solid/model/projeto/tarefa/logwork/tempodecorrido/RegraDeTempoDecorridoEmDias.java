package main.br.com.solid.model.projeto.tarefa.logwork.tempodecorrido;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.temporal.ChronoUnit;

public class RegraDeTempoDecorridoEmDias extends RegraDeCalculoDeTempoDecorrido {

	@Override
	protected ChronoUnit getChronoUnit() {
		return DAYS;
	}

}
