<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>人员选择</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/ligerui-icons.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
  <script type="text/javascript">
  var roleId = "${roleId}";
  </script>
</head>

<body style="overflow:hidden;">
  <div id="query" style="margin: 5px 0px 5px 5px;">
    人员名称：<input type="text" id="userName" name="userName">
    <button id="searchBtn" style="height:22px; margin-left:5px;">查询</button>
  </div>
  <div id="maingrid"></div>
  <div style="display:none;"></div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/common/userSelect.js"></script>
<script type="text/javascript">
	$(function() {
		userSelect.initPage();
	});
</script>
</html>