package main.br.com.solid.model.usuario;

public class Usuario {
	
	private Long id;
	private String nomeCompleto;
	private String usuario;
	private String senha;
	private String email;
	private Cargo cargo;
	
	protected Usuario() {}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		if(nomeCompleto == null || nomeCompleto.isEmpty())
			throw new IllegalArgumentException();
		
		this.nomeCompleto = nomeCompleto;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		if(usuario == null || usuario.isEmpty())
			throw new IllegalArgumentException();
		
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if(senha == null || senha.isEmpty())
			throw new IllegalArgumentException();
		
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if (email == null || email.isEmpty())
			throw new IllegalArgumentException();
		
		this.email = email;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setCargo(Cargo cargo) {
		if(cargo == null)
			throw new IllegalArgumentException();
		
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return nomeCompleto; 
	}
	
	@Override
	public boolean equals(Object obj) {
		Usuario other = (Usuario) obj;
		
		return getNomeCompleto().equals(other.getNomeCompleto()) &&
			   getUsuario().equals(other.getUsuario()) &&
			   getEmail().equals(other.getEmail());
	}

}
