package com.ApiStudy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ApiStudy.Achievement.Achievement;
import com.ApiStudy.Hero.Hero;
import com.ApiStudy.Map.Maps;
import com.google.gson.Gson;

@RestController
public class OwController {

	/*------------*/
	/*-AUTOWIREDS-*/
	/*------------*/

	@Autowired
	HeroConsumer heroConsumer;
	@Autowired
	AchievementConsumer achievementConsumer;
	@Autowired
	MapConsumer mapConsumer;

	/*------------*/
	/*---HEROES---*/
	/*------------*/
	
	@RequestMapping(value = "/heroes")
	public String getHeroes(@RequestParam(value="produce", defaultValue="json") String produce) {
		Gson gson = new Gson();
		List<Hero> heroes = heroConsumer.getHeroes();
		
		String returnProduce = "";

		if (produce.equalsIgnoreCase("html")) {
			returnProduce = "<html><head><font size=5><b>Hero's Profile</b></head></font><BR><BR><body>";
			for (Hero h : heroes) {
				returnProduce += "<b>Nome: </b>" + h.getName() + "<BR>";
				returnProduce += "<b>ID: </b>" + h.getId() + "<BR>";
				returnProduce += "<b>Real Nome: </b>" + h.getRealName() + "<BR>";
				returnProduce += "<b>Age: </b>" + h.getAge() + "<BR>";
				returnProduce += "<b>Height: </b>" + h.getHeight() + "<BR>";
				returnProduce += "<b>Affiliation: </b>" + h.getAffiliation() + "<BR>";
				returnProduce += "<b>Base of Operations: </b>" + h.getBaseOfOperations() + "<BR>";
				returnProduce += "<b>Health: </b>" + h.getHealth() + "<BR>";
				returnProduce += "<b>Armour: </b>" + h.getArmour() + "<BR>";
				returnProduce += "<b>Shield: </b>" + h.getShield() + "<BR>";
				returnProduce += "<b>Class: </b>" + h.getRoleToString();
				returnProduce += "<b>SubClass: </b>" + h.getSubRoleToString();
				returnProduce += "<b>Difficulty: </b>" + h.getDifficulty() + "<BR>";
				returnProduce += "<b>Description: </b>" + h.getDescription() + "<BR>";
				returnProduce += "<b>Abilities: </b>" + h.getAbilityToString();
				returnProduce += "_____________________________________________<BR><BR>";
				returnProduce += "</body></html>";
			}
		} else if (produce.equalsIgnoreCase("json")) {
			returnProduce = gson.toJson(heroConsumer.getHeroes());
		} else {
			returnProduce = "Especifique uma saída válida: html ou json";
		}

		return returnProduce;
	}

	@RequestMapping(value = "/hero/{id}")
	public String getHeroId(@PathVariable("id") String feature,
			                @RequestParam(value = "produce", defaultValue = "json") String produce) {

		Gson gson = new Gson();
		String returnProduce = "";
		
		Hero h = new Hero();
		int id = Integer.parseInt(feature);
		for (Hero temp : heroConsumer.getHeroes()) {
			h = temp;
			if (h.getId() == id)
				break;
		}
		
		if (produce.equalsIgnoreCase("html")) {
			
		returnProduce += "<html><head><font size=5><b>" + h.getName() + "'s Profile</b>" + "</font></head><body>";
		returnProduce += "<BR><b>Id: </b>" + h.getId() + "<BR>";
		returnProduce += "<b>Nome: </b>" + h.getName() + "<BR>";
		returnProduce += "<b>Real Nome: </b>" + h.getRealName() + "<BR>";
		returnProduce += "<b>Age: </b>" + h.getAge() + "<BR>";
		returnProduce += "<b>Height: </b>" + h.getHeight() + "<BR>";
		returnProduce += "<b>Affiliation: </b>" + h.getAffiliation() + "<BR>";
		returnProduce += "<b>Base of Operations: </b>" + h.getBaseOfOperations() + "<BR>";
		returnProduce += "<b>Health: </b>" + h.getHealth() + "<BR>";
		returnProduce += "<b>Armour: </b>" + h.getArmour() + "<BR>";
		returnProduce += "<b>Shield: </b>" + h.getShield() + "<BR>";
		returnProduce += "<b>Class: </b>" + h.getRoleToString();
		returnProduce += "<b>SubClass: </b>" + h.getSubRoleToString();
		returnProduce += "<b>Difficulty: </b>" + h.getDifficulty() + "<BR>";
		returnProduce += "<b>Description: </b>" + h.getDescription() + "<BR>";
		returnProduce += "<b>Abilities: </b>" + h.getAbilityToString();
		returnProduce += "</body></html>";
		
		} else if (produce.equalsIgnoreCase("json")) {
			returnProduce = gson.toJson(h);
		} else {
			returnProduce = "Especifique uma saída válida: html ou json";
		}
		return returnProduce;
	}
	
