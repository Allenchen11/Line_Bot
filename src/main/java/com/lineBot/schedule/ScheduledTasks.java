package com.lineBot.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lineBot.service.LineBotService;

@Component
public class ScheduledTasks {

	@Autowired
	LineBotService lineBotService;

	@Value("${morningPushText}")
	String morningPushText;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "0 45 8 * * * ")
	public void morningPush() {
		morningPushText = "早安!現在早上8:45分，台指期開始了，台股也將於15分鐘後開盤。讓我們今天一起賺錢吧!!!";
		lineBotService.pushMessage(morningPushText);
		logger.info("===cron: 時間:{}", dateFormat.format(new Date()) + " 訊息推播完成");
	}
}
