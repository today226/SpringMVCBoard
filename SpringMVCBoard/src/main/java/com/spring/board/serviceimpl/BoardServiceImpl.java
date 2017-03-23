package com.spring.board.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDAO;
import com.spring.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(
			Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		boardDAO.insertBoard(map) ;
		
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map)
			throws Exception {
		boardDAO.updateHitCnt(map);
		Map<String, Object> resultMap = boardDAO.selectBoardDetail(map);
		return resultMap;
	}

	@Override
	public Map<String, Object> updateBoardDetail(Map<String, Object> map)
			throws Exception {
		Map<String, Object> resultMap = boardDAO.selectBoardDetail(map);
		return resultMap;
	}
	
	
}
