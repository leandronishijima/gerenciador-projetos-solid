package main.br.com.solid.model.projeto.tarefa;

import main.br.com.solid.model.usuario.Usuario;


public class DetalhesTestesTarefa {
	
	private Usuario usuarioTeste;
	
	public DetalhesTestesTarefa() {}
	
	public Usuario getUsuarioTestes() {
		return usuarioTeste;
	}

	public void setUsuarioTestes(Usuario usuarioTestes) {
		if(!usuarioTestes.isTester())
			throw new IllegalArgumentException("Somente usuários do tipo tester podem testar uma tarefa");
		
		this.usuarioTeste = usuarioTestes;
	}

}
