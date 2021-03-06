package main.br.com.solid.model.projeto;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.usuario.Usuario;

public class Projeto {
	
	private String nome;
	private String descricao;
	private List<Usuario> integrantes;
	private List<Tarefa> tarefas;
	private Long id;
	
	public Projeto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.integrantes = new ArrayList<Usuario>();
		this.tarefas = new ArrayList<Tarefa>();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getIntegrantes() {
		return unmodifiableList(integrantes);
	}
	
	public void adicionaIntegrante(Usuario usuario) {
		integrantes.add(usuario);
	}
	
	public void adicionaTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}

	public List<Tarefa> getTarefas() {
		return unmodifiableList(tarefas);
	}
	
	@Override
	public boolean equals(Object obj) {
		Projeto other = (Projeto) obj;
		return getNome().equals(other.getNome()) && getDescricao().equals(other.getDescricao());
	}
	
	@Override
	public String toString() {
		return getNome();
	}

}
