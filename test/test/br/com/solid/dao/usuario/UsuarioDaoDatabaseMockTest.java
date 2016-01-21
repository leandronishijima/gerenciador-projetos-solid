package test.br.com.solid.dao.usuario;

import static main.br.com.solid.model.usuario.Cargo.ANALISTA;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import main.br.com.solid.dao.usuario.UsuarioDaoDatabaseMock;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Before;
import org.junit.Test;

public class UsuarioDaoDatabaseMockTest {
	
	private UsuarioDaoDatabaseMock dao;

	@Before
	public void criaDao() {
		dao = new UsuarioDaoDatabaseMock();
	}
	
	@Test
	public void persisteUsuario() {
		Usuario usr = criaEPersisteUsuario();
		
		Usuario usuarioPesquisado = dao.pesquisaPorId(usr.getId());
		
		assertAtributosPadroes(usr, usuarioPesquisado);
	}

	@Test
	public void editaUsuario() {
		Usuario usr = criaEPersisteUsuario();
		
		Usuario usuarioPesquisado = dao.pesquisaPorId(usr.getId());
		
		assertAtributosPadroes(usr, usuarioPesquisado);
		
		usr.setEmail("leandro.nishijima@gmail.com");
		dao.saveOrUpdate(usr);
		
		usuarioPesquisado = dao.pesquisaPorId(usr.getId());
		
		assertThat(usuarioPesquisado, equalTo(usr));
		
		assertThat(usuarioPesquisado.getNomeCompleto(), equalTo("Leandro Nishijima"));
		assertThat(usuarioPesquisado.getUsuario(), equalTo("leandro.nishijima"));
		assertThat(usuarioPesquisado.getSenha(), equalTo("senhaTeste"));
		assertThat(usuarioPesquisado.getEmail(), equalTo("leandro.nishijima@gmail.com"));
		assertThat(usuarioPesquisado.getCargo(), equalTo(DESENVOLVEDOR));
	}
	
	@Test
	public void listAllUsuarios() {
		Usuario leandro = criaUsuarioTeste();
		dao.saveOrUpdate(leandro);
		
		Usuario samuel = UsuarioBuilder.builder()
							.nomeCompleto("Samuel Oliveira Correia")
							.usuario("samuel.oliveira")
							.senha("samuelTeste")
							.email("samueloliveiracorreia@teleworm.us")
							.cargo(ANALISTA)
							.build();
		
		dao.saveOrUpdate(samuel);
		
		Usuario gabriela = UsuarioBuilder.builder()
							.nomeCompleto("Gabriela Ribeiro Martins")
							.usuario("gabriela.martins").senha("gabrielaRibeiroTeste")
							.email("gabrielaribeiromartins@armyspy.com").cargo(DESENVOLVEDOR)
							.build();
		
		dao.saveOrUpdate(gabriela);
		
		assertThat(dao.listAll(), hasSize(3));
		
		assertThat(dao.pesquisaPorId(leandro.getId()).getNomeCompleto(), equalTo("Leandro Nishijima"));
		assertThat(dao.pesquisaPorId(samuel.getId()).getNomeCompleto(), equalTo("Samuel Oliveira Correia"));
		assertThat(dao.pesquisaPorId(gabriela.getId()).getNomeCompleto(), equalTo("Gabriela Ribeiro Martins"));
	}
	
	@Test
	public void excluiUsuario() {
		Usuario usr = criaEPersisteUsuario();
		
		assertThat(dao.listAll(), hasSize(1));
		
		dao.exclui(usr);
		assertThat(dao.listAll(), empty());
	}

	private Usuario criaUsuarioTeste() {
		return UsuarioBuilder.builder()
				.nomeCompleto("Leandro Nishijima")
				.usuario("leandro.nishijima")
				.senha("senhaTeste")
				.email("leandro.nishijima@github.com")
				.cargo(DESENVOLVEDOR)
				.build();
	}
	
	private Usuario criaEPersisteUsuario() {
		Usuario usr = criaUsuarioTeste();
		dao.saveOrUpdate(usr);
		return usr;
	}
	
	private void assertAtributosPadroes(Usuario usr, Usuario usuarioPesquisado) {
		assertThat(usuarioPesquisado, equalTo(usr));
		
		assertThat(usuarioPesquisado.getNomeCompleto(), equalTo("Leandro Nishijima"));
		assertThat(usuarioPesquisado.getUsuario(), equalTo("leandro.nishijima"));
		assertThat(usuarioPesquisado.getSenha(), equalTo("senhaTeste"));
		assertThat(usuarioPesquisado.getEmail(), equalTo("leandro.nishijima@github.com"));
		assertThat(usuarioPesquisado.getCargo(), equalTo(DESENVOLVEDOR));
	}

}
