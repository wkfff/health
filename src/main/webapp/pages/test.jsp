<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>测试</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Tab/css/form.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/common.css" />
</head>

<body style="overflow:hidden;">
  <!-- 查询条件 -->
  <div id="queryHead" class="panel">
    <div class="panel-title">
      <span>查询条件</span>
    </div>
    <div class="panel-content" style="height:100px;">
      <form id="queryForm"></form>
    </div>
  </div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#queryForm").ligerForm({
		inputWidth: 170, labelWidth: 90, space: 40,
		fields: [
		  {display: "信息标题", name: "descTitle", newline: false, type: "text"},
		  {display: "信息状态", name: "descStatus", newline: false, type: "select", comboboxName: "descStatus", editor: {data: [{value:"10",text:"未发布"},{value:"11",text:"已发布"}]}},
		  {display: "信息类目", name: "descCategory", newline: false, type: "select", comboboxName: "descCategory", editor: {data: [{value:"10",text:"原创"},{value:"11",text:"转载"}]}},
		  {display: "创建开始日期", name: "createBeginDate", newline: true, type: "date"},
		  {display: "创建结束日期", name: "createEndDate", newline: false, type: "date"}
		]
	});
});
</script>
</html>