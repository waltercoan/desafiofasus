package br.univille.testeselecao.service;

import java.util.List;

import br.univille.testeselecao.dao.Game;

public interface GameService {
	List<Game> findAll();
	List<Game> findAllGameByName(String name);
	void save(Game game);
	void delete(Game game);
	Game findFirstByName(String name);
	Game findById(long id);
}
