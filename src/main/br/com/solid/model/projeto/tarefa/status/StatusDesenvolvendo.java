package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.responsaveis.Responsaveis;
import main.br.com.solid.model.projeto.tarefa.status.wip.ValidadorWip;
import main.br.com.solid.model.projeto.tarefa.status.wip.ValidadorWipNull;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioNull;

public class StatusDesenvolvendo extends Status {
	
	private Usuario subResponsavel1;
	private Usuario subResponsavel2;
	private ValidadorWip validadorWip;
	
	protected StatusDesenvolvendo(Usuario subResponsavel1, Usuario subResponsavel2, ValidadorWip validadorWip) {
		this.subResponsavel1 = subResponsavel1;
		this.subResponsavel2 = subResponsavel2;
		this.validadorWip = validadorWip;
	}
	
	public static StatusDesenvolvendo instancia() {
		return new StatusDesenvolvendo(UsuarioNull.instancia(), UsuarioNull.instancia(), ValidadorWipNull.instancia());
	}
	
	public static StatusDesenvolvendo paraUsuariosSemValidarWip(Usuario subResponsavel1, Usuario subResponsavel2) {
		return new StatusDesenvolvendo(subResponsavel1, subResponsavel2, ValidadorWipNull.instancia());
	}
	
	public static StatusDesenvolvendo paraUsuarioSemValidarWip(Usuario subResponsavel1) {
		return new StatusDesenvolvendo(subResponsavel1, subResponsavel1, ValidadorWipNull.instancia());
	}
	
	public static StatusDesenvolvendo paraUsuario(Usuario subResponsavel1, ValidadorWip validadorWip) {
		return new StatusDesenvolvendo(subResponsavel1, subResponsavel1, validadorWip);
	}
	
	public static StatusDesenvolvendo paraUsuarios(Usuario subResponsavel1, Usuario subResponsavel2, ValidadorWip validadorWip) {
		return new StatusDesenvolvendo(subResponsavel1, subResponsavel2, validadorWip);
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
		validadorWip.validaWipParaUsuario(subResponsavel1);
		validadorWip.validaWipParaUsuario(subResponsavel2);
		
		if(tarefaAlvo.getDetalhes().isImpedida()) {
			tarefaAlvo.getImpedimento().retorna();
			return;
		}
		
		Responsaveis responsaveis = tarefaAlvo.getResponsaveis();
		
		responsaveis.adicionaSubResponsavel1(subResponsavel1);
		responsaveis.adicionaSubResponsavel2(subResponsavel2);
	}
	
	protected Usuario getSubResponsavel1() {
		return subResponsavel1;
	}
	
	protected Usuario getSubResponsavel2() {
		return subResponsavel2;
	}

}
