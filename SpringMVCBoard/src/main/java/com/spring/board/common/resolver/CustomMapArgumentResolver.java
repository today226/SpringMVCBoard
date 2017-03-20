package com.spring.board.common.resolver;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.spring.board.common.map.CommandMap;

//MapArguemtResolver를 등록하지 않았다면, 컨트롤러에서 request.getParameter 메서드 등을 이용하여 하나하나씩 
//값을 가져와야 하기 때문에 상당히 번거롭고 코드가 길어지게 된다 
//(사실 Annotation을 이용하여 그러한 과정을 생략할 수 있지만, 위에서 이야기한것처럼 값을 수정하거나 추가하기 위해서 MapArguementResolver를 등록
public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver {

	//supportsParameter 메서드는 Resolver가 적용 가능한지 검사하는 역할
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	}

	//resolverArgument 메서드는 파라미터와 기타 정보를 받아서 실제 객체를 반환
	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();
		
		String key = null;
		String[] values = null;
		//request에 있는 값을 iterator를 이용하여 하나씩 가져오는 로직
		while(enumeration.hasMoreElements()){
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if(values != null){
				//request에 담겨있는 모든 키(key)와 값(value)을 commandMap에 저장
				commandMap.put(key, (values.length > 1) ? values: values[0]);
			}
		}
		return commandMap;
	}
}
