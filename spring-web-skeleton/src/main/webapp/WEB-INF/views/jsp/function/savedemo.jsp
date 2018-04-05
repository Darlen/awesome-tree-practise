<%@ include file="../common/includes.jsp"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="${_contextPath}/static/js/jquery-1.11.0.min.js"></script>
</head>
<body>

	<form:form method="post" id="user" commandName="user"
		action="${_contextPath}/user/save">
		<div class="main">
			<div class="login">
				<ul>
					<li><span>id:</span> ${demo.id}</li>
					<li><span>nickname:</span> <input type="text"
						name="nickname" id="nickname" value="${demo.nickname}"/></li>
					<li><span>email:</span> <input type="text"
						name="email" id="email" value="${demo.email}"/></li>
					<li><span>createTime:</span> <input type="text"
						name="createTime" id="createDate" value="${demo.createTime}"/></li>
					<li><span>modifyTime:</span> <input type="text"
						name="modifyTime" id="modifyDate" value="${demo.modifyTime}"/></li>

				</ul>


				<div class="botton">
					<input name="demo" type="submit"
						value="submit"  />
				</div>
			</div>
		</div>
	</form:form>
<form action="${_contextPath}/user/uploadPic" enctype="multipart/form-data" method="post">
    <input type="hidden" name="method" value="uploadPic"/>
    <input type="file" name="file"/>
    <input type="submit" value="upload"/>
</form>
</body>



</html>