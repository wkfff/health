<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>角色管理</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/ligerui-icons.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/common.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/gh-buttons.css" />
</head>

<body style="overflow:hidden;">
  <div id="queryHead" class="panel">
    <div class="panel-title">
      <span>查询条件</span>
      <div class="panel-button">
        <a id="search" href="javascript:void(0);" class="button icon search">查询</a>
      </div>
    </div>
    <div class="panel-content" style="height:50px;">
      <form id="queryForm"></form>
    </div>
  </div>
  <div id="maingrid"></div>
  <div style="display:none;"></div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/common/roleManager.js"></script>
<script type="text/javascript">
	$(function() {
		roleManager.initPage();
	});
</script>
</html>