package com.ApiStudy.Hero;

import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hero {
	
	public static final String idRole = "id";
	public static final String nameRole = "name";
	
	private Integer id;
	private String name;
	private String description;
	private Integer health;
	private Integer armour;
	private Integer shield;
	@JsonProperty("real_name")
	private String realName;
	private Integer age;
	private Object height;
	private String affiliation;
	@JsonProperty("base_of_operations")
	private String baseOfOperations;
	private Integer difficulty;
	private String url;
	private Map<String, String> role;
	@JsonProperty("sub_roles")
	private List<SubRole> subRoles = null;
	private List<Ability> abilities = null;

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

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getArmour() {
		return armour;
	}

	public void setArmour(Integer armour) {
		this.armour = armour;
	}

	public Integer getShield() {
		return shield;
	}

	public void setShield(Integer shield) {
		this.shield = shield;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getAge() {
		if(age == null) {
			 return 0;
		 }
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Object getHeight() {
		return height;
	}

	public void setHeight(Object height) {
		this.height = height;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getBaseOfOperations() {
		return baseOfOperations;
	}

	public void setBaseOfOperations(String baseOfOperations) {
		this.baseOfOperations = baseOfOperations;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getRole() {
		return role;
	}

	public void setRole(Map<String, String> role) {
		this.role = role;
	}

	public List<SubRole> getSubRoles() {
		return subRoles;
	}

	public void setSubRoles(List<SubRole> subRoles) {
		this.subRoles = subRoles;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	
	public String getRoleToString() {
		String roleTemp = "";
		roleTemp += StringUtils.capitalize(this.getRole().get(nameRole));
		roleTemp += "(" + "<b>Id: </b>" + this.getRole().get(idRole)+ ")" + "<BR>";
		return roleTemp;
	}
	public String getSubRoleToString() {
		String subRoleTemp = "<BR>";
		for (SubRole s : subRoles) {
			subRoleTemp += "<b><span style=\"margin-left:2em\">Id: </b>" + s.getId() + "</span>" + "<BR>";
			subRoleTemp += "<b><span style=\"margin-left:2em\">Nome: </b>" + s.getName()  + "</span>" + "<BR>";
		}
		
		return subRoleTemp;
	}
	
	public String getAbilityToString () {
		String abilityTemp = "";
		for (Ability a : abilities) {
			abilityTemp += "<b><blockquote>Id: </b>" + a.getId() +  "<BR>";
			abilityTemp += "<b>Name: </b>" + a.getName() +  "<BR>";
			abilityTemp += "<b>Description: </b>" + a.getDescription() + "<BR>";
			abilityTemp += "<b>IsUltimate: </b>" +  a.getIsUltimate() + "<BR>";
			abilityTemp += "<b>Url: </b>" + a.getUrl() + "</blockquote>";
		}
		return abilityTemp;
		
	}


}