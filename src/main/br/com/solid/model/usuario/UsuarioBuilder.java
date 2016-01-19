package main.br.com.solid.model.usuario;

public class UsuarioBuilder {
	
	private Usuario usr;
	
	public static UsuarioBuilder builder() {
		return new UsuarioBuilder();
	}
	
	private UsuarioBuilder() {
		usr = new Usuario();
	}
	
	public UsuarioBuilder nomeCompleto(String nomeCompleto) {
		usr.setNomeCompleto(nomeCompleto);
		return this;
	}
	
	public UsuarioBuilder usuario(String usuario) {
		usr.setUsuario(usuario);
		return this;
	}
	
	public UsuarioBuilder senha(String senha) {
		usr.setSenha(senha);
		return this;
	}
	
	public UsuarioBuilder email(String email) {
		usr.setEmail(email);
		return this;
	}
	
	public UsuarioBuilder cargo(Cargo cargo) {
		usr.setCargo(cargo);
		return this;
	}
	
	public Usuario build() {
		return usr;
	}

}