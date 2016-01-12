package main.br.com.solid.model.usuario;

public class Usuario {
	
	private Long id;
	private String nomeCompleto;
	private String usuario;
	private String senha;
	private String email;
	private Cargo cargo;

	public Usuario(Long id, String nomeCompleto, String usuario, String senha, String email, Cargo cargo) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		this.cargo = cargo;
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
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	@Override
	public String toString() {
		return nomeCompleto; 
	}

}
