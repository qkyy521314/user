<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
  <body>
  	
    <form id="adduser3" action="${pageContext.request.contextPath }/user/up" method="post" enctype="multipart/form-data">
    
    	<div>
			<h3>请选择文件:</h3>
			<input class="easyui-filebox" style="width:300px" name="source" >
    	</div>
    </form>
 
  </body>
