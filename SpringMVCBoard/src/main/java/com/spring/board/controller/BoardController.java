package com.spring.board.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/board/openBoardList.com")
	public ModelAndView openBoardList(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("");
		log.debug("인터셉터 테스트");
		return mv;
	}
}
