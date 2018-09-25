package com.ApiStudy.Achievement;

import java.util.Map;

public class Reward {

	public static final String idType = "id";
	public static final String nameType = "name";
	public static final String urlType = "url";
	public static final String nameQuality = "name";
	
	
	private Integer id;
	private String name;
	private Object cost;
	private String url;
	private Map<String, String> type;
	private Map<String, String> quality;

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

	public Object getCost() {
	return cost;
	}

	public void setCost(Object cost) {
	this.cost = cost;
	}

	public String getUrl() {
	return url;
	}

	public void setUrl(String url) {
	this.url = url;
	}

	public Map<String, String> getType() {
	return type;
	}

	public void setType(Map<String, String> type) {
	this.type = type;
	}

	public Map<String, String> getQuality() {
	return quality;
	}

	public void setQuality(Map<String, String> quality) {
	this.quality = quality;
	}

}
