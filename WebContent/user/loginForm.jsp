<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="/blog/user?cmd=login" method="POST" onsubmit="return valid()">
		<div class="form-group">
			<input type="text" name="username" id="username" class="form-control" 	placeholder="Enter Username" />
		</div>
		<div class="form-group">
			<input type="password" name="password" class="form-control" placeholder="Enter Password" required />
		</div>
		<button type="submit" class="btn btn-primary">로그인완료</button>
	</form>
</div>

</body>
</html>