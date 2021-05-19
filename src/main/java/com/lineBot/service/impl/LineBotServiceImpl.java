package com.lineBot.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.lineBot.model.EventVo;
import com.lineBot.model.LineRequestVo;
import com.lineBot.repo.LineRequestRepo;
import com.lineBot.service.LineBotService;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

@Service
public class LineBotServiceImpl implements LineBotService {

	private Logger logger = LoggerFactory.getLogger(LineBotService.class);

	@Autowired
	private HttpServletRequest request;
	@Value("${line.bot.channelSecret}")
	private String channelSecret;
	@Value("${line.bot.channelToken}")
	private String channelToken;

	@Autowired
	private LineRequestRepo lineRequestRepo;

	@Override
	public BotApiResponse replyMessage(String lineRequestJsonData) {

		try {
			Gson gson = new Gson();
			LineRequestVo lineRequestVo = gson.fromJson(lineRequestJsonData, LineRequestVo.class);
			EventVo eventVo = new EventVo();
			String messageFromUser = "";

			List<EventVo> eventVoList = lineRequestVo.getEvents();
			for (EventVo aEventVo : eventVoList) {
				eventVo.setReplyToken(aEventVo.getReplyToken());
				messageFromUser = aEventVo.getMessage().getText();
			}

			final LineMessagingClient client = LineMessagingClient.builder(channelToken).build();

			String sendToUserText = "Hi !!! 你剛剛是說「 " + messageFromUser + " 」嗎?  希望有機會能夠幫得上你的忙";

			final TextMessage textMessage = new TextMessage(sendToUserText);
			final ReplyMessage replyMessage = new ReplyMessage(eventVo.getReplyToken(), textMessage);

			final BotApiResponse botApiResponse;

			botApiResponse = client.replyMessage(replyMessage).get();

			logger.info("botApiResponse : " + botApiResponse);

			if (botApiResponse != null) {
				lineRequestRepo.save(lineRequestVo);
			}

			return botApiResponse;

		} catch (Exception e) {
			logger.error(e.toString());
		}
		return null;
	}
	
	@Override
	public BotApiResponse pushMessage(String sendText) {

		try {
			final LineMessagingClient client = LineMessagingClient.builder(channelToken).build();

			final TextMessage textMessage = new TextMessage(sendText);
			final PushMessage pushMessage = new PushMessage(channelSecret, textMessage);

			final BotApiResponse botApiResponse;
			botApiResponse = client.pushMessage(pushMessage).get();
			logger.info("botApiResponse : " + botApiResponse);

		} catch (Exception e) {
			logger.error(e.toString());
		}
		return null;

	}

}
