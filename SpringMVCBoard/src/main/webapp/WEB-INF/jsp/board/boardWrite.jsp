<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
	<form id="frm">
		<table class="board_view">
			<colgroup>
				<col width="15%"/>
				<col width="*"/>
			</colgroup>
			<caption>게시글 작성</caption>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="TITLE" name="TITLE" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
 					</td>
				</tr>
			</tbody>
		</table>
		<div>
			<a href="#this" class="btn" style="padding-top:2px;" id="list">목록으로</a>
			<a href="#this" class="btn" style="padding-top:2px;" id="write">작성하기</a>
		</div>
		
	</form>
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#list").on("click", function(e){
				e.preventDefault();
				fn_boardList();
			});
			
			$("#write").on("click", function(e){
				e.preventDefault();
				fn_insertBoard();
			});
			
			function fn_boardList(){
				var comSubmit = new ComSubmit();
				//JSTL을 사용하지 않으면 comsubmit.setUrl("/board/boardList.com")이라고 처리하면 된다
				comSubmit.setUrl("<c:url value='/board/boardList.com' />");
				comSubmit.submit();
			}
			
			function fn_insertBoard(){
				//alert($('#TITLE').val());
				//alert($('#CONTENTS').val());
				var comSubmit = new ComSubmit("frm");
				comSubmit.setUrl("<c:url value='/board/insertBoard.com' />");
				comSubmit.submit();
			}
		});
	</script>
</body>
</html>
