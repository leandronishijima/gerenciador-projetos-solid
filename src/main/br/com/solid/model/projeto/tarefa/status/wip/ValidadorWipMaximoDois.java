package main.br.com.solid.model.projeto.tarefa.status.wip;

import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.service.projeto.ProjetoService;

public class ValidadorWipMaximoDois implements ValidadorWip {
	
	private ProjetoService service;
	
	public ValidadorWipMaximoDois(ProjetoService service) {
		this.service = service;
	}

	@Override
	public void validaWipParaUsuario(Usuario usr) {
		int ocorrenciasResponsavel1 = 1;
		
		for(Projeto projeto : service.listAll())
			for (Tarefa tarefa : projeto.getTarefas())
				if(tarefa.isDesenvolvendo())
					if(validaWipUsuario(usr, tarefa))
							ocorrenciasResponsavel1++;
		
		if(ocorrenciasResponsavel1 > 2)
			throw new WorkInProgressException();
	}
	
	private boolean validaWipUsuario(Usuario usr, Tarefa tarefa) {
		return usr.equals(tarefa.getResponsaveis().getSubResponsavel1()) || usr.equals(tarefa.getResponsaveis().getSubResponsavel2());
	}

}
