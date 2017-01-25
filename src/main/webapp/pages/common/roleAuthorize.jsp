<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>角色授权</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/ligerui-icons.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
</head>

<body style="overflow:hidden;">
  <div id="page_layout">
    <div position="left" id="roleTree">
      <div id="query" style="margin: 5px 0px 5px 5px;">
        <input type="text" id="roleName" name="roleName">
        <button id="searchBtn" style="height:22px; margin-left:5px;">查询</button>
      </div>
      <div id="rolegrid"></div>
    </div>
    <div position="center" id="authorizeContent">
      <div id="authorizeTabs" style="overflow:hidden;">
        <div tabid="roleUser" title="角色人员" lselected="true"><div id="usergrid"></div></div>
        <div tabid="roleMenu" title="菜单权限"><div id="menugrid"></div></div>
      </div>
    </div>
  </div>
</body>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<script type="text/javascript" src="${ctp}/scripts/common/roleAuthorize.js"></script>
<script type="text/javascript">
	$(function() {
		roleAuthorize.initPage();
	});
</script>
</html>