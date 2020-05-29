package br.univille.testeselecao.service;

import java.util.List;

import br.univille.testeselecao.dao.Platform;

public interface PlatformService {
	List<Platform> findAll();
	void save(Platform p);
	List<Platform> findByName(String name);
	Platform findById(long id);
}
