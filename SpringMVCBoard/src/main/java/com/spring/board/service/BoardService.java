package com.spring.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

	void insertBoard(Map<String, Object> map) throws Exception;

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	Map<String, Object> updateBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map) throws Exception;

	void deleteBoard(Map<String, Object> map) throws Exception;
}
