package com.lineBot.service;

import org.springframework.stereotype.Service;

import com.linecorp.bot.model.response.BotApiResponse;

@Service
public interface LineBotService {
	public BotApiResponse replyMessage(String lineRequestJsonData);
	
	public BotApiResponse pushMessage(String sendText);
}


