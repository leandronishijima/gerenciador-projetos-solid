package test.br.com.solid.service.projeto;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.service.projeto.ProjetoService;

import org.junit.Before;
import org.junit.Test;

public class ProjetoServiceTest {
	
	private ProjetoService service;
	
	@Before
	public void instanciaService() {
		service = new ProjetoService();
	}

	@Test
	public void save_projeto() {
		assertThat(persisteProjeto(criaProjetoPadraoTeste()), equalTo(true));
	}

	@Test
	public void pesquisa_projeto_cadastrado() {
		Projeto proj = criaProjetoPadraoTeste();
		persisteProjeto(proj);
		
		Projeto projetoPesquisado = service.pesquisaProjeto(proj.getId());
		
		assertThat(proj, equalTo(projetoPesquisado));
	}

	@Test
	public void listaTodosUsuariosListados() {
		persisteProjeto(criaProjetoPadraoTeste());
		persisteProjeto(new Projeto("Projeto 1", "Projeto 1 descrição"));
		persisteProjeto(new Projeto("Projeto 2", "Projeto 2 descrição"));
		persisteProjeto(new Projeto("Projeto 3", "Projeto 3 descrição"));
		
		assertThat(service.listAll(), hasSize(4));
	}
	
	private Projeto persisteProjeto(Projeto projeto) {
		return service.saveOrUpdate(projeto);
	}
	
	private Projeto criaProjetoPadraoTeste() {
		return new Projeto("Projeto teste", "Descrição do projeto teste!");
	}

}
