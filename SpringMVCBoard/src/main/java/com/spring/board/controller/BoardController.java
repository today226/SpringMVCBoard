package com.spring.board.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.common.logger.ParameterLogger;
import com.spring.board.common.map.CommandMap;
import com.spring.board.service.BoardService;


@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardList.com")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap);
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value="/board/boardWrite.com")
	public ModelAndView boardWrite(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value="/board/testMapArgumentResolver.com")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("");
		
		if(commandMap.isEmpty() == false){
			Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String, Object> entry = null;
			while(iterator.hasNext()){
				entry = iterator.next();
				log.debug("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
		}
		return mv;
	}	
	
	@RequestMapping(value="/board/insertBoard.com")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
		ParameterLogger parameterLogger = new ParameterLogger();
		parameterLogger.outputParameters(commandMap);
		ModelAndView mv = new ModelAndView("redirect:/board/boardList.com");
		boardService.insertBoard(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping(value="/board/selectBoardDetail.com")
	public ModelAndView selectBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map);
		return mv;
	}	
	
	@RequestMapping(value="/board/updateBoardUpdate.com")
	public ModelAndView boardUpdateDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardUpdate");
		
		ParameterLogger parameterLogger = new ParameterLogger();
		parameterLogger.outputParameters(commandMap);
		
		Map<String, Object> map = boardService.updateBoardDetail(commandMap.getMap());
		mv.addObject("map", map);
		return mv;
	}
	
	@RequestMapping(value="/board/boardUpdate.com")
	public ModelAndView boardUpdate(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/selectBoardDetail.com");
		boardService.updateBoard(commandMap.getMap());
		mv.addObject("IDX", commandMap.get("IDX"));
		ParameterLogger parameterLogger = new ParameterLogger();
		parameterLogger.outputParameters(commandMap);
		return mv;
		
	}
}