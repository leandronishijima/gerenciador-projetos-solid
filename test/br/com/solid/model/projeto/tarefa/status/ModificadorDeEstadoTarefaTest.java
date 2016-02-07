package br.com.solid.model.projeto.tarefa.status;

import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isADesenvolver;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isAguardandotestes;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isDesenvolvendo;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isEmAnalise;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isEmTestes;
import static br.com.solid.model.projeto.tarefa.status.TarefaStatusMatchers.isImpedida;
import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static main.br.com.solid.model.usuario.Cargo.TESTER;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;
import main.br.com.solid.model.projeto.tarefa.status.ModificadorDeEstadoTarefa;
import main.br.com.solid.model.projeto.tarefa.status.StatusADesenvolver;
import main.br.com.solid.model.projeto.tarefa.status.StatusAguardandoTestes;
import main.br.com.solid.model.projeto.tarefa.status.StatusDesenvolvendo;
import main.br.com.solid.model.projeto.tarefa.status.StatusEmTestes;
import main.br.com.solid.model.projeto.tarefa.status.StatusImpedida;
import main.br.com.solid.model.usuario.Cargo;
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
	
	@Test
	public void testa_mudanca_de_estado_de_impedida_para_desenvolvendo() {
		changeToADesenvolver();
		changeToDesenvolvendo();
		changeToImpedida();
		changeToDesenvolvendo();
		
		assertThat(tarefa.getImpedimento().getDataRetorno(), notNullValue());
	}
	
	@Test
	public void testa_mudanca_de_estado_de_desenvolvendo_para_aguardando_testes() {
		changeToADesenvolver();
		changeToDesenvolvendo();
		
		assertThat(tarefa.getDataFimDesenvolvimento(), nullValue());
		
		changeToAguardandoTestes();
		assertThat(tarefa.getDataFimDesenvolvimento(), notNullValue());
	}
	
	@Test
	public void testa_mudanca_de_estado_de_aguardando_testes_para_em_testes() {
		changeToADesenvolver();
		changeToDesenvolvendo();
		changeToAguardandoTestes();
		
		Usuario tester = criaUsuario("Novo tester", "tester", "123teste", "teste@test.com", TESTER);
		
		ModificadorDeEstadoTarefa.alteraStatus(tarefa, StatusEmTestes.comTester(tester));
		assertThat(tarefa, isEmTestes());
		assertThat(tarefa.getUsuarioTestes(), equalTo(tester));
	}

	private void changeToAguardandoTestes() {
		ModificadorDeEstadoTarefa.alteraStatus(tarefa, StatusAguardandoTestes.instancia());
		assertThat(tarefa, isAguardandotestes());
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
	
	private Usuario criaUsuario(String nomeCompleto, String usuario, String senha, String email, Cargo cargo) {
		return UsuarioBuilder.builder()
				.nomeCompleto(nomeCompleto)
				.usuario(usuario)
				.senha(senha)
				.email(email)
				.cargo(cargo)
				.build();
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
