package main.br.com.solid.model.usuario;

import static main.br.com.solid.model.usuario.Cargo.NULL_CARGO;

public class UsuarioNull extends Usuario {
	
	private UsuarioNull() {}
	
	public static UsuarioNull instancia() {
		return new UsuarioNull();
	}
	
	@Override
	public Long getId() {
		return 0l;
	}
	
	@Override
	public void setId(Long id) {}
	
	@Override
	public String getNomeCompleto() {
		return "";
	}
	
	@Override
	public void setNomeCompleto(String nomeCompleto) {}
	
	@Override
	public String getUsuario() {
		return "";
	}
	
	@Override
	public void setUsuario(String usuario) {}
	
	@Override
	public String getSenha() {
		return "";
	}
	
	@Override
	public void setSenha(String senha) {}
	
	@Override
	public String getEmail() {
		return "";
	}
	
	@Override
	public void setEmail(String email) {}
	
	@Override
	public Cargo getCargo() {
		return NULL_CARGO;
	}
	
	@Override
	public void setCargo(Cargo cargo) {}

}
