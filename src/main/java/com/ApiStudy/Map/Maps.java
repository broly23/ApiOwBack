package com.ApiStudy.Map;

import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

public class Maps {

	public static final String idMode = "id";
	public static final String nameMode = "name";
	public static final String idEvent = "id";
	public static final String nameEvent = "name";
	public static final String startDateEvent = "start_date";
	public static final String endDateEvent = "end_date";
	public static final String urlEvent = "url";
	
	private Integer id;
	private String name;
	private String location;
	private String url;
	private Map<String, String> mode;
	private List<Stage> stages = null;
	private Map<String, String> event;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Map<String, String> getMode() {
		return mode;
	}

	public void setMode(Map<String, String> mode) {
		this.mode = mode;
	}

	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	public Map<String, String> getEvent() {
		return event;
	}

	public void setEvent(Map<String, String> event) {
		this.event = event;
	}

	public String getModeToString() {
		String modeTemp = "";
		modeTemp += StringUtils.capitalize(this.getMode().get(nameMode));
		modeTemp += "(" + "<b>Id: </b>" + (this.getMode().get(idMode)) + ")";
		return modeTemp;
	}

	public String getStageToString() {
		String stageTemp = "<BR>";
		if (getStages() == null || getStages().size() == 0) {
			stageTemp = "No Stage<BR>"; 
		} else {
			for (Stage s : stages) {
				stageTemp += "<b><span style=\"margin-left:2em\">Id: </b>" + s.getId() + "</span><BR>";
				stageTemp += "<b><span style=\"margin-left:2em\">Nome: </b>" + s.getName()  + "</span><BR>";
			}
		}
		return stageTemp;
	}
	
		public String getEventToString() {
			String eventTemp = "";
			if (getEvent() == null) {
				eventTemp += "No Event"; 
			} else {
				eventTemp += "<BR><b><span style=\"margin-left:2em\">Id: </b>" + this.getEvent().get(idEvent) + "</span><BR>";
				eventTemp += "<b><span style=\"margin-left:2em\">Name: </b>" + this.getEvent().get(nameEvent) + "</span><BR>";
				eventTemp += "<b><span style=\"margin-left:2em\">Start Date: </b>" + this.getEvent().get(startDateEvent) + "</span><BR>";
				eventTemp += "<b><span style=\"margin-left:2em\">End Date: </b>" + this.getEvent().get(endDateEvent)+ "</span><BR>";
				eventTemp += "<b><span style=\"margin-left:2em\">Url: </b>" + this.getEvent().get(urlEvent) + "</span><BR>";
			}
				return eventTemp;
		}
}
