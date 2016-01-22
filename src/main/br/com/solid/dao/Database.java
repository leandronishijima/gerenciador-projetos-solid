package main.br.com.solid.dao;

import java.util.HashMap;
import java.util.Map;

import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.usuario.Usuario;

public class Database {
	
	private Map<Long, Usuario> usuarios;
	private Map<Long, Projeto> projetos;
	
	private static Database instance;
	
	private Database() {
		reset();
	}
	
	public Map<Long, Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Map<Long, Projeto> getProjetos() {
		return projetos;
	}
	
	public static Long geraIdUnico(Object obj) {
		return (long) (obj.hashCode() * 17);
	}
	
	private void reset() {
		usuarios = new HashMap<Long, Usuario>();
		projetos = new HashMap<Long, Projeto>();
	}
	
	public static Database getInstance() {
		if (instance == null)
			return new Database();
		
		return instance;
	}

	public static void reinicializa() {
		getInstance().reset();
	}

}
