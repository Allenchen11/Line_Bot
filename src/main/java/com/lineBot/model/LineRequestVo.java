package com.lineBot.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="LineRequest")
public class LineRequestVo implements Serializable{
	private static final long serialVersionUID = 8526107141962896527L;
	
	@Id
    public String id;
	@Field("destination")
	@JsonProperty("destination")
	private String destination;
	@Field("events")
	@JsonProperty("events")
	private List<EventVo> events;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<EventVo> getEvents() {
		return events;
	}

	public void setEvents(List<EventVo> events) {
		this.events = events;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