	@RequestMapping(value = "/heroes/age/{init}/{final}", produces = { "text/html" })
	public String getHeroAge(@PathVariable("init") String initAge, 
			@PathVariable("final") String finalAge) {
		
		String htm = "<html><head>Heroes</head><body>";
		int ageI = Integer.parseInt(initAge);
		int ageF = Integer.parseInt(finalAge);
		for (Hero temp : heroConsumer.getHeroes()) {
			if(temp.getAge() >= ageI && temp.getAge() <=ageF) {
				htm += "<b>Nome: </b>" + temp.getName() + "<BR>";
				
				htm += "</body></html>";
			}
		}
		
		return htm;
	}
	

	/*------------*/
	/*----MAPS----*/
	/*------------*/

	@RequestMapping(value = "/maps")
	public String getMaps(@RequestParam(value="produce", defaultValue="json") String produce) {
		Gson gson = new Gson();
		List<Maps> maps = mapConsumer.getMaps();
		String htm = "";
		
		
		if (produce.equalsIgnoreCase("html")) {
			for (Maps m : maps) {
				htm += "<html><head><font size=5><b>All Maps</b></head></font><BR><BR><body>";
				htm += "<b>Id: </b>" + m.getId() + "<BR>";
				htm += "<b>Nome: </b>" + m.getName() + "<BR>";
				htm += "<b>Location: </b>" + m.getLocation() + "<BR>";
				htm += "<b>Mode: </b>" + m.getModeToString() + "<BR>";
				htm += "<b>Stage: </b>" + m.getStageToString();
				htm += "<b>Event: </b>" + m.getEventToString() + "<BR>";
				htm += "_____________________________________________<BR><BR>";
				htm += "</body></html>";
			}
		}else if (produce.equalsIgnoreCase("json")) {
			htm = gson.toJson(mapConsumer.getMaps());	
		
		} else {
			htm = "Especifique uma saída válida: html ou json";
		}
		return htm;
	}
	

	@RequestMapping(value = "/map/{id}")
	public String getMapId(@PathVariable("id") String feature,
			                @RequestParam(value = "produce", defaultValue = "json") String produce) {

		Gson gson = new Gson();
		String htm = "";

		Maps m = new Maps();
		int id = Integer.parseInt(feature);
		for (Maps temp : mapConsumer.getMaps()) {
			m = temp;
			if (m.getId() == id)
				break;
		}
		if (produce.equalsIgnoreCase("html")) {
			htm += "<html><head><h1 style=\"color:green;\"><span style=\"margin-left:3em\">"
					+ "<b>Map</b></h1></span></head><body>";
			htm += "<b>Id: </b>" + m.getId() + "<BR>";
			htm += "<b>Nome: </b>" + m.getName() + "<BR>";
			htm += "<b>Location: </b>" + m.getLocation() + "<BR>";
			htm += "<b>Mode: </b>" + m.getModeToString() + "<BR>";
			htm += "<b>Stage: </b>" + m.getStageToString();
			htm += "<b>Event: </b>" + m.getEventToString() + "<BR>";
		}
		else if (produce.equalsIgnoreCase("json")) {
			htm = gson.toJson(m);
		} else {
			htm = "Especifique uma saída válida: html ou json";
		}

		return htm;
	}

	/*------------*/
	/* ACHIEVEMENTS */
	/*------------*/

	@RequestMapping(value = "/achievements")
	public List<Achievement> getAchievements() {
		return achievementConsumer.getAchievements();
	}

	@RequestMapping(value = "/achievements/{heroid}", produces = { "text/html" })
	public String getAchievementsByHeroId(@PathVariable("heroid") String heroid) {
		int id = Integer.parseInt(heroid);
		String heroName = "";
		List<Achievement> achievements = new ArrayList<Achievement>();
		for (Achievement a : achievementConsumer.getAchievements()) {
			if (a.getHero() != null && a.getHero().getId() == id) {
				achievements.add(a);
				heroName = a.getHero().getName();
			}
		}
		String htm = "<html><head><b>" + heroName + "'s Achievements</b><BR><BR></head><body>";

		for (Achievement a : achievements) {
			htm += "<b>Id: </b>" + a.getId() + "<BR>";
			htm += "<b>Name: </b>" + a.getName() + "<BR>";
			htm += "<b>Description: </b>" + a.getDescription() + "<BR>";
			htm += "<b>Reward: </b><BR>";
			htm += a.getRewardToString() + "<BR>";

		}
		htm += "</body></html>";
		return htm;
	}
}

