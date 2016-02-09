package main.br.com.solid.model.projeto.tarefa.responsaveis;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

import main.br.com.solid.model.usuario.Usuario;

public class Responsaveis {
	
	private Usuario subResponsavel1;
	private Usuario subResponsavel2;
	private List<Usuario> watchers;
	
	public Responsaveis() {
		this.watchers = new ArrayList<Usuario>();
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
	
	public void adicionaSubResponsavel2(Usuario subresponsavel2) {
		this.subResponsavel2 = subresponsavel2;
	}

	public void adicionaWatcher(Usuario watcher) {
		watchers.add(watcher);
	}

	public List<Usuario> getWatchers() {
		return unmodifiableList(watchers);
	}

}
