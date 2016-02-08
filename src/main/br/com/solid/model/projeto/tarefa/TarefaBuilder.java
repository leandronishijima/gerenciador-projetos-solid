package main.br.com.solid.model.projeto.tarefa;

import java.time.LocalDate;


public class TarefaBuilder {
	
	private Tarefa tarefa;

	private TarefaBuilder() {
		this.tarefa = new Tarefa();
	}
	
	public static TarefaBuilder builder() {
		return new TarefaBuilder();
	}
	
	public TarefaBuilder titulo(String titulo) {
		tarefa.getDetalhes().setTitulo(titulo);
		return this;
	}
	
	public TarefaBuilder comDescricao(String descricao) {
		tarefa.getDetalhes().setDescricao(descricao);
		return this;
	}
	
	public TarefaBuilder comEstimativa(Estimativa estimativa) {
		tarefa.getDetalhesProgressoTarefa().setEstimativa(estimativa);
		return this;
	}
	
	public TarefaBuilder comCategoria(CategoriaTarefa categoria) {
		tarefa.getDetalhes().setCategoria(categoria);
		return this;
	}
	
	public TarefaBuilder comPrevisaoDeInicioEm(LocalDate inicioPrevisto) {
		tarefa.getDetalhesProgressoTarefa().setInicioPrevisto(inicioPrevisto);
		return this;
	}
	
	public TarefaBuilder comPrioridade(Prioridade prioridade) {
		tarefa.definePrioridade(prioridade);
		return this;
	}
	
	public Tarefa build() {
		return tarefa;
	}

}
