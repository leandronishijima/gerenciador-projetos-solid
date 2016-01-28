package main.br.com.solid.dao.projeto.tarefa;

import java.time.LocalDate;
import java.util.List;

import main.br.com.solid.model.usuario.Usuario;

public class Tarefa {
	
	private CategoriaTarefa categoria;
	private String status;
	private Usuario subResponsavel1;
	private Usuario subResponsavel2;
	private List<Usuario> watchers;
	private LocalDate inicioPrevisto;
	private LocalDate fimPrevisoto;

}
