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

      var dg;
      var tools = [
          {iconCls:'icon-add',handler:function(){
              $("#addpicture").dialog("open");
          }},
          '-',
          {iconCls:'icon-edit',handler:function(){
              dg = $("#picture").datagrid("getSelected");
              $.messager.confirm('确认','你确认要下载吗？',function(r){
                  if(r && dg){
                      <%--location.href="${pageContext.request.contextPath}/picture/down?p_id="+dg.p_id;--%>
                      $.ajax({
                          type:"get",
                          url:"${pageContext.request.contextPath}/picture/down?p_id="+dg.p_id,
                          success:function(ret){
								if(ret=='ok'){
                                    $.messager.show({
                                        title:'下载成功',
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
              //$("#updatepicture").dialog("open");
              console.log(dg);
          }} ,'-' ,
          {iconCls:'icon-remove',handler:function(){
              dg = $("#picture").datagrid("getSelected");
              $.messager.confirm('确认','你确认要删除记录吗？',function(r){
                      if(r && dg){
                          console.log(dg);
                          $.ajax({
                              type:"get",
                              url:"${pageContext.request.contextPath}/picture/delete?p_id="+dg.p_id,
                              success:function(ret){
                                  $("#picture").datagrid("reload");
                              }
                          });

                      }else {
                          $.messager.show({
                              title:'请选择文件',
                              timeout:2000,
                              showType:'fade'
                          });
                      }
                  }
              );
          }}
      ];
      var updatebats=[
          {text:'更新',handler:function(){
              $("#person1").form("submit",{
                  url:"${pageContext.request.contextPath}/Person/update",
                  onSubmit:function(person){

                      return $("#person1").form("validate") ;
                  },
                  success:function(ret){
                      console.log(ret);
                      if(ret=='ok'){
                          $.messager.show({
                              title:'更新成功',
                              timeout:2000,
                              showType:'fade'
                          });
                          $("#dg").datagrid("reload");
                      }
                  }
              });

              $("#update").dialog("close");
          }},
          {text:'取消',handler:function(){
              $("#update").dialog("refresh").dialog("close");
          }}
      ];

      //dialog添加的按钮
      var addpicturebats=[
          {text:'添加',handler:function(){

              $("#addpicture2").form("submit",{

                  url:"${pageContext.request.contextPath}/picture/up",
                  onSubmit:function(s){
                      console.log(s);

                      return $("#addpicture").form("validate") ;
                  },
                  success:function(ret){
                      if(ret=='ok'){
                          $.messager.show({
                              title:'消息',
                              timeout:2000,
                              showType:'slide',
                              msg:'恭喜您，添加成功！'
                          });
                          $("#picture").datagrid("reload");
                      }
                  }
              });

              $("#addpicture").dialog("refresh").dialog("close");
          }},
          {text:'取消',handler:function(){
              $("#addpicture").dialog("close");
          }}
      ];


      function purl(value,row,index){

          if(value) {
              var url = "http://192.168.11.129/group1/" + value;

              return "<img src="+url+" width='40px' height='30px'>";

          }
          else return null;
      }
  </script>
        <table id="picture" class="easyui-datagrid" style="width:14%;height:14%" data-options="title:'轮播图展示',
       		    																	iconCls:'icon-ok',
       		    																	fit:true,
											    									fitColumns:true,
											    									pagination:true,
											    									pageSize:2,
											    									toolbar:tools,
																					url:'${pageContext.request.contextPath}/picture/queryAll'
																								">


       		    	<thead>
       		    		<tr>
    						<th data-options="field:'p_id'">id</th>
							<th data-options="field:'p_name'">图片名称</th>
							<th data-options="field:'p_url',formatter:purl">图片地址</th>
    						<th data-options="field:'p_state'">状态</th>
    						<th data-options="field:'html_url'">超链接</th>

    					</tr>     		    		
       		    	</thead>
       		    	<tbody>
       		    	</tbody>
       		    </table>
		<div class="easyui-dialog" id="addpicture"  title="add" style="width: 400px;height:200px "
			 data-options="iconCls:'icon-add',
    						  closed:true,
    					      modal:true,
    						  buttons:addpicturebats,
    						  href:'${pageContext.request.contextPath}/back/view/picture/add.jsp',
    						 ">
		</div>

  </body>
</html>
