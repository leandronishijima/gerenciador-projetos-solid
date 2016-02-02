package main.br.com.solid.model.projeto.tarefa;

public enum StatusTarefa {
	
	EM_ANALISE("Em Análise"),
	A_DESENVOLVER("A Desenvolver"),
	DESENVOLVENDO("Desenvolvendo"),
	AGUARDANDO_TESTES("Aguardando Testes"),
	EM_TESTES("Em Testes"),
	FINALIZADA("Finalizada"),
	CANCELADA("Cancelada"),
	IMPEDIDA("Impedida");
	
	private String descricao;

	private StatusTarefa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}

}
