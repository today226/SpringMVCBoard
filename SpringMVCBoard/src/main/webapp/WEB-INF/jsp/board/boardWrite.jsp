<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
<!-- 해당 폼을 Multipart 형식임을 알려주는데,사진,동영상 등 글자가 아닌 파일은 모두 Multipart 형식의 데이터다. 
파일 관련된 개발을 하다보면 상당히 많은 에러가 나는데, 그 중에서 가장 많은 경우가 form에 enctype="multipart/form-data"가 선언되지 않은 경우-->
	<form id="frm" name="frm" enctype="multipart/form-data">
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
		<input type="file" name="file"/>
		<br/><br/>
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
