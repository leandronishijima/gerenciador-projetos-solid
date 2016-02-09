package br.com.solid.model.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static main.br.com.solid.model.usuario.Cargo.ANALISTA;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static main.br.com.solid.model.usuario.Cargo.GERENTE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.DetalhesTarefa;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;
import main.br.com.solid.model.projeto.tarefa.responsaveis.Responsaveis;
import main.br.com.solid.model.projeto.tarefa.status.StatusEmAnalise;
import main.br.com.solid.model.usuario.Cargo;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Test;

public class TarefaTest {

	@Test
	public void criacao_tarefa_happy_day() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		DetalhesTarefa detalhes = tarefa.getDetalhes();
		
		assertThat(detalhes.getTitulo(), equalTo("Bug!"));
		assertThat(detalhes.getDescricao(), equalTo("Bug a ser corrigido!"));
		assertThat(detalhes.getStatus(), equalTo(StatusEmAnalise.instancia()));
		assertThat(detalhes.getCategoria(), equalTo(BUG));
		assertThat(detalhes.getDataCriacao(), equalTo(LocalDate.now()));
	}
	
	@Test
	public void adiciona_subresponsaveis() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		Responsaveis responsaveis = tarefa.getResponsaveis();
		
		responsaveis.adicionaSubResponsavel1(usuario);
		responsaveis.adicionaSubResponsavel2(usuario);
		
		assertThat(responsaveis.getSubResponsavel1(), equalTo(usuario));
		assertThat(responsaveis.getSubResponsavel2(), equalTo(usuario));
	}

	@Test
	public void adiciona_watcher() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		Responsaveis responsaveis = tarefa.getResponsaveis();
		
		responsaveis.adicionaWatcher(usuario);
		
		assertThat(responsaveis.getWatchers(), hasSize(1));
	}
	
	@Test
	public void adiciona_varios_watchers() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Responsaveis responsaveis = tarefa.getResponsaveis();
		
		responsaveis.adicionaWatcher(criaUsuarioPadrao());
		responsaveis.adicionaWatcher(criaUsuario("Nome completo teste", "alguem@github.com", "nome.teste", ANALISTA));
		responsaveis.adicionaWatcher(criaUsuario("Novo nome completo teste", "um_novo_alguem@github.com", "novo.nome", GERENTE));
		
		assertThat(responsaveis.getWatchers(), hasSize(3));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void erro_ao_adicionar_watcher_diretamente_pelo_getter() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		Usuario usuario = criaUsuarioPadrao();
		
		Responsaveis responsaveis = tarefa.getResponsaveis();
		
		responsaveis.getWatchers().add(usuario);
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
		Tarefa tarefa = TarefaBuilder.builder()
				.titulo("Bug!")
				.comDescricao("Bug a ser corrigido!")
				.comEstimativa(UM_DIA)
				.comPrevisaoDeInicioEm(LocalDate.of(2016, JANUARY, 29))
				.comCategoria(BUG).build();
		return tarefa;
	}

}
