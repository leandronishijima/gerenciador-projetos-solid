package test.br.com.solid.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.br.com.solid.dao.usuario.UsuarioDaoDatabaseMockTest;
import test.br.com.solid.model.usuario.UsuarioBuilderTest;
import test.br.com.solid.service.usuario.UsuarioServiceTest;


@RunWith(Suite.class)
@SuiteClasses({ UsuarioDaoDatabaseMockTest.class,
                UsuarioBuilderTest.class,
                UsuarioServiceTest.class })
public class UsuarioCadastroTests {

}
