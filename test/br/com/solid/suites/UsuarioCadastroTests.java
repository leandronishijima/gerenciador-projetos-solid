package br.com.solid.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.solid.dao.usuario.UsuarioDaoDatabaseMockTest;
import br.com.solid.model.usuario.UsuarioBuilderTest;
import br.com.solid.service.usuario.UsuarioServiceTest;


@RunWith(Suite.class)
@SuiteClasses({ UsuarioDaoDatabaseMockTest.class,
                UsuarioBuilderTest.class,
                UsuarioServiceTest.class })
public class UsuarioCadastroTests {

}
