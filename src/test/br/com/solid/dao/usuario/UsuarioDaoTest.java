package test.br.com.solid.dao.usuario;

import static main.br.com.solid.model.usuario.Cargo.ANALISTA;
import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import main.br.com.solid.dao.usuario.UsuarioDao;
import main.br.com.solid.model.usuario.Usuario;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class UsuarioDaoTest {
	
	private UsuarioDao dao;

	@Before
	public void criaDao() {
		dao = new UsuarioDao();
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
		
		Usuario samuel = new Usuario("Samuel Oliveira Correia", "samuel.oliveira", "samuelTeste", "samueloliveiracorreia@teleworm.us", ANALISTA);
		dao.saveOrUpdate(samuel);
		
		Usuario gabriela = new Usuario("Gabriela Ribeiro Martins", "gabriela.martins", "gabrielaRibeiroTeste", "gabrielaribeiromartins@armyspy.com", DESENVOLVEDOR);
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
		return new Usuario("Leandro Nishijima", "leandro.nishijima", "senhaTeste", "leandro.nishijima@github.com", DESENVOLVEDOR);
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
