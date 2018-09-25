package com.ApiStudy.Achievement;

import com.ApiStudy.Hero.HeroBean;

public class Achievement {	

	private Integer id;
	private String name;
	private String description;
	private String url;
	private HeroBean hero;
	private Reward reward;

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(String description) {
	this.description = description;
	}

	public String getUrl() {
	return url;
	}

	public void setUrl(String url) {
	this.url = url;
	}

	public HeroBean getHero() {
	return hero;
	}

	public void setHero(HeroBean hero) {
	this.hero = hero;
	}

	public Reward getReward() {
	return reward;
	}
	
	public String getRewardToString() {
		String rewardString = "";
		rewardString += "<b><span style=\"margin-left:2em\">Id: </b>" + reward.getId() + "</span><BR>";
		rewardString += "<b><span style=\"margin-left:2em\">Name: </b>" + reward.getName() + "</span><BR>";
		rewardString += "<b><span style=\"margin-left:2em\">Cost: </b>" + reward.getCost() + "</span><BR>";
		rewardString += "<b><span style=\"margin-left:2em\">URL: </b>" + reward.getUrl() + "</span><BR>";
		rewardString += "<b><span style=\"margin-left:2em\">Type: </b></span><BR>";
		rewardString += "<b><span style=\"margin-left:3em\">Id: </b>" + reward.getType().get(Reward.idType) + "</span><BR>";
		rewardString += "<b><span style=\"margin-left:3em\">Name: </b>" + reward.getType().get(Reward.nameType) + "</span><BR>";
		rewardString += "<b><span style=\"margin-left:3em\">URL: </b>" + reward.getType().get(Reward.urlType) + "</span><BR>";
		rewardString += "<b><span style=\"margin-left:2em\">Quality: </b></span><BR>";
		rewardString += "<b><span style=\"margin-left:3em\">Id: </b>" + reward.getQuality().get(Reward.nameQuality) + "</span><BR>";
		return rewardString;
		
	}

	public void setReward(Reward reward) {
	this.reward = reward;
	}

}
