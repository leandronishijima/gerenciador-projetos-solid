package main.br.com.solid.model.projeto.tarefa.status.wip;

import main.br.com.solid.model.usuario.Usuario;

public class ValidadorWipNull implements ValidadorWip {
	
	private ValidadorWipNull() {}
	
	public static ValidadorWipNull instancia() {
		return new ValidadorWipNull();
	}

	@Override
	public void validaWipParaUsuario(Usuario usr) {}

}
