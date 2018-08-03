<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  <body>
  	
    <form id="addarticle2"  method="post" >
    	<div>
    		标题:
    		<input class="easyui-textbox"  name="title"  data-options="required:true,
    																			   iconCls:'icon-man',
    																			   iconAlign:'left'
    																			   ">
    	</div>
    	<div>
    		作者:
    		<input class="easyui-textbox"  name="author"  data-options="required:true,
    																			   
    																			   iconAlign:'left'
    																			   ">
    	</div>
    	<div>
			插图:
    		<input class="easyui-textbox"  name="illustration"  data-options="required:true,
    																			  
    																			   iconAlign:'left'
    																			   ">
    	</div>
    	
    	<div>
			详情:
			<input class="easyui-textbox"  name="particulars"  data-options="required:true,

    																			   iconAlign:'left'
    																			   ">
    	</div>



  		
    </form>
 	
  </body>
</html>
