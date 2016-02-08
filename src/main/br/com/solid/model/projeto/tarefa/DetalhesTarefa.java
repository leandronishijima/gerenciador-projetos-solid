package main.br.com.solid.model.projeto.tarefa;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.status.Status;
import main.br.com.solid.model.projeto.tarefa.status.StatusEmAnalise;

public class DetalhesTarefa {
	
	private String titulo;
	private String descricao;
	private LocalDate dataCriacao;
	private CategoriaTarefa categoria;
	private Status status;
	private Prioridade prioridade;
	
	public DetalhesTarefa() {
		this.status = StatusEmAnalise.instancia();
		this.dataCriacao = LocalDate.now();
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaTarefa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaTarefa categoria) {
		this.categoria = categoria;
	}
	
	public boolean isImpedida() {
		return getStatus().isStatusImpedida();
	}
	
	protected void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	public Prioridade getPrioridade() {
		return prioridade;
	}

}
