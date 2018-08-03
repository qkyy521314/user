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
      //{url:'${pageContext.request.contextPath}/log/querybyXXX?'+name+'='+value }
      $('#ss').searchbox({
          searcher:function(value,name){
				console.log(value,"--",name);
              $('#log').datagrid('load', {
                  name: name,
                  value: value
              });

          },
          menu:'#mm',
          prompt:'请输入值'
      });

  </script>

  <table id="log" class="easyui-datagrid" style="width:14%;height:14%" data-options="title:'日志展示',
       		    																	iconCls:'icon-ok',
       		    																	fit:true,
											    									fitColumns:true,
											    									pagination:true,
											    									pageSize:2,

																					url:'${pageContext.request.contextPath}/log/queryAll'
																								">

	  <input id="ss" style="width: 300px"></input>
	  <div id="mm" style="width:60px">
		  <div data-options="name:'username'">管理员</div>
		  <div data-options="name:'type'">类型</div>
		  <div data-options="name:'createDate'">日期</div>
	  </div>
       		    	<thead>
       		    		<tr>
    						<th data-options="field:'l_id'">id</th>
							<th data-options="field:'username'">管理员名称</th>
							<th data-options="field:'createDate'">创建时间</th>
							<th data-options="field:'detail'">详情</th>
    						<th data-options="field:'type'">类型</th>

    					</tr>     		    		
       		    	</thead>
       		    	<tbody>
       		    	</tbody>
       		    </table>


  </body>
</html>
