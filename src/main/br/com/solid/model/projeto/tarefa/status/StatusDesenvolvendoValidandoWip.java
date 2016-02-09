package main.br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.responsaveis.WorkInProgressException;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.service.projeto.ProjetoService;

public class StatusDesenvolvendoValidandoWip extends StatusDesenvolvendo {
	
	private ProjetoService service;
	
	protected StatusDesenvolvendoValidandoWip(Usuario subResponsavel1, Usuario subResponsavel2, ProjetoService service) {
		super(subResponsavel1, subResponsavel2);
		this.service = service;
	}
	
	public static StatusDesenvolvendoValidandoWip paraUsuarios(Usuario subResponsavel1, Usuario subResponsavel2, ProjetoService service) {
		return new StatusDesenvolvendoValidandoWip(subResponsavel1, subResponsavel2, service);
	}
	
	public static StatusDesenvolvendoValidandoWip paraUsuario(Usuario subResponsavel1, ProjetoService service) {
		return new StatusDesenvolvendoValidandoWip(subResponsavel1, subResponsavel1, service);
	}
	
	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		validaWip();
		super.executaAcao(tarefaAlvo);
	}

	private void validaWip() {
		int ocorrenciasResponsavel1 = 1;
		int ocorrenciasResponsavel2 = 1;
		
		for(Projeto projeto : service.listAll())
			for (Tarefa tarefa : projeto.getTarefas())
				if(tarefa.isDesenvolvendo()) {
					if(validaWipSubResponsavel1(tarefa))
							ocorrenciasResponsavel1++;
					
					if(validaWipSubResponsavel2(tarefa))
							ocorrenciasResponsavel2++;
				}
		
		if(ocorrenciasResponsavel1 > 2 || ocorrenciasResponsavel2 > 2)
			throw new WorkInProgressException();
	}

	private boolean validaWipSubResponsavel1(Tarefa tarefa) {
		return getSubResponsavel1().equals(tarefa.getResponsaveis().getSubResponsavel1()) || getSubResponsavel2().equals(tarefa.getResponsaveis().getSubResponsavel2());
	}
	
	private boolean validaWipSubResponsavel2(Tarefa tarefa) {
		return getSubResponsavel2().equals(tarefa.getResponsaveis().getSubResponsavel1()) || getSubResponsavel1().equals(tarefa.getResponsaveis().getSubResponsavel2());
	}

}
