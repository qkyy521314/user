<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/script/echarts.min.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<script type="text/javascript">

function selectTab(name,icons,href){
    console.log(href);
	//如果已经存在则选中
	if($("#tt").tabs("exists",name)){
		//选中
		$("#tt").tabs("select",name);
	}else{
	//如果不存在则创建
	$("#tt").tabs("add",{
		title:name,
		iconCls:icons,
		closable:true,
		href:"${pageContext.request.contextPath}/back/view/"+href
	})
	}
}

$(function(){

	//手风琴菜单选项卡
	$.post(
	"${pageContext.request.contextPath}/menu/queryAll",
	function(data){


        //参数1：要遍历的集合  index:循环变量的下标  obj:循环变量
		$.each(data,function(index,obj){

			var content="";
			$.each(obj.menus,function(i,o){
				content+="<a onclick='selectTab(\""+o.text+"\",\""+o.iconCls+"\",\""+o.href+"\")' style='width:100%' class ='easyui-linkbutton' data-options='iconCls:\""+o.iconCls+"\"'>"+o.text+"</a>"
			})

			$("#aa").accordion("add",{
                title:obj.text,
                content:content,
                iconCls:obj.iconCls
            });
			})
	},
	"JSON"
	)
})




</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.login.name} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/logout" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>
       
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
			
		</div>
    </div>
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>
    </div>   
</body> 
</html>