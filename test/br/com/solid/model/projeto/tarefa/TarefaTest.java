package br.com.solid.model.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.dao.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.dao.projeto.tarefa.StatusTarefa.EM_ANALISE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.dao.projeto.tarefa.Tarefa;
import main.br.com.solid.model.usuario.Cargo;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Test;

public class TarefaTest {

	@Test
	public void criacao_tarefa_happy_day() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		assertThat(tarefa.getStatus(), equalTo(EM_ANALISE));
		assertThat(tarefa.getCategoria(), equalTo(BUG));
		assertThat(tarefa.getDataCriacao(), equalTo(LocalDate.of(2015, JANUARY, 29)));
	}
	
	@Test
	public void adiciona_subresponsaveis() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		tarefa.adicionaSubResponsavel1(usuario);
		tarefa.adicionaSubResponsavel2(usuario);
		
		assertThat(tarefa.getSubResponsavel1(), equalTo(usuario));
		assertThat(tarefa.getSubResponsavel2(), equalTo(usuario));
	}

	@Test
	public void adiciona_watchers() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		tarefa.adicionaWatcher(usuario);
		
		assertThat(tarefa.getWatchers(), hasSize(1));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void erro_ao_adicionar_watcher_diretamente_pelo_getter() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		tarefa.getWatchers().add(usuario);
	}
	
	private Usuario criaUsuarioPadrao() {
		Usuario usuario = UsuarioBuilder.builder()
			.cargo(Cargo.DESENVOLVEDOR)
			.email("teste@teste.com")
			.nomeCompleto("Leandro Nishijima")
			.senha("teste")
			.usuario("leandro.nishijima")
			.build();
		return usuario;
	}
	
	private Tarefa criaTarefaBugPadrao() {
		LocalDate dataCriacao = LocalDate.of(2015, JANUARY, 29);
		Tarefa tarefa = new Tarefa(1, dataCriacao, BUG);
		return tarefa;
	}

}
