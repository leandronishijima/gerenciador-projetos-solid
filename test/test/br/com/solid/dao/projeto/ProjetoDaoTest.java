package test.br.com.solid.dao.projeto;

import static main.br.com.solid.model.usuario.Cargo.DESENVOLVEDOR;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import main.br.com.solid.dao.Database;
import main.br.com.solid.dao.projeto.ProjetoDaoDatabaseMock;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.usuario.Usuario;
import main.br.com.solid.model.usuario.UsuarioBuilder;

import org.junit.Before;
import org.junit.Test;

public class ProjetoDaoTest {

	private ProjetoDaoDatabaseMock dao;
	
	@Before
	public void inicializaDao() {
		dao = new ProjetoDaoDatabaseMock();
		Database.reinicializa();
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
	
	@Test
	public void testa_list_all_projetos() {
		Projeto projeto1 = criaProjetoPadrao();
		Projeto projeto2 = new Projeto("Novo projeto teste", "Projeto de testes!");
		
		dao.saveOrUpdate(projeto1);
		dao.saveOrUpdate(projeto2);
		
		List<Projeto> listAll = dao.listAll();
		
		assertThat(listAll, hasSize(2));
		assertThat(listAll, contains(projeto1, projeto2));
	}
	
	@Test
	public void testa_persistencia_de_edicao() {
		Projeto projeto = criaProjetoPadrao();
		
		dao.saveOrUpdate(projeto);
		assertThat(dao.listAll(), hasSize(1));

		projeto.setDescricao("Nova descri��o para o projeto");
		
		dao.saveOrUpdate(projeto);
		assertThat(dao.listAll(), hasSize(1));
		
		Projeto projetoPesquisado = dao.pesquisaPorId(projeto.getId());
		
		assertThat(projetoPesquisado.getId(), equalTo(projeto.getId()));
		assertThat(projetoPesquisado.getDescricao(), equalTo("Nova descri��o para o projeto"));
	}
	
	@Test
	public void test_exclui() {
		Projeto projeto = criaProjetoPadrao();
		
		dao.saveOrUpdate(projeto);
		assertThat(dao.listAll(), hasSize(1));
		
		dao.exclui(projeto);
		
		assertThat(dao.listAll(), hasSize(0));
	}
	
	private void persiste(Projeto proj) {
		dao.saveOrUpdate(proj);
		assertThat(proj.getId(), notNullValue());
	}

	private Projeto criaProjetoPadrao() {
		return new Projeto("Projeto Teste",	"Projeto inicial da empresa");
	}

}
