<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
	<h2>게시판 목록</h2>
	<table class="board_list">
		<colgroup>
			<col width="10%"/>
			<col width="*"/>
			<col width="15%"/>
			<col width="20%"/>
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(list) > 0 }">
					<c:forEach items="${list}" var="row">
						<tr>
							<td>${row.IDX}</td>
							<td class="title">
								<a href="#this" name="title">${row.TITLE}</a>
								<input type="hidden" id="IDX" value="${row.IDX }">
							</td>
							<td>${row.HIT_CNT}</td>
							<td>${row.CREA_DTM}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<br />
	<a href="this" class="btn" id="write">글쓰기</a>
	
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#write").on("click", function(e){
				e.preventDefault();
				fn_boardWrite();
			});
			
			$("a[name='title']").on("click", function(e){
				e.preventDefault();
				fn_boardDetail($(this));
			});
		});
		
		function fn_boardWrite(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/boardWrite.com' />");
			comSubmit.submit();
		}
		
		function fn_boardDetail(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/selectBoardDetail.com' />");
			//obj.parent().find("#IDX").val()은 jQuery를 이용하여 선택된 <a> 태그의 부모 노드 내에서 IDX라는 값을 가진 태그를 찾아서 그 태그의 값을 가져오도록 한 것
			comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
			comSubmit.submit();
		}
	</script>
</body>
</html>