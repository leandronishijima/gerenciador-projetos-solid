package br.com.solid.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.solid.dao.projeto.ProjetoDaoDatabaseMockTest;
import br.com.solid.service.projeto.ProjetoServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ ProjetoDaoDatabaseMockTest.class,
                ProjetoServiceTest.class })
public class ProjetoCadastroTests {

}
