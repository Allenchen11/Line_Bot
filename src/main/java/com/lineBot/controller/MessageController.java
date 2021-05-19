package com.lineBot.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lineBot.service.LineBotService;

@RestController
public class MessageController {

	private Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private HttpServletRequest request;
	@Value("${line.bot.channelSecret}")
	private String channelSecret;
	@Value("${line.bot.channelToken}")
	private String channelToken;

	@Autowired
	LineBotService lineBotService;

	@RequestMapping("/replyMessage")
	public HttpStatus replyMessage(@RequestBody String requestbody,
			@RequestHeader("x-line-signature") String requestHeader) {
		logger.info("receiced requestbody : " + requestbody);

		lineBotService.replyMessage(requestbody);

		return HttpStatus.OK;

	}

	@RequestMapping("/pushMessage")
	public HttpStatus pushMessage() {
		try {
			String text = request.getParameter("text");

			lineBotService.pushMessage(text);

		} catch (Exception e) {
			logger.error(e.toString());
		}

		return HttpStatus.OK;

	}

	@RequestMapping("/test")
	public String test() {

		try {
//			List<LineRequestVo> lineRequestVoList = lineRequestRepo.findAll();
//			System.out.println(lineRequestVoList.size());
//			for (LineRequestVo aLineRequestVo : lineRequestVoList) {
//				logger.info(aLineRequestVo.getId());
//				logger.info(aLineRequestVo.getDestination());
//			}

//			String json = "{\"destination\":\"U451d36478fe04cabf9b7ad14f6f\",\"events\":[{\"type\":\"message\",\"message\":{\"type\":\"text\",\"id\":\"14073168138\",\"text\":\"我肏!!!!!!\"},\"timestamp\":1621345940015,\"source\":{\"type\":\"user\",\"userId\":\"U6c36f546eff3ede1809902a5df14\"},\"replyToken\":\"5f22dfaec2ab43e31198c4a65\",\"mode\":\"active\"}]}";

//			Gson gson = new Gson();
//			LineRequestVo lineRequestVo = gson.fromJson(json, LineRequestVo.class);
//
//			logger.info("Destination: " + lineRequestVo.getDestination());
//			logger.info("Events :" + lineRequestVo.getEvents());
//			logger.info("Events size:" + lineRequestVo.getEvents().size());

//			logger.info("Destination == " + lineRequestVo.getDestination());
//			logger.info("Events == " + lineRequestVo.getEvents());
		} catch (Exception e) {
			return e.toString();
		}

		return "success!";

	}

}
