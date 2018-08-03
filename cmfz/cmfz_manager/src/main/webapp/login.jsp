<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="back/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="back/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="back/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="back/script/jquery.js"></script>
	<script type="text/javascript" src="back/script/common.js"></script>
	<script type="text/javascript">

		$(function(){
			<%--//点击更换验证码：--%>
			<%--$("#captchaImage").click(function(){//点击更换验证码--%>
				<%--$("#captchaImage").src("${pageContext.request.contextPath}/manager/imageCode"+Math.random());--%>

			<%--});--%>
			
			//  form 表单提交
			$("#loginForm").bind("submit",function(a){

                console.log(a);
                //	return false;
			});
			
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/manager/login" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="back/img/header_logo.gif" alt=".."/>
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="name" class="text" value="" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/manager/imageCode" title="点击更换验证码" onclick="this.src=this.src+'?'"/>
							</td>
						</tr>					
			
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2005-2013.</div>
				<div class="link">
					<a href="">前台首页</a> |
					<a href="">官方网站</a> |
					<a href="">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>