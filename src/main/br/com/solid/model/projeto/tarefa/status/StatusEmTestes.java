package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioNull;

public class StatusEmTestes extends Status {
	
	private Usuario usuarioTester;
	
	private StatusEmTestes() {}

	private StatusEmTestes(Usuario usuarioTester) {
		this.usuarioTester = usuarioTester;
	}
	
	public static StatusEmTestes instancia() {
		return new StatusEmTestes(UsuarioNull.instancia());
	}
	
	public static StatusEmTestes comTester(Usuario usuarioTester) {
		return new StatusEmTestes(usuarioTester);
	}

	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(asList(StatusAguardandoTestes.instancia()));
	}

	@Override
	String getDescricao() {
		return "'Em Testes'";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		tarefaAlvo.getDetalhesTestesTarefa().setUsuarioTestes(usuarioTester);
	}

}
