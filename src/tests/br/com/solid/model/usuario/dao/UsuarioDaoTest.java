package tests.br.com.solid.model.usuario.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.solid.model.usuario.Usuario;
import br.com.solid.model.usuario.dao.UsuarioDao;

public class UsuarioDaoTest {
	
	@Test
	public void persisteUsuarioDesenvolvedor() {
		Usuario usr = criaUsuarioTeste();
		
		UsuarioDao dao = new UsuarioDao();
		dao.save(usr);
		
		Usuario usuarioPesquisado = dao.pesquisaPorId(usr.getId());
		
		assertThat(usuarioPesquisado, equalTo(usr));
		
		assertThat(usuarioPesquisado.getNomeCompleto(), equalTo("Leandro Nishijima"));
		assertThat(usuarioPesquisado.getUsuario(), equalTo("leandro.nishijima"));
		assertThat(usuarioPesquisado.getSenha(), equalTo("senhaTeste"));
		assertThat(usuarioPesquisado.getEmail(), equalTo("leandro.nishijima@github.com"));
	}

	private Usuario criaUsuarioTeste() {
		return new Usuario(1l, "Leandro Nishijima", "leandro.nishijima", "senhaTeste", "leandro.nishijima@github.com");
	}

}
