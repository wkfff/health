<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/pages/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>内容管理系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/pages/common/baseFile.jsp"%>
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Aqua/css/ligerui-all.css" />
  <link rel="stylesheet" href="${ctp}/scripts/ligerUI/skins/Gray/css/all.css" />
  <!-- <link rel="stylesheet" href="${ctp}/styles/main/jquery-accordion-menu.css" /> -->
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="${ctp}/styles/common/tree-menu.css" />
  <link rel="stylesheet" href="${ctp}/styles/main/main.css" />
  <style type="text/css">
	#menu-list a{
		overflow:hidden;
		text-overflow:ellipsis;
		-o-text-overflow:ellipsis;
		white-space:nowrap;
		width:100%;
	}
  </style>
</head>

<body style="overflow:hidden;">
<div class="top">
	<div class="admin_logo">
		<img src="${ctp}/images/main/admin_logo.jpg">
	</div>
	<div class="top_member">
	欢迎您！Admin
	</div>
</div>
<div class="side_switch" id="side_switch"></div>
<div class="side_switchl" id="side_switchl"></div>
<div class="left">
	<div class="member_info">
		<div class="member_ico"><img src="${ctp}/images/main/a.png" width="43" height="43"></div>
		<a href="javascript:void(0);" class="system_a">账号管理</a>
		<a href="javascript:void(0);" class="system_log">注销</a>
		<a href="javascript:void(0);" class="system_logout" onclick="main.logout();">退出</a>
	</div>
	<div class="left_title">常用功能操作</div>
	<!-- 
	<div id="jquery-accordion-menu" class="jquery-accordion-menu red">
		<ul id="menu-list"></ul>
	</div>
	 -->
	<div id="accordion_menu" style="width:196px;">
	  <ul id="menu-list" class="accordion"></ul>
	</div>
	
</div>
<div id="main" class="right">
  <div tabid="home" title="首页" lselected="true"></div>
</div>
<form id="form1" name="form1" action=""></form>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/core/base.js"></script>
<script type="text/javascript" src="${ctp}/scripts/ligerUI/js/ligerui.min.js"></script>
<!-- <script type="text/javascript" src="${ctp}/scripts/main/jquery-accordion-menu.js"></script> -->
<script type="text/javascript" src="${ctp}/scripts/main/main.js"></script>
</body>
</html>