package com.lineBot.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventVo implements Serializable {
	private static final long serialVersionUID = 6787736678144530974L;
	
	@JsonProperty("type")
	private String type;
	@JsonProperty("message")
	private MessageVo message;
	@JsonProperty("messages")
	private List<MessageVo> messages;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("source")
	private SourceVo source;
	@JsonProperty("replyToken")
	private String replyToken;
	@JsonProperty("mode")
	private String mode;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MessageVo getMessage() {
		return message;
	}

	public void setMessage(MessageVo message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public SourceVo getSource() {
		return source;
	}

	public void setSource(SourceVo source) {
		this.source = source;
	}

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

	public List<MessageVo> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageVo> messages) {
		this.messages = messages;
	}
	
	

}
