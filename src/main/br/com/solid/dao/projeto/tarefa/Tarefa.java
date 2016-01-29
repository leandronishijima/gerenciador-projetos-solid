package main.br.com.solid.dao.projeto.tarefa;

import static java.util.Collections.unmodifiableList;
import static main.br.com.solid.dao.projeto.tarefa.StatusTarefa.EM_ANALISE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
		this.watchers = new ArrayList<Usuario>();
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

	public void adicionaSubResponsavel2(Usuario subresponsavel2) {
		this.subResponsavel2 = subresponsavel2;
	}
	
	public Usuario getSubResponsavel1() {
		return subResponsavel1;
	}

	public void adicionaSubResponsavel1(Usuario subresponsavel1) {
		this.subResponsavel1 = subresponsavel1;
	}

	public Usuario getSubResponsavel2() {
		return subResponsavel2;
	}

	public void adicionaWatcher(Usuario watcher) {
		watchers.add(watcher);
	}
	
	public List<Usuario> getWatchers() {
		return unmodifiableList(watchers);
	}
	
}
