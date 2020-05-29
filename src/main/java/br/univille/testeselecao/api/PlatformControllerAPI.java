package br.univille.testeselecao.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.testeselecao.dao.Platform;
import br.univille.testeselecao.service.PlatformService;

@RestController
@RequestMapping("/api/platforms")
public class PlatformControllerAPI {
	@Autowired
	private PlatformService service;
	
	
	@GetMapping()
	public ResponseEntity<List<Platform>> getAll() {
		try {
			List<Platform> platforms = service.findAll();
			if(platforms != null && platforms.size() > 0) {
				return ResponseEntity.ok(platforms);
			}
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(path="/name/{name}")
	public ResponseEntity<List<Platform>> getAllByName(@PathVariable("name") String name ) {
		try {
			List<Platform> platforms = service.findByName(name);
			if(platforms != null && platforms.size() > 0) {
				return ResponseEntity.ok(platforms);
			}
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<Platform> getById(@PathVariable("id") long id) {
		try {
			Platform platform = service.findById(id);
			if(platform != null ) {
				return ResponseEntity.ok(platform);
			}
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
