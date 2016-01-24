package br.com.solid.model.usuario;

import static main.br.com.solid.model.usuario.Cargo.GERENTE;
import main.br.com.solid.model.usuario.Cargo;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Before;
import org.junit.Test;

public class UsuarioBuilderTest {
	
	private UsuarioBuilder builder;
	
	@Before
	public void initialize() {
		builder = UsuarioBuilder.builder();
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioComNomeCompletoVazio() {
		criaUsuario("", "teste.teste", "123teste", "teste@teste.com", GERENTE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioComNomeCompletoNulo() {
		criaUsuario(null, "teste.teste", "123teste", "teste@teste.com", GERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioSemUsuario() {
		criaUsuario("Leandro Nishijima", "", "123teste", "teste@teste.com", GERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioComUsuarioNulo() {
		criaUsuario("Leandro Nishijima", null, "123teste", "teste@teste.com", GERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioComSenhaVazia() {
		criaUsuario("Leandro Nishijima", "leandro.nishijima", "", "teste@teste.com", GERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioComSenhaNula() {
		criaUsuario("Leandro Nishijima", "leandro.nishijima", null, "teste@teste.com", GERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioComEmailVazio() {
		criaUsuario("Leandro Nishijima", "leandro.nishijima", "123teste", "", GERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioComEmailNulo() {
		criaUsuario("Leandro Nishijima", "leandro.nishijima", "123teste", null, GERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveSerPossivelCadastrarUsuarioSemCargo() {
		criaUsuario("Leandro Nishijima", "leandro.nishijima", "123teste", "leandro.nishijima@github.com", null);
	}
	
	private void criaUsuario(String nomeCompleto, String usuario, String senha, String email, Cargo cargo) {
		builder
			.nomeCompleto(nomeCompleto)
			.usuario(usuario)
			.senha(senha)
			.email(email)
			.cargo(cargo)
			.build();
	}
	
}
