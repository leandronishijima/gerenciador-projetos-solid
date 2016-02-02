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
		tarefa.setTitulo(titulo);
		return this;
	}
	
	public TarefaBuilder comDescricao(String descricao) {
		tarefa.setDescricao(descricao);
		return this;
	}
	
	public TarefaBuilder comEstimativa(Estimativa estimativa) {
		tarefa.setEstimativa(estimativa);
		return this;
	}
	
	public TarefaBuilder comCategoria(CategoriaTarefa categoria) {
		tarefa.setCategoria(categoria);
		return this;
	}
	
	public TarefaBuilder comPrevisaoDeInicioEm(LocalDate inicioPrevisto) {
		tarefa.setInicioPrevisto(inicioPrevisto);
		return this;
	}
	
	public Tarefa build() {
		return tarefa;
	}

}
