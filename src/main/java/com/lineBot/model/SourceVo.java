package com.lineBot.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceVo implements Serializable{
	private static final long serialVersionUID = 9110953629645065400L;
	
	@JsonProperty("replyToken")
	private String replyToken;
	@JsonProperty("mode")
	private String mode;
	
	public String getReplyToken() {
		return replyToken;
	}
	public void setReplyToken(String replyToken) {
		this.replyToken = replyToken;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
