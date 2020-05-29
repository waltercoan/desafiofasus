package br.univille.testeselecao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.testeselecao.dao.Game;
import br.univille.testeselecao.dao.Platform;
import br.univille.testeselecao.service.GameService;
import br.univille.testeselecao.service.PlatformService;

@Component
public class StartupEventListenerBean {
	@Autowired
	private PlatformService service;

	@Autowired
	private GameService gameService;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {

			Platform p1 = new Platform();
			p1.setName("Xbox");
			p1.setCompany("Microsoft");
			if(service.findByName(p1.getName()).size() == 0)
				service.save(p1);
			else
				p1 = service.findByName("Xbox").get(1);

			Platform p2 = new Platform();
			p2.setName("PlayStation");
			p2.setCompany("Sony");
			if(service.findByName(p2.getName()).size() == 0)
				service.save(p2);
			else
				p2 = service.findByName("PlayStation").get(1);

			Platform p3 = new Platform();
			p3.setName("Nintendo Switch");
			p3.setCompany("Nintendo");
			if(service.findByName(p3.getName()).size() == 0)
				service.save(p3);
			else
				p3 = service.findByName("Nintendo Switch").get(1);


			Game g1 = new Game();
			g1.setName("GTA V");
			g1.getPlatformEnable().add(p1);
			g1.getPlatformEnable().add(p2);
			g1.setStudio("RockStar Games");
			g1.setDateCreated(new Date(2013,9,17));

			if(gameService.findFirstByName(g1.getName()) == null) {
				gameService.save(g1);
			}

			Game g2 = new Game();
			g2.setName("Animal Crossing: New Horizons");
			g2.getPlatformEnable().add(p3);
			g2.setStudio("Nintendo");
			g2.setDateCreated(new Date(2020,03,20));

			if(gameService.findFirstByName(g2.getName()) == null) {
				gameService.save(g2);
			}
		}catch (Exception e) {

		}

	}

}