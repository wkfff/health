<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>菜单管理</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/ligerui-icons.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
  <link rel="stylesheet" href="${ctp}/styles/main/jquery-accordion-menu.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/common.css" />
  <link rel="stylesheet" href="${ctp}/styles/common/gh-buttons.css" />
</head>

<body style="overflow:hidden;">
<!-- 
  <div id="menuLayout">
    <div id="treeDiv" position="left"><div id="menuToolbar"></div><ul id="leftTree"></ul></div>
    <div id="centerOpt" position="center">
      <form id="dataForm"></form>
      <div class="left-button">
        <a id="submitBtn" href="javascript:void(0);" class="button icon approve">提交</a>
      </div>
    </div>
  </div>
 -->
  <div class="l-clear"></div>
  <div id="mainGrid"></div>
  <div style="display:none;">
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/jquery-validation/messages_cn.js"></script>
<script type="text/javascript" src="${ctp}/scripts/common/menuManager.js"></script>
<script type="text/javascript">
	$(function() {
		menuManager.initPage();
	});
</script>
</html>