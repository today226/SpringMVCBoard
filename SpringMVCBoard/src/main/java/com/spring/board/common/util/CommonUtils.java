package com.spring.board.common.util;

import java.util.UUID;

public class CommonUtils {
	
	//32������ ������ ���ڿ�(��������)�� ���� ��ȯ���ִ� ���
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
