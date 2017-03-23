<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp"%>
<html>
<head>
<%@ include file="head.jsp"%>
<title>登录</title>
</head>
<body>
<div class="demo form-bg" style="padding: 20px 0px 20px 0px; top: 25%; position: relative">
<div class="container">
	<div class="row">
		<div class="col-md-offset-3 col-md-6">
			<form class="form-horizontal" action="${ctx}/user/login" method="post">
				<span class="heading">用户登录</span>
				<div class="form-group">
					<input type="text" class="form-control" id="inputEmail3" value="${user.userName}" name="userName" placeholder="用户名或电子邮件">
					<i class="fa fa-user"></i>
				</div>
				<div class="form-group help">
					<input type="password" class="form-control" id="inputPassword3" value="${user.password}" name="password" placeholder="密　码">
					<i class="fa fa-lock"></i>
					<a href="#" class="fa fa-question-circle"></a>
				</div>
				<div class="form-group">
					<div class="main-checkbox">
						<input type="checkbox" value="None" id="checkbox1" name="check"/>
						<label for="checkbox1"></label>
					</div>
					<span class="text">Remember me</span>
					<button type="submit" class="btn btn-default">登录</button>
					<font color="red">${errorMsg }</font>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</body>
</html>