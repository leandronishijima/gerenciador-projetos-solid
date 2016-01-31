package br.com.solid.model.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.model.projeto.tarefa.StatusTarefa.EM_ANALISE;
import static main.br.com.solid.model.usuario.Cargo.ANALISTA;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static main.br.com.solid.model.usuario.Cargo.GERENTE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
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
	public void adiciona_watcher() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		tarefa.adicionaWatcher(usuario);
		
		assertThat(tarefa.getWatchers(), hasSize(1));
	}
	
	@Test
	public void adiciona_varios_watchers() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		tarefa.adicionaWatcher(criaUsuarioPadrao());
		tarefa.adicionaWatcher(criaUsuario("Nome completo teste", "alguem@github.com", "nome.teste", ANALISTA));
		tarefa.adicionaWatcher(criaUsuario("Novo nome completo teste", "um_novo_alguem@github.com", "novo.nome", GERENTE));
		
		assertThat(tarefa.getWatchers(), hasSize(3));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void erro_ao_adicionar_watcher_diretamente_pelo_getter() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		tarefa.getWatchers().add(usuario);
	}
	
	private Usuario criaUsuarioPadrao() {
		return criaUsuario("Leandro Nishijima", "leandro.nishijima@github.com", "leandro.nishijima", DESENVOLVEDOR);
	}
	
	private Usuario criaUsuario(String nomeCompleto, String email, String usuario, Cargo cargo) {
		Usuario usr = UsuarioBuilder.builder()
				.cargo(cargo)
				.email(email)
				.nomeCompleto(nomeCompleto)
				.senha("teste")
				.usuario(usuario)
				.build();
			
			return usr;
	}
	
	private Tarefa criaTarefaBugPadrao() {
		Tarefa tarefa = new Tarefa("Bug!", "Bug a ser corrigido!", 1, LocalDate.of(2016, JANUARY, 29), BUG);
		return tarefa;
	}

}
