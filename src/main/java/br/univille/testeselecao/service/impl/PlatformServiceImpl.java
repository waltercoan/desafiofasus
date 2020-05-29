package br.univille.testeselecao.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.testeselecao.dao.Platform;
import br.univille.testeselecao.repository.PlatformRepository;
import br.univille.testeselecao.service.PlatformService;

@Service(value = "platformService")
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformRepository repository;
	
	public List<Platform> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Platform p) {
		repository.save(p);
	}

	@Override
	public List<Platform> findByName(String name) {
		return repository.findAllByName(name);
	}

	@Override
	public Platform findById(long id) {
		Optional<Platform> result = repository.findById(id);
		return result.get();
	}
}
