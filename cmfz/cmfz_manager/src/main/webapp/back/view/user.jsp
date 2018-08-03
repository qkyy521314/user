<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<!-- 导入顺序固定 -->
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/gray/easyui.css">
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
	  <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.easyui.min.js"></script>

  </head>
  
  <body>
  <script type="text/javascript">

      //dialog添加的按钮
      var adduserbats=[
          {text:'添加',handler:function(){

              $("#adduser2").form("submit",{

                  url:"${pageContext.request.contextPath}/user/adds",
                  onSubmit:function(s){


                      return $("#adduser2").form("validate") ;
                  },
                  success:function(ret){
                      if(ret=='ok'){
                          $.messager.show({
                              title:'消息',
                              timeout:2000,
                              showType:'slide',
                              msg:'恭喜您，添加成功！'
                          });
                          $("#user").datagrid("reload");
                      }
                  }
              });

              $("#adduser").dialog("refresh").dialog("close");
          }},
          {text:'取消',handler:function(){
              $("#adduser").dialog("close");
          }}
      ];

      var adduserfilebats=[
          {text:'添加',handler:function(){

              $("#adduser3").form("submit",{

                  url:"${pageContext.request.contextPath}/user/up",
                  onSubmit:function(s){


                      return $("#adduser3").form("validate") ;
                  },
                  success:function(ret){
                      if(ret=='ok'){
                          $.messager.show({
                              title:'消息',
                              timeout:2000,
                              showType:'slide',
                              msg:'恭喜您，添加成功！'
                          });
                          $("#user").datagrid("reload");
                      }
                  }
              });

              $("#adduserfile").dialog("refresh").dialog("close");
          }},
          {text:'取消',handler:function(){
              $("#adduserfile").dialog("close");
          }}
      ];
      var dg;
      var toolusers = [
          {iconCls:'icon-add',text:'全部导出',handler:function(){
              $.messager.confirm('确认','你确认要导出全部记录吗？',function(r){
                  location.href="${pageContext.request.contextPath}/user/down";
                  <%--if(r){--%>
                      <%--console.log(dg);--%>
                      <%--$.ajax({--%>
                          <%--type:"get",--%>
                          <%--url:"${pageContext.request.contextPath}/user/down",--%>
                          <%--success:function(ret){--%>
                              <%--console.log(ret);--%>
                              <%--$("#picture").datagrid("reload");--%>
                          <%--}--%>
                      <%--});--%>

                  <%--}--%>
              });
          }},
		  '-',
          {iconCls:'icon-add',text:'自定义导出',handler:function(){

          }},
          '-',
          {iconCls:'icon-edit',text:'导入模板下载',handler:function(){

          }},
		  '-',
          {iconCls:'icon-remove',text:'导入',handler:function(){
              $("#adduserfile").dialog("open");
          }},
		  '-',
          {iconCls:'icon-add',text:'添加',handler:function(){
              $("#adduser").dialog("open");
          }}
      ];

      // 模拟表单提交同步方式下载文件
      // 能够弹出保存文件对话框
      function downloadFileByForm() {
          console.log("ajaxDownloadSynchronized");
          var url = "http://localhost:8080/ajaxDownloadServlet.do";
          var fileName = "testAjaxDownload.txt";
          var form = $("<form></form>").attr("action", url).attr("method", "post");
          form.append($("<input></input>").attr("type", "hidden").attr("name", "fileName").attr("value", fileName));
          form.appendTo('body').submit().remove();
      }

  </script>
        <table id="user" class="easyui-datagrid" style="width:14%;height:14%" data-options="title:'用户管理',
       		    																	iconCls:'icon-ok',
       		    																	fit:true,
											    									fitColumns:true,
											    									pagination:true,
											    									pageSize:2,
											    									toolbar:toolusers,
																					url:'${pageContext.request.contextPath}/user/queryAll'
																								">


       		    	<thead>
       		    		<tr>
    						<th data-options="field:'u_id'">id</th>
							<th data-options="field:'mobilephone'">账号</th>
							<th data-options="field:'password'">密码</th>
    						<th data-options="field:'head_portrait'">头像</th>
    						<th data-options="field:'b_name'">法名</th>
							<th data-options="field:'username'">姓名</th>
							<th data-options="field:'address'">地址</th>
							<th data-options="field:'signature'">签名</th>
							<th data-options="field:'c_state'">状态</th>
							<th data-options="field:'age'">年龄</th>
							<th data-options="field:'u_ip'">登陆IP</th>
							<th data-options="field:'registdate'">注册时间</th>
							<th data-options="field:'salt'">盐</th>



    					</tr>     		    		
       		    	</thead>
       		    	<tbody>
       		    	</tbody>
       		    </table>
		<div class="easyui-dialog" id="adduser"  title="add" style="width: 400px;height:600px "
			 data-options="iconCls:'icon-add',
    						  closed:true,
    					      modal:true,
    						  buttons:adduserbats,
    						  href:'${pageContext.request.contextPath}/back/view/user/add.jsp',
    						 ">
		</div>

  		<div class="easyui-dialog" id="adduserfile"  title="add" style="width: 400px;height:200px "
	  		 data-options="iconCls:'icon-add',
    						  closed:true,
    					      modal:true,
    						  buttons:adduserfilebats,
    						  href:'${pageContext.request.contextPath}/back/view/user/addfile.jsp',
    						 ">
  		</div>

  </body>
</html>
