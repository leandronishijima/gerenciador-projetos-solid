package main.br.com.solid.model.projeto.tarefa;

public enum Estimativa {
	
	QUATRO_HORAS(0, "4 Horas"),
	UM_DIA(1, "1 Dia"),
	DOIS_DIAS(2, "2 Dias"),
	TRES_DIAS(3, "3 Dias"),
	UMA_SEMANA(5, "5 Dias");
	
	private int qtdDias;
	private String descricao;

	private Estimativa(int qtdDias, String descricao) {
		this.qtdDias = qtdDias;
		this.descricao = descricao;
	}
	
	public int getQtdDias() {
		return qtdDias;
	}
	
	@Override
	public String toString() {
		return descricao;
	}

}
