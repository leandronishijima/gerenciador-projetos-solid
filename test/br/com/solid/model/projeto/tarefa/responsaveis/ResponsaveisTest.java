package br.com.solid.model.projeto.tarefa.responsaveis;

import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.OS;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.DOIS_DIAS;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.BLOQUEADOR;
import static main.br.com.solid.model.projeto.tarefa.status.ModificadorDeEstadoTarefa.alteraStatus;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.dao.projeto.ProjetoDaoDatabaseMock;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.CategoriaTarefa;
import main.br.com.solid.model.projeto.tarefa.Estimativa;
import main.br.com.solid.model.projeto.tarefa.Prioridade;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;
import main.br.com.solid.model.projeto.tarefa.responsaveis.Responsaveis;
import main.br.com.solid.model.projeto.tarefa.responsaveis.WorkInProgressException;
import main.br.com.solid.model.projeto.tarefa.status.StatusADesenvolver;
import main.br.com.solid.model.projeto.tarefa.status.StatusDesenvolvendoValidandoWip;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;
import main.br.com.solid.service.projeto.ProjetoService;

import org.junit.Before;
import org.junit.Test;

public class ResponsaveisTest {
	
	private Projeto projeto;
	private ProjetoService service;
	private Usuario usuarioPadrao;
	
	@Before
	public void environment() {
		projeto = new Projeto("Novo Projeto", "Descrição do projeto novo");
		
		service = new ProjetoService(new ProjetoDaoDatabaseMock());
		service.saveOrUpdate(projeto);
		
		usuarioPadrao = criaUsuarioPadrao();
	}

	@Test
	public void permite_usuario_desenvolver_duas_tarefas_simultaneamente() {
		Tarefa os1 = geraTarefa("OS 1");
		alteraStatus(os1, StatusDesenvolvendoValidandoWip.paraUsuario(usuarioPadrao));
		
		Responsaveis responsaveisOs1 = os1.getResponsaveis();
		assertThat(usuarioPadrao, allOf(equalTo(responsaveisOs1.getSubResponsavel1()), equalTo(responsaveisOs1.getSubResponsavel2())));
		
		Tarefa os2 = geraTarefa("OS 2");
		alteraStatus(os2, StatusDesenvolvendoValidandoWip.paraUsuario(usuarioPadrao));
		
		Responsaveis responsaveisOs2 = os2.getResponsaveis();
		assertThat(usuarioPadrao, allOf(equalTo(responsaveisOs2.getSubResponsavel1()), equalTo(responsaveisOs2.getSubResponsavel2())));
	}
	
	@Test(expected = WorkInProgressException.class)
	public void nao_permite_usuario_desenvolver_mais_de_duas_tarefas_simultaneamente() {
		Tarefa os1 = geraTarefa("OS 1");
		alteraStatus(os1, StatusDesenvolvendoValidandoWip.paraUsuario(usuarioPadrao, service));
		Responsaveis responsaveisOs1 = os1.getResponsaveis();
		assertThat(usuarioPadrao, allOf(equalTo(responsaveisOs1.getSubResponsavel1()), equalTo(responsaveisOs1.getSubResponsavel2())));
		
		Tarefa os2 = geraTarefa("OS 2");
		alteraStatus(os2, StatusDesenvolvendoValidandoWip.paraUsuario(usuarioPadrao, service));
		Responsaveis responsaveisOs2 = os2.getResponsaveis();
		assertThat(usuarioPadrao, allOf(equalTo(responsaveisOs2.getSubResponsavel1()), equalTo(responsaveisOs2.getSubResponsavel2())));
		
		Tarefa os3 = geraTarefa("OS 3");
		alteraStatus(os3, StatusDesenvolvendoValidandoWip.paraUsuario(usuarioPadrao, service));
	}

	private Tarefa geraTarefa(String titulo) {
		return criaTarefa(titulo, "Nova OS", DOIS_DIAS, LocalDate.now(), OS, BLOQUEADOR);
	}
	
	private Tarefa criaTarefa(String titulo, String descricao, Estimativa estimativa, LocalDate inicioEm, CategoriaTarefa categoriaTarefa, Prioridade prioridade) {
		Tarefa tarefa = 
					TarefaBuilder.builder()
					.titulo(titulo)
					.comDescricao(descricao)
					.comEstimativa(estimativa)
					.comPrevisaoDeInicioEm(inicioEm)
					.comCategoria(categoriaTarefa)
					.comPrioridade(prioridade).build();
		
		projeto.adicionaTarefa(tarefa);
		service.saveOrUpdate(projeto);
		
		alteraStatus(tarefa, StatusADesenvolver.instancia());
		
		return tarefa;
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
