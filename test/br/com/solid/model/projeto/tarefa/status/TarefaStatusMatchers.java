package br.com.solid.model.projeto.tarefa.status;


public class TarefaStatusMatchers {

	public static StatusMatcher isADesenvolver() {
		return new StatusADesenvolverMatcher();
	}

	public static StatusMatcher isEmAnalise() {
		return new StatusEmAnaliseMatcher();
	}

	public static StatusMatcher isDesenvolvendo() {
		return new StatusDesenvolvendoMatcher();
	}

	public static StatusMatcher isImpedida() {
		return new StatusImpedidaMatcher();
	}

}
