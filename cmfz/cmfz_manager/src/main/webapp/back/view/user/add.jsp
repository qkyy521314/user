<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  <body>
  	
    <form id="adduser2"  method="post" >
    	<div>
    		账号:
    		<input class="easyui-textbox"  name="mobilephone"  data-options="required:true,
    																			   iconCls:'icon-man',
    																			   iconAlign:'left'
    																			   ">
    	</div>
    	<div>
    		密码:
    		<input class="easyui-textbox"  name="password"  data-options="required:true,
    																			   
    																			   iconAlign:'left'
    																			   ">
    	</div>
    	<div>
			头像:
    		<input class="easyui-textbox"  name="head_portrait"  data-options="required:true,
    																			  
    																			   iconAlign:'left'
    																			   ">
    	</div>
    	
    	<div>
			法名:
			<input class="easyui-textbox"  name="b_name"  data-options="required:true,

    																			   iconAlign:'left'
    																			   ">
    	</div>

		<div>
			昵称:
			<input class="easyui-textbox"  name="username"  data-options="required:true,
    																			   iconAlign:'left'
    																			   ">
		</div>

		<div>
			地址:
			<input class="easyui-textbox"  name="address"  data-options="required:true,
    																			   iconAlign:'left'
    																			   ">
		</div>

		<div>
			个性签名:
			<input class="easyui-textbox"  name="signature"  data-options="required:true,
    																			   iconAlign:'left'
    																			   ">
		</div>

		<div>
			登录IP:
			<input class="easyui-textbox"  name="u_ip"  data-options="required:true,
    																			   iconAlign:'left'
    																			   ">
		</div>

  		
    </form>
 	
  </body>
</html>
