package br.univille.testeselecao.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.testeselecao.dao.Game;
import br.univille.testeselecao.repository.GameRepository;
import br.univille.testeselecao.service.GameService;

@Service(value = "gameService")
public class GameServiceImpl implements GameService{

	@Autowired
	private GameRepository repository;
	
	@Override
	public List<Game> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Game> findAllGameByName(String name) {
		return repository.findAllByName(name);
	}

	@Override
	public void save(Game game) {
		repository.save(game);
	}

	@Override
	public void delete(Game game) {
		repository.delete(game);
	}

	@Override
	public Game findFirstByName(String name) {
		return repository.findFirstByNameContains(name);
	}

	@Override
	public Game findById(long id) {
		Optional<Game> result = repository.findById(id);
		return result.get();
	}

}
