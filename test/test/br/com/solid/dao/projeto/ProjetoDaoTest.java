package test.br.com.solid.dao.projeto;

import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import main.br.com.solid.dao.projeto.ProjetoDao;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Before;
import org.junit.Test;

public class ProjetoDaoTest {

	private ProjetoDao dao;
	
	@Before
	public void inicializaDao() {
		dao = new ProjetoDao();
	}

	@Test
	public void persiste_projeto() {
		Projeto proj = criaProjetoPadrao();
		
		persiste(proj);
		
		Projeto projPesquisado = dao.pesquisaPorId(proj.getId());

		assertThat(projPesquisado, equalTo(proj));
		assertThat(projPesquisado.getNome(), equalTo("Projeto Teste"));
		assertThat(projPesquisado.getDescricao(), equalTo("Projeto inicial da empresa"));
		assertThat(projPesquisado.getIntegrantes(), empty());
	}
	
	@Test
	public void adiciona_integrantes_ao_projeto() {
		Projeto proj = criaProjetoPadrao();
		
		Usuario usr = UsuarioBuilder.builder()
			.nomeCompleto("Leandro Nishijima")
			.usuario("leandro.nishijima")
			.senha("123teste")
			.email("leandro@email.com")
			.cargo(DESENVOLVEDOR)
			.build();
		
		proj.adicionaIntegrante(usr);
		
		persiste(proj);
		
		Projeto projPesquisado = dao.pesquisaPorId(proj.getId());
		
		assertThat(projPesquisado.getIntegrantes(), hasSize(1));
		assertThat(projPesquisado.getIntegrantes(), contains(usr));
	}

	private void persiste(Projeto proj) {
		dao.saveOrUpdate(proj);
		assertThat(proj.getId(), notNullValue());
	}

	private Projeto criaProjetoPadrao() {
		return new Projeto("Projeto Teste",	"Projeto inicial da empresa");
	}

}
