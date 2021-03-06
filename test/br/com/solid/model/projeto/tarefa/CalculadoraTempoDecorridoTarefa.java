package br.com.solid.model.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.OS;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static main.br.com.solid.model.projeto.tarefa.logwork.tempodecorrido.CalculadoraDeTempoDecorrido.calculaTempoDecorrido;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import main.br.com.solid.model.projeto.tarefa.DetalhesProgressoTarefa;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;
import main.br.com.solid.model.projeto.tarefa.logwork.LogWork;
import main.br.com.solid.model.projeto.tarefa.logwork.LogWorkBuilder;
import main.br.com.solid.model.projeto.tarefa.logwork.tempodecorrido.RegraDeTempoDecorridoEmHoras;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Test;

public class CalculadoraTempoDecorridoTarefa {

	@Test
	public void calcula_tempo_decorrido_tarefa_dentro_do_estimado() {
		Tarefa os = criaTarefaOsPadrao();

		LogWork log = LogWorkBuilder.builder()
				.usuario(criaUsuarioPadrao())
				.iniciouEm(LocalDateTime.of(2016, JANUARY, 1, 9, 00))
				.finalizouEm(LocalDateTime.of(2016, JANUARY, 1, 12, 00)).build();
		
		DetalhesProgressoTarefa detalhesProgressoTarefa = os.getDetalhesProgressoTarefa();
		
		detalhesProgressoTarefa.adicionaLogWork(log);
		
		assertThat(detalhesProgressoTarefa.getLogsWorks(), hasSize(1));
		assertThat(calculaTempoDecorrido(detalhesProgressoTarefa.getLogsWorks(), new RegraDeTempoDecorridoEmHoras()), equalTo(10800l));
	}

	private Tarefa criaTarefaOsPadrao() {
		Tarefa tarefa = TarefaBuilder.builder().titulo("Bug!")
				.comDescricao("Bug a ser corrigido!").comEstimativa(UM_DIA)
				.comPrevisaoDeInicioEm(LocalDate.of(2016, JANUARY, 29))
				.comCategoria(OS).build();
		return tarefa;
	}

	private Usuario criaUsuarioPadrao() {
		return UsuarioBuilder.builder().nomeCompleto("Leandro Nishijima")
				.usuario("leandro.nishijima").senha("123teste")
				.email("leandro@email.com").cargo(DESENVOLVEDOR).build();
	}

}
