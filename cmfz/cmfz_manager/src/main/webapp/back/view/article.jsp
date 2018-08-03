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

      $('#ss1').searchbox({
          searcher:function(value,name){
              console.log(value,"--",name);
              $('#article').datagrid('load', {
                  name: name,
                  value: value
              });

          },
          menu:'#mm1',
          prompt:'请输入值'
      });

      var dg;
      var articletools = [
          {iconCls:'icon-down',handler:function(){
              dg = $("#article").datagrid("getSelected");
              $.messager.confirm('确认','你确认要生成HTML吗？',function(r){
                  if(r && dg){

                      $.ajax({
                          type:"get",
                          url:"${pageContext.request.contextPath}/article/create?title="+dg.title,
                          success:function(ret){
								if(ret){
                                    $.messager.show({
                                        title:'生成成功',
                                        timeout:2000,
                                        showType:'fade'
                                    });
								}
                          }
                      });

                  }else {
                      $.messager.show({
                          title:'请选择文件',
                          timeout:2000,
                          showType:'fade'
                      });
                  }
              });
          }},
          '-' ,
          {iconCls:'icon-add',handler:function(){
              $("#addArticle").dialog("open");
          }},
          '-' ,
          {iconCls:'icon-save',handler:function(){
              dg = $("#article").datagrid("getSelected");
              $.messager.confirm('确认','你确认要点击阅读吗？',function(r){
                  if(r && dg){
                      $.ajax({
                          type:"get",
                          url:"${pageContext.request.contextPath}/article/click?title="+dg.title,
                          success:function(ret){
                              if(ret){
                                  $.messager.show({
                                      title:'点击成功',
                                      timeout:2000,
                                      showType:'fade'
                                  });
                              }
                          }
                      });

                  }else {
                      $.messager.show({
                          title:'请选择文件',
                          timeout:2000,
                          showType:'fade'
                      });
                  }
              });
          }}
      ];

      //dialog添加的按钮
      var addaddArticlebats=[
          {text:'添加',handler:function(){

              $("#addarticle2").form("submit",{

                  url:"${pageContext.request.contextPath}/article/add",
                  onSubmit:function(s){
                      console.log(s);

                      return $("#addarticle2").form("validate") ;
                  },
                  success:function(ret){
                      if(ret=='ok'){
                          $.messager.show({
                              title:'消息',
                              timeout:2000,
                              showType:'slide',
                              msg:'恭喜您，添加成功！'
                          });
                          $("#article").datagrid("reload");
                      }
                  }
              });

              $("#addArticle").dialog("refresh").dialog("close");
          }},
          {text:'取消',handler:function(){
              $("#addArticle").dialog("close");
          }}
      ];

  </script>

  <table id="article" class="easyui-datagrid" style="width:14%;height:14%" data-options="title:'文章展示',
       		    																	iconCls:'icon-ok',
       		    																	fit:true,
											    									fitColumns:true,
											    									pagination:true,
											    									pageSize:2,
																					toolbar:articletools,
																					url:'${pageContext.request.contextPath}/article/queryAll'
																								">
	  <input id="ss1" style="width: 300px"></input>
	  <div id="mm1" style="width:60px">
		  <div data-options="name:'keyword'">关键字</div>
	  </div>

       		    	<thead>
       		    		<tr>
    						<th data-options="field:'a_id'">id</th>
							<th data-options="field:'title'">标题</th>
							<th data-options="field:'author'">作者</th>
							<th data-options="field:'illustration'">插图</th>
    						<th data-options="field:'particulars'">内容</th>
							<th data-options="field:'publish_date'">出版日期</th>
							<th data-options="field:'a_state'">状态</th>
    					</tr>     		    		
       		    	</thead>
       		    	<tbody>
       		    	</tbody>
       		    </table>

  </div>

  <div class="easyui-dialog" id="addArticle"  title="add" style="width: 400px;height:200px "
	   data-options="iconCls:'icon-add',
    						  closed:true,
    					      modal:true,
    						  buttons:addaddArticlebats,
    						  href:'${pageContext.request.contextPath}/back/view/article/add.jsp',
    						 ">
  </div>

  </body>
</html>
