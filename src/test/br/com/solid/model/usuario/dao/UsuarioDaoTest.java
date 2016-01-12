package test.br.com.solid.model.usuario.dao;

import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.dao.UsuarioDao;

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
		
		usuarioPesquisado.setEmail("leandro.nishijima@gmail.com");
		
		assertThat(usuarioPesquisado, equalTo(usr));
		
		assertThat(usuarioPesquisado.getNomeCompleto(), equalTo("Leandro Nishijima"));
		assertThat(usuarioPesquisado.getUsuario(), equalTo("leandro.nishijima"));
		assertThat(usuarioPesquisado.getSenha(), equalTo("senhaTeste"));
		assertThat(usuarioPesquisado.getEmail(), equalTo("leandro.nishijima@gmail.com"));
		assertThat(usuarioPesquisado.getCargo(), equalTo(DESENVOLVEDOR));
	}

	private Usuario criaUsuarioTeste() {
		return new Usuario(1l, "Leandro Nishijima", "leandro.nishijima", "senhaTeste", "leandro.nishijima@github.com", DESENVOLVEDOR);
	}
	
	private Usuario criaEPersisteUsuario() {
		Usuario usr = criaUsuarioTeste();
		dao.save(usr);
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
