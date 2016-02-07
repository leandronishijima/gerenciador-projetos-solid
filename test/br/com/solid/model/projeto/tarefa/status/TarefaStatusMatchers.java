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

	public static StatusMatcher isAguardandotestes() {
		return new StatusAguardandoTestesMatcher();
	}

	public static StatusMatcher isEmTestes() {
		return new StatusEmTestesMatcher();
	}

	public static StatusMatcher isFinalizada() {
		return new StatusFinalizadaMatcher();
	}

	public static StatusMatcher isCancelada() {
		return new StatusCanceladaMatcher();
	}

}
