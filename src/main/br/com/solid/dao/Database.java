package main.br.com.solid.dao;

import java.util.HashMap;
import java.util.Map;

import main.br.com.solid.model.usuario.Usuario;

public class Database {
	
	private Map<Long, Usuario> usuarios;
	
	private static Database instance;
	
	private Database() {
		usuarios = new HashMap<Long, Usuario>();
	}
	
	public Map<Long, Usuario> getUsuarios() {
		return usuarios;
	}
	
	public static Database getInstance() {
		if (instance == null)
			return new Database();
		
		return instance;
	}

}
