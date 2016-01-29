package main.br.com.solid.dao.projeto.tarefa;

import static main.br.com.solid.dao.projeto.tarefa.StatusTarefa.EM_ANALISE;

import java.time.LocalDate;
import java.util.List;

import main.br.com.solid.model.usuario.Usuario;

public class Tarefa {
	
	private CategoriaTarefa categoria;
	private StatusTarefa status;
	private Usuario subResponsavel1;
	private Usuario subResponsavel2;
	private List<Usuario> watchers;
	private LocalDate inicioPrevisto;
	private LocalDate fimPrevisoto;
	private int estimativa;
	private LocalDate dataCriacao;
	
	public Tarefa(int estimativa, LocalDate dataCriacao, CategoriaTarefa categoria) {
		this.estimativa = estimativa;
		this.dataCriacao = dataCriacao;
		this.categoria = categoria;
		this.status = EM_ANALISE;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public CategoriaTarefa getCategoria() {
		return categoria;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	
}
