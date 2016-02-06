package main.br.com.solid.model.projeto.tarefa;

import static java.util.Collections.unmodifiableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.logwork.LogWork;
import main.br.com.solid.model.projeto.tarefa.status.Status;
import main.br.com.solid.model.projeto.tarefa.status.StatusEmAnalise;
import main.br.com.solid.model.usuario.Usuario;

public class Tarefa {

	private String titulo;
	private String descricao;
	private CategoriaTarefa categoria;
	private Status status;
	private Usuario subResponsavel1;
	private Usuario subResponsavel2;
	private List<Usuario> watchers;
	private LocalDate inicioPrevisto;
	private LocalDate fimPrevisto;
	private Estimativa estimativa;
	private LocalDate dataCriacao;
	private List<LogWork> logsWorks;
	private Impedimento impedimento;

	protected Tarefa() {
		this.status = StatusEmAnalise.instancia();
		this.dataCriacao = LocalDate.now();
		this.watchers = new ArrayList<Usuario>();
		this.logsWorks = new ArrayList<LogWork>();
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

	public void setInicioPrevisto(LocalDate inicioPrevisto) {
		this.inicioPrevisto = inicioPrevisto;
	}

	public Estimativa getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(Estimativa estimativa) {
		this.estimativa = estimativa;
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

	public void adicionaLogWork(LogWork logWork) {
		logsWorks.add(logWork);
	}

	public List<LogWork> getLogsWorks() {
		return unmodifiableList(logsWorks);
	}

	public Impedimento getImpedimento() {
		return impedimento;
	}
	
	public void impede(Impedimento impedimento) {
		this.impedimento = impedimento;
	}

	public boolean isImpedida() {
		return getStatus().isStatusImpedida();
	}

}
