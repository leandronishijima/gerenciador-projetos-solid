package main.br.com.solid.model.projeto.tarefa;

import static java.util.Collections.unmodifiableList;
import static main.br.com.solid.model.projeto.tarefa.StatusTarefa.EM_ANALISE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.br.com.solid.model.usuario.Usuario;

public class Tarefa {
	
	private String titulo;
	private String descricao;
	private CategoriaTarefa categoria;
	private StatusTarefa status;
	private Usuario subResponsavel1;
	private Usuario subResponsavel2;
	private List<Usuario> watchers;
	private LocalDate inicioPrevisto;
	private LocalDate fimPrevisto;
	private int estimativa;
	private LocalDate dataCriacao;
	
	public Tarefa(String titulo, String descricao, int estimativa, LocalDate inicioPrevisto, CategoriaTarefa categoria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.estimativa = estimativa;
		this.dataCriacao = LocalDate.now();
		this.categoria = categoria;
		this.inicioPrevisto = inicioPrevisto;
		this.status = EM_ANALISE;
		this.watchers = new ArrayList<Usuario>();
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
	
	public LocalDate getFimPrevisto() {
		return fimPrevisto;
	}
	
	public void setFimPrevisto(LocalDate fimPrevisto) {
		this.fimPrevisto = fimPrevisto;
	}

	public LocalDate getInicioPrevisto() {
		return inicioPrevisto;
	}

	public long getEstimativa() {
		return estimativa;
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

}
