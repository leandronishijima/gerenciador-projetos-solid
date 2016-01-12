package br.com.solid.model.usuario;

public class Usuario {
	
	private Long id;
	private String nomeCompleto;
	private String usuario;
	private String senha;
	private String email;

	public Usuario(Long id, String nomeCompleto, String usuario, String senha, String email) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return nomeCompleto; 
	}

}
