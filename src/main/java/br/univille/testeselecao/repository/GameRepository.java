package br.univille.testeselecao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.testeselecao.dao.Game;
import br.univille.testeselecao.dao.Platform;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	List<Game> findAll();
	List<Game> findAllByPlatformEnable(Platform platform);
	List<Game> findAllByName(String name);
	Game findFirstByNameContains(String name);
}
