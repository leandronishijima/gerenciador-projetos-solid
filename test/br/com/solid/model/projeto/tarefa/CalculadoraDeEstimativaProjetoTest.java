package br.com.solid.model.projeto.tarefa;

import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.OS;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.TRES_DIAS;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.BLOQUEADOR;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.CRITICO;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.CalculadoraDeEstimativaProjeto;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.CategoriaTarefa;
import main.br.com.solid.model.projeto.tarefa.Estimativa;
import main.br.com.solid.model.projeto.tarefa.Prioridade;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;

import org.junit.Test;

public class CalculadoraDeEstimativaProjetoTest {

	@Test
	public void calcula_estimativa_de_projeto_simples() {
		Projeto projeto = new Projeto("Projeto feliz!", "Descrição do projeto feliz!");
		
		projeto.adicionaTarefa(criaTarefa("OS 1", "Criar projeto no repositório", UM_DIA, LocalDate.now(), OS, BLOQUEADOR));
		projeto.adicionaTarefa(criaTarefa("OS 2", "Configurar frameworks descritos pela arquitetura", TRES_DIAS, LocalDate.now().plusDays(2), OS, BLOQUEADOR));
		projeto.adicionaTarefa(criaTarefa("OS 3", "Alinhamento da equipe", TRES_DIAS, LocalDate.now().plusDays(4), OS, CRITICO));
		
		CalculadoraDeEstimativaProjeto calculadora = new CalculadoraDeEstimativaProjeto(projeto);
		assertThat(calculadora.calcula(), equalTo(7l));
	}
	
	private Tarefa criaTarefa(String titulo, String descricao, Estimativa estimativa, LocalDate inicioEm, CategoriaTarefa categoriaTarefa, Prioridade prioridade) {
		Tarefa tarefa = TarefaBuilder.builder()
				.titulo(titulo)
				.comDescricao(descricao)
				.comEstimativa(estimativa)
				.comPrevisaoDeInicioEm(inicioEm)
				.comCategoria(categoriaTarefa)
				.comPrioridade(prioridade).build();
		return tarefa;
	}

}
