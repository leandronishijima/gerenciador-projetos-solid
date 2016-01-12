package br.com.solid.model.usuario;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.solid.model.usuario.dao.UsuarioDao;

public class UsuarioDaoTest {

	@Test
	public void persisteUsuarioDesenvolvedor() {
		Usuario usr = new Usuario();
		
		UsuarioDao dao = new UsuarioDao();
		dao.save(usr);
		
		Usuario usuarioPesquisado = dao.pesquisa(usr.getId());
		
		assertThat(usuarioPesquisado, equalTo(usr));
		// TODO Fazer assert dos atributos do usuario
	}

}
