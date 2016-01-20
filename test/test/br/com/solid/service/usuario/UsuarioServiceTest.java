package test.br.com.solid.service.usuario;

import static main.br.com.solid.model.usuario.Cargo.ANALISTA;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static main.br.com.solid.model.usuario.Cargo.SUPORTE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import main.br.com.solid.model.usuario.Cargo;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;
import main.br.com.solid.service.usuario.UsuarioService;

import org.junit.Before;
import org.junit.Test;

public class UsuarioServiceTest {

	private UsuarioService service;
	
	@Before
	public void instanciaService() {
		service = new UsuarioService();
	}

	@Test
	public void saveUsuario() {
		assertThat(persisteUsuario(criaUsuarioPadraoTeste()), equalTo(true));
	}

	@Test
	public void pesquisaUsuarioCadastrado() {
		Usuario usr = criaUsuarioPadraoTeste();
		persisteUsuario(usr);
		
		Usuario usuarioPesquisado = service.pesquisaUsuario(usr.getId());
		
		assertThat(usr, equalTo(usuarioPesquisado));
		validaDadosUsuarioPadrao(usuarioPesquisado);
	}

	@Test
	public void listaTodosUsuariosListados() {
		persisteUsuario(criaUsuarioPadraoTeste());
		persisteUsuario(criaUsuario("Samuel Oliveira Correia", "samuel.oliveira", "samuelTeste", "samueloliveiracorreia@teleworm.us", ANALISTA));
		persisteUsuario(criaUsuario("Gabriela Ribeiro Martins", "gabriela.martins", "gabrielaRibeiroTeste", "gabrielaribeiromartins@armyspy.com", DESENVOLVEDOR));
		persisteUsuario(criaUsuario("Rebeca Silva Castro", "rebeca.castro", "rebecaTeste", "rebecasilvacastro@teleworm.us", SUPORTE));
		
		assertThat(service.listaTodos(), hasSize(4));
	}

	private Usuario criaUsuario(String nomeCompleto, String usuario, String senha, String email, Cargo cargo) {
		return UsuarioBuilder.builder()
				.nomeCompleto(nomeCompleto)
				.usuario(usuario)
				.senha(senha)
				.email(email)
				.cargo(cargo)
				.build();
	}
	
	private boolean persisteUsuario(Usuario usuario) {
		return service.saveOrUpdate(usuario);
	}
	
	private Usuario criaUsuarioPadraoTeste() {
		return criaUsuario("Leandro Nishijima", "leandro.nishijima", "senhaTeste", "leandronishijima@github.com", DESENVOLVEDOR);
	}
	
	private void validaDadosUsuarioPadrao(Usuario usuarioPesquisado) {
		assertThat(usuarioPesquisado.getNomeCompleto(), equalTo("Leandro Nishijima"));
		assertThat(usuarioPesquisado.getUsuario(), equalTo("leandro.nishijima"));
		assertThat(usuarioPesquisado.getSenha(), equalTo("senhaTeste"));
		assertThat(usuarioPesquisado.getEmail(), equalTo("leandronishijima@github.com"));
		assertThat(usuarioPesquisado.getCargo(), equalTo(DESENVOLVEDOR));
	}

}
