package br.univille.testeselecao.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.testeselecao.dao.Game;
import br.univille.testeselecao.service.GameService;

@RestController
@RequestMapping("/api/games")
public class GameControllerAPI {
	@Autowired
	private GameService service;
	
	@GetMapping()
	public ResponseEntity<List<Game>> getAll() {
		try {
			List<Game> games = service.findAll();
			if(games != null && games.size() > 0) {
				return ResponseEntity.ok(games);
			}
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping(path="/name/{name}")
	public ResponseEntity<List<Game>> getAllByName(@PathVariable("name") String name) {
		try {
			List<Game> games = service.findAllGameByName(name);
			if(games != null && games.size() > 0) {
				return ResponseEntity.ok(games);
			}
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PostMapping
    public ResponseEntity<?> save(@RequestBody Game game){
        service.save(game);
        return ResponseEntity.ok(game);
    }
	@PutMapping(path="/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody Game game){
        Game oldGame = service.findById(id);
       
        oldGame.setName(game.getName());
        oldGame.setStudio(game.getStudio());
        oldGame.setDateCreated(game.getDateCreated());
        if(game.getPlatformEnable().size() != oldGame.getPlatformEnable().size())
        	oldGame.setPlatformEnable(game.getPlatformEnable());

        service.save(oldGame);
        return ResponseEntity.ok().build();
    }
	@DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
		Game game = service.findById(id);
       
		service.delete(game);
       
        return ResponseEntity.ok().build();
    }
}
