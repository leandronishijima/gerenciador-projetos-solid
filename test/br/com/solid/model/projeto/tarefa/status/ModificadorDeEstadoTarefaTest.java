package br.com.solid.model.projeto.tarefa.status;

import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isADesenvolver;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isDesenvolvendo;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isEmAnalise;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isImpedida;
import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;
import main.br.com.solid.model.projeto.tarefa.status.ModificadorDeEstadoTarefa;
import main.br.com.solid.model.projeto.tarefa.status.StatusADesenvolver;
import main.br.com.solid.model.projeto.tarefa.status.StatusDesenvolvendo;
import main.br.com.solid.model.projeto.tarefa.status.StatusImpedida;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Before;
import org.junit.Test;

public class ModificadorDeEstadoTarefaTest {
	
	private Tarefa tarefa;

	@Before
	public void criaTarefaBugPadrao() {
		tarefa = TarefaBuilder.builder()
				.titulo("It's a Bug!")
				.comDescricao("Bug a ser corrigido!")
				.comEstimativa(UM_DIA)
				.comPrevisaoDeInicioEm(LocalDate.of(2016, JANUARY, 29))
				.comCategoria(BUG).build();
	}
	
	@Test
	public void testa_mudanca_de_estado_de_em_analise_para_a_desenvolver() {
		assertThat(tarefa, isEmAnalise());
		
		changeToADesenvolver();
		assertThat(tarefa, isADesenvolver());
	}
	
	@Test
	public void testa_mudanca_de_estado_de_a_desenvolver_para_desenvolvendo() {
		changeToADesenvolver();
		
		changeToDesenvolvendo();
	}

	@Test
	public void testa_mudanca_de_estado_de_desenvolvendo_para_impedido() {
		changeToADesenvolver();
		changeToDesenvolvendo();
		
		changeToImpedida();
		
		assertThat(tarefa, isImpedida());
		assertThat(tarefa.getImpedimento().getMotivo(), equalTo("Impedido por motivo de for�a maior!"));
		assertThat(tarefa.getImpedimento().getDataImpedimento(), notNullValue());
	}

	@Test
	public void testa_mudanca_de_estado_de_impedida_para_a_desenvolver() {
		changeToADesenvolver();
		
		changeToDesenvolvendo();
		
		changeToImpedida();
		assertThat(tarefa.getImpedimento().getMotivo(), equalTo("Impedido por motivo de for�a maior!"));
		assertThat(tarefa.getImpedimento().getDataImpedimento(), notNullValue());
		assertThat(tarefa.getImpedimento().getDataRetorno(), nullValue());
		
		changeToADesenvolver();
		assertThat(tarefa.getImpedimento().getDataRetorno(), notNullValue());
	}
	
	private void changeToImpedida() {
		ModificadorDeEstadoTarefa.alteraStatus(tarefa, StatusImpedida.comMotivoEData("Impedido por motivo de for�a maior!", LocalDate.now()));
		assertThat(tarefa, isImpedida());
	}
	
	private void changeToDesenvolvendo() {
		Usuario usuario = criaUsuarioPadrao();
		
		ModificadorDeEstadoTarefa.alteraStatus(tarefa, StatusDesenvolvendo.paraUsuario(usuario));
		
		assertThat(tarefa, isDesenvolvendo());
		assertThat(tarefa.getSubResponsavel1(), equalTo(usuario));
		assertThat(tarefa.getSubResponsavel2(), equalTo(usuario));
	}

	private void changeToADesenvolver() {
		ModificadorDeEstadoTarefa.alteraStatus(tarefa, StatusADesenvolver.instancia());
		assertThat(tarefa, isADesenvolver());
	}
	
	private Usuario criaUsuarioPadrao() {
		return UsuarioBuilder.builder()
				.nomeCompleto("Leandro Nishijima")
				.usuario("leandro.nishijima")
				.senha("123teste")
				.email("leandro@email.com")
				.cargo(DESENVOLVEDOR)
				.build();
	}

}
