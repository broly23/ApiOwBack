package com.ApiStudy.Hero;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability {
	
	
	private Integer id;
	private String name;
	private String description;
	@JsonProperty("is_ultimate")
	private Boolean isUltimate;
	private String url;
	

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

	public Boolean getIsUltimate() {
	return isUltimate;
	}

	public void setIsUltimate(Boolean isUltimate) {
	this.isUltimate = isUltimate;
	}

	public String getUrl() {
	return url;
	}

	public void setUrl(String url) {
	this.url = url;
	}

	
}
