package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioNull;

public class StatusDesenvolvendo extends Status {
	
	private Usuario subResponsavel1;
	private Usuario subResponsavel2;

	private StatusDesenvolvendo(Usuario subResponsavel1, Usuario subResponsavel2) {
		this.subResponsavel1 = subResponsavel1;
		this.subResponsavel2 = subResponsavel2;
	}
	
	public static StatusDesenvolvendo instancia() {
		return new StatusDesenvolvendo(UsuarioNull.instancia(), UsuarioNull.instancia());
	}
	
	public static StatusDesenvolvendo paraUsuarios(Usuario subResponsavel1, Usuario subResponsavel2) {
		return new StatusDesenvolvendo(subResponsavel1, subResponsavel2);
	}
	
	public static StatusDesenvolvendo paraUsuario(Usuario subResponsavel1) {
		return new StatusDesenvolvendo(subResponsavel1, subResponsavel1);
	}
	
	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(asList(
				StatusADesenvolver.instancia(), 
				StatusImpedida.instancia()));
	}

	@Override
	String getDescricao() {
		return "'Desenvolvendo'";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		if(tarefaAlvo.isImpedida()) {
			tarefaAlvo.getImpedimento().retorna();
			return;
		}
		
		tarefaAlvo.adicionaSubResponsavel1(subResponsavel1);
		tarefaAlvo.adicionaSubResponsavel2(subResponsavel2);
	}

}
