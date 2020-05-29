package br.univille.testeselecao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.testeselecao.dao.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
	List<Platform> findAll();
	List<Platform> findAllByName(String name);
	Platform findFirstByName(String name);
}
