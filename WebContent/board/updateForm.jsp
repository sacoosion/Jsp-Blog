<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<!-- 해당 페이지로 직접 URL(자원에 직접 파일.확장자) 접근을 하게 되면 또 파일 내부에서 세션체크를 해야함. -->
<!-- 필터에 .jsp로 접근하는 모든 접근을 막아버리면 됨. -->

<div class="container">
	<form action="/blog/board?cmd=update&id=${dto.id }" method="POST">
		<%-- <input type="hidden" name="userId" value="${sessionScope.principal.id }"/> --%>
		<input type="hidden" name="id" value="${dto.id }"/>
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" placeholder="title" id="title" name="title"  value="${dto.title }"/>
		</div>
	
		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control" id="summernote" rows="5" id="content" name="content">
				${dto.content }
			</textarea>
		</div>
	
		<button type="submit" class="btn btn-primary">글쓰기 수정</button>
	</form>
</div>

  <script>
    $('#summernote').summernote({
        placeholder: '글을 쓰세요',
        tabsize: 2,
        height: 400
      });
  </script>

</body>
</html>

