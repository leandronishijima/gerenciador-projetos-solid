package main.br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.responsaveis.WorkInProgressException;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.service.projeto.ProjetoService;

public class StatusDesenvolvendoValidandoSubResponsaveis extends StatusDesenvolvendo {
	
	private ProjetoService service;
	
	protected StatusDesenvolvendoValidandoSubResponsaveis(Usuario subResponsavel1, Usuario subResponsavel2, ProjetoService service) {
		super(subResponsavel1, subResponsavel2);
		this.service = service;
	}
	
	public static StatusDesenvolvendoValidandoSubResponsaveis paraUsuarios(Usuario subResponsavel1, Usuario subResponsavel2, ProjetoService service) {
		return new StatusDesenvolvendoValidandoSubResponsaveis(subResponsavel1, subResponsavel2, service);
	}
	
	public static StatusDesenvolvendoValidandoSubResponsaveis paraUsuario(Usuario subResponsavel1, ProjetoService service) {
		return new StatusDesenvolvendoValidandoSubResponsaveis(subResponsavel1, subResponsavel1, service);
	}
	
	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		int ocorrenciasResponsavel1 = 1;
		int ocorrenciasResponsavel2 = 1;
		
		for(Projeto projeto : service.listAll()) {
			for (Tarefa tarefa : projeto.getTarefas()) {
				if(tarefa.isDesenvolvendo()) {
					if(getSubResponsavel1().equals(tarefa.getResponsaveis().getSubResponsavel1()) || getSubResponsavel2().equals(tarefa.getResponsaveis().getSubResponsavel2()))
							ocorrenciasResponsavel1++;
					
					if(getSubResponsavel1().equals(tarefa.getResponsaveis().getSubResponsavel1()) || getSubResponsavel2().equals(tarefa.getResponsaveis().getSubResponsavel2()))
							ocorrenciasResponsavel2++;
				}
			}
		}
		
		if(ocorrenciasResponsavel1 > 2 || ocorrenciasResponsavel2 > 2)
			throw new WorkInProgressException();

		super.executaAcao(tarefaAlvo);
	}

}
